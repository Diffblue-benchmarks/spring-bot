package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.templating.TableConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FreemarkerTypeConverterConfig.class})
@ExtendWith(SpringExtension.class)
class FreemarkerTypeConverterConfigDiffblueTest {
  @Autowired
  private FreemarkerTypeConverterConfig freemarkerTypeConverterConfig;

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#symphonyFreeMarkerRendering()}
   */
  @Test
  void testSymphonyFreeMarkerRendering() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FreemarkerRendering actualSymphonyFreeMarkerRenderingResult = (new FreemarkerTypeConverterConfig())
        .symphonyFreeMarkerRendering();

    // Assert
    assertEquals(".With", actualSymphonyFreeMarkerRenderingResult.extend("With"));
    assertEquals("<span>foo</span>", actualSymphonyFreeMarkerRenderingResult.description("foo"));
    assertNull(actualSymphonyFreeMarkerRenderingResult.buttons("Location"));
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmBeanConverter(FreemarkerRendering)}
   */
  @Test
  void testFmBeanConverter() {
    // Arrange, Act and Assert
    assertEquals(2000, freemarkerTypeConverterConfig.fmBeanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmBooleanConverter(FreemarkerRendering)}
   */
  @Test
  void testFmBooleanConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.fmBooleanConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmCollectionConverter(FreemarkerRendering)}
   */
  @Test
  void testFmCollectionConverter() {
    // Arrange and Act
    TableConverter<String> actualFmCollectionConverterResult = freemarkerTypeConverterConfig
        .fmCollectionConverter(new FreemarkerRendering());

    // Assert
    assertTrue(actualFmCollectionConverterResult.getR() instanceof FreemarkerRendering);
    assertEquals(50, actualFmCollectionConverterResult.getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmEnumConverter(FreemarkerRendering)}
   */
  @Test
  void testFmEnumConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.fmEnumConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#hashTagConverter(FreemarkerRendering)}
   */
  @Test
  void testHashTagConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.hashTagConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#timeConverter(FreemarkerRendering)}
   */
  @Test
  void testTimeConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.timeConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmTextFieldConverter(FreemarkerRendering)}
   */
  @Test
  void testFmTextFieldConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.fmTextFieldConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmRoomConverter(FreemarkerRendering)}
   */
  @Test
  void testFmRoomConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.fmRoomConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#fmDropdownAnnotationConverter(FreemarkerRendering)}
   */
  @Test
  void testFmDropdownAnnotationConverter() {
    // Arrange, Act and Assert
    assertEquals(40,
        freemarkerTypeConverterConfig.fmDropdownAnnotationConverter(new FreemarkerRendering()).getPriority());
  }

  /**
   * Method under test:
   * {@link FreemarkerTypeConverterConfig#rmUserConverter(FreemarkerRendering)}
   */
  @Test
  void testRmUserConverter() {
    // Arrange, Act and Assert
    assertEquals(50, freemarkerTypeConverterConfig.rmUserConverter(new FreemarkerRendering()).getPriority());
  }
}
