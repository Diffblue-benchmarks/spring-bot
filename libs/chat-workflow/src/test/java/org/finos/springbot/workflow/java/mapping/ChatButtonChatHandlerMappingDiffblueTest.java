package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.Test;

class ChatButtonChatHandlerMappingDiffblueTest {
  /**
   * Method under test: {@link ChatButtonChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  void testGetHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).getHandlers(Action.NULL_ACTION)
        .isEmpty());
  }

  /**
   * Method under test: {@link ChatButtonChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  void testGetHandlers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping = new ChatButtonChatHandlerMapping(wrf, null,
        new AllConversations());

    // Act and Assert
    assertTrue(chatButtonChatHandlerMapping.getHandlers(new ErrorAction(null, "Ej")).isEmpty());
  }

  /**
   * Method under test:
   * {@link ChatButtonChatHandlerMapping#getAllHandlers(Addressable, User)}
   */
  @Test
  void testGetAllHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue(
        (new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).getAllHandlers(null, null).isEmpty());
  }

  /**
   * Method under test: {@link ChatButtonChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  void testGetExecutors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).getExecutors(Action.NULL_ACTION)
        .isEmpty());
  }

  /**
   * Method under test: {@link ChatButtonChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  void testGetExecutors2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatButtonChatHandlerMapping chatButtonChatHandlerMapping = new ChatButtonChatHandlerMapping(wrf, null,
        new AllConversations());

    // Act and Assert
    assertTrue(chatButtonChatHandlerMapping.getExecutors(new ErrorAction(null, "Ej")).isEmpty());
  }

  /**
   * Method under test:
   * {@link ChatButtonChatHandlerMapping#ChatButtonChatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  void testNewChatButtonChatHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act
    ChatButtonChatHandlerMapping actualChatButtonChatHandlerMapping = new ChatButtonChatHandlerMapping(wrf, null,
        new AllConversations());

    // Assert
    assertNull(actualChatButtonChatHandlerMapping.getApplicationContext());
    assertTrue(actualChatButtonChatHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualChatButtonChatHandlerMapping.mappingRegistry.getRegistrations().isEmpty());
  }
}
