package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.example.todo.ToDoItem.Status;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToDoItemDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoItem#ToDoItem()}
   *   <li>{@link ToDoItem#setAssignTo(User)}
   *   <li>{@link ToDoItem#setCreator(User)}
   *   <li>{@link ToDoItem#setDescription(String)}
   *   <li>{@link ToDoItem#setNumber(Integer)}
   *   <li>{@link ToDoItem#setStatus(Status)}
   *   <li>{@link ToDoItem#getAssignTo()}
   *   <li>{@link ToDoItem#getCreator()}
   *   <li>{@link ToDoItem#getDescription()}
   *   <li>{@link ToDoItem#getNumber()}
   *   <li>{@link ToDoItem#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.todo.ToDoItem.<init>()",
      "void org.finos.springbot.example.todo.ToDoItem.<init>(java.lang.String, org.finos.springbot.workflow.content.User, org.finos.springbot.workflow.content.User, org.finos.springbot.example.todo.ToDoItem$Status)",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.todo.ToDoItem.getAssignTo()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.todo.ToDoItem.getCreator()",
      "java.lang.String org.finos.springbot.example.todo.ToDoItem.getDescription()",
      "java.lang.Integer org.finos.springbot.example.todo.ToDoItem.getNumber()",
      "org.finos.springbot.example.todo.ToDoItem$Status org.finos.springbot.example.todo.ToDoItem.getStatus()",
      "void org.finos.springbot.example.todo.ToDoItem.setAssignTo(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.todo.ToDoItem.setCreator(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.todo.ToDoItem.setDescription(java.lang.String)",
      "void org.finos.springbot.example.todo.ToDoItem.setNumber(java.lang.Integer)",
      "void org.finos.springbot.example.todo.ToDoItem.setStatus(org.finos.springbot.example.todo.ToDoItem$Status)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToDoItem actualToDoItem = new ToDoItem();
    SymphonyUser assignTo = new SymphonyUser(1L);
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator = new SymphonyUser(1L);
    actualToDoItem.setCreator(creator);
    actualToDoItem.setDescription("The characteristics of someone or something");
    actualToDoItem.setNumber(10);
    actualToDoItem.setStatus(Status.OPEN);
    User actualAssignTo = actualToDoItem.getAssignTo();
    User actualCreator = actualToDoItem.getCreator();
    String actualDescription = actualToDoItem.getDescription();
    Integer actualNumber = actualToDoItem.getNumber();
    Status actualStatus = actualToDoItem.getStatus();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(10, actualNumber.intValue());
    assertEquals(Status.OPEN, actualStatus);
    assertSame(assignTo, actualAssignTo);
    assertSame(creator, actualCreator);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoItem#ToDoItem(String, User, User, Status)}
   *   <li>{@link ToDoItem#setAssignTo(User)}
   *   <li>{@link ToDoItem#setCreator(User)}
   *   <li>{@link ToDoItem#setDescription(String)}
   *   <li>{@link ToDoItem#setNumber(Integer)}
   *   <li>{@link ToDoItem#setStatus(Status)}
   *   <li>{@link ToDoItem#getAssignTo()}
   *   <li>{@link ToDoItem#getCreator()}
   *   <li>{@link ToDoItem#getDescription()}
   *   <li>{@link ToDoItem#getNumber()}
   *   <li>{@link ToDoItem#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'The characteristics of someone or something'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.todo.ToDoItem.<init>()",
      "void org.finos.springbot.example.todo.ToDoItem.<init>(java.lang.String, org.finos.springbot.workflow.content.User, org.finos.springbot.workflow.content.User, org.finos.springbot.example.todo.ToDoItem$Status)",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.todo.ToDoItem.getAssignTo()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.todo.ToDoItem.getCreator()",
      "java.lang.String org.finos.springbot.example.todo.ToDoItem.getDescription()",
      "java.lang.Integer org.finos.springbot.example.todo.ToDoItem.getNumber()",
      "org.finos.springbot.example.todo.ToDoItem$Status org.finos.springbot.example.todo.ToDoItem.getStatus()",
      "void org.finos.springbot.example.todo.ToDoItem.setAssignTo(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.todo.ToDoItem.setCreator(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.todo.ToDoItem.setDescription(java.lang.String)",
      "void org.finos.springbot.example.todo.ToDoItem.setNumber(java.lang.Integer)",
      "void org.finos.springbot.example.todo.ToDoItem.setStatus(org.finos.springbot.example.todo.ToDoItem$Status)"})
  void testGettersAndSetters_whenTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    SymphonyUser creator = new SymphonyUser(1L);

    // Act
    ToDoItem actualToDoItem = new ToDoItem("The characteristics of someone or something", creator, new SymphonyUser(1L),
        Status.OPEN);
    SymphonyUser assignTo = new SymphonyUser(1L);
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator2 = new SymphonyUser(1L);
    actualToDoItem.setCreator(creator2);
    actualToDoItem.setDescription("The characteristics of someone or something");
    actualToDoItem.setNumber(10);
    actualToDoItem.setStatus(Status.OPEN);
    User actualAssignTo = actualToDoItem.getAssignTo();
    User actualCreator = actualToDoItem.getCreator();
    String actualDescription = actualToDoItem.getDescription();
    Integer actualNumber = actualToDoItem.getNumber();
    Status actualStatus = actualToDoItem.getStatus();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(10, actualNumber.intValue());
    assertEquals(Status.OPEN, actualStatus);
    assertSame(assignTo, actualAssignTo);
    assertSame(creator2, actualCreator);
  }
}
