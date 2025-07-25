package org.symphonyoss.fin.security.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SecIdDiffblueTest {
  /**
   * Test {@link SecId#getSymbolPrefix()}.
   *
   * <p>Method under test: {@link SecId#getSymbolPrefix()}
   */
  @Test
  @DisplayName("Test getSymbolPrefix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SecId.getSymbolPrefix()"})
  void testGetSymbolPrefix() {
    // Arrange, Act and Assert
    assertEquals("$", new Cusip("42").getSymbolPrefix());
  }
}
