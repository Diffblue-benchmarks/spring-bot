package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EntityMapResolverFactoryDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link EntityMapResolverFactory}
   */
  @Test
  void testNewEntityMapResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new EntityMapResolverFactory()).getOrder());
  }
}
