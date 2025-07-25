package org.finos.springbot.symphony.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyConversationsDiffblueTest {
  /**
   * Test {@link SymphonyConversations#simpleMeta(String, boolean)}.
   *
   * <p>Method under test: {@link SymphonyConversations#simpleMeta(String, boolean)}
   */
  @Test
  @DisplayName("Test simpleMeta(String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SymphonyConversations.simpleMeta(String, boolean)"})
  void testSimpleMeta() {
    // Arrange and Act
    Map<String, Object> actualSimpleMetaResult =
        SymphonyConversations.simpleMeta("The characteristics of someone or something", true);

    // Assert
    assertEquals(2, actualSimpleMetaResult.size());
    assertEquals(
        "The characteristics of someone or something",
        actualSimpleMetaResult.get(SymphonyConversations.ROOM_DESCRIPTION));
    assertTrue((Boolean) actualSimpleMetaResult.get(SymphonyConversations.ROOM_PUBLIC));
  }
}
