package org.finos.springbot.tests.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tests.form.Primitives.Meal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrimitivesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Primitives}
   *   <li>{@link Primitives#setA(String)}
   *   <li>{@link Primitives#setB(boolean)}
   *   <li>{@link Primitives#setC(int)}
   *   <li>{@link Primitives#setM(Meal)}
   *   <li>{@link Primitives#getA()}
   *   <li>{@link Primitives#getC()}
   *   <li>{@link Primitives#getM()}
   *   <li>{@link Primitives#isB()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Primitives.<init>()", "String Primitives.getA()", "int Primitives.getC()",
      "Meal Primitives.getM()", "boolean Primitives.isB()", "void Primitives.setA(String)",
      "void Primitives.setB(boolean)", "void Primitives.setC(int)", "void Primitives.setM(Meal)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Primitives actualPrimitives = new Primitives();
    actualPrimitives.setA("foo");
    actualPrimitives.setB(true);
    actualPrimitives.setC(1);
    actualPrimitives.setM(Meal.BREAKFAST);
    String actualA = actualPrimitives.getA();
    int actualC = actualPrimitives.getC();
    Meal actualM = actualPrimitives.getM();

    // Assert
    assertEquals("foo", actualA);
    assertEquals(1, actualC);
    assertEquals(Meal.BREAKFAST, actualM);
    assertTrue(actualPrimitives.isB());
  }
}
