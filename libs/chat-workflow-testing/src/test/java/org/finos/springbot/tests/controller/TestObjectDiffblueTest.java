package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestObjectDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestObject#TestObject()}
   *   <li>{@link TestObject#setAskAxed(boolean)}
   *   <li>{@link TestObject#setAskQty(Number)}
   *   <li>{@link TestObject#setBidAxed(boolean)}
   *   <li>{@link TestObject#setBidQty(Number)}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestObject.<init>()",
    "void TestObject.<init>(String, boolean, boolean, String, Number, Number)",
    "Number TestObject.getAskQty()",
    "Number TestObject.getBidQty()",
    "String TestObject.getCreator()",
    "String TestObject.getIsin()",
    "boolean TestObject.isAskAxed()",
    "boolean TestObject.isBidAxed()",
    "void TestObject.setAskAxed(boolean)",
    "void TestObject.setAskQty(Number)",
    "void TestObject.setBidAxed(boolean)",
    "void TestObject.setBidQty(Number)",
    "void TestObject.setCreator(String)",
    "void TestObject.setIsin(String)",
    "String TestObject.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TestObject actualTestObject = new TestObject();
    actualTestObject.setAskAxed(true);
    actualTestObject.setAskQty(Integer.valueOf(1));
    actualTestObject.setBidAxed(true);
    Integer bidQty = Integer.valueOf(1);
    actualTestObject.setBidQty(bidQty);
    String actualToStringResult = actualTestObject.toString();
    Number actualAskQty = actualTestObject.getAskQty();
    Number actualBidQty = actualTestObject.getBidQty();
    String actualCreator = actualTestObject.getCreator();
    String actualIsin = actualTestObject.getIsin();
    boolean actualIsAskAxedResult = actualTestObject.isAskAxed();

    // Assert
    assertEquals(
        "TestObject [isin=null, bidAxed=true, askAxed=true, creator=null, bidQty=1, askQty=1]",
        actualToStringResult);
    assertNull(actualCreator);
    assertNull(actualIsin);
    assertTrue(actualIsAskAxedResult);
    assertTrue(actualTestObject.isBidAxed());
    assertSame(bidQty, actualAskQty);
    assertSame(bidQty, actualBidQty);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Isin}.
   *   <li>Then return {@code Creator}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestObject#TestObject(String, boolean, boolean, String, Number, Number)}
   *   <li>{@link TestObject#setAskAxed(boolean)}
   *   <li>{@link TestObject#setAskQty(Number)}
   *   <li>{@link TestObject#setBidAxed(boolean)}
   *   <li>{@link TestObject#setBidQty(Number)}
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
  @DisplayName("Test getters and setters; when 'Isin'; then return 'Creator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestObject.<init>()",
    "void TestObject.<init>(String, boolean, boolean, String, Number, Number)",
    "Number TestObject.getAskQty()",
    "Number TestObject.getBidQty()",
    "String TestObject.getCreator()",
    "String TestObject.getIsin()",
    "boolean TestObject.isAskAxed()",
    "boolean TestObject.isBidAxed()",
    "void TestObject.setAskAxed(boolean)",
    "void TestObject.setAskQty(Number)",
    "void TestObject.setBidAxed(boolean)",
    "void TestObject.setBidQty(Number)",
    "void TestObject.setCreator(String)",
    "void TestObject.setIsin(String)",
    "String TestObject.toString()"
  })
  void testGettersAndSetters_whenIsin_thenReturnCreator() {
    // Arrange and Act
    TestObject actualTestObject =
        new TestObject("Isin", true, true, "Creator", Integer.valueOf(1), Integer.valueOf(1));
    actualTestObject.setAskAxed(true);
    actualTestObject.setAskQty(Integer.valueOf(1));
    actualTestObject.setBidAxed(true);
    Integer bidQty = Integer.valueOf(1);
    actualTestObject.setBidQty(bidQty);
    String actualToStringResult = actualTestObject.toString();
    Number actualAskQty = actualTestObject.getAskQty();
    Number actualBidQty = actualTestObject.getBidQty();
    String actualCreator = actualTestObject.getCreator();
    String actualIsin = actualTestObject.getIsin();
    boolean actualIsAskAxedResult = actualTestObject.isAskAxed();

    // Assert
    assertEquals("Creator", actualCreator);
    assertEquals("Isin", actualIsin);
    assertEquals(
        "TestObject [isin=Isin, bidAxed=true, askAxed=true, creator=Creator, bidQty=1, askQty=1]",
        actualToStringResult);
    assertTrue(actualIsAskAxedResult);
    assertTrue(actualTestObject.isBidAxed());
    assertSame(bidQty, actualAskQty);
    assertSame(bidQty, actualBidQty);
  }
}
