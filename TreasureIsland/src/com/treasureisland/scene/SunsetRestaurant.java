package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

public class SunsetRestaurant extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public SunsetRestaurant(String sceneName) {
    super(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void talkToNPC(Player player) {
      System.out.println("Talking to Tom at Sunset Restaurant. I found out about room 101.");
      storylineProgression("TI.txt", "RNDStart", "RNDStop");
    if(Item.findByName(player.playerInventory, "101") == null) {
      player.playerInventory.add(new Item("101", 0, 0));
      System.out.println("\n" + Color.ANSI_BLUE.getValue() + "Clue added to your Inventory!!" + Color.ANSI_RESET.getValue());
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", "PStart", "PStop");
    storylineProgression("TI.txt", "SLStart", "SLStop");
    player.iterateThroughClues();
  }

//  @Override
//  public void investigateArea(Player player) {
//    storylineProgression("TI.txt", "SLStart", "SLStop");
//  }

  @Override
  public void vendor(Player player) {}
}
