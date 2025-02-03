package org.finos.springbot.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WelcomeMessageConfigDiffblueTest {
  /**
   * Test {@link WelcomeMessageConfig#welcomeMessages()}.
   * <ul>
   *   <li>Then calls {@link MemberAction#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WelcomeMessageConfig#welcomeMessages()}
   */
  @Test
  @DisplayName("Test welcomeMessages(); then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer org.finos.springbot.example.demo.WelcomeMessageConfig.welcomeMessages()"})
  void testWelcomeMessages_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    RoomWelcomeEventConsumer actualWelcomeMessagesResult = (new WelcomeMessageConfig()).welcomeMessages();
    MemberAction t = mock(MemberAction.class);
    when(t.getType()).thenReturn(Type.REMOVED);
    actualWelcomeMessagesResult.accept(t);

    // Assert
    verify(t).getType();
  }
}
