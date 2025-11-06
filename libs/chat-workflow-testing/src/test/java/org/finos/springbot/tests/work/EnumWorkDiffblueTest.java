package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EnumWorkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EnumWork}
   *   <li>{@link EnumWork#setS(EnumWork.TrafficLights)}
   *   <li>{@link EnumWork#getS()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EnumWork actualEnumWork = new EnumWork();
    actualEnumWork.setS(EnumWork.TrafficLights.RED);

    // Assert that nothing has changed
    assertEquals(EnumWork.TrafficLights.RED, actualEnumWork.getS());
  }
}
