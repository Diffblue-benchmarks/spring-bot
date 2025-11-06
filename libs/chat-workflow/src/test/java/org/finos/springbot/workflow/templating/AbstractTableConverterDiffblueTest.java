package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AbstractTableConverterDiffblueTest {
  /**
   * Method under test: {@link AbstractTableConverter#getR()}
   */
  @Test
  void testGetR() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(null);

    // Act and Assert
    assertNull(tableConverter.getR());
  }
}
