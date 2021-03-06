package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class ChurchCruces extends Scene {

  public ChurchCruces(String sceneName) {
    super(sceneName);
  }


  @Override
  public void talkToNPC(Player player) {
    System.out.println("You are talking to Friar Domingo at Church Cruces");
    storylineProgression("TI.txt",  "FJStart", "FJStop");

    // TODO: ITEMS: Add item to player's inventory
    System.out.println(" You found one of the treasures needed to access the Island ");
    player.setHasIslandItem(true);
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("looking around church");
    storylineProgression("TI.txt",  "CStart", "CStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating Church Cruces...");
    storylineProgression("TI.txt",  "AStart", "AStop");
  }

  @Override
  public void vendor(Player player) {

  }

}
