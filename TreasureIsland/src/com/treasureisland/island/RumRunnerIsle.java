package com.treasureisland.island;

import com.treasureisland.OnlyOneScanner;
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

  public RumRunnerIsle(String islandName) {
    setName(islandName);
  }

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
    try {

      String userInput = "";

      while (!player.getHasIslandItem()) {
        System.out.println(directionOptions);

        userInput = scanner.nextLine().trim().toLowerCase();

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
          System.out.println("Please try again...");
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Oops! Please try again...");
    }
  }

  @Override
  public void talkToNPC(Player player) throws InterruptedException {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}
}
