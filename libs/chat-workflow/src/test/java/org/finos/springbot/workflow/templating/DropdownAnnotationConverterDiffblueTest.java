package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

class DropdownAnnotationConverterDiffblueTest {
  /**
   * Method under test:
   * {@link DropdownAnnotationConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert() {
    // Arrange
    DropdownAnnotationConverter<Object> dropdownAnnotationConverter = new DropdownAnnotationConverter<>(null);

    // Act and Assert
    assertFalse(dropdownAnnotationConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Method under test:
   * {@link DropdownAnnotationConverter#getDropdownAnnotation(Field)}
   */
  @Test
  void testGetDropdownAnnotation() {
    // Arrange
    DropdownAnnotationConverter<Object> dropdownAnnotationConverter = new DropdownAnnotationConverter<>(null);

    // Act and Assert
    assertNull(dropdownAnnotationConverter.getDropdownAnnotation(null));
  }

  /**
   * Method under test:
   * {@link DropdownAnnotationConverter#DropdownAnnotationConverter(Rendering)}
   */
  @Test
  void testNewDropdownAnnotationConverter() {
    // Arrange and Act
    DropdownAnnotationConverter<Object> actualDropdownAnnotationConverter = new DropdownAnnotationConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.MED_PRIORITY, actualDropdownAnnotationConverter.getPriority());
  }
}
