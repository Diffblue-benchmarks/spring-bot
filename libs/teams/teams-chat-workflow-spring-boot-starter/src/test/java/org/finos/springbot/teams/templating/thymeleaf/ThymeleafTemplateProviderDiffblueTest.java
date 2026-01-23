package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.microsoft.bot.schema.Entity;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.response.templating.MarkupAndEntities;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.templating.Mode;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThymeleafTemplateProvider.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ThymeleafTemplateProviderDiffblueTest {
  @Autowired private ThymeleafTemplateProvider thymeleafTemplateProvider;

  @MockitoBean private ThymeleafTemplater thymeleafTemplater;

  /**
   * Test {@link ThymeleafTemplateProvider#ThymeleafTemplateProvider(String, String, String,
   * ResourceLoader, ThymeleafTemplater)}.
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#ThymeleafTemplateProvider(String,
   * String, String, ResourceLoader, ThymeleafTemplater)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplateProvider(String, String, String, ResourceLoader, ThymeleafTemplater)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThymeleafTemplateProvider.<init>(String, String, String, ResourceLoader, ThymeleafTemplater)"
  })
  void testNewThymeleafTemplateProvider() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    // Act
    ThymeleafTemplateProvider actualThymeleafTemplateProvider =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);

    // Assert
    assertEquals("", actualThymeleafTemplateProvider.deserializeTemplate(null));
    assertNull(actualThymeleafTemplateProvider.getTemplateForName("Name"));
  }

  /**
   * Test {@link ThymeleafTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link
   *       Addressable} and e is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName(
      "Test needsButtons(Response); when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThymeleafTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse r = new ErrorResponse(stream, new Throwable());

    // Act and Assert
    assertFalse(ThymeleafTemplateProvider.needsButtons(r));
  }

  /**
   * Test {@link ThymeleafTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link Response}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName("Test needsButtons(Response); when Response")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThymeleafTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenResponse() {
    // Arrange, Act and Assert
    assertFalse(ThymeleafTemplateProvider.needsButtons(mock(Response.class)));
  }

  /**
   * Test {@link ThymeleafTemplateProvider#needsButtons(Response)}.
   *
   * <ul>
   *   <li>When {@link WorkResponse#WorkResponse(Addressable, Object, WorkMode)} with to is {@link
   *       Addressable} and o is {@code 42} and m is {@code BOTH}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#needsButtons(Response)}
   */
  @Test
  @DisplayName(
      "Test needsButtons(Response); when WorkResponse(Addressable, Object, WorkMode) with to is Addressable and o is '42' and m is 'BOTH'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThymeleafTemplateProvider.needsButtons(Response)"})
  void testNeedsButtons_whenWorkResponseWithToIsAddressableAndOIs42AndMIsBoth() {
    // Arrange, Act and Assert
    assertFalse(
        ThymeleafTemplateProvider.needsButtons(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
  }

  /**
   * Test {@link ThymeleafTemplateProvider#deserializeTemplate(InputStream)}.
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#deserializeTemplate(InputStream)}
   */
  @Test
  @DisplayName("Test deserializeTemplate(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplateProvider.deserializeTemplate(InputStream)"})
  void testDeserializeTemplate() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", thymeleafTemplateProvider.deserializeTemplate(is));
    int actualReadResult = is.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)} with {@code String},
   * {@code WorkResponse}.
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  @DisplayName("Test applyTemplate(String, WorkResponse) with 'String', 'WorkResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarkupAndEntities ThymeleafTemplateProvider.applyTemplate(String, WorkResponse)"
  })
  void testApplyTemplateWithStringWorkResponse() {
    // Arrange
    WorkResponse t = new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH, "$");

    // Act
    MarkupAndEntities actualApplyTemplateResult =
        thymeleafTemplateProvider.applyTemplate("Template", t);

    // Assert
    assertEquals("Template", actualApplyTemplateResult.getContents());
    assertTrue(actualApplyTemplateResult.getEntities().isEmpty());
  }

  /**
   * Test {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)} with {@code String},
   * {@code WorkResponse}.
   *
   * <ul>
   *   <li>Then return Contents is {@code Template}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  @DisplayName(
      "Test applyTemplate(String, WorkResponse) with 'String', 'WorkResponse'; then return Contents is 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarkupAndEntities ThymeleafTemplateProvider.applyTemplate(String, WorkResponse)"
  })
  void testApplyTemplateWithStringWorkResponse_thenReturnContentsIsTemplate() {
    // Arrange and Act
    MarkupAndEntities actualApplyTemplateResult =
        thymeleafTemplateProvider.applyTemplate(
            "Template", new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    assertEquals("Template", actualApplyTemplateResult.getContents());
    assertTrue(actualApplyTemplateResult.getEntities().isEmpty());
  }

  /**
   * Test {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)} with {@code String},
   * {@code WorkResponse}.
   *
   * <ul>
   *   <li>Then return Entities size is one.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplateProvider#applyTemplate(String, WorkResponse)}
   */
  @Test
  @DisplayName(
      "Test applyTemplate(String, WorkResponse) with 'String', 'WorkResponse'; then return Entities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MarkupAndEntities ThymeleafTemplateProvider.applyTemplate(String, WorkResponse)"
  })
  void testApplyTemplateWithStringWorkResponse_thenReturnEntitiesSizeIsOne() {
    // Arrange and Act
    MarkupAndEntities actualApplyTemplateResult =
        thymeleafTemplateProvider.applyTemplate(
            "<at key=\"UU\">UU</at>",
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    List<Entity> entities = actualApplyTemplateResult.getEntities();
    assertEquals(1, entities.size());
    Entity getResult = entities.get(0);
    Map<String, JsonNode> properties = getResult.getProperties();
    assertEquals(2, properties.size());
    assertTrue(properties.get("mentioned") instanceof ObjectNode);
    assertTrue(properties.get("text") instanceof TextNode);
    assertEquals("<at>UU</at>", actualApplyTemplateResult.getContents());
    assertEquals("mention", getResult.getType());
  }
}
