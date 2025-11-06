package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class IntegerWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegerWork}
   *   <li>{@link IntegerWork#setS(Integer)}
   *   <li>{@link IntegerWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    IntegerWork actualIntegerWork = new IntegerWork();
    actualIntegerWork.setS(1);

    // Assert that nothing has changed
    assertEquals(1, actualIntegerWork.getS().intValue());
  }
}
