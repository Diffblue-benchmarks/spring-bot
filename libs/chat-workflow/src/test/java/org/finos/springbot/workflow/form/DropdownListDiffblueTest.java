package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.springbot.workflow.form.DropdownList.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DropdownListDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DropdownList#DropdownList()}
   *   <li>{@link DropdownList#setContents(Collection)}
   *   <li>{@link DropdownList#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DropdownList.<init>()",
    "void DropdownList.<init>(Collection)",
    "Collection DropdownList.getContents()",
    "void DropdownList.setContents(Collection)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DropdownList actualDropdownList = new DropdownList();
    ArrayList<Item> contents = new ArrayList<>();
    actualDropdownList.setContents(contents);
    Collection<Item> actualContents = actualDropdownList.getContents();

    // Assert
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DropdownList#DropdownList(Collection)}
   *   <li>{@link DropdownList#setContents(Collection)}
   *   <li>{@link DropdownList#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DropdownList.<init>()",
    "void DropdownList.<init>(Collection)",
    "Collection DropdownList.getContents()",
    "void DropdownList.setContents(Collection)"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    DropdownList actualDropdownList = new DropdownList(new ArrayList<>());
    ArrayList<Item> contents = new ArrayList<>();
    actualDropdownList.setContents(contents);
    Collection<Item> actualContents = actualDropdownList.getContents();

    // Assert
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Test Item {@link Item#equals(Object)}, and {@link Item#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Item#equals(Object)}
   *   <li>{@link Item#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Item equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Item item = new Item("Key", "Name");
    Item item2 = new Item("Key", "Name");

    // Act and Assert
    assertEquals(item, item2);
    int expectedHashCodeResult = item.hashCode();
    assertEquals(expectedHashCodeResult, item2.hashCode());
  }

  /**
   * Test Item {@link Item#equals(Object)}, and {@link Item#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Item#equals(Object)}
   *   <li>{@link Item#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Item equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Item item = new Item("Key", "Name");

    // Act and Assert
    assertEquals(item, item);
    int expectedHashCodeResult = item.hashCode();
    assertEquals(expectedHashCodeResult, item.hashCode());
  }

  /**
   * Test Item {@link Item#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Item#equals(Object)}
   */
  @Test
  @DisplayName("Test Item equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Item item = new Item(null, "Name");

    // Act and Assert
    assertNotEquals(item, new Item("Key", "Name"));
  }

  /**
   * Test Item {@link Item#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Item#equals(Object)}
   */
  @Test
  @DisplayName("Test Item equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Item item = new Item("Key", null);

    // Act and Assert
    assertNotEquals(item, new Item("Key", "Name"));
  }

  /**
   * Test Item {@link Item#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Item#equals(Object)}
   */
  @Test
  @DisplayName("Test Item equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Item("Key", "Name"), null);
  }

  /**
   * Test Item {@link Item#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Item#equals(Object)}
   */
  @Test
  @DisplayName("Test Item equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Item.equals(Object)", "int Item.hashCode()"})
  void testItemEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Item("Key", "Name"), "Different type to Item");
  }

  /**
   * Test Item getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Item#Item()}
   *   <li>{@link Item#setKey(String)}
   *   <li>{@link Item#setName(String)}
   *   <li>{@link Item#getKey()}
   *   <li>{@link Item#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test Item getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Item.<init>()",
    "void Item.<init>(String, String)",
    "String Item.getKey()",
    "String Item.getName()",
    "void Item.setKey(String)",
    "void Item.setName(String)"
  })
  void testItemGettersAndSetters() {
    // Arrange and Act
    Item actualItem = new Item();
    actualItem.setKey("Key");
    actualItem.setName("Name");
    String actualKey = actualItem.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualItem.getName());
  }

  /**
   * Test Item getters and setters.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Item#Item(String, String)}
   *   <li>{@link Item#setKey(String)}
   *   <li>{@link Item#setName(String)}
   *   <li>{@link Item#getKey()}
   *   <li>{@link Item#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test Item getters and setters; when 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Item.<init>()",
    "void Item.<init>(String, String)",
    "String Item.getKey()",
    "String Item.getName()",
    "void Item.setKey(String)",
    "void Item.setName(String)"
  })
  void testItemGettersAndSetters_whenKey() {
    // Arrange and Act
    Item actualItem = new Item("Key", "Name");
    actualItem.setKey("Key");
    actualItem.setName("Name");
    String actualKey = actualItem.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualItem.getName());
  }

  /**
   * Test {@link DropdownList#of(Item[])}.
   *
   * <p>Method under test: {@link DropdownList#of(Item[])}
   */
  @Test
  @DisplayName("Test of(Item[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DropdownList DropdownList.of(Item[])"})
  void testOf() {
    // Arrange
    Item item = new Item("Key", "Name");

    // Act
    DropdownList actualOfResult = DropdownList.of(item);

    // Assert
    Collection<Item> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, actualOfResult.size());
    assertSame(item, ((List<Item>) contents).get(0));
  }

  /**
   * Test {@link DropdownList#add(Item)}.
   *
   * <ul>
   *   <li>Given {@link DropdownList#DropdownList()}.
   *   <li>Then {@link DropdownList#DropdownList()} Contents size is one.
   * </ul>
   *
   * <p>Method under test: {@link DropdownList#add(Item)}
   */
  @Test
  @DisplayName("Test add(Item); given DropdownList(); then DropdownList() Contents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DropdownList.add(Item)"})
  void testAdd_givenDropdownList_thenDropdownListContentsSizeIsOne() {
    // Arrange
    DropdownList dropdownList = new DropdownList();
    Item i = new Item("Key", "Name");

    // Act
    dropdownList.add(i);

    // Assert
    Collection<Item> contents = dropdownList.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, dropdownList.size());
    assertSame(i, ((List<Item>) contents).get(0));
  }

  /**
   * Test {@link DropdownList#size()}.
   *
   * <p>Method under test: {@link DropdownList#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DropdownList.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new DropdownList().size());
  }
}
