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

class TextFieldConverterDiffblueTest {
  /**
   * Test {@link TextFieldConverter#TextFieldConverter(int, Rendering, Class[])}.
   * <p>
   * Method under test: {@link TextFieldConverter#TextFieldConverter(int, Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new TextFieldConverter(int, Rendering, Class[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.templating.TextFieldConverter.<init>(int, org.finos.springbot.workflow.templating.Rendering, java.lang.Class[])"})
  void testNewTextFieldConverter() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    // Act
    TextFieldConverter<Object> actualTextFieldConverter = new TextFieldConverter<>(1, r, forNameResult);

    // Assert
    assertEquals(1, actualTextFieldConverter.getPriority());
  }

  /**
   * Test {@link TextFieldConverter#apply(Field, Type, boolean, Variable)} with {@code ctx}, {@code t}, {@code editMode}, {@code variable}.
   * <p>
   * Method under test: {@link TextFieldConverter#apply(Field, Type, boolean, Variable)}
   */
  @Test
  @DisplayName("Test apply(Field, Type, boolean, Variable) with 'ctx', 't', 'editMode', 'variable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.TextFieldConverter.apply(java.lang.reflect.Field, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable)"})
  void testApplyWithCtxTEditModeVariable() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean())).thenReturn("Text Field");
    Class<Object> forNameResult = Object.class;
    TextFieldConverter<Object> textFieldConverter = new TextFieldConverter<>(1, r, forNameResult);

    // Act
    Object actualApplyResult = textFieldConverter.apply(null, new TypePlaceHolder(1), true, mock(Variable.class));

    // Assert
    verify(r).textField(isA(Variable.class), eq(true));
    assertEquals("Text Field", actualApplyResult);
  }
}
