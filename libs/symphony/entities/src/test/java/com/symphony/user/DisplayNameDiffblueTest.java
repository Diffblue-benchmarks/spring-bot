package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class DisplayNameDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisplayName#DisplayName()}
   *   <li>{@link DisplayName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DisplayName actualDisplayName = new DisplayName();

    // Assert
    assertEquals("@", actualDisplayName.getSymbolPrefix());
    assertNull(actualDisplayName.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DisplayName#DisplayName(String)}
   *   <li>{@link DisplayName#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    DisplayName actualDisplayName = new DisplayName("42");
    String actualSymbolPrefix = actualDisplayName.getSymbolPrefix();

    // Assert
    assertEquals("42", actualDisplayName.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
