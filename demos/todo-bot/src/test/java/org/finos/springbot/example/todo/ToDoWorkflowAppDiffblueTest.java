package org.finos.springbot.example.todo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ToDoWorkflowAppDiffblueTest {
  /**
   * Test {@link ToDoWorkflowApp#rwec(ResponseHandlers)}.
   * <ul>
   *   <li>When {@link ResponseHandlers} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoWorkflowApp#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test rwec(ResponseHandlers); when ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer org.finos.springbot.example.todo.ToDoWorkflowApp.rwec(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
  void testRwec_whenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ToDoWorkflowApp toDoWorkflowApp = new ToDoWorkflowApp();
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = toDoWorkflowApp.rwec(rh);
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    actualRwecResult.accept(new MemberAction(a, new SymphonyUser(1L), Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
  }
}
