package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class ReminderPropertiesDiffblueTest {
  /**
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("+00:00:01", actualDefaultTimeZone.toString());
    assertEquals("Welcome Message", actualWelcomeMessage);
    assertEquals(1, actualDefaultRemindBefore);
    assertSame(defaultTimeZone, actualDefaultTimeZone);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ReminderProperties}
   */
  @Test
  void testNewReminderProperties() {
    // Arrange and Act
    ReminderProperties actualReminderProperties = new ReminderProperties();

    // Assert
    assertEquals("Europe/London", actualReminderProperties.getDefaultTimeZone().toString());
    assertEquals(
        "Welcome!\n"
            + "I am the Reminder Bot. If you mention a date or time in your chat message , I will suggest creating a"
            + " reminder for it.\n" + "type /help for help and /list to see existing reminders.",
        actualReminderProperties.getWelcomeMessage());
    assertEquals(0, actualReminderProperties.getDefaultRemindBefore());
  }
}
