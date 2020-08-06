package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.DuskTillDawnSaloon;
import com.treasureisland.scene.Graveyard;
import com.treasureisland.scene.PawPawBeach;
import java.util.Scanner;

public class IslaDeMuerta extends Island {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public IslaDeMuerta() {
    // setNorthScene(new AbandonedDistillery());
    // setEastScene(new DuskTillDawnSaloon());
    // setSouthScene(new Graveyard());
    // setWestScene(new PawPawBeach());
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
