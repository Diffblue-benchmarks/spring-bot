package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReminderController.class, AllHistory.class, ReminderProperties.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ReminderControllerDiffblueTest {
  @Autowired
  private ReminderController reminderController;

  @Autowired
  private ReminderProperties reminderProperties;

  /**
   * Method under test:
   * {@link ReminderController#addreminder(Reminder, Addressable, User)}
   */
  @Test
  void testAddreminder() {
    // Arrange
    Reminder cr = new Reminder();
    cr.setAuthor(new SymphonyUser(1L));
    cr.setDescription("The characteristics of someone or something");
    cr.setLocalTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    // Act
    ReminderList actualAddreminderResult = reminderController.addreminder(cr, a, new SymphonyUser(1L));

    // Assert
    assertEquals("Europe/London", actualAddreminderResult.getTimeZone().toString());
    assertEquals(0, actualAddreminderResult.remindBefore.intValue());
    assertEquals(0, actualAddreminderResult.getRemindBefore());
    List<Reminder> reminders = actualAddreminderResult.getReminders();
    assertEquals(1, reminders.size());
    assertSame(cr, reminders.get(0));
  }

  /**
   * Method under test:
   * {@link ReminderController#addreminder(Reminder, Addressable, User)}
   */
  @Test
  void testAddreminder2() {
    // Arrange
    Reminder cr = new Reminder();
    cr.setAuthor(new SymphonyUser(2L));
    cr.setDescription("The characteristics of someone or something");
    cr.setLocalTime(LocalDate.of(1970, 1, 1).atStartOfDay());
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    // Act
    ReminderList actualAddreminderResult = reminderController.addreminder(cr, a, new SymphonyUser(1L));

    // Assert
    assertEquals("Europe/London", actualAddreminderResult.getTimeZone().toString());
    assertEquals(0, actualAddreminderResult.remindBefore.intValue());
    assertEquals(0, actualAddreminderResult.getRemindBefore());
    List<Reminder> reminders = actualAddreminderResult.getReminders();
    assertEquals(1, reminders.size());
    assertSame(cr, reminders.get(0));
  }

  /**
   * Method under test: {@link ReminderController#list(Addressable)}
   */
  @Test
  void testList() {
    // Arrange and Act
    ReminderList actualListResult = reminderController.list(new SymphonyRoom("Name", "42"));

    // Assert
    assertEquals("Europe/London", actualListResult.getTimeZone().toString());
    assertEquals(0, actualListResult.remindBefore.intValue());
    assertEquals(0, actualListResult.getRemindBefore());
    assertTrue(actualListResult.getReminders().isEmpty());
  }

  /**
   * Method under test: {@link ReminderController#list(Addressable)}
   */
  @Test
  void testList2() {
    // Arrange and Act
    ReminderList actualListResult = reminderController.list(new SymphonyRoom("42", "42"));

    // Assert
    assertEquals("Europe/London", actualListResult.getTimeZone().toString());
    assertEquals(0, actualListResult.remindBefore.intValue());
    assertEquals(0, actualListResult.getRemindBefore());
    assertTrue(actualListResult.getReminders().isEmpty());
  }

  /**
   * Method under test: {@link ReminderController#save(ReminderList)}
   */
  @Test
  void testSave() {
    // Arrange
    ReminderList rl = new ReminderList();

    // Act and Assert
    assertSame(rl, reminderController.save(rl));
  }

  /**
   * Method under test: {@link ReminderController#edit(ReminderList)}
   */
  @Test
  void testEdit() {
    // Arrange
    ReminderList rl = new ReminderList();

    // Act and Assert
    assertSame(rl, reminderController.edit(rl));
  }

  /**
   * Method under test: {@link ReminderController#timezones()}
   */
  @Test
  void testTimezones() {
    // Arrange and Act
    Map<String, String> actualTimezonesResult = reminderController.timezones();

    // Assert
    assertEquals(604, actualTimezonesResult.size());
    assertEquals("Africa/Cairo", actualTimezonesResult.get("Africa/Cairo"));
    assertEquals("Africa/Nairobi", actualTimezonesResult.get("Africa/Nairobi"));
    assertEquals("America/Cuiaba", actualTimezonesResult.get("America/Cuiaba"));
    assertEquals("America/El_Salvador", actualTimezonesResult.get("America/El_Salvador"));
    assertEquals("America/Marigot", actualTimezonesResult.get("America/Marigot"));
    assertEquals("Asia/Aden", actualTimezonesResult.get("Asia/Aden"));
    assertEquals("Asia/Aqtau", actualTimezonesResult.get("Asia/Aqtau"));
    assertEquals("Asia/Pontianak", actualTimezonesResult.get("Asia/Pontianak"));
    assertEquals("Etc/GMT+8", actualTimezonesResult.get("Etc/GMT+8"));
    assertEquals("Etc/GMT+9", actualTimezonesResult.get("Etc/GMT+9"));
    assertEquals("Pacific/Kwajalein", actualTimezonesResult.get("Pacific/Kwajalein"));
  }
}
