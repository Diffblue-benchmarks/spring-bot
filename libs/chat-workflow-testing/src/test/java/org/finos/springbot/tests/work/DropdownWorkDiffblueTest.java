package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DropdownWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DropdownWork}
   *   <li>{@link DropdownWork#setS(String)}
   *   <li>{@link DropdownWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tests.work.DropdownWork.<init>()",
      "java.lang.String org.finos.springbot.tests.work.DropdownWork.getS()",
      "void org.finos.springbot.tests.work.DropdownWork.setS(java.lang.String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    DropdownWork actualDropdownWork = new DropdownWork();
    actualDropdownWork.setS("foo");

    // Assert
    assertEquals("foo", actualDropdownWork.getS());
  }
}
