package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.function.Supplier;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.SimpleMessageAction;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;
import org.springframework.util.function.SingletonSupplier;

class InRoomAddressingCheckerDiffblueTest {
  /**
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  void testFilter() {
    // Arrange
    Action a = Action.NULL_ACTION;

    // Act and Assert
    assertSame(a, (new InRoomAddressingChecker(null, true)).filter(a));
  }

  /**
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  void testFilter2() {
    // Arrange
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(
        new SingletonSupplier<>((User) null, null), true);

    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertNull(inRoomAddressingChecker.filter(new SimpleMessageAction(null, null, new Message.MessageImpl(c), "Ej")));
  }

  /**
   * Method under test: {@link InRoomAddressingChecker#filter(Action)}
   */
  @Test
  void testFilter3() {
    // Arrange
    InRoomAddressingChecker inRoomAddressingChecker = new InRoomAddressingChecker(
        new SingletonSupplier<>((User) null, null), false);

    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertNull(inRoomAddressingChecker.filter(new SimpleMessageAction(null, null, new Message.MessageImpl(c), "Ej")));
  }

  /**
   * Method under test:
   * {@link InRoomAddressingChecker#InRoomAddressingChecker(Supplier, boolean)}
   */
  @Test
  void testNewInRoomAddressingChecker() {
    // Arrange and Act
    InRoomAddressingChecker actualInRoomAddressingChecker = new InRoomAddressingChecker(null, true);

    // Assert
    assertNull(actualInRoomAddressingChecker.theBot);
    assertTrue(actualInRoomAddressingChecker.allowSlash);
  }
}
