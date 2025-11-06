package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

class WorkflowConfigDiffblueTest {
  /**
   * Method under test:
   * {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)}
   */
  @Test
  void testTimeFinder() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowConfig workflowConfig = new WorkflowConfig();
    ChatWorkflowErrorHandler eh = new ChatWorkflowErrorHandler(null, "Template Name");

    AllConversations sc = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    TimeFinder actualTimeFinderResult = workflowConfig.timeFinder(eh, sc, h, null);

    // Assert
    assertNull(actualTimeFinderResult.stanfordCoreNLP);
    assertNull(actualTimeFinderResult.reminderProperties);
    assertNull(actualTimeFinderResult.rh);
  }
}
