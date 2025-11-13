package org.finos.springbot.example.todo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   *
   * <ul>
   *   <li>When {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} does nothing.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoWorkflowApp#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test rwec(ResponseHandlers); when ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer ToDoWorkflowApp.rwec(ResponseHandlers)"})
  void testRwec_whenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ToDoWorkflowApp toDoWorkflowApp = new ToDoWorkflowApp();

    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = toDoWorkflowApp.rwec(rh);
    SymphonyRoom a = new SymphonyRoom("Name", "42");
    MemberAction t = new MemberAction(a, new SymphonyUser(1L), Type.ADDED, "42");
    actualRwecResult.accept(t);

    // Assert
    verify(rh).accept(isA(Response.class));
  }
}
