package org.finos.springbot.tests.work;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DisplayWorkDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DisplayWork.<init>()",
    "String DisplayWork.getInvisible()",
    "String DisplayWork.getS()",
    "void DisplayWork.setInvisible(String)",
    "void DisplayWork.setS(String)"
  })
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
