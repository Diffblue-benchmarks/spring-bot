package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ChatButtonWorkflowResolverFactoryDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ChatButtonWorkflowResolverFactory}
   */
  @Test
  void testNewChatButtonWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new ChatButtonWorkflowResolverFactory()).getOrder());
  }
}
