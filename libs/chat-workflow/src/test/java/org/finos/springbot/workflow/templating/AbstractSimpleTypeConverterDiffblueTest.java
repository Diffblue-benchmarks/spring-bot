package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import org.mockito.Mockito;

class AbstractSimpleTypeConverterDiffblueTest {
  /**
   * Test {@link AbstractSimpleTypeConverter#apply(Field, WithType, Type, boolean, Variable, WithField)} with {@code Field}, {@code WithType}, {@code Type}, {@code boolean}, {@code Variable}, {@code WithField}.
   * <p>
   * Method under test: {@link AbstractSimpleTypeConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField) with 'Field', 'WithType', 'Type', 'boolean', 'Variable', 'WithField'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.AbstractSimpleTypeConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApplyWithFieldWithTypeTypeBooleanVariableWithField() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.checkBox(Mockito.<Variable>any(), anyBoolean())).thenReturn("Check Box");
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(r);
    WithType<Object> controller = mock(WithType.class);

    // Act
    Object actualApplyResult = booleanConverter.apply(null, controller, new TypePlaceHolder(1), true,
        mock(Variable.class), mock(WithField.class));

    // Assert
    verify(r).checkBox(isA(Variable.class), eq(true));
    assertEquals("Check Box", actualApplyResult);
  }
}
