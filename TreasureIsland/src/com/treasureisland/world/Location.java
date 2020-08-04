package com.treasureisland.world;

import com.treasureisland.island.DirectionEnum;
import java.io.IOException;
import java.io.Serializable;

public abstract class Location implements Serializable {
  String locationName = null;
  DirectionEnum direction = null;

  public String getLocationName() {
    return null;
  }

  public void talkToNPC() throws IOException, InterruptedException {

  }

  public void lookAroundLocation() throws IOException, InterruptedException {

  }

  public void investigateArea() throws IOException, InterruptedException {

  }

  public void vendor() {

  }
}
