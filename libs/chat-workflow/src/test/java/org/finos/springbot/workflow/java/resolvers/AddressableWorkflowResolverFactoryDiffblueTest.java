package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AddressableWorkflowResolverFactory.class})
@ExtendWith(SpringExtension.class)
class AddressableWorkflowResolverFactoryDiffblueTest {
  @Autowired
  private AddressableWorkflowResolverFactory addressableWorkflowResolverFactory;

  /**
   * Method under test: {@link AddressableWorkflowResolverFactory#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, addressableWorkflowResolverFactory.getOrder());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AddressableWorkflowResolverFactory}
   */
  @Test
  void testNewAddressableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new AddressableWorkflowResolverFactory()).getOrder());
  }
}
