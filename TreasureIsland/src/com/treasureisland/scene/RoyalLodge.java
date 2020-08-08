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
    System.out.println("Talking to a npc Royal lodge, I found out about room 101");
    storylineProgression("TI.txt",  "R1Start", "R1Stop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around royal lodge");
    storylineProgression("TI.txt",  "SRStart", "SRStop");
    storylineProgression("TI.txt",  "BRStart", "BRStop");
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
