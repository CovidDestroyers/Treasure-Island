package com.treasureisland.island;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.map.MainMap;
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

  public static Scene islandLocationFactory(String direction, String islandFactorySelection)
      throws InterruptedException {
    Scene scene = null;
    MainMap map = new MainMap();
    if ("rumrunnerisle".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
        case "north":
          scene = new RumDistillery("Rum Distillery");
          break;
        case "s":
        case "south":
          scene = new CrimsonBeachBar("Crimson Beach Bar");
          break;
        case "e":
        case "east":
          scene = new AbandonedDistillery("Abandoned distillery");
          break;
        case "w":
        case "west":
          scene = new SugarCaneField("Sugar cane field");
          break;
        case "m":
        case "map":
          map.rumRunner();
          break;
        default:
          System.out.println("Error, please select correct input");
          break;
      }
    }

    if ("portRoyal".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
        case "north":
          scene = new RoyalLodge("Royal Lodge");
          break;
        case "s":
        case "south":
          scene = new ShipGraveyard("Ship Graveyard");
          break;
        case "e":
        case "east":
          scene = new SunsetRestaurant("Sunset Restaurant");
          break;
        case "w":
        case "west":
          scene = new TikkiLounge("Tikki Lounge");
          break;
        case "m":
        case "map":
          map.portRoyal();
          break;
        default:
          System.out.println("Error, please select correct input");
          break;
      }
    }

    if ("islacruces".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
        case "north":
          scene = new ChurchCruces("Church Cruces");
          break;
        case "s":
        case "south":
          scene = new SouthendBeachCruces("Southend Beach");
          break;
        case "e":
        case "east":
          scene = new SaintsLodgeCruces("Saints Lodge");
          break;
        case "w":
        case "west":
          scene = new DoubleCrossTavernCruces("Double Cross Tavern");
          break;
        case "m":
        case "map":
          map.islaCruces();
          break;
        default:
          System.out.println("Error, please select correct input");
          break;
      }
    }

    if ("islademuerta".equalsIgnoreCase(islandFactorySelection)) {
      switch (direction.toLowerCase()) {
        case "n":
        case "north":
          scene = new AbandonedHouse("Abandoned House On The Hill");
          break;
        case "s":
        case "south":
          scene = new Graveyard("Graveyard");
          break;
        case "e":
        case "east":
          scene = new DuskTillDawnSaloon("Dusk Till Dawn Saloon");
          break;
        case "w":
        case "west":
          scene = new PawPawBeach("Pawpaw Beach");
          break;
        default:
          System.out.println("Error, please select correct input");
          break;
      }
    }
    return scene;
  }
}
