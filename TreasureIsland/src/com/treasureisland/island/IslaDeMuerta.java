package com.treasureisland.island;

import com.treasureisland.player.Player;

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
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) throws InterruptedException {

  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {

  }

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {

  }

  @Override
  public void vendor(Player player) {

  }
}
