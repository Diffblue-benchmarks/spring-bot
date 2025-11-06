package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class SimpleMessageActionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SimpleMessageAction#SimpleMessageAction(Addressable, User, Message, Object)}
   *   <li>{@link SimpleMessageAction#getAddressable()}
   *   <li>{@link SimpleMessageAction#getData()}
   *   <li>{@link SimpleMessageAction#getMessage()}
   *   <li>{@link SimpleMessageAction#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Message.MessageImpl words = new Message.MessageImpl(new ArrayList<>());

    // Act
    SimpleMessageAction actualSimpleMessageAction = new SimpleMessageAction(null, null, words, "Ej");
    Addressable actualAddressable = actualSimpleMessageAction.getAddressable();
    Object actualData = actualSimpleMessageAction.getData();
    Message actualMessage = actualSimpleMessageAction.getMessage();

    // Assert
    assertEquals("Ej", actualData);
    assertNull(actualAddressable);
    assertNull(actualSimpleMessageAction.getUser());
    assertSame(words, actualMessage);
  }
}
