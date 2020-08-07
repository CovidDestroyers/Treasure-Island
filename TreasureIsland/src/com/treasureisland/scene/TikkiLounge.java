package com.treasureisland.scene;

import com.treasureisland.player.Color;
import com.treasureisland.player.Player;
import java.util.Scanner;

public class TikkiLounge extends Scene {
  Scanner in;

  public TikkiLounge(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Player player) throws InterruptedException {
    this.in = in;
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc Tikki lounge");
    System.out.println("I wont talk without the code");

    String input = in.nextLine();
    if (input.equalsIgnoreCase("High Tide")) {
      System.out.println(
          Color.ANSI_BOLD.getValue()
              + "DING DING DING"
              + Color.ANSI_RESET.getValue()
              + "\n You have unlocked your second treasure piece.");
      player.setHasIslandItem(true);
    } else {
      System.out.println(
          "To get the code, you must do side quest talk to npc in \"Ship Graveyard\"");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around Tikki lounge, I ran into Callie ");
    storylineProgression("TI.txt",  "CAStart", "CAStop");
    storylineProgression("TI.txt",  "SAMStart", "SAMStop");
    // TODO: ITEMS -> More keys
    System.out.println("You got one of the keys needed for the Treasure Island");
    player.playerCoinGenerator();
    System.out.println(" ");
    player.setHasIslandItem(true);
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
