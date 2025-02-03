package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.SimpleMessageAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessagePartWorkflowResolverFactoryDiffblueTest {
  /**
   * Test {@link MessagePartWorkflowResolverFactory#MessagePartWorkflowResolverFactory(List)}.
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#MessagePartWorkflowResolverFactory(List)}
   */
  @Test
  @DisplayName("Test new MessagePartWorkflowResolverFactory(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory.<init>(java.util.List)"})
  void testNewMessagePartWorkflowResolverFactory() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new MessagePartWorkflowResolverFactory(new ArrayList<>())).getOrder());
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#getOrder()}.
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory.getOrder()"})
  void testGetOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY,
        (new MessagePartWorkflowResolverFactory(new ArrayList<>())).getOrder());
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@link Message.MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ChatHandlerExecutor#action()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given MessageImpl(List) with c is ArrayList(); then calls action()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver_givenMessageImplWithCIsArrayList_thenCallsAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MessagePartWorkflowResolverFactory messagePartWorkflowResolverFactory = new MessagePartWorkflowResolverFactory(
        new ArrayList<>());
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Act
    messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@link Action#NULL_ACTION}.</li>
   *   <li>Then return {@link NullWorkflowResolver}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given NULL_ACTION; then return NullWorkflowResolver")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver_givenNull_action_thenReturnNullWorkflowResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    MessagePartWorkflowResolverFactory messagePartWorkflowResolverFactory = new MessagePartWorkflowResolverFactory(
        new ArrayList<>());
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    when(che.action()).thenReturn(Action.NULL_ACTION);

    // Act
    WorkflowResolver actualCreateResolverResult = messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
    assertTrue(actualCreateResolverResult instanceof NullWorkflowResolver);
    assertFalse(actualCreateResolverResult.resolve(null).isPresent());
    assertFalse(actualCreateResolverResult.canResolve(null));
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@code Content}.</li>
   *   <li>Then calls {@link ChatHandlerExecutor#action()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given 'org.finos.springbot.workflow.content.Content'; then calls action()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.resolvers.WorkflowResolver org.finos.springbot.workflow.java.resolvers.MessagePartWorkflowResolverFactory.createResolver(org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testCreateResolver_givenOrgFinosSpringbotWorkflowContentContent_thenCallsAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<Class<? extends Content>> contentClasses = new ArrayList<>();
    Class<Content> forNameResult = Content.class;
    contentClasses.add(forNameResult);
    MessagePartWorkflowResolverFactory messagePartWorkflowResolverFactory = new MessagePartWorkflowResolverFactory(
        contentClasses);
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Act
    messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
  }
}
