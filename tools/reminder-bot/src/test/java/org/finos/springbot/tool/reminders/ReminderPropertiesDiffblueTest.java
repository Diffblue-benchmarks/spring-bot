package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReminderPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReminderProperties#setDefaultRemindBefore(int)}
   *   <li>{@link ReminderProperties#setDefaultTimeZone(ZoneId)}
   *   <li>{@link ReminderProperties#setWelcomeMessage(String)}
   *   <li>{@link ReminderProperties#getDefaultRemindBefore()}
   *   <li>{@link ReminderProperties#getDefaultTimeZone()}
   *   <li>{@link ReminderProperties#getWelcomeMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReminderProperties.getDefaultRemindBefore()",
    "ZoneId ReminderProperties.getDefaultTimeZone()",
    "String ReminderProperties.getWelcomeMessage()",
    "void ReminderProperties.setDefaultRemindBefore(int)",
    "void ReminderProperties.setDefaultTimeZone(ZoneId)",
    "void ReminderProperties.setWelcomeMessage(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    ReminderProperties reminderProperties = new ReminderProperties();

    // Act
    reminderProperties.setDefaultRemindBefore(1);
    ZoneOffset defaultTimeZone = ZoneOffset.ofTotalSeconds(1);
    reminderProperties.setDefaultTimeZone(defaultTimeZone);
    reminderProperties.setWelcomeMessage("Welcome Message");
    int actualDefaultRemindBefore = reminderProperties.getDefaultRemindBefore();
    ZoneId actualDefaultTimeZone = reminderProperties.getDefaultTimeZone();
    String actualWelcomeMessage = reminderProperties.getWelcomeMessage();

    // Assert
    assertEquals("+00:00:01", actualDefaultTimeZone.toString());
    assertEquals("Welcome Message", actualWelcomeMessage);
    assertEquals(1, actualDefaultRemindBefore);
    assertSame(defaultTimeZone, actualDefaultTimeZone);
  }

  /**
   * Test new {@link ReminderProperties} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ReminderProperties}
   */
  @Test
  @DisplayName("Test new ReminderProperties (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReminderProperties.<init>()"})
  void testNewReminderProperties() {
    // Arrange and Act
    ReminderProperties actualReminderProperties = new ReminderProperties();

    // Assert
    assertEquals(
        "Welcome!\n"
            + "I am the Reminder Bot. If you mention a date or time in your chat message , I will suggest creating a"
            + " reminder for it.\n"
            + "type /help for help and /list to see existing reminders.",
        actualReminderProperties.getWelcomeMessage());
    assertEquals(0, actualReminderProperties.getDefaultRemindBefore());
    String expectedToStringResult = System.getProperty("user.timezone");
    assertEquals(expectedToStringResult, actualReminderProperties.getDefaultTimeZone().toString());
  }
}
