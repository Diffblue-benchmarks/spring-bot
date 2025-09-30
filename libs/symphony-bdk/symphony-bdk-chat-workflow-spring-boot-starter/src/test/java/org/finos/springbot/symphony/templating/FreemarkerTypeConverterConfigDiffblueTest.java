package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.templating.TableConverter;
import org.finos.springbot.workflow.templating.TableRendering;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FreemarkerTypeConverterConfig.class})
@ExtendWith(SpringExtension.class)
class FreemarkerTypeConverterConfigDiffblueTest {
  @Autowired private FreemarkerTypeConverterConfig freemarkerTypeConverterConfig;

  /**
   * Test {@link FreemarkerTypeConverterConfig#symphonyFreeMarkerRendering()}.
   *
   * <p>Method under test: {@link FreemarkerTypeConverterConfig#symphonyFreeMarkerRendering()}
   */
  @Test
  @DisplayName("Test symphonyFreeMarkerRendering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FreemarkerRendering FreemarkerTypeConverterConfig.symphonyFreeMarkerRendering()"
  })
  void testSymphonyFreeMarkerRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    FreemarkerRendering actualSymphonyFreeMarkerRenderingResult =
        new FreemarkerTypeConverterConfig().symphonyFreeMarkerRendering();

    // Assert
    assertEquals(".With", actualSymphonyFreeMarkerRenderingResult.extend("With"));
    assertEquals("<span>foo</span>", actualSymphonyFreeMarkerRenderingResult.description("foo"));
    assertNull(actualSymphonyFreeMarkerRenderingResult.buttons("Location"));
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmBeanConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmBeanConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test fmBeanConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BeanConverter FreemarkerTypeConverterConfig.fmBeanConverter(FreemarkerRendering)"
  })
  void testFmBeanConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        2000,
        freemarkerTypeConverterConfig.fmBeanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmBeanConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmBeanConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmBeanConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BeanConverter FreemarkerTypeConverterConfig.fmBeanConverter(FreemarkerRendering)"
  })
  void testFmBeanConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        2000,
        freemarkerTypeConverterConfig.fmBeanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmBooleanConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmBooleanConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test fmBooleanConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BooleanConverter FreemarkerTypeConverterConfig.fmBooleanConverter(FreemarkerRendering)"
  })
  void testFmBooleanConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig.fmBooleanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmBooleanConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmBooleanConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmBooleanConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BooleanConverter FreemarkerTypeConverterConfig.fmBooleanConverter(FreemarkerRendering)"
  })
  void testFmBooleanConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig.fmBooleanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmCollectionConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmCollectionConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmCollectionConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TableConverter FreemarkerTypeConverterConfig.fmCollectionConverter(FreemarkerRendering)"
  })
  void testFmCollectionConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange and Act
    TableConverter<String> actualFmCollectionConverterResult =
        freemarkerTypeConverterConfig.fmCollectionConverter(new FreemarkerRendering());

    // Assert
    assertTrue(actualFmCollectionConverterResult.getR() instanceof FreemarkerRendering);
    assertEquals(50, actualFmCollectionConverterResult.getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmCollectionConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Then return R is {@link FreemarkerRendering} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmCollectionConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmCollectionConverter(FreemarkerRendering); then return R is FreemarkerRendering (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TableConverter FreemarkerTypeConverterConfig.fmCollectionConverter(FreemarkerRendering)"
  })
  void testFmCollectionConverter_thenReturnRIsFreemarkerRendering() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();
    FreemarkerRendering r = new FreemarkerRendering();

    // Act
    TableConverter<String> actualFmCollectionConverterResult =
        freemarkerTypeConverterConfig.fmCollectionConverter(r);

    // Assert
    TableRendering<String> r2 = actualFmCollectionConverterResult.getR();
    assertTrue(r2 instanceof FreemarkerRendering);
    assertEquals(50, actualFmCollectionConverterResult.getPriority());
    assertSame(r, r2);
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmEnumConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmEnumConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test fmEnumConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.EnumConverter FreemarkerTypeConverterConfig.fmEnumConverter(FreemarkerRendering)"
  })
  void testFmEnumConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.fmEnumConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmEnumConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmEnumConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmEnumConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.EnumConverter FreemarkerTypeConverterConfig.fmEnumConverter(FreemarkerRendering)"
  })
  void testFmEnumConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.fmEnumConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#hashTagConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#hashTagConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test hashTagConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter FreemarkerTypeConverterConfig.hashTagConverter(FreemarkerRendering)"
  })
  void testHashTagConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig.hashTagConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#hashTagConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#hashTagConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test hashTagConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter FreemarkerTypeConverterConfig.hashTagConverter(FreemarkerRendering)"
  })
  void testHashTagConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig.hashTagConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#timeConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerTypeConverterConfig#timeConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test timeConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TimeConverter FreemarkerTypeConverterConfig.timeConverter(FreemarkerRendering)"
  })
  void testTimeConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.timeConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#timeConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerTypeConverterConfig#timeConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test timeConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TimeConverter FreemarkerTypeConverterConfig.timeConverter(FreemarkerRendering)"
  })
  void testTimeConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.timeConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmTextFieldConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmTextFieldConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmTextFieldConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TextFieldConverter FreemarkerTypeConverterConfig.fmTextFieldConverter(FreemarkerRendering)"
  })
  void testFmTextFieldConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig
            .fmTextFieldConverter(new FreemarkerRendering())
            .getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmTextFieldConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmTextFieldConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmTextFieldConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TextFieldConverter FreemarkerTypeConverterConfig.fmTextFieldConverter(FreemarkerRendering)"
  })
  void testFmTextFieldConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50,
        freemarkerTypeConverterConfig
            .fmTextFieldConverter(new FreemarkerRendering())
            .getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmRoomConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmRoomConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test fmRoomConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.ChatConverter FreemarkerTypeConverterConfig.fmRoomConverter(FreemarkerRendering)"
  })
  void testFmRoomConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.fmRoomConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmRoomConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmRoomConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmRoomConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.ChatConverter FreemarkerTypeConverterConfig.fmRoomConverter(FreemarkerRendering)"
  })
  void testFmRoomConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.fmRoomConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmDropdownAnnotationConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmDropdownAnnotationConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmDropdownAnnotationConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.DropdownAnnotationConverter FreemarkerTypeConverterConfig.fmDropdownAnnotationConverter(FreemarkerRendering)"
  })
  void testFmDropdownAnnotationConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        40,
        freemarkerTypeConverterConfig
            .fmDropdownAnnotationConverter(new FreemarkerRendering())
            .getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#fmDropdownAnnotationConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#fmDropdownAnnotationConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test fmDropdownAnnotationConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.DropdownAnnotationConverter FreemarkerTypeConverterConfig.fmDropdownAnnotationConverter(FreemarkerRendering)"
  })
  void testFmDropdownAnnotationConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        40,
        freemarkerTypeConverterConfig
            .fmDropdownAnnotationConverter(new FreemarkerRendering())
            .getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#rmUserConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#rmUserConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName("Test rmUserConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter FreemarkerTypeConverterConfig.rmUserConverter(FreemarkerRendering)"
  })
  void testRmUserConverter_givenFreemarkerTypeConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.rmUserConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Test {@link FreemarkerTypeConverterConfig#rmUserConverter(FreemarkerRendering)}.
   *
   * <ul>
   *   <li>Given {@link FreemarkerTypeConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FreemarkerTypeConverterConfig#rmUserConverter(FreemarkerRendering)}
   */
  @Test
  @DisplayName(
      "Test rmUserConverter(FreemarkerRendering); given FreemarkerTypeConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter FreemarkerTypeConverterConfig.rmUserConverter(FreemarkerRendering)"
  })
  void testRmUserConverter_givenFreemarkerTypeConverterConfig2() {
    // Arrange
    FreemarkerTypeConverterConfig freemarkerTypeConverterConfig =
        new FreemarkerTypeConverterConfig();

    // Act and Assert
    assertEquals(
        50, freemarkerTypeConverterConfig.rmUserConverter(new FreemarkerRendering()).getPriority());
  }
}
