package com.treasureisland.island;

import com.treasureisland.world.AbandonedDistillery;
import com.treasureisland.world.DuskTillDawnSaloon;
import com.treasureisland.world.Graveyard;
import com.treasureisland.world.PawPawBeach;

public class IslaDeMuerta extends Island {

  public IslaDeMuerta() {
    setNorthScene(new AbandonedDistillery());
    setEastScene(new DuskTillDawnSaloon());
    setSouthScene(new Graveyard());
    setWestScene(new PawPawBeach());
  }
}
