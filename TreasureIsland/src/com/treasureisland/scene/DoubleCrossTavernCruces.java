package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class DoubleCrossTavernCruces extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public DoubleCrossTavernCruces(String sceneName) {
    super(sceneName);
  }


  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a Tony James at Double Cross Tavern");
    storylineProgression("TI.txt",  "TCStart", "TCStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "BAStart", "BAStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt",  "DStart", "DStop");
    player.playerCoinGenerator();
  }

  @Override
  public void vendor(Player player) {}
}
