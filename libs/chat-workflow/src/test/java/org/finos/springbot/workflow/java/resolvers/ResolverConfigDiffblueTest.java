package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

class ResolverConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ResolverConfig#messagePartWorkflowResolverFactory()}
   */
  @Test
  void testMessagePartWorkflowResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new ResolverConfig()).messagePartWorkflowResolverFactory().getOrder());
  }

  /**
   * Method under test:
   * {@link ResolverConfig#addressableWorkflowResolverFactory()}
   */
  @Test
  void testAddressableWorkflowResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        (new ResolverConfig()).addressableWorkflowResolverFactory().getOrder());
  }

  /**
   * Method under test: {@link ResolverConfig#historyResolver(AllHistory)}
   */
  @Test
  void testHistoryResolver() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResolverConfig resolverConfig = new ResolverConfig();

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.historyResolver(hist).getOrder());
  }
}
