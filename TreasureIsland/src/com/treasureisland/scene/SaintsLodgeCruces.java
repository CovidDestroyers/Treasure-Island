package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class SaintsLodgeCruces extends Scene {

  private final Player player = new Player();

  public SaintsLodgeCruces(String sceneName) {
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
    System.out.println("Talking to Dirty Lewis Brown at Saints Lodge");

    // TODO: storylineProgrssion should be in the Scene class
    storylineProgression("TI.txt", getSceneName(), "SLStart", "SLStop");
    player.setPlayerHealth(player.getPlayerHealth() - 30);
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around Saints Lodge");
    storylineProgression("TI.txt", getSceneName(), "MRStart", "MRStop");
    player.setPlayerHealth(player.getPlayerHealth() - 20);
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating Saints Lodge");
    storylineProgression("TI.txt", getSceneName(), "PAStart", "PAStop");
    player.setPlayerHealth(player.getPlayerHealth() - 15);
  }

  @Override
  public void vendor() {}
}
