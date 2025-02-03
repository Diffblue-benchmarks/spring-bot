package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenfigiDiffblueTest {
  /**
   * Test {@link Openfigi#Openfigi()}.
   * <ul>
   *   <li>Then return Value is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Openfigi#Openfigi()}
   */
  @Test
  @DisplayName("Test new Openfigi(); then return Value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.symphonyoss.fin.security.id.Openfigi.<init>()",
      "void org.symphonyoss.fin.security.id.Openfigi.<init>(java.lang.String)"})
  void testNewOpenfigi_thenReturnValueIsNull() {
    // Arrange, Act and Assert
    assertNull((new Openfigi()).getValue());
  }

  /**
   * Test {@link Openfigi#Openfigi(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Openfigi#Openfigi(String)}
   */
  @Test
  @DisplayName("Test new Openfigi(String); when '42'; then return Value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.symphonyoss.fin.security.id.Openfigi.<init>()",
      "void org.symphonyoss.fin.security.id.Openfigi.<init>(java.lang.String)"})
  void testNewOpenfigi_when42_thenReturnValueIs42() {
    // Arrange, Act and Assert
    assertEquals("42", (new Openfigi("42")).getValue());
  }
}
