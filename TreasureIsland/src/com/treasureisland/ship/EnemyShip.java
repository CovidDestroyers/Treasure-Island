package com.treasureisland.ship;

import com.treasureisland.player.Player;
import java.util.Random;

public class EnemyShip implements java.io.Serializable {
    public final String enemyShipName = "The Queen Anne's Revenge";
    private   Integer enemyShipHealth = 100;
    public Integer enemyAttackStrength = new Random().nextInt(100);


  public EnemyShip() {}


  public String getEnemyShipName() {
    return enemyShipName;
  }

  public Integer getEnemyShipHealth() {
    return enemyShipHealth;
  }

  public void setEnemyShipHealth(Integer enemyShipHealth) {
    this.enemyShipHealth = enemyShipHealth;
  }

  public void attackPlayerShip(PlayerShip playerShip, Player player) throws InterruptedException {
    System.out.println(
        enemyShipName
            + " attacked "
            + playerShip.getPlayerShipName()
            + " for "
            + enemyAttackStrength
            + " damage.");
    playerShip.setPlayerShipHealth(playerShip.getPlayerShipHealth() - enemyAttackStrength);

    if (playerShip.getPlayerShipHealth() <= 0) {
      player.playerDeathArt();
      player.playerDeathOptions();
    }
  }

  public void defendEnemyShip(PlayerShip playerShip) {
    int result = playerShip.playerAttackStrength - getEnemyShipHealth();
    if (result <= 0) {
      System.out.println(getEnemyShipName() + " did no damage.");
    } else {
      setEnemyShipHealth(getEnemyShipHealth() - result);
      System.out.println(playerShip.getPlayerShipName() + " did " + result + " damage");
    }
  }

  public Integer getEnemyAttackStrength() {
    return enemyAttackStrength;
  }

  public void setEnemyAttackStrength(Integer enemyAttackStrength) {
    this.enemyAttackStrength = enemyAttackStrength;
  }
}
