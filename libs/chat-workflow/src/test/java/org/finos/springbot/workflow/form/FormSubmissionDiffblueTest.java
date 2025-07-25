package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormSubmissionDiffblueTest {
  /**
   * Test {@link FormSubmission#FormSubmission(String, Object)}.
   *
   * <p>Method under test: {@link FormSubmission#FormSubmission(String, Object)}
   */
  @Test
  @DisplayName("Test new FormSubmission(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormSubmission.<init>(String, Object)"})
  void testNewFormSubmission() {
    // Arrange and Act
    FormSubmission actualFormSubmission = new FormSubmission("Form Name", "Structure");

    // Assert
    assertEquals("Form Name", actualFormSubmission.formName);
    assertEquals("Structure", actualFormSubmission.structure);
  }
}
