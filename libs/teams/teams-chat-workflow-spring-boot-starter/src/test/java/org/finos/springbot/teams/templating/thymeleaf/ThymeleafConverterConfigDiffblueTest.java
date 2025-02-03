package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.templating.TableConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThymeleafConverterConfig.class})
@ExtendWith(SpringExtension.class)
class ThymeleafConverterConfigDiffblueTest {
  @Autowired
  private ThymeleafConverterConfig thymeleafConverterConfig;

  /**
   * Test {@link ThymeleafConverterConfig#thymleafRendering()}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#thymleafRendering()}
   */
  @Test
  @DisplayName("Test thymleafRendering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.thymleafRendering()"})
  void testThymleafRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    ThymeleafRendering actualThymleafRenderingResult = (new ThymeleafConverterConfig()).thymleafRendering();

    // Assert
    assertEquals(".With", actualThymleafRenderingResult.extend("With"));
    assertEquals("<span>foo</span>", actualThymleafRenderingResult.description("foo"));
    assertNull(actualThymleafRenderingResult.buttons("Location"));
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlBeanConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.BeanConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlBeanConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlBeanConverter() {
    // Arrange, Act and Assert
    assertEquals(2000, thymeleafConverterConfig.tlBeanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlBooleanConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.BooleanConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlBooleanConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlBooleanConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlBooleanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlTableConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.TableConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlTableConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlTableConverter() {
    // Arrange and Act
    TableConverter<String> actualTlTableConverterResult = thymeleafConverterConfig
        .tlTableConverter(new ThymeleafRendering());

    // Assert
    assertTrue(actualTlTableConverterResult.getR() instanceof ThymeleafRendering);
    assertEquals(50, actualTlTableConverterResult.getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlEnumConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.EnumConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlEnumConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlEnumConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlEnumConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlTimeConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.TimeConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlTimeConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlTimeConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlTimeConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test textFieldConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.TextFieldConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.textFieldConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTextFieldConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.textFieldConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlUserConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.UserConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlUserConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlUserConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlUserConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlChatConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.ChatConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlChatConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlChatConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlChatConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}.
   * <p>
   * Method under test: {@link ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlDropdownAnnotationConverter(ThymeleafRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.DropdownAnnotationConverter org.finos.springbot.teams.templating.thymeleaf.ThymeleafConverterConfig.tlDropdownAnnotationConverter(org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering)"})
  void testTlDropdownAnnotationConverter() {
    // Arrange, Act and Assert
    assertEquals(40, thymeleafConverterConfig.tlDropdownAnnotationConverter(new ThymeleafRendering()).getPriority());
  }
}
