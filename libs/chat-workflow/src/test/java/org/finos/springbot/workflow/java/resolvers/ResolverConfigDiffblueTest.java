package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResolverConfig.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ResolverConfigDiffblueTest {
  @MockBean
  private BeanFactory beanFactory;

  @Autowired
  private ResolverConfig resolverConfig;

  /**
   * Test {@link ResolverConfig#springBeanResolver()}.
   * <p>
   * Method under test: {@link ResolverConfig#springBeanResolver()}
   */
  @Test
  @DisplayName("Test springBeanResolver()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.springBeanResolver()"})
  void testSpringBeanResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    WorkflowResolverFactory actualSpringBeanResolverResult = (new ResolverConfig()).springBeanResolver();
    actualSpringBeanResolverResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, actualSpringBeanResolverResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#messagePartWorkflowResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#messagePartWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test messagePartWorkflowResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.messagePartWorkflowResolverFactory()"})
  void testMessagePartWorkflowResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new ResolverConfig()).messagePartWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#chatButtonWorkflowResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#chatButtonWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test chatButtonWorkflowResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.ChatButtonWorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.chatButtonWorkflowResolverFactory()"})
  void testChatButtonWorkflowResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    ChatButtonWorkflowResolverFactory actualChatButtonWorkflowResolverFactoryResult = (new ResolverConfig())
        .chatButtonWorkflowResolverFactory();
    actualChatButtonWorkflowResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, actualChatButtonWorkflowResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#chatVariableWorkflowResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#chatVariableWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test chatVariableWorkflowResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.ChatVariableWorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.chatVariableWorkflowResolverFactory()"})
  void testChatVariableWorkflowResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    ChatVariableWorkflowResolverFactory actualChatVariableWorkflowResolverFactoryResult = (new ResolverConfig())
        .chatVariableWorkflowResolverFactory();
    actualChatVariableWorkflowResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, actualChatVariableWorkflowResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#addressableWorkflowResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#addressableWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test addressableWorkflowResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.AddressableWorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.addressableWorkflowResolverFactory()"})
  void testAddressableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.addressableWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#entityMapResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#entityMapResolverFactory()}
   */
  @Test
  @DisplayName("Test entityMapResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.EntityMapResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.entityMapResolverFactory()"})
  void testEntityMapResolverFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    EntityMapResolverFactory actualEntityMapResolverFactoryResult = (new ResolverConfig()).entityMapResolverFactory();
    actualEntityMapResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, actualEntityMapResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#historyResolver(AllHistory)}.
   * <p>
   * Method under test: {@link ResolverConfig#historyResolver(AllHistory)}
   */
  @Test
  @DisplayName("Test historyResolver(AllHistory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.MessageHistoryWorkflowResolverFactory org.finos.springbot.workflow.java.resolvers.ResolverConfig.historyResolver(org.finos.springbot.workflow.history.AllHistory)"})
  void testHistoryResolver() throws BeansException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ResolverConfig resolverConfig = new ResolverConfig();

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.historyResolver(hist).getOrder());
  }
}
