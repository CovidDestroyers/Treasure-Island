package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class Graveyard extends Scene {

  public Graveyard(String sceneName) {
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
    System.out.println("After some persuasion my acquaintance took me to the graveyard.");
    storylineProgression("TI.txt", getSceneName(), "CQStart", "CQStop");
    player.setPlayerHealth(player.getPlayerHealth() - 5);
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "STStart", "STStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "BTStart", "BTStop");
    player.playerCoinGenerator();
  }

  @Override
  public void vendor() {}
}
