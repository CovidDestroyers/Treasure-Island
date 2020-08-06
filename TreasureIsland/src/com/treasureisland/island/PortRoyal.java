package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.ShipGraveyard;
import com.treasureisland.scene.SunsetRestaurant;
import com.treasureisland.scene.TikkiLounge;
import java.util.Scanner;

public class PortRoyal extends Island {

  public PortRoyal() {
    // setNorthScene(new RoyalLodge());
    // setEastScene(new SunsetRestaurant());
    // setSouthScene(new ShipGraveyard());
    // setWestScene(new TikkiLounge());
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
