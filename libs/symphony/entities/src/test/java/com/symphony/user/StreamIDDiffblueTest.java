package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamIDDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StreamID#StreamID()}
   *   <li>{@link StreamID#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.StreamID.<init>()",
      "void com.symphony.user.StreamID.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.StreamID.getSymbolPrefix()"})
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    StreamID actualStreamID = new StreamID();

    // Assert
    assertEquals("@", actualStreamID.getSymbolPrefix());
    assertNull(actualStreamID.getValue());
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
   *   <li>{@link StreamID#StreamID(String)}
   *   <li>{@link StreamID#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.StreamID.<init>()",
      "void com.symphony.user.StreamID.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.StreamID.getSymbolPrefix()"})
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    StreamID actualStreamID = new StreamID("42");
    String actualSymbolPrefix = actualStreamID.getSymbolPrefix();

    // Assert
    assertEquals("42", actualStreamID.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
