package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReminderListDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReminderList#ReminderList()}
   *   <li>{@link ReminderList#setReminders(List)}
   *   <li>{@link ReminderList#setTimeZone(ZoneId)}
   *   <li>{@link ReminderList#getReminders()}
   *   <li>{@link ReminderList#getTimeZone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReminderList.<init>()",
    "List ReminderList.getReminders()",
    "ZoneId ReminderList.getTimeZone()",
    "void ReminderList.setReminders(List)",
    "void ReminderList.setTimeZone(ZoneId)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ReminderList actualReminderList = new ReminderList();
    ArrayList<Reminder> reminders = new ArrayList<>();
    actualReminderList.setReminders(reminders);
    ZoneOffset timeZone = ZoneOffset.ofTotalSeconds(1);
    actualReminderList.setTimeZone(timeZone);
    List<Reminder> actualReminders = actualReminderList.getReminders();
    ZoneId actualTimeZone = actualReminderList.getTimeZone();

    // Assert
    assertEquals("+00:00:01", actualTimeZone.toString());
    assertTrue(actualReminders.isEmpty());
    assertSame(reminders, actualReminders);
    assertSame(timeZone, actualTimeZone);
  }

  /**
   * Test {@link ReminderList#ReminderList(ReminderList)}.
   *
   * <ul>
   *   <li>When {@link ReminderList#ReminderList()}.
   *   <li>Then return {@link ReminderList#remindBefore} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReminderList#ReminderList(ReminderList)}
   */
  @Test
  @DisplayName(
      "Test new ReminderList(ReminderList); when ReminderList(); then return remindBefore is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReminderList.<init>(ReminderList)"})
  void testNewReminderList_whenReminderList_thenReturnRemindBeforeIsNull() {
    // Arrange and Act
    ReminderList actualReminderList = new ReminderList(new ReminderList());

    // Assert
    assertNull(actualReminderList.remindBefore);
    assertNull(actualReminderList.getTimeZone());
    assertTrue(actualReminderList.getReminders().isEmpty());
  }

  /**
   * Test {@link ReminderList#getRemindBefore()}.
   *
   * <ul>
   *   <li>Given {@link ReminderList#ReminderList()} RemindBefore is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReminderList#getRemindBefore()}
   */
  @Test
  @DisplayName("Test getRemindBefore(); given ReminderList() RemindBefore is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ReminderList.getRemindBefore()"})
  void testGetRemindBefore_givenReminderListRemindBeforeIsOne_thenReturnOne() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    reminderList.setRemindBefore(1);

    // Act and Assert
    assertEquals(1, reminderList.getRemindBefore());
  }

  /**
   * Test {@link ReminderList#setRemindBefore(int)}.
   *
   * <p>Method under test: {@link ReminderList#setRemindBefore(int)}
   */
  @Test
  @DisplayName("Test setRemindBefore(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReminderList.setRemindBefore(int)"})
  void testSetRemindBefore() {
    // Arrange
    ReminderList reminderList = new ReminderList();

    // Act
    reminderList.setRemindBefore(1);

    // Assert
    assertEquals(1, reminderList.remindBefore.intValue());
    assertEquals(1, reminderList.getRemindBefore());
  }
}
