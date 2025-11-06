package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FormDataArgumentWorkflowResolverFactoryDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link FormDataArgumentWorkflowResolverFactory}
   */
  @Test
  void testNewFormDataArgumentWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new FormDataArgumentWorkflowResolverFactory()).getOrder());
  }
}
