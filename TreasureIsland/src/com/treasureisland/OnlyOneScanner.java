package com.treasureisland;

import java.io.Serializable;
import java.util.Scanner;

public class OnlyOneScanner implements Serializable {
  private static Scanner theOneScanner;

  private OnlyOneScanner() {

  }

  public static Scanner getTheOneScanner() {
    if (theOneScanner == null) {
      theOneScanner = new Scanner(System.in);
    }
    return theOneScanner;
  }
}
