package com.treasureisland.scene;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.island.DirectionEnum;
import com.treasureisland.player.Player;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Scene implements Serializable {
  protected String sceneName;
  protected String storyFileName = "TI.txt";
  protected Scanner scanner = OnlyOneScanner.getTheOneScanner();

  DirectionEnum direction;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Scene(String sceneName) {
    setSceneName(sceneName);
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
   * @param player
   * @throws InterruptedException
   */
  public abstract void enter(Player player) throws InterruptedException;


  public void talkToNPC(Player player) {

  }

  public void talkToNPC(Player player, String startPosition, String endPosition) {

  }

  public abstract void lookAroundLocation(Player player);

  public abstract void investigateArea(Player player) throws InterruptedException;

  public abstract void vendor(Player player);


  /**
   *
   * @param fileName
   * @param start
   * @param stop
   */
  public void storylineProgression(String fileName, String start, String stop) {
    try {
      File myObj =
          new File(
              System.getProperty("user.dir")
                  + "/TreasureIsland/src/com/treasureisland/text/"
                  + fileName);

      //System.out.println(location);

      Scanner myReader = new Scanner(myObj);
      boolean tokenFound = false;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine().trim();

        if (data.equals(start)) {
          tokenFound = true;
        }

        if (data.equals(stop)) {
          tokenFound = false;
        }

        if ((tokenFound) && (!data.equals(start))) {
          System.out.println(data);
          Thread.sleep(650);
        }
      }

      myReader.close();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // GET METHODS
  public String getSceneName() {
    return sceneName;
  }

  // SET METHODS
  public void setSceneName(String sceneName) {
    this.sceneName = sceneName;
  }

}
