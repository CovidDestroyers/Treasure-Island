package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

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
   * @param in
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc at Double Cross Tavern");
    storylineProgression("TI.txt", getSceneName(), "TCStart", "TCStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "BAStart", "BAStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "DStart", "DStop");
    player.playerCoinGenerator();
  }

  @Override
  public void vendor() {}
}
