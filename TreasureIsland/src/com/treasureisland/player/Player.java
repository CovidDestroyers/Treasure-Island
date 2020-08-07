package com.treasureisland.player;

import com.treasureisland.island.IsleFactory;
import com.treasureisland.OnlyOneScanner;
import com.treasureisland.SaveLoadGame;
import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.island.Island;
import com.treasureisland.items.Item;
import com.treasureisland.items.Vendor;
import com.treasureisland.map.MainMap;
import com.treasureisland.scene.Scene;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player implements Serializable {

  private final Vendor vendor = new Vendor();
  private final List<Item> vendorItems = vendor.getVendorItems();

  public ArrayList<String> playerClues = new ArrayList<>();
  public String[] clues = {
    "Go " + Color.ANSI_YELLOW.getValue() + "South" + Color.ANSI_RESET.getValue(),
    "Go North",
    "Go " + Color.ANSI_GREEN.getValue() + "West" + Color.ANSI_RESET.getValue(),
    "Go " + Color.ANSI_BLUE.getValue() + "East" + Color.ANSI_RESET.getValue()
  };

  private String playerName;

  private Scene currentScene;
  private Island currentIsland;

  private Boolean hasIslandItem = false;
  private Integer playerCoins = 10;
  private Integer playerHealth = 75;
  private Integer playerAttackStrength = new Random().nextInt(75);
  private SaveLoadGame saveLoadGame;

  private String input;
  private transient Scanner scanner = OnlyOneScanner.getTheOneScanner();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Player() {}

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void iterateThroughPlayerClues() {

    switch (this.currentScene.getSceneName()) {
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
                + "What is the name of the old and abandoned legendary ship you found in Ship Graveyard?"
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

  /**
   * Adds or substracts coins from the Player's coins
   *
   * @param coins -> Integer
   */
  public void coinManager(Integer coins) {
    if (coins.equals(0)) {
      System.out.println("Nothing was found!");
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

  /** Player visits the Vendor All Items from the Vendor are printed out */
  public void playerVisitsVendor() {
    vendor.vendorIntroduction();

    input = scanner.nextLine();

    if ("y".equalsIgnoreCase(input)) {
      this.playerPurchase();
    }
    if ("n".equalsIgnoreCase(input)) {
      System.out.println("Bye");
    }
  }

  // TODO: Put this in Vendor class
  public void playerPurchase() {
    System.out.println("\nWhat would you like to buy?");
    input = scanner.nextLine().trim();
    switch (input.toLowerCase()) {
      case "banana":
      case "b":
        System.out.println("You bought a banana");
        this.setPlayerHealth(this.getPlayerHealth() + vendor.findByName("banana").getHealthValue());
        this.itemManager(vendor.findByName("banana").getCost());
        break;

      case "apple":
      case "ap":
        Item anApple = vendor.findByName("apple");
        System.out.println("bought apple");
        this.setPlayerHealth(this.getPlayerHealth() + anApple.getHealthValue());

        this.itemManager(anApple.getCost());
        break;

      case "rum":
      case "r":
        System.out.println("bought rum");
        this.setPlayerHealth(this.getPlayerHealth() + vendor.findByName("rum").getHealthValue());
        this.itemManager(vendor.findByName("rum").getCost());
        break;

      case "salted meat":
      case "sm":
        this.setPlayerHealth(
            this.getPlayerHealth() + vendor.findByName("salted meat").getHealthValue());
        this.itemManager(vendor.findByName("salted meat").getCost());

        System.out.println("You bought some salted meat! Would you like some ale to wash it down?");
        break;

      case "sea biscuits":
      case "sb":
        this.setPlayerHealth(
            this.getPlayerHealth() + vendor.findByName("sea biscuits").getHealthValue());
        this.itemManager(vendor.findByName("sea biscuits").getCost());

        System.out.println("You bought a delicious sea biscut!");
        break;

      case "ale":
      case "al":
        this.setPlayerHealth(this.getPlayerHealth() + vendor.findByName("ale").getHealthValue());
        this.itemManager(vendor.findByName("ale").getCost());

        System.out.println("You bought some ale! Don't sail and drink!");
        break;

      default:
        System.out.println("Invalid input");
        playerPurchase();
        break;
    }
  }

  public void itemManager(Integer coins) {
    Integer playerCoins = getPlayerCoins();
    if (playerCoins - coins <= 0) {
      System.out.println("You can not afford this item");

    } else {
      setPlayerCoins(playerCoins - coins);
      System.out.println(
          "You spent " + coins + " gold. You now have " + getPlayerCoins() + " gold.");
      playerInfoConsoleOutput();
    }
  }

  /**
   * This looks like this is generates the number of coins found when the player "investigates"
   * things
   */
  public void playerCoinGenerator() {
    Random rand = new Random();
    int upperBoundofCoins = 51;
    int coins = rand.nextInt(upperBoundofCoins);
    if (coins <= 0) {
      System.out.println("Nothing was found ");
      return;
    }
    coinManager(coins);
  }

  /** Checks Player Health and prints out death art if player is dead. */
  public void playerHealthCheck() throws InterruptedException {
    if (this.getPlayerHealth() <= 0) {
      playerDeathArt();
      playerDeathOptions();
    }
  }


  public void playerDeathOptions() throws InterruptedException {
    System.out.println("\nWould you like to play again?\n -Type \"Y\": Yes\n -Type \"N\": No");

    input = scanner.nextLine().trim().toLowerCase();

    if ("y".equals(input) || "yes".equals(input)) {
      // TreasureIslandGameplay.getInstance().chosePlayerName();
      new TreasureIslandGameplay().chosePlayerName();
    } else if ("n".equals(input) || "no".equals(input)) {
      System.out.println("Thank you for playing");
      System.exit(0);

    } else {
      System.out.println("Invalid Input, Try Again!!");
      playerDeathOptions();
    }
  }

  public void processMovement(String islandDestination) {
    String directionOptions =
        "Where would you like to go?\n " +
          "-Type \"N\": North\n " +
          "-Type \"S\": South\n " +
          "-Type \"W\": West\n " +
          "-Type \"E\": East\n " +
          "-Type \"Save\": Save Game\n " +
          "-Type \"Map\": Map\n";

    try {
      while (!hasIslandItem) {
        System.out.println(directionOptions);

        String direction = scanner.nextLine().trim();

        if ("save".equalsIgnoreCase(direction)) {
          SaveLoadGame.saveGame();
          System.out.println("We saved your game state!!");
          System.out.println("But You cannot run forever my friend."+Color.ANSI_RED.getValue()+"Black Beard " +Color.ANSI_RESET.getValue()+ "will find you!!!");
          System.out.println("Sleep well for it may be your last night.");
          System.out.println("Goodbye for now.");
          System.exit(0);

        } else {
          this.currentScene = IsleFactory.islandLocationFactory(direction, islandDestination);
          System.out.println("\nYou are now at the " + this.currentScene.getSceneName());
          Thread.sleep(1000);
          playerInfoConsoleOutput();
          Thread.sleep(2000);
          playerInteractionOptions(direction);
        }
      }

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.println("\b");
    }
  }

  public void playerInteractionOptions(String direction) throws IOException, InterruptedException {
    String input = "";

    String interactionOptions =
        "\nWhat would you like to do?\n" +
          " -Type \"T\": Talk\n" +
          " -Type \"L\": Look Around\n" +
          " -Type \"I\": Investigate\n " +
          " -Type \"C\": See Clues\n " +
          " -Type \"M\": Look at the Map\n" +
          " -Type \"E\": Exit This World\n";

    String interactOptionsWithVendor =
        "\nWhat would you like to do? \n " +
          "-Type \"T\": Talk\n " +
          "-Type \"L\": Look Around\n " +
          "-Type \"I\": Investigate\n " +
          "-Type \"C\": See Clues\n " +
          "-Type \"M\": Look at the Map\n" +
          "-Type \"V\": Visit the Vendor\n " +
          "-Type \"E\": Exit This World\n";

    playerHealthCheck();

    if ("w".equalsIgnoreCase(direction)) {
      System.out.println(interactOptionsWithVendor);
    } else {
      System.out.println(interactionOptions);
    }

    input = scanner.nextLine().trim();


    switch (input.toLowerCase()) {
      case "talk":
      case "t":
        playerInfoConsoleOutput();
        currentScene.talkToNPC(this);
        playerInteractionOptions(direction);
        break;
      case "look":
      case "l":
        playerInfoConsoleOutput();
        currentScene.lookAroundLocation(this);
        playerInteractionOptions(direction);
        break;
      case "investigate":
      case "i":
        playerInfoConsoleOutput();
        currentScene.investigateArea(this);
        playerInteractionOptions(direction);
        break;
      case "clues":
      case "c":
        playerInfoConsoleOutput();
        // TODO: Move this method into each Scene class
        iterateThroughPlayerClues();
        playerInteractionOptions(direction);
        break;
      case "map":
      case "m":
       MainMap main = new MainMap();
       main.mainMap();
        break;
      case "vendor":
      case "v":
        playerInfoConsoleOutput();
        currentScene.vendor(this);
        playerVisitsVendor();
        playerInteractionOptions(direction);
        break;
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
        "\n" + Color.ANSI_RED.getValue() + getCrossBones() + Color.ANSI_RESET.getValue());

    System.out.println(
        Color.ANSI_RED.getValue()
            + Color.ANSI_BOLD.getValue()
            + "You dead!"
            + Color.ANSI_RESET.getValue());
  }

  public void playerInfoConsoleOutput() {
    System.out.println(
        "\n"
            + "___________________________________________________________"
            + "\n"
            + "     "
            + Color.ANSI_PURPLE.getValue()
            + "Health"
            + Color.ANSI_RESET.getValue()
            + ": "
            + this.getPlayerHealth()
            + "\n"
            + "     "
            + Color.ANSI_YELLOW.getValue()
            + "Coins"
            + Color.ANSI_RESET.getValue()
            + ": "
            + this.getPlayerCoins()
            + "\n"
            + "     "
            + Color.ANSI_GREEN.getValue()
            + "Current Location"
            + Color.ANSI_RESET.getValue()
            + ": "
            + currentScene.getSceneName()
            + "\n"
            + "___________________________________________________________");
  }

  // Player and Pirate Fight Sequence
  public void attackPirate(Pirate pirate) {
    System.out.println(
        "\n"
            + Color.ANSI_GREEN.getValue()
            + getPlayerName()
            + Color.ANSI_RESET.getValue()
            + " attacked "
            + Color.ANSI_RED.getValue()
            + pirate.getPirateName()
            + Color.ANSI_RESET.getValue()
            + " for "
            + playerAttackStrength
            + " damage.");
    pirate.setPirateHealth(pirate.getPirateHealth() - playerAttackStrength);

    if (pirate.getPirateHealth() <= 0) {
      System.out.println("You defeated " + pirate.getPirateName());
    }
  }

  public void defendPlayer(Pirate pirate) {
    int result = pirate.pirateAttackStrength - getPlayerHealth();
    if (result <= 0) {
      System.out.println(
          Color.ANSI_RED.getValue()
              + pirate.getPirateName()
              + Color.ANSI_RESET.getValue()
              + " did no damage.");
    } else {
      setPlayerHealth(getPlayerHealth() - result);
      System.out.println(
          Color.ANSI_RED.getValue()
              + pirate.getPirateName()
              + Color.ANSI_RESET.getValue()
              + " did "
              + result
              + " damage");
    }
  }

  public String getCrossBones() {
    return "                     .ed\"\"\"\" \"\"\"$$$$be.\n"
        + "                   -\"           ^\"\"**$$$e.\n"
        + "                 .\"                   '$$$c\n"
        + "                /                      \"4$$b\n"
        + "               d  3                      $$$$\n"
        + "               $  *                   .$$$$$$\n"
        + "              .$  ^c           $$$$$e$$$$$$$$.\n"
        + "              d$L  4.         4$$$$$$$$$$$$$$b\n"
        + "              $$$$b ^ceeeee.  4$$ECL.F*$$$$$$$\n"
        + "  e$\"\"=.      $$$$P d$$$$F $ $$$$$$$$$- $$$$$$\n"
        + " z$$b. ^c     3$$$F \"$$$$b   $\"$$$$$$$  $$$$*\"      .=\"\"$c\n"
        + "4$$$$L        $$P\"  \"$$b   .$ $$$$$...e$$        .=  e$$$.\n"
        + "^*$$$$$c  %..   *c    ..    $$ 3$$$$$$$$$$eF     zP  d$$$$$\n"
        + "  \"**$$$ec   \"   %ce\"\"    $$$  $$$$$$$$$$*    .r\" =$$$$P\"\"\n"
        + "        \"*$b.  \"c  *$e.    *** d$$$$$\"L$$    .d\"  e$$***\"\n"
        + "          ^*$$c ^$c $$$      4J$$$$$% $$$ .e*\".eeP\"\n"
        + "             \"$$$$$$\"'$=e....$*$$**$cz$$\" \"..d$*\"\n"
        + "               \"*$$$  *=%4.$ L L$ P3$$$F $$$P\"\n"
        + "                  \"$   \"%*ebJLzb$e$$$$$b $P\"\n"
        + "                    %..      4$$$$$$$$$$ \"\n"
        + "                     $$$e   z$$$$$$$$$$%\n"
        + "                      \"*$c  \"$$$$$$$P\"\n"
        + "                       .\"\"\"*$$$$$$$$bc\n"
        + "                    .-\"    .$***$$$\"\"\"*e.\n"
        + "                 .-\"    .e$\"     \"*$c  ^*b.\n"
        + "          .=*\"\"\"\"    .e$*\"          \"*bc  \"*$e..\n"
        + "        .$\"        .z*\"               ^*$e.   \"*****e.\n"
        + "        $$ee$c   .d\"                     \"*$.        3.\n"
        + "        ^*$E\")$..$\"                         *   .ee==d%\n"
        + "           $.d$$$*                           *  J$$$e*\n"
        + "            \"\"\"\"\"                              \"$$$\"";
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public void setPlayerHealth(Integer playerHealth) {
    this.playerHealth = playerHealth;
  }

  public void setPlayerCoins(int playerCoins) {
    this.playerCoins = playerCoins;
  }

  public void setCurrentIsland(Island currentIsland) {
    this.currentIsland = currentIsland;
  }

  // GET METHODS
  public Island getCurrentIsland() {
    return currentIsland;
  }

  public Integer getPlayerHealth() {
    return this.playerHealth;
  }

  public Integer getPlayerCoins() {
    return this.playerCoins;
  }

  public String getPlayerName() {
    return this.playerName;
  }

  public Scene getCurrentScene() {
    return currentScene;
  }

  public void setCurrentScene(Scene currentScene) {
    this.currentScene = currentScene;
  }

  public Boolean getHasIslandItem() {
    return hasIslandItem;
  }

  public void setHasIslandItem(Boolean hasIslandItem) {
    this.hasIslandItem = hasIslandItem;
  }

  public void setPlayerCoins(Integer playerCoins) {
    this.playerCoins = playerCoins;
  }

  public Integer getPlayerAttackStrength() {
    return playerAttackStrength;
  }

  public void setPlayerAttackStrength(Integer playerAttackStrength) {
    this.playerAttackStrength = playerAttackStrength;
  }

  public SaveLoadGame getSaveLoadGame() {
    return saveLoadGame;
  }

  public void setSaveLoadGame(SaveLoadGame saveLoadGame) {
    this.saveLoadGame = saveLoadGame;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public Scanner getScanner() {
    return scanner;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public String toString() {
    return "Player{"
        + "vendor="
        + vendor
        + ", vendorItems="
        + vendorItems
        + ", playerClues="
        + playerClues
        + ", clues="
        + Arrays.toString(clues)
        + ", currentScene="
        + currentScene
        + ", hasIslandItem="
        + hasIslandItem
        + ", input='"
        + input
        + '\''
        + ", scanner="
        + scanner
        + ", playerName='"
        + playerName
        + '\''
        + ", playerCoins="
        + playerCoins
        + ", playerHealth="
        + playerHealth
        + ", saveLoadGame="
        + saveLoadGame
        + ", crossBones='"
        + getCrossBones()
        + '\''
        + '}';
  }
}
