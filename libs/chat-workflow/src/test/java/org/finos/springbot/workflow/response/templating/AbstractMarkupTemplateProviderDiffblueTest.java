package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.ResourceLoader;

class AbstractMarkupTemplateProviderDiffblueTest {
  /**
   * Test {@link AbstractMarkupTemplateProvider#deserializeTemplate(InputStream)}.
   *
   * <p>Method under test: {@link AbstractMarkupTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  @DisplayName("Test deserializeTemplate(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup AbstractMarkupTemplateProvider.deserializeTemplate(InputStream)"})
  void testDeserializeTemplate() throws IOException {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Markup actualDeserializeTemplateResult = simpleMarkupTemplateProvider.deserializeTemplate(is);

    // Assert
    assertEquals("AXAXAXAX", actualDeserializeTemplateResult.getContents());
    int actualReadResult = is.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#applyTemplate(Markup, MessageResponse)} with {@code
   * Markup}, {@code MessageResponse}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractMarkupTemplateProvider#applyTemplate(Markup,
   * MessageResponse)}
   */
  @Test
  @DisplayName(
      "Test applyTemplate(Markup, MessageResponse) with 'Markup', 'MessageResponse'; then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Markup AbstractMarkupTemplateProvider.applyTemplate(Markup, MessageResponse)"
  })
  void testApplyTemplateWithMarkupMessageResponse_thenCallsApply() {
    // Arrange
    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            converter);

    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenReturn("Not all who wander are lost");

    // Act
    simpleMarkupTemplateProvider.applyTemplate(
        markup, new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
    verify(markup).getContents();
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   *
   * <p>Method under test: {@link AbstractMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractMarkupTemplateProvider.prepareMarkupForInsertion(String)"})
  void testPrepareMarkupForInsertion() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act and Assert
    assertEquals("Markup", simpleMarkupTemplateProvider.prepareMarkupForInsertion("Markup"));
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then return Contents is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)}
   */
  @Test
  @DisplayName(
      "Test getDefaultTemplate(MessageResponse) with 'MessageResponse'; then return Contents is 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup AbstractMarkupTemplateProvider.getDefaultTemplate(MessageResponse)"})
  void testGetDefaultTemplateWithMessageResponse_thenReturnContentsIsAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange
    ProtocolResolver resolver = mock(ProtocolResolver.class);
    when(resolver.resolve(Mockito.<String>any(), Mockito.<ResourceLoader>any()))
        .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));

    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    rl.addProtocolResolver(resolver);
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            rl,
            mock(BiFunction.class));

    // Act
    Markup actualDefaultTemplate =
        simpleMarkupTemplateProvider.getDefaultTemplate(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));
    String actualContents = actualDefaultTemplate.getContents();

    // Assert
    verify(resolver)
        .resolve(
            eq("Template PrefixDefault Template NameTemplate Suffix"), isA(ResourceLoader.class));
    assertEquals("AXAXAXAX", actualContents);
  }

  /**
   * Test {@link AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then return Contents is {@link AbstractMarkupTemplateProvider#MESSAGE_AREA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractMarkupTemplateProvider#getDefaultTemplate(MessageResponse)}
   */
  @Test
  @DisplayName(
      "Test getDefaultTemplate(MessageResponse) with 'MessageResponse'; then return Contents is MESSAGE_AREA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup AbstractMarkupTemplateProvider.getDefaultTemplate(MessageResponse)"})
  void testGetDefaultTemplateWithMessageResponse_thenReturnContentsIsMessage_area() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act
    Markup actualDefaultTemplate =
        simpleMarkupTemplateProvider.getDefaultTemplate(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    assertEquals(AbstractMarkupTemplateProvider.MESSAGE_AREA, actualDefaultTemplate.getContents());
  }
}
