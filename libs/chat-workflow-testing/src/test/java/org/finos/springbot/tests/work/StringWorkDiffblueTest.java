package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringWork}
   *   <li>{@link StringWork#setS(String)}
   *   <li>{@link StringWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StringWork actualStringWork = new StringWork();
    actualStringWork.setS("foo");

    // Assert that nothing has changed
    assertEquals("foo", actualStringWork.getS());
  }
}
