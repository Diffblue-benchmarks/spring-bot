package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.io.UnsupportedEncodingException;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.serialization.MarkupWriter;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class AbstractResourceTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractResourceTemplateProvider#template(DataResponse)}
   */
  @Test
  void testTemplate() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());

    // Act and Assert
    assertEquals("",
        simpleMarkupTemplateProvider.template(new MessageResponse(null, "Not all who wander are lost")).getContents());
  }

  /**
   * Method under test:
   * {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)}
   */
  @Test
  void testHasTemplate() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());

    // Act and Assert
    assertFalse(simpleMarkupTemplateProvider.hasTemplate(new MessageResponse(null, "Not all who wander are lost")));
  }

  /**
   * Method under test:
   * {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)}
   */
  @Test
  void testHasTemplate2() throws UnsupportedEncodingException {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl, new MarkupWriter<>());
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertFalse(simpleMarkupTemplateProvider
        .hasTemplate(new AttachmentResponse(null, m, "Template", "AXAXAXAX".getBytes("UTF-8"), "Name", "Extension")));
  }

  /**
   * Method under test:
   * {@link AbstractResourceTemplateProvider#getDefaultTemplateName()}
   */
  @Test
  void testGetDefaultTemplateName() {
    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();

    // Act and Assert
    assertEquals("Default Template Name", (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", rl, new MarkupWriter<>())).getDefaultTemplateName());
  }
}
