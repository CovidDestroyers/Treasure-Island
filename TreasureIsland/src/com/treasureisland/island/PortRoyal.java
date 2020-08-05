package com.treasureisland.island;

import com.treasureisland.world.RoyalLodge;
import com.treasureisland.world.ShipGraveyard;
import com.treasureisland.world.SunsetRestaurant;
import com.treasureisland.world.TikkiLounge;

public class PortRoyal extends Island {

  public PortRoyal() {
    setNorthScene(new RoyalLodge());
    setEastScene(new SunsetRestaurant());
    setSouthScene(new ShipGraveyard());
    setWestScene(new TikkiLounge());
  }
}
