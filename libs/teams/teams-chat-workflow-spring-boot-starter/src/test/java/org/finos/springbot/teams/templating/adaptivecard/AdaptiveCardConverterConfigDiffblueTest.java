package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdaptiveCardConverterConfig.class})
@ExtendWith(SpringExtension.class)
class AdaptiveCardConverterConfigDiffblueTest {
  @Autowired
  private AdaptiveCardConverterConfig adaptiveCardConverterConfig;

  /**
   * Test {@link AdaptiveCardConverterConfig#adaptiveCardRendering()}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#adaptiveCardRendering()}
   */
  @Test
  @DisplayName("Test adaptiveCardRendering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdaptiveCardRendering AdaptiveCardConverterConfig.adaptiveCardRendering()"})
  void testAdaptiveCardRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    AdaptiveCardRendering actualAdaptiveCardRenderingResult = (new AdaptiveCardConverterConfig())
        .adaptiveCardRendering();

    // Assert
    assertTrue(actualAdaptiveCardRenderingResult.buttons("Location") instanceof ObjectNode);
    assertTrue(actualAdaptiveCardRenderingResult.description("foo") instanceof ObjectNode);
    assertEquals(".With", actualAdaptiveCardRenderingResult.extend("With"));
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acBeanConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acBeanConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acBeanConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.BeanConverter AdaptiveCardConverterConfig.acBeanConverter(AdaptiveCardRendering)"})
  void testAcBeanConverter() {
    // Arrange, Act and Assert
    assertEquals(2000, adaptiveCardConverterConfig.acBeanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acBooleanConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acBooleanConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acBooleanConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.BooleanConverter AdaptiveCardConverterConfig.acBooleanConverter(AdaptiveCardRendering)"})
  void testAcBooleanConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acBooleanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acCollectionConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acCollectionConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acCollectionConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.CollectionConverter AdaptiveCardConverterConfig.acCollectionConverter(AdaptiveCardRendering)"})
  void testAcCollectionConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acCollectionConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acEnumConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acEnumConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acEnumConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.EnumConverter AdaptiveCardConverterConfig.acEnumConverter(AdaptiveCardRendering)"})
  void testAcEnumConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acEnumConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acTimeConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acTimeConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acTimeConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.TimeConverter AdaptiveCardConverterConfig.acTimeConverter(AdaptiveCardRendering)"})
  void testAcTimeConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acTimeConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acTextFieldConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acTextFieldConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acTextFieldConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.adaptivecard.ValidatingTextFieldConverter AdaptiveCardConverterConfig.acTextFieldConverter(AdaptiveCardRendering)"})
  void testAcTextFieldConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acTextFieldConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acUserConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acUserConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acUserConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.UserConverter AdaptiveCardConverterConfig.acUserConverter(AdaptiveCardRendering)"})
  void testAcUserConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acUserConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acChatConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acChatConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acChatConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.ChatConverter AdaptiveCardConverterConfig.acChatConverter(AdaptiveCardRendering)"})
  void testAcChatConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acChatConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acDropdownAnnotationConverter(AdaptiveCardRendering)}.
   * <p>
   * Method under test: {@link AdaptiveCardConverterConfig#acDropdownAnnotationConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName("Test acDropdownAnnotationConverter(AdaptiveCardRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.DropdownAnnotationConverter AdaptiveCardConverterConfig.acDropdownAnnotationConverter(AdaptiveCardRendering)"})
  void testAcDropdownAnnotationConverter() {
    // Arrange, Act and Assert
    assertEquals(40,
        adaptiveCardConverterConfig.acDropdownAnnotationConverter(new AdaptiveCardRendering()).getPriority());
  }
}
