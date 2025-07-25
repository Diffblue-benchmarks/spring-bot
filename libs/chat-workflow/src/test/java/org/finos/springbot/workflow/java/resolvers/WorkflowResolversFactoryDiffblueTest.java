package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Optional;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WorkflowResolversFactory.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class WorkflowResolversFactoryDiffblueTest {
  @Autowired private WorkflowResolversFactory workflowResolversFactory;

  /**
   * Test {@link WorkflowResolversFactory#createResolvers(ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Given {@link WorkflowResolversFactory}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WorkflowResolversFactory#createResolvers(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test createResolvers(ChatHandlerExecutor); given WorkflowResolversFactory; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.WorkflowResolvers WorkflowResolversFactory.createResolvers(ChatHandlerExecutor)"
  })
  void testCreateResolvers_givenWorkflowResolversFactory_thenNull() {
    // Arrange, Act and Assert
    assertNull(null);
    assertFalse(
        workflowResolversFactory
            .createResolvers(mock(ChatHandlerExecutor.class))
            .resolve(null)
            .isPresent());
  }

  /**
   * Test {@link WorkflowResolversFactory#createResolvers(ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Then calls {@link WorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * </ul>
   *
   * <p>Method under test: {@link WorkflowResolversFactory#createResolvers(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test createResolvers(ChatHandlerExecutor); then calls createResolver(ChatHandlerExecutor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.resolvers.WorkflowResolvers WorkflowResolversFactory.createResolvers(ChatHandlerExecutor)"
  })
  void testCreateResolvers_thenCallsCreateResolver() throws BeansException {
    // Arrange
    WorkflowResolverFactory workflowResolverFactory = mock(WorkflowResolverFactory.class);
    when(workflowResolverFactory.getOrder()).thenReturn(1);
    when(workflowResolverFactory.createResolver(Mockito.<ChatHandlerExecutor>any()))
        .thenReturn(new NullWorkflowResolver());
    WorkflowResolverFactory workflowResolverFactory2 = mock(WorkflowResolverFactory.class);
    when(workflowResolverFactory2.createResolver(Mockito.<ChatHandlerExecutor>any()))
        .thenReturn(new NullWorkflowResolver());
    when(workflowResolverFactory2.getOrder()).thenReturn(1);
    WorkflowResolverFactory workflowResolverFactory3 = mock(WorkflowResolverFactory.class);
    when(workflowResolverFactory3.createResolver(Mockito.<ChatHandlerExecutor>any()))
        .thenReturn(new NullWorkflowResolver());
    when(workflowResolverFactory3.getOrder()).thenReturn(1);

    HashMap<String, WorkflowResolverFactory> stringWorkflowResolverFactoryMap = new HashMap<>();
    stringWorkflowResolverFactoryMap.put("", workflowResolverFactory3);
    stringWorkflowResolverFactoryMap.put("42", workflowResolverFactory2);
    stringWorkflowResolverFactoryMap.put("foo", workflowResolverFactory);
    AbstractApplicationContext applicationContext = mock(AbstractApplicationContext.class);
    when(applicationContext.getBeansOfType(Mockito.<Class<WorkflowResolverFactory>>any()))
        .thenReturn(stringWorkflowResolverFactoryMap);
    doNothing()
        .when(applicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    applicationContext.addBeanFactoryPostProcessor(new CustomAutowireConfigurer());

    WorkflowResolversFactory workflowResolversFactory = new WorkflowResolversFactory();
    workflowResolversFactory.setApplicationContext(applicationContext);

    // Act
    Optional<Object> actualResolveResult =
        workflowResolversFactory.createResolvers(mock(ChatHandlerExecutor.class)).resolve(null);

    // Assert
    verify(workflowResolverFactory3).createResolver(isA(ChatHandlerExecutor.class));
    verify(workflowResolverFactory2).createResolver(isA(ChatHandlerExecutor.class));
    verify(workflowResolverFactory).createResolver(isA(ChatHandlerExecutor.class));
    verify(workflowResolverFactory3).getOrder();
    verify(workflowResolverFactory2).getOrder();
    verify(workflowResolverFactory, atLeast(1)).getOrder();
    verify(applicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    verify(applicationContext).getBeansOfType(isA(Class.class));
    assertFalse(actualResolveResult.isPresent());
  }
}
