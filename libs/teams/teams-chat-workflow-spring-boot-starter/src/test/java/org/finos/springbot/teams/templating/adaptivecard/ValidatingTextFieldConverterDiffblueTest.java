package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.templating.Rendering;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatingTextFieldConverterDiffblueTest {
  /**
   * Test {@link ValidatingTextFieldConverter#ValidatingTextFieldConverter(int, Rendering,
   * Class[])}.
   *
   * <p>Method under test: {@link ValidatingTextFieldConverter#ValidatingTextFieldConverter(int,
   * Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new ValidatingTextFieldConverter(int, Rendering, Class[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidatingTextFieldConverter.<init>(int, Rendering, Class[])"})
  void testNewValidatingTextFieldConverter() {
    // Arrange
    AdaptiveCardRendering r = new AdaptiveCardRendering();
    Class<Object> forNameResult = Object.class;

    // Act
    ValidatingTextFieldConverter actualValidatingTextFieldConverter =
        new ValidatingTextFieldConverter(1, r, forNameResult);

    // Assert
    assertEquals(1, actualValidatingTextFieldConverter.getPriority());
  }
}
