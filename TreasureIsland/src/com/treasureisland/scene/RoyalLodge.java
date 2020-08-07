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
  public void talk(Player player) {
    System.out.println("Talking to a npc Royal lodge, I found out about room 101");
    storylineProgression("TI.txt",  "R1Start", "R1Stop");
  }

  @Override
  public void look(Player player) {
    System.out.println("Looking around royal lodge");
    storylineProgression("TI.txt",  "SRStart", "SRStop");
  }

  @Override
  public void investigate(Player player) {
    System.out.println("Investigating royal lodge");
    storylineProgression("TI.txt",  "BRStart", "BRStop");
  }

  @Override
  public void vendor(Player player) {}
}
