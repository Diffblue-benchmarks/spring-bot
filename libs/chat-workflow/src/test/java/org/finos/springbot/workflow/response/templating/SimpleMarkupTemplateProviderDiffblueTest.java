package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.serialization.MarkupWriter;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ResourceLoader;

class SimpleMarkupTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link SimpleMarkupTemplateProvider#toMarkup(String, Markup)}
   */
  @Test
  void testToMarkup() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("foo", (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix", "Default Template Name",
        rl, new MarkupWriter<>())).toMarkup("foo", Markup.EMPTY_MARKUP).getContents());
  }

  /**
   * Method under test:
   * {@link SimpleMarkupTemplateProvider#createContext(MessageResponse)}
   */
  @Test
  void testCreateContext() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());

    // Act and Assert
    assertEquals("",
        simpleMarkupTemplateProvider.createContext(new MessageResponse(null, "Not all who wander are lost"))
            .getContents());
  }

  /**
   * Method under test:
   * {@link SimpleMarkupTemplateProvider#SimpleMarkupTemplateProvider(String, String, String, ResourceLoader, BiFunction)}
   */
  @Test
  void testNewSimpleMarkupTemplateProvider() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("Default Template Name", (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl, new MarkupWriter<>())).getDefaultTemplateName());
  }
}
