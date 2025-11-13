package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResolverConfig.class})
@ExtendWith(SpringExtension.class)
class ResolverConfigDiffblueTest {
  @Autowired private ResolverConfig resolverConfig;

  /**
   * Test {@link ResolverConfig#springBeanResolver()}.
   *
   * <p>Method under test: {@link ResolverConfig#springBeanResolver()}
   */
  @Test
  @DisplayName("Test springBeanResolver()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkflowResolverFactory ResolverConfig.springBeanResolver()"})
  void testSpringBeanResolver() {
    // Arrange and Act
    WorkflowResolverFactory actualSpringBeanResolverResult =
        new ResolverConfig().springBeanResolver();
    actualSpringBeanResolverResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, actualSpringBeanResolverResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#messagePartWorkflowResolverFactory()}.
   *
   * <p>Method under test: {@link ResolverConfig#messagePartWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test messagePartWorkflowResolverFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory ResolverConfig.messagePartWorkflowResolverFactory()"
  })
  void testMessagePartWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.LOW_PRIORITY,
        new ResolverConfig().messagePartWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#formDataArgumentWorkflowResolverFactory()}.
   *
   * <p>Method under test: {@link ResolverConfig#formDataArgumentWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test formDataArgumentWorkflowResolverFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory ResolverConfig.formDataArgumentWorkflowResolverFactory()"
  })
  void testFormDataArgumentWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        new ResolverConfig().formDataArgumentWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#chatButtonWorkflowResolverFactory()}.
   *
   * <p>Method under test: {@link ResolverConfig#chatButtonWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test chatButtonWorkflowResolverFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChatButtonWorkflowResolverFactory ResolverConfig.chatButtonWorkflowResolverFactory()"
  })
  void testChatButtonWorkflowResolverFactory() {
    // Arrange and Act
    ChatButtonWorkflowResolverFactory actualChatButtonWorkflowResolverFactoryResult =
        new ResolverConfig().chatButtonWorkflowResolverFactory();
    actualChatButtonWorkflowResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        actualChatButtonWorkflowResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#chatVariableWorkflowResolverFactory()}.
   *
   * <p>Method under test: {@link ResolverConfig#chatVariableWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test chatVariableWorkflowResolverFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChatVariableWorkflowResolverFactory ResolverConfig.chatVariableWorkflowResolverFactory()"
  })
  void testChatVariableWorkflowResolverFactory() {
    // Arrange and Act
    ChatVariableWorkflowResolverFactory actualChatVariableWorkflowResolverFactoryResult =
        new ResolverConfig().chatVariableWorkflowResolverFactory();
    actualChatVariableWorkflowResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        actualChatVariableWorkflowResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#addressableWorkflowResolverFactory()}.
   *
   * <ul>
   *   <li>Given {@link ResolverConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ResolverConfig#addressableWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test addressableWorkflowResolverFactory(); given ResolverConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.AddressableWorkflowResolverFactory ResolverConfig.addressableWorkflowResolverFactory()"
  })
  void testAddressableWorkflowResolverFactory_givenResolverConfig() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.addressableWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#addressableWorkflowResolverFactory()}.
   *
   * <ul>
   *   <li>Given {@link ResolverConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ResolverConfig#addressableWorkflowResolverFactory()}
   */
  @Test
  @DisplayName(
      "Test addressableWorkflowResolverFactory(); given ResolverConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.AddressableWorkflowResolverFactory ResolverConfig.addressableWorkflowResolverFactory()"
  })
  void testAddressableWorkflowResolverFactory_givenResolverConfig2() {
    // Arrange, Act and Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY,
        new ResolverConfig().addressableWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#entityMapResolverFactory()}.
   *
   * <p>Method under test: {@link ResolverConfig#entityMapResolverFactory()}
   */
  @Test
  @DisplayName("Test entityMapResolverFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityMapResolverFactory ResolverConfig.entityMapResolverFactory()"})
  void testEntityMapResolverFactory() {
    // Arrange and Act
    EntityMapResolverFactory actualEntityMapResolverFactoryResult =
        new ResolverConfig().entityMapResolverFactory();
    actualEntityMapResolverFactoryResult.createResolver(mock(ChatHandlerExecutor.class));

    // Assert
    assertEquals(
        WorkflowResolverFactory.NORMAL_PRIORITY, actualEntityMapResolverFactoryResult.getOrder());
  }

  /**
   * Test {@link ResolverConfig#historyResolver(AllHistory)}.
   *
   * <p>Method under test: {@link ResolverConfig#historyResolver(AllHistory)}
   */
  @Test
  @DisplayName("Test historyResolver(AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.MessageHistoryWorkflowResolverFactory ResolverConfig.historyResolver(AllHistory)"
  })
  void testHistoryResolver() throws BeansException {
    // Arrange
    ResolverConfig resolverConfig = new ResolverConfig();

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(mock(ApplicationContext.class));

    // Act and Assert
    assertEquals(
        WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.historyResolver(hist).getOrder());
  }
}
