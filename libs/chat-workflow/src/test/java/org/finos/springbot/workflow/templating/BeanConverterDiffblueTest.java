package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BeanConverterDiffblueTest {
  /**
   * Test {@link BeanConverter#BeanConverter(Rendering)}.
   * <p>
   * Method under test: {@link BeanConverter#BeanConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new BeanConverter(Rendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.templating.BeanConverter.<init>(org.finos.springbot.workflow.templating.Rendering)"})
  void testNewBeanConverter() {
    // Arrange and Act
    BeanConverter<Object> actualBeanConverter = new BeanConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.BOTTOM_PRIORITY, actualBeanConverter.getPriority());
  }

  /**
   * Test {@link BeanConverter#canConvert(Field, Type)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type); when 'java.lang.Object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.templating.BeanConverter.canConvert(java.lang.reflect.Field, java.lang.reflect.Type)"})
  void testCanConvert_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));
    Class<Object> t = Object.class;

    // Act and Assert
    assertTrue(beanConverter.canConvert(null, t));
  }

  /**
   * Test {@link BeanConverter#canConvert(Field, Type)}.
   * <ul>
   *   <li>When {@link TypePlaceHolder#TypePlaceHolder(int)} with ordinal is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type); when TypePlaceHolder(int) with ordinal is one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.templating.BeanConverter.canConvert(java.lang.reflect.Field, java.lang.reflect.Type)"})
  void testCanConvert_whenTypePlaceHolderWithOrdinalIsOne_thenReturnFalse() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertFalse(beanConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Test {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>Given {@link Rendering} {@link Rendering#description(String)} return {@code Description}.</li>
   *   <li>Then return {@code Description}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); given Rendering description(String) return 'Description'; then return 'Description'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.BeanConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_givenRenderingDescriptionReturnDescription_thenReturnDescription() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.description(Mockito.<String>any())).thenReturn("Description");
    BeanConverter<Object> beanConverter = new BeanConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    Variable variable = mock(Variable.class);
    WithField<Object> showDetails = mock(WithField.class);
    when(showDetails.expand()).thenReturn(false);

    // Act
    Object actualApplyResult = beanConverter.apply(null, controller, null, true, variable, showDetails);

    // Assert
    verify(r).description(eq("some object"));
    verify(showDetails).expand();
    assertEquals("Description", actualApplyResult);
  }

  /**
   * Test {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>Given {@link Rendering} {@link Rendering#list(List)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); given Rendering list(List) return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.BeanConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_givenRenderingListReturnFalse_thenReturnFalse() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.list(Mockito.<List<Object>>any())).thenReturn(false);
    BeanConverter<Object> beanConverter = new BeanConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    Variable variable = mock(Variable.class);
    WithField<Object> showDetails = mock(WithField.class);
    when(showDetails.expand()).thenReturn(true);

    // Act
    Object actualApplyResult = beanConverter.apply(null, controller, null, true, variable, showDetails);

    // Assert
    verify(r).list(isA(List.class));
    verify(showDetails).expand();
    assertFalse((Boolean) actualApplyResult);
  }

  /**
   * Test {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>Given {@link Rendering} {@link Rendering#list(List)} return {@code List}.</li>
   *   <li>Then return {@code List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); given Rendering list(List) return 'List'; then return 'List'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.BeanConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_givenRenderingListReturnList_thenReturnList() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.list(Mockito.<List<Object>>any())).thenReturn("List");
    BeanConverter<Object> beanConverter = new BeanConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    Variable variable = mock(Variable.class);
    WithField<Object> showDetails = mock(WithField.class);
    when(showDetails.expand()).thenReturn(true);

    // Act
    Object actualApplyResult = beanConverter.apply(null, controller, null, true, variable, showDetails);

    // Assert
    verify(r).list(isA(List.class));
    verify(showDetails).expand();
    assertEquals("List", actualApplyResult);
  }

  /**
   * Test {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>Given {@link Rendering} {@link Rendering#list(List)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); given Rendering list(List) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.BeanConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_givenRenderingListReturnTrue_thenReturnTrue() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    when(r.list(Mockito.<List<Object>>any())).thenReturn(true);
    BeanConverter<Object> beanConverter = new BeanConverter<>(r);
    WithType<Object> controller = mock(WithType.class);
    Variable variable = mock(Variable.class);
    WithField<Object> showDetails = mock(WithField.class);
    when(showDetails.expand()).thenReturn(true);

    // Act
    Object actualApplyResult = beanConverter.apply(null, controller, null, true, variable, showDetails);

    // Assert
    verify(r).list(isA(List.class));
    verify(showDetails).expand();
    assertTrue((Boolean) actualApplyResult);
  }

  /**
   * Test {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeanConverter#apply(Field, WithType, Type, boolean, Variable, WithField)}
   */
  @Test
  @DisplayName("Test apply(Field, WithType, Type, boolean, Variable, WithField); when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Object org.finos.springbot.workflow.templating.BeanConverter.apply(java.lang.reflect.Field, org.finos.springbot.workflow.templating.WithType, java.lang.reflect.Type, boolean, org.finos.springbot.workflow.templating.Variable, org.finos.springbot.workflow.templating.WithField)"})
  void testApply_whenJavaLangObject_thenReturnNull() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));
    WithType<Object> controller = mock(WithType.class);
    Class<Object> t = Object.class;

    // Act and Assert
    assertNull(beanConverter.apply(null, controller, t, true, mock(Variable.class), null));
  }

  /**
   * Test {@link BeanConverter#propertyPanel(WithField)}.
   * <p>
   * Method under test: {@link BeanConverter#propertyPanel(WithField)}
   */
  @Test
  @DisplayName("Test propertyPanel(WithField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.WithField org.finos.springbot.workflow.templating.BeanConverter.propertyPanel(org.finos.springbot.workflow.templating.WithField)"})
  void testPropertyPanel() {
    // Arrange
    BeanConverter<Object> beanConverter = new BeanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertEquals("Field  Name",
        beanConverter.propertyPanel(mock(WithField.class)).fieldNameDefaultFormatter("Field Name"));
  }
}
