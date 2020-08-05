package com.treasureisland.island;

import com.treasureisland.world.ChurchCruces;
import com.treasureisland.world.DoubleCrossTavernCruces;
import com.treasureisland.world.SaintsLodgeCruces;
import com.treasureisland.world.SouthendBeachCruces;

public class IslaCruces extends Island {

  public IslaCruces() {
    setNorthScene(new ChurchCruces());
    setEastScene(new SaintsLodgeCruces());
    setSouthScene(new SouthendBeachCruces());
    setWestScene(new DoubleCrossTavernCruces());
  }
}
