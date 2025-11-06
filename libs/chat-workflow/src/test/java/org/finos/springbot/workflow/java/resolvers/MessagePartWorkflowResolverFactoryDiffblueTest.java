package org.finos.springbot.workflow.java.resolvers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessagePartWorkflowResolverFactoryDiffblueTest {
  @InjectMocks
  private MessagePartWorkflowResolverFactory messagePartWorkflowResolverFactory;

  @Mock
  private List<Class<? extends Content>> list;

  /**
   * Test {@link MessagePartWorkflowResolverFactory#MessagePartWorkflowResolverFactory(List)}.
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#MessagePartWorkflowResolverFactory(List)}
   */
  @Test
  @DisplayName("Test new MessagePartWorkflowResolverFactory(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MessagePartWorkflowResolverFactory.<init>(List)"})
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
  @MethodsUnderTest({"int MessagePartWorkflowResolverFactory.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(WorkflowResolverFactory.LOW_PRIORITY, messagePartWorkflowResolverFactory.getOrder());
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@link List} {@link List#iterator()} return {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given List iterator() return ArrayList() iterator; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WorkflowResolver MessagePartWorkflowResolverFactory.createResolver(ChatHandlerExecutor)"})
  void testCreateResolver_givenListIteratorReturnArrayListIterator_thenCallsIterator() {
    // Arrange
    ArrayList<Class<? extends Content>> resultClassList = new ArrayList<>();
    org.mockito.Mockito.<Iterator<Class<? extends Content>>>when(list.iterator())
        .thenReturn(resultClassList.iterator());
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Act
    messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(list).iterator();
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
  @MethodsUnderTest({"WorkflowResolver MessagePartWorkflowResolverFactory.createResolver(ChatHandlerExecutor)"})
  void testCreateResolver_givenNull_action_thenReturnNullWorkflowResolver() {
    // Arrange
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    when(che.action()).thenReturn(Action.NULL_ACTION);

    // Act
    WorkflowResolver actualCreateResolverResult = messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(che).action();
    assertTrue(actualCreateResolverResult instanceof NullWorkflowResolver);
  }

  /**
   * Test {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}.
   * <ul>
   *   <li>Given {@code Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessagePartWorkflowResolverFactory#createResolver(ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test createResolver(ChatHandlerExecutor); given 'org.finos.springbot.workflow.content.Content'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WorkflowResolver MessagePartWorkflowResolverFactory.createResolver(ChatHandlerExecutor)"})
  void testCreateResolver_givenOrgFinosSpringbotWorkflowContentContent() {
    // Arrange
    ArrayList<Class<? extends Content>> resultClassList = new ArrayList<>();
    Class<Content> forNameResult = Content.class;
    resultClassList.add(forNameResult);
    org.mockito.Mockito.<Iterator<Class<? extends Content>>>when(list.iterator())
        .thenReturn(resultClassList.iterator());
    ChatHandlerExecutor che = mock(ChatHandlerExecutor.class);
    Addressable a = mock(Addressable.class);
    User u = mock(User.class);
    when(che.action()).thenReturn(new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej"));

    // Act
    messagePartWorkflowResolverFactory.createResolver(che);

    // Assert
    verify(list).iterator();
    verify(che).action();
  }
}
