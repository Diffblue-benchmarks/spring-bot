package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatButtonChatHandlerMapping.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatButtonChatHandlerMappingDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @Autowired private ChatButtonChatHandlerMapping chatButtonChatHandlerMapping;

  @MockitoBean private ResponseConverters responseConverters;

  @MockitoBean private WorkflowResolversFactory workflowResolversFactory;

  /**
   * Test {@link ChatButtonChatHandlerMapping#ChatButtonChatHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}.
   *
   * <p>Method under test: {@link
   * ChatButtonChatHandlerMapping#ChatButtonChatHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName(
      "Test new ChatButtonChatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChatButtonChatHandlerMapping.<init>(WorkflowResolversFactory, ResponseConverters, AllConversations)"
  })
  void testNewChatButtonChatHandlerMapping() throws IllegalStateException {
    // Arrange and Act
    ChatButtonChatHandlerMapping actualChatButtonChatHandlerMapping =
        new ChatButtonChatHandlerMapping(
            workflowResolversFactory, mock(ResponseConverters.class), allConversations);

    // Assert
    assertNull(actualChatButtonChatHandlerMapping.getApplicationContext());
    assertTrue(actualChatButtonChatHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualChatButtonChatHandlerMapping.mappingRegistry.getRegistrations().isEmpty());
  }

  /**
   * Test {@link ChatButtonChatHandlerMapping#getHandlers(Action)}.
   *
   * <ul>
   *   <li>When {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable}
   *       and {@code Ej}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatButtonChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  @DisplayName(
      "Test getHandlers(Action); when ErrorAction(Addressable, Object) with a is Addressable and 'Ej'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ChatButtonChatHandlerMapping.getHandlers(Action)"})
  void testGetHandlers_whenErrorActionWithAIsAddressableAndEj_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        chatButtonChatHandlerMapping
            .getHandlers(new ErrorAction(mock(Addressable.class), "Ej"))
            .isEmpty());
  }

  /**
   * Test {@link ChatButtonChatHandlerMapping#getHandlers(Action)}.
   *
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatButtonChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  @DisplayName("Test getHandlers(Action); when NULL_ACTION; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ChatButtonChatHandlerMapping.getHandlers(Action)"})
  void testGetHandlers_whenNull_action_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(chatButtonChatHandlerMapping.getHandlers(Action.NULL_ACTION).isEmpty());
  }

  /**
   * Test {@link ChatButtonChatHandlerMapping#getAllHandlers(Addressable, User)}.
   *
   * <p>Method under test: {@link ChatButtonChatHandlerMapping#getAllHandlers(Addressable, User)}
   */
  @Test
  @DisplayName("Test getAllHandlers(Addressable, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ChatButtonChatHandlerMapping.getAllHandlers(Addressable, User)"
  })
  void testGetAllHandlers() {
    // Arrange, Act and Assert
    assertTrue(
        chatButtonChatHandlerMapping
            .getAllHandlers(mock(Addressable.class), mock(User.class))
            .isEmpty());
  }

  /**
   * Test {@link ChatButtonChatHandlerMapping#getExecutors(Action)}.
   *
   * <ul>
   *   <li>When {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable}
   *       and {@code Ej}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatButtonChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  @DisplayName(
      "Test getExecutors(Action); when ErrorAction(Addressable, Object) with a is Addressable and 'Ej'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ChatButtonChatHandlerMapping.getExecutors(Action)"})
  void testGetExecutors_whenErrorActionWithAIsAddressableAndEj_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        chatButtonChatHandlerMapping
            .getExecutors(new ErrorAction(mock(Addressable.class), "Ej"))
            .isEmpty());
  }

  /**
   * Test {@link ChatButtonChatHandlerMapping#getExecutors(Action)}.
   *
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatButtonChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  @DisplayName("Test getExecutors(Action); when NULL_ACTION; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ChatButtonChatHandlerMapping.getExecutors(Action)"})
  void testGetExecutors_whenNull_action_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(chatButtonChatHandlerMapping.getExecutors(Action.NULL_ACTION).isEmpty());
  }
}
