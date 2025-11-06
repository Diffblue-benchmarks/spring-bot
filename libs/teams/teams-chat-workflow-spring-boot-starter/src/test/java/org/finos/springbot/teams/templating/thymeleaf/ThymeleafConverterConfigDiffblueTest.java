package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.templating.TableConverter;
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
   * Method under test: {@link ThymeleafConverterConfig#thymleafRendering()}
   */
  @Test
  void testThymleafRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ThymeleafRendering actualThymleafRenderingResult = (new ThymeleafConverterConfig()).thymleafRendering();

    // Assert
    assertEquals(".With", actualThymleafRenderingResult.extend("With"));
    assertEquals("<span>foo</span>", actualThymleafRenderingResult.description("foo"));
    assertNull(actualThymleafRenderingResult.buttons("Location"));
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlBeanConverter(ThymeleafRendering)}
   */
  @Test
  void testTlBeanConverter() {
    // Arrange, Act and Assert
    assertEquals(2000, thymeleafConverterConfig.tlBeanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlBooleanConverter(ThymeleafRendering)}
   */
  @Test
  void testTlBooleanConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlBooleanConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlTableConverter(ThymeleafRendering)}
   */
  @Test
  void testTlTableConverter() {
    // Arrange and Act
    TableConverter<String> actualTlTableConverterResult = thymeleafConverterConfig
        .tlTableConverter(new ThymeleafRendering());

    // Assert
    assertTrue(actualTlTableConverterResult.getR() instanceof ThymeleafRendering);
    assertEquals(50, actualTlTableConverterResult.getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlEnumConverter(ThymeleafRendering)}
   */
  @Test
  void testTlEnumConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlEnumConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlTimeConverter(ThymeleafRendering)}
   */
  @Test
  void testTlTimeConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlTimeConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#textFieldConverter(ThymeleafRendering)}
   */
  @Test
  void testTextFieldConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.textFieldConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlUserConverter(ThymeleafRendering)}
   */
  @Test
  void testTlUserConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlUserConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlChatConverter(ThymeleafRendering)}
   */
  @Test
  void testTlChatConverter() {
    // Arrange, Act and Assert
    assertEquals(50, thymeleafConverterConfig.tlChatConverter(new ThymeleafRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link ThymeleafConverterConfig#tlDropdownAnnotationConverter(ThymeleafRendering)}
   */
  @Test
  void testTlDropdownAnnotationConverter() {
    // Arrange, Act and Assert
    assertEquals(40, thymeleafConverterConfig.tlDropdownAnnotationConverter(new ThymeleafRendering()).getPriority());
  }
}
