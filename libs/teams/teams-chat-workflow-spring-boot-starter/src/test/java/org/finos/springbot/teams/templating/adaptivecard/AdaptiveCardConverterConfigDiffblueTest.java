package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdaptiveCardConverterConfigDiffblueTest {
  /**
   * Test {@link AdaptiveCardConverterConfig#acBeanConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acBeanConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acBeanConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BeanConverter AdaptiveCardConverterConfig.acBeanConverter(AdaptiveCardRendering)"
  })
  void testAcBeanConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        2000,
        adaptiveCardConverterConfig.acBeanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acBooleanConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acBooleanConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acBooleanConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BooleanConverter AdaptiveCardConverterConfig.acBooleanConverter(AdaptiveCardRendering)"
  })
  void testAcBooleanConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        adaptiveCardConverterConfig.acBooleanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acCollectionConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acCollectionConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acCollectionConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.CollectionConverter AdaptiveCardConverterConfig.acCollectionConverter(AdaptiveCardRendering)"
  })
  void testAcCollectionConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        adaptiveCardConverterConfig
            .acCollectionConverter(new AdaptiveCardRendering())
            .getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acEnumConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acEnumConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acEnumConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.EnumConverter AdaptiveCardConverterConfig.acEnumConverter(AdaptiveCardRendering)"
  })
  void testAcEnumConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50, adaptiveCardConverterConfig.acEnumConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acTimeConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acTimeConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acTimeConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TimeConverter AdaptiveCardConverterConfig.acTimeConverter(AdaptiveCardRendering)"
  })
  void testAcTimeConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50, adaptiveCardConverterConfig.acTimeConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acTextFieldConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acTextFieldConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acTextFieldConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.templating.adaptivecard.ValidatingTextFieldConverter AdaptiveCardConverterConfig.acTextFieldConverter(AdaptiveCardRendering)"
  })
  void testAcTextFieldConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        adaptiveCardConverterConfig
            .acTextFieldConverter(new AdaptiveCardRendering())
            .getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acUserConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acUserConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acUserConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter AdaptiveCardConverterConfig.acUserConverter(AdaptiveCardRendering)"
  })
  void testAcUserConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50, adaptiveCardConverterConfig.acUserConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acChatConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acChatConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acChatConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.ChatConverter AdaptiveCardConverterConfig.acChatConverter(AdaptiveCardRendering)"
  })
  void testAcChatConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        50, adaptiveCardConverterConfig.acChatConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Test {@link AdaptiveCardConverterConfig#acDropdownAnnotationConverter(AdaptiveCardRendering)}.
   *
   * <ul>
   *   <li>Given {@link AdaptiveCardConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdaptiveCardConverterConfig#acDropdownAnnotationConverter(AdaptiveCardRendering)}
   */
  @Test
  @DisplayName(
      "Test acDropdownAnnotationConverter(AdaptiveCardRendering); given AdaptiveCardConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.DropdownAnnotationConverter AdaptiveCardConverterConfig.acDropdownAnnotationConverter(AdaptiveCardRendering)"
  })
  void testAcDropdownAnnotationConverter_givenAdaptiveCardConverterConfig() {
    // Arrange
    AdaptiveCardConverterConfig adaptiveCardConverterConfig = new AdaptiveCardConverterConfig();

    // Act and Assert
    assertEquals(
        40,
        adaptiveCardConverterConfig
            .acDropdownAnnotationConverter(new AdaptiveCardRendering())
            .getPriority());
  }
}
