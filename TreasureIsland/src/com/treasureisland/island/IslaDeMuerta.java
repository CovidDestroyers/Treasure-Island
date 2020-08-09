package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedHouse;
import com.treasureisland.scene.DuskTillDawnSaloon;
import com.treasureisland.scene.Graveyard;
import com.treasureisland.scene.PawPawBeach;
import com.treasureisland.scene.Scene;

public class IslaDeMuerta extends Island {

  private final Scene abandonedHouse =
    new AbandonedHouse("Abandoned House On The Hill");
  private final Scene duskTillDawnSaloon =
    new DuskTillDawnSaloon("Dusk Till Dawn Saloon");
  private final Scene graveYard = new Graveyard("Graveyard");
  private final Scene pawPawBeach = new PawPawBeach("Pawpaw Beach");

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public IslaDeMuerta() {
    setIslandName("Isla De Muerta");
    setCurrentScene(duskTillDawnSaloon);

    abandonedHouse.connectSouth(pawPawBeach);
    abandonedHouse.connectEast(duskTillDawnSaloon);
    pawPawBeach.connectEast(graveYard);
    duskTillDawnSaloon.connectSouth(graveYard);
  }

  public IslaDeMuerta(String islandName) {
    setName(islandName);
  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}


  @Override
  public String toString() {
    return "IslaDeMuerta{" +
      "abandonedHouse=" + abandonedHouse +
      ", duskTillDawnSaloon=" + duskTillDawnSaloon +
      ", graveYard=" + graveYard +
      ", pawPawBeach=" + pawPawBeach +
      "} " + super.toString();
  }
}
