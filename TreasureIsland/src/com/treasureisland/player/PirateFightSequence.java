package com.treasureisland.player;

import com.treasureisland.TreasureIslandGameplay;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.items.Item;

import java.util.Random;
import java.util.Scanner;

public class PirateFightSequence {

  /*
   * =============================================
   * ============= Variable Declarations =========
   * =============================================
   */
  String input;
  public Pirate pirate = Pirate.getInstance();
  public transient Scanner scanner = OnlyOneScanner.getTheOneScanner();
  private static final PirateFightSequence pirateFightSequence = new PirateFightSequence();
  private final TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  private PirateFightSequence() {}

  public static PirateFightSequence getInstance() {
    return pirateFightSequence;
  }

  /*
   * =============================================
   * ============= Business Methods ================
   * =============================================
   */
  public void PlayerAndPirateFightSequence(Player player) throws InterruptedException {
      while(player.getPlayerHealth() > 0 && pirate.getPirateHealth() > 0){
        System.out.println("You encountered '" + Color.ANSI_RED.getValue() + pirate.getPirateName() + Color.ANSI_RESET.getValue() + "'");
        System.out.println("Would you like to Attack<A> or Defend<D>??");
        input = scanner.nextLine();
        if("a".equalsIgnoreCase(input)){
          System.out.println("\n");
          player.attackPirate(pirate);
          enemyAction(player);
        }
        else if("d".equalsIgnoreCase(input)){
          System.out.println("\n");
          player.defendPlayer(pirate);
        }
        healthStatus(player);
        System.out.println("\n");
      }
      player.setPlayerHealth(player.getPlayerHealth());
      pirate.setPirateHealth(pirate.getPirateHealth());
      if (pirate.getPirateHealth() <= 0) {
        System.out.println(Color.ANSI_BLUE.getValue() + "WooooHooo!!! You defeated '" + Color.ANSI_RED.getValue() + pirate.getPirateName() + Color.ANSI_RESET.getValue() +"'\n\n");
        if(Item.findByName(player.playerInventory, "999") == null){
          player.playerInventory.add(new Item("999",0,0));
          System.out.println("\n" + Color.ANSI_BLUE.getValue() + "Clue added to your Inventory!!" + Color.ANSI_RESET.getValue());
        }
        treasureIslandGameplay.setAvailablePirates(player.getCurrentScene().getSceneName());
      }
  }

  public void enemyAction(Player player) throws InterruptedException {
    Random rand = new Random();
    int result = rand.nextInt(10 - 1) + 1;
    if(pirate.getPirateHealth() > 0){
      if(result > 0 && result <=7){
        pirate.attackPlayer(player);
      }
      if(result > 7) {
        pirate.defendPirate(player);
      }
    }
  }

  public void healthStatus(Player player){
    System.out.println("\n"+ Color.ANSI_GREEN.getValue() + player.getPlayerName() + Color.ANSI_RESET.getValue() + ": "  + player.getPlayerHealth());
    System.out.println(Color.ANSI_RED.getValue() + pirate.getPirateName() + Color.ANSI_RESET.getValue() + ": " + pirate.getPirateHealth());
  }
}
