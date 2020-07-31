package com.treasureisland.player;

import com.treasureisland.IsleFactory;
import com.treasureisland.SaveLoadGame;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.items.Items;
import com.treasureisland.items.Vendor;
import com.treasureisland.world.Location;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player  implements java.io.Serializable{
  private static Player player;
  private final Vendor vendor = new Vendor();
  private final List<Items> vendorItems = vendor.getVendorItems();

  public ArrayList<String> playerClues = new ArrayList<>();
  public String[] clues = {
    "Go " + Color.ANSI_YELLOW.getValue() + "South" + Color.ANSI_RESET.getValue(),
    "Go North",
    "Go " + Color.ANSI_GREEN.getValue() + "West" + Color.ANSI_RESET.getValue(),
    "Go " + Color.ANSI_BLUE.getValue() + "East" + Color.ANSI_RESET.getValue()
  };

  public Location location;
  public Boolean haveIslandItem = false;
  String input;
  transient Scanner scanner = new Scanner(System.in);
  private String playerName;
  private Integer playerCoins = 0;
  private Integer playerHealth = 50;
  private SaveLoadGame saveLoadGame;
  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  private Player() {}

  public static Player getInstance() {
    if (player == null) {
      player = new Player();
    }

    return player;
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  // Helper methods below
  public void iterateThroughPlayerClues() {

    switch (player.location.getLocationName()) {
      case "Rum Distillery":
        System.out.println(
            "\napply wha' ye got"
                + Color.ANSI_YELLOW.getValue()
                + "\nClue#1 "
                + Color.ANSI_RESET.getValue()
                + clues[0]
                + "\n"
                + Color.ANSI_BLUE.getValue()
                + "Clue#2 "
                + Color.ANSI_RESET.getValue()
                + clues[3]);
        System.out.println(
            Color.ANSI_GREEN.getValue()
                + "Clue#3"
                + Color.ANSI_RESET.getValue()
                + " = "
                + Color.ANSI_YELLOW.getValue()
                + "Clue#1"
                + Color.ANSI_RESET.getValue()
                + " + "
                + Color.ANSI_BLUE.getValue()
                + "Clue#2"
                + Color.ANSI_RESET.getValue()
                + " .... "
                + "\n"
                + "\nwill reveal th' island t' kick off...");

        break;
      case "Crimson Beach Bar":
        System.out.println(
            Color.ANSI_YELLOW.getValue()
                + "Clue#1"
                + Color.ANSI_RESET.getValue()
                + " How's th' cabin number Jojo said t' look aft?");

        break;
      case "Abandoned distillery":
        System.out.println(
            Color.ANSI_BLUE.getValue()
                + "Clue#2"
                + Color.ANSI_RESET.getValue()
                + " How many Antique coins are thar?");

        break;
      case "Sugar cane field":
        System.out.println(
            Color.ANSI_RED.getValue()
                + "\nSecret Code: "
                + Color.ANSI_GREEN.getValue()
                + "Clue#3"
                + Color.ANSI_RESET.getValue()
                + " - lastOneDigitOff"
                + Color.ANSI_RESET.getValue());
        break;
      case "Tikki Lounge":
        System.out.println(
            Color.ANSI_RED.getValue()
                + "\nSecret Code: "
                + Color.ANSI_GREEN.getValue()
                + "What is the name of old and abandoned legendary ship you found in Ship Graveyard?"
                + Color.ANSI_RESET.getValue());
        break;
      case "Southend Beach":
        System.out.println(
            Color.ANSI_RED.getValue()
                + "\nSecret Code: "
                + Color.ANSI_GREEN.getValue()
                + "To get the lockpin you must surrender the item you stole in \"Church\""
                + Color.ANSI_RESET.getValue());
        break;
    }
  }

  public void coinManager(Integer coins) {
    if (coins.equals(0)) {
      System.out.println("Nothing was found CM");
    }
    if (coins > 0) {
      playerCoins += coins;
      System.out.println(
          "You found " + coins + " coins. You now have a total of " + getPlayerCoins() + " coins");
    }
    if (coins < 0) {
      playerCoins -= coins;
      System.out.println(
          "You spent " + coins + " gold. You now have a total of " + getPlayerCoins() + " coins.");
    }
  }

  public void playerVisitsVendor() {
    System.out.println("\nWelcome to my shop! Please browse my collection \n");
    vendor.getAll();
    System.out.println("\nWould you like to buy anything? y/n");
    input = scanner.nextLine();
    if ("y".equalsIgnoreCase(input)) {
      player.playerPurchase();
    }
    if ("n".equalsIgnoreCase(input)) {
      System.out.println("Bye");
    }
  }

  public void playerPurchase() {
    System.out.println("\nWhat would you like to buy?");
    input = scanner.nextLine();
    switch (input.toLowerCase()) {
      case "Banana":
      case "b":
        System.out.println("You bought a banana");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Banana").getHealthValue());
        player.itemManager(vendor.findByName("Banana").getCost());
        break;

      case "Apple":
      case "ap":
        System.out.println("bought apple");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Apple").getHealthValue());

        player.itemManager(vendor.findByName("Apple").getCost());
        break;

      case "Rum":
      case "r":
        System.out.println("bought rum");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Rum").getHealthValue());
        player.itemManager(vendor.findByName("Rum").getCost());
        break;

      case "Salted meat":
      case "sm":
        System.out.println("bought salted meat");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Salted meat").getHealthValue());

        player.itemManager(vendor.findByName("Salted meat").getCost());
        break;

      case "Sea biscuits":
      case "sb":
        System.out.println("bought sea biscuts");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Sea biscuits").getHealthValue());

        player.itemManager(vendor.findByName("Sea biscuits").getCost());
        break;

      case "Ale":
      case "al":
        System.out.println("Bought ale");
        player.setPlayerHealth(
            player.getPlayerHealth() + vendor.findByName("Ale").getHealthValue());
        player.itemManager(vendor.findByName("Ale").getCost());
        break;

      default:
        System.out.println("Invalid input");
        playerPurchase();
        break;
    }
  }

  public void itemManager(Integer coins) {
    if (getPlayerCoins() - coins < 0) {
      System.out.println("You can not afford this item");
    } else {
      setPlayerCoins(getPlayerCoins() - coins);
      System.out.println(
          "You spent " + coins + " gold. You now have " + getPlayerCoins() + " gold.");
      playerInfoConsoleOutput();
    }
  }

  public void playerCoinGenerator() {
    Random rand = new Random();
    int upperBoundofCoins = 51;
    int coins = rand.nextInt(upperBoundofCoins);
    if (coins < 0) {
      System.out.println("Nothing was found ");
      return;
    }
    coinManager(coins);
  }

  // DONE: figure out why this is throwing NPE. Do not get NPE on any other class that imports
  // TODO TreasureIslandGameScanner other than this one.
  public void playerHealthCheck() {
    if (player.getPlayerHealth() <= 0) {
      playerDeathArt();
      playerDeathOptions();
    }
  }

  public void playerDeathOptions() {
    System.out.println("Would you like to play again?? Yes<Y> or No<N>");
    input = scanner.nextLine();

    // DONE: NO IMPLEMENTATION YET FOR INVALID INPUT HANDLING
    if ("y".equalsIgnoreCase(input)) {
      TreasureIslandGameplay.getInstance().chosePlayerName();
    }
    else if ("n".equalsIgnoreCase(input)) {
      System.out.println("Thank you for playing");
      System.exit(0);
    }
    else {
      System.out.println("Invalid Input, Try Again!!");
      playerDeathOptions();
    }
  }

  public void processMovement(String islandDestination) {
    try {
      while (!player.haveIslandItem) {
        System.out.println(
            "Where would you like to go. N/S/E/W/SaveGame"); // Quit => SOUT("THANKS FOR PLAYING) =>
        // System.exit(0)
        String direction = scanner.nextLine();
        if ("savegame".equalsIgnoreCase(direction)) {
          SaveLoadGame.saveGame();
          System.exit(0);
        }
        player.location = IsleFactory.islandLocationFactory(direction, islandDestination);
        System.out.println("You are now at the " + player.location.getLocationName());
        playerInfoConsoleOutput();
        playerInteractionOptions(direction);
      }

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void playerInteractionOptions(String direction) throws IOException, InterruptedException {
      String input = "";
      playerHealthCheck();

      if ("w".equalsIgnoreCase(direction)) {
        System.out.println(
          "What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Vendor(v)/ Clues(c)/ Exit(e)");

      } else {
        System.out.println(
          "What actions would you like to make? Talk(t)/ Look(l)/ Investigate(i)/ Clues(c)/ Exit(e)");
      }

      input = scanner.nextLine().trim();
      System.out.println("\n\n\n");

      switch (input.toLowerCase()) {
        case "talk":
        case "t":
          playerInfoConsoleOutput();
          location.talkToNPC();
          playerInteractionOptions(direction);
          break;
        case "look":
        case "l":
          playerInfoConsoleOutput();
          location.lookAroundLocation();
          playerInteractionOptions(direction);
          break;
        case "investigate":
        case "i":
          playerInfoConsoleOutput();
          location.investigateArea();
          playerInteractionOptions(direction);
          break;
        case "clues":
        case "c":
          playerInfoConsoleOutput();
          iterateThroughPlayerClues();
          playerInteractionOptions(direction);
          break;
        case "vendor":
        case "v":
          playerInfoConsoleOutput();
          location.vendor();
          playerInteractionOptions(direction);
          break;
        // TODO try if statement to catch w direction for vendor.
        // if player.direction is w then add vendor option as well (v)
        case "exit":
        case "e":
          break;
        default:
          System.out.println("Invalid input, please try again.");
          playerInteractionOptions(input);
          break;
      }
  }

  public void playerDeathArt() {
    System.out.println(
        "\n"
            + Color.ANSI_RED.getValue()
            + "▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄ \n"
            + " ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌\n"
            + "  ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌\n"
            + "  ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌\n"
            + "  ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓ \n"
            + "   ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒ \n"
            + " ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒ \n"
            + " ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░ \n"
            + " ░ ░         ░ ░     ░           ░     ░     ░  ░   ░    \n"
            + " ░ ░                           ░                  ░      \n"
            + Color.ANSI_RESET.getValue());
  }

  public void playerInfoConsoleOutput() {
    System.out.println(
        "\n\n"
            + "-----------------------------------------------------------"
            + "\n"
            + "                 "
            + Color.ANSI_BLUE.getValue()
            + "Treasure Island"
            + Color.ANSI_RESET.getValue()
            + "                           "
            + "\n"
            + "     "
            + Color.ANSI_WHITE_BOLD.getValue()
            + "Player"
            + Color.ANSI_RESET.getValue()
            + ": "
            + player.getPlayerName()
            + "\n"
            + "     "
            + Color.ANSI_PURPLE.getValue()
            + "Health"
            + Color.ANSI_RESET.getValue()
            + ": "
            + +player.getPlayerHealth()
            + "\n"
            + "     "
            + Color.ANSI_GREEN.getValue()
            + "Current Location"
            + Color.ANSI_RESET.getValue()
            + ": "
            + location.getLocationName()
            + "\n"
            + "     "
            + Color.ANSI_YELLOW.getValue()
            + "Coins"
            + Color.ANSI_RESET.getValue()
            + ": "
            + player.getPlayerCoins()
            + "\n"
            + "                                                           "
            + "\n"
            + "___________________________________________________________");
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  // GET METHODS
  public Integer getPlayerHealth() {
    return this.playerHealth;
  }

  public void setPlayerHealth(Integer playerHealth) {
    this.playerHealth = playerHealth;
  }

  public Integer getPlayerCoins() {
    return this.playerCoins;
  }

  public void setPlayerCoins(int playerCoins) {
    this.playerCoins = playerCoins;
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  @Override
  public String toString() {
    return "Player{"
        + "player="
        + player
        + ", vendorItems="
        + vendorItems
        + ", playerClues="
        + playerClues
        + ", clues="
        + Arrays.toString(clues)
        + ", location="
        + location
        + ", haveIslandItem="
        + haveIslandItem
        + ", scanner="
        + scanner
        + ", input='"
        + input
        + '\''
        + ", playerName='"
        + playerName
        + '\''
        + ", playerCoins="
        + playerCoins
        + ", playerHealth="
        + playerHealth
        + ", saveLoadGame="
        + saveLoadGame
        + '}';
  }
}
