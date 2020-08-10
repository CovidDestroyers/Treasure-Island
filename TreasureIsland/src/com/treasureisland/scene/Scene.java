package com.treasureisland.scene;

import com.treasureisland.Interactions;
import com.treasureisland.OnlyOneScanner;
import com.treasureisland.OurLogger;
import com.treasureisland.map.MainMap;
import com.treasureisland.player.Player;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public abstract class Scene implements Serializable {
  protected transient Scanner scanner = OnlyOneScanner.getTheOneScanner();
  protected transient Logger logger = OurLogger.getLogger();

  protected Map<String, String> methods;

  protected String storyFileName = "TI.txt";
  protected String name;
  protected String storyStart;
  protected String storyEnd;

  protected Scene northScene;
  protected Scene southScene;
  protected Scene eastScene;
  protected Scene westScene;
  protected MainMap theMap = new MainMap();
  protected String interActionOptions =
      "\nWhat would you like to do?\n "
          + " -Type \"T\": Talk\n "
          + " -Type \"L\": Look Around\n "
          + " -Type \"R\": See Treasure Rewards\n "
          + " -Type \"M\": Look at the Map\n "
          + " -Type \"INV\": Inventory\n "
          + " -Type \"G\": Grab Item\n "
          + " -Type \"E\": Exit This Location\n ";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Scene() {}

  public Scene(String name) {
    setName(name);
    setMethods(buildMethodMap());
  }

  /*
   * =============================================
   * =========== Abstract Methods ================
   * =============================================
   */

  /**
   * These methods are used for custom gameplay in each Scene class
   *
   * @param player - Player object
   * @throws InterruptedException - from the global Scanner object OnlyOneScanner
   */
  public abstract void talkToNPC(Player player) throws InterruptedException;

  public abstract void lookAroundLocation(Player player) throws InterruptedException;

  public abstract void vendor(Player player);

  public void investigateArea(Player player) throws InterruptedException {}

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /**
   * Gets the correct Scene class based on direction
   * @param direction - user command given through the console
   *                  - Validated by DirectionEnum.isValid
   * @return a Scene class in the specified direction
   */
  public Scene changeScene(String direction) {
    String trimmedDirection = direction.trim().toLowerCase().substring(0, 1);

    Scene nextScene = null;

    switch (trimmedDirection) {
      case "n":
        nextScene = getNorthScene();

        break;
      case "e":
        nextScene = getEastScene();

        break;
      case "s":
        nextScene = getSouthScene();

        break;
      case "w":
        nextScene = getWestScene();
        break;

      default:
        System.out.println("Error: unknown direction " + direction);
        break;
    }

    if (nextScene == null) {
      nextScene = this;
      System.out.printf(
          "To the %s all you see is water. You're a lousy swimmer for a pirate so...\n", direction);
      System.out.printf("I'm taking you back to the %s\n\n", nextScene.getName());
    }

    return nextScene;
  }

  /**
   *
   *  @param otherScene - the Scene class to the East of the invoking Scene
   * class
   * */
  public void connectEast(Scene otherScene) {
    setEastScene(otherScene);
    otherScene.setWestScene(this);
  }

  /**
   *
   * @param otherScene - the Scene class to the South of the invoking Scene
   * class
   */
  public void connectSouth(Scene otherScene) {
    setSouthScene(otherScene);
    otherScene.setNorthScene(this);
  }

  /**
   * The entry point into all scene classes.
   *
   * @param player - Player object
   * @param islandName - String: name of an Island
   * @throws InterruptedException
   */
  public void enter(Player player, String islandName) throws InterruptedException {
    String userInput = "";
    Method aMethod;

    System.out.printf("Welcome to the %s!\n", getName());

    player.setCurrentScene(this);

    while (true) {
      try {
        player.playerHealthCheck();
        player.playerInfoConsoleOutput();

        displayInteractionOptions();

        userInput = scanner.nextLine().trim().toLowerCase();

        if (!userInput.equals("")) {
          userInput =
              (userInput.startsWith("i")) ? userInput.substring(0, 3) : userInput.substring(0, 1);
        }

        if (Interactions.isValid(userInput)) {
          if ("e".equals(userInput)) {
            System.out.printf("You have left %s\n", getName());
            break;
          } else if ("m".equals(userInput) || "map".equals(userInput)) {
            displayMap(islandName);
          } else {
            String aMethodName = getNameOfMethod(userInput);

            if(aMethodName != null) {
              if (isPlayerMethod(aMethodName)) {
                aMethod = Player.class.getMethod(aMethodName);
                aMethod.invoke(player);
              } else {
                aMethod = Scene.class.getMethod(aMethodName, Player.class);
                aMethod.invoke(this, player);
              }
            } else {
              System.out.println("Error: Invalid Input. Please try again.");
            }
          }
        } else {
          System.out.println("Error: Invalid Input. Please try again.");
        }

      } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
        System.out.println("Error: Invalid Input. Please try again.");
      }
    }
  }

  /**
   *
   * @param userInput - user typed commands from  console
   * @return a Method from Player or Scene based on the
   */
  public Method getRightMethod(String userInput) {
    String nameOfMethod = getNameOfMethod(userInput);
    Method rightMethod = null;

    try {
      rightMethod =
          (isPlayerMethod(nameOfMethod))
              ? Player.class.getMethod(nameOfMethod)
              : Scene.class.getMethod(nameOfMethod, Player.class);

    } catch (NoSuchMethodException e) {
      System.out.println("Error: Invalid Input. Please try again.");
    }
    return rightMethod;
  }

  /**
   * Gets the name of a method from the `methods` Map
   * @param userInput - user command from console
   * @return - String with name of method if found
   */
  public String getNameOfMethod(String userInput) {
    String userIn = userInput.substring(0, 1);

    String methodName = null;
    if (methods.containsKey(userIn)) {
      methodName = methods.get(userIn);
    }
    return methodName;
  }

  /**
   * Checks if a method is a Player method
   * @param aMethodName - name of a method
   * @return - Boolean
   */
  public Boolean isPlayerMethod(String aMethodName) {
    boolean playerMethod = false;
    if ("grabItemFromInventory".equals(aMethodName)
        || "printInventoryItems".equals(aMethodName)
        || "iterateThroughPlayerTreasureRewards".equals(aMethodName)) {
      playerMethod = true;
    }
    return playerMethod;
  }

  public Map<String, String> buildMethodMap() {
    Map<String, String> mapOfMethods = new HashMap<>();
    mapOfMethods.put("t", "talkToNPC");
    mapOfMethods.put("l", "lookAroundLocation");
    mapOfMethods.put("v", "vendor");
    mapOfMethods.put("e", "exit");
    mapOfMethods.put("g", "grabItemFromInventory");
    mapOfMethods.put("i", "printInventoryItems");
    mapOfMethods.put("r", "iterateThroughPlayerTreasureRewards");
    mapOfMethods.put("m", "displayMap");

    return mapOfMethods;
  }

  /**
   * Displays the Island Map
   *
   * @param islandName - the name of an Island
   */
  public void displayMap(String islandName) {
    if ("Rum Runner Isle".equalsIgnoreCase(islandName)) {
      theMap.rumRunner();
    } else if ("Port Royal".equalsIgnoreCase(islandName)) {
      theMap.portRoyal();
    } else if ("Isla Cruces".equalsIgnoreCase(islandName)) {
      theMap.islaCruces();
    } else if ("Isla De Muerta".equalsIgnoreCase(islandName)) {
      theMap.islaDeMuerta();
    } else {
      theMap.mainMap();
    }
  }

  /**
   * @param fileName - Name of file where story line is kept
   * @param start - start location of scene storyline
   * @param stop - stop location of scene storyline
   */
  public void storylineProgression(String fileName, String start, String stop) {
    try {
      File myObj =
          new File(
              System.getProperty("user.dir")
                  + "/TreasureIsland/src/com/treasureisland/text/"
                  + fileName);

      Scanner myReader = new Scanner(myObj);
      boolean tokenFound = false;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine().trim();

        if (data.equals(start)) {
          tokenFound = true;
        }

        if (data.equals(stop)) {
          tokenFound = false;
        }

        if ((tokenFound) && (!data.equals(start))) {
          System.out.println(data);
          Thread.sleep(0);
        }
      }

      myReader.close();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void displayInteractionOptions() {
    System.out.println(getInterActionOptions());
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  public Map<String, String> getMethods() {
    return methods;
  }

  public void setMethods(Map<String, String> methods) {
    this.methods = methods;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStoryFileName() {
    return storyFileName;
  }

  public void setStoryFileName(String storyFileName) {
    this.storyFileName = storyFileName;
  }

  public String getStoryStart() {
    return storyStart;
  }

  public void setStoryStart(String storyStart) {
    this.storyStart = storyStart;
  }

  public String getStoryEnd() {
    return storyEnd;
  }

  public void setStoryEnd(String storyEnd) {
    this.storyEnd = storyEnd;
  }

  public Scene getNorthScene() {
    return northScene;
  }

  public void setNorthScene(Scene northScene) {
    this.northScene = northScene;
  }

  public Scene getSouthScene() {
    return southScene;
  }

  public void setSouthScene(Scene southScene) {
    this.southScene = southScene;
  }

  public Scene getEastScene() {
    return eastScene;
  }

  public void setEastScene(Scene eastScene) {
    this.eastScene = eastScene;
  }

  public Scene getWestScene() {
    return westScene;
  }

  public void setWestScene(Scene westScene) {
    this.westScene = westScene;
  }

  public String getInterActionOptions() {
    return interActionOptions;
  }

  public void setInterActionOptions(String interActionOptions) {
    this.interActionOptions = interActionOptions;
  }

  public MainMap getTheMap() {
    return theMap;
  }

  public void setTheMap(MainMap theMap) {
    this.theMap = theMap;
  }


  @Override
  public String toString() {
    return "Scene{" +
      "scanner=" + scanner +
      ", storyFileName='" + storyFileName + '\'' +
      ", name='" + name + '\'' +
      ", storyStart='" + storyStart + '\'' +
      ", storyEnd='" + storyEnd + '\'' +
      ", northScene=" + northScene +
      ", southScene=" + southScene +
      ", eastScene=" + eastScene +
      ", westScene=" + westScene +
      ", theMap=" + theMap +
      ", interActionOptions='" + interActionOptions + '\'' +
      '}';
  }
}
