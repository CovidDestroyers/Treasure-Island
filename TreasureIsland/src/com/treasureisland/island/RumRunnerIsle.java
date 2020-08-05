package com.treasureisland.island;

import com.treasureisland.world.*;

public class RumRunnerIsle extends Island {


  public RumRunnerIsle() {
    setNorthScene(new RumDistillery());
    setEastScene(new AbandonedDistillery());
    setSouthScene(new CrimsonBeachBar());
    setWestScene(new SugarCaneField());
  }
}
