package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class EmailAddressDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailAddress#EmailAddress()}
   *   <li>{@link EmailAddress#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EmailAddress actualEmailAddress = new EmailAddress();

    // Assert
    assertEquals("@", actualEmailAddress.getSymbolPrefix());
    assertNull(actualEmailAddress.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailAddress#EmailAddress(String)}
   *   <li>{@link EmailAddress#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EmailAddress actualEmailAddress = new EmailAddress("42");
    String actualSymbolPrefix = actualEmailAddress.getSymbolPrefix();

    // Assert
    assertEquals("42", actualEmailAddress.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
