package com.treasureisland.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vendor implements java.io.Serializable{

  private final List<Item> vendorItems =
      new ArrayList<>(
          Arrays.asList(
              new Item("Banana", 5, 40),
              new Item("Apple", 3, 35),
              new Item("Rum", 0, 55),
              new Item("Salted meat", 10, 50),
              new Item("Sea biscuits", 2, 35),
              new Item("Ale", 1, 30)));

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

  public void getAll() {
    for (Item item : vendorItems) {
      System.out.println(item.toString());
    }
  }


  public Item findByName(String name) {
    Item result = null;
    for (Item item : vendorItems) {
      if (item.getItemName().equals(name)) {
        result = item;
        break;
      }
    }
    return result;
  }

  public List<Item> getVendorItems() {
    return vendorItems;
  }
}
