package com.treasureisland.island;

import com.treasureisland.world.*;

public class RumRunnerIsle extends Island {
  Scene location;


  public void setIslandToTheNorth(Island islandToTheNorth) {
    super.setIslandToTheNorth(islandToTheNorth);
  }


  public void setIslandToTheEast(Island islandToTheEast) {
    super.setIslandToTheEast(islandToTheEast);
  }


  public void setNorthScene(RumDistillery northScene) {
    super.setNorthScene(northScene);
  }


  public void setSouthScene(CrimsonBeachBar southScene) {
    super.setSouthScene(southScene);
  }


  public void setWestScene(SugarCaneField westScene) {
    super.setWestScene(westScene);
  }


  public void setEastScene(AbandonedDistillery eastScene) {
    super.setEastScene(eastScene);
  }

  // @Override
  // public Location islandLocationSelector(IslandSelector rumRunnerIsle, DirectionEnum direction) {
  //   location = null;
  //   if (direction.equals(DirectionEnum.N)) {
  //     location = new RumDistillery();
  //   }
  //   if (direction.equals(DirectionEnum.S)) {
  //     location = new CrimsonBeachBar();
  //   }
  //   if (direction.equals(DirectionEnum.E)) {
  //     location = new AbandonedDistillery();
  //   }
  //   if (direction.equals(DirectionEnum.W)) {
  //     location = new SugarCaneField();
  //   }
  //   return location;
  // }
}
