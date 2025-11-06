package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.history.AllHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ResolverConfig.class})
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class ResolverConfigDiffblueTest {
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
  @MethodsUnderTest({"WorkflowResolverFactory ResolverConfig.springBeanResolver()"})
  void testSpringBeanResolver() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.springBeanResolver().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory ResolverConfig.messagePartWorkflowResolverFactory()"})
  void testMessagePartWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.messagePartWorkflowResolverFactory().getOrder());
  }

  /**
   * Test {@link ResolverConfig#formDataArgumentWorkflowResolverFactory()}.
   * <p>
   * Method under test: {@link ResolverConfig#formDataArgumentWorkflowResolverFactory()}
   */
  @Test
  @DisplayName("Test formDataArgumentWorkflowResolverFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory ResolverConfig.formDataArgumentWorkflowResolverFactory()"})
  void testFormDataArgumentWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.formDataArgumentWorkflowResolverFactory().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.ChatButtonWorkflowResolverFactory ResolverConfig.chatButtonWorkflowResolverFactory()"})
  void testChatButtonWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.chatButtonWorkflowResolverFactory().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.ChatVariableWorkflowResolverFactory ResolverConfig.chatVariableWorkflowResolverFactory()"})
  void testChatVariableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.chatVariableWorkflowResolverFactory().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.AddressableWorkflowResolverFactory ResolverConfig.addressableWorkflowResolverFactory()"})
  void testAddressableWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY,
        resolverConfig.addressableWorkflowResolverFactory().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.AddressableWorkflowResolverFactory ResolverConfig.addressableWorkflowResolverFactory()"})
  void testAddressableWorkflowResolverFactory2() {
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
      "org.finos.springbot.workflow.java.resolvers.EntityMapResolverFactory ResolverConfig.entityMapResolverFactory()"})
  void testEntityMapResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, resolverConfig.entityMapResolverFactory().getOrder());
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
      "org.finos.springbot.workflow.java.resolvers.MessageHistoryWorkflowResolverFactory ResolverConfig.historyResolver(AllHistory)"})
  void testHistoryResolver() throws BeansException {
    // Arrange
    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, resolverConfig.historyResolver(hist).getOrder());
  }
}
