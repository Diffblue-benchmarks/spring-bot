package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisplayWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.DisplayWork.<init>()",
      "java.lang.String org.finos.springbot.tests.work.DisplayWork.getInvisible()",
      "java.lang.String org.finos.springbot.tests.work.DisplayWork.getS()",
      "void org.finos.springbot.tests.work.DisplayWork.setInvisible(java.lang.String)",
      "void org.finos.springbot.tests.work.DisplayWork.setS(java.lang.String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    DisplayWork actualDisplayWork = new DisplayWork();
    actualDisplayWork.setInvisible("Invisible");
    actualDisplayWork.setS("foo");
    String actualInvisible = actualDisplayWork.getInvisible();

    // Assert
    assertEquals("Invisible", actualInvisible);
    assertEquals("foo", actualDisplayWork.getS());
  }
}
