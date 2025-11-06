package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionSingleWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CollectionSingleWork}
   *   <li>{@link CollectionSingleWork#setInts(List)}
   *   <li>{@link CollectionSingleWork#setStrings(List)}
   *   <li>{@link CollectionSingleWork#getInts()}
   *   <li>{@link CollectionSingleWork#getStrings()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CollectionSingleWork actualCollectionSingleWork = new CollectionSingleWork();
    ArrayList<Integer> ints = new ArrayList<>();
    actualCollectionSingleWork.setInts(ints);
    ArrayList<String> strings = new ArrayList<>();
    actualCollectionSingleWork.setStrings(strings);
    List<Integer> actualInts = actualCollectionSingleWork.getInts();
    List<String> actualStrings = actualCollectionSingleWork.getStrings();

    // Assert that nothing has changed
    assertTrue(actualInts.isEmpty());
    assertTrue(actualStrings.isEmpty());
    assertSame(ints, actualInts);
    assertSame(strings, actualStrings);
  }
}
