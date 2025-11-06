package org.finos.springbot.workflow.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MarkupWriterDiffblueTest {
  /**
   * Test {@link MarkupWriter#MarkupWriter()}.
   * <p>
   * Method under test: {@link MarkupWriter#MarkupWriter()}
   */
  @Test
  @DisplayName("Test new MarkupWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MarkupWriter.<init>()", "void MarkupWriter.<init>(Map)"})
  void testNewMarkupWriter() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>();

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Test {@link MarkupWriter#MarkupWriter(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkupWriter#MarkupWriter(Map)}
   */
  @Test
  @DisplayName("Test new MarkupWriter(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MarkupWriter.<init>()", "void MarkupWriter.<init>(Map)"})
  void testNewMarkupWriter_whenHashMap() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>(new HashMap<>());

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Test {@link MarkupWriter#apply(Content, Object)} with {@code Content}, {@code Object}.
   * <ul>
   *   <li>Given {@link MarkupWriter#MarkupWriter()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test apply(Content, Object) with 'Content', 'Object'; given MarkupWriter(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MarkupWriter.apply(Content, Object)"})
  void testApplyWithContentObject_givenMarkupWriter_thenReturnEmptyString() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>();

    // Act and Assert
    assertEquals("", markupWriter.apply(mock(Content.class), "42"));
  }

  /**
   * Test {@link MarkupWriter#apply(Content, Object)} with {@code Content}, {@code Object}.
   * <ul>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test apply(Content, Object) with 'Content', 'Object'; then return 'Apply'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MarkupWriter.apply(Content, Object)"})
  void testApplyWithContentObject_thenReturnApply() {
    // Arrange
    BiFunction<Content, Object, String> mapper = mock(BiFunction.class);
    when(mapper.apply(Mockito.<Content>any(), Mockito.<Object>any())).thenReturn("Apply");

    MarkupWriter<Object> markupWriter = new MarkupWriter<>();
    Class<Content> cl = Content.class;
    markupWriter.add(cl, mapper);

    // Act
    String actualApplyResult = markupWriter.apply(mock(Content.class), "42");

    // Assert
    verify(mapper).apply(isA(Content.class), isA(Object.class));
    assertEquals("Apply", actualApplyResult);
  }
}
