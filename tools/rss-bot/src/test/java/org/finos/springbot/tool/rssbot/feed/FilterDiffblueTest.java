package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tool.rssbot.feed.Filter.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FilterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Filter#setToMatch(String)}
   *   <li>{@link Filter#setUsage(Type)}
   *   <li>{@link Filter#getToMatch()}
   *   <li>{@link Filter#getUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.tool.rssbot.feed.Filter.getToMatch()",
      "org.finos.springbot.tool.rssbot.feed.Filter$Type org.finos.springbot.tool.rssbot.feed.Filter.getUsage()",
      "void org.finos.springbot.tool.rssbot.feed.Filter.setToMatch(java.lang.String)",
      "void org.finos.springbot.tool.rssbot.feed.Filter.setUsage(org.finos.springbot.tool.rssbot.feed.Filter$Type)"})
  void testGettersAndSetters() {
    // Arrange
    Filter filter = new Filter();

    // Act
    filter.setToMatch("To Match");
    filter.setUsage(Type.INCLUDE);
    String actualToMatch = filter.getToMatch();

    // Assert
    assertEquals("To Match", actualToMatch);
    assertEquals(Type.INCLUDE, filter.getUsage());
  }

  /**
   * Test {@link Filter#test(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link Filter} (default constructor) ToMatch is empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName("Test test(String) with 'String'; given Filter (default constructor) ToMatch is empty string; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.tool.rssbot.feed.Filter.test(java.lang.String)"})
  void testTestWithString_givenFilterToMatchIsEmptyString_thenReturnFalse() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("");

    // Act and Assert
    assertFalse(filter.test("foo"));
  }

  /**
   * Test {@link Filter#test(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link Filter} (default constructor) ToMatch is {@code To Match}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName("Test test(String) with 'String'; given Filter (default constructor) ToMatch is 'To Match'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.tool.rssbot.feed.Filter.test(java.lang.String)"})
  void testTestWithString_givenFilterToMatchIsToMatch_thenReturnTrue() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("To Match");

    // Act and Assert
    assertTrue(filter.test("foo"));
  }

  /**
   * Test {@link Filter#test(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link Filter} (default constructor) Usage is {@code INCLUDE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName("Test test(String) with 'String'; given Filter (default constructor) Usage is 'INCLUDE'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.tool.rssbot.feed.Filter.test(java.lang.String)"})
  void testTestWithString_givenFilterUsageIsInclude_thenReturnTrue() {
    // Arrange
    Filter filter = new Filter();
    filter.setUsage(Type.INCLUDE);
    filter.setToMatch("");

    // Act and Assert
    assertTrue(filter.test("foo"));
  }

  /**
   * Test new {@link Filter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Filter}
   */
  @Test
  @DisplayName("Test new Filter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.feed.Filter.<init>()"})
  void testNewFilter() {
    // Arrange and Act
    Filter actualFilter = new Filter();

    // Assert
    assertNull(actualFilter.getToMatch());
    assertEquals(Type.EXCLUDE, actualFilter.getUsage());
  }
}
