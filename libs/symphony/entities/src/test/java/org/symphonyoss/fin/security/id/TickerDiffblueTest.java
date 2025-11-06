package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TickerDiffblueTest {
  /**
   * Method under test: {@link Ticker#Ticker()}
   */
  @Test
  void testNewTicker() {
    // Arrange, Act and Assert
    assertNull((new Ticker()).getValue());
    assertEquals("42", (new Ticker("42")).getValue());
  }
}
