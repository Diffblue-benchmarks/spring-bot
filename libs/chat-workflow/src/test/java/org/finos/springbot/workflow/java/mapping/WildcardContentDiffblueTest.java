package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.annotations.ChatVariable;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.Test;

class WildcardContentDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WildcardContent#WildcardContent(ChatVariable, Class, WildcardContent.Arity)}
   *   <li>{@link WildcardContent#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Class<Content> expected = Content.class;

    // Act and Assert
    assertEquals("WildcardContent [null, org.finos.springbot.workflow.content.Content, ONE]",
        (new WildcardContent(null, expected, WildcardContent.Arity.ONE)).toString());
  }

  /**
   * Method under test: {@link WildcardContent#matches(Content)}
   */
  @Test
  void testMatches() {
    // Arrange
    Class<Content> expected = Content.class;
    WildcardContent wildcardContent = new WildcardContent(null, expected, WildcardContent.Arity.ONE);

    // Act and Assert
    assertTrue(wildcardContent.matches(new CodeBlock.CodeBlockImpl("foo")));
  }
}
