package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ToDoListDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoList#ToDoList()}
   *   <li>{@link ToDoList#setItems(List)}
   *   <li>{@link ToDoList#getItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.todo.ToDoList.<init>()",
      "void org.finos.springbot.example.todo.ToDoList.<init>(java.util.List)",
      "java.util.List org.finos.springbot.example.todo.ToDoList.getItems()",
      "void org.finos.springbot.example.todo.ToDoList.setItems(java.util.List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ToDoList actualToDoList = new ToDoList();
    ArrayList<ToDoItem> items = new ArrayList<>();
    actualToDoList.setItems(items);
    List<ToDoItem> actualItems = actualToDoList.getItems();

    // Assert
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoList#ToDoList(List)}
   *   <li>{@link ToDoList#setItems(List)}
   *   <li>{@link ToDoList#getItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.todo.ToDoList.<init>()",
      "void org.finos.springbot.example.todo.ToDoList.<init>(java.util.List)",
      "java.util.List org.finos.springbot.example.todo.ToDoList.getItems()",
      "void org.finos.springbot.example.todo.ToDoList.setItems(java.util.List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    ToDoList actualToDoList = new ToDoList(new ArrayList<>());
    ArrayList<ToDoItem> items = new ArrayList<>();
    actualToDoList.setItems(items);
    List<ToDoItem> actualItems = actualToDoList.getItems();

    // Assert
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }
}
