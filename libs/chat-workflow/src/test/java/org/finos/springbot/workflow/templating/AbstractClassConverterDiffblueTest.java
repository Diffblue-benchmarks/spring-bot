package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractClassConverterDiffblueTest {
  /**
   * Test {@link AbstractClassConverter#canConvert(Field, Type)}.
   *
   * <ul>
   *   <li>Given {@link BooleanConverter#BooleanConverter(Rendering)} with r is {@link Rendering}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName(
      "Test canConvert(Field, Type); given BooleanConverter(Rendering) with r is Rendering; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractClassConverter.canConvert(Field, Type)"})
  void testCanConvert_givenBooleanConverterWithRIsRendering_thenReturnFalse() {
    // Arrange
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(mock(Rendering.class));
    Class<Object> t = Object.class;

    // Act and Assert
    assertFalse(booleanConverter.canConvert(null, t));
  }

  /**
   * Test {@link AbstractClassConverter#canConvert(Field, Type)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName(
      "Test canConvert(Field, Type); given 'java.lang.Object'; when 'java.lang.Object'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractClassConverter.canConvert(Field, Type)"})
  void testCanConvert_givenJavaLangObject_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    Rendering<Object> r = mock(Rendering.class);
    Class<Object> forNameResult = Object.class;

    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(2, r, forNameResult);
    Class<Object> t = Object.class;

    // Act and Assert
    assertTrue(booleanConverter.canConvert(null, t));
  }

  /**
   * Test {@link AbstractClassConverter#canConvert(Field, Type)}.
   *
   * <ul>
   *   <li>When {@link TypePlaceHolder#TypePlaceHolder(int)} with ordinal is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractClassConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName(
      "Test canConvert(Field, Type); when TypePlaceHolder(int) with ordinal is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractClassConverter.canConvert(Field, Type)"})
  void testCanConvert_whenTypePlaceHolderWithOrdinalIsOne_thenReturnFalse() {
    // Arrange
    BooleanConverter<Object> booleanConverter = new BooleanConverter<>(mock(Rendering.class));

    // Act and Assert
    assertFalse(booleanConverter.canConvert(null, new TypePlaceHolder(1)));
  }
}
