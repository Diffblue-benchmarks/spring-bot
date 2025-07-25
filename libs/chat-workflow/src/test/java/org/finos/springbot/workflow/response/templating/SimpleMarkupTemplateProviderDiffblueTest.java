package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ResourceLoader;

class SimpleMarkupTemplateProviderDiffblueTest {
  /**
   * Test {@link SimpleMarkupTemplateProvider#SimpleMarkupTemplateProvider(String, String, String,
   * ResourceLoader, BiFunction)}.
   *
   * <p>Method under test: {@link SimpleMarkupTemplateProvider#SimpleMarkupTemplateProvider(String,
   * String, String, ResourceLoader, BiFunction)}
   */
  @Test
  @DisplayName(
      "Test new SimpleMarkupTemplateProvider(String, String, String, ResourceLoader, BiFunction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleMarkupTemplateProvider.<init>(String, String, String, ResourceLoader, BiFunction)"
  })
  void testNewSimpleMarkupTemplateProvider() {
    // Arrange, Act and Assert
    assertEquals(
        "Default Template Name",
        new SimpleMarkupTemplateProvider(
                "Template Prefix",
                "Template Suffix",
                "Default Template Name",
                new ApplicationResourceLoader(),
                mock(BiFunction.class))
            .getDefaultTemplateName());
  }

  /**
   * Test {@link SimpleMarkupTemplateProvider#toMarkup(String, Markup)}.
   *
   * <p>Method under test: {@link SimpleMarkupTemplateProvider#toMarkup(String, Markup)}
   */
  @Test
  @DisplayName("Test toMarkup(String, Markup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup SimpleMarkupTemplateProvider.toMarkup(String, Markup)"})
  void testToMarkup() {
    // Arrange, Act and Assert
    assertEquals(
        "foo",
        new SimpleMarkupTemplateProvider(
                "Template Prefix",
                "Template Suffix",
                "Default Template Name",
                new ApplicationResourceLoader(),
                mock(BiFunction.class))
            .toMarkup("foo", mock(Markup.class))
            .getContents());
  }

  /**
   * Test {@link SimpleMarkupTemplateProvider#createContext(MessageResponse)}.
   *
   * <p>Method under test: {@link SimpleMarkupTemplateProvider#createContext(MessageResponse)}
   */
  @Test
  @DisplayName("Test createContext(MessageResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Markup SimpleMarkupTemplateProvider.createContext(MessageResponse)"})
  void testCreateContext() {
    // Arrange
    SimpleMarkupTemplateProvider simpleMarkupTemplateProvider =
        new SimpleMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));

    // Act and Assert
    assertEquals(
        "",
        simpleMarkupTemplateProvider
            .createContext(
                new MessageResponse(mock(Addressable.class), "Not all who wander are lost"))
            .getContents());
  }
}
