package com.treasureisland.player;

import java.util.Random;

public class Pirate {

  /*
   * =============================================
   * ========== Variable Declarations =============
   * =============================================
   */
  private static Pirate pirate;
  public Integer pirateHealth = 75;
  public Integer pirateAttackStrength = new Random().nextInt(75);
  public final String pirateName = "Black Beard";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Pirate() {}

  public static Pirate getInstance() {
    if (pirate == null) {
      pirate = new Pirate();
    }
    return pirate;
  }


  /*
   * =============================================
   * ============= Business Methods ==============
   * =============================================
   */
  public void attackPlayer(Player player) {
    System.out.println(
      Color.ANSI_RED.getValue() + getPirateName() + Color.ANSI_RESET.getValue()
        + " attacked "
        + Color.ANSI_GREEN.getValue() + player.getPlayerName() + Color.ANSI_RESET.getValue()
        + " for "
        + pirateAttackStrength
        + " damage.");
    player.setPlayerHealth(player.getPlayerHealth() - pirateAttackStrength);

    if (player.getPlayerHealth() <= 0) {
      player.playerDeathArt();
      player.playerDeathOptions();
    }
  }

  public void defendPirate(Player player) {
    int result = player.playerAttackStrength - getPirateHealth();
    if (result <= 0) {
      System.out.println(Color.ANSI_RED.getValue() + getPirateName() + Color.ANSI_RESET.getValue() + " did no damage.");
    } else {
      setPirateHealth(getPirateHealth() - result);
      System.out.println(Color.ANSI_GREEN.getValue() + player.getPlayerName() + Color.ANSI_RESET.getValue() + " did " + result + " damage");
    }
  }


  /*
   * =============================================
   * ============= Accessor Methods ==============
   * =============================================
   */
  //SET methods
  public void setPirateHealth(Integer pirateHealth) {
    this.pirateHealth = pirateHealth;
  }

  //GET Methods
  public String getPirateName() {
    return pirateName;
  }

  public Integer getPirateHealth() {
    return pirateHealth;
  }
}