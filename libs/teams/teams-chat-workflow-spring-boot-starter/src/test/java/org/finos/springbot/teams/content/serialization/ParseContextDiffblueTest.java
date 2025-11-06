package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
import org.junit.jupiter.api.Test;

class ParseContextDiffblueTest {
  /**
   * Method under test: {@link ParseContext#ParseContext(TeamsAddressable, List)}
   */
  @Test
  void testNewParseContext() {
    // Arrange
    TeamsChannel within = new TeamsChannel("42", "Name");

    // Act and Assert
    assertTrue((new ParseContext(within, new ArrayList<>())).entities.isEmpty());
  }
}
