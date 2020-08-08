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

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) throws InterruptedException {
    System.out.println("You're in the abandoned distillery!");
  }

  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt",  "BGStart", "BGEnd");
  }

  @Override
  public void lookAroundLocation(Player player) {

    storylineProgression("TI.txt",  "DSStart", "DSEnd");

    storylineProgression("TI.txt",  "DRStart", "DREnd");
    player.setPlayerHealth(player.getPlayerHealth() - 5);
    player.iterateThroughClues();
    if(Item.findByName(player.playerInventory, "9") == null) {
      player.playerInventory.add(new Item("9", 0, 0));
      System.out.println("\n" + Color.ANSI_BLUE.getValue() + "Clue added to your Inventory!!" + Color.ANSI_RESET.getValue());
    }
  }

  //@Override
//  public void investigateArea(Player player) {
//    storylineProgression("TI.txt",  "DRStart", "DREnd");
//    //player.playerClues.add("9");
//    if(Item.findByName(player.playerInventory, "9") == null) {
//      player.playerInventory.add(new Item("9", 0, 0));
//    }
//    player.iterateThroughClues();
//    player.playerClues.add("9");
//
//  }

  @Override
  public void vendor(Player player) {

  }

}
