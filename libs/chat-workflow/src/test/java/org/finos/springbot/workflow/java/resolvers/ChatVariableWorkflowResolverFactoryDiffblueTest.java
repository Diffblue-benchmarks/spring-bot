package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ChatVariableWorkflowResolverFactoryDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ChatVariableWorkflowResolverFactory}
   */
  @Test
  void testNewChatVariableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new ChatVariableWorkflowResolverFactory()).getOrder());
  }
}
