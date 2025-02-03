package org.finos.springbot.symphony;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SymphonyExceptionDiffblueTest {
  /**
   * Test {@link SymphonyException#SymphonyException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyException#SymphonyException(String)}
   */
  @Test
  @DisplayName("Test new SymphonyException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.Throwable)"})
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
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyException#SymphonyException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new SymphonyException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.Throwable)"})
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
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyException#SymphonyException(Throwable)}
   */
  @Test
  @DisplayName("Test new SymphonyException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.String, java.lang.Throwable)",
      "void org.finos.springbot.symphony.SymphonyException.<init>(java.lang.Throwable)"})
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
