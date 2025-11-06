package org.finos.springbot.symphony.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@ContextConfiguration(classes = {FreemarkerWorkTemplater.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FreemarkerWorkTemplaterDiffblueTest {
  @Autowired
  private FreemarkerWorkTemplater freemarkerWorkTemplater;

  @Autowired
  private List<TypeConverter<String>> list;

  @MockBean
  private Rendering<String> rendering;

  @MockBean
  private TypeConverter<String> typeConverter;

  /**
   * Test {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}.
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new FreemarkerWorkTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreemarkerWorkTemplater.<init>(List, Rendering)"})
  void testNewFreemarkerWorkTemplater_thenCallsGetPriority() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new FreemarkerWorkTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }

  /**
   * Test {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}.
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new FreemarkerWorkTemplater(List, Rendering); then calls getPriority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreemarkerWorkTemplater.<init>(List, Rendering)"})
  void testNewFreemarkerWorkTemplater_thenCallsGetPriority2() {
    // Arrange
    when(typeConverter.getPriority()).thenReturn(1);

    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);
    fieldConverters.add(typeConverter);

    // Act
    new FreemarkerWorkTemplater(fieldConverters, rendering);

    // Assert
    verify(typeConverter, atLeast(1)).getPriority();
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#canConvert(Field, Type)} return {@code true}.</li>
   *   <li>When {@link Mode#FORM}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); given TypeConverter canConvert(Field, Type) return 'true'; when FORM; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverterCanConvertReturnTrue_whenForm_thenReturnAString() {
    // Arrange
    when(typeConverter.apply(Mockito.<Field>any(), Mockito.<WithType<String>>any(), Mockito.<Type>any(), anyBoolean(),
        Mockito.<Variable>any(), Mockito.<WithField<String>>any())).thenReturn("Apply");
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.FORM);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter).apply(isNull(), isA(WithType.class), isA(Type.class), eq(true), isA(Variable.class),
        isA(WithField.class));
    assertEquals("\n" + "<#-- starting template -->\n" + "<form id=\"java.lang.Object\">Apply\n"
        + "  <p><#list entity.buttons.contents as button>\n" + "    <button \n" + "         name=\"${button.name}\"\n"
        + "         type=\"${button.buttonType?lower_case}\">\n" + "      ${button.text}\n" + "    </button>\n"
        + "  </#list></p>\n" + "</form>\n" + "<#-- ending template -->\n", actualConvertResult);
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>When {@code DISPLAY_WITH_BUTTONS}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); when 'DISPLAY_WITH_BUTTONS'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_whenDisplayWithButtons_thenReturnAString() {
    // Arrange
    when(typeConverter.apply(Mockito.<Field>any(), Mockito.<WithType<String>>any(), Mockito.<Type>any(), anyBoolean(),
        Mockito.<Variable>any(), Mockito.<WithField<String>>any())).thenReturn("Apply");
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter).apply(isNull(), isA(WithType.class), isA(Type.class), eq(false), isA(Variable.class),
        isA(WithField.class));
    assertEquals("\n" + "<#-- starting template -->Apply\n" + "<form id=\"just-buttons-form\">\n"
        + "  <p><#list entity.buttons.contents as button>\n" + "    <button \n" + "         name=\"${button.name}\"\n"
        + "         type=\"${button.buttonType?lower_case}\">\n" + "      ${button.text}\n" + "    </button>\n"
        + "  </#list></p>\n" + "</form>\n" + "<#-- ending template -->\n", actualConvertResult);
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   * <ul>
   *   <li>When {@code DISPLAY}.</li>
   *   <li>Then return {@code <#-- starting template -->Apply <#-- ending template -->}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); when 'DISPLAY'; then return '<#-- starting template -->Apply <#-- ending template -->'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_whenDisplay_thenReturnStartingTemplateApplyEndingTemplate() {
    // Arrange
    when(typeConverter.apply(Mockito.<Field>any(), Mockito.<WithType<String>>any(), Mockito.<Type>any(), anyBoolean(),
        Mockito.<Variable>any(), Mockito.<WithField<String>>any())).thenReturn("Apply");
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(true);
    Class<Object> c = Object.class;

    // Act
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.DISPLAY);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter).apply(isNull(), isA(WithType.class), isA(Type.class), eq(false), isA(Variable.class),
        isA(WithField.class));
    assertEquals("\n<#-- starting template -->Apply\n<#-- ending template -->\n", actualConvertResult);
  }
}
