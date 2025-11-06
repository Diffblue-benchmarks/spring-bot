package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.util.ErrorHandler;

class TableDeleteRowsDiffblueTest {
  /**
   * Method under test:
   * {@link TableDeleteRows#TableDeleteRows(ErrorHandler, ResponseHandlers)}
   */
  @Test
  void testNewTableDeleteRows() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TableDeleteRows(new ChatWorkflowErrorHandler(null, "Template Name"), null)).rh);
  }
}
