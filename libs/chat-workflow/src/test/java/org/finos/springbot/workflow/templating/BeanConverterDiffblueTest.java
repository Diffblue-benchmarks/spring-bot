package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.Test;

class BeanConverterDiffblueTest {
  /**
   * Method under test: {@link BeanConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);

    // Act and Assert
    assertFalse(beanConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Method under test: {@link BeanConverter#canConvert(Field, Type)}
   */
  @Test
  void testCanConvert2() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);
    Class<Object> t = Object.class;

    // Act and Assert
    assertTrue(beanConverter.canConvert(null, t));
  }

  /**
   * Method under test:
   * {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  void testApply() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);
    BeanConverter<Object> controller = new BeanConverter<>(null);

    // Act and Assert
    assertNull(beanConverter.apply(null, controller, new TypePlaceHolder(1), true, null, null));
  }

  /**
   * Method under test: {@link BeanConverter#propertyPanel(WithField)}
   */
  @Test
  void testPropertyPanel() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);

    // Act and Assert
    assertEquals("Field  Name", beanConverter.propertyPanel(null).fieldNameDefaultFormatter("Field Name"));
  }

  /**
   * Method under test: {@link BeanConverter#BeanConverter(Rendering)}
   */
  @Test
  void testNewBeanConverter() {
    // Arrange and Act
    BeanConverter<Object> actualBeanConverter = new BeanConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.BOTTOM_PRIORITY, actualBeanConverter.getPriority());
  }
}
