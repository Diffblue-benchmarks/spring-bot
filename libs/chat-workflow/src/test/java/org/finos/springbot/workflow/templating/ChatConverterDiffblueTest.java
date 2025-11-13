package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatConverterDiffblueTest {
  /**
   * Test {@link ChatConverter#ChatConverter(int, Rendering, Class[])}.
   *
   * <p>Method under test: {@link ChatConverter#ChatConverter(int, Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new ChatConverter(int, Rendering, Class[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatConverter.<init>(int, Rendering, Class[])"})
  void testNewChatConverter() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    // Act
    ChatConverter<Object> actualChatConverter = new ChatConverter<>(1, r, forNameResult);

    // Assert
    assertEquals(1, actualChatConverter.getPriority());
  }
}
