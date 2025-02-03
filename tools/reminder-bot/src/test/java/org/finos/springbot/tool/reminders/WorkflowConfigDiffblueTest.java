package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

class WorkflowConfigDiffblueTest {
  /**
   * Test {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)}.
   * <p>
   * Method under test: {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)}
   */
  @Test
  @DisplayName("Test timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.reminders.TimeFinder org.finos.springbot.tool.reminders.WorkflowConfig.timeFinder(org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler, org.finos.springbot.workflow.conversations.AllConversations, org.finos.springbot.workflow.history.AllHistory, org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testTimeFinder() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    WorkflowConfig workflowConfig = new WorkflowConfig();
    ChatWorkflowErrorHandler eh = new ChatWorkflowErrorHandler(mock(ResponseHandlers.class), "Template Name");

    AllConversations sc = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    TimeFinder actualTimeFinderResult = workflowConfig.timeFinder(eh, sc, h, mock(ResponseHandlers.class));

    // Assert
    assertNull(actualTimeFinderResult.stanfordCoreNLP);
    assertNull(actualTimeFinderResult.reminderProperties);
  }
}
