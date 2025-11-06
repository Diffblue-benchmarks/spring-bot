package org.finos.springbot.example.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.Test;

class WelcomeMessageConfigDiffblueTest {
  /**
   * Method under test: {@link WelcomeMessageConfig#welcomeMessages()}
   */
  @Test
  void testWelcomeMessages() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    RoomWelcomeEventConsumer actualWelcomeMessagesResult = (new WelcomeMessageConfig()).welcomeMessages();
    MemberAction t = mock(MemberAction.class);
    when(t.getType()).thenReturn(MemberAction.Type.REMOVED);
    actualWelcomeMessagesResult.accept(t);

    // Assert that nothing has changed
    verify(t).getType();
  }
}
