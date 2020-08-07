package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class DuskTillDawnSaloon extends Scene {

  public DuskTillDawnSaloon(String sceneName) {
    super(sceneName);
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
  public void talkToNPC(Player player) {
    System.out.println("You're talking to a npc at Dusk Till Dawn Saloon.");
    storylineProgression("TI.txt",  "FIStart", "FIStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "WCStart", "WCStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println(" Searching the saloon, I found out that John has a key I may need.");
    storylineProgression("TI.txt", "KJStart", "KJStop");

    player.setPlayerHealth(player.getPlayerHealth() - 20);
    // TODO: ITEMS -> Key
    System.out.println(" But you also got the key needed for the Treasure Island");
    player.setHasIslandItem(true);
  }

  @Override
  public void vendor(Player player) {}
}
