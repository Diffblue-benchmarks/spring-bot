package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ParseContextDiffblueTest {
  /**
   * Test {@link ParseContext#ParseContext(TeamsAddressable, List)}.
   *
   * <p>Method under test: {@link ParseContext#ParseContext(TeamsAddressable, List)}
   */
  @Test
  @DisplayName("Test new ParseContext(TeamsAddressable, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParseContext.<init>(TeamsAddressable, List)"})
  void testNewParseContext() {
    // Arrange
    TeamsAddressable within = mock(TeamsAddressable.class);

    // Act
    ParseContext actualParseContext = new ParseContext(within, new ArrayList<>());

    // Assert
    assertTrue(actualParseContext.entities.isEmpty());
  }
}
