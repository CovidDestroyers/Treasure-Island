package com.treasureisland.scene;

import com.treasureisland.player.PirateFightSequence;
import com.treasureisland.player.Player;
import java.util.Scanner;

public class CrimsonBeachBar extends Scene {

  public CrimsonBeachBar(String sceneName) {
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
  public void enter(Scanner in, Player player) throws InterruptedException {

  }

  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt", getSceneName(), "JStart", "JEnd");

    //TODO another clue added 9999 in RumDistillery.java. hash out which clue added.
    player.playerClues.add("999");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "CBStart", "CBEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 10);
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "PTStart", "PTEnd");
    PirateFightSequence.getInstance().PlayerAndPirateFightSequence(player);
  }

  @Override
  public void vendor() {

  }

}