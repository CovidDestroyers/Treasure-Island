package com.treasureisland.island;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.SaveLoadGame;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.SugarCaneField;
import java.util.Scanner;

public class RumRunnerIsle extends Island {
  private final transient Scanner scanner = OnlyOneScanner.getTheOneScanner();

  private final Scene rumDistillery = new RumDistillery("Rum Distillery");
  private final Scene abandonedDistillery = new AbandonedDistillery("Abandoned distillery");
  private final Scene crimsonBeachBar = new CrimsonBeachBar("Crimson Beach Bar");
  private final Scene sugarCaneField = new SugarCaneField("Sugar cane field");

  public RumRunnerIsle() {
    setIslandName("rumRunnerisle");
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
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Player player) throws InterruptedException {
    String userInput = "";

    currentScene = rumDistillery;

    currentScene.enter(player, getIslandName());

    while (!player.getHasIslandItem()) {
      System.out.println(this.directionOptions);
      userInput = scanner.nextLine().trim().toLowerCase();
      player.setHasIslandItem(false);

      if ("save".equals(userInput)) {
        SaveLoadGame.saveGame();
        System.out.println("We saved your game state!!");
        System.out.println(
            "But You cannot run forever my friend."
                + Color.ANSI_RED.getValue()
                + " Black Beard "
                + Color.ANSI_RESET.getValue()
                + "will find you!!!");
        System.out.println("Sleep well for it may be your last night.");
        System.out.println("Goodbye for now.");
        System.exit(0);

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
        System.out.println("Please try again...");
      }
    }
  }
}
