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
  public void talk(Player player) {
    System.out.println("Talking to a Tony James at Double Cross Tavern");
    storylineProgression("TI.txt",  "TCStart", "TCStop");
  }

  @Override
  public void look(Player player) {
    storylineProgression("TI.txt",  "BAStart", "BAStop");
  }

  @Override
  public void investigate(Player player) {
    storylineProgression("TI.txt",  "DStart", "DStop");
    player.playerCoinGenerator();
  }

  @Override
  public void vendor(Player player) {}
}
