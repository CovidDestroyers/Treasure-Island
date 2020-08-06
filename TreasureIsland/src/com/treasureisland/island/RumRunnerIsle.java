package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.SugarCaneField;
import java.util.Scanner;

public class RumRunnerIsle extends Island {

  public RumRunnerIsle() {
    // setNorthScene(new RumDistillery());
    // setEastScene(new AbandonedDistillery());
    // setSouthScene(new CrimsonBeachBar());
    // setWestScene(new SugarCaneField());
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
}
