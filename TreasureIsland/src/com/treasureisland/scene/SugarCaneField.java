package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

public class SugarCaneField extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public SugarCaneField(String sceneName) {
    super(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  @Override
  public void talkToNPC(Player player) {
    System.out.println("I won't talk without the secret code");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("9999")) {
      System.out.println(
          "\n "
              + Color.ANSI_BOLD.getValue()
              + Color.ANSI_BLUE.getValue()
              + "DING DING DING"
              + Color.ANSI_RESET.getValue()
              + "\n You have unlocked your first treasure piece."
              + "\n awarded "
              + Color.ANSI_BOLD.getValue()
              + Color.ANSI_RED.getValue()
              + "\"An Emerald\""
              + Color.ANSI_RESET.getValue());
      player.playerTreasures.add("Emerald");
      player.playerInventory.remove(Item.findByName(player.playerInventory, "9"));
      player.playerInventory.remove(Item.findByName(player.playerInventory, "999"));
      player.setHasIslandItem(true);
    } else {
      System.out.println("To get the code, you should look around for the clues.");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", "WWStart", "WWEnd");
    storylineProgression("TI.txt", "SStart", "SEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 5);
    System.out.println("\n");
    player.playerCoinGenerator();
    System.out.println("\n");
    player.iterateThroughClues();
    if (Item.findByName(player.playerInventory, "key") == null) {
      player.playerInventory.add(new Item("key", 0, 0));
      System.out.println(
        "\n"
          + Color.ANSI_BLUE.getValue()
          + "Clue added to your Inventory!!"
          + Color.ANSI_RESET.getValue());
    }
  }

  @Override
  public void vendor(Player player) {
    player.playerVisitsVendor();
  }

  @Override
  public void displayInteractionOptions() {
    System.out.println(
        "\nWhat would you like to do?\n "
            + " -Type \"T\": Talk\n "
            + " -Type \"L\": Look Around\n "
            + " -Type \"V\": Visit Vendor\n "
            + " -Type \"R\": See Treasure Rewards\n "
            + " -Type \"M\": Look at the Map\n "
            + " -Type \"INV\": Inventory\n "
            + " -Type \"G\": Grab Item\n "
            + " -Type \"E\": Exit This Location\n ");
  }
}
