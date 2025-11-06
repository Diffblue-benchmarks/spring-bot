package com.symphony.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class StreamIDDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StreamID#StreamID()}
   *   <li>{@link StreamID#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StreamID actualStreamID = new StreamID();

    // Assert
    assertEquals("@", actualStreamID.getSymbolPrefix());
    assertNull(actualStreamID.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StreamID#StreamID(String)}
   *   <li>{@link StreamID#getSymbolPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    StreamID actualStreamID = new StreamID("42");
    String actualSymbolPrefix = actualStreamID.getSymbolPrefix();

    // Assert
    assertEquals("42", actualStreamID.getValue());
    assertEquals("@", actualSymbolPrefix);
  }
}
