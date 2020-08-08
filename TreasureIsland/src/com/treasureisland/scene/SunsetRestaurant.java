package com.treasureisland.scene;

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
    storylineProgression("TI.txt", "RNDStart", "RNDStop");
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
