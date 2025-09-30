package org.finos.springbot.workflow.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatListResponseHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatListResponseHandlerDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @Autowired private ChatListResponseHandler chatListResponseHandler;

  /**
   * Test {@link ChatListResponseHandler#ChatListResponseHandler(AllConversations)}.
   *
   * <p>Method under test: {@link ChatListResponseHandler#ChatListResponseHandler(AllConversations)}
   */
  @Test
  @DisplayName("Test new ChatListResponseHandler(AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatListResponseHandler.<init>(AllConversations)"})
  void testNewChatListResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(
        ResponseHandler.MEDIUM_PRIORITY,
        new ChatListResponseHandler(new AllConversations()).getOrder());
  }

  /**
   * Test {@link ChatListResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link ErrorResponse#ErrorResponse(Addressable, Throwable)} with stream is {@link
   *       Addressable} and e is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ChatListResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; when ErrorResponse(Addressable, Throwable) with stream is Addressable and e is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ChatListResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenErrorResponseWithStreamIsAddressableAndEIsThrowable() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse t = new ErrorResponse(stream, new Throwable());

    // Act and Assert
    assertNull(chatListResponseHandler.apply(t));
  }

  /**
   * Test {@link ChatListResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link Response}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChatListResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ChatListResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(chatListResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link ChatListResponseHandler#getOrder()}.
   *
   * <p>Method under test: {@link ChatListResponseHandler#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChatListResponseHandler.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, chatListResponseHandler.getOrder());
  }
}
