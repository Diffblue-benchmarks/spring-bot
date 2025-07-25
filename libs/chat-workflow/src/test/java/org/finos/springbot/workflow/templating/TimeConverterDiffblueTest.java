package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TimeConverterDiffblueTest {
  /**
   * Test {@link TimeConverter#TimeConverter(int, Rendering, Class[])}.
   *
   * <p>Method under test: {@link TimeConverter#TimeConverter(int, Rendering, Class[])}
   */
  @Test
  @DisplayName("Test new TimeConverter(int, Rendering, Class[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeConverter.<init>(int, Rendering, Class[])"})
  void testNewTimeConverter() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    // Act
    TimeConverter<Object> actualTimeConverter = new TimeConverter<>(1, r, forNameResult);

    // Assert
    assertEquals(1, actualTimeConverter.getPriority());
  }

  /**
   * Test {@link TimeConverter#TimeConverter(Rendering)}.
   *
   * <p>Method under test: {@link TimeConverter#TimeConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new TimeConverter(Rendering)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeConverter.<init>(Rendering)"})
  void testNewTimeConverter2() {
    // Arrange and Act
    TimeConverter<Object> actualTimeConverter = new TimeConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualTimeConverter.getPriority());
  }

  /**
   * Test {@link TimeConverter#apply(Field, Type, boolean, Variable)} with {@code ctx}, {@code t},
   * {@code editMode}, {@code variable}.
   *
   * <p>Method under test: {@link TimeConverter#apply(Field, Type, boolean, Variable)}
   */
  @Test
  @DisplayName("Test apply(Field, Type, boolean, Variable) with 'ctx', 't', 'editMode', 'variable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TimeConverter.apply(Field, Type, boolean, Variable)"})
  void testApplyWithCtxTEditModeVariable() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean())).thenReturn("Text Field");
    TimeConverter<Object> timeConverter = new TimeConverter<>(r);

    // Act
    Object actualApplyResult =
        timeConverter.apply(null, new TypePlaceHolder(1), true, mock(Variable.class));

    // Assert
    verify(r).textField(isA(Variable.class), eq(true));
    assertEquals("Text Field", actualApplyResult);
  }
}
