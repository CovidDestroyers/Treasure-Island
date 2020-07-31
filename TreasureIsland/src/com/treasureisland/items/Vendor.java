package com.treasureisland.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vendor implements java.io.Serializable {

  private final List<Item> vendorItems =
      new ArrayList<>(
          Arrays.asList(
              new Item("banana", 5, 40),
              new Item("apple", 3, 35),
              new Item("rum", 0, 55),
              new Item("salted meat", 10, 50),
              new Item("sea biscuits", 2, 35),
              new Item("ale", 1, 30)));

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

  // TODO: Change this to print out each item in a visually pleasing way
  public void getAll() {
    for (Item item : vendorItems) {
      System.out.println(item.toString());
    }
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

  public List<Item> getAllItems() {
    return vendorItems;
  }
}
