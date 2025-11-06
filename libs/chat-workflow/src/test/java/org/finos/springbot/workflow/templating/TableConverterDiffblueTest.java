package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

class TableConverterDiffblueTest {
  /**
   * Method under test: {@link TableConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(null);

    // Act and Assert
    assertFalse(tableConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Method under test: {@link TableConverter#TableConverter(TableRendering)}
   */
  @Test
  void testNewTableConverter() {
    // Arrange and Act
    TableConverter<Object> actualTableConverter = new TableConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualTableConverter.getPriority());
  }
}
