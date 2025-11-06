package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CollectionBeanWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CollectionBeanWork}
   *   <li>{@link CollectionBeanWork#setInners(List)}
   *   <li>{@link CollectionBeanWork#getInners()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CollectionBeanWork actualCollectionBeanWork = new CollectionBeanWork();
    ArrayList<CollectionBeanWork.Inner> inners = new ArrayList<>();
    actualCollectionBeanWork.setInners(inners);
    List<CollectionBeanWork.Inner> actualInners = actualCollectionBeanWork.getInners();

    // Assert that nothing has changed
    assertTrue(actualInners.isEmpty());
    assertSame(inners, actualInners);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CollectionBeanWork.Inner}
   *   <li>{@link CollectionBeanWork.Inner#setB(boolean)}
   *   <li>{@link CollectionBeanWork.Inner#setS(String)}
   *   <li>{@link CollectionBeanWork.Inner#getS()}
   *   <li>{@link CollectionBeanWork.Inner#isB()}
   * </ul>
   */
  @Test
  void testInnerGettersAndSetters() {
    // Arrange and Act
    CollectionBeanWork.Inner actualInner = new CollectionBeanWork.Inner();
    actualInner.setB(true);
    actualInner.setS("foo");
    String actualS = actualInner.getS();

    // Assert that nothing has changed
    assertEquals("foo", actualS);
    assertTrue(actualInner.isB());
  }
}
