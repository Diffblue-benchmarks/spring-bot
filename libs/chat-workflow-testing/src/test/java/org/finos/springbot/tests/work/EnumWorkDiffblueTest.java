package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.tests.work.EnumWork.TrafficLights;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EnumWork}
   *   <li>{@link EnumWork#setS(TrafficLights)}
   *   <li>{@link EnumWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.EnumWork.<init>()",
      "org.finos.springbot.tests.work.EnumWork$TrafficLights org.finos.springbot.tests.work.EnumWork.getS()",
      "void org.finos.springbot.tests.work.EnumWork.setS(org.finos.springbot.tests.work.EnumWork$TrafficLights)"})
  void testGettersAndSetters() {
    // Arrange and Act
    EnumWork actualEnumWork = new EnumWork();
    actualEnumWork.setS(TrafficLights.RED);

    // Assert
    assertEquals(TrafficLights.RED, actualEnumWork.getS());
  }
}
