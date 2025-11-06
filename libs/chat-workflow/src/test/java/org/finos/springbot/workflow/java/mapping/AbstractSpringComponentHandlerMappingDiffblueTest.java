package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.Test;

class AbstractSpringComponentHandlerMappingDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractSpringComponentHandlerMapping#getHandlerMethods()}
   */
  @Test
  void testGetHandlerMethods() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).getHandlerMethods().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AbstractSpringComponentHandlerMapping.MappingRegistry#MappingRegistry(AbstractSpringComponentHandlerMapping)}
   *   <li>
   * {@link AbstractSpringComponentHandlerMapping.MappingRegistry#getRegistrations()}
   * </ul>
   */
  @Test
  void testMappingRegistryGettersAndSetters() {
    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue(
        ((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).new MappingRegistry()).getRegistrations()
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractSpringComponentHandlerMapping#roomMatched(String[], Chat)}
   */
  @Test
  void testRoomMatched() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertFalse(
        (new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).roomMatched(new String[]{}, null));
  }

  /**
   * Method under test:
   * {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  void testCanBePerformed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertFalse((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).canBePerformed(null, null,
        new String[]{"Exclude Rooms"}, new String[]{"Include Rooms"}, true));
  }

  /**
   * Method under test:
   * {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  void testCanBePerformed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).canBePerformed(null, null,
        new String[]{"Exclude Rooms"}, new String[]{}, true));
  }

  /**
   * Method under test:
   * {@link AbstractSpringComponentHandlerMapping#canBePerformed(Addressable, User, String[], String[], boolean)}
   */
  @Test
  void testCanBePerformed3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();

    // Act and Assert
    assertTrue((new ChatButtonChatHandlerMapping(wrf, null, new AllConversations())).canBePerformed(null, null,
        new String[]{"Exclude Rooms"}, new String[]{}, false));
  }
}
