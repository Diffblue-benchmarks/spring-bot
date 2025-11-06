package org.finos.springbot.symphony.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyContentConfigDiffblueTest {
  /**
   * Test {@link SymphonyContentConfig#symphonyMessageMLWriter()}.
   * <p>
   * Method under test: {@link SymphonyContentConfig#symphonyMessageMLWriter()}
   */
  @Test
  @DisplayName("Test symphonyMessageMLWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.symphony.content.serialization.SymphonyMarkupWriter SymphonyContentConfig.symphonyMessageMLWriter()"})
  void testSymphonyMessageMLWriter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals("", (new SymphonyContentConfig()).symphonyMessageMLWriter().apply(null, null));
  }
}
