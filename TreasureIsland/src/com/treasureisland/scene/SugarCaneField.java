package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
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
      System.out.println("\n "
          + Color.ANSI_BOLD.getValue()
          + Color.ANSI_BLUE.getValue()
          + "DING DING DING"
          + Color.ANSI_RESET.getValue()
          + "\n You have unlocked your first treasure piece."
          + "\n awarded "
          + Color.ANSI_BOLD.getValue()
          + Color.ANSI_RED.getValue()
          + "\"An Emerald\""
          + Color.ANSI_RESET.getValue());
      player.playerTreasures.add("Emerald");
      player.playerInventory.remove(Item.findByName(player.playerInventory, "9"));
      player.playerInventory.remove(Item.findByName(player.playerInventory, "999"));
      player.setHasIslandItem(true);
    } else {
      System.out.println(
        "To get the code, you should look around for the clues.");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt",  "WWStart", "WWEnd");
    storylineProgression("TI.txt", "SStart", "SEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 5);
    System.out.println("\n");
    player.playerCoinGenerator();
    System.out.println("\n");
    player.iterateThroughClues();
    if(Item.findByName(player.playerInventory, "Key") == null) {
      player.playerInventory.add(new Item("Key", 0, 0));
      System.out.println("\n" + Color.ANSI_BLUE.getValue() + "Clue added to your Inventory!!" + Color.ANSI_RESET.getValue());
    }

    // TODO decide what we want to do for the key. Will we need an object ArrayList to hold items?
    //player.playerClues.add("key");
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
