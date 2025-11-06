package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TimeConverterDiffblueTest {
  /**
   * Method under test:
   * {@link TimeConverter#TimeConverter(int, Rendering, Class[])}
   */
  @Test
  void testNewTimeConverter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    TimeConverter<Object> actualTimeConverter = new TimeConverter<>(1, null, forNameResult);

    // Assert
    assertEquals(1, actualTimeConverter.getPriority());
  }

  /**
   * Method under test: {@link TimeConverter#TimeConverter(Rendering)}
   */
  @Test
  void testNewTimeConverter2() {
    // Arrange and Act
    TimeConverter<Object> actualTimeConverter = new TimeConverter<>(null);

    // Assert
    assertNull(actualTimeConverter.r);
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualTimeConverter.getPriority());
  }
}
