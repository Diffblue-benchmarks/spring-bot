package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TimezonePickerDiffblueTest {
  /**
   * Test new {@link TimezonePicker} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TimezonePicker}
   */
  @Test
  @DisplayName("Test new TimezonePicker (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimezonePicker.<init>()"})
  void testNewTimezonePicker() {
    // Arrange, Act and Assert
    assertNull((new TimezonePicker()).timezone);
  }
}
