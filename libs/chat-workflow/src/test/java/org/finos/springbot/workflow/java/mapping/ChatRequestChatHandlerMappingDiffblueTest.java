package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.Test;

class ChatRequestChatHandlerMappingDiffblueTest {
  /**
   * Method under test: {@link ChatRequestChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  void testGetHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatRequestChatHandlerMapping(wrf, null, new AllConversations())).getHandlers(Action.NULL_ACTION)
        .isEmpty());
  }

  /**
   * Method under test: {@link ChatRequestChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  void testGetHandlers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatRequestChatHandlerMapping chatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());

    // Act and Assert
    assertTrue(chatRequestChatHandlerMapping.getHandlers(new ErrorAction(null, "Ej")).isEmpty());
  }

  /**
   * Method under test:
   * {@link ChatRequestChatHandlerMapping#getAllHandlers(Addressable, User)}
   */
  @Test
  void testGetAllHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue(
        (new ChatRequestChatHandlerMapping(wrf, null, new AllConversations())).getAllHandlers(null, null).isEmpty());
  }

  /**
   * Method under test: {@link ChatRequestChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  void testGetExecutors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatRequestChatHandlerMapping(wrf, null, new AllConversations())).getExecutors(Action.NULL_ACTION)
        .isEmpty());
  }

  /**
   * Method under test: {@link ChatRequestChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  void testGetExecutors2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatRequestChatHandlerMapping chatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());

    // Act and Assert
    assertTrue(chatRequestChatHandlerMapping.getExecutors(new ErrorAction(null, "Ej")).isEmpty());
  }

  /**
   * Method under test:
   * {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  void testGetContentClassFromType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatRequestChatHandlerMapping chatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.getContentClassFromType(new TypePlaceHolder(1)));
  }

  /**
   * Method under test:
   * {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  void testGetContentClassFromType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatRequestChatHandlerMapping chatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());
    Class<Object> t = Object.class;

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> chatRequestChatHandlerMapping.getContentClassFromType(t));
  }

  /**
   * Method under test:
   * {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  void testGetContentClassFromType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ChatRequestChatHandlerMapping chatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());
    Class<Content> t = Content.class;

    // Act
    Class<? extends Content> actualContentClassFromType = chatRequestChatHandlerMapping.getContentClassFromType(t);

    // Assert
    Class<Content> expectedContentClassFromType = Content.class;
    assertEquals(expectedContentClassFromType, actualContentClassFromType);
    assertSame(t, actualContentClassFromType);
  }

  /**
   * Method under test:
   * {@link ChatRequestChatHandlerMapping#ChatRequestChatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)}
   */
  @Test
  void testNewChatRequestChatHandlerMapping() throws IllegalStateException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act
    ChatRequestChatHandlerMapping actualChatRequestChatHandlerMapping = new ChatRequestChatHandlerMapping(wrf, null,
        new AllConversations());

    // Assert
    assertNull(actualChatRequestChatHandlerMapping.getApplicationContext());
    assertTrue(actualChatRequestChatHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualChatRequestChatHandlerMapping.mappingRegistry.getRegistrations().isEmpty());
  }
}
