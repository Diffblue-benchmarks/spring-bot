package org.finos.springbot.tests.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PrimitivesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Primitives}
   *   <li>{@link Primitives#setA(String)}
   *   <li>{@link Primitives#setB(boolean)}
   *   <li>{@link Primitives#setC(int)}
   *   <li>{@link Primitives#setM(Primitives.Meal)}
   *   <li>{@link Primitives#getA()}
   *   <li>{@link Primitives#getC()}
   *   <li>{@link Primitives#getM()}
   *   <li>{@link Primitives#isB()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Primitives actualPrimitives = new Primitives();
    actualPrimitives.setA("foo");
    actualPrimitives.setB(true);
    actualPrimitives.setC(1);
    actualPrimitives.setM(Primitives.Meal.BREAKFAST);
    String actualA = actualPrimitives.getA();
    int actualC = actualPrimitives.getC();
    Primitives.Meal actualM = actualPrimitives.getM();

    // Assert that nothing has changed
    assertEquals("foo", actualA);
    assertEquals(1, actualC);
    assertEquals(Primitives.Meal.BREAKFAST, actualM);
    assertTrue(actualPrimitives.isB());
  }
}
