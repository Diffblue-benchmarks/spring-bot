package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DropdownWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DropdownWork}
   *   <li>{@link DropdownWork#setS(String)}
   *   <li>{@link DropdownWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DropdownWork actualDropdownWork = new DropdownWork();
    actualDropdownWork.setS("foo");

    // Assert that nothing has changed
    assertEquals("foo", actualDropdownWork.getS());
  }
}
