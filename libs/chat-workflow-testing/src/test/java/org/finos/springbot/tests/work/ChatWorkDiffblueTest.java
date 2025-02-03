package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.testing.content.TestRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ChatWork}
   *   <li>{@link ChatWork#setS(Chat)}
   *   <li>{@link ChatWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.ChatWork.<init>()",
      "org.finos.springbot.workflow.content.Chat org.finos.springbot.tests.work.ChatWork.getS()",
      "void org.finos.springbot.tests.work.ChatWork.setS(org.finos.springbot.workflow.content.Chat)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ChatWork actualChatWork = new ChatWork();
    TestRoom s = new TestRoom("Key", "Name");

    actualChatWork.setS(s);

    // Assert
    assertSame(s, actualChatWork.getS());
  }
}
