package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.actions.consumers.ChatWorkflowErrorHandler;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(
    classes = {
      WorkflowConfig.class,
      ReminderProperties.class,
      ChatWorkflowErrorHandler.class,
      String.class,
      AllConversations.class,
      AllHistory.class
    })
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class WorkflowConfigDiffblueTest {
  @Autowired private ReminderProperties reminderProperties;

  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private WorkflowConfig workflowConfig;

  /**
   * Test {@link WorkflowConfig#rwec(ResponseHandlers)}.
   *
   * <p>Method under test: {@link WorkflowConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test rwec(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer WorkflowConfig.rwec(ResponseHandlers)"})
  void testRwec() {
    // Arrange and Act
    workflowConfig.rwec(mock(ResponseHandlers.class));

    // Assert that nothing has changed
    assertTrue(workflowConfig instanceof WorkflowConfig);
  }

  /**
   * Test {@link WorkflowConfig#rwec(ResponseHandlers)}.
   *
   * <p>Method under test: {@link WorkflowConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test rwec(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer WorkflowConfig.rwec(ResponseHandlers)"})
  void testRwec2() {
    // Arrange and Act
    RoomWelcomeEventConsumer actualRwecResult = workflowConfig.rwec(mock(ResponseHandlers.class));
    SymphonyRoom a = new SymphonyRoom();
    SymphonyUser u = new SymphonyUser();
    MemberAction t = new MemberAction(a, u, Type.ADDED, "42");
    actualRwecResult.accept(t);

    // Assert that nothing has changed
    Chat addressable = t.getAddressable();
    assertTrue(addressable instanceof SymphonyRoom);
    User user = t.getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(workflowConfig instanceof WorkflowConfig);
    assertEquals("42", t.getData());
    assertEquals(Type.ADDED, t.getType());
    assertSame(a, addressable);
    assertSame(u, user);
  }

  /**
   * Test {@link WorkflowConfig#rwec(ResponseHandlers)}.
   *
   * <ul>
   *   <li>Then {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable}
   *       and {@code Ej} Data is {@code Ej}.
   * </ul>
   *
   * <p>Method under test: {@link WorkflowConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test rwec(ResponseHandlers); then ErrorAction(Addressable, Object) with a is Addressable and 'Ej' Data is 'Ej'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer WorkflowConfig.rwec(ResponseHandlers)"})
  void testRwec_thenErrorActionWithAIsAddressableAndEjDataIsEj() {
    // Arrange and Act
    RoomWelcomeEventConsumer actualRwecResult = workflowConfig.rwec(mock(ResponseHandlers.class));
    ErrorAction t = new ErrorAction(mock(Addressable.class), "Ej");
    actualRwecResult.accept(t);

    // Assert that nothing has changed
    assertTrue(workflowConfig instanceof WorkflowConfig);
    assertEquals("Ej", t.getData());
  }

  /**
   * Test {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory,
   * ResponseHandlers)}.
   *
   * <p>Method under test: {@link WorkflowConfig#timeFinder(ChatWorkflowErrorHandler,
   * AllConversations, AllHistory, ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TimeFinder WorkflowConfig.timeFinder(ChatWorkflowErrorHandler, AllConversations, AllHistory, ResponseHandlers)"
  })
  void testTimeFinder() throws BeansException {
    // Arrange
    WorkflowConfig workflowConfig = new WorkflowConfig();
    ChatWorkflowErrorHandler eh =
        new ChatWorkflowErrorHandler(mock(ResponseHandlers.class), "Template Name");
    AllConversations sc = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    // Act
    TimeFinder actualTimeFinderResult =
        workflowConfig.timeFinder(eh, sc, h, mock(ResponseHandlers.class));

    // Assert
    assertNull(actualTimeFinderResult.stanfordCoreNLP);
    assertNull(actualTimeFinderResult.reminderProperties);
  }
}
