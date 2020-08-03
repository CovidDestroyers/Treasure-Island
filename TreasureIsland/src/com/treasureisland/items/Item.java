package com.treasureisland.items;

import java.io.Serializable;

public class Item implements Serializable {
  private String itemName;
  private String currentWorld;

  private Integer healthValue;
  private Integer cost;

  private Boolean isAnotherItemNeeded = false;
  private String purpose = "none";
  private String nameOfOtherItem = "none";
  private String whatDoesOtherItemDo = "n/a";
  private String itemRevealed = "none";
  private String asciiArt = "none";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Item() {}

  public Item(String itemName) {
    setItemName(itemName);
  }

  public Item(String itemName, Integer healthValue, Integer cost) {
    this(itemName);
    setHealthValue(healthValue);
    setCost(cost);
  }

  public Item(String itemName, Integer healthValue, Integer cost, String currentWorld) {
    this(itemName, healthValue, cost);
    setCurrentWorld(currentWorld);
  }

  public Item(
      String itemName,
      Integer healthValue,
      Integer cost,
      String currentWorld,
      Boolean isAnotherItemNeeded) {
    this(itemName, healthValue, cost, currentWorld);
    setAnotherItemNeeded(isAnotherItemNeeded);
  }

  public Item(
      String itemName,
      Integer healthValue,
      Integer cost,
      String currentWorld,
      Boolean isAnotherItemNeeded,
      String nameOfOtherItem) {
    this(itemName, healthValue, cost, currentWorld, isAnotherItemNeeded);
    setNameOfOtherItem(nameOfOtherItem);
  }

  public Item(
      String itemName,
      Integer healthValue,
      Integer cost,
      String currentWorld,
      Boolean isAnotherItemNeeded,
      String nameOfOtherItem,
      String itemRevealed) {
    this(itemName, healthValue, cost, currentWorld, isAnotherItemNeeded, nameOfOtherItem);
    setItemRevealed(itemRevealed);
  }

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

  public String getItemName() {
    return itemName;
  }

  // SET METHODS
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getCurrentWorld() {
    return currentWorld;
  }

  public void setCurrentWorld(String currentWorld) {
    this.currentWorld = currentWorld;
  }

  public Integer getHealthValue() {
    return healthValue;
  }

  public void setHealthValue(Integer healthValue) {
    this.healthValue = healthValue;
  }

  public Integer getCost() {
    return cost;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  // GET METHODS

  public Boolean getAnotherItemNeeded() {
    return isAnotherItemNeeded;
  }

  public void setAnotherItemNeeded(Boolean anotherItemNeeded) {
    isAnotherItemNeeded = anotherItemNeeded;
  }

  public String getNameOfOtherItem() {
    return nameOfOtherItem;
  }

  public void setNameOfOtherItem(String nameOfOtherItem) {
    this.nameOfOtherItem = nameOfOtherItem;
  }

  public String getWhatDoesOtherItemDo() {
    return whatDoesOtherItemDo;
  }

  public void setWhatDoesOtherItemDo(String whatDoesOtherItemDo) {
    this.whatDoesOtherItemDo = whatDoesOtherItemDo;
  }

  public String getItemRevealed() {
    return itemRevealed;
  }

  public void setItemRevealed(String itemRevealed) {
    this.itemRevealed = itemRevealed;
  }

  public String getAsciiArt() {
    return asciiArt;
  }

  public void setAsciiArt(String asciiArt) {
    this.asciiArt = asciiArt;
  }

  @Override
  public String toString() {
    return "Items{"
        + "itemName='"
        + itemName
        + '\''
        + ", currentWorld='"
        + currentWorld
        + '\''
        + ", healthValue="
        + healthValue
        + ", cost="
        + cost
        + ", isAnotherItemNeeded="
        + isAnotherItemNeeded
        + ", purpose='"
        + purpose
        + '\''
        + ", nameOfOtherItem='"
        + nameOfOtherItem
        + '\''
        + ", whatDoesOtherItemDo='"
        + whatDoesOtherItemDo
        + '\''
        + ", itemRevealed='"
        + itemRevealed
        + '\''
        + ", asciiArt='"
        + asciiArt
        + '\''
        + ", anotherItemNeeded="
        + getAnotherItemNeeded()
        + '}';
  }
}
