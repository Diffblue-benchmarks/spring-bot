package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.util.ErrorHandler;

@DisabledInAotMode
class TableEditRowDiffblueTest {
  @MockBean
  private ErrorHandler errorHandler;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test {@link TableEditRow#fixSpel(String)}.
   * <p>
   * Method under test: {@link TableEditRow#fixSpel(String)}
   */
  @Test
  @DisplayName("Test fixSpel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.workflow.actions.form.TableEditRow.fixSpel(java.lang.String)"})
  void testFixSpel() {
    // Arrange, Act and Assert
    assertEquals("In", TableEditRow.fixSpel("In"));
  }
}
