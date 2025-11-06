package org.finos.springbot.example.demo;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StartUpMessageBean.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class StartUpMessageBeanDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @MockBean
  private ResponseHandlers responseHandlers;

  @Autowired
  private StartUpMessageBean startUpMessageBean;

  /**
   * Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  void testDoSomethingAfterStartup() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any())).thenReturn(new SymphonyRoom("Name", "42"));
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    startUpMessageBean.doSomethingAfterStartup();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getExistingChat(eq("${room}"));
  }

  /**
   * Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  void testDoSomethingAfterStartup2() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any())).thenReturn(null);

    // Act
    startUpMessageBean.doSomethingAfterStartup();

    // Assert that nothing has changed
    verify(allConversations).getExistingChat(eq("${room}"));
  }
}
