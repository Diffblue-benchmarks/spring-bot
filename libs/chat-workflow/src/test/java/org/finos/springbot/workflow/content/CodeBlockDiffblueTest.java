package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CodeBlockDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeBlock.CodeBlockImpl#equals(Object)}
   *   <li>{@link CodeBlock.CodeBlockImpl#hashCode()}
   * </ul>
   */
  @Test
  void testCodeBlockImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    CodeBlock.CodeBlockImpl codeBlockImpl2 = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertEquals(codeBlockImpl, codeBlockImpl2);
    int expectedHashCodeResult = codeBlockImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeBlockImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeBlock.CodeBlockImpl#equals(Object)}
   *   <li>{@link CodeBlock.CodeBlockImpl#hashCode()}
   * </ul>
   */
  @Test
  void testCodeBlockImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl("foo");

    // Act and Assert
    assertEquals(codeBlockImpl, codeBlockImpl);
    int expectedHashCodeResult = codeBlockImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeBlockImpl.hashCode());
  }

  /**
   * Method under test: {@link CodeBlock.CodeBlockImpl#equals(Object)}
   */
  @Test
  void testCodeBlockImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CodeBlock.CodeBlockImpl codeBlockImpl = new CodeBlock.CodeBlockImpl(
        "org.finos.springbot.workflow.content.CodeBlock");

    // Act and Assert
    assertNotEquals(codeBlockImpl, new CodeBlock.CodeBlockImpl("foo"));
  }

  /**
   * Method under test: {@link CodeBlock.CodeBlockImpl#equals(Object)}
   */
  @Test
  void testCodeBlockImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeBlock.CodeBlockImpl("foo"), null);
  }

  /**
   * Method under test: {@link CodeBlock.CodeBlockImpl#equals(Object)}
   */
  @Test
  void testCodeBlockImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeBlock.CodeBlockImpl("foo"), "Different type to CodeBlockImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeBlock.CodeBlockImpl#CodeBlockImpl(String)}
   *   <li>{@link CodeBlock.CodeBlockImpl#toString()}
   *   <li>{@link CodeBlock.CodeBlockImpl#getText()}
   * </ul>
   */
  @Test
  void testCodeBlockImplGettersAndSetters() {
    // Arrange and Act
    CodeBlock.CodeBlockImpl actualCodeBlockImpl = new CodeBlock.CodeBlockImpl("foo");
    String actualToStringResult = actualCodeBlockImpl.toString();

    // Assert
    assertEquals("CodeBlock [foo]", actualToStringResult);
    assertEquals("foo", actualCodeBlockImpl.getText());
  }

  /**
   * Method under test: {@link CodeBlock#of(String)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    CodeBlock actualOfResult = CodeBlock.of("foo");
    String actualText = actualOfResult.getText();

    // Assert
    assertTrue(actualOfResult instanceof CodeBlock.CodeBlockImpl);
    assertEquals("foo", actualOfResult.getText());
    assertEquals("foo", actualText);
  }
}
