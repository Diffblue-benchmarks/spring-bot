package org.finos.springbot.workflow.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatListResponseHandler.class, AllConversations.class})
@ExtendWith(SpringExtension.class)
class ChatListResponseHandlerDiffblueTest {
  @Autowired
  private ChatListResponseHandler chatListResponseHandler;

  /**
   * Method under test: {@link ChatListResponseHandler#apply(Response)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertNull(chatListResponseHandler.apply(new MessageResponse(null, "Not all who wander are lost")));
    assertNull(chatListResponseHandler.apply(new ErrorResponse(null, new Throwable())));
  }

  /**
   * Method under test: {@link ChatListResponseHandler#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, chatListResponseHandler.getOrder());
  }

  /**
   * Method under test:
   * {@link ChatListResponseHandler#ChatListResponseHandler(AllConversations)}
   */
  @Test
  void testNewChatListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, (new ChatListResponseHandler(new AllConversations())).getOrder());
  }
}
