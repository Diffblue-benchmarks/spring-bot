package org.finos.springbot.symphony.templating;

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
import org.finos.springbot.workflow.templating.BooleanConverter;
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

@ContextConfiguration(classes = {FreemarkerWorkTemplater.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FreemarkerWorkTemplaterDiffblueTest {
  @Autowired private FreemarkerWorkTemplater freemarkerWorkTemplater;

  @Autowired private List<TypeConverter<String>> list;

  @MockitoBean private Rendering<String> rendering;

  @MockitoBean private TypeConverter<String> typeConverter;

  /**
   * Test {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new FreemarkerWorkTemplater(List, Rendering); then calls getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then calls {@link TypeConverter#getPriority()}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#FreemarkerWorkTemplater(List, Rendering)}
   */
  @Test
  @DisplayName("Test new FreemarkerWorkTemplater(List, Rendering); then calls getPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link Mode#FORM}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given 'java.lang.Object'; when FORM; then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_givenJavaLangObject_whenForm_thenReturnAString() {
    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    FreemarkerRendering r = new FreemarkerRendering();
    Class<Object> forNameResult = Object.class;

    BooleanConverter<String> booleanConverter = new BooleanConverter<>(1, r, forNameResult);
    fieldConverters.add(booleanConverter);
    FreemarkerWorkTemplater freemarkerWorkTemplater =
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        "\n"
            + "<#-- starting template -->\n"
            + "<form id=\"java.lang.Object\">\n"
            + " <span class=\"tempo-text-color--red\">${entity.errors.contents['entity.form']!''}</span>\n"
            + " <checkbox \n"
            + "  name=\"entity.form\"\n"
            + "  checked=\"${entity.form?string('true', 'false')}\"\n"
            + "  value=\"true\">entity.form</checkbox>\n"
            + "  <p><#list entity.buttons.contents as button>\n"
            + "    <button \n"
            + "         name=\"${button.name}\"\n"
            + "         type=\"${button.buttonType?lower_case}\">\n"
            + "      ${button.text}\n"
            + "    </button>\n"
            + "  </#list></p>\n"
            + "</form>\n"
            + "<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.FORM));
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Given {@link TypeConverter} {@link TypeConverter#apply(Field, WithType, Type, boolean,
   *       Variable, WithField)} return {@code Apply}.
   *   <li>When {@link Mode#FORM}.
   *   <li>Then calls {@link TypeConverter#apply(Field, WithType, Type, boolean, Variable,
   *       WithField)}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); given TypeConverter apply(Field, WithType, Type, boolean, Variable, WithField) return 'Apply'; when FORM; then calls apply(Field, WithType, Type, boolean, Variable, WithField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_givenTypeConverterApplyReturnApply_whenForm_thenCallsApply() {
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
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.FORM);

    // Assert
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
    verify(typeConverter)
        .apply(
            isNull(),
            isA(WithType.class),
            isA(Type.class),
            eq(true),
            isA(Variable.class),
            isA(WithField.class));
    assertEquals(
        "\n"
            + "<#-- starting template -->\n"
            + "<form id=\"java.lang.Object\">Apply\n"
            + "  <p><#list entity.buttons.contents as button>\n"
            + "    <button \n"
            + "         name=\"${button.name}\"\n"
            + "         type=\"${button.buttonType?lower_case}\">\n"
            + "      ${button.text}\n"
            + "    </button>\n"
            + "  </#list></p>\n"
            + "</form>\n"
            + "<#-- ending template -->\n",
        actualConvertResult);
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then return {@code <#-- starting template -->Apply <#-- ending template -->}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); then return '<#-- starting template -->Apply <#-- ending template -->'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_thenReturnStartingTemplateApplyEndingTemplate() {
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
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.DISPLAY);

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
    assertEquals(
        "\n<#-- starting template -->Apply\n<#-- ending template -->\n", actualConvertResult);
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then return {@code <#-- starting template --> <table> </table> <#-- ending template -->}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); then return '<#-- starting template --><table></table> <#-- ending template -->'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_thenReturnStartingTemplateTableTableEndingTemplate() {
    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater =
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering());
    Class<Object> c = Object.class;

    // Act and Assert
    assertEquals(
        "\n<#-- starting template --><table></table>\n<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_thenThrowUnsupportedOperationException() {
    // Arrange
    when(typeConverter.canConvert(Mockito.<Field>any(), Mockito.<Type>any())).thenReturn(false);
    Class<Object> c = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
    verify(typeConverter).canConvert(isNull(), isA(Type.class));
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>When {@code DISPLAY_WITH_BUTTONS}.
   *   <li>Then calls {@link TypeConverter#apply(Field, WithType, Type, boolean, Variable,
   *       WithField)}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName(
      "Test convert(Class, Mode); when 'DISPLAY_WITH_BUTTONS'; then calls apply(Field, WithType, Type, boolean, Variable, WithField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_whenDisplayWithButtons_thenCallsApply() {
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
    String actualConvertResult = freemarkerWorkTemplater.convert(c, Mode.DISPLAY_WITH_BUTTONS);

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
    assertEquals(
        "\n"
            + "<#-- starting template -->Apply\n"
            + "<form id=\"just-buttons-form\">\n"
            + "  <p><#list entity.buttons.contents as button>\n"
            + "    <button \n"
            + "         name=\"${button.name}\"\n"
            + "         type=\"${button.buttonType?lower_case}\">\n"
            + "      ${button.text}\n"
            + "    </button>\n"
            + "  </#list></p>\n"
            + "</form>\n"
            + "<#-- ending template -->\n",
        actualConvertResult);
  }

  /**
   * Test {@link FreemarkerWorkTemplater#convert(Class, Mode)}.
   *
   * <ul>
   *   <li>When {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link FreemarkerWorkTemplater#convert(Class, Mode)}
   */
  @Test
  @DisplayName("Test convert(Class, Mode); when 'java.lang.String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FreemarkerWorkTemplater.convert(Class, Mode)"})
  void testConvert_whenJavaLangString() {
    // Arrange
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    fieldConverters.add(new BeanConverter<>(new FreemarkerRendering()));
    FreemarkerWorkTemplater freemarkerWorkTemplater =
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering());
    Class<String> c = String.class;

    // Act and Assert
    assertEquals(
        "\n"
            + "<#-- starting template --><table><tr><td style=\"width: 200px\"><b>Value:</b></td><td><table></table></td></tr>"
            + "\n"
            + "<tr><td style=\"width: 200px\"><b>Coder:</b></td><td><table></table></td></tr>\n"
            + "<tr><td style=\"width: 200px\"><b>Hash:</b></td><td><table></table></td></tr>\n"
            + "<tr><td style=\"width: 200px\"><b>Hash Is Zero:</b></td><td><table></table></td></tr></table>\n"
            + "<#-- ending template -->\n",
        freemarkerWorkTemplater.convert(c, Mode.DISPLAY));
  }
}
