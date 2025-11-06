package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestObject#TestObject()}
   *   <li>{@link TestObject#setAskAxed(boolean)}
   *   <li>{@link TestObject#setAskQty(Number)}
   *   <li>{@link TestObject#setBidAxed(boolean)}
   *   <li>{@link TestObject#setBidQty(Number)}
   *   <li>{@link TestObject#setCreator(String)}
   *   <li>{@link TestObject#setIsin(String)}
   *   <li>{@link TestObject#toString()}
   *   <li>{@link TestObject#getAskQty()}
   *   <li>{@link TestObject#getBidQty()}
   *   <li>{@link TestObject#getCreator()}
   *   <li>{@link TestObject#getIsin()}
   *   <li>{@link TestObject#isAskAxed()}
   *   <li>{@link TestObject#isBidAxed()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TestObject actualTestObject = new TestObject();
    actualTestObject.setAskAxed(true);
    actualTestObject.setAskQty(Integer.valueOf(1));
    actualTestObject.setBidAxed(true);
    Integer bidQty = Integer.valueOf(1);
    actualTestObject.setBidQty(bidQty);
    actualTestObject.setCreator("Creator");
    actualTestObject.setIsin("Isin");
    String actualToStringResult = actualTestObject.toString();
    Number actualAskQty = actualTestObject.getAskQty();
    Number actualBidQty = actualTestObject.getBidQty();
    String actualCreator = actualTestObject.getCreator();
    String actualIsin = actualTestObject.getIsin();
    boolean actualIsAskAxedResult = actualTestObject.isAskAxed();

    // Assert that nothing has changed
    assertEquals("Creator", actualCreator);
    assertEquals("Isin", actualIsin);
    assertEquals("TestObject [isin=Isin, bidAxed=true, askAxed=true, creator=Creator, bidQty=1, askQty=1]",
        actualToStringResult);
    assertTrue(actualIsAskAxedResult);
    assertTrue(actualTestObject.isBidAxed());
    assertSame(bidQty, actualAskQty);
    assertSame(bidQty, actualBidQty);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TestObject#TestObject(String, boolean, boolean, String, Number, Number)}
   *   <li>{@link TestObject#setAskAxed(boolean)}
   *   <li>{@link TestObject#setAskQty(Number)}
   *   <li>{@link TestObject#setBidAxed(boolean)}
   *   <li>{@link TestObject#setBidQty(Number)}
   *   <li>{@link TestObject#setCreator(String)}
   *   <li>{@link TestObject#setIsin(String)}
   *   <li>{@link TestObject#toString()}
   *   <li>{@link TestObject#getAskQty()}
   *   <li>{@link TestObject#getBidQty()}
   *   <li>{@link TestObject#getCreator()}
   *   <li>{@link TestObject#getIsin()}
   *   <li>{@link TestObject#isAskAxed()}
   *   <li>{@link TestObject#isBidAxed()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Integer bidAmount = Integer.valueOf(1);

    // Act
    TestObject actualTestObject = new TestObject("Isin", true, true, "Creator", bidAmount, Integer.valueOf(1));
    actualTestObject.setAskAxed(true);
    actualTestObject.setAskQty(Integer.valueOf(1));
    actualTestObject.setBidAxed(true);
    Integer bidQty = Integer.valueOf(1);
    actualTestObject.setBidQty(bidQty);
    actualTestObject.setCreator("Creator");
    actualTestObject.setIsin("Isin");
    String actualToStringResult = actualTestObject.toString();
    Number actualAskQty = actualTestObject.getAskQty();
    Number actualBidQty = actualTestObject.getBidQty();
    String actualCreator = actualTestObject.getCreator();
    String actualIsin = actualTestObject.getIsin();
    boolean actualIsAskAxedResult = actualTestObject.isAskAxed();

    // Assert that nothing has changed
    assertEquals("Creator", actualCreator);
    assertEquals("Isin", actualIsin);
    assertEquals("TestObject [isin=Isin, bidAxed=true, askAxed=true, creator=Creator, bidQty=1, askQty=1]",
        actualToStringResult);
    assertTrue(actualIsAskAxedResult);
    assertTrue(actualTestObject.isBidAxed());
    assertSame(bidQty, actualAskQty);
    assertSame(bidQty, actualBidQty);
  }
}
