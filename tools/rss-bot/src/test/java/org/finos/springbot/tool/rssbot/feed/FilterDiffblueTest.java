package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tool.rssbot.feed.Filter.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FilterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Filter#setToMatch(String)}
   *   <li>{@link Filter#setUsage(Type)}
   *   <li>{@link Filter#getToMatch()}
   *   <li>{@link Filter#getUsage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String Filter.getToMatch()",
    "Type Filter.getUsage()",
    "void Filter.setToMatch(String)",
    "void Filter.setUsage(Type)"
  })
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
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) ToMatch is empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName(
      "Test test(String) with 'String'; given Filter (default constructor) ToMatch is empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Filter.test(String)"})
  void testTestWithString_givenFilterToMatchIsEmptyString_thenReturnFalse() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("");

    // Act and Assert
    assertFalse(filter.test("foo"));
  }

  /**
   * Test {@link Filter#test(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) ToMatch is {@code To Match}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName(
      "Test test(String) with 'String'; given Filter (default constructor) ToMatch is 'To Match'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Filter.test(String)"})
  void testTestWithString_givenFilterToMatchIsToMatch_thenReturnTrue() {
    // Arrange
    Filter filter = new Filter();
    filter.setToMatch("To Match");

    // Act and Assert
    assertTrue(filter.test("foo"));
  }

  /**
   * Test {@link Filter#test(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link Filter} (default constructor) Usage is {@code INCLUDE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#test(String)}
   */
  @Test
  @DisplayName(
      "Test test(String) with 'String'; given Filter (default constructor) Usage is 'INCLUDE'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Filter.test(String)"})
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
   *
   * <p>Method under test: default or parameterless constructor of {@link Filter}
   */
  @Test
  @DisplayName("Test new Filter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Filter.<init>()"})
  void testNewFilter() {
    // Arrange and Act
    Filter actualFilter = new Filter();

    // Assert
    assertNull(actualFilter.getToMatch());
    assertEquals(Type.EXCLUDE, actualFilter.getUsage());
  }
}
