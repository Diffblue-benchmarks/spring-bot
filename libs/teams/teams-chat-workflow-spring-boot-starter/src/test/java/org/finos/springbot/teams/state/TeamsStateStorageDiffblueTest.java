package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.teams.state.TeamsStateStorage.Filter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsStateStorageDiffblueTest {
  /**
   * Test Filter getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Filter#Filter(String, String, String)}
   *   <li>{@link Filter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test Filter getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Filter.<init>(String)", "void Filter.<init>(String, String, String)",
      "String Filter.toString()"})
  void testFilterGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Filter [key=Key, value=42, operator=Operator]", (new Filter("Key", "42", "Operator")).toString());
  }

  /**
   * Test Filter getters and setters.
   * <ul>
   *   <li>Then return toString is {@code Filter [key=Key, value=tag, operator==]}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Filter#Filter(String)}
   *   <li>{@link Filter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test Filter getters and setters; then return toString is 'Filter [key=Key, value=tag, operator==]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Filter.<init>(String)", "void Filter.<init>(String, String, String)",
      "String Filter.toString()"})
  void testFilterGettersAndSetters_thenReturnToStringIsFilterKeyKeyValueTagOperator() {
    // Arrange, Act and Assert
    assertEquals("Filter [key=Key, value=tag, operator==]", (new Filter("Key")).toString());
  }
}
