package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CusipDiffblueTest {
  /**
   * Test {@link Cusip#Cusip()}.
   *
   * <ul>
   *   <li>Then return Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Cusip#Cusip()}
   */
  @Test
  @DisplayName("Test new Cusip(); then return Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cusip.<init>()", "void Cusip.<init>(String)"})
  void testNewCusip_thenReturnValueIsNull() {
    // Arrange, Act and Assert
    assertNull(new Cusip().getValue());
  }

  /**
   * Test {@link Cusip#Cusip(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Cusip#Cusip(String)}
   */
  @Test
  @DisplayName("Test new Cusip(String); when '42'; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Cusip.<init>()", "void Cusip.<init>(String)"})
  void testNewCusip_when42_thenReturnValueIs42() {
    // Arrange, Act and Assert
    assertEquals("42", new Cusip("42").getValue());
  }
}
