package com.treasureisland.scene;

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

  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt", "BGStart", "BGEnd");
  }

  @Override
  public void lookAroundLocation(Player player) {

    storylineProgression("TI.txt",  "DSStart", "DSEnd");

    storylineProgression("TI.txt",  "DRStart", "DREnd");
    player.setPlayerHealth(player.getPlayerHealth() - 50);
    player.iterateThroughClues();
    player.playerClues.add("9");

  }

  //  @Override
  //  public void investigateArea(Player player) {
  //    storylineProgression("TI.txt",  "DRStart", "DREnd");
  //    player.playerClues.add("9");
  //  }

  @Override
  public void vendor(Player player) {}
}
