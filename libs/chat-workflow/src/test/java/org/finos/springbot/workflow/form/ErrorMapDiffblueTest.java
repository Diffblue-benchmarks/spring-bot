package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ErrorMapDiffblueTest {
  /**
   * Method under test: {@link ErrorMap#add(String, String)}
   */
  @Test
  void testAdd() {
    // Arrange
    ErrorMap errorMap = new ErrorMap();

    // Act
    errorMap.add("Field", "An error occurred");

    // Assert
    Map<String, String> contents = errorMap.getContents();
    assertEquals(1, contents.size());
    assertEquals("An error occurred", contents.get("Field"));
    assertEquals(1, errorMap.size());
  }

  /**
   * Method under test: {@link ErrorMap#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ErrorMap()).size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorMap#ErrorMap()}
   *   <li>{@link ErrorMap#setContents(Map)}
   *   <li>{@link ErrorMap#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorMap actualErrorMap = new ErrorMap();
    HashMap<String, String> contents = new HashMap<>();
    actualErrorMap.setContents(contents);
    Map<String, String> actualContents = actualErrorMap.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents.isEmpty());
    assertSame(contents, actualContents);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorMap#ErrorMap(Map)}
   *   <li>{@link ErrorMap#setContents(Map)}
   *   <li>{@link ErrorMap#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ErrorMap actualErrorMap = new ErrorMap(new HashMap<>());
    HashMap<String, String> contents = new HashMap<>();
    actualErrorMap.setContents(contents);
    Map<String, String> actualContents = actualErrorMap.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents.isEmpty());
    assertSame(contents, actualContents);
  }
}
