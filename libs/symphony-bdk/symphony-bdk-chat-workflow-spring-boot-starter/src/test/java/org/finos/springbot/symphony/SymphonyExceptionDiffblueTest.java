package org.finos.springbot.symphony;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyExceptionDiffblueTest {
  /**
   * Test {@link SymphonyException#SymphonyException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyException#SymphonyException(String)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SymphonyException.<init>(String)",
    "void SymphonyException.<init>(String, Throwable)",
    "void SymphonyException.<init>(Throwable)"
  })
  void testNewSymphonyException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    SymphonyException actualSymphonyException = new SymphonyException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSymphonyException.getMessage());
    assertNull(actualSymphonyException.getCause());
    assertEquals(0, actualSymphonyException.getSuppressed().length);
  }

  /**
   * Test {@link SymphonyException#SymphonyException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyException#SymphonyException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SymphonyException.<init>(String)",
    "void SymphonyException.<init>(String, Throwable)",
    "void SymphonyException.<init>(Throwable)"
  })
  void testNewSymphonyException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SymphonyException actualSymphonyException = new SymphonyException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualSymphonyException.getMessage());
    assertEquals(0, actualSymphonyException.getSuppressed().length);
    assertSame(cause, actualSymphonyException.getCause());
  }

  /**
   * Test {@link SymphonyException#SymphonyException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyException#SymphonyException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new SymphonyException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SymphonyException.<init>(String)",
    "void SymphonyException.<init>(String, Throwable)",
    "void SymphonyException.<init>(Throwable)"
  })
  void testNewSymphonyException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SymphonyException actualSymphonyException = new SymphonyException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualSymphonyException.getMessage());
    assertEquals(0, actualSymphonyException.getSuppressed().length);
    assertSame(cause, actualSymphonyException.getCause());
  }
}
