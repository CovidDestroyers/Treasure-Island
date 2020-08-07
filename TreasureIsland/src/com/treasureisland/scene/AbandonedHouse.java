package com.treasureisland.scene;

import com.treasureisland.player.Player;

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
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) throws InterruptedException {}

  @Override
  public void talk(Player player) {
    storylineProgression("TI.txt", "FLStart", "FLStop");
  }

  @Override
  public void look(Player player) {
    storylineProgression("TI.txt",  "DAStart", "DAStop");
  }

  @Override
  public void investigate(Player player) {
    storylineProgression("TI.txt",  "HPStart", "HPStop");
  }

  @Override
  public void vendor(Player player) {}
}
