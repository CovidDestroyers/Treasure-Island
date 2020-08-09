package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.ShipGraveyard;
import com.treasureisland.scene.SunsetRestaurant;
import com.treasureisland.scene.TikkiLounge;

public class PortRoyal extends Island {
  private final Scene royalLounge = new RoyalLodge("Royal Lodge");
  private final Scene sunSetRestaurant = new SunsetRestaurant("Sunset Restaurant");
  private final Scene tikkiLounge = new TikkiLounge("Tikki Lounge");
  private final Scene shipGraveyard = new ShipGraveyard("Ship Graveyard");

  public PortRoyal() {
    setIslandName("Port Royal");
    setCurrentScene(royalLounge);

    royalLounge.connectSouth(tikkiLounge);
    royalLounge.connectEast(sunSetRestaurant);
    sunSetRestaurant.connectSouth(shipGraveyard);
    tikkiLounge.connectEast(shipGraveyard);
  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}

  @Override
  public String toString() {
    return "PortRoyal{"
        + "royalLounge="
        + royalLounge
        + ", sunSetRestaurant="
        + sunSetRestaurant
        + ", tikkiLounge="
        + tikkiLounge
        + ", shipGraveyard="
        + shipGraveyard
        + "} "
        + super.toString();
  }
}
