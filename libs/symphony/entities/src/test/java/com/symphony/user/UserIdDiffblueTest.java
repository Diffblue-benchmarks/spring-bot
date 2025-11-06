package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class UserIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserId#UserId()}
   *   <li>{@link UserId#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserId actualUserId = new UserId();

    // Assert
    assertEquals("@", actualUserId.getSymbolPrefix());
    assertNull(actualUserId.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserId#UserId(String)}
   *   <li>{@link UserId#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    UserId actualUserId = new UserId("42");
    String actualSymbolPrefix = actualUserId.getSymbolPrefix();

    // Assert
    assertEquals("42", actualUserId.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
