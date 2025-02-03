package org.finos.springbot.symphony.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.templating.Markup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyMarkupTemplateProvider.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SymphonyMarkupTemplateProviderDiffblueTest {
  @MockBean
  private BiFunction<Content, Markup, String> biFunction;

  @MockBean
  private ResourceLoader resourceLoader;

  @Autowired
  private SymphonyMarkupTemplateProvider symphonyMarkupTemplateProvider;

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   * <ul>
   *   <li>When {@code Markup}.</li>
   *   <li>Then return {@code Markup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String); when 'Markup'; then return 'Markup'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(java.lang.String)"})
  void testPrepareMarkupForInsertion_whenMarkup_thenReturnMarkup() {
    // Arrange, Act and Assert
    assertEquals("Markup", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("Markup"));
  }

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   * <ul>
   *   <li>When {@code <messageML>}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String); when '<messageML>'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(java.lang.String)"})
  void testPrepareMarkupForInsertion_whenMessageML_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("<messageML>"));
  }

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   * <ul>
   *   <li>When {@code </messageML>}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String); when '</messageML>'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(java.lang.String)"})
  void testPrepareMarkupForInsertion_whenMessageML_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("</messageML>"));
  }
}
