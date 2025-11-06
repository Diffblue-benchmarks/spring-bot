package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReminderListDiffblueTest {
  /**
   * Method under test: {@link ReminderList#getRemindBefore()}
   */
  @Test
  void testGetRemindBefore() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    reminderList.setRemindBefore(1);

    // Act and Assert
    assertEquals(1, reminderList.getRemindBefore());
  }

  /**
   * Method under test: {@link ReminderList#setRemindBefore(int)}
   */
  @Test
  void testSetRemindBefore() {
    // Arrange
    ReminderList reminderList = new ReminderList();

    // Act
    reminderList.setRemindBefore(1);

    // Assert
    assertEquals(1, reminderList.remindBefore.intValue());
    assertEquals(1, reminderList.getRemindBefore());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReminderList#ReminderList()}
   *   <li>{@link ReminderList#setReminders(List)}
   *   <li>{@link ReminderList#setTimeZone(ZoneId)}
   *   <li>{@link ReminderList#getReminders()}
   *   <li>{@link ReminderList#getTimeZone()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ReminderList actualReminderList = new ReminderList();
    ArrayList<Reminder> reminders = new ArrayList<>();
    actualReminderList.setReminders(reminders);
    ZoneOffset timeZone = ZoneOffset.ofTotalSeconds(1);
    actualReminderList.setTimeZone(timeZone);
    List<Reminder> actualReminders = actualReminderList.getReminders();
    ZoneId actualTimeZone = actualReminderList.getTimeZone();

    // Assert that nothing has changed
    assertEquals("+00:00:01", actualTimeZone.toString());
    assertTrue(actualReminders.isEmpty());
    assertSame(reminders, actualReminders);
    assertSame(timeZone, actualTimeZone);
  }

  /**
   * Method under test: {@link ReminderList#ReminderList(ReminderList)}
   */
  @Test
  void testNewReminderList() {
    // Arrange and Act
    ReminderList actualReminderList = new ReminderList(new ReminderList());

    // Assert
    assertNull(actualReminderList.remindBefore);
    assertNull(actualReminderList.getTimeZone());
    assertTrue(actualReminderList.getReminders().isEmpty());
  }
}
