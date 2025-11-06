package org.finos.springbot.workflow.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.Test;

class MarkupWriterDiffblueTest {
  /**
   * Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  void testApply() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>();

    // Act and Assert
    assertEquals("", markupWriter.apply(new CodeBlock.CodeBlockImpl("foo"), "42"));
  }

  /**
   * Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  void testApply2() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>();
    Class<Content> cl = Content.class;
    markupWriter.add(cl, new MarkupWriter<>());

    // Act and Assert
    assertEquals("", markupWriter.apply(new CodeBlock.CodeBlockImpl("foo"), "42"));
  }

  /**
   * Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  void testApply3() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>();

    // Act and Assert
    assertEquals("", markupWriter.apply(null, "42"));
  }

  /**
   * Method under test: {@link MarkupWriter.ImageWriter#ImageWriter(MarkupWriter)}
   */
  @Test
  void testImageWriterNewImageWriter() {
    // Arrange, Act and Assert
    assertEquals("img", ((new MarkupWriter()).new ImageWriter()).tag);
  }

  /**
   * Method under test: {@link MarkupWriter.LinkWriter#LinkWriter(MarkupWriter)}
   */
  @Test
  void testLinkWriterNewLinkWriter() {
    // Arrange, Act and Assert
    assertEquals("a", ((new MarkupWriter()).new LinkWriter()).tag);
  }

  /**
   * Method under test: {@link MarkupWriter#MarkupWriter()}
   */
  @Test
  void testNewMarkupWriter() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>();

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Method under test: {@link MarkupWriter#MarkupWriter(Map)}
   */
  @Test
  void testNewMarkupWriter2() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>(new HashMap<>());

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Method under test:
   * {@link MarkupWriter.OrderedTagWriter#OrderedTagWriter(MarkupWriter, String, BiFunction)}
   */
  @Test
  void testOrderedTagWriterNewOrderedTagWriter() {
    // Arrange
    MarkupWriter markupWriter = new MarkupWriter();

    // Act and Assert
    assertTrue(
        ((MarkupWriter<Object>) (markupWriter.new OrderedTagWriter("Tag", new MarkupWriter<>())).following).tagMap
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link MarkupWriter.SimpleTagWriter#SimpleTagWriter(MarkupWriter, String)}
   */
  @Test
  void testSimpleTagWriterNewSimpleTagWriter() {
    // Arrange, Act and Assert
    assertEquals("Tag", ((new MarkupWriter()).new SimpleTagWriter("Tag")).tag);
  }
}
