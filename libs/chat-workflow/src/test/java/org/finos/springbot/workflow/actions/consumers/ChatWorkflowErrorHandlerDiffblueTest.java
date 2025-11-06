package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;

class ChatWorkflowErrorHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link ChatWorkflowErrorHandler#ChatWorkflowErrorHandler(ResponseHandlers, String)}
   */
  @Test
  void testNewChatWorkflowErrorHandler() {
    // Arrange and Act
    ChatWorkflowErrorHandler actualChatWorkflowErrorHandler = new ChatWorkflowErrorHandler(null, "Template Name");

    // Assert
    assertEquals("Template Name", actualChatWorkflowErrorHandler.templateName);
    assertNull(actualChatWorkflowErrorHandler.rh);
  }
}
