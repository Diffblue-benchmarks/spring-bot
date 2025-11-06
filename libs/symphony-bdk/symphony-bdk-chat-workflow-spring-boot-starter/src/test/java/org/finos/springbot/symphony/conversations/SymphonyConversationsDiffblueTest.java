package org.finos.springbot.symphony.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SymphonyConversationsDiffblueTest {
  /**
   * Method under test: {@link SymphonyConversations#simpleMeta(String, boolean)}
   */
  @Test
  void testSimpleMeta() {
    // Arrange and Act
    Map<String, Object> actualSimpleMetaResult = SymphonyConversations
        .simpleMeta("The characteristics of someone or something", true);

    // Assert
    assertEquals(2, actualSimpleMetaResult.size());
    assertEquals("The characteristics of someone or something",
        actualSimpleMetaResult.get(SymphonyConversations.ROOM_DESCRIPTION));
    assertTrue(actualSimpleMetaResult.containsKey(SymphonyConversations.ROOM_PUBLIC));
  }
}
