package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class SouthendBeachCruces extends Scene {

  public SouthendBeachCruces(String sceneName) {
    super(sceneName);
  }


  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc Southend Beach");
    System.out.println("To unlock the lockpin you need to surrender the stolen item");

    String input = scanner.nextLine();
    if (input.equalsIgnoreCase("goblet")) {
      System.out.println("DING DING DING \n You have unlocked your third treasure piece.");
      player.setHasIslandItem(true);
      storylineProgression("TI.txt",  "FStart", "FStop");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around Southend Beach");
    storylineProgression("TI.txt",  "SHStart", "SHStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating Southend beach");
    storylineProgression("TI.txt",  "GHStart", "GHStop");
  }

  @Override
  public void vendor(Player player) {}
}
