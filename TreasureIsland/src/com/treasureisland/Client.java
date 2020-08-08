package com.treasureisland;

import java.io.Serializable;

public class Client implements Serializable {
  public static void main(String[] args) throws InterruptedException {
    TreasureIslandGameplay beginGame = TreasureIslandGameplay.getInstance();
    beginGame.start();
  }
}
