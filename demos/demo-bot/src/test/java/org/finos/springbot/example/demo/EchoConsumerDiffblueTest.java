package org.finos.springbot.example.demo;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.SimpleMessageAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Message;
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

@ContextConfiguration(classes = {EchoConsumer.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EchoConsumerDiffblueTest {
  @Autowired
  private EchoConsumer echoConsumer;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Method under test: {@link EchoConsumer#accept(Action)}
   */
  @Test
  void testAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);

    // Act
    echoConsumer.accept(new SimpleMessageAction(a, u, new Message.MessageImpl(new ArrayList<>()), "Ej"));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
