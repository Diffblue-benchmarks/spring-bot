package org.finos.springbot.tests.form;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Collection}
   *   <li>{@link Collection#setItems(List)}
   *   <li>{@link Collection#getItems()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Collection actualCollection = new Collection();
    ArrayList<Primitives> items = new ArrayList<>();
    actualCollection.setItems(items);
    List<Primitives> actualItems = actualCollection.getItems();

    // Assert that nothing has changed
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }
}
