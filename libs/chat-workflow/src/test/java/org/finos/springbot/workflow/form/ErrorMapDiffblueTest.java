package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ErrorMapDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorMap#ErrorMap()}
   *   <li>{@link ErrorMap#setContents(Map)}
   *   <li>{@link ErrorMap#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ErrorMap.<init>()", "void ErrorMap.<init>(Map)", "Map ErrorMap.getContents()",
      "void ErrorMap.setContents(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorMap actualErrorMap = new ErrorMap();
    HashMap<String, String> contents = new HashMap<>();
    actualErrorMap.setContents(contents);
    Map<String, String> actualContents = actualErrorMap.getContents();

    // Assert
    assertTrue(actualContents.isEmpty());
    assertSame(contents, actualContents);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorMap#ErrorMap(Map)}
   *   <li>{@link ErrorMap#setContents(Map)}
   *   <li>{@link ErrorMap#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ErrorMap.<init>()", "void ErrorMap.<init>(Map)", "Map ErrorMap.getContents()",
      "void ErrorMap.setContents(Map)"})
  void testGettersAndSetters_whenHashMap() {
    // Arrange and Act
    ErrorMap actualErrorMap = new ErrorMap(new HashMap<>());
    HashMap<String, String> contents = new HashMap<>();
    actualErrorMap.setContents(contents);
    Map<String, String> actualContents = actualErrorMap.getContents();

    // Assert
    assertTrue(actualContents.isEmpty());
    assertSame(contents, actualContents);
  }

  /**
   * Test {@link ErrorMap#add(String, String)}.
   * <p>
   * Method under test: {@link ErrorMap#add(String, String)}
   */
  @Test
  @DisplayName("Test add(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ErrorMap.add(String, String)"})
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
   * Test {@link ErrorMap#size()}.
   * <p>
   * Method under test: {@link ErrorMap#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ErrorMap.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ErrorMap()).size());
  }
}
