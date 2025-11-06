package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SecIdDiffblueTest {
  /**
   * Method under test: {@link SecId#getSymbolPrefix()}
   */
  @Test
  void testGetSymbolPrefix() {
    // Arrange, Act and Assert
    assertEquals("$", (new Cusip("42")).getSymbolPrefix());
  }
}
