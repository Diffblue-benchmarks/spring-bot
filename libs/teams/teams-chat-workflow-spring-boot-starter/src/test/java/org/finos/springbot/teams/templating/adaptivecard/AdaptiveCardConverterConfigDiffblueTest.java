package org.finos.springbot.teams.templating.adaptivecard;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acBeanConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcBeanConverter() {
    // Arrange, Act and Assert
    assertEquals(2000, adaptiveCardConverterConfig.acBeanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acBooleanConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcBooleanConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acBooleanConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acCollectionConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcCollectionConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acCollectionConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acEnumConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcEnumConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acEnumConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acTimeConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcTimeConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acTimeConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acTextFieldConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcTextFieldConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acTextFieldConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acUserConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcUserConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acUserConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acChatConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcChatConverter() {
    // Arrange, Act and Assert
    assertEquals(50, adaptiveCardConverterConfig.acChatConverter(new AdaptiveCardRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link AdaptiveCardConverterConfig#acDropdownAnnotationConverter(AdaptiveCardRendering)}
   */
  @Test
  void testAcDropdownAnnotationConverter() {
    // Arrange, Act and Assert
    assertEquals(40,
        adaptiveCardConverterConfig.acDropdownAnnotationConverter(new AdaptiveCardRendering()).getPriority());
  }
}
