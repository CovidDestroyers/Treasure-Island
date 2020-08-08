package com.treasureisland;

import java.io.Serializable;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

public class OurLogger implements Serializable {
  private static transient final Logger logger = Logger.getLogger("com.treasureisland");

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  // public static void configLogger() {
  //   Handler consoleHandler = null;
  //   Handler fileHandler = null;
  // }

  public static Logger getLogger() {
    return logger;
  };

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */


}
