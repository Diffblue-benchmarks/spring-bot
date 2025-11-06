package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.util.ErrorHandler;

class TimeFinderDiffblueTest {
  /**
   * Method under test:
   * {@link TimeFinder#TimeFinder(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)}
   */
  @Test
  void testNewTimeFinder() throws BeansException {
    // Arrange
    ChatWorkflowErrorHandler errorHandler = new ChatWorkflowErrorHandler(null, "Template Name");

    AllConversations rooms = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    ReminderProperties reminderProperties = new ReminderProperties();
    reminderProperties.setDefaultRemindBefore(1);
    ZoneOffset defaultTimeZone = ZoneOffset.ofTotalSeconds(1);
    reminderProperties.setDefaultTimeZone(defaultTimeZone);
    reminderProperties.setWelcomeMessage("Welcome Message");

    // Act and Assert
    ReminderProperties reminderProperties2 = (new TimeFinder(errorHandler, rooms, h, reminderProperties,
        null)).reminderProperties;
    ZoneId defaultTimeZone2 = reminderProperties2.getDefaultTimeZone();
    assertEquals("+00:00:01", defaultTimeZone2.toString());
    assertEquals("Welcome Message", reminderProperties2.getWelcomeMessage());
    assertEquals(1, reminderProperties2.getDefaultRemindBefore());
    assertSame(defaultTimeZone, defaultTimeZone2);
  }
}
