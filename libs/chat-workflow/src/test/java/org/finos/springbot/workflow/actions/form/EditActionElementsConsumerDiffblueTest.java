package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.util.ErrorHandler;

class EditActionElementsConsumerDiffblueTest {
  /**
   * Method under test:
   * {@link EditActionElementsConsumer#EditActionElementsConsumer(ErrorHandler, ResponseHandlers)}
   */
  @Test
  void testNewEditActionElementsConsumer() {
    // Arrange, Act and Assert
    assertNull((new EditActionElementsConsumer(new ChatWorkflowErrorHandler(null, "Template Name"), null)).rh);
  }
}
