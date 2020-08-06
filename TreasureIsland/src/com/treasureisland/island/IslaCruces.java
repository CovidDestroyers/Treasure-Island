package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.ChurchCruces;
import com.treasureisland.scene.DoubleCrossTavernCruces;
import com.treasureisland.scene.SaintsLodgeCruces;
import com.treasureisland.scene.SouthendBeachCruces;
import java.util.Scanner;

public class IslaCruces extends Island {

  public IslaCruces() {
    // setNorthScene(new ChurchCruces());
    // setEastScene(new SaintsLodgeCruces());
    // setSouthScene(new SouthendBeachCruces());
    // setWestScene(new DoubleCrossTavernCruces());
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
