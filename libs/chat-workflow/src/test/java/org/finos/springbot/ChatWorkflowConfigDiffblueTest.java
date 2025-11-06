package org.finos.springbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping;
import org.finos.springbot.workflow.java.mapping.ChatRequestChatHandlerMapping;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.util.ErrorHandler;

class ChatWorkflowConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ChatWorkflowConfig#workResponseConverter(ResponseHandlers)}
   */
  @Test
  void testWorkResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new ChatWorkflowConfig()).workResponseConverter(null).getOrder());
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#contentResponseConverter(ResponseHandlers)}
   */
  @Test
  void testContentResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new ChatWorkflowConfig()).contentResponseConverter(null).getOrder());
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#collectionResponseConverter(ResponseHandlers)}
   */
  @Test
  void testCollectionResponseConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new ChatWorkflowConfig()).collectionResponseConverter(null).getOrder());
  }

  /**
   * Method under test: {@link ChatWorkflowConfig#buttonsResponseHandler()}
   */
  @Test
  void testButtonsResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).buttonsResponseHandler().getOrder());
  }

  /**
   * Method under test: {@link ChatWorkflowConfig#chatListResponseHandler()}
   */
  @Test
  void testChatListResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).chatListResponseHandler().getOrder());
  }

  /**
   * Method under test: {@link ChatWorkflowConfig#userListResponseHandler()}
   */
  @Test
  void testUserListResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).userListResponseHandler().getOrder());
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}
   */
  @Test
  void testChatWorkflowErrorHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ErrorHandler actualChatWorkflowErrorHandlerResult = (new ChatWorkflowConfig()).chatWorkflowErrorHandler(null);
    actualChatWorkflowErrorHandlerResult.handleError(new Throwable());

    // Assert
    assertTrue(actualChatWorkflowErrorHandlerResult instanceof ChatWorkflowErrorHandler);
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#chatWorkflowErrorHandler(ResponseHandlers)}
   */
  @Test
  void testChatWorkflowErrorHandler2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ErrorHandler actualChatWorkflowErrorHandlerResult = (new ChatWorkflowConfig()).chatWorkflowErrorHandler(null);
    actualChatWorkflowErrorHandlerResult.handleError(new Throwable("Error thrown:"));

    // Assert
    assertTrue(actualChatWorkflowErrorHandlerResult instanceof ChatWorkflowErrorHandler);
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#buttonHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  void testButtonHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act
    ChatButtonChatHandlerMapping actualButtonHandlerMappingResult = chatWorkflowConfig.buttonHandlerMapping(wrf, null,
        new AllConversations());

    // Assert
    assertNull(actualButtonHandlerMappingResult.getApplicationContext());
    assertTrue(actualButtonHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Method under test:
   * {@link ChatWorkflowConfig#chatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  void testChatHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ChatWorkflowConfig chatWorkflowConfig = new ChatWorkflowConfig();
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act
    ChatRequestChatHandlerMapping actualChatHandlerMappingResult = chatWorkflowConfig.chatHandlerMapping(wrf, null,
        new AllConversations());

    // Assert
    assertNull(actualChatHandlerMappingResult.getApplicationContext());
    assertTrue(actualChatHandlerMappingResult.getHandlerMethods().isEmpty());
  }

  /**
   * Method under test: {@link ChatWorkflowConfig#headerTagResponsehandler()}
   */
  @Test
  void testHeaderTagResponsehandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(100, (new ChatWorkflowConfig()).headerTagResponsehandler().getOrder());
  }
}
