package org.finos.springbot.workflow.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserListResponseHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserListResponseHandlerDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @Autowired
  private UserListResponseHandler userListResponseHandler;

  /**
   * Test {@link UserListResponseHandler#UserListResponseHandler(AllConversations)}.
   * <p>
   * Method under test: {@link UserListResponseHandler#UserListResponseHandler(AllConversations)}
   */
  @Test
  @DisplayName("Test new UserListResponseHandler(AllConversations)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserListResponseHandler.<init>(AllConversations)"})
  void testNewUserListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, (new UserListResponseHandler(new AllConversations())).getOrder());
  }

  /**
   * Test {@link UserListResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link Addressable} and e is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserListResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void UserListResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);

    // Act and Assert
    assertNull(userListResponseHandler.apply(new ErrorResponse(stream, new Throwable())));
  }

  /**
   * Test {@link UserListResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>When {@link Response}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserListResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Void UserListResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(userListResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link UserListResponseHandler#getOrder()}.
   * <p>
   * Method under test: {@link UserListResponseHandler#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int UserListResponseHandler.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, userListResponseHandler.getOrder());
  }
}
