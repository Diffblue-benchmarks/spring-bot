package org.finos.springbot.tests.form;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollectionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Collection}
   *   <li>{@link Collection#setItems(List)}
   *   <li>{@link Collection#getItems()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.form.Collection.<init>()",
      "java.util.List org.finos.springbot.tests.form.Collection.getItems()",
      "void org.finos.springbot.tests.form.Collection.setItems(java.util.List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Collection actualCollection = new Collection();
    ArrayList<Primitives> items = new ArrayList<>();
    actualCollection.setItems(items);
    List<Primitives> actualItems = actualCollection.getItems();

    // Assert
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
  }
}
