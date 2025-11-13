package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.templating.BeanConverter;
import org.finos.springbot.workflow.templating.Mode;
import org.finos.springbot.workflow.templating.Rendering;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.finos.springbot.workflow.templating.Variable;
import org.finos.springbot.workflow.templating.WithField;
import org.finos.springbot.workflow.templating.WithType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThymeleafTemplater.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ThymeleafTemplaterDiffblueTest {
  @Autowired private List<TypeConverter<String>> list;

  @MockitoBean private Rendering<String> rendering;

  @Autowired private ThymeleafTemplater thymeleafTemplater;

  @MockitoBean private TypeConverter<String> typeConverter;

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#getPriority()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplater(List, Rendering); given TypeConverter getPriority() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThymeleafTemplater.<init>(List, Rendering)"})
  void testNewThymeleafTemplater_givenTypeConverterGetPriorityReturnOne() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new ThymeleafTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#getPriority()} return one.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplater(List, Rendering); given TypeConverter getPriority() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThymeleafTemplater.<init>(List, Rendering)"})
  void testNewThymeleafTemplater_givenTypeConverterGetPriorityReturnOne2() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new ThymeleafTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplater(List, Rendering); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThymeleafTemplater.<init>(List, Rendering)"})
  void testNewThymeleafTemplater_thenThrowUnsupportedOperationException() {
    // Arrange
    when(typeConverter.getPriority()).thenThrow(new UnsupportedOperationException());

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ThymeleafTemplater(fieldConverters, rendering));
    verify(typeConverter).getPriority();
  }

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link TypeConverter}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplater(List, Rendering); when ArrayList() add TypeConverter; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThymeleafTemplater.<init>(List, Rendering)"})
  void testNewThymeleafTemplater_whenArrayListAddTypeConverter_thenDoesNotThrow() {
    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);

    // Act
    assertDoesNotThrow(() -> new ThymeleafTemplater(fieldConverters, rendering));
  }

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName(
      "Test new ThymeleafTemplater(List, Rendering); when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThymeleafTemplater.<init>(List, Rendering)"})
  void testNewThymeleafTemplater_whenArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> new ThymeleafTemplater(new ArrayList<>(), rendering));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#apply(Field, WithType, Type, boolean,
   *       Variable, WithField)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given TypeConverter apply(Field, WithType, Type, boolean, Variable, WithField) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverterApplyThrowUnsupportedOperationException() {
    // Arrange
    when(typeConverter.apply(
            Mockito.<Field>any(),
            Mockito.<WithType<String>>any(),
            Mockito.<Type>any(),
            anyBoolean(),
            Mockito.<Variable>any(),
            Mockito.<WithField<String>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.DISPLAY));
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter)
        .apply(
            isNull(),
            isA(WithType.class),
            isA(Type.class),
            eq(false),
            isA(Variable.class),
            isA(WithField.class));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#canConvert(Field, Type)} return {@code
   *       false}.
   *   <li>Then calls {@link TypeConverter#canConvert(Field, Type)}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given TypeConverter canConvert(Field, Type) return 'false'; then calls canConvert(Field, Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverterCanConvertReturnFalse_thenCallsCanConvert() {
    // Arrange
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(false);
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.DISPLAY));
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#canConvert(Field, Type)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given TypeConverter canConvert(Field, Type) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverterCanConvertThrowUnsupportedOperationException() {
    // Arrange
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any()))
        .thenThrow(new UnsupportedOperationException());
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.DISPLAY));
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter}.
   *   <li>When {@link Mode#DISPLAY_WITH_BUTTONS}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); given TypeConverter; when DISPLAY_WITH_BUTTONS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverter_whenDisplay_with_buttons() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> thymeleafTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter}.
   *   <li>When {@link Mode#FORM}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given TypeConverter; when FORM; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverter_whenForm_thenThrowUnsupportedOperationException() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.FORM));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then return {@code <div xmlns:th="http://www.thymeleaf.org">Apply</div>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); then return '<div xmlns:th=\"http://www.thymeleaf.org\">Apply</div>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_thenReturnDivXmlnsThHttpWwwThymeleafOrgApplyDiv() {
    // Arrange
    when(typeConverter.apply(
            Mockito.<Field>any(),
            Mockito.<WithType<String>>any(),
            Mockito.<Type>any(),
            anyBoolean(),
            Mockito.<Variable>any(),
            Mockito.<WithField<String>>any()))
        .thenReturn("Apply");
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act
    String actualConvertResult = thymeleafTemplater.convert(c, Mode.DISPLAY);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter)
        .apply(
            isNull(),
            isA(WithType.class),
            isA(Type.class),
            eq(false),
            isA(Variable.class),
            isA(WithField.class));
    assertEquals("<div xmlns:th=\"http://www.thymeleaf.org\">Apply</div>", actualConvertResult);
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then return {@code <div xmlns:th="http://www.thymeleaf.org"> <table> </table> </div>}.
   * </ul>
   *
   * <p>Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); then return '<div xmlns:th=\"http://www.thymeleaf.org\"><table></table></div>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ThymeleafTemplater.convert(Class, Mode)"})
  void testConvert_thenReturnDivXmlnsThHttpWwwThymeleafOrgTableTableDiv() {
    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new ThymeleafRendering()));
    ThymeleafTemplater thymeleafTemplater =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        "<div xmlns:th=\"http://www.thymeleaf.org\"><table></table></div>",
        thymeleafTemplater.convert(c, Mode.DISPLAY));
  }
}
