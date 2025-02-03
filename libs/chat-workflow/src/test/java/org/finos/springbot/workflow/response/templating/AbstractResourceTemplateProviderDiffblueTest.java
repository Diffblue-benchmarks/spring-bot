package org.finos.springbot.workflow.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.io.ApplicationResourceLoader;

class AbstractResourceTemplateProviderDiffblueTest {
  /**
   * Test {@link AbstractResourceTemplateProvider#getDefaultTemplateName()}.
   * <p>
   * Method under test: {@link AbstractResourceTemplateProvider#getDefaultTemplateName()}
   */
  @Test
  @DisplayName("Test getDefaultTemplateName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.response.templating.AbstractResourceTemplateProvider.getDefaultTemplateName()"})
  void testGetDefaultTemplateName() {
    // Arrange, Act and Assert
    assertEquals("Default Template Name", (new SimpleMarkupTemplateProvider("Template Prefix", "Template Suffix",
        "Default Template Name", new ApplicationResourceLoader(), mock(BiFunction.class))).getDefaultTemplateName());
  }
}
