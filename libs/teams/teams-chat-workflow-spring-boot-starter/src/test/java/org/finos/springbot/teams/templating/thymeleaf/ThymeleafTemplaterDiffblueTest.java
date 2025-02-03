package org.finos.springbot.teams.templating.thymeleaf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ThymeleafTemplater.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ThymeleafTemplaterDiffblueTest {
  @Autowired
  private List<TypeConverter<String>> list;

  @MockBean
  private Rendering<String> rendering;

  @Autowired
  private ThymeleafTemplater thymeleafTemplater;

  @MockBean
  private TypeConverter<String> typeConverter;

  /**
   * Test {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}.
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new ThymeleafTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater.<init>(java.util.List, org.finos.springbot.workflow.templating.Rendering)"})
  void testNewThymeleafTemplater_thenCallsGetPriority() {
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
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafTemplater#ThymeleafTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new ThymeleafTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater.<init>(java.util.List, org.finos.springbot.workflow.templating.Rendering)"})
  void testNewThymeleafTemplater_thenCallsGetPriority2() {
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
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>Then return {@code <div xmlns:th="http://www.thymeleaf.org">Apply</div>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); then return '<div xmlns:th=\"http://www.thymeleaf.org\">Apply</div>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater.convert(java.lang.Class, org.finos.springbot.workflow.templating.Mode)"})
  void testConvert_thenReturnDivXmlnsThHttpWwwThymeleafOrgApplyDiv() {
    // Arrange
    when(typeConverter.apply(Mockito.<Field>any(), Mockito.<WithType<String>>any(), Mockito.<Type>any(), anyBoolean(),
        Mockito.<Variable>any(), Mockito.<WithField<String>>any())).thenReturn("Apply");
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act
    String actualConvertResult = thymeleafTemplater.convert(c, Mode.DISPLAY);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter).apply(isNull(), isA(WithType.class), isA(Type.class), eq(false), isA(Variable.class),
        isA(WithField.class));
    assertEquals("<div xmlns:th=\"http://www.thymeleaf.org\">Apply</div>", actualConvertResult);
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>When {@code DISPLAY_WITH_BUTTONS}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); when 'DISPLAY_WITH_BUTTONS'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater.convert(java.lang.Class, org.finos.springbot.workflow.templating.Mode)"})
  void testConvert_whenDisplayWithButtons_thenThrowUnsupportedOperationException() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS));
  }

  /**
   * Test {@link ThymeleafTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>When {@code FORM}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThymeleafTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); when 'FORM'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater.convert(java.lang.Class, org.finos.springbot.workflow.templating.Mode)"})
  void testConvert_whenForm_thenThrowUnsupportedOperationException() {
    // Arrange
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> thymeleafTemplater.convert(c, Mode.FORM));
  }
}
