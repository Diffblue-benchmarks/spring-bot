package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class SymphonyTemplateProviderDiffblueTest {
  /**
   * Method under test:
   * {@link SymphonyTemplateProvider#getDefaultTemplate(WorkResponse)}
   */
  @Test
  void testGetDefaultTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));
    SymphonyRoom stream = new SymphonyRoom("default-edit", "42");

    // Act and Assert
    assertThrows(SymphonyException.class,
        () -> symphonyTemplateProvider.getDefaultTemplate(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  void testNeedsButtons() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));

    // Act and Assert
    assertFalse(symphonyTemplateProvider
        .needsButtons(new MessageResponse(new SymphonyRoom("Name", "42"), "Not all who wander are lost")));
  }

  /**
   * Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  void testNeedsButtons2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));
    SymphonyRoom stream = new SymphonyRoom("Name", "42");

    // Act and Assert
    assertFalse(symphonyTemplateProvider.needsButtons(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Method under test: {@link SymphonyTemplateProvider#needsButtons(Response)}
   */
  @Test
  void testNeedsButtons3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));

    // Act and Assert
    assertFalse(
        symphonyTemplateProvider.needsButtons(new WorkResponse(new SymphonyRoom("Name", "42"), "42", WorkMode.BOTH)));
  }

  /**
   * Method under test:
   * {@link SymphonyTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  void testDeserializeTemplate() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", symphonyTemplateProvider.deserializeTemplate(is));
    assertEquals(-1, is.read(new byte[]{}));
  }

  /**
   * Method under test:
   * {@link SymphonyTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  void testApplyTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    SymphonyTemplateProvider symphonyTemplateProvider = new SymphonyTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", rl,
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering()));

    // Act and Assert
    assertEquals("Template", symphonyTemplateProvider.applyTemplate("Template",
        new WorkResponse(new SymphonyRoom("Name", "42"), "42", WorkMode.BOTH)));
  }
}
