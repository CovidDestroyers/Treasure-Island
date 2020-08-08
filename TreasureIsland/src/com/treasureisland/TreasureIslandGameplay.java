package com.treasureisland;

import com.treasureisland.island.IslaCruces;
import com.treasureisland.island.IslaDeMuerta;
import com.treasureisland.island.Island;
import com.treasureisland.island.PortRoyal;
import com.treasureisland.island.RumRunnerIsle;
import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.scene.Scene;
import com.treasureisland.ship.ShipBattleSequence;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreasureIslandGameplay implements Serializable {
  private final Island rumRunnerIsle;
  private final Island portRoyal;
  private final Island islaCruces;
  private final Island islaDeMuerta;
  private Island currentIsland;

  private final Player player;
  private final ShipBattleSequence shipBattleSequence = new ShipBattleSequence();
  private final transient Scanner scanner = OnlyOneScanner.getTheOneScanner();
  private String input;
  public static TreasureIslandGameplay treasureIslandGameplay;
  private final Map<String, Boolean> availablePirates = new HashMap<>();

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

    availablePirates.put("Crimson Beach Bar", true);
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

  public void start() throws InterruptedException {
    welcomeToTreasureIsland();
    currentIsland = rumRunnerIsle;
    customGameplayOptions();
    // currentIsland.enter(scanner, player);
    rumRunnerIsle();
  }

  public void customGameplayOptions() throws InterruptedException {
    File gameState = new File(System.getProperty("user.dir") + "/TreasureIsland.ser");
    if (gameState.exists()) {
      System.out.println(
          "Would you like to Load existing game<L>, play the full game<F>, or play on a sample island<S>?");
    } else {
      System.out.println("Would you like to play the full game<F>, or play on a sample island<S>?");
    }

    input = scanner.nextLine().trim().toLowerCase();
    switch (input) {
      case "l":
        treasureIslandGameplay = SaveLoadGame.loadGame();
        System.out.println("\nWelcome, " + treasureIslandGameplay.player.getPlayerName() + "\n \n");
        System.out.println(
            "Location: " + treasureIslandGameplay.player.getCurrentScene().getSceneName());
        System.out.println("Player Health: " + treasureIslandGameplay.player.getPlayerHealth());
        System.out.println("Player Coins: " + treasureIslandGameplay.player.getPlayerCoins());

        break;
      case "f":
        if (gameState.exists()) {
          gameState.delete();
        }
        chosePlayerName();
        break;
      case "s":
        if (gameState.exists()) {
          gameState.delete();
        }
        player.setPlayerName("Test Player");
        testIslandSelector();
        break;
      default:
        customGameplayOptions();
        break;
    }
  }

  // Player chooses name and is stored into playerName variable
  // calls first storyline txt file then puts player into rumDistillery()
  // ENtry point into
  public void chosePlayerName() throws InterruptedException {
    // welcomeToTreasureIsland();
    System.out.println("\nPlease enter your name: ");
    String input = scanner.nextLine();
    player.setPlayerName(input);

    String text =
        Color.ANSI_BLUE.getValue()
            + "\nAhoy "
            + Color.ANSI_GREEN.getValue()
            + player.getPlayerName()
            + Color.ANSI_BLUE.getValue()
            + "! "
            + " "
            + "Welcome to Treasure Island....well you are not there yet.  You need to find it first.\n"
            + "\n"
            + "I know you said you put this life behind you, but rumor has it "
            + Color.ANSI_RED.getValue()
            + "Black Beard "
            + Color.ANSI_BLUE.getValue()
            + "has a bounty on your head!!\n"
            + "Don't worry friend, I have a way to satisfy his bounty.....if you can survive his gang!!\n"
            + "\n"
            + "All you need to do is find the diamond.\n"
            + "\n"
            + "Playing this game is easy, talk to people around the Islands, Sail between the Islands and walk between\n"
            + "the places.\n"
            + "\n"
            + "The clues will lead you on your path.  If you ever get disorientated, type Map and it will clear your way.\n"
            + "\n"
            + "Your journey starts on Rum Runner Isle.  Good luck!"
            + Color.ANSI_RESET.getValue()
            + "\n"
            + "\n";
    int i;
    for (i = 0; i < text.length(); i++) {
      System.out.printf("%c", text.charAt(i));
      try {
        Thread.sleep(000); // 0.5s pause between characters
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }

    rumRunnerIsle();
  }

  // loop continues until they find the islands special item
  // allows user to chose N/S/E/W from IsleFactory
  // playerInteractionOptions allows for player to talk, look around, investigate or leave

  public void rumRunnerIsle() {
    try {
      player.processMovement("rumRunnerisle");
      System.out.println("Leaving Rum Runners Isle \n \n");
      leavingIslandShipPrint();
      Thread.sleep(5000);
      player.setHasIslandItem(false);
      shipBattleSequence.shipBattleAfterLeavingIsland(player, scanner);
      portRoyal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void portRoyal() throws InterruptedException {
    System.out.println("You made it to Port Royal");
    player.processMovement("portRoyal");
    if(player.playerTreasures.size() == 2){
      treasureIsland();
    }
//    System.out.println("Leaving Port Royal Isle \n \n");
//    leavingIslandShipPrint();
//    Thread.sleep(5000);
//    player.setHasIslandItem(false);
//    shipBattleSequence.shipBattleAfterLeavingIsland(player, scanner);
//    islaCruces();
  }

  public void islaCruces() throws InterruptedException {
    System.out.println("At Isla Cruces");
    player.processMovement("islaCruces");
    System.out.println("Leaving Isla Cruces \n \n");
    leavingIslandShipPrint();
    Thread.sleep(5000);
    player.setHasIslandItem(false);
    shipBattleSequence.shipBattleAfterLeavingIsland(player,scanner);

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

   public void treasureIsland() {
     if(Item.findByName(player.playerInventory,"Key") != null){
       if(player.playerTreasures.contains("Sacred Jewel")){
         System.out.println("What! I have been to this island before, there are people inhabiting this island!!\n" +
           "          How can treasure be on this island? It is supposed to be the biggest treasure in the world.\n" +
           "          This is confusing, I have to figure out a way to make some sense of this situation.\n" +
           "          Or else all this situation will be for nothing.\n" +
           "\n" +
           "\n" +
           "\n" +
           "          After revisiting the clues, I think I figured it out.\n" +
           "          I need to get to this hidden monastery and I will find more info there.\n" +
           "\n" +
           "          Talking with the monks there, I found out that they had a very sacred jewel stolen from them years back.\n" +
           "          Now that sounds interesting, the description they provided matched with the jewel I posses.\n" +
           "\n" +
           "          Should I give this jewel back to the monastery?\n" +
           "\n" +
           "          I gave the jewel to monastery and in return they provided me with a medium size box which had . . .\n" +
           "              Three keyholes in it!\n" +
           "              I took the box with me to open it privately.\n" +
           "              Upon opening it I found . . .\n" +
           "              Jewels, coins and the most treasured "  + Color.ANSI_BOLD.getValue() + Color.ANSI_BLUE.getValue() + "50 carat Diamond" + Color.ANSI_RESET.getValue() + "!");

         playAgain();
       }
       else {
         System.out.println(
           "To get the sacred jewel, you have to look around in \"Port Royal\"");
       }
     }
     else {
       System.out.println(
         "To get the key, you have to look around in \"Sugar Cane Field\" in \"Rum Runner Isle\"");
     }
   }

   //Method to ask for play again the game
   public void playAgain(){
     System.out.println("\nWould you like to play again?\n -Type \"Y\": Yes\n -Type \"N\": No");

     input = scanner.nextLine().trim().toLowerCase();

     if ("y".equals(input) || "yes".equals(input)) {
       try {
         new TreasureIslandGameplay().chosePlayerName();
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
     } else if ("n".equals(input) || "no".equals(input)) {
       System.out.println("Thank you for playing!!");
       System.exit(0);
     } else {
       System.out.println("Invalid Input, Try Again!!");
       playAgain();
     }
   }

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
            + Color.ANSI_GREEN.getValue()
            + "    $$$$$$$$                                                                               $$$$$$            $$                            $$\n"
            + "       $$                                                                                    $$              $$                            $$\n"
            + "       $$      $$$$$$    $$$$$$    $$$$$$    $$$$$$$   $$    $$   $$$$$$    $$$$$$           $$     $$$$$$$  $$   $$$$$$   $$$$$$$    $$$$$$$\n"
            + "       $$     $$    $$  $$    $$        $$  $$         $$    $$  $$    $$  $$    $$          $$    $$        $$        $$  $$    $$  $$    $$\n"
            + "       $$     $$        $$$$$$$$   $$$$$$$   $$$$$$    $$    $$  $$        $$$$$$$$          $$     $$$$$$   $$   $$$$$$$  $$    $$  $$    $$\n"
            + "       $$     $$        $$        $$    $$         $$  $$    $$  $$        $$                $$          $$  $$  $$    $$  $$    $$  $$    $$\n"
            + "       $$     $$         $$$$$$$   $$$$$$$  $$$$$$$     $$$$$$   $$         $$$$$$$        $$$$$$  $$$$$$$   $$   $$$$$$$  $$    $$   $$$$$$$\n"
            + "                                                                                                                                             \n"
            + "                                                                                                                                             \n"
            + "                                                                                                                                             \n"
            + Color.ANSI_RESET.getValue());
  }

  public Map<String, Boolean> getAvailablePirates() {
    return availablePirates;
  }

  public void setAvailablePirates(String key) {
    availablePirates.replace(key, false);
  }
}
