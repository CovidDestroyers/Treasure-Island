package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class AbandonedHouse extends Scene {

  public AbandonedHouse(String sceneName) {
    super(sceneName);
  }

  @Override
  public String getSceneName() {
    return "Abandoned House On The Hill ";
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
    System.out.println(
        "After informing about the Abandoned house on the hill, my friend took me there and I searched . .");
    storylineProgression("TI.txt", getSceneName(), "FLStart", "FLStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "DAStart", "DAStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "HPStart", "HPStop");
  }

  @Override
  public void vendor() {}
}