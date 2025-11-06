package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

class AbstractClassConverterDiffblueTest {
  /**
   * Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert() {
    // Arrange
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(null);

    // Act and Assert
    assertFalse(booleanConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert2() {
    // Arrange
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(null);
    Class<Object> t = Object.class;

    // Act and Assert
    assertFalse(booleanConverter.canConvert(null, t));
  }

  /**
   * Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert3() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(2, null, forNameResult);
    Class<Object> t = Object.class;

    // Act and Assert
    assertTrue(booleanConverter.canConvert(null, t));
  }
}
