package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TeamsStateStorageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsStateStorage.Filter#Filter(String)}
   *   <li>{@link TeamsStateStorage.Filter#toString()}
   * </ul>
   */
  @Test
  void testFilterGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Filter [key=Key, value=tag, operator==]", (new TeamsStateStorage.Filter("Key")).toString());
    assertEquals("Filter [key=Key, value=42, operator=Operator]",
        (new TeamsStateStorage.Filter("Key", "42", "Operator")).toString());
  }
}
