package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class SugarCaneField extends Scene {

  public SugarCaneField(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Player player) throws InterruptedException {
    System.out.println("You made it to the sugar can fields!");
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("I won't talk without the secret code");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("9999")) {
      System.out.println(
          "DING DING DING \n You have unlocked your first treasure piece. \n awarded the \"An Emerald\"");
      player.playerTreasures.add("An Emerald");
    } else {
      System.out.println("Go away");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "WWStart", "WWEnd");
    player.playerCoinGenerator();
  }

//  @Override
//  public void investigateArea(Player player) {
//    storylineProgression("TI.txt", "SStart", "SEnd");
//    player.setPlayerHealth(player.getPlayerHealth() - 5);
//
//    // TODO decide what we want to do for the key. Will we need an object ArrayList to hold items?
//    player.playerClues.add("some placeholder for the key");
//  }

  @Override
  public void vendor(Player player) {
    player.playerVisitsVendor();
  }
}
