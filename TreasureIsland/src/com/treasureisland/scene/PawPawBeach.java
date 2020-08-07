package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class PawPawBeach extends Scene {

  public PawPawBeach(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println(
        "A guy called Slimjaw has some interesting information but he was more interested in having a hot-dog eating competition");
    storylineProgression("TI.txt",  "SJStart", "SJStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "PMStart", "PMStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt",  "CGStart", "CGStop");
  }

  @Override
  public void vendor(Player player) {}
}
