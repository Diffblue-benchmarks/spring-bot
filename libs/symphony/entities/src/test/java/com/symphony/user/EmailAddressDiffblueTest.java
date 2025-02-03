package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmailAddressDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailAddress#EmailAddress()}
   *   <li>{@link EmailAddress#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.EmailAddress.<init>()",
      "void com.symphony.user.EmailAddress.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.EmailAddress.getSymbolPrefix()"})
  void testGettersAndSetters_thenReturnValueIsNull() {
    // Arrange and Act
    EmailAddress actualEmailAddress = new EmailAddress();

    // Assert
    assertEquals("@", actualEmailAddress.getSymbolPrefix());
    assertNull(actualEmailAddress.getValue());
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
   *   <li>{@link EmailAddress#EmailAddress(String)}
   *   <li>{@link EmailAddress#getSymbolPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void com.symphony.user.EmailAddress.<init>()",
      "void com.symphony.user.EmailAddress.<init>(java.lang.String)",
      "java.lang.String com.symphony.user.EmailAddress.getSymbolPrefix()"})
  void testGettersAndSetters_when42_thenReturnValueIs42() {
    // Arrange and Act
    EmailAddress actualEmailAddress = new EmailAddress("42");
    String actualSymbolPrefix = actualEmailAddress.getSymbolPrefix();

    // Assert
    assertEquals("42", actualEmailAddress.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
