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

class BooleanConverterDiffblueTest {
  /**
   * Test {@link BooleanConverter#BooleanConverter(int, Rendering, Class[])}.
   * <p>
   * Method under test: {@link BooleanConverter#BooleanConverter(int, Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new BooleanConverter(int, Rendering, Class[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BooleanConverter.<init>(int, Rendering, Class[])"})
  void testNewBooleanConverter() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    // Act
    BooleanConverter<Object> actualBooleanConverter = new BooleanConverter<>(1, r, forNameResult);

    // Assert
    assertEquals(1, actualBooleanConverter.getPriority());
  }

  /**
   * Test {@link BooleanConverter#BooleanConverter(Rendering)}.
   * <p>
   * Method under test: {@link BooleanConverter#BooleanConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new BooleanConverter(Rendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BooleanConverter.<init>(Rendering)"})
  void testNewBooleanConverter2() {
    // Arrange and Act
    BooleanConverter<Object> actualBooleanConverter = new BooleanConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualBooleanConverter.getPriority());
  }

  /**
   * Test {@link BooleanConverter#apply(Field, Type, boolean, Variable)} with {@code ctx}, {@code t}, {@code editMode}, {@code variable}.
   * <p>
   * Method under test: {@link BooleanConverter#apply(Field, Type, boolean, Variable)}
   */
  @Test
  @DisplayName("Test apply(Field, Type, boolean, Variable) with 'ctx', 't', 'editMode', 'variable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object BooleanConverter.apply(Field, Type, boolean, Variable)"})
  void testApplyWithCtxTEditModeVariable() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.checkBox(Mockito.<Variable>any(), anyBoolean())).thenReturn("Check Box");
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(r);

    // Act
    Object actualApplyResult = booleanConverter.apply(null, new TypePlaceHolder(1), true, mock(Variable.class));

    // Assert
    verify(r).checkBox(isA(Variable.class), eq(true));
    assertEquals("Check Box", actualApplyResult);
  }
}
