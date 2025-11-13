package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DropdownAnnotationConverterDiffblueTest {
  /**
   * Test {@link DropdownAnnotationConverter#DropdownAnnotationConverter(Rendering)}.
   *
   * <p>Method under test: {@link
   * DropdownAnnotationConverter#DropdownAnnotationConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new DropdownAnnotationConverter(Rendering)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DropdownAnnotationConverter.<init>(Rendering)"})
  void testNewDropdownAnnotationConverter() {
    // Arrange and Act
    DropdownAnnotationConverter<Object> actualDropdownAnnotationConverter =
        new DropdownAnnotationConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(
        AbstractTypeConverter.MED_PRIORITY, actualDropdownAnnotationConverter.getPriority());
  }

  /**
   * Test {@link DropdownAnnotationConverter#canConvert(Field, Type)}.
   *
   * <p>Method under test: {@link DropdownAnnotationConverter#canConvert(Field, Type)}
   */
  @Test
  @DisplayName("Test canConvert(Field, Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DropdownAnnotationConverter.canConvert(Field, Type)"})
  void testCanConvert() {
    // Arrange
    DropdownAnnotationConverter<Object> dropdownAnnotationConverter =
        new DropdownAnnotationConverter<>(mock(Rendering.class));

    // Act and Assert
    assertFalse(dropdownAnnotationConverter.canConvert(null, new TypePlaceHolder(1)));
  }

  /**
   * Test {@link DropdownAnnotationConverter#getDropdownAnnotation(Field)}.
   *
   * <p>Method under test: {@link DropdownAnnotationConverter#getDropdownAnnotation(Field)}
   */
  @Test
  @DisplayName("Test getDropdownAnnotation(Field)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.annotations.Dropdown DropdownAnnotationConverter.getDropdownAnnotation(Field)"
  })
  void testGetDropdownAnnotation() {
    // Arrange
    DropdownAnnotationConverter<Object> dropdownAnnotationConverter =
        new DropdownAnnotationConverter<>(mock(Rendering.class));

    // Act and Assert
    assertNull(dropdownAnnotationConverter.getDropdownAnnotation(null));
  }
}
