package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class WordDiffblueTest {
  /**
   * Method under test: {@link Word#of(String)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    Word actualOfResult = Word.of("foo");

    // Assert
    assertEquals("foo", actualOfResult.getText());
    assertEquals("foo", actualOfResult.getIdentifier());
  }
}
