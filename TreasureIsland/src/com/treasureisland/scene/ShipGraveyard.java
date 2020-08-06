package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class ShipGraveyard extends Scene {

  public ShipGraveyard(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}

  @Override
  public void talkToNPC(Player player) {
    System.out.println(
        "Talking to npc ship graveyard, I was pointed to check out the biggest ship ");
    storylineProgression("TI.txt", getSceneName(), "SGStart", "SGStop");
  }

  @Override
  public void lookAroundLocation(Player player) {
    System.out.println("Looking around ship graveyard");
    storylineProgression("TI.txt", getSceneName(), "SBStart", "SBStop");
  }

  @Override
  public void investigateArea(Player player) {
    System.out.println("Investigating ship graveyard");
    storylineProgression("TI.txt", getSceneName(), "BBDtart", "BBDStop");
    player.playerCoinGenerator();
  }

  @Override
  public void vendor() {}
}
