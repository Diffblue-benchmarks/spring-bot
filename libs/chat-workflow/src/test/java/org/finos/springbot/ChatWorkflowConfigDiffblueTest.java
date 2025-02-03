package org.finos.springbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;
import org.springframework.validation.Validator;

@ContextConfiguration(classes = {ChatWorkflowConfig.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ChatWorkflowConfigDiffblueTest {
  @Autowired
  private ChatWorkflowConfig chatWorkflowConfig;

  @MockBean
  private Validator validator;

  /**
   * Test {@link ChatWorkflowConfig#workResponseConverter(ResponseHandlers)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#workResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test workResponseConverter(ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.converters.WorkResponseConverter org.finos.springbot.ChatWorkflowConfig.workResponseConverter(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testWorkResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        (new ChatWorkflowConfig()).workResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#contentResponseConverter(ResponseHandlers)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#contentResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test contentResponseConverter(ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.converters.ContentResponseConverter org.finos.springbot.ChatWorkflowConfig.contentResponseConverter(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testContentResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        (new ChatWorkflowConfig()).contentResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#collectionResponseConverter(ResponseHandlers)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#collectionResponseConverter(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test collectionResponseConverter(ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.converters.CollectionResponseConverter org.finos.springbot.ChatWorkflowConfig.collectionResponseConverter(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testCollectionResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        (new ChatWorkflowConfig()).collectionResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#buttonsResponseHandler()}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#buttonsResponseHandler()}
   */
  @Test
  @DisplayName("Test buttonsResponseHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.handlers.ButtonsResponseHandler org.finos.springbot.ChatWorkflowConfig.buttonsResponseHandler()"})
  void testButtonsResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).buttonsResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatListResponseHandler()}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#chatListResponseHandler()}
   */
  @Test
  @DisplayName("Test chatListResponseHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.handlers.ChatListResponseHandler org.finos.springbot.ChatWorkflowConfig.chatListResponseHandler()"})
  void testChatListResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).chatListResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#userListResponseHandler()}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#userListResponseHandler()}
   */
  @Test
  @DisplayName("Test userListResponseHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.handlers.UserListResponseHandler org.finos.springbot.ChatWorkflowConfig.userListResponseHandler()"})
  void testUserListResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).userListResponseHandler().getOrder());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test chatWorkflowErrorHandler(ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.util.ErrorHandler org.finos.springbot.ChatWorkflowConfig.chatWorkflowErrorHandler(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testChatWorkflowErrorHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    ErrorHandler actualChatWorkflowErrorHandlerResult = chatWorkflowConfig.chatWorkflowErrorHandler(rh);
    actualChatWorkflowErrorHandlerResult.handleError(new Throwable());

    // Assert
    verify(rh).accept(isA(Response.class));
    assertTrue(actualChatWorkflowErrorHandlerResult instanceof ChatWorkflowErrorHandler);
  }

  /**
   * Test {@link ChatWorkflowConfig#buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName("Test buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping org.finos.springbot.ChatWorkflowConfig.buttonHandlerMapping(org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory, org.finos.springbot.workflow.java.converters.ResponseConverters, org.finos.springbot.workflow.conversations.AllConversations)"})
  void testButtonHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act
    ChatButtonChatHandlerMapping actualButtonHandlerMappingResult = chatWorkflowConfig.buttonHandlerMapping(wrf,
        converters, new AllConversations());

    // Assert
    assertNull(actualButtonHandlerMappingResult.getApplicationContext());
    assertTrue(actualButtonHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName("Test chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.java.mapping.ChatRequestChatHandlerMapping org.finos.springbot.ChatWorkflowConfig.chatHandlerMapping(org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory, org.finos.springbot.workflow.java.converters.ResponseConverters, org.finos.springbot.workflow.conversations.AllConversations)"})
  void testChatHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);

    // Act
    ChatRequestChatHandlerMapping actualChatHandlerMappingResult = chatWorkflowConfig.chatHandlerMapping(wrf,
        converters, new AllConversations());

    // Assert
    assertNull(actualChatHandlerMappingResult.getApplicationContext());
    assertTrue(actualChatHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#allConversations()}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#allConversations()}
   */
  @Test
  @DisplayName("Test allConversations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.conversations.AllConversations org.finos.springbot.ChatWorkflowConfig.allConversations()"})
  void testAllConversations() {
    // Arrange and Act
    AllConversations actualAllConversationsResult = chatWorkflowConfig.allConversations();

    // Assert
    assertTrue(actualAllConversationsResult.getAllAddressables().isEmpty());
    assertTrue(actualAllConversationsResult.getAllChats().isEmpty());
  }

  /**
   * Test {@link ChatWorkflowConfig#headerTagResponsehandler()}.
   * <p>
   * Method under test: {@link ChatWorkflowConfig#headerTagResponsehandler()}
   */
  @Test
  @DisplayName("Test headerTagResponsehandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.tags.HeaderTagResponseHandler org.finos.springbot.ChatWorkflowConfig.headerTagResponsehandler()"})
  void testHeaderTagResponsehandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).headerTagResponsehandler().getOrder());
  }
}
