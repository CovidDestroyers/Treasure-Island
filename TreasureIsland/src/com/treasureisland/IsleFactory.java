package com.treasureisland;

import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.AbandonedHouse;
import com.treasureisland.scene.ChurchCruces;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.DoubleCrossTavernCruces;
import com.treasureisland.scene.DuskTillDawnSaloon;
import com.treasureisland.scene.Graveyard;
import com.treasureisland.scene.PawPawBeach;
import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.SaintsLodgeCruces;
import com.treasureisland.scene.Scene;
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
          location = new RumDistillery("Rum Distillery");
          break;

        case "s":
          location = new CrimsonBeachBar("Crimson Beach Bar");
          break;

        case "e":
          location = new AbandonedDistillery("Abandoned distillery");
          break;

        case "w":
          location = new SugarCaneField("Sugar cane field");
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
          location = new RoyalLodge("Royal Lodge");
          break;
        case "s":
          location = new ShipGraveyard("Ship Graveyard");
          break;

        case "e":
          location = new SunsetRestaurant("Sunset Restaurant");
          break;

        case "w":
          location = new TikkiLounge("Tikki Lounge");
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
          location = new ChurchCruces("Church Cruces");
          break;
        case "s":
          location = new SouthendBeachCruces("Southend Beach");
          break;

        case "e":
          location = new SaintsLodgeCruces("Saints Lodge");
          break;

        case "w":
          location = new DoubleCrossTavernCruces("Double Cross Tavern");
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
          location = new AbandonedHouse("Abandoned House On The Hill");
          break;
        case "s":
          location = new Graveyard("Graveyard");
          break;

        case "e":
          location = new DuskTillDawnSaloon("Dusk Till Dawn Saloon");
          break;

        case "w":
          location = new PawPawBeach("Pawpaw Beach");
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
