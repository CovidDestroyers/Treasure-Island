package com.treasureisland.items;

public class Items implements java.io.Serializable{
    public String itemName;
  private String currentWorld;

  private Integer healthValue;
  private Integer cost;

  private final String purpose = "none";
  private final Boolean isAnotherItemNeeded = false;
  private final String nameOfOtherItem = "none";
  private final String whatDoesOtherItemDo = "n/a";
  private final String itemRevealed = "none";

  private final String asciiArt = "none";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Items() {}

  public Items(String itemName) {
    setItemName(itemName);
  }

  public Items(String itemName, Integer healthValue, Integer cost) {
    this(itemName);
    setHealthValue(healthValue);
    setCost(cost);
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

  public void setItemName(String itemName) {
    this.itemName = itemName;
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

  @Override
  public String toString() {
    return " Item = "
        + itemName
        + ", Health Gained = "
        + healthValue
        + ", cost = "
        + cost
        + " gold "
        + "";
  }
}
