package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FormSubmissionDiffblueTest {
  /**
   * Method under test: {@link FormSubmission#FormSubmission(String, Object)}
   */
  @Test
  void testNewFormSubmission() {
    // Arrange and Act
    FormSubmission actualFormSubmission = new FormSubmission("Form Name", "Structure");

    // Assert
    assertEquals("Form Name", actualFormSubmission.formName);
    assertEquals("Structure", actualFormSubmission.structure);
  }
}
