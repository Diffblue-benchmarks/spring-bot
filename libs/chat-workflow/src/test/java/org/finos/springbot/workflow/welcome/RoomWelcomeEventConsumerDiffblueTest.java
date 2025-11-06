package org.finos.springbot.workflow.welcome;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoomWelcomeEventConsumerDiffblueTest {
  /**
   * Test {@link RoomWelcomeEventConsumer#RoomWelcomeEventConsumer(ResponseHandlers)}.
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoomWelcomeEventConsumer#RoomWelcomeEventConsumer(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test new RoomWelcomeEventConsumer(ResponseHandlers); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RoomWelcomeEventConsumer.<init>(ResponseHandlers)"})
  void testNewRoomWelcomeEventConsumer_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRoomWelcomeEventConsumer = new RoomWelcomeEventConsumer(rh);
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Name");
    User u = mock(User.class);
    when(u.getName()).thenReturn("Name");
    actualRoomWelcomeEventConsumer.accept(new MemberAction(a, u, Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
    verify(a).getName();
    verify(u).getName();
  }

  /**
   * Test {@link RoomWelcomeEventConsumer#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoomWelcomeEventConsumer#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RoomWelcomeEventConsumer.accept(Action)"})
  void testAcceptWithAction_thenCallsApply() {
    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());
    Function<MemberAction, Message> welcomeMessageBuilder = mock(Function.class);
    when(welcomeMessageBuilder.apply(Mockito.<MemberAction>any())).thenReturn(new MessageImpl(new ArrayList<>()));
    RoomWelcomeEventConsumer roomWelcomeEventConsumer = new RoomWelcomeEventConsumer(rh, welcomeMessageBuilder);

    // Act
    roomWelcomeEventConsumer.accept(new MemberAction(mock(Chat.class), mock(User.class), Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
    verify(welcomeMessageBuilder).apply(isA(MemberAction.class));
  }

  /**
   * Test {@link RoomWelcomeEventConsumer#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Then calls {@link Chat#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoomWelcomeEventConsumer#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RoomWelcomeEventConsumer.accept(Action)"})
  void testAcceptWithAction_thenCallsGetName() {
    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());
    RoomWelcomeEventConsumer roomWelcomeEventConsumer = new RoomWelcomeEventConsumer(rh);
    Chat a = mock(Chat.class);
    when(a.getName()).thenReturn("Name");
    User u = mock(User.class);
    when(u.getName()).thenReturn("Name");

    // Act
    roomWelcomeEventConsumer.accept(new MemberAction(a, u, Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
    verify(a).getName();
    verify(u).getName();
  }
}
