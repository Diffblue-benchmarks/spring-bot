package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class ReminderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Reminder#setAuthor(User)}
   *   <li>{@link Reminder#setDescription(String)}
   *   <li>{@link Reminder#setLocalTime(LocalDateTime)}
   *   <li>{@link Reminder#getAuthor()}
   *   <li>{@link Reminder#getDescription()}
   *   <li>{@link Reminder#getLocalTime()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Reminder reminder = new Reminder();
    SymphonyUser author = new SymphonyUser(1L);

    // Act
    reminder.setAuthor(author);
    reminder.setDescription("The characteristics of someone or something");
    LocalDateTime localTime = LocalDate.of(1970, 1, 1).atStartOfDay();
    reminder.setLocalTime(localTime);
    User actualAuthor = reminder.getAuthor();
    String actualDescription = reminder.getDescription();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualDescription);
    assertSame(author, actualAuthor);
    assertSame(localTime, reminder.getLocalTime());
  }

  /**
   * Method under test: default or parameterless constructor of {@link Reminder}
   */
  @Test
  void testNewReminder() {
    // Arrange and Act
    Reminder actualReminder = new Reminder();

    // Assert
    assertNull(actualReminder.getDescription());
    assertNull(actualReminder.getLocalTime());
    assertNull(actualReminder.getAuthor());
  }
}
