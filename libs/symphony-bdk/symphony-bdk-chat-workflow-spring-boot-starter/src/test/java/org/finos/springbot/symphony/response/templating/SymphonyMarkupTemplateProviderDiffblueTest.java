package org.finos.springbot.symphony.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.springbot.symphony.content.serialization.SymphonyMarkupWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class SymphonyMarkupTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  void testPrepareMarkupForInsertion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("Markup", (new SymphonyMarkupTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl, new SymphonyMarkupWriter())).prepareMarkupForInsertion("Markup"));
  }

  /**
   * Method under test:
   * {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  void testPrepareMarkupForInsertion2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("", (new SymphonyMarkupTemplateProvider("Template Prefix", "Template Suffix", "Default Template Name",
        rl, new SymphonyMarkupWriter())).prepareMarkupForInsertion("<messageML>"));
  }

  /**
   * Method under test:
   * {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  void testPrepareMarkupForInsertion3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("", (new SymphonyMarkupTemplateProvider("Template Prefix", "Template Suffix", "Default Template Name",
        rl, new SymphonyMarkupWriter())).prepareMarkupForInsertion("</messageML>"));
  }
}
