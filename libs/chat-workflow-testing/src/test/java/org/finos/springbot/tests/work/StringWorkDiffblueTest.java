package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringWork}
   *   <li>{@link StringWork#setS(String)}
   *   <li>{@link StringWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringWork.<init>()", "String StringWork.getS()", "void StringWork.setS(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    StringWork actualStringWork = new StringWork();
    actualStringWork.setS("foo");

    // Assert
    assertEquals("foo", actualStringWork.getS());
  }
}
