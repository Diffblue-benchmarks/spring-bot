package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CollectionConverterDiffblueTest {
  /**
   * Method under test: {@link CollectionConverter#CollectionConverter(Rendering)}
   */
  @Test
  void testNewCollectionConverter() {
    // Arrange and Act
    CollectionConverter<Object> actualCollectionConverter = new CollectionConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualCollectionConverter.getPriority());
  }

  /**
   * Method under test: {@link CollectionConverter#CollectionConverter(Rendering)}
   */
  @Test
  void testNewCollectionConverter2() {
    // Arrange and Act
    CollectionConverter<Object> actualCollectionConverter = new CollectionConverter<>(null);

    // Assert
    assertEquals(AbstractTypeConverter.LOW_PRIORITY, actualCollectionConverter.getPriority());
  }
}
