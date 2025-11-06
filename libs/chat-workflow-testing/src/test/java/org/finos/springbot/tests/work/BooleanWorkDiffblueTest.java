package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BooleanWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanWork}
   *   <li>{@link BooleanWork#setS(Boolean)}
   *   <li>{@link BooleanWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanWork actualBooleanWork = new BooleanWork();
    actualBooleanWork.setS(true);

    // Assert that nothing has changed
    assertTrue(actualBooleanWork.getS());
  }
}
