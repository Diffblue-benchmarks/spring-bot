package org.finos.springbot.example.todo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ToDoWorkflowAppDiffblueTest {
  /**
   * Method under test: {@link ToDoWorkflowApp#rwec(ResponseHandlers)}
   */
  @Test
  void testRwec() {
    // Arrange
    ToDoWorkflowApp toDoWorkflowApp = new ToDoWorkflowApp();
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = toDoWorkflowApp.rwec(rh);
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    actualRwecResult.accept(new MemberAction(a, new SymphonyUser(1L), MemberAction.Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
  }
}
