package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.tests.work.CollectionBeanWork.Inner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CollectionBeanWorkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CollectionBeanWork}
   *   <li>{@link CollectionBeanWork#setInners(List)}
   *   <li>{@link CollectionBeanWork#getInners()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CollectionBeanWork.<init>()",
    "List CollectionBeanWork.getInners()",
    "void CollectionBeanWork.setInners(List)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CollectionBeanWork actualCollectionBeanWork = new CollectionBeanWork();
    ArrayList<Inner> inners = new ArrayList<>();
    actualCollectionBeanWork.setInners(inners);
    List<Inner> actualInners = actualCollectionBeanWork.getInners();

    // Assert
    assertTrue(actualInners.isEmpty());
    assertSame(inners, actualInners);
  }

  /**
   * Test Inner getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Inner}
   *   <li>{@link Inner#setB(boolean)}
   *   <li>{@link Inner#setS(String)}
   *   <li>{@link Inner#getS()}
   *   <li>{@link Inner#isB()}
   * </ul>
   */
  @Test
  @DisplayName("Test Inner getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Inner.<init>()",
    "String Inner.getS()",
    "boolean Inner.isB()",
    "void Inner.setB(boolean)",
    "void Inner.setS(String)"
  })
  void testInnerGettersAndSetters() {
    // Arrange and Act
    Inner actualInner = new Inner();
    actualInner.setB(true);
    actualInner.setS("foo");
    String actualS = actualInner.getS();

    // Assert
    assertEquals("foo", actualS);
    assertTrue(actualInner.isB());
  }
}
