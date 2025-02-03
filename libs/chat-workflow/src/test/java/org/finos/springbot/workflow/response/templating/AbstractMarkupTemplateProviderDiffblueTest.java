package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.io.ApplicationResourceLoader;

class AbstractMarkupTemplateProviderDiffblueTest {
  /**
   * Test {@link AbstractMarkupTemplateProvider#deserializeTemplate(InputStream)}.
   * <p>
   * Method under test: {@link AbstractMarkupTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  @DisplayName("Test deserializeTemplate(InputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.templating.Markup org.finos.springbot.workflow.response.templating.AbstractMarkupTemplateProvider.deserializeTemplate(java.io.InputStream)"})
  void testDeserializeTemplate() throws IOException {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", new ApplicationResourceLoader(), mock(BiFunction.class));
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", simpleMarkupTemplateProvider.deserializeTemplate(is).getContents());
    assertEquals(-1, is.read(new byte[]{}));
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#applyTemplate(Markup, MessageResponse)} with {@code Markup}, {@code MessageResponse}.
   * <p>
   * Method under test: {@link AbstractMarkupTemplateProvider#applyTemplate(Markup, MessageResponse)}
   */
  @Test
  @DisplayName("Test applyTemplate(Markup, MessageResponse) with 'Markup', 'MessageResponse'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.templating.Markup org.finos.springbot.workflow.response.templating.AbstractMarkupTemplateProvider.applyTemplate(org.finos.springbot.workflow.response.templating.Markup, org.finos.springbot.workflow.response.MessageResponse)"})
  void testApplyTemplateWithMarkupMessageResponse() {
    // Arrange
    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", new ApplicationResourceLoader(), converter);
    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenReturn("Not all who wander are lost");

    // Act
    String actualContents = simpleMarkupTemplateProvider
        .applyTemplate(markup, new MessageResponse(mock(Addressable.class), "Not all who wander are lost"))
        .getContents();

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
    verify(markup).getContents();
    assertEquals("Not all who wander are lost", actualContents);
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   * <p>
   * Method under test: {@link AbstractMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.response.templating.AbstractMarkupTemplateProvider.prepareMarkupForInsertion(java.lang.String)"})
  void testPrepareMarkupForInsertion() {
    // Arrange, Act and Assert
    assertEquals("Markup",
        (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix", "Default Template Name",
            new ApplicationResourceLoader(), mock(BiFunction.class))).prepareMarkupForInsertion("Markup"));
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)} with {@code MessageResponse}.
   * <p>
   * Method under test: {@link AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)}
   */
  @Test
  @DisplayName("Test getDefaultTemplate(MessageResponse) with 'MessageResponse'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.templating.Markup org.finos.springbot.workflow.response.templating.AbstractMarkupTemplateProvider.getDefaultTemplate(org.finos.springbot.workflow.response.MessageResponse)"})
  void testGetDefaultTemplateWithMessageResponse() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider = new SimpleMarkupTemplateProvider("Template Prefix",
        "Template Suffix", "Default Template Name", new ApplicationResourceLoader(), mock(BiFunction.class));

    // Act and Assert
    assertEquals(AbstractMarkupTemplateProvider.MESSAGE_AREA,
        simpleMarkupTemplateProvider
            .getDefaultTemplate(new MessageResponse(mock(Addressable.class), "Not all who wander are lost"))
            .getContents());
  }
}
