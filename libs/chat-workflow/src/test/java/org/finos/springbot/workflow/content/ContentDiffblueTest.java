package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ContentDiffblueTest {
  /**
   * Method under test: {@link Content#only(Class)}
   */
  @Test
  void testOnly() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act
    List<Content> actualOnlyResult = codeBlockImpl.only(x);

    // Assert
    assertEquals(1, actualOnlyResult.size());
    Content getResult = actualOnlyResult.get(0);
    assertTrue(getResult instanceof CodeBlock.CodeBlockImpl);
    assertEquals("foo", getResult.getText());
    assertSame(codeBlockImpl, getResult);
  }

  /**
   * Method under test: {@link Content#replace(Content, Content)}
   */
  @Test
  void testReplace() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    CodeBlock.CodeBlockImpl oldContent = new CodeBlock.CodeBlockImpl("foo");

    // Act
    Content actualReplaceResult = codeBlockImpl.replace(oldContent, new CodeBlock.CodeBlockImpl("foo"));
    String actualText = actualReplaceResult.getText();

    // Assert
    assertTrue(actualReplaceResult instanceof CodeBlock.CodeBlockImpl);
    assertEquals("foo", actualReplaceResult.getText());
    assertEquals("foo", actualText);
  }

  /**
   * Method under test: {@link Content#startsWith(Content)}
   */
  @Test
  void testStartsWith() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(codeBlockImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link Content#startsWith(Content)}
   */
  @Test
  void testStartsWith2() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl(
        "org.finos.springbot.workflow.content.CodeBlock");

    // Act and Assert
    assertFalse(codeBlockImpl.startsWith(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link Content#startsWith(Content)}
   */
  @Test
  void testStartsWith3() {
    // Arrange, Act and Assert
    assertFalse((new CodeBlock.CodeBlockImpl("foo")).startsWith(null));
  }

  /**
   * Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  void testGetNth() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act and Assert
    assertFalse(codeBlockImpl.getNth(x, 1).isPresent());
  }

  /**
   * Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  void testGetNth2() {
    // Arrange, Act and Assert
    assertFalse((new CodeBlock.CodeBlockImpl("foo")).getNth(null, 1).isPresent());
  }

  /**
   * Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  void testGetNth3() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act
    Optional<Content> actualNth = codeBlockImpl.getNth(x, 0);

    // Assert
    Content getResult = actualNth.get();
    assertTrue(getResult instanceof CodeBlock.CodeBlockImpl);
    assertEquals("foo", getResult.getText());
    assertTrue(actualNth.isPresent());
    assertSame(codeBlockImpl, getResult);
  }

  /**
   * Method under test: {@link Content#matches(Content)}
   */
  @Test
  void testMatches() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(codeBlockImpl.matches(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link Content#matches(Content)}
   */
  @Test
  void testMatches2() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl(
        "org.finos.springbot.workflow.content.CodeBlock");

    // Act and Assert
    assertFalse(codeBlockImpl.matches(new CodeBlock.CodeBlockImpl("foo")));
  }

  /**
   * Method under test: {@link Content#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange and Act
    Content actualEmptyResult = Content.empty();

    // Assert
    assertEquals("", actualEmptyResult.getText());
    assertFalse(actualEmptyResult.matches(null));
    assertFalse(actualEmptyResult.startsWith(null));
  }
}
