package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageHistoryWorkflowResolverFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MessageHistoryWorkflowResolverFactoryDiffblueTest {
  @MockBean
  private AllHistory allHistory;

  @Autowired
  private MessageHistoryWorkflowResolverFactory messageHistoryWorkflowResolverFactory;

  /**
   * Test {@link MessageHistoryWorkflowResolverFactory#MessageHistoryWorkflowResolverFactory(AllHistory)}.
   * <p>
   * Method under test: {@link MessageHistoryWorkflowResolverFactory#MessageHistoryWorkflowResolverFactory(AllHistory)}
   */
  @Test
  @DisplayName("Test new MessageHistoryWorkflowResolverFactory(AllHistory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.resolvers.MessageHistoryWorkflowResolverFactory.<init>(org.finos.springbot.workflow.history.AllHistory)"})
  void testNewMessageHistoryWorkflowResolverFactory() throws BeansException {
    // Arrange
    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, (new MessageHistoryWorkflowResolverFactory(hist)).getOrder());
  }

  /**
   * Test {@link MessageHistoryWorkflowResolverFactory#getOrder()}.
   * <p>
   * Method under test: {@link MessageHistoryWorkflowResolverFactory#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.workflow.java.resolvers.MessageHistoryWorkflowResolverFactory.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, messageHistoryWorkflowResolverFactory.getOrder());
  }
}
