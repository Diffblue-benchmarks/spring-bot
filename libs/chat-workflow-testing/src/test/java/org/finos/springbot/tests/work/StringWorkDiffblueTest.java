package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringWorkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StringWork}
   *   <li>{@link StringWork#getS()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StringWork.<init>()",
    "java.lang.String StringWork.getS()",
    "void StringWork.setS(java.lang.String)"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new StringWork().getS());
  }
}
