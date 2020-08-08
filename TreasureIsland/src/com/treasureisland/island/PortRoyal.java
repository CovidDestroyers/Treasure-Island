package com.treasureisland.island;

import com.treasureisland.player.Player;

public class PortRoyal extends Island {

  public PortRoyal() {
    setIslandName("portRoyal");
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
    System.out.println("You made it to Port Royal!");
    try {
      String userInput = "";

      // currentScene = rumDistillery;

      while (!player.getHasIslandItem()) {
        System.out.println(getDirectionOptions());

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
