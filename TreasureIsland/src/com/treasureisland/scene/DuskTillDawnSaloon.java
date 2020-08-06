package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class DuskTillDawnSaloon extends Scene {

  public DuskTillDawnSaloon(String sceneName) {
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
    System.out.println("You're talking to a npc at Dusk Till Dawn Saloon.");
    storylineProgression("TI.txt", getSceneName(), "FIStart", "FIStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "WCStart", "WCStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println(" Searching the saloon, I found out that John has a key I may need.");
    storylineProgression("TI.txt", getSceneName(), "KJStart", "KJStop");

    player.setPlayerHealth(player.getPlayerHealth() - 20);
    // TODO: ITEMS -> Key
    System.out.println(" But you also got the key needed for the Treasure Island");
    player.haveIslandItem = true;
  }

  @Override
  public void vendor() {}
}
