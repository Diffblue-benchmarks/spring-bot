package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class IsinDiffblueTest {
  /**
   * Method under test: {@link Isin#Isin()}
   */
  @Test
  void testNewIsin() {
    // Arrange, Act and Assert
    assertNull((new Isin()).getValue());
    assertEquals("42", (new Isin("42")).getValue());
  }
}
