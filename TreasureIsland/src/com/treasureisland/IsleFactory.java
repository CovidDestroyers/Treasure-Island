package com.treasureisland;
import com.sun.tools.javac.Main;
import com.treasureisland.island.DirectionEnum;

import com.treasureisland.map.MainMap;

import com.treasureisland.world.*;


public class IsleFactory {



    private IsleFactory() {

    }

    private static final TreasureIslandGameplay playerGoesTo = TreasureIslandGameplay.getInstance();

    public static Location islandLocationFactory(String direction, String islandFactorySelection) throws InterruptedException {
        Location location = null;
        if("rumrunnerisle".equalsIgnoreCase(islandFactorySelection)) {
           //islandFactorySelection.equalsIgnoreCase("rumRunnerIsle") old implementation
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
                    //TODO pass direction into rumRunnerIsle and see if i can have optional options for vendor
                    playerGoesTo.rumRunnerIsle();
                    break;
            }
        }

        if("portRoyal".equalsIgnoreCase(islandFactorySelection)) {
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

        if("islacruces".equalsIgnoreCase(islandFactorySelection)){
            switch(direction.toLowerCase()){
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

        if("islademuerta".equalsIgnoreCase(islandFactorySelection)){
            switch(direction.toLowerCase()){
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
