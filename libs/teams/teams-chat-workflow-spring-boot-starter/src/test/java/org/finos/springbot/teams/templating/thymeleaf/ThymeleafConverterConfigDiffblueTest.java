package org.finos.springbot.teams.templating.thymeleaf;

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

@ContextConfiguration(classes = {ThymeleafConverterConfig.class})
@ExtendWith(SpringExtension.class)
class ThymeleafConverterConfigDiffblueTest {
  @Autowired private ThymeleafConverterConfig thymeleafConverterConfig;

  /**
   * Test {@link ThymeleafConverterConfig#thymleafRendering()}.
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#thymleafRendering()}
   */
  @Test
  @DisplayName("Test thymleafRendering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ThymeleafRendering ThymeleafConverterConfig.thymleafRendering()"})
  void testThymleafRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    ThymeleafRendering actualThymleafRenderingResult =
        new ThymeleafConverterConfig().thymleafRendering();

    // Assert
    assertEquals(".With", actualThymleafRenderingResult.extend("With"));
    assertEquals("<span>foo</span>", actualThymleafRenderingResult.description("foo"));
    assertNull(actualThymleafRenderingResult.buttons("Location"));
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlBeanConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BeanConverter ThymeleafConverterConfig.tlBeanConverter(ThymeleafRendering)"
  })
  void testTlBeanConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        2000, thymeleafConverterConfig.tlBeanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlBeanConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BeanConverter ThymeleafConverterConfig.tlBeanConverter(ThymeleafRendering)"
  })
  void testTlBeanConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        2000, thymeleafConverterConfig.tlBeanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlBooleanConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BooleanConverter ThymeleafConverterConfig.tlBooleanConverter(ThymeleafRendering)"
  })
  void testTlBooleanConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlBooleanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlBooleanConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.BooleanConverter ThymeleafConverterConfig.tlBooleanConverter(ThymeleafRendering)"
  })
  void testTlBooleanConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlBooleanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlTableConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TableConverter ThymeleafConverterConfig.tlTableConverter(ThymeleafRendering)"
  })
  void testTlTableConverter_givenThymeleafConverterConfig() {
    // Arrange and Act
    TableConverter<String> actualTlTableConverterResult =
        thymeleafConverterConfig.tlTableConverter(new ThymeleafRendering());

    // Assert
    assertTrue(actualTlTableConverterResult.getR() instanceof ThymeleafRendering);
    assertEquals(50, actualTlTableConverterResult.getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Then return R is {@link ThymeleafRendering} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlTableConverter(ThymeleafRendering); then return R is ThymeleafRendering (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TableConverter ThymeleafConverterConfig.tlTableConverter(ThymeleafRendering)"
  })
  void testTlTableConverter_thenReturnRIsThymeleafRendering() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();
    ThymeleafRendering r = new ThymeleafRendering();

    // Act
    TableConverter<String> actualTlTableConverterResult =
        thymeleafConverterConfig.tlTableConverter(r);

    // Assert
    TableRendering<String> r2 = actualTlTableConverterResult.getR();
    assertTrue(r2 instanceof ThymeleafRendering);
    assertEquals(50, actualTlTableConverterResult.getPriority());
    assertSame(r, r2);
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlEnumConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.EnumConverter ThymeleafConverterConfig.tlEnumConverter(ThymeleafRendering)"
  })
  void testTlEnumConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlEnumConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlEnumConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.EnumConverter ThymeleafConverterConfig.tlEnumConverter(ThymeleafRendering)"
  })
  void testTlEnumConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlEnumConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlTimeConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TimeConverter ThymeleafConverterConfig.tlTimeConverter(ThymeleafRendering)"
  })
  void testTlTimeConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlTimeConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlTimeConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TimeConverter ThymeleafConverterConfig.tlTimeConverter(ThymeleafRendering)"
  })
  void testTlTimeConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlTimeConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test textFieldConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TextFieldConverter ThymeleafConverterConfig.textFieldConverter(ThymeleafRendering)"
  })
  void testTextFieldConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.textFieldConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test textFieldConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.TextFieldConverter ThymeleafConverterConfig.textFieldConverter(ThymeleafRendering)"
  })
  void testTextFieldConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.textFieldConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlUserConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter ThymeleafConverterConfig.tlUserConverter(ThymeleafRendering)"
  })
  void testTlUserConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlUserConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlUserConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.UserConverter ThymeleafConverterConfig.tlUserConverter(ThymeleafRendering)"
  })
  void testTlUserConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlUserConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName("Test tlChatConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.ChatConverter ThymeleafConverterConfig.tlChatConverter(ThymeleafRendering)"
  })
  void testTlChatConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlChatConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlChatConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.ChatConverter ThymeleafConverterConfig.tlChatConverter(ThymeleafRendering)"
  })
  void testTlChatConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        50, thymeleafConverterConfig.tlChatConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlDropdownAnnotationConverter(ThymeleafRendering); given ThymeleafConverterConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.DropdownAnnotationConverter ThymeleafConverterConfig.tlDropdownAnnotationConverter(ThymeleafRendering)"
  })
  void testTlDropdownAnnotationConverter_givenThymeleafConverterConfig() {
    // Arrange, Act and Assert
    assertEquals(
        40,
        thymeleafConverterConfig
            .tlDropdownAnnotationConverter(new ThymeleafRendering())
            .getPriority());
  }

  /**
   * Test {@link ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}.
   *
   * <ul>
   *   <li>Given {@link ThymeleafConverterConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}
   */
  @Test
  @DisplayName(
      "Test tlDropdownAnnotationConverter(ThymeleafRendering); given ThymeleafConverterConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.templating.DropdownAnnotationConverter ThymeleafConverterConfig.tlDropdownAnnotationConverter(ThymeleafRendering)"
  })
  void testTlDropdownAnnotationConverter_givenThymeleafConverterConfig2() {
    // Arrange
    ThymeleafConverterConfig thymeleafConverterConfig = new ThymeleafConverterConfig();

    // Act and Assert
    assertEquals(
        40,
        thymeleafConverterConfig
            .tlDropdownAnnotationConverter(new ThymeleafRendering())
            .getPriority());
  }
}
