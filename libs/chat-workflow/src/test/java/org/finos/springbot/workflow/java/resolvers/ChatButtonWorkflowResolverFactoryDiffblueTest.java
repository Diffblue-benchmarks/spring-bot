package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChatButtonWorkflowResolverFactoryDiffblueTest {
  /**
   * Test new {@link ChatButtonWorkflowResolverFactory} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ChatButtonWorkflowResolverFactory}
   */
  @Test
  @DisplayName("Test new ChatButtonWorkflowResolverFactory (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.java.resolvers.ChatButtonWorkflowResolverFactory.<init>()"})
  void testNewChatButtonWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new ChatButtonWorkflowResolverFactory()).getOrder());
  }
}
