package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.SugarCaneField;
import java.util.Scanner;

public class RumRunnerIsle extends Island {
  private Scene rumDistillery = new RumDistillery("Rum Distillery");
  private Scene abandonedDistillery = new AbandonedDistillery("Abandoned distillery");
  private Scene crimsonBeachBar = new CrimsonBeachBar("Crimson Beach Bar");
  private Scene sugarCaneField = new SugarCaneField("Sugar cane field");


  public RumRunnerIsle() {
    addScenesToIsland(rumDistillery, abandonedDistillery, crimsonBeachBar, sugarCaneField);

    rumDistillery.connectSouth(sugarCaneField);
    rumDistillery.connectEast(abandonedDistillery);
    sugarCaneField.connectEast(crimsonBeachBar);
    abandonedDistillery.connectSouth(crimsonBeachBar);
  }

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param in
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    String userInput = "";

    currentScene = rumDistillery;

    currentScene.enter(player);

    player.setHasIslandItem(false);

    while (true) {
      userInput = in.nextLine().trim().toLowerCase();

      if (DirectionEnum.isValid(userInput)) {
        System.out.println("You entered the right command!");

        currentScene = currentScene.changeScene(userInput);

        currentScene.enter(player);
      } else {
        System.out.println("Hmmmm it seems you have entered an incorrect command");

      }
    }

  }
}
