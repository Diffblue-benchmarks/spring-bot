package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegerWork}
   *   <li>{@link IntegerWork#setS(Integer)}
   *   <li>{@link IntegerWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.IntegerWork.<init>()",
      "java.lang.Integer org.finos.springbot.tests.work.IntegerWork.getS()",
      "void org.finos.springbot.tests.work.IntegerWork.setS(java.lang.Integer)"})
  void testGettersAndSetters() {
    // Arrange and Act
    IntegerWork actualIntegerWork = new IntegerWork();
    actualIntegerWork.setS(1);

    // Assert
    assertEquals(1, actualIntegerWork.getS().intValue());
  }
}
