package com.treasureisland;

public class Client {
  public static void main(String[] args) throws InterruptedException {
    TreasureIslandGameplay beginGame = TreasureIslandGameplay.getInstance();
    beginGame.customGameplayOptions();
  }
}
