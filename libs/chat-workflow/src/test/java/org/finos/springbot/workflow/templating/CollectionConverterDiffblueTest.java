package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollectionConverterDiffblueTest {
  /**
   * Test {@link CollectionConverter#CollectionConverter(Rendering)}.
   *
   * <p>Method under test: {@link CollectionConverter#CollectionConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new CollectionConverter(Rendering)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionConverter.<init>(Rendering)"})
  void testNewCollectionConverter() {
    // Arrange and Act
    CollectionConverter<Object> actualCollectionConverter =
        new CollectionConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualCollectionConverter.getPriority());
  }

  /**
   * Test {@link CollectionConverter#CollectionConverter(Rendering)}.
   *
   * <p>Method under test: {@link CollectionConverter#CollectionConverter(Rendering)}
   */
  @Test
  @DisplayName("Test new CollectionConverter(Rendering)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CollectionConverter.<init>(Rendering)"})
  void testNewCollectionConverter2() {
    // Arrange and Act
    CollectionConverter<Object> actualCollectionConverter =
        new CollectionConverter<>(mock(Rendering.class));

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualCollectionConverter.getPriority());
  }
}
