package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ChatConverterDiffblueTest {
  /**
   * Method under test:
   * {@link ChatConverter#ChatConverter(int, Rendering, Class[])}
   */
  @Test
  void testNewChatConverter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    ChatConverter<Object> actualChatConverter = new ChatConverter<>(1, null, forNameResult);

    // Assert
    assertEquals(1, actualChatConverter.getPriority());
  }
}
