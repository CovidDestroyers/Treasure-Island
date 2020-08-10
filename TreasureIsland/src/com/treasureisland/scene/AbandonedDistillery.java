package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

public class AbandonedDistillery extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public AbandonedDistillery(String sceneName) {
    super(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt", "DSStart", "DSEnd");
    if (Item.findByName(player.playerInventory, "9") == null) {
      player.playerInventory.add(new Item("9", 0, 0));
      System.out.println(
        "\n"
          + Color.ANSI_BLUE.getValue()
          + "Clue added to your Inventory!!"
          + Color.ANSI_RESET.getValue());
    }
  }

  @Override
  public void lookAroundLocation(Player player) {

    storylineProgression("TI.txt", "BGStart", "BGEnd");

    player.setPlayerHealth(player.getPlayerHealth() - 5);
    System.out.println("\n");
    player.iterateThroughClues();
  }

  @Override
  public void vendor(Player player) {}
}
