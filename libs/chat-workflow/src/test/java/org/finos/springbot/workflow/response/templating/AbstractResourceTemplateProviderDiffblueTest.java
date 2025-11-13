package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.ResourceLoader;

class AbstractResourceTemplateProviderDiffblueTest {
  /**
   * Test {@link AbstractResourceTemplateProvider#template(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#template(DataResponse)}
   */
  @Test
  @DisplayName("Test template(DataResponse) with 'MessageResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractResourceTemplateProvider.template(DataResponse)"})
  void testTemplateWithMessageResponse() {
    // Arrange
    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", null, converter);

    // Act
    simpleMarkupTemplateProvider.template(
        new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#template(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#template(DataResponse)}
   */
  @Test
  @DisplayName("Test template(DataResponse) with 'MessageResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractResourceTemplateProvider.template(DataResponse)"})
  void testTemplateWithMessageResponse2() throws UnsupportedEncodingException {
    // Arrange
    ProtocolResolver resolver = mock(ProtocolResolver.class);
    when(resolver.resolve(Mockito.<String>any(), Mockito.<ResourceLoader>any()))
        .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));

    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    rl.addProtocolResolver(resolver);

    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");

    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);
    AttachmentResponse attachmentResponse =
        new AttachmentResponse(
            mock(Addressable.class),
            mock(Content.class),
            AbstractMarkupTemplateProvider.MESSAGE_AREA,
            "AXAXAXAX".getBytes("UTF-8"),
            AbstractMarkupTemplateProvider.MESSAGE_AREA,
            AbstractMarkupTemplateProvider.MESSAGE_AREA);

    // Act
    simpleMarkupTemplateProvider.template(attachmentResponse);

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
    verify(resolver)
        .resolve(
            eq("Template Prefix<!-- Message Content -->Template Suffix"),
            isA(ResourceLoader.class));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#template(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#template(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test template(DataResponse) with 'MessageResponse'; then calls apply(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractResourceTemplateProvider.template(DataResponse)"})
  void testTemplateWithMessageResponse_thenCallsApply() {
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

    // Act
    simpleMarkupTemplateProvider.template(
        new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#template(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then calls {@link ProtocolResolver#resolve(String, ResourceLoader)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#template(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test template(DataResponse) with 'MessageResponse'; then calls resolve(String, ResourceLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractResourceTemplateProvider.template(DataResponse)"})
  void testTemplateWithMessageResponse_thenCallsResolve() throws UnsupportedEncodingException {
    // Arrange
    ProtocolResolver resolver = mock(ProtocolResolver.class);
    when(resolver.resolve(Mockito.<String>any(), Mockito.<ResourceLoader>any()))
        .thenReturn(new ByteArrayResource("AXAXAXAX".getBytes("UTF-8")));

    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    rl.addProtocolResolver(resolver);

    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");

    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);

    // Act
    simpleMarkupTemplateProvider.template(
        new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
    verify(resolver)
        .resolve(
            eq("Template PrefixDefault Template NameTemplate Suffix"), isA(ResourceLoader.class));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#getTemplateForName(String)}.
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#getTemplateForName(String)}
   */
  @Test
  @DisplayName("Test getTemplateForName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object AbstractResourceTemplateProvider.getTemplateForName(String)"
  })
  void testGetTemplateForName() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            null,
            mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleMarkupTemplateProvider.getTemplateForName("Name"));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#getTemplateForName(String)}.
   *
   * <ul>
   *   <li>Then calls {@link ProtocolResolver#resolve(String, ResourceLoader)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#getTemplateForName(String)}
   */
  @Test
  @DisplayName("Test getTemplateForName(String); then calls resolve(String, ResourceLoader)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object AbstractResourceTemplateProvider.getTemplateForName(String)"
  })
  void testGetTemplateForName_thenCallsResolve() throws UnsupportedEncodingException {
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
    simpleMarkupTemplateProvider.getTemplateForName("Name");

    // Assert
    verify(resolver).resolve(eq("Template PrefixNameTemplate Suffix"), isA(ResourceLoader.class));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#getTemplateForName(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#getTemplateForName(String)}
   */
  @Test
  @DisplayName("Test getTemplateForName(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object AbstractResourceTemplateProvider.getTemplateForName(String)"
  })
  void testGetTemplateForName_thenReturnNull() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act and Assert
    assertNull(simpleMarkupTemplateProvider.getTemplateForName("Name"));
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test hasTemplate(DataResponse) with 'MessageResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractResourceTemplateProvider.hasTemplate(DataResponse)"})
  void testHasTemplateWithMessageResponse() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act
    boolean actualHasTemplateResult =
        simpleMarkupTemplateProvider.hasTemplate(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    assertFalse(actualHasTemplateResult);
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test hasTemplate(DataResponse) with 'MessageResponse'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractResourceTemplateProvider.hasTemplate(DataResponse)"})
  void testHasTemplateWithMessageResponse_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    AttachmentResponse attachmentResponse =
        new AttachmentResponse(
            mock(Addressable.class),
            mock(Content.class),
            "Template",
            "AXAXAXAX".getBytes("UTF-8"),
            "Name",
            "Extension");

    // Act
    boolean actualHasTemplateResult = simpleMarkupTemplateProvider.hasTemplate(attachmentResponse);

    // Assert
    assertFalse(actualHasTemplateResult);
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)} with {@code
   * MessageResponse}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test hasTemplate(DataResponse) with 'MessageResponse'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractResourceTemplateProvider.hasTemplate(DataResponse)"})
  void testHasTemplateWithMessageResponse_thenReturnTrue() throws UnsupportedEncodingException {
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
    AttachmentResponse attachmentResponse =
        new AttachmentResponse(
            mock(Addressable.class),
            mock(Content.class),
            "Template",
            "AXAXAXAX".getBytes("UTF-8"),
            "Name",
            "Extension");

    // Act
    boolean actualHasTemplateResult = simpleMarkupTemplateProvider.hasTemplate(attachmentResponse);

    // Assert
    verify(resolver)
        .resolve(eq("Template PrefixTemplateTemplate Suffix"), isA(ResourceLoader.class));
    assertTrue(actualHasTemplateResult);
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#resolveTemplate(String)}.
   *
   * <ul>
   *   <li>Then return Contents is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#resolveTemplate(String)}
   */
  @Test
  @DisplayName("Test resolveTemplate(String); then return Contents is 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object AbstractResourceTemplateProvider.resolveTemplate(String)"})
  void testResolveTemplate_thenReturnContentsIsAxaxaxax() throws Exception {
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
    String actualContents = simpleMarkupTemplateProvider.resolveTemplate("Name").getContents();

    // Assert
    verify(resolver).resolve(eq("Template PrefixNameTemplate Suffix"), isA(ResourceLoader.class));
    assertEquals("AXAXAXAX", actualContents);
  }

  /**
   * Test {@link AbstractResourceTemplateProvider#getDefaultTemplateName()}.
   *
   * <p>Method under test: {@link AbstractResourceTemplateProvider#getDefaultTemplateName()}
   */
  @Test
  @DisplayName("Test getDefaultTemplateName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractResourceTemplateProvider.getDefaultTemplateName()"})
  void testGetDefaultTemplateName() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act and Assert
    assertEquals("Default Template Name", simpleMarkupTemplateProvider.getDefaultTemplateName());
  }
}
