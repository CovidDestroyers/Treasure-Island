package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Arrays;

public class RumDistillery extends Scene {

  public RumDistillery(String sceneName) {
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
  public void enter(Player player) throws InterruptedException {
    System.out.println(southScene.getSceneName());
    System.out.println("You are in the rum distillery!");
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("You're talking to Sean Philippa in the Rum distillery");
    storylineProgression("TI.txt","RDStart", "RDEnd");
    player.playerClues.add(
        "For the last occurrence, look under drum that gives men courage."
            + "\n"
            + "Speak the pirates favorite letter, your reward shall be even better");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", "OCStart", "OCEnd");
    storylineProgression("TI.txt", "MBStart", "MBEnd");
    System.out.println(" ");
    player.playerCoinGenerator();
    player.iterateThroughClues();
  }

//  @Override
//  public void investigateArea(Player player) {
//    storylineProgression("TI.txt", "MBStart", "MBEnd");
//  }

  @Override
  public void vendor(Player player) {}
}
