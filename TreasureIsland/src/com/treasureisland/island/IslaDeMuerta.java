package com.treasureisland.island;

import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.DuskTillDawnSaloon;
import com.treasureisland.scene.Graveyard;
import com.treasureisland.scene.PawPawBeach;

public class IslaDeMuerta extends Island {

  public IslaDeMuerta() {
    setNorthScene(new AbandonedDistillery());
    setEastScene(new DuskTillDawnSaloon());
    setSouthScene(new Graveyard());
    setWestScene(new PawPawBeach());
  }
}
