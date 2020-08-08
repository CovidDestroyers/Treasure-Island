package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class Docks extends Scene {

  public Docks(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Player player, String islandName) {}

  @Override
  public void talkToNPC(Player player) {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}
}
