package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DisplayWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DisplayWork}
   *   <li>{@link DisplayWork#setInvisible(String)}
   *   <li>{@link DisplayWork#setS(String)}
   *   <li>{@link DisplayWork#getInvisible()}
   *   <li>{@link DisplayWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DisplayWork actualDisplayWork = new DisplayWork();
    actualDisplayWork.setInvisible("Invisible");
    actualDisplayWork.setS("foo");
    String actualInvisible = actualDisplayWork.getInvisible();

    // Assert that nothing has changed
    assertEquals("Invisible", actualInvisible);
    assertEquals("foo", actualDisplayWork.getS());
  }
}
