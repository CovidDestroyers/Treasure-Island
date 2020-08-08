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

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {

    storylineProgression("TI.txt",  "R1Start", "R1Stop");
  }

  @Override
  public void lookAroundLocation(Player player) {
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
