package com.treasureisland.map;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

import java.util.Scanner;


public class MainMap {

  private String input;
  private transient Scanner scanner = OnlyOneScanner.getTheOneScanner();

  public void mainMap() {

    System.out.println("\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0123456789123456789123456789123456789123456789123456789123456789123456789123456789123"+Color.ANSI_RESET.getValue()+"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1                                                                "+Color.ANSI_GREEN_BACKGROUND.getValue()+"      "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"              "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2                                                                "+Color.ANSI_GREEN_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"             "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3                                                              "+Color.ANSI_GREEN_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4                                                            "+Color.ANSI_GREEN_BACKGROUND.getValue()+"             "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5                                                        "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                            "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"         "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"              "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                       "+Color.ANSI_GREEN_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Isle Cruces"+Color.ANSI_GREEN_BACKGROUND.getValue() +"     "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"8  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                             "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"9   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                             "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"          "+Color.ANSI_BLACK.getValue()+"Isle De Muentes"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                              "+Color.ANSI_GREEN_BACKGROUND.getValue()+"              "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                   "+Color.ANSI_GREEN_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3                                       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                  "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                              "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"             "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Port Royal      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"             "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                             "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"8                 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"9                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                      "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+" "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"   "+Color.ANSI_BLACK.getValue()+"Rum Runner Isle  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                    "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                      "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                      "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                           "+Color.ANSI_RESET.getValue() +"\n" +
      "\n" +      Color.ANSI_RESET.getValue());

    Boolean isBack = false;
    while (!isBack) {
      System.out.println("Type \"Back\" to Return.");
      input = scanner.nextLine().trim();
      if ("back".equalsIgnoreCase(input)) {
        isBack = true;
        clearScreen();
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
  }

  public void rumRunner() {

    System.out.println("\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"+Color.ANSI_RESET.getValue()+"\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                                                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                                              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                         "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3                                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4                                        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                      "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"           "+Color.ANSI_BLACK.getValue()+"Rum Distillery            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7                                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8                                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9                          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  ^                          "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                     /X\\                     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                    /   \\                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                   /     \\               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  /       \\               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4                       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                          "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                          "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                       "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7                         "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                              "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8                            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9                                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0                                 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        "+Color.ANSI_BLACK.getValue()+"Abandon        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        "+Color.ANSI_BLACK.getValue()+"Distillery     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3                               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                          "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4                            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Sugar Cane Field                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7                          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8                          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                          "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                         "+Color.ANSI_WHITE_BOLD.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+".-'-'-.-,._"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"              "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                       "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1             "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                          "+Color.ANSI_WHITE_BOLD.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"_.-'        ~  '"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                          "+Color.ANSI_WHITE_BOLD.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+".-'  ~   ~   _ _.-'"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                            "+Color.ANSI_WHITE_BOLD.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"'-._,.-'._.-'-'"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                               "+Color.ANSI_BLACK.getValue()+"Crimson Beach Bar                      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                      "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                       "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "                         "+Color.ANSI_BLACK.getValue()+"Rum Runner Isle"+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                    "+Color.ANSI_RESET.getValue()+ "\n"+
      "\n" +
      Color.ANSI_RESET.getValue());

    Boolean isBack = false;
    while (!isBack) {
      System.out.println("Type \"Back\" to Return.");
      input = scanner.nextLine().trim();
      if ("back".equalsIgnoreCase(input)) {
        isBack = true;
        clearScreen();
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
  }

  public void islaCruces() {

    System.out.println("\n" + Color.ANSI_BLUE.getValue()+
      "0123456789012345678901234567890123456789012345678901234567890                 " +
      "                                    XXX\n" +
      "                                 XXX  XXXXX\n" +
      "                              XXXX        XXXX\n" +
      "                            XXX    Church     XX\n" +
      "                          XXX                  XX\n" +
      "                        XXX                    XXX\n" +
      "                       XX                        X\n" +
      "                      XX                         XX\n" +
      "                    XX                            XX\n" +
      "                  XXX                              X\n" +
      "                XXX                                 X\n" +
      "              XXX                                   X\n" +
      "   XXXXXXXXXXXX                                     XX\n" +
      "   X                                                 X\n" +
      "   X                                                 X\n" +
      "   X  Double                                          X\n" +
      "   X  Cross                                Sunset     X\n" +
      "   XX                                     Restaurant X\n" +
      "    X                                               XX\n" +
      "     X                                              X\n" +
      "     XX                                             X\n" +
      "      X                                             X\n" +
      "      XX                                            X\n" +
      "       X                                           X\n" +
      "        X                                          X\n" +
      "        XX                                        X\n" +
      "         XX                                      XX\n" +
      "           X                                     X\n" +
      "             XX                                 X\n" +
      " Isle Cruces   XXXX                           XX\n" +
      "                  XX                        XXX\n" +
      "                    XX    South End Beach   XX\n" +
      "                     XXXXXXXXXXXXXXXXXXXXXX\n" + "\n" +
      Color.ANSI_RESET.getValue());

    Boolean isBack = false;
    while (!isBack) {
      System.out.println("Type \"Back\" to Return.");
      input = scanner.nextLine().trim();
      if ("back".equalsIgnoreCase(input)) {
        isBack = true;
        clearScreen();
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
  }


  public void islaDeMuerta() {

    System.out.println("\n" + Color.ANSI_BLUE.getValue()+ "          |\n" +
      "      XXXXXXXXX\n" +
      "  XXXX       XXXX\n" +
      " XX             XXXXXX\n" +
      "X                     XXXXXXX\n" +
      "X                            XXXXXXX\n" +
      "X                                  XXXXXXXXXXXXX\n" +
      "X                                              XXXXXX\n" +
      "XX                                 Abandon House    XXXXX\n" +
      " XXX                                                    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
      "   XX                                                                                  XXXXXX\n" +
      "    XXX  Paw Paw Beach                                                                       XXXX\n" +
      "      XX                                                                                        XXX\n" +
      "       XX                                                                                         XXX\n" +
      "         XX                                                                                         X\n" +
      "          XX                                                                                       XX\n" +
      "            XX                                                                                       XX\n" +
      "             XXX                                                           Dusk TIll Dawn Saloon       XX\n" +
      "                XX                                                                                      XX\n" +
      "                 XXX                             Graveyard                                               XX\n" +
      "                   XXX                                       XXXXXXXXXXXX                                 XX\n" +
      "                     XXXXXXXXXXXXXXXXXXXXXXXX                X         XXX                                 X\n" +
      "                                            XXXXXXXXXXXXX   X            XXX                               X\n" +
      "                                                        XXXX              XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n" +
      "\n" +
      "                             Isla DeMuentes\n " +
      Color.ANSI_RESET.getValue());

    Boolean isBack = false;
    while (!isBack) {
      System.out.println("Type \"Back\" to Return.");
      input = scanner.nextLine().trim();
      if ("back".equalsIgnoreCase(input)) {
        isBack = true;
        clearScreen();
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
  }


  public void portRoyal() {

    System.out.println("\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012" +Color.ANSI_BLUE_BACKGROUND.getValue()+Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                         "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                 " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                           " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                              " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                        " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                           " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                      " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                      "+Color.ANSI_BLACK.getValue()+"Royal Lodge"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                   " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                               " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                           " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                            " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                               " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                         " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                  " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                       " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                    " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                         " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                 " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                              " +Color.ANSI_BLUE_BACKGROUND.getValue()+"            " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                   " +Color.ANSI_BLUE_BACKGROUND.getValue()+"       " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                     " +Color.ANSI_BLUE_BACKGROUND.getValue()+"      " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Tikki Lounge"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                 "+Color.ANSI_BLACK.getValue()+"Saints Lodge"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"         " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                      " +Color.ANSI_BLUE_BACKGROUND.getValue()+"     " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                     " +Color.ANSI_BLUE_BACKGROUND.getValue()+"      " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                     " +Color.ANSI_BLUE_BACKGROUND.getValue()+"      " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                     " +Color.ANSI_BLUE_BACKGROUND.getValue()+"      " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                   " +Color.ANSI_BLUE_BACKGROUND.getValue()+"       " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                   " +Color.ANSI_BLUE_BACKGROUND.getValue()+"       " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                  " +Color.ANSI_BLUE_BACKGROUND.getValue()+"        " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                                " +Color.ANSI_BLUE_BACKGROUND.getValue()+"         " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                               " +Color.ANSI_BLUE_BACKGROUND.getValue()+"         " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                              " +Color.ANSI_BLUE_BACKGROUND.getValue()+"         " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                           " +Color.ANSI_BLUE_BACKGROUND.getValue()+"          " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                         " +Color.ANSI_BLUE_BACKGROUND.getValue()+"           " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3         "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                   " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4             "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLACK.getValue()+"Ship Graveyad"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                    " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                  " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                          " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"          "+Color.ANSI_BLACK.getValue()+"Port Royal" +Color.ANSI_BLUE_BACKGROUND.getValue()+"                             " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7                        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  " +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                  " + Color.ANSI_RESET.getValue() + "\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8                               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"         "   +Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                    " + Color.ANSI_RESET.getValue() + "\n");

    Boolean isBack = false;
    while (!isBack) {
      System.out.println("Type \"Back\" to Return.");
      input = scanner.nextLine().trim();
      if ("back".equalsIgnoreCase(input)) {
        isBack = true;
        clearScreen();
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
  }

  // Method to clear the screen
  public void clearScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.println("\b");
    }
  }
}
