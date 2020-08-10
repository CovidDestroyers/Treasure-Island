package com.treasureisland.island;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.player.Player;
import com.treasureisland.scene.AbandonedDistillery;
import com.treasureisland.scene.CrimsonBeachBar;
import com.treasureisland.scene.RumDistillery;
import com.treasureisland.scene.Scene;
import com.treasureisland.scene.SugarCaneField;
import java.util.Scanner;

public class RumRunnerIsle extends Island {
  private final transient Scanner scanner = OnlyOneScanner.getTheOneScanner();

  private final Scene rumDistillery = new RumDistillery("Rum Distillery");
  private final Scene abandonedDistillery = new AbandonedDistillery(
    "Abandoned Distillery");
  private final Scene crimsonBeachBar = new CrimsonBeachBar("Crimson Beach Bar");
  private final Scene sugarCaneField = new SugarCaneField("Sugar Cane Field");

  public RumRunnerIsle(String islandName) {
    setName(islandName);
  }

  public RumRunnerIsle() {
    setIslandName("Rum Runner Isle");
    setCurrentScene(rumDistillery);

    rumDistillery.connectSouth(sugarCaneField);
    rumDistillery.connectEast(abandonedDistillery);
    sugarCaneField.connectEast(crimsonBeachBar);
    abandonedDistillery.connectSouth(crimsonBeachBar);

  }


  @Override
  public void talkToNPC(Player player) throws InterruptedException {}

  @Override
  public void lookAroundLocation(Player player) throws InterruptedException {}

  @Override
  public void vendor(Player player) {}


  @Override
  public String toString() {
    return "RumRunnerIsle{" +
      "scanner=" + scanner +
      ", rumDistillery=" + rumDistillery +
      ", abandonedDistillery=" + abandonedDistillery +
      ", crimsonBeachBar=" + crimsonBeachBar +
      ", sugarCaneField=" + sugarCaneField +
      "} " + super.toString();
  }
}
