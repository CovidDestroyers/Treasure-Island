package com.treasureisland.map;

import com.treasureisland.OnlyOneScanner;
import com.treasureisland.player.Color;
import com.treasureisland.player.Player;

import java.util.Scanner;


public class MainMap {

  public void mainMap() {

    System.out.println("\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0123456789123456789123456789123456789123456789123456789123456789123456789123456789123"+Color.ANSI_RESET.getValue()+"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1                                                                "+Color.ANSI_GREEN_BACKGROUND.getValue()+"      "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"              "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2                                                                "+Color.ANSI_GREEN_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"             "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3                                                              "+Color.ANSI_GREEN_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4                                                            "+Color.ANSI_GREEN_BACKGROUND.getValue()+"             "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5                                                        "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                            "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"         "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"              "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                        "+Color.ANSI_GREEN_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Port Royal"+Color.ANSI_GREEN_BACKGROUND.getValue() +"     "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"8  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                             "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"9   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                             "+Color.ANSI_GREEN_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"          "+Color.ANSI_BLACK.getValue()+"Isla DeMuentes"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                              "+Color.ANSI_GREEN_BACKGROUND.getValue()+"               "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                   "+Color.ANSI_GREEN_BACKGROUND.getValue()+"        "+Color.ANSI_RESET.getValue()+Color.ANSI_BLUE_BACKGROUND.getValue()+"          "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3                                       "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                  "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                              "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"    "+Color.ANSI_BLACK.getValue()+"Isla Cruces      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"8                 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                            "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"9                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"0              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"     "+Color.ANSI_BLUE_BACKGROUND.getValue()+" "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                       "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"1               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                        "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"2              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"3            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"     "+Color.ANSI_BLACK.getValue()+"Rum Runner   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                      "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"4              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"5            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                   "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                     "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"6               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                      "+Color.ANSI_RESET.getValue() +"\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue()+"7                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                           "+Color.ANSI_RESET.getValue() +"\n" +
      "\n" +      Color.ANSI_RESET.getValue());

    Scanner scanner = OnlyOneScanner.getTheOneScanner();
    System.out.println("Type back to return.");
    scanner.next();
    Player player = new Player();
    player.clearScreen();
  }

  public void rumRunner() {

    System.out.println("\n" +
      Color.ANSI_BLUE_BACKGROUND.getValue() + "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"+Color.ANSI_RESET.getValue()+"\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                                                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                           "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                                              "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                         "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3                                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4                                        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                             "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                      "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                                     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                 "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                                   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"           Rum Distillery            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
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
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0                                 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        Abandon        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                        Distillery     "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2                                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3                               "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                          "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4                            "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                            "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6                           "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"    Sugar Cane Field                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7                          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8                          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                         "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                        "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9                      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                          "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0                  "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                         .-'-'-.-,._              "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                       "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1             "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                          _.-'        ~  '               "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                     "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "2          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                          .-'  ~   ~   _ _.-'                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "3        "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                            '-._,.-'._.-'-'                      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "4      "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                  "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "5     "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                    "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "6   "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                      "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                  "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "7"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "8"+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                                        "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                   "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "9 "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                              Crimson Beach Bar                       "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                    "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "0          "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                           "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                      "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "1                    "+Color.ANSI_YELLOW_BACKGROUND.getValue()+"                                                "+Color.ANSI_BLUE_BACKGROUND.getValue()+"                       "+Color.ANSI_RESET.getValue()+ "\n"+
      Color.ANSI_BLUE_BACKGROUND.getValue() + "                         "+Color.ANSI_BLACK.getValue()+"Rum Runner Isla"+Color.ANSI_BLUE_BACKGROUND.getValue()+"                                                    "+Color.ANSI_RESET.getValue()+ "\n"+
      "\n" +
      Color.ANSI_RESET.getValue());

    Scanner scanner = OnlyOneScanner.getTheOneScanner();
    System.out.println("Type back to return.");
    scanner.next();
    Player player = new Player();
    player.clearScreen();

  }


  public void portRoyal() {

    System.out.println("\n" + Color.ANSI_BLUE.getValue()+ "                 " +
      "                                    XXX\n" +
      "                                 XXX  XXXXX\n" +
      "                              XXXX        XXXX\n" +
      "                            XXX    Royal     XX\n" +
      "                          XXX      Lodge      XX\n" +
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
      "   X  Tikki                                          X\n" +
      "   X  Lounge                              Sunset     X\n" +
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
      "Port Royal     XXXX                           XX\n" +
      "                  XX                        XXX\n" +
      "                    XX    Ship Graveyard   XX\n" +
      "                     XXXXXXXXXXXXXXXXXXXXXX\n" + "\n" +
      Color.ANSI_RESET.getValue());
  }


  public void deMuerta() {

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
  }


  public void islaCruces() {

    System.out.println("\n" + Color.ANSI_BLUE.getValue()+
      "                        XXXXXXXXXXXXXXXXXX\n" +
      "                  XXXXX                XXXXXX\n" +
      "             XXXXX                           XXXXXX\n" +
      "          XXXX                                    XXX\n" +
      "       XXXX           Church                        XXXXX\n" +
      "      XX                                                 XXX\n" +
      "    XX                                                      XXX\n" +
      "   X                                                           XXX\n" +
      "  X                                                               XX\n" +
      " X                                                                  XXX\n" +
      " X                                                                     XXX\n" +
      " X                                                                        XXXXX\n" +
      " X                                                                             XXXXX\n" +
      "X                                                                                  XX\n" +
      "X   Double Cross                                                                    X\n" +
      "X                                                                                    X\n" +
      "X                                                                                    X\n" +
      "X                                                                                    X\n" +
      "X                                                                Saints Lodge        X\n" +
      "X                                                                                    X\n" +
      "X                                                                                    X\n" +
      "X                                                                                   X\n" +
      "X                                                                                   X\n" +
      "XX                                                                                  X\n" +
      " X                                                                                 X\n" +
      " X                                                                                XX\n" +
      " XX                                                                               X\n" +
      "  XX                                                                             X\n" +
      "   XX                                                                            X\n" +
      "    XX                                                                          X\n" +
      "      XX                                                                       XX\n" +
      "       XXX                                                   XXXXXXXXXXXXXXXXXXX\n" +
      "         XXX             South End Beach              XXXXXXXX\n" +
      "            XXX                                  XXXXXX\n" +
      "               XXX                         XXXXXX\n" +
      "                  XXXXX                  XX         Isla Cruces\n" +
      "                       XXXXXXXX        XX\n" +
      "                              XXXXXXXXX\n "   +   "\n" +
      Color.ANSI_RESET.getValue());
  }


}
