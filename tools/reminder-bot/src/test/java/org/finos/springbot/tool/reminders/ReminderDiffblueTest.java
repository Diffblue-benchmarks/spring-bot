package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReminderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.reminders.Reminder.getAuthor()",
      "java.lang.String org.finos.springbot.tool.reminders.Reminder.getDescription()",
      "java.time.LocalDateTime org.finos.springbot.tool.reminders.Reminder.getLocalTime()",
      "void org.finos.springbot.tool.reminders.Reminder.setAuthor(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.tool.reminders.Reminder.setDescription(java.lang.String)",
      "void org.finos.springbot.tool.reminders.Reminder.setLocalTime(java.time.LocalDateTime)"})
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

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertSame(author, actualAuthor);
    assertSame(localTime, reminder.getLocalTime());
  }

  /**
   * Test new {@link Reminder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Reminder}
   */
  @Test
  @DisplayName("Test new Reminder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.reminders.Reminder.<init>()"})
  void testNewReminder() {
    // Arrange and Act
    Reminder actualReminder = new Reminder();

    // Assert
    assertNull(actualReminder.getDescription());
    assertNull(actualReminder.getLocalTime());
    assertNull(actualReminder.getAuthor());
  }
}
