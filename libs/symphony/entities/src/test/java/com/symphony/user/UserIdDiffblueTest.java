package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserIdDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserId#UserId()}
   *   <li>{@link UserId#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.UserId.<init>()", "void com.symphony.user.UserId.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.UserId.getSymbolPrefix()"})
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    UserId actualUserId = new UserId();

    // Assert
    assertEquals("@", actualUserId.getSymbolPrefix());
    assertNull(actualUserId.getValue());
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
   *   <li>{@link UserId#UserId(String)}
   *   <li>{@link UserId#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.UserId.<init>()", "void com.symphony.user.UserId.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.UserId.getSymbolPrefix()"})
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    UserId actualUserId = new UserId("42");
    String actualSymbolPrefix = actualUserId.getSymbolPrefix();

    // Assert
    assertEquals("42", actualUserId.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
