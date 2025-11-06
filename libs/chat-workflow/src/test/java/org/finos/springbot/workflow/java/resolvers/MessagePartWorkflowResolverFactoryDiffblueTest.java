package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MessagePartWorkflowResolverFactoryDiffblueTest {
  /**
   * Method under test: {@link MessagePartWorkflowResolverFactory#getOrder()}
   */
  @Test
  void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new MessagePartWorkflowResolverFactory(new ArrayList<>())).getOrder());
  }

  /**
   * Method under test:
   * {@link MessagePartWorkflowResolverFactory#MessagePartWorkflowResolverFactory(List)}
   */
  @Test
  void testNewMessagePartWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new MessagePartWorkflowResolverFactory(new ArrayList<>())).getOrder());
  }
}
