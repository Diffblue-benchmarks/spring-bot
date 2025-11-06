package org.finos.springbot.tool.rssbot.notify;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NotifierDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link Notifier}
   */
  @Test
  void testNewNotifier() {
    // Arrange and Act
    Notifier actualNotifier = new Notifier();

    // Assert
    assertNull(actualNotifier.properties);
    assertNull(actualNotifier.rh);
  }
}
