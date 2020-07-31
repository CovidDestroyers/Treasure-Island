package com.treasureisland.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vendor implements java.io.Serializable {

  private static final Vendor item = new Vendor();

  private final List<Items> vendorItems =
      new ArrayList<>(
          Arrays.asList(
              new Items("Banana", 5, 40),
              new Items("Apple", 3, 35),
              new Items("Rum", 0, 55),
              new Items("Salted meat", 10, 50),
              new Items("Sea biscuits", 2, 35),
              new Items("Ale", 1, 30)));

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Vendor() {}

  // public static Vendor getInstance() {
  //  return vendor;
  // }

  public void getAll() {
    for (Items item : vendorItems) {
      System.out.println(item.toString());
    }
  }

  public Items findByName(String name) {
    Items result = null;
    for (Items item : vendorItems) {
      if (item.getItemName().equals(name)) {
        result = item;
        break;
      }
    }
    return result;
  }

  public List<Items> getVendorItems() {
    return vendorItems;
  }
}
