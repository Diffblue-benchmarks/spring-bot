package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MessageDiffblueTest {
  /**
   * Method under test: {@link Message.MessageImpl#buildAnother(List)}
   */
  @Test
  void testMessageImplBuildAnother() {
    // Arrange
    Message.MessageImpl messageImpl = new Message.MessageImpl(new ArrayList<>());

    // Act
    Message actualBuildAnotherResult = messageImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof Message.MessageImpl);
    assertEquals(messageImpl, actualBuildAnotherResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Message.MessageImpl#MessageImpl(List)}
   *   <li>{@link Message.MessageImpl#toString()}
   * </ul>
   */
  @Test
  void testMessageImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    Message.MessageImpl actualMessageImpl = new Message.MessageImpl(c);

    // Assert
    assertEquals("Message [[]]", actualMessageImpl.toString());
    List<Content> contents = actualMessageImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link Message.MessageImpl#rightClass(Object)}
   */
  @Test
  void testMessageImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new Message.MessageImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link Message.MessageImpl#rightClass(Object)}
   */
  @Test
  void testMessageImplRightClass2() {
    // Arrange
    Message.MessageImpl messageImpl = new Message.MessageImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(messageImpl.rightClass(new Message.MessageImpl(new ArrayList<>())));
  }

  /**
   * Method under test: {@link Message#of(List)}
   */
  @Test
  void testOf() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    Message actualOfResult = Message.of(c);

    // Assert
    assertTrue(actualOfResult instanceof Message.MessageImpl);
    assertEquals("", actualOfResult.getText());
    assertEquals(0, actualOfResult.size());
    assertFalse(actualOfResult.iterator().hasNext());
    List<Content> contents = actualOfResult.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }
}
