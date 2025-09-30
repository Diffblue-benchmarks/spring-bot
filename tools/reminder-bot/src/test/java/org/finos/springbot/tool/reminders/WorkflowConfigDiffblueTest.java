package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

@ExtendWith(MockitoExtension.class)
class WorkflowConfigDiffblueTest {
  @InjectMocks private ReminderProperties reminderProperties;

  @InjectMocks private WorkflowConfig workflowConfig;

  /**
   * Test {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory,
   * ResponseHandlers)}.
   *
   * <p>Method under test: {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler,
   * AllConversations, AllHistory, ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TimeFinder WorkflowConfig.timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)"
  })
  void testTimeFinder() throws BeansException {
    // Arrange
    ChatWorkflowErrorHandler eh =
        new ChatWorkflowErrorHandler(mock(ResponseHandlers.class), "Template Name");
    AllConversations sc = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    // Act
    TimeFinder actualTimeFinderResult =
        workflowConfig.timeFinder(eh, sc, h, mock(ResponseHandlers.class));

    // Assert
    assertNull(actualTimeFinderResult.stanfordCoreNLP);
    assertNull(actualTimeFinderResult.reminderProperties);
  }
}
