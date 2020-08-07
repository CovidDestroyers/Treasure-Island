package com.treasureisland.items;

import com.treasureisland.TreasureIslandGameplay;
import com.treasureisland.player.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vendor implements Serializable {
  private String vendorFirstName = "Nazim";
  private String vendorLastName = "Lassrin";
  private String input;

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

  // player purchase items from Vendor and that adds to inventory
  public void purchaseItems(Scanner in, Player player, String item)
  {
      Item findItem = Item.findByName(vendorItems, item.trim().toLowerCase());
      if(findItem != null){
        // buy item from vendor using coins and add to inventory
        itemManager(in, player,findItem);
      } else {
        System.out.println("You can't buy that item!!");
      }
  }

  // Item manager to check Player can afford item or not
  public void itemManager(Scanner in, Player player, Item item) {
      Integer playerCoins = player.getPlayerCoins();
      Integer coins = item.getCost();
      if (playerCoins - coins <= 0) {
        System.out.println("You can not afford this item");
        System.out.println("\nWould you like to purchase again?\n -Type \"Y\": Yes\n -Type \"N\": No");

        input = in.nextLine().trim().toLowerCase();

        if ("y".equals(input) || "yes".equals(input)) {
          System.out.println("\nSimply type the name of the item you want and press \"enter\".\n");
          printVendorItems();
          input = in.nextLine().trim();
          purchaseItems(in, player, input);
        } else if ("n".equals(input) || "no".equals(input)) {
          System.out.println("Thank you for visiting my shop!!");
          player.playerInfoConsoleOutput();
        } else {
          System.out.println("Invalid input, please try again.");
        }
      } else {
        player.setPlayerCoins(playerCoins - coins);
        System.out.println("You bought " + item.getItemName());
        System.out.println(
          "You spent " + coins + " gold. You now have " + player.getPlayerCoins() + " gold.");

        // add to Player Inventory
        player.playerInventory.add(item);
        System.out.println("Your Purchase added to Inventory to use whenever you need!!");
        player.playerInfoConsoleOutput();
      }
  }

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

//  public void playerPurchase() {
//    System.out.println("\nWhat would you like to buy?");
//    input = scanner.nextLine().trim();
//    switch (input.toLowerCase()) {
//      case "banana":
//      case "b":
//        System.out.println("You bought a banana");
//        this.setPlayerHealth(
//            this.getPlayerHealth() + vendor.findByName("banana").getHealthValue());
//        this.itemManager(vendor.findByName("banana").getCost());
//        break;
//
//      case "apple":
//      case "ap":
//        Item anApple = vendor.findByName("apple");
//        System.out.println("bought apple");
//        this.setPlayerHealth(this.getPlayerHealth() + anApple.getHealthValue());
//
//        this.itemManager(anApple.getCost());
//        break;
//
//      case "rum":
//      case "r":
//        System.out.println("bought rum");
//        this.setPlayerHealth(
//            this.getPlayerHealth() + vendor.findByName("rum").getHealthValue());
//        this.itemManager(vendor.findByName("rum").getCost());
//        break;
//
//      case "salted meat":
//      case "sm":
//        this.setPlayerHealth(
//            this.getPlayerHealth() + vendor.findByName("salted meat").getHealthValue());
//        this.itemManager(vendor.findByName("salted meat").getCost());
//
//        System.out.println("You bought some salted meat! Would you like some ale to wash it down?");
//        break;
//
//      case "sea biscuits":
//      case "sb":
//        this.setPlayerHealth(
//            this.getPlayerHealth() + vendor.findByName("sea biscuits").getHealthValue());
//        this.itemManager(vendor.findByName("sea biscuits").getCost());
//
//        System.out.println("You bought a delicious sea biscut!");
//        break;
//
//      case "ale":
//      case "al":
//        this.setPlayerHealth(
//            this.getPlayerHealth() + vendor.findByName("ale").getHealthValue());
//        this.itemManager(vendor.findByName("ale").getCost());
//
//        System.out.println("You bought some ale! Don't sail and drink!");
//        break;
//
//      default:
//        System.out.println("Invalid input");
//        playerPurchase();
//        break;
//    }
//  }
