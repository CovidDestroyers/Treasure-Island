package com.treasureisland.island;

import com.treasureisland.player.Player;
import com.treasureisland.scene.Scene;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Island implements Serializable {
  protected Island islandToTheNorth;
  protected Island islandToTheSouth;
  protected Island islandToTheEast;
  protected Island islandToTheWest;


  protected Scene currentScene;
  protected List<Scene> scenesOnIsland = new ArrayList<>();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Island() {}

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void addScenesToIsland(Scene... scenes) {
    try {
      scenesOnIsland.addAll(Arrays.asList(scenes));
    } catch (Exception e) {
      System.out.println("Something broke :`(");
      e.printStackTrace();
    }
  }

  /**
   * The entry point into all scene classes. The Game class will call `Scene.enter(in, player);` to
   * start each Scene's story
   *
   * @param in
   * @param player
   * @throws InterruptedException
   */
  public abstract void enter(Scanner in, Player player) throws InterruptedException;

  /**
   * @param direction
   * @return
   */
  public Island changeIsland(String direction) {
    String sanitizedDirection = direction.trim().toLowerCase();
    Island nextIsland = null;

    if ("north".equals(sanitizedDirection)) {
      nextIsland = getIslandToTheNorth();

    } else if ("east".equals(sanitizedDirection)) {
      nextIsland = getIslandToTheEast();

    } else if ("south".equals(sanitizedDirection)) {
      nextIsland = getIslandToTheSouth();

    } else if ("west".equals(sanitizedDirection)) {
      nextIsland = getIslandToTheWest();

    } else {
      System.out.println("Error: unknown direction " + direction);
    }

    if (nextIsland == null) {
      System.out.println("You cannot go " + direction + " from here.");
      nextIsland = this;
    }
    return nextIsland;
  }


  public void connectEast(Island otherIsland) {
    setIslandToTheEast(otherIsland);
    otherIsland.setIslandToTheWest(this);
  }


  public void connectSouth(Island otherIsland) {
    setIslandToTheSouth(otherIsland);
    otherIsland.setIslandToTheNorth(this);
  }



  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */


  public Island getIslandToTheNorth() {
    return islandToTheNorth;
  }

  public void setIslandToTheNorth(Island islandToTheNorth) {
    this.islandToTheNorth = islandToTheNorth;
  }

  public Island getIslandToTheSouth() {
    return islandToTheSouth;
  }

  public void setIslandToTheSouth(Island islandToTheSouth) {
    this.islandToTheSouth = islandToTheSouth;
  }

  public Island getIslandToTheEast() {
    return islandToTheEast;
  }

  public void setIslandToTheEast(Island islandToTheEast) {
    this.islandToTheEast = islandToTheEast;
  }

  public Island getIslandToTheWest() {
    return islandToTheWest;
  }

  public void setIslandToTheWest(Island islandToTheWest) {
    this.islandToTheWest = islandToTheWest;
  }
}
