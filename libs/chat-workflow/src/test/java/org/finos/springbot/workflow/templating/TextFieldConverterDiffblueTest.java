package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TextFieldConverterDiffblueTest {
  /**
   * Method under test:
   * {@link TextFieldConverter#TextFieldConverter(int, Rendering, Class[])}
   */
  @Test
  void testNewTextFieldConverter() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    TextFieldConverter<Object> actualTextFieldConverter = new TextFieldConverter<>(1, null, forNameResult);

    // Assert
    assertEquals(1, actualTextFieldConverter.getPriority());
  }
}
