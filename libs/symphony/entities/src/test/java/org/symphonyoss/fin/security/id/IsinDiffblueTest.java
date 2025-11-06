package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IsinDiffblueTest {
  /**
   * Test {@link Isin#Isin()}.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Isin#Isin()}
   */
  @Test
  @DisplayName("Test new Isin(); then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Isin.<init>()", "void Isin.<init>(String)"})
  void testNewIsin_thenReturnValueIsNull() {
    // Arrange, Act and Assert
    assertNull((new Isin()).getValue());
  }

  /**
   * Test {@link Isin#Isin(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Isin#Isin(String)}
   */
  @Test
  @DisplayName("Test new Isin(String); when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Isin.<init>()", "void Isin.<init>(String)"})
  void testNewIsin_when42_thenReturnValueIs42() {
    // Arrange, Act and Assert
    assertEquals("42", (new Isin("42")).getValue());
  }
}
