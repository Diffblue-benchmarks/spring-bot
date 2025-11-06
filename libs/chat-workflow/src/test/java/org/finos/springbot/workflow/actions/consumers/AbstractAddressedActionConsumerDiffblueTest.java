package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMapping;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer;
import org.junit.jupiter.api.Test;

class AbstractAddressedActionConsumerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractAddressedActionConsumer#performFilters(Action)}
   */
  @Test
  void testPerformFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ChatHandlerMapping<?>> handlerMapping = new ArrayList<>();
    ChatWorkflowErrorHandler eh = new ChatWorkflowErrorHandler(null, "Template Name");

    // Act and Assert
    assertNull((new ChatHandlerMappingActionConsumer(handlerMapping, eh, new ArrayList<>()))
        .performFilters(Action.NULL_ACTION));
  }

  /**
   * Method under test:
   * {@link AbstractAddressedActionConsumer#performFilters(Action)}
   */
  @Test
  void testPerformFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<AddressingChecker> ac = new ArrayList<>();
    ac.add(new InRoomAddressingChecker(null, true));
    ArrayList<ChatHandlerMapping<?>> handlerMapping = new ArrayList<>();
    Action in = Action.NULL_ACTION;

    // Act and Assert
    assertSame(in,
        (new ChatHandlerMappingActionConsumer(handlerMapping, new ChatWorkflowErrorHandler(null, "Template Name"), ac))
            .performFilters(in));
  }

  /**
   * Method under test:
   * {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}
   */
  @Test
  void testAddressCheckingFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<ChatHandlerMapping<?>> handlerMapping = new ArrayList<>();
    ChatWorkflowErrorHandler eh = new ChatWorkflowErrorHandler(null, "Template Name");

    // Act and Assert
    assertNull((new ChatHandlerMappingActionConsumer(handlerMapping, eh, new ArrayList<>()))
        .addressCheckingFilters(Action.NULL_ACTION));
  }

  /**
   * Method under test:
   * {@link AbstractAddressedActionConsumer#addressCheckingFilters(Action)}
   */
  @Test
  void testAddressCheckingFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<AddressingChecker> ac = new ArrayList<>();
    ac.add(new InRoomAddressingChecker(null, true));
    ArrayList<ChatHandlerMapping<?>> handlerMapping = new ArrayList<>();
    Action in = Action.NULL_ACTION;

    // Act and Assert
    assertSame(in,
        (new ChatHandlerMappingActionConsumer(handlerMapping, new ChatWorkflowErrorHandler(null, "Template Name"), ac))
            .addressCheckingFilters(in));
  }
}
