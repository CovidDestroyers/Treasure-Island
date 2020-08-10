package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

public class ShipGraveyard extends Scene {

  public ShipGraveyard(String sceneName) {
    super(sceneName);
  }


  @Override
  public void talkToNPC(Player player) {
    System.out.println(
        "Talking to Ryan at ship graveyard, I was pointed to check out the biggest ship ");
    storylineProgression("TI.txt",  "SGStart", "SGStop");
    if(Item.findByName(player.playerInventory, "high tide") == null) {
      player.playerInventory.add(new Item("high tide", 0, 0));
      System.out.println("\n" + Color.ANSI_BLUE.getValue() + "Clue added to your Inventory!!" + Color.ANSI_RESET.getValue());
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around ship graveyard");
    storylineProgression("TI.txt",  "SBStart", "SBStop");
    player.playerCoinGenerator();
    System.out.println("\n");
    player.iterateThroughClues();
  }

//  @Override
//  public void investigateArea(Player player) {
//    System.out.println("Investigating ship graveyard");
//    storylineProgression("TI.txt",  "BBDtart", "BBDStop");
//    player.playerCoinGenerator();
//  }

  @Override
  public void vendor(Player player) {}
}
