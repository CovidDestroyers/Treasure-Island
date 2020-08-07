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
  public void enter(Player player) throws InterruptedException {}

  @Override
  public void talk(Player player) {
    storylineProgression("TI.txt", "RNDStart", "RNDStop");
  }

  @Override
  public void look(Player player) {
    storylineProgression("TI.txt", "PStart", "PStop");
  }

  @Override
  public void investigate(Player player) {
    storylineProgression("TI.txt", "SLStart", "SLStop");
  }

  @Override
  public void vendor(Player player) {}
}
