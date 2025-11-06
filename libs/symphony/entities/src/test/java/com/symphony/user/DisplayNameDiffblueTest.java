package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisplayNameDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisplayName#DisplayName()}
   *   <li>{@link DisplayName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DisplayName.<init>()", "void DisplayName.<init>(String)",
      "String DisplayName.getSymbolPrefix()"})
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    DisplayName actualDisplayName = new DisplayName();

    // Assert
    assertEquals("@", actualDisplayName.getSymbolPrefix());
    assertNull(actualDisplayName.getValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisplayName#DisplayName(String)}
   *   <li>{@link DisplayName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @org.junit.jupiter.api.DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DisplayName.<init>()", "void DisplayName.<init>(String)",
      "String DisplayName.getSymbolPrefix()"})
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    DisplayName actualDisplayName = new DisplayName("42");
    String actualSymbolPrefix = actualDisplayName.getSymbolPrefix();

    // Assert
    assertEquals("42", actualDisplayName.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
