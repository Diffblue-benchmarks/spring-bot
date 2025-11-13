package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class TableConverterDiffblueTest {
  /**
   * Test {@link TableConverter#TableConverter(TableRendering)}.
   *
   * <p>Method under test: {@link TableConverter#TableConverter(TableRendering)}
   */
  @Test
  @DisplayName("Test new TableConverter(TableRendering)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableConverter.<init>(TableRendering)"})
  void testNewTableConverter() {
    // Arrange and Act
    TableConverter<Object> actualTableConverter = new TableConverter<>(mock(TableRendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualTableConverter.getPriority());
  }

  /**
   * Test {@link TableConverter#canConvert(Field, Type)}.
   *
   * <p>Method under test: {@link TableConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableConverter.canConvert(Field, Type)"})
  void testCanConvert() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(mock(TableRendering.class));

    // Act and Assert
    assertFalse(tableConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   *
   * <ul>
   *   <li>Given {@link TableRendering} {@link TableRendering#textField(Variable, boolean)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable,
   * WithField)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, WithType, Type, boolean, Variable, WithField); given TableRendering textField(Variable, boolean) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TableConverter.apply(Field, WithType, Type, boolean, Variable, WithField)"
  })
  void testApply_givenTableRenderingTextFieldReturnFalse_thenReturnFalse() {
    // Arrange
    TableRendering<Object> r = mock(TableRendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean())).thenReturn(false);
    TableConverter<Object> tableConverter = new TableConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);

    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenReturn(false);

    // Act
    Object actualApplyResult =
        tableConverter.apply(null, controller, t, true, variable, showDetail);

    // Assert
    verify(r).textField(isA(Variable.class), eq(false));
    verify(showDetail).expand();
    assertFalse((Boolean) actualApplyResult);
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   *
   * <ul>
   *   <li>Given {@link TableRendering} {@link TableRendering#textField(Variable, boolean)} return
   *       {@code Text Field}.
   *   <li>Then return {@code Text Field}.
   * </ul>
   *
   * <p>Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable,
   * WithField)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, WithType, Type, boolean, Variable, WithField); given TableRendering textField(Variable, boolean) return 'Text Field'; then return 'Text Field'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TableConverter.apply(Field, WithType, Type, boolean, Variable, WithField)"
  })
  void testApply_givenTableRenderingTextFieldReturnTextField_thenReturnTextField() {
    // Arrange
    TableRendering<Object> r = mock(TableRendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean())).thenReturn("Text Field");
    TableConverter<Object> tableConverter = new TableConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);

    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenReturn(false);

    // Act
    Object actualApplyResult =
        tableConverter.apply(null, controller, t, true, variable, showDetail);

    // Assert
    verify(r).textField(isA(Variable.class), eq(false));
    verify(showDetail).expand();
    assertEquals("Text Field", actualApplyResult);
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   *
   * <ul>
   *   <li>Given {@link TableRendering} {@link TableRendering#textField(Variable, boolean)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable,
   * WithField)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, WithType, Type, boolean, Variable, WithField); given TableRendering textField(Variable, boolean) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TableConverter.apply(Field, WithType, Type, boolean, Variable, WithField)"
  })
  void testApply_givenTableRenderingTextFieldReturnTrue_thenReturnTrue() {
    // Arrange
    TableRendering<Object> r = mock(TableRendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean())).thenReturn(true);
    TableConverter<Object> tableConverter = new TableConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);

    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenReturn(false);

    // Act
    Object actualApplyResult =
        tableConverter.apply(null, controller, t, true, variable, showDetail);

    // Assert
    verify(r).textField(isA(Variable.class), eq(false));
    verify(showDetail).expand();
    assertTrue((Boolean) actualApplyResult);
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   *
   * <ul>
   *   <li>Given {@link TableRendering} {@link TableRendering#textField(Variable, boolean)} throw
   *       {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable,
   * WithField)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, WithType, Type, boolean, Variable, WithField); given TableRendering textField(Variable, boolean) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TableConverter.apply(Field, WithType, Type, boolean, Variable, WithField)"
  })
  void testApply_givenTableRenderingTextFieldThrowUnsupportedOperationException() {
    // Arrange
    TableRendering<Object> r = mock(TableRendering.class);
    when(r.textField(Mockito.<Variable>any(), anyBoolean()))
        .thenThrow(new UnsupportedOperationException());
    TableConverter<Object> tableConverter = new TableConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);

    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenReturn(false);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> tableConverter.apply(null, controller, t, true, variable, showDetail));
    verify(r).textField(isA(Variable.class), eq(false));
    verify(showDetail).expand();
  }

  /**
   * Test {@link TableConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link TableConverter#apply(Field, WithType, Type, boolean, Variable,
   * WithField)}
   */
  @Test
  @DisplayName(
      "Test apply(Field, WithType, Type, boolean, Variable, WithField); given UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TableConverter.apply(Field, WithType, Type, boolean, Variable, WithField)"
  })
  void testApply_givenUnsupportedOperationException() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(mock(TableRendering.class));
    WithType<Object> controller = mock(WithType.class);
    TypePlaceHolder t = new TypePlaceHolder(1);
    Variable variable = mock(Variable.class);

    WithField<Object> showDetail = mock(WithField.class);
    when(showDetail.expand()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> tableConverter.apply(null, controller, t, true, variable, showDetail));
    verify(showDetail).expand();
  }
}
