package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumConverterDiffblueTest {
  /**
   * Test {@link EnumConverter#EnumConverter(Rendering)}.
   * <p>
   * Method under test: {@link EnumConverter#EnumConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new EnumConverter(Rendering)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.templating.EnumConverter.<init>(org.finos.springbot.workflow.templating.Rendering)"})
  void testNewEnumConverter() {
    // Arrange and Act
    EnumConverter<Object> actualEnumConverter = new EnumConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualEnumConverter.getPriority());
  }

  /**
   * Test {@link EnumConverter#canConvert(Field, Type)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type); when 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.templating.EnumConverter.canConvert(java.lang.reflect.Field, java.lang.reflect.Type)"})
  void testCanConvert_whenJavaLangObject() {
    // Arrange
    EnumConverter<Object> enumConverter = new EnumConverter<>(mock(Rendering.class));
    Class<Object> t = Object.class;

    // Act and Assert
    assertFalse(enumConverter.canConvert(null, t));
  }

  /**
   * Test {@link EnumConverter#canConvert(Field, Type)}.
   * <ul>
   *   <li>When {@link TypePlaceHolder#TypePlaceHolder(int)} with ordinal is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type); when TypePlaceHolder(int) with ordinal is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.templating.EnumConverter.canConvert(java.lang.reflect.Field, java.lang.reflect.Type)"})
  void testCanConvert_whenTypePlaceHolderWithOrdinalIsOne() {
    // Arrange
    EnumConverter<Object> enumConverter = new EnumConverter<>(mock(Rendering.class));

    // Act and Assert
    assertFalse(enumConverter.canConvert(null, new TypePlaceHolder(1)));
  }
}
