package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestObjectsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TestObjects#TestObjects()}
   *   <li>{@link TestObjects#setItems(List)}
   *   <li>{@link TestObjects#toString()}
   *   <li>{@link TestObjects#getItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestObjects.<init>()",
    "void TestObjects.<init>(List)",
    "List TestObjects.getItems()",
    "void TestObjects.setItems(List)",
    "String TestObjects.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TestObjects actualTestObjects = new TestObjects();
    ArrayList<TestObject> items = new ArrayList<>();
    actualTestObjects.setItems(items);
    String actualToStringResult = actualTestObjects.toString();
    List<TestObject> actualItems = actualTestObjects.getItems();

    // Assert
    assertEquals("TestObjects [items=[]]", actualToStringResult);
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
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
   *   <li>{@link TestObjects#TestObjects(List)}
   *   <li>{@link TestObjects#setItems(List)}
   *   <li>{@link TestObjects#toString()}
   *   <li>{@link TestObjects#getItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TestObjects.<init>()",
    "void TestObjects.<init>(List)",
    "List TestObjects.getItems()",
    "void TestObjects.setItems(List)",
    "String TestObjects.toString()"
  })
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    TestObjects actualTestObjects = new TestObjects(new ArrayList<>());
    ArrayList<TestObject> items = new ArrayList<>();
    actualTestObjects.setItems(items);
    String actualToStringResult = actualTestObjects.toString();
    List<TestObject> actualItems = actualTestObjects.getItems();

    // Assert
    assertEquals("TestObjects [items=[]]", actualToStringResult);
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }
}
