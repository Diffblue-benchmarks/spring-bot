package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.testing.content.TestRoom;
import org.finos.springbot.workflow.content.Chat;
import org.junit.jupiter.api.Test;

class ChatWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ChatWork}
   *   <li>{@link ChatWork#setS(Chat)}
   *   <li>{@link ChatWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ChatWork actualChatWork = new ChatWork();
    TestRoom s = new TestRoom("Key", "Name");

    actualChatWork.setS(s);

    // Assert that nothing has changed
    assertSame(s, actualChatWork.getS());
  }
}
