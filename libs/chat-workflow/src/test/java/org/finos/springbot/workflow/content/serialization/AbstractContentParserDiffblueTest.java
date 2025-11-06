package org.finos.springbot.workflow.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.OrderedContent;
import org.finos.springbot.workflow.content.OrderedList;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.UnorderedList;
import org.junit.jupiter.api.Test;

class AbstractContentParserDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractContentParser.BlockQuoteFrame#getContents()}
   */
  @Test
  void testBlockQuoteFrameGetContents() {
    // Arrange
    AbstractContentParser.BlockQuoteFrame blockQuoteFrame = new AbstractContentParser.BlockQuoteFrame("Tag");

    // Act
    BlockQuote actualContents = blockQuoteFrame.getContents();

    // Assert
    assertTrue(actualContents instanceof BlockQuote.BlockQuoteImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    List<Content> contents = actualContents.getContents();
    assertTrue(contents.isEmpty());
    assertSame(blockQuoteFrame.stuffSoFar, contents);
  }

  /**
   * Method under test: {@link AbstractContentParser.CodeBlockFrame#getContents()}
   */
  @Test
  void testCodeBlockFrameGetContents() {
    // Arrange and Act
    CodeBlock actualContents = (new AbstractContentParser.CodeBlockFrame("Tag")).getContents();
    String actualText = actualContents.getText();

    // Assert
    assertTrue(actualContents instanceof CodeBlock.CodeBlockImpl);
    assertEquals("", actualContents.getText());
    assertEquals("", actualText);
  }

  /**
   * Method under test: {@link AbstractContentParser.CodeBlockFrame#hasContent()}
   */
  @Test
  void testCodeBlockFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse((new AbstractContentParser.CodeBlockFrame("Tag")).hasContent());
  }

  /**
   * Method under test:
   * {@link AbstractContentParser.ContainerFrame#isEnding(String)}
   */
  @Test
  void testContainerFrameIsEnding() {
    // Arrange, Act and Assert
    assertFalse((new AbstractContentParser.BlockQuoteFrame("Tag")).isEnding("Q Name"));
    assertTrue((new AbstractContentParser.BlockQuoteFrame("Q Name")).isEnding("Q Name"));
  }

  /**
   * Method under test: {@link AbstractContentParser.ListFrame#getContents()}
   */
  @Test
  void testListFrameGetContents() {
    // Arrange and Act
    OrderedContent<?> actualContents = (new AbstractContentParser.ListFrame("Q Name")).getContents();

    // Assert
    assertTrue(actualContents instanceof UnorderedList.UnorderedListImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Method under test: {@link AbstractContentParser.ListFrame#getContents()}
   */
  @Test
  void testListFrameGetContents2() {
    // Arrange and Act
    OrderedContent<?> actualContents = (new AbstractContentParser.ListFrame("ol")).getContents();

    // Assert
    assertTrue(actualContents instanceof OrderedList.OrderedListImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Method under test: {@link AbstractContentParser.ListFrame#hasContent()}
   */
  @Test
  void testListFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse((new AbstractContentParser.ListFrame("Q Name")).hasContent());
  }

  /**
   * Method under test: {@link AbstractContentParser.ListFrame#push(Content)}
   */
  @Test
  void testListFramePush() {
    // Arrange
    AbstractContentParser.ListFrame listFrame = new AbstractContentParser.ListFrame("Q Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> listFrame.push(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link AbstractContentParser.MessageFrame#getContents()}
   */
  @Test
  void testMessageFrameGetContents() {
    // Arrange
    AbstractContentParser.MessageFrame messageFrame = new AbstractContentParser.MessageFrame("Tag");

    // Act
    Message actualContents = messageFrame.getContents();

    // Assert
    assertTrue(actualContents instanceof Message.MessageImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    List<Content> contents = actualContents.getContents();
    assertTrue(contents.isEmpty());
    assertSame(messageFrame.stuffSoFar, contents);
  }

  /**
   * Method under test: {@link AbstractContentParser.ParagraphFrame#getContents()}
   */
  @Test
  void testParagraphFrameGetContents() {
    // Arrange
    AbstractContentParser.ParagraphFrame paragraphFrame = new AbstractContentParser.ParagraphFrame("Q Name");

    // Act
    Paragraph actualContents = paragraphFrame.getContents();

    // Assert
    assertTrue(actualContents instanceof Paragraph.ParagraphImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    List<Content> contents = actualContents.getContents();
    assertTrue(contents.isEmpty());
    assertSame(paragraphFrame.stuffSoFar, contents);
  }

  /**
   * Method under test: {@link AbstractContentParser.TableFrame#getContents()}
   */
  @Test
  void testTableFrameGetContents() {
    // Arrange and Act
    Table actualContents = (new AbstractContentParser.TableFrame("Q Name")).getContents();

    // Assert
    assertFalse(actualContents.matches(null));
    assertFalse(actualContents.startsWith(null));
  }

  /**
   * Method under test: {@link AbstractContentParser.TableFrame#hasContent()}
   */
  @Test
  void testTableFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse((new AbstractContentParser.TableFrame("Q Name")).hasContent());
  }

  /**
   * Method under test: {@link AbstractContentParser.TableFrame#newRow()}
   */
  @Test
  void testTableFrameNewRow() {
    // Arrange
    AbstractContentParser.TableFrame tableFrame = new AbstractContentParser.TableFrame("Q Name");

    // Act
    tableFrame.newRow();

    // Assert
    assertTrue(tableFrame.hasContent());
  }

  /**
   * Method under test: {@link AbstractContentParser.TextRunFrame#hasContent()}
   */
  @Test
  void testTextRunFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse((new AbstractContentParser.BlockQuoteFrame("Tag")).hasContent());
  }
}
