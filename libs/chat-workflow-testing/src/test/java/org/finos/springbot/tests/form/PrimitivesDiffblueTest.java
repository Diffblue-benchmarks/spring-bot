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
  @MethodsUnderTest({"void org.finos.springbot.tests.form.Primitives.<init>()",
      "java.lang.String org.finos.springbot.tests.form.Primitives.getA()",
      "int org.finos.springbot.tests.form.Primitives.getC()",
      "org.finos.springbot.tests.form.Primitives$Meal org.finos.springbot.tests.form.Primitives.getM()",
      "boolean org.finos.springbot.tests.form.Primitives.isB()",
      "void org.finos.springbot.tests.form.Primitives.setA(java.lang.String)",
      "void org.finos.springbot.tests.form.Primitives.setB(boolean)",
      "void org.finos.springbot.tests.form.Primitives.setC(int)",
      "void org.finos.springbot.tests.form.Primitives.setM(org.finos.springbot.tests.form.Primitives$Meal)"})
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
