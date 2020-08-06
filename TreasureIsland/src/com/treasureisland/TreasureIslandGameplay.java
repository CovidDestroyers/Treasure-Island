package com.treasureisland;

import com.treasureisland.island.IslaCruces;
import com.treasureisland.island.IslaDeMuerta;
import com.treasureisland.island.Island;
import com.treasureisland.island.PortRoyal;
import com.treasureisland.island.RumRunnerIsle;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.ship.ShipBattleSequence;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class TreasureIslandGameplay implements Serializable {
  private final Island rumRunnerIsle;
  private final Island portRoyal;
  private final Island islaCruces;
  private final Island islaDeMuerta;

  private final Player player;
  private final ShipBattleSequence shipBattleSequence = ShipBattleSequence.getInstance();
  transient Scanner scanner = new Scanner(System.in);
  String input;
  public static TreasureIslandGameplay treasureIslandGameplay;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public TreasureIslandGameplay() {
    player = new Player();
    rumRunnerIsle = new RumRunnerIsle();
    portRoyal = new PortRoyal();
    islaCruces = new IslaCruces();
    islaDeMuerta = new IslaDeMuerta();

    rumRunnerIsle.connectEast(islaCruces);
    islaDeMuerta.connectEast(portRoyal);
    portRoyal.connectSouth(islaCruces);
    islaDeMuerta.connectSouth(rumRunnerIsle);
  }

  public static TreasureIslandGameplay getInstance() {
    if (treasureIslandGameplay == null) {
      treasureIslandGameplay = new TreasureIslandGameplay();
    }
    return treasureIslandGameplay;
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void start(Scanner in) throws InterruptedException {
    scanner = in;
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
      System.out.println("Location: " + treasureIslandGameplay.player.location.getSceneName());
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

  // Player chooses name and is stored into playerName variable
  // calls first storyline txt file then puts player into rumDistillery()
  // ENtry point into
  public void chosePlayerName() {
    welcomeToTreasureIsland();
    System.out.println("Please enter your name: ");
    String input = scanner.nextLine();
    player.setPlayerName(input);

    System.out.println("\nWelcome, " + player.getPlayerName() + "\n \n");

    System.out.println(
        "Ahoy matey!  \n" +
          "Welcome to Treasure Isalnd....well you are not there yet.  You need to find it.\n" +
          "I know you said you put this life behind you, but rumor has it Black Beard has a bounty on your head!!\n" +
          "Don't worry friend, I have a way to satisfy the bounty.....if you survive his gang!!\n" +
          "\n" +
          "All you need to do is find the diamond.\n" +
          "\n" +
          "Playing this game is easy, talk to people around the Islands, Sail between the Islands and walk between\n" +
          "the places.\n" +
          "\n" +
          "The clues will lead you on your path.  If you ever get disorientated, type Map and it will clear your way.\n" +
          "\n" +
          "Your journey starts on Rum Runner Isle at the Rum Distillery.  Good luck!");
    // storylineProgression("GameIntroText.txt", "", "start", "stop");
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
    // treasureIsland();
  }

  // public void treasureIsland() {
  //   TreasureIslandGameplay.getInstance().storylineProgression("TI.txt", "", "TIStart", "TIEnd");
  //   Scanner scanner = new Scanner(System.in);
  //
  //   System.out.println(" Press (e) to exit");
  //   String input = scanner.nextLine();
  //   if (input.equalsIgnoreCase("e")) {
  //     System.exit(0);
  //   }
  // }

  // HELPER METHODS BELLOW

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

  public void depart() {
    // TODO return to the main section of the island.
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
    // TODO ask for a new island
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

  public void welcomeToTreasureIsland() {

    System.out.println(
        "\n"
            + Color.ANSI_GREEN.getValue() +
          "    $$$$$$$$                                                                               $$$$$$            $$                            $$\n" +
          "       $$                                                                                    $$              $$                            $$\n" +
          "       $$      $$$$$$    $$$$$$    $$$$$$    $$$$$$$   $$    $$   $$$$$$    $$$$$$           $$     $$$$$$$  $$   $$$$$$   $$$$$$$    $$$$$$$\n" +
          "       $$     $$    $$  $$    $$        $$  $$         $$    $$  $$    $$  $$    $$          $$    $$        $$        $$  $$    $$  $$    $$\n" +
          "       $$     $$        $$$$$$$$   $$$$$$$   $$$$$$    $$    $$  $$        $$$$$$$$          $$     $$$$$$   $$   $$$$$$$  $$    $$  $$    $$\n" +
          "       $$     $$        $$        $$    $$         $$  $$    $$  $$        $$                $$          $$  $$  $$    $$  $$    $$  $$    $$\n" +
          "       $$     $$         $$$$$$$   $$$$$$$  $$$$$$$     $$$$$$   $$         $$$$$$$        $$$$$$  $$$$$$$   $$   $$$$$$$  $$    $$   $$$$$$$\n" +
          "                                                                                                                                             \n" +
          "                                                                                                                                             \n" +
          "                                                                                                                                             \n" + Color.ANSI_RESET.getValue());
  }
}
