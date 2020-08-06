package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class SouthendBeachCruces extends Scene {

  public SouthendBeachCruces(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println("Talking to a npc Southend Beach");
    System.out.println("To unlock the lockpin you need to surrender the stolen item");
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    if (input.equalsIgnoreCase("goblet")) {
      System.out.println("DING DING DING \n You have unlocked your third treasure piece.");
      player.haveIslandItem = true;
      storylineProgression("TI.txt", getSceneName(), "FStart", "FStop");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around Southend Beach");
    storylineProgression("TI.txt", getSceneName(), "SHStart", "SHStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating Southend beach");
    storylineProgression("TI.txt", getSceneName(), "GHStart", "GHStop");
  }

  @Override
  public void vendor() {}
}
