package com.treasureisland.island;

public enum DirectionEnum {
  N("N"),
  S("S"),
  E("E"),
  W("W"),
  NORTH("NORTH"),
  SOUTH("SOUTH"),
  EAST("EAST"),
  WEST("WEST");

  private String acceptedText;

  DirectionEnum(String acceptedText) {
    this.acceptedText = acceptedText;
  }

  public String getAcceptedText() {
    return this.acceptedText;
  }

  public static Boolean isValid(String userInput) {
    boolean isValid = false;
    if (fromString(userInput) != null) {
      isValid = true;
    }
    return isValid;
  }

  public static DirectionEnum fromString(String acceptedText) {
    DirectionEnum foundDirection = null;

    for (DirectionEnum direction : DirectionEnum.values()) {
      if (direction.acceptedText.equalsIgnoreCase(acceptedText)) {
        foundDirection = direction;
        break;
      }
    }
    return foundDirection;
  }
}
