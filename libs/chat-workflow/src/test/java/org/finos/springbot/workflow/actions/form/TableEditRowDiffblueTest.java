package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TableEditRowDiffblueTest {
  /**
   * Test {@link TableEditRow#fixSpel(String)}.
   * <p>
   * Method under test: {@link TableEditRow#fixSpel(String)}
   */
  @Test
  @DisplayName("Test fixSpel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TableEditRow.fixSpel(String)"})
  void testFixSpel() {
    // Arrange, Act and Assert
    assertEquals("In", TableEditRow.fixSpel("In"));
  }
}
