package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractComplexTypeConverterDiffblueTest {
  /**
   * Test {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test withFields(WithType, Class, boolean, Variable, WithField); when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.templating.AbstractComplexTypeConverter.withFields(org.finos.springbot.workflow.templating.WithType, java.lang.Class, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testWithFields_whenJavaLangObject() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));
    WithType<Object> controller = mock(WithType.class);
    Class<Object> c = Object.class;

    // Act and Assert
    assertTrue(beanConverter.withFields(controller, c, true, mock(Variable.class), mock(WithField.class)).isEmpty());
  }

  /**
   * Test {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexTypeConverter#withFields(WithType, Class, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test withFields(WithType, Class, boolean, Variable, WithField); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.templating.AbstractComplexTypeConverter.withFields(org.finos.springbot.workflow.templating.WithType, java.lang.Class, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testWithFields_whenNull() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertTrue(beanConverter.withFields(mock(WithType.class), null, true, mock(Variable.class), mock(WithField.class))
        .isEmpty());
  }

  /**
   * Test {@link AbstractComplexTypeConverter#getFields(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexTypeConverter#getFields(Class)}
   */
  @Test
  @DisplayName("Test getFields(Class); when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.templating.AbstractComplexTypeConverter.getFields(java.lang.Class)"})
  void testGetFields_whenJavaLangObject() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));
    Class<Object> c = Object.class;

    // Act and Assert
    assertTrue(beanConverter.getFields(c).isEmpty());
  }

  /**
   * Test {@link AbstractComplexTypeConverter#getFields(Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexTypeConverter#getFields(Class)}
   */
  @Test
  @DisplayName("Test getFields(Class); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.workflow.templating.AbstractComplexTypeConverter.getFields(java.lang.Class)"})
  void testGetFields_whenNull() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertTrue(beanConverter.getFields(null).isEmpty());
  }
}
