package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;
// TODO "complete" besides deciding if we need a key array, also potentialy adding coins
// TODO decide if there is a vendor or something that coins can be spent. also potential health
// implementation

public class SugarCaneField extends Scene {
  Scanner in = new Scanner(System.in);

  public SugarCaneField(String sceneName) {
    super(sceneName);
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    this.in = in;
  }

  @Override
  public void talkToNPC(Player player) {
    System.out.println("I wont talk without the code");
    String input = in.nextLine();
    if (input.equalsIgnoreCase("9999")) {
      // TODO: ITEMS -> Cane Shard
      System.out.println(
          "DING DING DING \n You have unlocked your first treasure piece. \n awarded the cane shard");
      player.haveIslandItem = true;
    } else {
      System.out.println("Go away");
    }
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "WWStart", "WWEnd");
    player.playerCoinGenerator();
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "SStart", "SEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 5);

    // TODO decide what we want to do for the key. Will we need an object ArrayList to hold items?
    player.playerClues.add("some placeholder for the key");
  }

  @Override
  public void vendor() {
    // player.playerVisitsVendor();
  }

  /*
  public void vendor(){
      sout welcome to my shop
      vendorItems.getAll();
      input selector for vendor items.
      include method to grab item and increase health by amount
      reduce player coins by amount
      possibly include quantity that reduces by one every purchase
  }
   */

}
