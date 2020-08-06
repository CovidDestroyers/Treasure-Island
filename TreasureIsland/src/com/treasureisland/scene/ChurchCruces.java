package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class ChurchCruces extends Scene {

  public ChurchCruces(String sceneName) {
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
    System.out.println("You are talking to Friar Domingo at Church Cruces");
    storylineProgression("TI.txt", getSceneName(), "FJStart", "FJStop");

    // TODO: ITEMS: Add item to player's inventory
    System.out.println(" You found one of the treasures needed to access the Island ");
    player.haveIslandItem = true;
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("looking around church");
    storylineProgression("TI.txt", getSceneName(), "CStart", "CStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating Church Cruces...");
    storylineProgression("TI.txt", getSceneName(), "AStart", "AStop");
  }

  @Override
  public void vendor() {

  }

}
