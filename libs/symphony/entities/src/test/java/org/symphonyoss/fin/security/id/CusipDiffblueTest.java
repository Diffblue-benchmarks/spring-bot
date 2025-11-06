package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CusipDiffblueTest {
  /**
   * Method under test: {@link Cusip#Cusip()}
   */
  @Test
  void testNewCusip() {
    // Arrange, Act and Assert
    assertNull((new Cusip()).getValue());
    assertEquals("42", (new Cusip("42")).getValue());
  }
}
