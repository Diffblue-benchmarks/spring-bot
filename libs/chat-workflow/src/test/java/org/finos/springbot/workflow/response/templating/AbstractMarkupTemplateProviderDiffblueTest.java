package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.finos.springbot.workflow.content.serialization.MarkupWriter;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class AbstractMarkupTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractMarkupTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  void testDeserializeTemplate() throws IOException {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", simpleMarkupTemplateProvider.deserializeTemplate(is).getContents());
    assertEquals(-1, is.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link AbstractMarkupTemplateProvider#applyTemplate(Markup, MessageResponse)}
   */
  @Test
  void testApplyTemplate() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());

    // Act and Assert
    assertEquals("",
        simpleMarkupTemplateProvider
            .applyTemplate(Markup.EMPTY_MARKUP, new MessageResponse(null, "Not all who wander are lost"))
            .getContents());
  }

  /**
   * Method under test:
   * {@link AbstractMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  void testPrepareMarkupForInsertion() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("Markup", (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl, new MarkupWriter<>())).prepareMarkupForInsertion("Markup"));
  }

  /**
   * Method under test:
   * {@link AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)}
   */
  @Test
  void testGetDefaultTemplate() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());

    // Act and Assert
    assertEquals(AbstractMarkupTemplateProvider.MESSAGE_AREA,
        simpleMarkupTemplateProvider.getDefaultTemplate(new MessageResponse(null, "Not all who wander are lost"))
            .getContents());
  }
}
