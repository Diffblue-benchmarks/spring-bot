package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageHistoryWorkflowResolverFactory.class, AllHistory.class})
@ExtendWith(SpringExtension.class)
class MessageHistoryWorkflowResolverFactoryDiffblueTest {
  @Autowired
  private MessageHistoryWorkflowResolverFactory messageHistoryWorkflowResolverFactory;

  /**
   * Method under test: {@link MessageHistoryWorkflowResolverFactory#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, messageHistoryWorkflowResolverFactory.getOrder());
  }

  /**
   * Method under test:
   * {@link MessageHistoryWorkflowResolverFactory#MessageHistoryWorkflowResolverFactory(AllHistory)}
   */
  @Test
  void testNewMessageHistoryWorkflowResolverFactory() throws BeansException {
    // Arrange
    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, (new MessageHistoryWorkflowResolverFactory(hist)).getOrder());
  }
}
