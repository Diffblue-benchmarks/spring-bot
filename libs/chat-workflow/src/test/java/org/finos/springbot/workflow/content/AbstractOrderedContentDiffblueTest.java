package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AbstractOrderedContentDiffblueTest {
  /**
   * Method under test: {@link AbstractOrderedContent#getContents()}
   */
  @Test
  void testGetContents() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    List<Content> actualContents = (new BlockQuote.BlockQuoteImpl(c)).getContents();

    // Assert
    assertTrue(actualContents.isEmpty());
    assertSame(c, actualContents);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderedContent#equals(Object)}
   *   <li>{@link AbstractOrderedContent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());
    BlockQuote.BlockQuoteImpl blockQuoteImpl2 = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertEquals(blockQuoteImpl, blockQuoteImpl2);
    int expectedHashCodeResult = blockQuoteImpl.hashCode();
    assertEquals(expectedHashCodeResult, blockQuoteImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractOrderedContent#equals(Object)}
   *   <li>{@link AbstractOrderedContent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertEquals(blockQuoteImpl, blockQuoteImpl);
    int expectedHashCodeResult = blockQuoteImpl.hashCode();
    assertEquals(expectedHashCodeResult, blockQuoteImpl.hashCode());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("", (new BlockQuote.BlockQuoteImpl(new ArrayList<>())).getText());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  void testGetText2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertEquals("foo", (new BlockQuote.BlockQuoteImpl(c)).getText());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  void testGetText3() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    c.add(new CodeBlock.CodeBlockImpl("foo"));

    // Act and Assert
    assertEquals("foo foo", (new BlockQuote.BlockQuoteImpl(c)).getText());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  void testGetText4() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new BlockQuote.BlockQuoteImpl(new ArrayList<>()));

    // Act and Assert
    assertEquals("", (new BlockQuote.BlockQuoteImpl(c)).getText());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#getText()}
   */
  @Test
  void testGetText5() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    c.add(new CodeBlock.CodeBlockImpl(""));

    // Act and Assert
    assertEquals("foo", (new BlockQuote.BlockQuoteImpl(c)).getText());
  }

  /**
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlock.CodeBlockImpl("foo"));
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Act and Assert
    assertNotEquals(blockQuoteImpl, new BlockQuote.BlockQuoteImpl(new ArrayList<>()));
  }

  /**
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockQuote.BlockQuoteImpl(new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link AbstractOrderedContent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BlockQuote.BlockQuoteImpl(new ArrayList<>()), "Different type to AbstractOrderedContent");
  }
}
