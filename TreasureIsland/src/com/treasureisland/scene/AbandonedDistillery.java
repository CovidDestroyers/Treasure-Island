package com.treasureisland.scene;

import com.treasureisland.player.Player;
import java.util.Scanner;

public class AbandonedDistillery extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public AbandonedDistillery(String sceneName) {
    super(sceneName);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param in
   * @param player
   * @throws InterruptedException
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    setPlayer(player);
  }

  @Override
  public void talkToNPC(Player player) {
    storylineProgression("TI.txt", getSceneName(), "BGStart", "BGEnd");
  }

  @Override
  public void lookAroundLocation(Player player) {
    storylineProgression("TI.txt", getSceneName(), "DSStart", "DSEnd");
    player.setPlayerHealth(player.getPlayerHealth() - 50);
  }

  @Override
  public void investigateArea(Player player) {
    storylineProgression("TI.txt", getSceneName(), "DRStart", "DREnd");
  }

  @Override
  public void vendor() {

  }

}
