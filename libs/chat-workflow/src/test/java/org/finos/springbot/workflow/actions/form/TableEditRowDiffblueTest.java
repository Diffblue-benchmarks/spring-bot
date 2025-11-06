package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.util.ErrorHandler;

class TableEditRowDiffblueTest {
  /**
   * Method under test: {@link TableEditRow#fixSpel(String)}
   */
  @Test
  void testFixSpel() {
    // Arrange, Act and Assert
    assertEquals("In", TableEditRow.fixSpel("In"));
  }

  /**
   * Method under test:
   * {@link TableEditRow#TableEditRow(ErrorHandler, ResponseHandlers)}
   */
  @Test
  void testNewTableEditRow() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TableEditRow(new ChatWorkflowErrorHandler(null, "Template Name"), null)).rh);
  }
}
