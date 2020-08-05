package com.treasureisland.island;

import com.treasureisland.world.Scene;

public abstract class Island {
  private Island islandToTheNorth;
  private Island islandToTheSouth;
  private Island islandToTheEast;
  private Island islandToTheWest;

  private Scene northScene;
  private Scene southScene;
  private Scene eastScene;
  private Scene westScene;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /**
   * @param direction
   * @return
   */
  public Island changeIsland(String direction) {
    Island nextIsland = null;

    if ("north".equals(direction)) {
      nextIsland = islandToTheNorth;

    } else if ("east".equals(direction)) {
      nextIsland = islandToTheEast;

    } else if ("south".equals(direction)) {
      nextIsland = islandToTheSouth;

    } else if ("west".equals(direction)) {
      nextIsland = islandToTheWest;

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

  public Scene getNorthScene() {
    return northScene;
  }

  public void setNorthScene(Scene northScene) {
    this.northScene = northScene;
  }

  public Scene getSouthScene() {
    return southScene;
  }

  public void setSouthScene(Scene southScene) {
    this.southScene = southScene;
  }

  public Scene getEastScene() {
    return eastScene;
  }

  public void setEastScene(Scene eastScene) {
    this.eastScene = eastScene;
  }

  public Scene getWestScene() {
    return westScene;
  }

  public void setWestScene(Scene westScene) {
    this.westScene = westScene;
  }
  public Island() { }
}
