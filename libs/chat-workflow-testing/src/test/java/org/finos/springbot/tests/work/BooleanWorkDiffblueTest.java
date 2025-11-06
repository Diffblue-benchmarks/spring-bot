package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BooleanWorkDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanWork}
   *   <li>{@link BooleanWork#setS(Boolean)}
   *   <li>{@link BooleanWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BooleanWork.<init>()", "Boolean BooleanWork.getS()", "void BooleanWork.setS(Boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanWork actualBooleanWork = new BooleanWork();
    actualBooleanWork.setS(true);

    // Assert
    assertTrue(actualBooleanWork.getS());
  }
}
