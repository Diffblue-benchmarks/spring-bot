package org.finos.springbot.workflow.actions.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FormEditConfigDiffblueTest {
  /**
   * Test {@link FormEditConfig#tableAddRow()}.
   *
   * <p>Method under test: {@link FormEditConfig#tableAddRow()}
   */
  @Test
  @DisplayName("Test tableAddRow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.actions.form.TableAddRow FormEditConfig.tableAddRow()"
  })
  void testTableAddRow() {
    // Arrange, Act and Assert
    assertNull(new FormEditConfig().tableAddRow().rh);
  }

  /**
   * Test {@link FormEditConfig#tableDeleteRows()}.
   *
   * <p>Method under test: {@link FormEditConfig#tableDeleteRows()}
   */
  @Test
  @DisplayName("Test tableDeleteRows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.actions.form.TableDeleteRows FormEditConfig.tableDeleteRows()"
  })
  void testTableDeleteRows() {
    // Arrange, Act and Assert
    assertNull(new FormEditConfig().tableDeleteRows().rh);
  }

  /**
   * Test {@link FormEditConfig#tableEditRow()}.
   *
   * <p>Method under test: {@link FormEditConfig#tableEditRow()}
   */
  @Test
  @DisplayName("Test tableEditRow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.actions.form.TableEditRow FormEditConfig.tableEditRow()"
  })
  void testTableEditRow() {
    // Arrange, Act and Assert
    assertNull(new FormEditConfig().tableEditRow().rh);
  }

  /**
   * Test {@link FormEditConfig#editActionElementsConsumer()}.
   *
   * <p>Method under test: {@link FormEditConfig#editActionElementsConsumer()}
   */
  @Test
  @DisplayName("Test editActionElementsConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.actions.form.EditActionElementsConsumer FormEditConfig.editActionElementsConsumer()"
  })
  void testEditActionElementsConsumer() {
    // Arrange, Act and Assert
    assertNull(new FormEditConfig().editActionElementsConsumer().rh);
  }
}
