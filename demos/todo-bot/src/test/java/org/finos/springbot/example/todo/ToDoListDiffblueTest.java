package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ToDoListDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoList#ToDoList()}
   *   <li>{@link ToDoList#setItems(List)}
   *   <li>{@link ToDoList#getItems()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToDoList actualToDoList = new ToDoList();
    ArrayList<ToDoItem> items = new ArrayList<>();
    actualToDoList.setItems(items);
    List<ToDoItem> actualItems = actualToDoList.getItems();

    // Assert that nothing has changed
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDoList#ToDoList(List)}
   *   <li>{@link ToDoList#setItems(List)}
   *   <li>{@link ToDoList#getItems()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ToDoList actualToDoList = new ToDoList(new ArrayList<>());
    ArrayList<ToDoItem> items = new ArrayList<>();
    actualToDoList.setItems(items);
    List<ToDoItem> actualItems = actualToDoList.getItems();

    // Assert that nothing has changed
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }
}
