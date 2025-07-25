package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MarkupDiffblueTest {
  /**
   * Test {@link Markup#of(String)}.
   *
   * <p>Method under test: {@link Markup#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup Markup.of(String)"})
  void testOf() {
    // Arrange, Act and Assert
    assertEquals("String", Markup.of("String").getContents());
  }
}
