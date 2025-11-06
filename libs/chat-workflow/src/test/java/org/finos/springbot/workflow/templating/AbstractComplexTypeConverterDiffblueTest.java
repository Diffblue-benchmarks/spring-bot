package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AbstractComplexTypeConverterDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}
   */
  @Test
  void testWithFields() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);
    BeanConverter<Object> controller = new BeanConverter<>(null);
    Class<Object> c = Object.class;

    // Act and Assert
    assertTrue(beanConverter.withFields(controller, c, true, null, null).isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}
   */
  @Test
  void testWithFields2() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);

    // Act and Assert
    assertTrue(beanConverter.withFields(new BeanConverter<>(null), null, true, null, null).isEmpty());
  }

  /**
   * Method under test: {@link AbstractComplexTypeConverter#getFields(Class)}
   */
  @Test
  void testGetFields() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);
    Class<Object> c = Object.class;

    // Act and Assert
    assertTrue(beanConverter.getFields(c).isEmpty());
  }

  /**
   * Method under test: {@link AbstractComplexTypeConverter#getFields(Class)}
   */
  @Test
  void testGetFields2() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(null);

    // Act and Assert
    assertTrue(beanConverter.getFields(null).isEmpty());
  }
}
