package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

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
   * @param in
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc Royal lodge, I found out about room 101");
    storylineProgression("TI.txt", getSceneName(), "R1Start", "R1Stop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around royal lodge");
    storylineProgression("TI.txt", getSceneName(), "SRStart", "SRStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating royal lodge");
    storylineProgression("TI.txt", getSceneName(), "BRStart", "BRStop");
  }

  @Override
  public void vendor() {}
}
