package com.treasureisland;

import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws InterruptedException {
    TreasureIslandGameplay beginGame = TreasureIslandGameplay.getInstance();
    beginGame.start();
  }
}
