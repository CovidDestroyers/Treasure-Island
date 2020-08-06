package com.treasureisland.player;

import java.util.Random;
import java.util.Scanner;

public class PirateFightSequence {

  /*
   * =============================================
   * ============= Variable Declarations =========
   * =============================================
   */
  public Pirate pirate = Pirate.getInstance();

  public transient Scanner scanner = new Scanner(System.in);
  public String input;
  private static final PirateFightSequence pirateFightSequence = new PirateFightSequence();


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  private PirateFightSequence(){ }

  public static PirateFightSequence getInstance(){
    return pirateFightSequence;
  }


  /*
   * =============================================
   * ============= Business Methods ================
   * =============================================
   */
  public void PlayerAndPirateFightSequence(Player player){
      while(player.getPlayerHealth() > 0 && pirate.getPirateHealth() > 0){
        System.out.println("You encountered " + pirate.getPirateName());
        System.out.println("Would you like to Attack<A> or Defend<D>??");
        input = scanner.nextLine();
        if("a".equalsIgnoreCase(input)){
          player.attackPirate(pirate);
          enemyAction(player);
        }
        else if("d".equalsIgnoreCase(input)){
          player.defendPlayer(pirate);
        }
        System.out.println("\n");
        healthStatus(player);
        System.out.println("\n");

      }
      System.out.println("You defeated " + pirate.getPirateName() + "\n\n");
      player.setPlayerHealth(player.getPlayerHealth());
      pirate.setPirateHealth(pirate.getPirateHealth());
  }

  public void enemyAction(Player player){
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
    System.out.println("\n"+player.getPlayerName() + ": " + player.getPlayerHealth());
    System.out.println("\n"+pirate.getPirateName() + ": " + pirate.getPirateHealth());
  }
}
