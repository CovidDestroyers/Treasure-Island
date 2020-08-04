package com.treasureisland;

import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.ship.ShipBattleSequence;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TreasureIslandGameplay implements java.io.Serializable {
  private final Player player = Player.getInstance();
  private final ShipBattleSequence shipBattleSequence = ShipBattleSequence.getInstance();
  transient Scanner scanner = new Scanner(System.in);
  String input;
  private static TreasureIslandGameplay treasureIslandGameplay = new TreasureIslandGameplay();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public TreasureIslandGameplay() {}

  public static TreasureIslandGameplay getInstance() {
    return treasureIslandGameplay;
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  // Player chooses name and is stored into playerName variable
  // calls first storyline txt file then puts player into rumDistillery()
  public void chosePlayerName() {
    welcomeToTreasureIsland();
    System.out.println("Please enter your name: ");
    String input = scanner.nextLine();
    player.setPlayerName(input);
    System.out.println("\nWelcome, " + player.getPlayerName() + "\n \n");
    storylineProgression("GameIntroText.txt", "", "start", "stop");
    rumRunnerIsle();
  }

  // loop continues until they find the islands special item
  // allows user to chose N/S/E/W from IsleFactory
  // playerInteractionOptions allows for player to talk, look around, investigate or leave

  public void rumRunnerIsle() {
    try {
      // process player movement and takes in current island as parameter so factory knows where to
      // delegate
      player.processMovement("rumRunnerisle");
      System.out.println("Leaving Rum Runners Isle \n \n");
      leavingIslandShipPrint();
      Thread.sleep(5000);
      player.haveIslandItem = false;
      ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();
      portRoyal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void portRoyal() throws InterruptedException {
    System.out.println("You made it to Port Royal");
    player.processMovement("portRoyal");
    System.out.println("Leaving Port Royal Isle \n \n");
    leavingIslandShipPrint();
    Thread.sleep(5000);
    player.haveIslandItem = false;
    ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();
    islaCruces();
  }

  public void islaCruces() throws InterruptedException {
    System.out.println("At Isla Cruces");
    player.processMovement("islaCruces");
    System.out.println("Leaving Isla Cruces \n \n");
    leavingIslandShipPrint();
    Thread.sleep(5000);
    player.haveIslandItem = false;
    ShipBattleSequence.getInstance().shipBattleafterLeavingIsland();

    islaDeMuerta();
  }

  public void islaDeMuerta() throws InterruptedException {
    System.out.println("At Isla de Muerta");
    player.processMovement("islademuerta");
    System.out.println("Leaving Isla De Muerta \n \n");
    leavingIslandShipPrint();
    Thread.sleep(5000);
    treasureIsland();
  }

  public void treasureIsland() {
    TreasureIslandGameplay.getInstance().storylineProgression("TI.txt", "", "TIStart", "TIEnd");
    Scanner scanner = new Scanner(System.in);
    //        System.out.println(" Would you like to check your clues/Information  Yes(y)   No(o)
    // \n");
    System.out.println(" Press (e) to exit");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("e")) {
      System.exit(0);
    }
  }

  // HELPER METHODS BELLOW

  public void storylineProgression(String fileName, String location, String start, String stop) {
    try {
      File myObj =
        new File(
          System.getProperty("user.dir")
            + "/TreasureIsland/src/com/treasureisland/text/"
            + fileName);
      System.out.println(location);
      Scanner myReader = new Scanner(myObj);
      boolean tokenFound = false;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine().trim();
        if (data.equals(start)) {

          tokenFound = true;
        } else if (data.equals(stop)) {
          tokenFound = false;
        }

        if ((tokenFound) && (!data.equals(start))) {

          System.out.println(data);
          Thread.sleep(1000);
        }
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void welcomeToTreasureIsland() {

    System.out.println(
      "\n"
        + Color.ANSI_BLUE.getValue()
        + " █     █░▓█████  ██▓     ▄████▄   ▒█████   ███▄ ▄███▓▓█████    ▄▄▄█████▓ ▒█████     ▄▄▄█████▓ ██▀███  ▓█████ ▄▄▄        ██████  █    ██  ██▀███  ▓█████     ██▓  ██████  ██▓    ▄▄▄       ███▄    █ ▓█████▄ \n"
        + "▓█░ █ ░█░▓█   ▀ ▓██▒    ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓█   ▀    ▓  ██▒ ▓▒▒██▒  ██▒   ▓  ██▒ ▓▒▓██ ▒ ██▒▓█   ▀▒████▄    ▒██    ▒  ██  ▓██▒▓██ ▒ ██▒▓█   ▀    ▓██▒▒██    ▒ ▓██▒   ▒████▄     ██ ▀█   █ ▒██▀ ██▌\n"
        + "▒█░ █ ░█ ▒███   ▒██░    ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▒███      ▒ ▓██░ ▒░▒██░  ██▒   ▒ ▓██░ ▒░▓██ ░▄█ ▒▒███  ▒██  ▀█▄  ░ ▓██▄   ▓██  ▒██░▓██ ░▄█ ▒▒███      ▒██▒░ ▓██▄   ▒██░   ▒██  ▀█▄  ▓██  ▀█ ██▒░██   █▌\n"
        + "░█░ █ ░█ ▒▓█  ▄ ▒██░    ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒▓█  ▄    ░ ▓██▓ ░ ▒██   ██░   ░ ▓██▓ ░ ▒██▀▀█▄  ▒▓█  ▄░██▄▄▄▄██   ▒   ██▒▓▓█  ░██░▒██▀▀█▄  ▒▓█  ▄    ░██░  ▒   ██▒▒██░   ░██▄▄▄▄██ ▓██▒  ▐▌██▒░▓█▄   ▌\n"
        + "░░██▒██▓ ░▒████▒░██████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒░▒████▒     ▒██▒ ░ ░ ████▓▒░     ▒██▒ ░ ░██▓ ▒██▒░▒████▒▓█   ▓██▒▒██████▒▒▒▒█████▓ ░██▓ ▒██▒░▒████▒   ░██░▒██████▒▒░██████▒▓█   ▓██▒▒██░   ▓██░░▒████▓ \n"
        + "░ ▓░▒ ▒  ░░ ▒░ ░░ ▒░▓  ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░░ ▒░ ░     ▒ ░░   ░ ▒░▒░▒░      ▒ ░░   ░ ▒▓ ░▒▓░░░ ▒░ ░▒▒   ▓▒█░▒ ▒▓▒ ▒ ░░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░░ ▒░ ░   ░▓  ▒ ▒▓▒ ▒ ░░ ▒░▓  ░▒▒   ▓▒█░░ ▒░   ▒ ▒  ▒▒▓  ▒ \n"
        + "  ▒ ░ ░   ░ ░  ░░ ░ ▒  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░ ░ ░  ░       ░      ░ ▒ ▒░        ░      ░▒ ░ ▒░ ░ ░  ░ ▒   ▒▒ ░░ ░▒  ░ ░░░▒░ ░ ░   ░▒ ░ ▒░ ░ ░  ░    ▒ ░░ ░▒  ░ ░░ ░ ▒  ░ ▒   ▒▒ ░░ ░░   ░ ▒░ ░ ▒  ▒ \n"
        + "  ░   ░     ░     ░ ░   ░        ░ ░ ░ ▒  ░      ░      ░        ░      ░ ░ ░ ▒       ░        ░░   ░    ░    ░   ▒   ░  ░  ░   ░░░ ░ ░   ░░   ░    ░       ▒ ░░  ░  ░    ░ ░    ░   ▒      ░   ░ ░  ░ ░  ░ \n"
        + "    ░       ░  ░    ░  ░░ ░          ░ ░         ░      ░  ░                ░ ░                 ░        ░  ░     ░  ░      ░     ░        ░        ░  ░    ░        ░      ░  ░     ░  ░         ░    ░    \n"
        + "                        ░                                                                                                                                                                            ░      \n"
        + Color.ANSI_RESET.getValue());
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

  public void customGameplayOptions() throws InterruptedException {
    File gameState = new File(System.getProperty("user.dir") + "/TreasureIsland.ser");
    if (gameState.exists()) {
      System.out.println(
        "Would you like to Load existing game<L>, play the full game<F>, or play on a sample island<S>?");
    } else {
      System.out.println("Would you like to play the full game<F>, or play on a sample island<S>?");
    }

    input = scanner.nextLine();
    if ("l".equalsIgnoreCase(input)) {
      treasureIslandGameplay = SaveLoadGame.loadGame();
      System.out.println("\nWelcome, " + treasureIslandGameplay.player.getPlayerName() + "\n \n");
      System.out.println("Location: " + treasureIslandGameplay.player.location.getLocationName());
      System.out.println("Player Health: " + treasureIslandGameplay.player.getPlayerHealth());
      System.out.println("Player Coins: " + treasureIslandGameplay.player.getPlayerCoins());

      rumRunnerIsle();
    } else if ("f".equalsIgnoreCase(input)) {
      if (gameState.exists()) {
        gameState.delete();
      }
      chosePlayerName();
    } else if ("s".equalsIgnoreCase(input)) {
      if (gameState.exists()) {
        gameState.delete();
      }
      player.setPlayerName("Test Player");
      testIslandSelector();
    } else {
      customGameplayOptions();
    }
  }

  public void depart(){
    //TODO return to the main section of the island.
    System.out.println("Good Bye!  Please come again!!");
    System.out.println("Type in either: North, South, East or West.");
    input = scanner.nextLine();
    switch (input) {
      case "North":
      case "n":
        break;
      case "South":
      case "s":
        break;
      case "East":
      case "e":
        break;
      case "West":
      case "w":
        break;
      default:
        System.out.println("Invalid input, please try again. ");
        depart();
    }
  }

  public void sail() throws InterruptedException {
    //TODO ask for a new island
    System.out.println("Hello Captain. Please pick a direction to set sail! ");
    System.out.println("Type in either: North, South, East, West or Not Ready??");
    switch (input.toLowerCase()) {
      case "Not Ready":
      case "nr":
        break;
      case "North":
      case "n":
        leavingIslandShipPrint();
        break;
      case "south":
      case "s":
        leavingIslandShipPrint();
        break;
      case "east":
      case "e":
        if(location.equals(rumRunnerIsle())) {

        }
        leavingIslandShipPrint();
        break;
      case "west":
      case "w":
        leavingIslandShipPrint();
        break;
      default:
        System.out.println("Invalid input, please try again. ");
        sail();
        break;
    }
  }

  public void testIslandSelector() throws InterruptedException {
    System.out.println(
      "Which island would you like to play?\n"
        + "1) Rum Runner Isle \n"
        + "2) Port Royal \n"
        + "3) Isla Cruces \n"
        + "4) Isla de Muerta \n"
        + "5) Back to main");
    input = scanner.nextLine();
    if ("1".equals(input)) {
      rumRunnerIsle();
    }
    if ("2".equals(input)) {
      portRoyal();
    }
    if ("3".equals(input)) {
      islaCruces();
    }
    if ("4".equals(input)) {
      islaDeMuerta();
    }
    if ("5".equals(input)) {
      customGameplayOptions();
    } else {
      testIslandSelector();
    }
  }
}