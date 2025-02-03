package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CollectionBeanWork}
   *   <li>{@link CollectionBeanWork#setInners(List)}
   *   <li>{@link CollectionBeanWork#getInners()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.CollectionBeanWork.<init>()",
      "java.util.List org.finos.springbot.tests.work.CollectionBeanWork.getInners()",
      "void org.finos.springbot.tests.work.CollectionBeanWork.setInners(java.util.List)"})
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
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.CollectionBeanWork$Inner.<init>()",
      "java.lang.String org.finos.springbot.tests.work.CollectionBeanWork$Inner.getS()",
      "boolean org.finos.springbot.tests.work.CollectionBeanWork$Inner.isB()",
      "void org.finos.springbot.tests.work.CollectionBeanWork$Inner.setB(boolean)",
      "void org.finos.springbot.tests.work.CollectionBeanWork$Inner.setS(java.lang.String)"})
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
