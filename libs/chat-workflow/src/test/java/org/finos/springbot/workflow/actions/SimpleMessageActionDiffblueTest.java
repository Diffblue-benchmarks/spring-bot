package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleMessageActionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleMessageAction#SimpleMessageAction(Addressable, User, Message, Object)}
   *   <li>{@link SimpleMessageAction#getAddressable()}
   *   <li>{@link SimpleMessageAction#getData()}
   *   <li>{@link SimpleMessageAction#getMessage()}
   *   <li>{@link SimpleMessageAction#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.actions.SimpleMessageAction.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.User, org.finos.springbot.workflow.content.Message, java.lang.Object)",
      "org.finos.springbot.workflow.content.Addressable org.finos.springbot.workflow.actions.SimpleMessageAction.getAddressable()",
      "java.lang.Object org.finos.springbot.workflow.actions.SimpleMessageAction.getData()",
      "org.finos.springbot.workflow.content.Message org.finos.springbot.workflow.actions.SimpleMessageAction.getMessage()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.workflow.actions.SimpleMessageAction.getUser()"})
  void testGettersAndSetters() {
    // Arrange
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    MessageImpl words = new MessageImpl(new ArrayList<>());

    // Act
    SimpleMessageAction actualSimpleMessageAction = new SimpleMessageAction(a, u, words, "Ej");
    Addressable actualAddressable = actualSimpleMessageAction.getAddressable();
    Object actualData = actualSimpleMessageAction.getData();
    Message actualMessage = actualSimpleMessageAction.getMessage();

    // Assert
    assertEquals("Ej", actualData);
    assertSame(words, actualMessage);
    assertSame(a, actualAddressable);
    assertSame(u, actualSimpleMessageAction.getUser());
  }
}
