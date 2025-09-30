package org.finos.springbot.symphony.response.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.response.templating.Markup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SymphonyMarkupTemplateProvider.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SymphonyMarkupTemplateProviderDiffblueTest {
  @MockitoBean private BiFunction<Content, Markup, String> biFunction;

  @Autowired private SymphonyMarkupTemplateProvider symphonyMarkupTemplateProvider;

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   *
   * <ul>
   *   <li>When {@code Markup}.
   *   <li>Then return {@code Markup}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName("Test prepareMarkupForInsertion(String); when 'Markup'; then return 'Markup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(String)"})
  void testPrepareMarkupForInsertion_whenMarkup_thenReturnMarkup() {
    // Arrange, Act and Assert
    assertEquals("Markup", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("Markup"));
  }

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   *
   * <ul>
   *   <li>When {@code <messageML>}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName(
      "Test prepareMarkupForInsertion(String); when '<messageML>'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(String)"})
  void testPrepareMarkupForInsertion_whenMessageML_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("<messageML>"));
  }

  /**
   * Test {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}.
   *
   * <ul>
   *   <li>When {@code </messageML>}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyMarkupTemplateProvider#prepareMarkupForInsertion(String)}
   */
  @Test
  @DisplayName(
      "Test prepareMarkupForInsertion(String); when '</messageML>'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyMarkupTemplateProvider.prepareMarkupForInsertion(String)"})
  void testPrepareMarkupForInsertion_whenMessageML_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", symphonyMarkupTemplateProvider.prepareMarkupForInsertion("</messageML>"));
  }
}
