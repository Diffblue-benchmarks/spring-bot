package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class MarkupDiffblueTest {
  /**
   * Method under test: {@link Markup#of(String)}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("String", Markup.of("String").getContents());
  }
}
