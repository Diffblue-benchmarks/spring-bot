package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AbstractTypeConverterDiffblueTest {
  /**
   * Method under test: {@link AbstractTypeConverter#getPriority()}
   */
  @Test
  void testGetPriority() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);

    // Act and Assert
    assertEquals(AbstractTypeConverter.BOTTOM_PRIORITY, beanConverter.getPriority());
  }
}
