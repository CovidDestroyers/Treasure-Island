package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.RoyalLodge;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.ShipGraveyard;
import com.treasureisland.scene.SunsetRestaurant;
import com.treasureisland.scene.TikkiLounge;

public class PortRoyal extends Island {
  private final Scene royalLounge = new RoyalLodge("Royal Lodge");
  private final Scene sunSetRestaurant = new SunsetRestaurant("Sunset Restaurant");
  private final Scene tikkiLounge = new TikkiLounge("Tikki Lounge");
  private final Scene shipGraveyard = new ShipGraveyard("Ship Graveyard");

  public PortRoyal() {
    setIslandName("portRoyal");
    addScenesToIsland(royalLounge, sunSetRestaurant, tikkiLounge, shipGraveyard);

    royalLounge.connectSouth(tikkiLounge);
    royalLounge.connectEast(sunSetRestaurant);
    sunSetRestaurant.connectSouth(shipGraveyard);
    tikkiLounge.connectEast(shipGraveyard);
  }

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) {
    System.out.println("You have arrived at Port Royal. Enjoy your stay...\n");

    String userInput = "";
    String whereToGo = getDirectionOptions();

    try {
      player.setCurrentIsland(this);
      currentScene = royalLounge;

      while (true) {
        whereToGo =
            (player.getHasIslandItem()) ? getDirectOptionsWithDocks() : getDirectionOptions();
        System.out.println(whereToGo);

        userInput = scanner.nextLine().trim().toLowerCase();

        if ("d".equals(userInput) || "docks".equals(userInput)) {
          break;
        }

        if ("save".equals(userInput)) {
          saveGame();

        } else if ("chart".equals(userInput)) {
          theMap.mainMap();

        } else if ("map".equals(userInput)) {
          theMap.rumRunner();

        } else if (DirectionEnum.isValid(userInput)) {
          currentScene = currentScene.changeScene(userInput);

          if (currentScene == null) {
            System.out.println("Please try again...\n");
          } else {
            currentScene.enter(player, getIslandName());
          }

        } else {
          System.out.println("Error: unknown direction " + userInput);
          System.out.println("Please try again...\n");
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Oops! Please try again...\n");
      System.out.println(directionOptions);
    }
  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}
}
