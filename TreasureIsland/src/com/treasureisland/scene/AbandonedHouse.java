package com.treasureisland.scene;

import com.treasureisland.player.Player;

public class AbandonedHouse extends Scene {

  public AbandonedHouse(String sceneName) {
    super(sceneName);
  }

  @Override
  public String getSceneName() {
    return "Abandoned House On The Hill ";
  }


  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt", "FLStart", "FLStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "DAStart", "DAStop");
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt",  "HPStart", "HPStop");
  }

  @Override
  public void vendor(Player player) {}
}
