package com.treasureisland.island;

import com.treasureisland.player.Player;

public class IslaDeMuerta extends Island {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public IslaDeMuerta() {
    setIslandName("Isla De Muerta");
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
}
