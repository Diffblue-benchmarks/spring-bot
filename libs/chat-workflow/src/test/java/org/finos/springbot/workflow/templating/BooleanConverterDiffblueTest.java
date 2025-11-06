package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class BooleanConverterDiffblueTest {
  /**
   * Method under test:
   * {@link BooleanConverter#BooleanConverter(int, Rendering, Class[])}
   */
  @Test
  void testNewBooleanConverter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    BooleanConverter<Object> actualBooleanConverter = new BooleanConverter<>(1, null, forNameResult);

    // Assert
    assertEquals(1, actualBooleanConverter.getPriority());
  }

  /**
   * Method under test: {@link BooleanConverter#BooleanConverter(Rendering)}
   */
  @Test
  void testNewBooleanConverter2() {
    // Arrange and Act
    BooleanConverter<Object> actualBooleanConverter = new BooleanConverter<>(null);

    // Assert
    assertNull(actualBooleanConverter.r);
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualBooleanConverter.getPriority());
  }
}
