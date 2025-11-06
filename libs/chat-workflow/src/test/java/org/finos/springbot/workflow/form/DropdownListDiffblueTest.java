package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

class DropdownListDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList.Item#equals(Object)}
   *   <li>{@link DropdownList.Item#hashCode()}
   * </ul>
   */
  @Test
  void testItemEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DropdownList.Item item = new DropdownList.Item("Key", "Name");
    DropdownList.Item item2 = new DropdownList.Item("Key", "Name");

    // Act and Assert
    assertEquals(item, item2);
    int expectedHashCodeResult = item.hashCode();
    assertEquals(expectedHashCodeResult, item2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList.Item#equals(Object)}
   *   <li>{@link DropdownList.Item#hashCode()}
   * </ul>
   */
  @Test
  void testItemEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DropdownList.Item item = new DropdownList.Item("Key", "Name");

    // Act and Assert
    assertEquals(item, item);
    int expectedHashCodeResult = item.hashCode();
    assertEquals(expectedHashCodeResult, item.hashCode());
  }

  /**
   * Method under test: {@link DropdownList.Item#equals(Object)}
   */
  @Test
  void testItemEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DropdownList.Item item = new DropdownList.Item(null, "Name");

    // Act and Assert
    assertNotEquals(item, new DropdownList.Item("Key", "Name"));
  }

  /**
   * Method under test: {@link DropdownList.Item#equals(Object)}
   */
  @Test
  void testItemEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DropdownList.Item item = new DropdownList.Item("Key", null);

    // Act and Assert
    assertNotEquals(item, new DropdownList.Item("Key", "Name"));
  }

  /**
   * Method under test: {@link DropdownList.Item#equals(Object)}
   */
  @Test
  void testItemEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DropdownList.Item("Key", "Name"), null);
  }

  /**
   * Method under test: {@link DropdownList.Item#equals(Object)}
   */
  @Test
  void testItemEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DropdownList.Item("Key", "Name"), "Different type to Item");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList.Item#Item()}
   *   <li>{@link DropdownList.Item#setKey(String)}
   *   <li>{@link DropdownList.Item#setName(String)}
   *   <li>{@link DropdownList.Item#getKey()}
   *   <li>{@link DropdownList.Item#getName()}
   * </ul>
   */
  @Test
  void testItemGettersAndSetters() {
    // Arrange and Act
    DropdownList.Item actualItem = new DropdownList.Item();
    actualItem.setKey("Key");
    actualItem.setName("Name");
    String actualKey = actualItem.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualItem.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList.Item#Item(String, String)}
   *   <li>{@link DropdownList.Item#setKey(String)}
   *   <li>{@link DropdownList.Item#setName(String)}
   *   <li>{@link DropdownList.Item#getKey()}
   *   <li>{@link DropdownList.Item#getName()}
   * </ul>
   */
  @Test
  void testItemGettersAndSetters2() {
    // Arrange and Act
    DropdownList.Item actualItem = new DropdownList.Item("Key", "Name");
    actualItem.setKey("Key");
    actualItem.setName("Name");
    String actualKey = actualItem.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualItem.getName());
  }

  /**
   * Method under test: {@link DropdownList#of(DropdownList.Item[])}
   */
  @Test
  void testOf() {
    // Arrange
    DropdownList.Item item = new DropdownList.Item("Key", "Name");

    // Act
    DropdownList actualOfResult = DropdownList.of(item);

    // Assert
    Collection<DropdownList.Item> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, actualOfResult.size());
    assertSame(item, ((List<DropdownList.Item>) contents).get(0));
  }

  /**
   * Method under test: {@link DropdownList#add(DropdownList.Item)}
   */
  @Test
  void testAdd() {
    // Arrange
    DropdownList dropdownList = new DropdownList();
    DropdownList.Item i = new DropdownList.Item("Key", "Name");

    // Act
    dropdownList.add(i);

    // Assert
    Collection<DropdownList.Item> contents = dropdownList.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, dropdownList.size());
    assertSame(i, ((List<DropdownList.Item>) contents).get(0));
  }

  /**
   * Method under test: {@link DropdownList#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new DropdownList()).size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList#DropdownList()}
   *   <li>{@link DropdownList#setContents(Collection)}
   *   <li>{@link DropdownList#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DropdownList actualDropdownList = new DropdownList();
    ArrayList<DropdownList.Item> contents = new ArrayList<>();
    actualDropdownList.setContents(contents);
    Collection<DropdownList.Item> actualContents = actualDropdownList.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DropdownList#DropdownList(Collection)}
   *   <li>{@link DropdownList#setContents(Collection)}
   *   <li>{@link DropdownList#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    DropdownList actualDropdownList = new DropdownList(new ArrayList<>());
    ArrayList<DropdownList.Item> contents = new ArrayList<>();
    actualDropdownList.setContents(contents);
    Collection<DropdownList.Item> actualContents = actualDropdownList.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }
}
