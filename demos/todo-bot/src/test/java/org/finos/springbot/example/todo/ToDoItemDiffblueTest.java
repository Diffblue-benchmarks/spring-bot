package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class ToDoItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoItem#ToDoItem()}
   *   <li>{@link ToDoItem#setAssignTo(User)}
   *   <li>{@link ToDoItem#setCreator(User)}
   *   <li>{@link ToDoItem#setDescription(String)}
   *   <li>{@link ToDoItem#setNumber(Integer)}
   *   <li>{@link ToDoItem#setStatus(ToDoItem.Status)}
   *   <li>{@link ToDoItem#getAssignTo()}
   *   <li>{@link ToDoItem#getCreator()}
   *   <li>{@link ToDoItem#getDescription()}
   *   <li>{@link ToDoItem#getNumber()}
   *   <li>{@link ToDoItem#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToDoItem actualToDoItem = new ToDoItem();
    SymphonyUser assignTo = new SymphonyUser(1L);
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator = new SymphonyUser(1L);
    actualToDoItem.setCreator(creator);
    actualToDoItem.setDescription("The characteristics of someone or something");
    actualToDoItem.setNumber(10);
    actualToDoItem.setStatus(ToDoItem.Status.OPEN);
    User actualAssignTo = actualToDoItem.getAssignTo();
    User actualCreator = actualToDoItem.getCreator();
    String actualDescription = actualToDoItem.getDescription();
    Integer actualNumber = actualToDoItem.getNumber();
    ToDoItem.Status actualStatus = actualToDoItem.getStatus();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(10, actualNumber.intValue());
    assertEquals(ToDoItem.Status.OPEN, actualStatus);
    assertSame(assignTo, actualAssignTo);
    assertSame(creator, actualCreator);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoItem#ToDoItem(String, User, User, ToDoItem.Status)}
   *   <li>{@link ToDoItem#setAssignTo(User)}
   *   <li>{@link ToDoItem#setCreator(User)}
   *   <li>{@link ToDoItem#setDescription(String)}
   *   <li>{@link ToDoItem#setNumber(Integer)}
   *   <li>{@link ToDoItem#setStatus(ToDoItem.Status)}
   *   <li>{@link ToDoItem#getAssignTo()}
   *   <li>{@link ToDoItem#getCreator()}
   *   <li>{@link ToDoItem#getDescription()}
   *   <li>{@link ToDoItem#getNumber()}
   *   <li>{@link ToDoItem#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    SymphonyUser creator = new SymphonyUser(1L);

    // Act
    ToDoItem actualToDoItem = new ToDoItem("The characteristics of someone or something", creator, new SymphonyUser(1L),
        ToDoItem.Status.OPEN);
    SymphonyUser assignTo = new SymphonyUser(1L);
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator2 = new SymphonyUser(1L);
    actualToDoItem.setCreator(creator2);
    actualToDoItem.setDescription("The characteristics of someone or something");
    actualToDoItem.setNumber(10);
    actualToDoItem.setStatus(ToDoItem.Status.OPEN);
    User actualAssignTo = actualToDoItem.getAssignTo();
    User actualCreator = actualToDoItem.getCreator();
    String actualDescription = actualToDoItem.getDescription();
    Integer actualNumber = actualToDoItem.getNumber();
    ToDoItem.Status actualStatus = actualToDoItem.getStatus();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(10, actualNumber.intValue());
    assertEquals(ToDoItem.Status.OPEN, actualStatus);
    assertSame(assignTo, actualAssignTo);
    assertSame(creator2, actualCreator);
  }
}
