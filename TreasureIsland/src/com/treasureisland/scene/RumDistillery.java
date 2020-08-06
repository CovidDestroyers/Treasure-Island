package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class RumDistillery extends Scene {

  public RumDistillery(String sceneName) {
    super(sceneName);
  }

  @Override
  public String getSceneName() {
    return "Rum Distillery";
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
    System.out.println("You're talking to a npc in rum distillery");
    storylineProgression("TI.txt", getSceneName(), "RDStart", "RDEnd");
    player.playerClues.add(
        "For the last occurrence, look under drum that gives men courage."
            + "\n"
            + "Speak the pirates favorite letter, your reward shall be even better");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "OCStart", "OCEnd");
    player.playerCoinGenerator();
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "MBStart", "MBEnd");
  }

  @Override
  public void vendor() {}
}