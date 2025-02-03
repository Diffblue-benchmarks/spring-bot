package org.finos.springbot.workflow.templating;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractTableConverterDiffblueTest {
  /**
   * Test {@link AbstractTableConverter#getR()}.
   * <p>
   * Method under test: {@link AbstractTableConverter#getR()}
   */
  @Test
  @DisplayName("Test getR()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.templating.TableRendering org.finos.springbot.workflow.templating.AbstractTableConverter.getR()"})
  void testGetR() {
    // Arrange
    TableConverter<Object> tableConverter = new TableConverter<>(mock(TableRendering.class));

    // Act and Assert
    assertSame(tableConverter.r, tableConverter.getR());
  }
}
