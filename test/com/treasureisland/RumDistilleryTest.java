package com.treasureisland;

import static org.junit.Assert.*;

import com.treasureisland.scene.RumDistillery;

public class RumDistilleryTest {

  @org.junit.Test
  public void testGetLocationName() {
    // Arrange

    var test1 = new RumDistillery();
    //        System.out.println(test1.getLocationName());
    //        OUTPUT: Rum Distillery
    //        // Act
    var expected = test1.getLocationName();
    var actual = "Rum Distillery";
    //        // Assert
    assertEquals(expected, actual);
  }
}