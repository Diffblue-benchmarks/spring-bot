package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TableConverterDiffblueTest {
  /**
   * Test {@link TableConverter#TableConverter(TableRendering)}.
   * <p>
   * Method under test: {@link TableConverter#TableConverter(TableRendering)}
   */
  @Test
  @DisplayName("Test new TableConverter(TableRendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.templating.TableConverter.<init>(org.finos.springbot.workflow.templating.TableRendering)"})
  void testNewTableConverter() {
    // Arrange and Act
    TableConverter<Object> actualTableConverter = new TableConverter<>(mock(TableRendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualTableConverter.getPriority());
  }

  /**
   * Test {@link TableConverter#canConvert(Field, Type)}.
   * <p>
   * Method under test: {@link TableConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.templating.TableConverter.canConvert(java.lang.reflect.Field, java.lang.reflect.Type)"})
  void testCanConvert() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(mock(TableRendering.class));

    // Act and Assert
    assertFalse(tableConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.TableConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_thenThrowUnsupportedOperationException() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(mock(TableRendering.class));
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);
    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> tableConverter.apply(null, controller, t, true, variable, showDetail));
    verify(showDetail).expand();
  }
}
