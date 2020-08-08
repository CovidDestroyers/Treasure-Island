package com.treasureisland.scene;

import com.treasureisland.Interactions;
import com.treasureisland.OnlyOneScanner;
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

public abstract class Scene implements Serializable {
  protected transient Scanner scanner = OnlyOneScanner.getTheOneScanner();

  protected String storyFileName = "TI.txt";
  protected String sceneName;
  protected String storyStart;
  protected String storyEnd;

  protected Scene northScene;
  protected Scene southScene;
  protected Scene eastScene;
  protected Scene westScene;

  public MainMap getTheMap() {
    return theMap;
  }

  public void setTheMap(MainMap theMap) {
    this.theMap = theMap;
  }

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
  public Scene(String sceneName) {
    setSceneName(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /**
   * @param direction
   * @return
   */
  public Scene changeScene(String direction) {
    String trimmedDirection = direction.trim().toLowerCase().substring(0, 1);

    Scene nextScene = null;

    switch (trimmedDirection) {
      case "n":
        nextScene = northScene;

        break;
      case "e":
        nextScene = eastScene;

        break;
      case "s":
        nextScene = southScene;

        break;
      case "w":
        nextScene = westScene;
        break;
    }

    if (nextScene == null) {
      System.out.println("You cannot go " + direction + " from here.");
      nextScene = this;
    }

    return nextScene;
  }

  public void connectEast(Scene otherScene) {
    setEastScene(otherScene);
    otherScene.setWestScene(this);
  }

  public void connectSouth(Scene otherScene) {
    setSouthScene(otherScene);
    otherScene.setNorthScene(otherScene);
  }

  /**
   * The entry point into all scene classes.
   *
   * @param player
   * @throws InterruptedException
   */
  public void enter(Player player, String islandName) throws InterruptedException {
    System.out.printf("You are in the %s!", getSceneName());
    String userInput = "";
    Method aMethod;

    player.setCurrentScene(this);

    while (true) {
      try {
        player.playerInfoConsoleOutput();
        displayInteractionOptions();

        userInput = scanner.nextLine().trim().toLowerCase();

        if (!userInput.equals("")) {
          if (userInput.startsWith("i")) {
            userInput = userInput.substring(0, 3);
          } else {
            userInput = userInput.substring(0, 1);
          }
        }

        if (Interactions.isValid(userInput)) {
          if ("e".equals(userInput)) {
            break;
          } else if ("m".equals(userInput)) {
            displayIslandMap(islandName);
          } else {
            String aMethodName = getNameOfMethod(userInput);

            if (isPlayerMethod(aMethodName)) {
              aMethod = Player.class.getMethod(aMethodName);
              aMethod.invoke(player);
            } else {
              aMethod = Scene.class.getMethod(aMethodName, Player.class);
              aMethod.invoke(this, player);
            }
          }

        } else {
          System.out.println("Error: Invalid Input. Please try again.");
        }

      } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
  }

  public Method getRightMethod(String userInput) {
    String nameOfMethod = getNameOfMethod(userInput);
    Method rightMethod = null;

    try {

      if (isPlayerMethod(nameOfMethod)) {
        rightMethod = Player.class.getMethod(nameOfMethod);
      } else {
        rightMethod = Scene.class.getMethod(nameOfMethod, Player.class);
      }

    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    return rightMethod;
  }

  public String getNameOfMethod(String userInput) {
    Map<String, String> methods = new HashMap<>();
    methods.put("t", "talkToNPC");
    methods.put("l", "lookAroundLocation");
    methods.put("v", "vendor");
    methods.put("e", "exit");
    methods.put("g", "grabItemFromInventory");
    methods.put("i", "printInventoryItems");
    methods.put("r", "iterateThroughPlayerTreasureRewards");
    methods.put("m", "displayIslandMap");

    String userIn = userInput.substring(0, 1);

    String methodName = null;
    if (methods.containsKey(userIn)) {
      methodName = methods.get(userIn);
    }
    return methodName;
  }

  public Boolean isPlayerMethod(String aMethodName) {
    boolean playerMethod = false;
    if ("grabItemFromInventory".equals(aMethodName)
        || "printInventoryItems".equals(aMethodName)
        || "iterateThroughPlayerTreasureRewards".equals(aMethodName)) {
      playerMethod = true;
    }
    return playerMethod;
  }

  /**
   * Player talks to characters in this method
   * @param player
   */
  public abstract void talkToNPC(Player player) throws InterruptedException;

  public abstract void lookAroundLocation(Player player) throws InterruptedException;

  public void investigateArea(Player player) throws InterruptedException {

  }

  public abstract void vendor(Player player);

  public void displayIslandMap(String islandName) {
    if ("rumRunnerisle".equalsIgnoreCase(islandName)) {
      theMap.rumRunner();
    } else if ("portRoyal".equalsIgnoreCase(islandName)) {
      theMap.portRoyal();
    } else if ("islaCruces".equalsIgnoreCase(islandName)) {
      theMap.islaCruces();
    } else if ("islademuerta".equalsIgnoreCase(islandName)) {
      theMap.islaDeMuerta();
    } else {
      theMap.mainMap();
    }
  }
  /**
   * @param fileName
   * @param start
   * @param stop
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
          Thread.sleep(650);
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

  // GET METHODS
  public String getSceneName() {
    return sceneName;
  }

  public String getStoryFileName() {
    return storyFileName;
  }

  public String getStoryStart() {
    return storyStart;
  }

  public String getStoryEnd() {
    return storyEnd;
  }

  public Scene getNorthScene() {
    return northScene;
  }

  public Scene getSouthScene() {
    return southScene;
  }

  public Scene getEastScene() {
    return eastScene;
  }

  public Scene getWestScene() {
    return westScene;
  }

  public String getInterActionOptions() {
    return interActionOptions;
  }

  // SET METHODS
  public void setWestScene(Scene westScene) {
    this.westScene = westScene;
  }

  public void setStoryStart(String storyStart) {
    this.storyStart = storyStart;
  }

  public void setStoryEnd(String storyEnd) {
    this.storyEnd = storyEnd;
  }

  public void setNorthScene(Scene northScene) {
    this.northScene = northScene;
  }

  public void setSouthScene(Scene southScene) {
    this.southScene = southScene;
  }

  public void setEastScene(Scene eastScene) {
    this.eastScene = eastScene;
  }

  public void setStoryFileName(String storyFileName) {
    this.storyFileName = storyFileName;
  }

  public void setSceneName(String sceneName) {
    this.sceneName = sceneName;
  }

  public void setInterActionOptions(String interActionOptions) {
    this.interActionOptions = interActionOptions;
  }
}
