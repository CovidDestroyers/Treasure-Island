package com.treasureisland.island;

import com.treasureisland.SaveLoadGame;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.scene.Scene;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Island extends Scene implements Serializable {
  protected Island islandToTheNorth;
  protected Island islandToTheSouth;
  protected Island islandToTheEast;
  protected Island islandToTheWest;

  protected String islandName;

  protected Scene currentScene;
  protected List<Scene> scenesOnIsland = new ArrayList<>();
  protected String directionOptions =
      "Where would you like to go?\n "
          + "-Type \"N\": North\n "
          + "-Type \"S\": South\n "
          + "-Type \"W\": West\n "
          + "-Type \"E\": East\n "
          + "-Type \"Save\": Save Game\n "
          + "-Type \"Chart\": Game Chart\n "
          + "-Type \"Map\": Island Map\n";

  protected String directOptionsWithDocks =
      "Where would you like to go?\n "
          + "-Type \"N\": North\n "
          + "-Type \"S\": South\n "
          + "-Type \"W\": West\n "
          + "-Type \"E\": East\n "
          + "-Type \"D\": Docks\n "
          + "-Type \"Save\": Save Game\n "
          + "-Type \"Chart\": Game Chart\n "
          + "-Type \"Map\": Island Map\n";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Island() {}

  public Island(String islandName) {
    super(islandName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addScenesToIsland(Scene... scenes) {
    try {
      scenesOnIsland.addAll(Arrays.asList(scenes));
    } catch (Exception e) {
      System.out.println("Something broke :`(");
      e.printStackTrace();
    }
  }

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param player
   * @throws InterruptedException
   */
  public void enter(Player player) throws InterruptedException {}

  /**
   * @param direction
   * @return
   */
  public Island changeIsland(String direction) {
    String sanitizedDirection = direction.trim().toLowerCase().substring(0, 1);
    Island nextIsland = null;

    switch (sanitizedDirection) {
      case "n":
        nextIsland = getIslandToTheNorth();

        break;
      case "e":
        nextIsland = getIslandToTheEast();

        break;
      case "s":
        nextIsland = getIslandToTheSouth();

        break;
      case "w":
        nextIsland = getIslandToTheWest();

        break;
      default:
        System.out.println("Error: unknown direction " + direction);
        break;
    }

    if (nextIsland == null) {
      System.out.println("You cannot go " + direction + " from here.");
      nextIsland = this;
    }
    return nextIsland;
  }

  public void connectEast(Island otherIsland) {
    setIslandToTheEast(otherIsland);
    otherIsland.setIslandToTheWest(this);
  }

  public void connectSouth(Island otherIsland) {
    setIslandToTheSouth(otherIsland);
    otherIsland.setIslandToTheNorth(this);
  }

  public void saveGame() {
    SaveLoadGame.saveGame();
    System.out.println("We saved your game state!!");
    System.out.println(
        "But You cannot run forever my friend."
            + Color.ANSI_RED.getValue()
            + " Black Beard "
            + Color.ANSI_RESET.getValue()
            + "will find you!!!");
    System.out.println("Sleep well for it may be your last night.");
    System.out.println("Goodbye for now.");
    System.exit(0);
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  public Island getIslandToTheNorth() {
    return islandToTheNorth;
  }

  public void setIslandToTheNorth(Island islandToTheNorth) {
    this.islandToTheNorth = islandToTheNorth;
  }

  public Island getIslandToTheSouth() {
    return islandToTheSouth;
  }

  public void setIslandToTheSouth(Island islandToTheSouth) {
    this.islandToTheSouth = islandToTheSouth;
  }

  public Island getIslandToTheEast() {
    return islandToTheEast;
  }

  public void setIslandToTheEast(Island islandToTheEast) {
    this.islandToTheEast = islandToTheEast;
  }

  public Island getIslandToTheWest() {
    return islandToTheWest;
  }

  public void setIslandToTheWest(Island islandToTheWest) {
    this.islandToTheWest = islandToTheWest;
  }

  public String getIslandName() {
    return islandName;
  }

  public void setIslandName(String islandName) {
    this.islandName = islandName;
  }

  public String getDirectionOptions() {
    return directionOptions;
  }

  public void setDirectionOptions(String directionOptions) {
    this.directionOptions = directionOptions;
  }

  public Scene getCurrentScene() {
    return currentScene;
  }

  public void setCurrentScene(Scene currentScene) {
    this.currentScene = currentScene;
  }

  public List<Scene> getScenesOnIsland() {
    return scenesOnIsland;
  }

  public void setScenesOnIsland(List<Scene> scenesOnIsland) {
    this.scenesOnIsland = scenesOnIsland;
  }

  public String getDirectOptionsWithDocks() {
    return directOptionsWithDocks;
  }

  public void setDirectOptionsWithDocks(String directOptionsWithDocks) {
    this.directOptionsWithDocks = directOptionsWithDocks;
  }

  public void leavingIslandShipPrint() throws InterruptedException {
    System.out.println(
        " "
            + "               __|__ |___| |\\\n"
            + "                |o__| |___| | \\\n"
            + "                |___| |___| |o \\\n"
            + "               _|___| |___| |__o\\\n"
            + "              /...\\_____|___|____\\_/\n"
            + "              \\   o * o * * o o  /\n"
            + "            ~~~~~~~~~~~~~~~~~~~~~~~~~~");
    Thread.sleep(2000);
    System.out.println(System.lineSeparator().repeat(50));
    System.out.println(
        " "
            + "                                               __|__ |___| |\\\n"
            + "                                                |o__| |___| | \\\n"
            + "                                                |___| |___| |o \\\n"
            + "                                               _|___| |___| |__o\\\n"
            + "                                            /...\\_____|___|____\\_/\n"
            + "                                            \\   o * o * * o o  /\n"
            + "                                           ~~~~~~~~~~~~~~~~~~~~~~~~~~");
    Thread.sleep(2000);
    System.out.println(System.lineSeparator().repeat(50));
    System.out.println(
        " "
            + "                                                                               __|__ |___| |\\\n"
            + "                                                                                |o__| |___| | \\\n"
            + "                                                                                |___| |___| |o \\\n"
            + "                                                                               _|___| |___| |__o\\\n"
            + "                                                                            /...\\_____|___|____\\_/\n"
            + "                                                                            \\   o * o * * o o  /\n"
            + "                                                                            ~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
}
