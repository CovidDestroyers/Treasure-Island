package com.treasureisland.items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vendor implements Serializable {
  private String vendorFirstName = "Nazim";
  private String vendorLastName = "Lassrin";

  private final List<Item> vendorItems =
      new ArrayList<>(
          Arrays.asList(
              new Item("banana", 20, 45),
              new Item("apple", 15, 40),
              new Item("rum", 30, 55),
              new Item("salted meat", 25, 50),
              new Item("sea biscuits", 10, 35),
              new Item("ale", 5, 5)));

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Vendor() {}

  // public static Vendor getInstance() {
  //  return vendor;
  // }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void purchaseItems(Scanner in, String itemName) {}

  public void vendorIntroduction() {
    String welcome =
        String.format(
            "Welcome to my shop! My name is %s %s.\n", getVendorFirstName(), getVendorLastName());
    String instructions =
        "I have many wonderful things you can have, if you have enough coin"
            + ".\nSimply type the name of the item you want and press \"enter\".\n";
    System.out.println(welcome);
    System.out.println(instructions);

    printVendorItems();
  }

  /** Prints all Vendor's Items in a Table */
  public void printVendorItems() {
    String leftAlignFormat = "| %-15s | %-4d   | %-4d  |%n";

    System.out.format("+-----------------+--------+-------+%n");
    System.out.format("| Name            | Health | Cost  |%n");
    System.out.format("+-----------------+--------+-------+%n");

    for (Item item : vendorItems) {
      System.out.printf(leftAlignFormat, item.getItemName(), item.getHealthValue(), item.getCost());
    }
    System.out.format("+-----------------+--------+-------+%n\n");
  }

  public Item findByName(String itemName) {
    Item result = null;
    String nameOfItem = itemName.trim().toLowerCase();
    for (Item item : vendorItems) {
      if (nameOfItem.equals(item.getItemName())) {
        result = item;
        break;
      }
    }
    return result;
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setVendorFirstName(String vendorFirstName) {
    this.vendorFirstName = vendorFirstName;
  }

  public void setVendorLastName(String vendorLastName) {
    this.vendorLastName = vendorLastName;
  }

  // GET METHODS
  public String getVendorFirstName() {
    return vendorFirstName;
  }

  public String getVendorLastName() {
    return vendorLastName;
  }

  public List<Item> getVendorItems() {
    return vendorItems;
  }
}
