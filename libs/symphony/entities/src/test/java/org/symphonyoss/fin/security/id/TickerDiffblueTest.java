package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TickerDiffblueTest {
  /**
   * Test {@link Ticker#Ticker()}.
   *
   * <ul>
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Ticker#Ticker()}
   */
  @Test
  @DisplayName("Test new Ticker(); then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ticker.<init>()", "void Ticker.<init>(String)"})
  void testNewTicker_thenReturnValueIsNull() {
    // Arrange, Act and Assert
    assertNull(new Ticker().getValue());
  }

  /**
   * Test {@link Ticker#Ticker(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Ticker#Ticker(String)}
   */
  @Test
  @DisplayName("Test new Ticker(String); when '42'; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Ticker.<init>()", "void Ticker.<init>(String)"})
  void testNewTicker_when42_thenReturnValueIs42() {
    // Arrange, Act and Assert
    assertEquals("42", new Ticker("42").getValue());
  }
}
