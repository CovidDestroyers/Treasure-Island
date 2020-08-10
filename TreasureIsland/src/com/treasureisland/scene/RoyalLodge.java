package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class RoyalLodge extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public RoyalLodge(String sceneName) {
    super(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void talkToNPC(Player player) {

    storylineProgression("TI.txt",  "R1Start", "R1Stop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "SRStart", "SRStop");
    player.iterateThroughClues();
  }

//  @Override
//  public void investigateArea(Player player) {
//    System.out.println("Investigating royal lodge");
//    storylineProgression("TI.txt",  "BRStart", "BRStop");
//  }

  @Override
  public void vendor(Player player) {}
}
