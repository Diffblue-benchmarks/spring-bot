package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.CodeBlock.CodeBlockImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CodeBlockDiffblueTest {
  /**
   * Test CodeBlockImpl {@link CodeBlockImpl#equals(Object)}, and {@link CodeBlockImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeBlockImpl#equals(Object)}
   *   <li>{@link CodeBlockImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test CodeBlockImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockImpl.equals(Object)", "int CodeBlockImpl.hashCode()"})
  void testCodeBlockImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    CodeBlockImpl codeBlockImpl2 = new CodeBlockImpl("foo");

    // Act and Assert
    assertEquals(codeBlockImpl, codeBlockImpl2);
    int expectedHashCodeResult = codeBlockImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeBlockImpl2.hashCode());
  }

  /**
   * Test CodeBlockImpl {@link CodeBlockImpl#equals(Object)}, and {@link CodeBlockImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeBlockImpl#equals(Object)}
   *   <li>{@link CodeBlockImpl#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test CodeBlockImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockImpl.equals(Object)", "int CodeBlockImpl.hashCode()"})
  void testCodeBlockImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    // Act and Assert
    assertEquals(codeBlockImpl, codeBlockImpl);
    int expectedHashCodeResult = codeBlockImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeBlockImpl.hashCode());
  }

  /**
   * Test CodeBlockImpl {@link CodeBlockImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeBlockImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CodeBlockImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockImpl.equals(Object)", "int CodeBlockImpl.hashCode()"})
  void testCodeBlockImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CodeBlockImpl codeBlockImpl =
        new CodeBlockImpl("org.finos.springbot.workflow.content.CodeBlock");

    // Act and Assert
    assertNotEquals(codeBlockImpl, new CodeBlockImpl("foo"));
  }

  /**
   * Test CodeBlockImpl {@link CodeBlockImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeBlockImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CodeBlockImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockImpl.equals(Object)", "int CodeBlockImpl.hashCode()"})
  void testCodeBlockImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeBlockImpl("foo"), null);
  }

  /**
   * Test CodeBlockImpl {@link CodeBlockImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeBlockImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test CodeBlockImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockImpl.equals(Object)", "int CodeBlockImpl.hashCode()"})
  void testCodeBlockImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CodeBlockImpl("foo"), "Different type to CodeBlockImpl");
  }

  /**
   * Test CodeBlockImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeBlockImpl#CodeBlockImpl(String)}
   *   <li>{@link CodeBlockImpl#toString()}
   *   <li>{@link CodeBlockImpl#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test CodeBlockImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CodeBlockImpl.<init>(String)",
    "String CodeBlockImpl.getText()",
    "String CodeBlockImpl.toString()"
  })
  void testCodeBlockImplGettersAndSetters() {
    // Arrange and Act
    CodeBlockImpl actualCodeBlockImpl = new CodeBlockImpl("foo");
    String actualToStringResult = actualCodeBlockImpl.toString();

    // Assert
    assertEquals("CodeBlock [foo]", actualToStringResult);
    assertEquals("foo", actualCodeBlockImpl.getText());
  }

  /**
   * Test {@link CodeBlock#of(String)}.
   *
   * <p>Method under test: {@link CodeBlock#of(String)}
   */
  @Test
  @DisplayName("Test of(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeBlock CodeBlock.of(String)"})
  void testOf() {
    // Arrange and Act
    CodeBlock actualOfResult = CodeBlock.of("foo");
    String actualText = actualOfResult.getText();

    // Assert
    assertTrue(actualOfResult instanceof CodeBlockImpl);
    assertEquals("foo", actualOfResult.getText());
    assertEquals("foo", actualText);
  }
}
