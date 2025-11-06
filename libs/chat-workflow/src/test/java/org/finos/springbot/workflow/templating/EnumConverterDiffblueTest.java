package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

class EnumConverterDiffblueTest {
  /**
   * Method under test: {@link EnumConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert() {
    // Arrange
    EnumConverter<Object> enumConverter = new EnumConverter<>(null);

    // Act and Assert
    assertFalse(enumConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Method under test: {@link EnumConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert2() {
    // Arrange
    EnumConverter<Object> enumConverter = new EnumConverter<>(null);
    Class<Object> t = Object.class;

    // Act and Assert
    assertFalse(enumConverter.canConvert(null, t));
  }

  /**
   * Method under test: {@link EnumConverter#EnumConverter(Rendering)}
   */
  @Test
  void testNewEnumConverter() {
    // Arrange and Act
    EnumConverter<Object> actualEnumConverter = new EnumConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualEnumConverter.getPriority());
  }
}
