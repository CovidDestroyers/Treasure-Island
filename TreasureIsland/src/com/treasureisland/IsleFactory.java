package com.treasureisland;

import com.treasureisland.world.AbandonedDistillery;
import com.treasureisland.world.AbandonedHouse;
import com.treasureisland.world.ChurchCruces;
import com.treasureisland.world.CrimsonBeachBar;
import com.treasureisland.world.DoubleCrossTavernCruces;
import com.treasureisland.world.DuskTillDawnSaloon;
import com.treasureisland.world.Graveyard;
import com.treasureisland.world.Scene;
import com.treasureisland.world.PawPawBeach;
import com.treasureisland.world.RoyalLodge;
import com.treasureisland.world.RumDistillery;
import com.treasureisland.world.SaintsLodgeCruces;
import com.treasureisland.world.ShipGraveyard;
import com.treasureisland.world.SouthendBeachCruces;
import com.treasureisland.world.SugarCaneField;
import com.treasureisland.world.SunsetRestaurant;
import com.treasureisland.world.TikkiLounge;

public class IsleFactory {

  private IsleFactory() {}

  private static final TreasureIslandGameplay playerGoesTo = TreasureIslandGameplay.getInstance();

  public static Scene islandLocationFactory(String direction, String islandFactorySelection)
      throws InterruptedException {
    Scene location = null;
    if ("rumrunnerisle".equalsIgnoreCase(islandFactorySelection)) {
      // islandFactorySelection.equalsIgnoreCase("rumRunnerIsle") old implementation
      switch (direction.toLowerCase()) {
        case "n":
          location = new RumDistillery();
          break;

        case "s":
          location = new CrimsonBeachBar();
          break;

        case "e":
          location = new AbandonedDistillery();
          break;

        case "w":
          location = new SugarCaneField();
          break;

        default:
          System.out.println("Error, please select correct input");
          playerGoesTo.rumRunnerIsle();
          break;
      }
    }

    if ("portRoyal".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
          location = new RoyalLodge();
          break;
        case "s":
          location = new ShipGraveyard();
          break;

        case "e":
          location = new SunsetRestaurant();
          break;

        case "w":
          location = new TikkiLounge();
          break;

        default:
          System.out.println("Error, please select correct input");
          playerGoesTo.portRoyal();
          break;
      }
    }

    if ("islacruces".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
          location = new ChurchCruces();
          break;
        case "s":
          location = new SouthendBeachCruces();
          break;

        case "e":
          location = new SaintsLodgeCruces();
          break;

        case "w":
          location = new DoubleCrossTavernCruces();
          break;

        default:
          System.out.println("Error, please select correct input");
          playerGoesTo.islaCruces();
          break;
      }
    }

    if ("islademuerta".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
          location = new AbandonedHouse();
          break;
        case "s":
          location = new Graveyard();
          break;

        case "e":
          location = new DuskTillDawnSaloon();
          break;

        case "w":
          location = new PawPawBeach();
          break;

        default:
          System.out.println("Error, please select correct input");
          playerGoesTo.islaDeMuerta();
          break;
      }
    }
    return location;
  }
}
