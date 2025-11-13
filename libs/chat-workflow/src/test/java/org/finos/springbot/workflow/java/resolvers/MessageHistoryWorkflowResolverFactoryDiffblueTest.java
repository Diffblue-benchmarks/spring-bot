package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageHistoryWorkflowResolverFactory.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class MessageHistoryWorkflowResolverFactoryDiffblueTest {
  @MockitoBean private AllHistory allHistory;

  @Autowired private MessageHistoryWorkflowResolverFactory messageHistoryWorkflowResolverFactory;

  /**
   * Test {@link
   * MessageHistoryWorkflowResolverFactory#MessageHistoryWorkflowResolverFactory(AllHistory)}.
   *
   * <p>Method under test: {@link
   * MessageHistoryWorkflowResolverFactory#MessageHistoryWorkflowResolverFactory(AllHistory)}
   */
  @Test
  @DisplayName("Test new MessageHistoryWorkflowResolverFactory(AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageHistoryWorkflowResolverFactory.<init>(AllHistory)"})
  void testNewMessageHistoryWorkflowResolverFactory() throws BeansException {
    // Arrange
    AllHistory hist = new AllHistory();
    hist.setApplicationContext(mock(ApplicationContext.class));

    // Act and Assert
    assertEquals(
        WorkflowResolverFactory.LOW_PRIORITY,
        new MessageHistoryWorkflowResolverFactory(hist).getOrder());
  }

  /**
   * Test {@link MessageHistoryWorkflowResolverFactory#getOrder()}.
   *
   * <p>Method under test: {@link MessageHistoryWorkflowResolverFactory#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int MessageHistoryWorkflowResolverFactory.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.LOW_PRIORITY, messageHistoryWorkflowResolverFactory.getOrder());
  }
}
