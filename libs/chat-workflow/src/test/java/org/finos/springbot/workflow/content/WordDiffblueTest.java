package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WordDiffblueTest {
  /**
   * Test {@link Word#of(String)}.
   * <p>
   * Method under test: {@link Word#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Word Word.of(String)"})
  void testOf() {
    // Arrange and Act
    Word actualOfResult = Word.of("foo");

    // Assert
    assertEquals("foo", actualOfResult.getText());
    assertEquals("foo", actualOfResult.getIdentifier());
  }
}
