package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class RumDistillery extends Scene {

  public RumDistillery(String sceneName) {
    super(sceneName);
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("You're talking to Sean Philippa in the Rum distillery");
    storylineProgression("TI.txt", "RDStart", "RDEnd");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", "OCStart", "OCEnd");
    System.out.println(" ");
    player.playerCoinGenerator();
    System.out.println("\n");
    player.iterateThroughClues();
  }


  @Override
  public void vendor(Player player) {}
}
