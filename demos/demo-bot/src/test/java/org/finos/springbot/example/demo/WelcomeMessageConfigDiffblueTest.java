package org.finos.springbot.example.demo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WelcomeMessageConfig.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class WelcomeMessageConfigDiffblueTest {
  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private WelcomeMessageConfig welcomeMessageConfig;

  /**
   * Test {@link WelcomeMessageConfig#welcomeMessages()}.
   *
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} does nothing.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link WelcomeMessageConfig#welcomeMessages()}
   */
  @Test
  @DisplayName(
      "Test welcomeMessages(); given ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer WelcomeMessageConfig.welcomeMessages()"})
  void testWelcomeMessages_givenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualWelcomeMessagesResult = welcomeMessageConfig.welcomeMessages();
    SymphonyRoom a = new SymphonyRoom("Name", "42");
    MemberAction t = new MemberAction(a, new SymphonyUser(1L), Type.ADDED, "42");
    actualWelcomeMessagesResult.accept(t);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link WelcomeMessageConfig#welcomeMessages()}.
   *
   * <ul>
   *   <li>Given {@link WelcomeMessageConfig} (default constructor).
   *   <li>Then calls {@link MemberAction#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link WelcomeMessageConfig#welcomeMessages()}
   */
  @Test
  @DisplayName(
      "Test welcomeMessages(); given WelcomeMessageConfig (default constructor); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer WelcomeMessageConfig.welcomeMessages()"})
  void testWelcomeMessages_givenWelcomeMessageConfig_thenCallsGetType() {
    // Arrange and Act
    RoomWelcomeEventConsumer actualWelcomeMessagesResult =
        new WelcomeMessageConfig().welcomeMessages();
    MemberAction t = mock(MemberAction.class);
    when(t.getType()).thenReturn(Type.REMOVED);
    actualWelcomeMessagesResult.accept(t);

    // Assert
    verify(t).getType();
  }
}
