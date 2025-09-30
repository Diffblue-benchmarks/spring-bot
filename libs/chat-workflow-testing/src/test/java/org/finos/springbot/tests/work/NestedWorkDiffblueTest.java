package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tests.work.NestedWork.Inner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedWorkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NestedWork}
   *   <li>{@link NestedWork#setA(Inner)}
   *   <li>{@link NestedWork#setB(Inner)}
   *   <li>{@link NestedWork#getA()}
   *   <li>{@link NestedWork#getB()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NestedWork.<init>()",
    "Inner NestedWork.getA()",
    "Inner NestedWork.getB()",
    "void NestedWork.setA(Inner)",
    "void NestedWork.setB(Inner)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NestedWork actualNestedWork = new NestedWork();
    Inner a = new Inner();
    a.setS("foo");
    actualNestedWork.setA(a);
    Inner b = new Inner();
    b.setS("foo");
    actualNestedWork.setB(b);
    Inner actualA = actualNestedWork.getA();
    Inner actualB = actualNestedWork.getB();

    // Assert
    assertEquals("foo", actualA.getS());
    assertEquals("foo", actualB.getS());
    assertSame(a, actualA);
    assertSame(b, actualB);
  }

  /**
   * Test Inner getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Inner}
   *   <li>{@link Inner#setS(String)}
   *   <li>{@link Inner#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test Inner getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Inner.<init>()", "String Inner.getS()", "void Inner.setS(String)"})
  void testInnerGettersAndSetters() {
    // Arrange and Act
    Inner actualInner = new Inner();
    actualInner.setS("foo");

    // Assert
    assertEquals("foo", actualInner.getS());
  }
}
