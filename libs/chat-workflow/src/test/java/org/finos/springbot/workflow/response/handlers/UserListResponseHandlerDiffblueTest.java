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

@ContextConfiguration(classes = {UserListResponseHandler.class, AllConversations.class})
@ExtendWith(SpringExtension.class)
class UserListResponseHandlerDiffblueTest {
  @Autowired
  private UserListResponseHandler userListResponseHandler;

  /**
   * Method under test: {@link UserListResponseHandler#apply(Response)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertNull(userListResponseHandler.apply(new MessageResponse(null, "Not all who wander are lost")));
    assertNull(userListResponseHandler.apply(new ErrorResponse(null, new Throwable())));
  }

  /**
   * Method under test: {@link UserListResponseHandler#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, userListResponseHandler.getOrder());
  }

  /**
   * Method under test:
   * {@link UserListResponseHandler#UserListResponseHandler(AllConversations)}
   */
  @Test
  void testNewUserListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, (new UserListResponseHandler(new AllConversations())).getOrder());
  }
}
