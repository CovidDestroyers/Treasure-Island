package com.treasureisland.island;

import com.treasureisland.SaveLoadGame;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.items.Item;
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
  protected String whereToGo;
  protected String directionOptions;
  protected String directOptionsWithDocks;

  protected Scene currentScene;

  protected List<Scene> scenesOnIsland = new ArrayList<>();
  protected static TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Island() {
    setDirectionOptions(
      "Where would you like to go?\n "
        + "-Type \"N\": North\n "
        + "-Type \"S\": South\n "
        + "-Type \"W\": West\n "
        + "-Type \"E\": East\n "
        + "-Type \"Save\": Save Game\n "
        + "-Type \"Chart\": Game Chart\n "
        + "-Type \"Map\": Island Map\n");
    setDirectOptionsWithDocks(
      "Where would you like to go?\n "
        + "-Type \"N\": North\n "
        + "-Type \"S\": South\n "
        + "-Type \"W\": West\n "
        + "-Type \"E\": East\n "
        + "-Type \"D\": Docks\n "
        + "-Type \"Save\": Save Game\n "
        + "-Type \"Chart\": Game Chart\n "
        + "-Type \"Map\": Island Map\n");

    setWhereToGo(getDirectionOptions());
  }

  public Island(String islandName) {
    this();
    setIslandName(islandName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /**
   * The entry point into all scene classes. The TreasureIslandGamePlay class
   * will call `Island.enter( player);`to start each Island's story
   *
   * @param player - Player object
   */
  public void enter(Player player) {
    String userInput;

    try {
      displayWelcomeMessage();

      while (true) {
        player.playerHealthCheck();

        if (player.playerTreasures.size() == 2) {
          treasureIsland(player);
        }

        setWhereToGo((player.getHasIslandItem()) ? getDirectOptionsWithDocks() : getDirectionOptions());

        System.out.println(getWhereToGo());

        userInput = scanner.nextLine().trim().toLowerCase();

        Boolean isDocks = ("d".equals(userInput) || "docks".equals(userInput));

        if (isDocks && player.getHasIslandItem()) {
          break;
        }

        if ("save".equals(userInput)) {
          saveGame();

        }
        else if ("chart".equals(userInput) || "c".equals(userInput)) {
          displayMap("main");

        }
        else if ("map".equals(userInput) || "m".equals(userInput)) {
          displayMap(getIslandName());

        }
        else if (DirectionEnum.isValid(userInput)) {
          currentScene = currentScene.changeScene(userInput);

          if (currentScene == null) {
            System.out.println("Please try again...\n");

          }
          else {
            player.setCurrentScene(currentScene);
            currentScene.enter(player, getIslandName());
          }

        }
        else {
          System.out.println("Error: unknown direction " + userInput);
          System.out.println("Please try again...\n");
        }
      }
    }
    catch (InterruptedException e) {
      System.out.println("Oops! Please try again...\n");
      System.out.println(directionOptions);
    }
  }

  /**
   * Gets the correct Island class based on direction
   *
   * @param direction - user command given through the console - Validated by
   * DirectionEnum.isValid
   * @return an Island class in the specified direction
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

  /**
   * @param otherIsland - the Island to the East of invoking Island class
   */
  public void connectEast(Island otherIsland) {
    setIslandToTheEast(otherIsland);
    otherIsland.setIslandToTheWest(this);
  }

  /**
   * @param otherIsland - the Island to the South of invoking Island class
   */
  public void connectSouth(Island otherIsland) {
    setIslandToTheSouth(otherIsland);
    otherIsland.setIslandToTheNorth(this);
  }

  /**
   * Saves current state of game and exits
   */
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


  /**
   * Adds an arbitrary number of Scene classes to an Island class
   *
   * @param scenes - the Scene classes on the island
   */
  public void addScenesToIsland(Scene... scenes) {
    try {
      scenesOnIsland.addAll(Arrays.asList(scenes));
    }
    catch (Exception e) {
      System.out.println("Something broke :`(");
      e.printStackTrace();
    }
  }


  protected void displayWelcomeMessage() {
    System.out.printf("You have arrived at %s. Enjoy your stay...\n",
      getIslandName());
  }

  //
  private void treasureIsland(Player player) {
    if (Item.findByName(player.playerInventory, "key") != null) {
      if (player.playerTreasures.contains("Sacred Jewel")) {
        displayTreasureIslandStory();
        System.exit(0);
      } else {
        System.out.println("To get the sacred jewel, you have to look around in \"Port Royal\"");
      }
    } else {
      System.out.println(
        "To get the key, you have to look in the \"Sugar Cane "
          + "Field\" in \"Rum Runner Isle\"");
    }
  }

  //Method to display TreasureIsland Story when Player wins
  public void displayTreasureIslandStory() {
    System.out.println(
      "\n\nWhat! I have been to this island before, there are people inhabiting this island!!\n"
        + "          How can treasure be on this island? It is supposed to be the biggest treasure in the world.\n"
        + "          This is confusing, I have to figure out a way to make some sense of this situation.\n"
        + "          Or else all this situation will be for nothing.\n"
        + "\n"
        + "\n"
        + "\n"
        + "          After revisiting the clues, I think I figured it out.\n"
        + "          I need to get to this hidden monastery and I will find more info there.\n"
        + "\n"
        + "          Talking with the monks there, I found out that they had a very sacred jewel stolen from them years back.\n"
        + "          Now that sounds interesting, the description they provided matched with the jewel I posses.\n"
        + "\n"
        + "          Should I give this jewel back to the monastery?\n"
        + "\n"
        + "          I gave the jewel to monastery and in return they provided me with a medium size box which had . . .\n"
        + "              Three keyholes in it!\n"
        + "              I took the box with me to open it privately.\n"
        + "              Upon opening it I found . . .\n"
        + "              Jewels, coins and the most treasured "
        + Color.ANSI_BOLD.getValue()
        + Color.ANSI_BLUE.getValue()
        + "50 carat Diamond"
        + Color.ANSI_RESET.getValue()
        + "!");
  }



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  public String getWhereToGo() {
    return whereToGo;
  }

  public void setWhereToGo(String whereToGo) {
    this.whereToGo = whereToGo;
  }

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
        + "                                            /.."
        + ".\\_____|___|____\\_/\n"
        + "                                            \\   o * o * * o o  /\n"
        + "                                           "
        + "~~~~~~~~~~~~~~~~~~~~~~~~~~");
    Thread.sleep(2000);
    System.out.println(System.lineSeparator().repeat(50));
    System.out.println(
      " "
        + "                                                                  "
        + "             __|__ |___| |\\\n"
        + "                                                                  "
        + "              |o__| |___| | \\\n"
        + "                                                                  "
        + "              |___| |___| |o \\\n"
        + "                                                                  "
        + "             _|___| |___| |__o\\\n"
        + "                                                                  "
        + "          /...\\_____|___|____\\_/\n"
        + "                                                                  "
        + "          \\   o * o * * o o  /\n"
        + "                                                                  "
        + "          ~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }

  @Override
  public String toString() {
    return "Island{"
      + "islandToTheNorth="
      + islandToTheNorth
      + ", islandToTheSouth="
      + islandToTheSouth
      + ", islandToTheEast="
      + islandToTheEast
      + ", islandToTheWest="
      + islandToTheWest
      + ", islandName='"
      + islandName
      + '\''
      + ", currentScene="
      + currentScene
      + ", scenesOnIsland="
      + scenesOnIsland
      + ", directionOptions='"
      + directionOptions
      + '\''
      + ", directOptionsWithDocks='"
      + directOptionsWithDocks
      + '\''
      + "} "
      + super.toString();
  }
}
