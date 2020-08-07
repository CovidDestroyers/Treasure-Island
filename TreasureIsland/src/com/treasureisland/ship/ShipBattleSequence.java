package com.treasureisland.ship;

import com.treasureisland.player.Player;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleSequence implements java.io.Serializable {
  public EnemyShip enemyShip = new EnemyShip();
  public PlayerShip playerShip = new PlayerShip();

  public String input;

  public ShipBattleSequence() {}

    public void shipBattleAfterLeavingIsland(Player player, Scanner scanner) throws InterruptedException {
        while(playerShip.getPlayerShipHealth() > 0 && enemyShip.getEnemyShipHealth() > 0){
            System.out.println("You encountered " + enemyShip.getEnemyShipName());
            System.out.println("Would you like to Attack<A> or Defend<D>??");
            input = scanner.nextLine();
            if("a".equalsIgnoreCase(input)){
                playerShip.attackEnemyShip(enemyShip);
                enemyAction(player);
            }
            else if("d".equalsIgnoreCase(input)){
                playerShip.defendPlayerShip(enemyShip,player);
            }
           System.out.println("\n");
            healthStatus();
            System.out.println("\n");

        }
        System.out.println("You defeated " + enemyShip.getEnemyShipName() + "\n\n");
        playerShip.setPlayerShipHealth(100);
        enemyShip.setEnemyShipHealth(100);
    }



    public void enemyAction(Player player) throws InterruptedException {
        Random rand = new Random();
        int result = rand.nextInt(10 - 1) + 1;
        if(enemyShip.getEnemyShipHealth() > 0){
            if(result > 0 && result <=7){
                enemyShip.attackPlayerShip(playerShip, player);
            }
            if(result > 7){
                enemyShip.defendEnemyShip(playerShip);
            }
        }
    }

  public void healthStatus() {
    System.out.println(
        "\n" + playerShip.getPlayerShipName() + ": " + playerShip.getPlayerShipHealth());
    System.out.println("\n" + enemyShip.getEnemyShipName() + ": " + enemyShip.getEnemyShipHealth());
  }
}
