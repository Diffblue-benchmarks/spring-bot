package org.finos.springbot.teams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class TeamsExceptionDiffblueTest {
  /**
   * Method under test: {@link TeamsException#TeamsException(String)}
   */
  @Test
  void testNewTeamsException() {
    // Arrange and Act
    TeamsException actualTeamsException = new TeamsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTeamsException.getMessage());
    assertNull(actualTeamsException.getCause());
    assertEquals(0, actualTeamsException.getSuppressed().length);
  }

  /**
   * Method under test: {@link TeamsException#TeamsException(String, Throwable)}
   */
  @Test
  void testNewTeamsException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TeamsException actualTeamsException = new TeamsException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTeamsException.getMessage());
    assertEquals(0, actualTeamsException.getSuppressed().length);
    assertSame(cause, actualTeamsException.getCause());
  }

  /**
   * Method under test: {@link TeamsException#TeamsException(Throwable)}
   */
  @Test
  void testNewTeamsException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TeamsException actualTeamsException = new TeamsException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualTeamsException.getMessage());
    assertEquals(0, actualTeamsException.getSuppressed().length);
    assertSame(cause, actualTeamsException.getCause());
  }
}
