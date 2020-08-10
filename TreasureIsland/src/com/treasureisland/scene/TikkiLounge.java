package com.treasureisland.scene;

import com.treasureisland.items.Item;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import java.util.Scanner;

public class TikkiLounge extends Scene {
  public TikkiLounge(String sceneName) {
    super(sceneName);
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Wanted to talk to Tony at Tikki lounge but he said I won't talk without the secret code");
    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("High Tide 101")) {
        System.out.println("\n "
          + Color.ANSI_BOLD.getValue()
          + Color.ANSI_BLUE.getValue()
          + "DING DING DING"
          + Color.ANSI_RESET.getValue()
          + "\n You have unlocked your second treasure piece."
          + "\n awarded "
          + Color.ANSI_BOLD.getValue()
          + Color.ANSI_RED.getValue()
          + "\"Sacred Jewel\""
          + Color.ANSI_RESET.getValue());
          player.playerTreasures.add("Sacred Jewel");
          player.playerInventory.remove(Item.findByName(player.playerInventory, "High Tide"));
          player.playerInventory.remove(Item.findByName(player.playerInventory, "101"));
          player.setHasIslandItem(true);
    } else {
      System.out.println(
          "To get the code, you should look around for the clues.");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around Tikki lounge, I ran into Callie ");
    storylineProgression("TI.txt",  "CAStart", "CAStop");
    storylineProgression("TI.txt",  "SAMStart", "SAMStop");
    // TODO: ITEMS -> More keys
    //System.out.println("You got one of the keys needed for the Treasure Island");
    player.playerCoinGenerator();
    System.out.println(" ");
    player.setHasIslandItem(true);
    System.out.println("\n");
    player.iterateThroughClues();
  }

//  @Override
//  public void investigateArea(Player player) {
//    System.out.println("Investigating Tikki lounge, I ran into Sam.");
//    storylineProgression("TI.txt",  "SAMStart", "SAMStop");
//    // TODO: ITEMS -> More keys
//    System.out.println("You got one of the keys needed for the Treasure Island");
//    player.playerCoinGenerator();
//    player.setHasIslandItem(true);
//  }

  @Override
  public void vendor(Player player) {
    player.playerVisitsVendor();
  }
}
