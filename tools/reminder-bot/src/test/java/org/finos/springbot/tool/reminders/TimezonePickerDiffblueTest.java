package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TimezonePickerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TimezonePicker}
   */
  @Test
  void testNewTimezonePicker() {
    // Arrange, Act and Assert
    assertNull((new TimezonePicker()).timezone);
  }
}
