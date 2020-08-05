package com.treasureisland.scene;

import com.treasureisland.TreasureIslandGameplay;

import com.treasureisland.player.Player;

public class CrimsonBeachBar extends Scene {

  private final TreasureIslandGameplay game = TreasureIslandGameplay.getInstance();
  private Player player = Player.getInstance();

  @Override
  public String getLocationName() {
    return "Crimson Beach Bar";
  }

  @Override
  public void talkToNPC() {
    game.storylineProgression("TI.txt", getLocationName(), "JStart", "JEnd");
    //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
    player.playerClues.add("999");
  }

  @Override
  public void lookAroundLocation(){
    game.storylineProgression("TI.txt", getLocationName(), "CBStart", "CBEnd");
  }

  @Override
  public void investigateArea(){
    game.storylineProgression("TI.txt", getLocationName(), "PTStart", "PTEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 10);
  }

  @Override
  public void vendor() {

  }

}