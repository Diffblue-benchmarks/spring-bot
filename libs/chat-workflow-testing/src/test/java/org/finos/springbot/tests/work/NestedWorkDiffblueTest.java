package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class NestedWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NestedWork}
   *   <li>{@link NestedWork#setA(NestedWork.Inner)}
   *   <li>{@link NestedWork#setB(NestedWork.Inner)}
   *   <li>{@link NestedWork#getA()}
   *   <li>{@link NestedWork#getB()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NestedWork actualNestedWork = new NestedWork();
    NestedWork.Inner a = new NestedWork.Inner();
    a.setS("foo");
    actualNestedWork.setA(a);
    NestedWork.Inner b = new NestedWork.Inner();
    b.setS("foo");
    actualNestedWork.setB(b);
    NestedWork.Inner actualA = actualNestedWork.getA();
    NestedWork.Inner actualB = actualNestedWork.getB();

    // Assert that nothing has changed
    assertEquals("foo", actualA.getS());
    assertEquals("foo", actualB.getS());
    assertSame(a, actualA);
    assertSame(b, actualB);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NestedWork.Inner}
   *   <li>{@link NestedWork.Inner#setS(String)}
   *   <li>{@link NestedWork.Inner#getS()}
   * </ul>
   */
  @Test
  void testInnerGettersAndSetters() {
    // Arrange and Act
    NestedWork.Inner actualInner = new NestedWork.Inner();
    actualInner.setS("foo");

    // Assert that nothing has changed
    assertEquals("foo", actualInner.getS());
  }
}
