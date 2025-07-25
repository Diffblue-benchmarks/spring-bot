package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.annotations.ChatVariable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.java.mapping.WildcardContent.Arity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WildcardContentDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WildcardContent#WildcardContent(ChatVariable, Class, Arity)}
   *   <li>{@link WildcardContent#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WildcardContent.<init>(ChatVariable, Class, Arity)",
    "String WildcardContent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;

    // Act
    WildcardContent actualWildcardContent = new WildcardContent(chatVariable, expected, Arity.ONE);
    actualWildcardContent.toString();

    // Assert
    assertEquals("{null}", actualWildcardContent.getText());
    assertEquals(Arity.ONE, actualWildcardContent.arity);
    Class<Content> expectedResultClass = Content.class;
    assertEquals(expectedResultClass, actualWildcardContent.expected);
  }

  /**
   * Test {@link WildcardContent#getText()}.
   *
   * <p>Method under test: {@link WildcardContent#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WildcardContent.getText()"})
  void testGetText() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.name()).thenReturn("Name");
    Class<Content> expected = Content.class;

    // Act
    String actualText = new WildcardContent(chatVariable, expected, Arity.ONE).getText();

    // Assert
    verify(chatVariable).name();
    assertEquals("{Name}", actualText);
  }

  /**
   * Test {@link WildcardContent#matches(Content)}.
   *
   * <ul>
   *   <li>Given {@code Content}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardContent#matches(Content)}
   */
  @Test
  @DisplayName(
      "Test matches(Content); given 'org.finos.springbot.workflow.content.Content'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WildcardContent.matches(Content)"})
  void testMatches_givenOrgFinosSpringbotWorkflowContentContent_thenReturnTrue() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;

    // Act and Assert
    assertTrue(new WildcardContent(chatVariable, expected, Arity.ONE).matches(mock(Content.class)));
  }
}
