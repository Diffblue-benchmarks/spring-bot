package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderedContentDiffblueTest {
  /**
   * Method under test: {@link OrderedContent#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new BlockQuote.BlockQuoteImpl(new ArrayList<>())).iterator().hasNext());
  }

  /**
   * Method under test: {@link OrderedContent#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new BlockQuote.BlockQuoteImpl(new ArrayList<>())).size());
  }

  /**
   * Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  void testRemoveAtStart() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(new CodeBlock.CodeBlockImpl("foo"));
    String actualText = actualRemoveAtStartResult.getText();

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuote.BlockQuoteImpl);
    assertEquals("", actualRemoveAtStartResult.getText());
    assertEquals("", actualText);
    assertEquals(0, ((BlockQuote.BlockQuoteImpl) actualRemoveAtStartResult).size());
    assertFalse(((BlockQuote.BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    List<Content> contents = ((BlockQuote.BlockQuoteImpl) actualRemoveAtStartResult).getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link OrderedContent#replace(Content, Content)}
   */
  @Test
  void testReplace() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);
    CodeBlock.CodeBlockImpl oldContent = new CodeBlock.CodeBlockImpl("foo");

    // Act
    Content actualReplaceResult = blockQuoteImpl.replace(oldContent, new CodeBlock.CodeBlockImpl("foo"));
    String actualText = actualReplaceResult.getText();

    // Assert
    assertTrue(actualReplaceResult instanceof BlockQuote.BlockQuoteImpl);
    assertEquals("", actualReplaceResult.getText());
    assertEquals("", actualText);
    assertEquals(0, ((BlockQuote.BlockQuoteImpl) actualReplaceResult).size());
    assertFalse(((BlockQuote.BlockQuoteImpl) actualReplaceResult).iterator().hasNext());
    List<Content> contents = ((BlockQuote.BlockQuoteImpl) actualReplaceResult).getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertFalse(blockQuoteImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertTrue(blockQuoteImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith3() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("org.finos.springbot.workflow.content.CodeBlock"));
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertFalse(blockQuoteImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith4() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(blockQuoteImpl.startsWith(new BlockQuote.BlockQuoteImpl(new ArrayList<>())));
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith5() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new BlockQuote.BlockQuoteImpl(new ArrayList<>()));
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertFalse(blockQuoteImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  void testStartsWith6() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertFalse((new BlockQuote.BlockQuoteImpl(c)).startsWith(null));
  }

  /**
   * Method under test: {@link OrderedContent#only(Class)}
   */
  @Test
  void testOnly() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());
    Class<Content> x = Content.class;

    // Act
    List<Content> actualOnlyResult = blockQuoteImpl.only(x);

    // Assert
    assertEquals(1, actualOnlyResult.size());
    assertSame(blockQuoteImpl, actualOnlyResult.get(0));
  }

  /**
   * Method under test: {@link OrderedContent#without(Content)}
   */
  @Test
  void testWithout() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act
    Content actualWithoutResult = blockQuoteImpl.without(new CodeBlock.CodeBlockImpl("foo"));

    // Assert
    assertTrue(actualWithoutResult instanceof BlockQuote.BlockQuoteImpl);
    assertEquals("", actualWithoutResult.getText());
    assertEquals(blockQuoteImpl, actualWithoutResult);
  }
}
