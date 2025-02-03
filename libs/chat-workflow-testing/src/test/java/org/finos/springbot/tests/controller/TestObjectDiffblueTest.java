package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestObjectDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.controller.TestObject.<init>()",
      "void org.finos.springbot.tests.controller.TestObject.<init>(java.lang.String, boolean, boolean, java.lang.String, java.lang.Number, java.lang.Number)",
      "java.lang.Number org.finos.springbot.tests.controller.TestObject.getAskQty()",
      "java.lang.Number org.finos.springbot.tests.controller.TestObject.getBidQty()",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.getCreator()",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.getIsin()",
      "boolean org.finos.springbot.tests.controller.TestObject.isAskAxed()",
      "boolean org.finos.springbot.tests.controller.TestObject.isBidAxed()",
      "void org.finos.springbot.tests.controller.TestObject.setAskAxed(boolean)",
      "void org.finos.springbot.tests.controller.TestObject.setAskQty(java.lang.Number)",
      "void org.finos.springbot.tests.controller.TestObject.setBidAxed(boolean)",
      "void org.finos.springbot.tests.controller.TestObject.setBidQty(java.lang.Number)",
      "void org.finos.springbot.tests.controller.TestObject.setCreator(java.lang.String)",
      "void org.finos.springbot.tests.controller.TestObject.setIsin(java.lang.String)",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.toString()"})
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

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Isin}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TestObject#TestObject(String, boolean, boolean, String, Number, Number)}
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
  @DisplayName("Test getters and setters; when 'Isin'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.controller.TestObject.<init>()",
      "void org.finos.springbot.tests.controller.TestObject.<init>(java.lang.String, boolean, boolean, java.lang.String, java.lang.Number, java.lang.Number)",
      "java.lang.Number org.finos.springbot.tests.controller.TestObject.getAskQty()",
      "java.lang.Number org.finos.springbot.tests.controller.TestObject.getBidQty()",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.getCreator()",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.getIsin()",
      "boolean org.finos.springbot.tests.controller.TestObject.isAskAxed()",
      "boolean org.finos.springbot.tests.controller.TestObject.isBidAxed()",
      "void org.finos.springbot.tests.controller.TestObject.setAskAxed(boolean)",
      "void org.finos.springbot.tests.controller.TestObject.setAskQty(java.lang.Number)",
      "void org.finos.springbot.tests.controller.TestObject.setBidAxed(boolean)",
      "void org.finos.springbot.tests.controller.TestObject.setBidQty(java.lang.Number)",
      "void org.finos.springbot.tests.controller.TestObject.setCreator(java.lang.String)",
      "void org.finos.springbot.tests.controller.TestObject.setIsin(java.lang.String)",
      "java.lang.String org.finos.springbot.tests.controller.TestObject.toString()"})
  void testGettersAndSetters_whenIsin() {
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

    // Assert
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
