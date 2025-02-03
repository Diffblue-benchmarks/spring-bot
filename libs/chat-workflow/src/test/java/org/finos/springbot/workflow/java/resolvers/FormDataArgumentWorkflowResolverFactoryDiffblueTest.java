package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FormDataArgumentWorkflowResolverFactory.class})
@ExtendWith(SpringExtension.class)
class FormDataArgumentWorkflowResolverFactoryDiffblueTest {
  @Autowired
  private FormDataArgumentWorkflowResolverFactory formDataArgumentWorkflowResolverFactory;

  /**
   * Test {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <p>
   * Method under test: {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver() {
    // Arrange
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new FormAction(a, u, "Form Data", "Action", new HashMap<>()));

    // Act
    formDataArgumentWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
  }

  /**
   * Test {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <p>
   * Method under test: {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver2() {
    // Arrange
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new FormAction(a, u, null, "Action", new HashMap<>()));

    // Act
    WorkflowResolver actualCreateResolverResult = formDataArgumentWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
    assertTrue(actualCreateResolverResult instanceof NullWorkflowResolver);
  }

  /**
   * Test {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@link Action#NULL_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormDataArgumentWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given NULL_ACTION")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver_givenNull_action() {
    // Arrange
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    when(che.action()).thenReturn(Action.NULL_ACTION);

    // Act
    WorkflowResolver actualCreateResolverResult = formDataArgumentWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
    assertTrue(actualCreateResolverResult instanceof NullWorkflowResolver);
  }

  /**
   * Test new {@link FormDataArgumentWorkflowResolverFactory} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FormDataArgumentWorkflowResolverFactory}
   */
  @Test
  @DisplayName("Test new FormDataArgumentWorkflowResolverFactory (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.resolvers.FormDataArgumentWorkflowResolverFactory.<init>()"})
  void testNewFormDataArgumentWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.NORMAL_PRIORITY, (new FormDataArgumentWorkflowResolverFactory()).getOrder());
  }
}
