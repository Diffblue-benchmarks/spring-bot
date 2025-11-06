package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.Test;

class MessageMatcherDiffblueTest {
  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new CodeBlock.CodeBlockImpl("foo"));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume2() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(
        new CodeBlock.CodeBlockImpl("org.finos.springbot.workflow.content.CodeBlock"));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume3() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(new ArrayList<>()));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume4() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(null);
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume5() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume6() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume7() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("Matched {} with start of {}"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume8() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new CodeBlock.CodeBlockImpl("foo"));

    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume9() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new BlockQuote.BlockQuoteImpl(new ArrayList<>()));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume10() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume11() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(null);
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));
    CodeBlock.CodeBlockImpl message = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume12() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new CodeBlock.CodeBlockImpl("foo"));

    ArrayList<Content> c = new ArrayList<>();
    c.add(new BlockQuote.BlockQuoteImpl(new ArrayList<>()));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertFalse(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume13() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));

    ArrayList<Content> c2 = new ArrayList<>();
    c2.add(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(c2);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  void testConsume14() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuote.BlockQuoteImpl(c));

    ArrayList<Content> c2 = new ArrayList<>();
    c2.add(new CodeBlock.CodeBlockImpl("foo"));
    c2.add(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl message = new BlockQuote.BlockQuoteImpl(c2);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }
}
