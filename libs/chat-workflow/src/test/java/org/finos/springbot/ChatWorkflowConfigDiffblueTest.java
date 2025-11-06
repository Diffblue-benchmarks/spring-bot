package org.finos.springbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Validator;

@ContextConfiguration(classes = {ChatWorkflowConfig.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
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
      "org.finos.springbot.workflow.java.converters.WorkResponseConverter ChatWorkflowConfig.workResponseConverter(ResponseHandlers)"})
  void testWorkResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, chatWorkflowConfig.workResponseConverter(mock(ResponseHandlers.class)).getOrder());
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
      "org.finos.springbot.workflow.java.converters.ContentResponseConverter ChatWorkflowConfig.contentResponseConverter(ResponseHandlers)"})
  void testContentResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        chatWorkflowConfig.contentResponseConverter(mock(ResponseHandlers.class)).getOrder());
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
      "org.finos.springbot.workflow.java.converters.CollectionResponseConverter ChatWorkflowConfig.collectionResponseConverter(ResponseHandlers)"})
  void testCollectionResponseConverter() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE,
        chatWorkflowConfig.collectionResponseConverter(mock(ResponseHandlers.class)).getOrder());
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
      "org.finos.springbot.workflow.response.handlers.ButtonsResponseHandler ChatWorkflowConfig.buttonsResponseHandler()"})
  void testButtonsResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, chatWorkflowConfig.buttonsResponseHandler().getOrder());
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
      "org.finos.springbot.workflow.response.handlers.ChatListResponseHandler ChatWorkflowConfig.chatListResponseHandler()"})
  void testChatListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, chatWorkflowConfig.chatListResponseHandler().getOrder());
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
      "org.finos.springbot.workflow.response.handlers.UserListResponseHandler ChatWorkflowConfig.userListResponseHandler()"})
  void testUserListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(100, chatWorkflowConfig.userListResponseHandler().getOrder());
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
      "org.springframework.util.ErrorHandler ChatWorkflowConfig.chatWorkflowErrorHandler(ResponseHandlers)"})
  void testChatWorkflowErrorHandler() {
    // Arrange, Act and Assert
    assertTrue(
        chatWorkflowConfig.chatWorkflowErrorHandler(mock(ResponseHandlers.class)) instanceof ChatWorkflowErrorHandler);
  }

  /**
   * Test {@link ChatWorkflowConfig#allConversations()}.
   * <ul>
   *   <li>Then return AllAddressables Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChatWorkflowConfig#allConversations()}
   */
  @Test
  @DisplayName("Test allConversations(); then return AllAddressables Empty")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link ChatWorkflowConfig#headerTagResponsehandler()}
   */
  @Test
  @DisplayName("Test headerTagResponsehandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.tags.HeaderTagResponseHandler ChatWorkflowConfig.headerTagResponsehandler()"})
  void testHeaderTagResponsehandler() {
    // Arrange, Act and Assert
    assertEquals(100, chatWorkflowConfig.headerTagResponsehandler().getOrder());
  }
}
