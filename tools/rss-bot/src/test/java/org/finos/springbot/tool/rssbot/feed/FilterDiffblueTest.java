package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Filter#setToMatch(String)}
   *   <li>{@link Filter#setUsage(Filter.Type)}
   *   <li>{@link Filter#getToMatch()}
   *   <li>{@link Filter#getUsage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Filter filter = new Filter();

    // Act
    filter.setToMatch("To Match");
    filter.setUsage(Filter.Type.INCLUDE);
    String actualToMatch = filter.getToMatch();

    // Assert that nothing has changed
    assertEquals("To Match", actualToMatch);
    assertEquals(Filter.Type.INCLUDE, filter.getUsage());
  }

  /**
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  void testTest() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("To Match");

    // Act and Assert
    assertTrue(filter.test("foo"));
  }

  /**
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  void testTest2() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("");

    // Act and Assert
    assertFalse(filter.test("foo"));
  }

  /**
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  void testTest3() {
    // Arrange
    Filter filter = new Filter();
    filter.setUsage(Filter.Type.INCLUDE);
    filter.setToMatch("");

    // Act and Assert
    assertTrue(filter.test("foo"));
  }

  /**
   * Method under test: default or parameterless constructor of {@link Filter}
   */
  @Test
  void testNewFilter() {
    // Arrange and Act
    Filter actualFilter = new Filter();

    // Assert
    assertNull(actualFilter.getToMatch());
    assertEquals(Filter.Type.EXCLUDE, actualFilter.getUsage());
  }
}
