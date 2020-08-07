package com.treasureisland.scene;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.player.Player;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Scene implements Serializable {
  protected Scanner scanner = OnlyOneScanner.getTheOneScanner();

  protected String storyFileName = "TI.txt";
  protected String sceneName;
  protected String storyStart;
  protected String storyEnd;

  protected Scene northScene;
  protected Scene southScene;
  protected Scene eastScene;
  protected Scene westScene;

  protected String interActionOptions =
      "\nWhat would you like to do?\n "
          + " -Type \"T\": Talk\n "
          + " -Type \"L\": Look Around\n "
          + " -Type \"I\": Investigate\n "
          + " -Type \"C\": See Clues\n "
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
    System.out.println(trimmedDirection);

    Scene nextScene = null;

    if ("n".equals(trimmedDirection)) {
      nextScene = northScene;

    } else if ("e".equals(trimmedDirection)) {
      nextScene = eastScene;

    } else if ("s".equals(trimmedDirection)) {
      nextScene = southScene;

    } else if ("w".equals(trimmedDirection)) {
      nextScene = westScene;

    } else {
      System.out.println("Error: unknown direction " + direction);
      System.out.println("Please try again...");
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
  public abstract void enter(Player player) throws InterruptedException;

  /**
   * Player talks to characters in this method
   * @param player
   */
  public abstract void talkToNPC(Player player);

  public abstract void lookAroundLocation(Player player) throws InterruptedException;

  public void investigateArea(Player player) throws InterruptedException {

  }

  public abstract void vendor(Player player);

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
