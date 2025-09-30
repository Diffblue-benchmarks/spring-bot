package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsErrorResourceResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsErrorResourceResponse#TeamsErrorResourceResponse(String, Throwable)}
   *   <li>{@link TeamsErrorResourceResponse#getThrowable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsErrorResourceResponse.<init>(String, Throwable)",
    "Throwable TeamsErrorResourceResponse.getThrowable()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    TeamsErrorResourceResponse actualTeamsErrorResourceResponse =
        new TeamsErrorResourceResponse("42", e);
    Throwable actualThrowable = actualTeamsErrorResourceResponse.getThrowable();

    // Assert
    assertEquals("42", actualTeamsErrorResourceResponse.getId());
    assertSame(e, actualThrowable);
  }
}
