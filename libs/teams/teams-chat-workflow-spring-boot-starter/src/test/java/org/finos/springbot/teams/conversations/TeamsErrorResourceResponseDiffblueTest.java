package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class TeamsErrorResourceResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsErrorResourceResponse#TeamsErrorResourceResponse(String, Throwable)}
   *   <li>{@link TeamsErrorResourceResponse#getThrowable()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    TeamsErrorResourceResponse actualTeamsErrorResourceResponse = new TeamsErrorResourceResponse("42", e);
    Throwable actualThrowable = actualTeamsErrorResourceResponse.getThrowable();

    // Assert
    assertEquals("42", actualTeamsErrorResourceResponse.getId());
    assertSame(e, actualThrowable);
  }
}
