package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

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
  public void enter(Scanner in, Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc sunset restaurant");
    storylineProgression("TI.txt", getSceneName(), "RNDStart", "RNDStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around sunset restaurant");
    storylineProgression("TI.txt", getSceneName(), "PSStart", "PSStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating sunset restaurant");
    storylineProgression("TI.txt", getSceneName(), "SLStart", "SLStop");
  }

  @Override
  public void vendor() {}
}
