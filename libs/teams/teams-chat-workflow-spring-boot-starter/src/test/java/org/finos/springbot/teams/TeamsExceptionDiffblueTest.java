package org.finos.springbot.teams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsExceptionDiffblueTest {
  /**
   * Test {@link TeamsException#TeamsException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsException#TeamsException(String)}
   */
  @Test
  @DisplayName("Test new TeamsException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.TeamsException.<init>(java.lang.String)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.Throwable)"})
  void testNewTeamsException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    TeamsException actualTeamsException = new TeamsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTeamsException.getMessage());
    assertNull(actualTeamsException.getCause());
    assertEquals(0, actualTeamsException.getSuppressed().length);
  }

  /**
   * Test {@link TeamsException#TeamsException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsException#TeamsException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new TeamsException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.TeamsException.<init>(java.lang.String)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.Throwable)"})
  void testNewTeamsException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
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
   * Test {@link TeamsException#TeamsException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsException#TeamsException(Throwable)}
   */
  @Test
  @DisplayName("Test new TeamsException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.TeamsException.<init>(java.lang.String)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.teams.TeamsException.<init>(java.lang.Throwable)"})
  void testNewTeamsException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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
