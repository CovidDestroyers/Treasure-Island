package com.treasureisland;

import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.AbandonedHouse;
import com.treasureisland.scene.ChurchCruces;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.DoubleCrossTavernCruces;
import com.treasureisland.scene.DuskTillDawnSaloon;
import com.treasureisland.scene.Graveyard;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.PawPawBeach;
import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.SaintsLodgeCruces;
import com.treasureisland.scene.ShipGraveyard;
import com.treasureisland.scene.SouthendBeachCruces;
import com.treasureisland.scene.SugarCaneField;
import com.treasureisland.scene.SunsetRestaurant;
import com.treasureisland.scene.TikkiLounge;

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
