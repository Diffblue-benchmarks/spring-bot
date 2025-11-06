package org.finos.springbot.symphony;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class SymphonyExceptionDiffblueTest {
  /**
   * Method under test: {@link SymphonyException#SymphonyException(String)}
   */
  @Test
  void testNewSymphonyException() {
    // Arrange and Act
    SymphonyException actualSymphonyException = new SymphonyException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSymphonyException.getMessage());
    assertNull(actualSymphonyException.getCause());
    assertEquals(0, actualSymphonyException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SymphonyException#SymphonyException(String, Throwable)}
   */
  @Test
  void testNewSymphonyException2() {
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
   * Method under test: {@link SymphonyException#SymphonyException(Throwable)}
   */
  @Test
  void testNewSymphonyException3() {
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
