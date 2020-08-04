package com.treasureisland.island;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.world.AbandonedDistillery;
import com.treasureisland.world.CrimsonBeachBar;
import com.treasureisland.world.Location;
import com.treasureisland.world.RumDistillery;
import com.treasureisland.world.SugarCaneField;

import java.util.Scanner;

public class RumRunnerIsle {
  Location location;

   @Override
   public Location islandLocationSelector(TreasureIslandGameplay DirectionEnum) {
     location = new Scanner();
     switch (location) {
       case "N":
         break;
       case "S":
         location.CrimsonBeachBar();
         break;
       case "E":
         location = new AbandonedDistillery();
         break;
       case "W":
         location = new SugarCaneField();
     }

     if (DirectionEnum.equals(DirectionEnum.N)) {
       location = new RumDistillery();
     }
     if (DirectionEnum.equals(DirectionEnum.S)) {
       location = new CrimsonBeachBar();
     }
     if (DirectionEnum.equals(DirectionEnum.E)) {
       location = new AbandonedDistillery();
     }
     if (DirectionEnum.equals(DirectionEnum.W)) {
       location = new SugarCaneField();
     }
     return location;
   }
}
