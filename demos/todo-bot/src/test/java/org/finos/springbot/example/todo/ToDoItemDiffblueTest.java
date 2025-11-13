package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToDoItem.<init>()",
    "void ToDoItem.<init>(String, User, User, Status)",
    "User ToDoItem.getAssignTo()",
    "User ToDoItem.getCreator()",
    "String ToDoItem.getDescription()",
    "Integer ToDoItem.getNumber()",
    "Status ToDoItem.getStatus()",
    "void ToDoItem.setAssignTo(User)",
    "void ToDoItem.setCreator(User)",
    "void ToDoItem.setDescription(String)",
    "void ToDoItem.setNumber(Integer)",
    "void ToDoItem.setStatus(Status)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ToDoItem actualToDoItem = new ToDoItem();
    SymphonyUser assignTo = new SymphonyUser();
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator = new SymphonyUser();
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
   *
   * <ul>
   *   <li>When {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToDoItem.<init>()",
    "void ToDoItem.<init>(String, User, User, Status)",
    "User ToDoItem.getAssignTo()",
    "User ToDoItem.getCreator()",
    "String ToDoItem.getDescription()",
    "Integer ToDoItem.getNumber()",
    "Status ToDoItem.getStatus()",
    "void ToDoItem.setAssignTo(User)",
    "void ToDoItem.setCreator(User)",
    "void ToDoItem.setDescription(String)",
    "void ToDoItem.setNumber(Integer)",
    "void ToDoItem.setStatus(Status)"
  })
  void testGettersAndSetters_whenTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    SymphonyUser creator = new SymphonyUser();

    // Act
    ToDoItem actualToDoItem =
        new ToDoItem(
            "The characteristics of someone or something",
            creator,
            new SymphonyUser(),
            Status.OPEN);
    SymphonyUser assignTo = new SymphonyUser();
    actualToDoItem.setAssignTo(assignTo);
    SymphonyUser creator2 = new SymphonyUser();
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
