package org.finos.springbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping;
import org.finos.springbot.workflow.java.mapping.ChatRequestChatHandlerMapping;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;
import org.springframework.validation.Validator;

@ContextConfiguration(classes = {ChatWorkflowConfig.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatWorkflowConfigDiffblueTest {
  @Autowired private ChatWorkflowConfig chatWorkflowConfig;

  @MockitoBean private Validator validator;

  /**
   * Test {@link ChatWorkflowConfig#workResponseConverter(ResponseHandlers)}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#workResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test workResponseConverter(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.converters.WorkResponseConverter ChatWorkflowConfig.workResponseConverter(ResponseHandlers)"
  })
  void testWorkResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        new ChatWorkflowConfig().workResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#contentResponseConverter(ResponseHandlers)}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#contentResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test contentResponseConverter(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.converters.ContentResponseConverter ChatWorkflowConfig.contentResponseConverter(ResponseHandlers)"
  })
  void testContentResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        new ChatWorkflowConfig().contentResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#collectionResponseConverter(ResponseHandlers)}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#collectionResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test collectionResponseConverter(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.converters.CollectionResponseConverter ChatWorkflowConfig.collectionResponseConverter(ResponseHandlers)"
  })
  void testCollectionResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        new ChatWorkflowConfig()
            .collectionResponseConverter(mock(ResponseHandlers.class))
            .getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#buttonsResponseHandler()}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#buttonsResponseHandler()}
   */
  @Test
  @DisplayName("Test buttonsResponseHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.response.handlers.ButtonsResponseHandler ChatWorkflowConfig.buttonsResponseHandler()"
  })
  void testButtonsResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, new ChatWorkflowConfig().buttonsResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatListResponseHandler()}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#chatListResponseHandler()}
   */
  @Test
  @DisplayName("Test chatListResponseHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.response.handlers.ChatListResponseHandler ChatWorkflowConfig.chatListResponseHandler()"
  })
  void testChatListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, new ChatWorkflowConfig().chatListResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#userListResponseHandler()}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#userListResponseHandler()}
   */
  @Test
  @DisplayName("Test userListResponseHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.response.handlers.UserListResponseHandler ChatWorkflowConfig.userListResponseHandler()"
  })
  void testUserListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, new ChatWorkflowConfig().userListResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}.
   *
   * <ul>
   *   <li>Then {@link Throwable#Throwable()} LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test chatWorkflowErrorHandler(ResponseHandlers); then Throwable() LocalizedMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorHandler ChatWorkflowConfig.chatWorkflowErrorHandler(ResponseHandlers)"})
  void testChatWorkflowErrorHandler_thenThrowableLocalizedMessageIsNull() {
    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    ErrorHandler actualChatWorkflowErrorHandlerResult =
        chatWorkflowConfig.chatWorkflowErrorHandler(rh);
    Throwable t = new Throwable();
    actualChatWorkflowErrorHandlerResult.handleError(t);

    // Assert
    verify(rh).accept(isA(Response.class));
    assertTrue(actualChatWorkflowErrorHandlerResult instanceof ChatWorkflowErrorHandler);
    assertNull(t.getLocalizedMessage());
    assertNull(t.getMessage());
    assertNull(t.getCause());
    assertEquals(0, t.getSuppressed().length);
  }

  /**
   * Test {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}.
   *
   * <ul>
   *   <li>When {@link ResponseHandlers}.
   * </ul>
   *
   * <p>Method under test: {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test chatWorkflowErrorHandler(ResponseHandlers); when ResponseHandlers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ErrorHandler ChatWorkflowConfig.chatWorkflowErrorHandler(ResponseHandlers)"})
  void testChatWorkflowErrorHandler_whenResponseHandlers() {
    // Arrange, Act and Assert
    assertTrue(
        new ChatWorkflowConfig().chatWorkflowErrorHandler(mock(ResponseHandlers.class))
            instanceof ChatWorkflowErrorHandler);
  }

  /**
   * Test {@link ChatWorkflowConfig#buttonHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#buttonHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName(
      "Test buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChatButtonChatHandlerMapping ChatWorkflowConfig.buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)"
  })
  void testButtonHandlerMapping() throws IllegalStateException {
    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act
    ChatButtonChatHandlerMapping actualButtonHandlerMappingResult =
        chatWorkflowConfig.buttonHandlerMapping(wrf, converters, new AllConversations());

    // Assert
    assertNull(actualButtonHandlerMappingResult.getApplicationContext());
    assertTrue(actualButtonHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatHandlerMapping(WorkflowResolversFactory, ResponseConverters,
   * AllConversations)}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#chatHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName(
      "Test chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChatRequestChatHandlerMapping ChatWorkflowConfig.chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)"
  })
  void testChatHandlerMapping() throws IllegalStateException {
    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act
    ChatRequestChatHandlerMapping actualChatHandlerMappingResult =
        chatWorkflowConfig.chatHandlerMapping(wrf, converters, new AllConversations());

    // Assert
    assertNull(actualChatHandlerMappingResult.getApplicationContext());
    assertTrue(actualChatHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#allConversations()}.
   *
   * <ul>
   *   <li>Then return AllAddressables Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatWorkflowConfig#allConversations()}
   */
  @Test
  @DisplayName("Test allConversations(); then return AllAddressables Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllConversations ChatWorkflowConfig.allConversations()"})
  void testAllConversations_thenReturnAllAddressablesEmpty() {
    // Arrange and Act
    AllConversations actualAllConversationsResult = chatWorkflowConfig.allConversations();

    // Assert
    assertTrue(actualAllConversationsResult.getAllAddressables().isEmpty());
    assertTrue(actualAllConversationsResult.getAllChats().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#headerTagResponsehandler()}.
   *
   * <p>Method under test: {@link ChatWorkflowConfig#headerTagResponsehandler()}
   */
  @Test
  @DisplayName("Test headerTagResponsehandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.tags.HeaderTagResponseHandler ChatWorkflowConfig.headerTagResponsehandler()"
  })
  void testHeaderTagResponsehandler() {
    // Arrange, Act and Assert
    assertEquals(100, new ChatWorkflowConfig().headerTagResponsehandler().getOrder());
  }
}
