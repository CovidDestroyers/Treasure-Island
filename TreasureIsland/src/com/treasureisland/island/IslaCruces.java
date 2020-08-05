package com.treasureisland.island;

import com.treasureisland.scene.ChurchCruces;
import com.treasureisland.scene.DoubleCrossTavernCruces;
import com.treasureisland.scene.SaintsLodgeCruces;
import com.treasureisland.scene.SouthendBeachCruces;

public class IslaCruces extends Island {

  public IslaCruces() {
    setNorthScene(new ChurchCruces());
    setEastScene(new SaintsLodgeCruces());
    setSouthScene(new SouthendBeachCruces());
    setWestScene(new DoubleCrossTavernCruces());
  }
}
