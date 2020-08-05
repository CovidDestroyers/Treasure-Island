package com.treasureisland.island;

import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.ShipGraveyard;
import com.treasureisland.scene.SunsetRestaurant;
import com.treasureisland.scene.TikkiLounge;

public class PortRoyal extends Island {

  public PortRoyal() {
    setNorthScene(new RoyalLodge());
    setEastScene(new SunsetRestaurant());
    setSouthScene(new ShipGraveyard());
    setWestScene(new TikkiLounge());
  }
}
