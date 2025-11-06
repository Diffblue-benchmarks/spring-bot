package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class OpenfigiDiffblueTest {
  /**
   * Method under test: {@link Openfigi#Openfigi()}
   */
  @Test
  void testNewOpenfigi() {
    // Arrange, Act and Assert
    assertNull((new Openfigi()).getValue());
    assertEquals("42", (new Openfigi("42")).getValue());
  }
}
