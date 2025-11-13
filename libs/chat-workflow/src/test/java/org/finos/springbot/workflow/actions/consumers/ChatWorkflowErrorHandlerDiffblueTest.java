package org.finos.springbot.workflow.actions.consumers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
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

@ContextConfiguration(classes = {ChatWorkflowErrorHandler.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatWorkflowErrorHandlerDiffblueTest {
  @Autowired private ChatWorkflowErrorHandler chatWorkflowErrorHandler;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test {@link ChatWorkflowErrorHandler#ChatWorkflowErrorHandler(ResponseHandlers, String)}.
   *
   * <p>Method under test: {@link
   * ChatWorkflowErrorHandler#ChatWorkflowErrorHandler(ResponseHandlers, String)}
   */
  @Test
  @DisplayName("Test new ChatWorkflowErrorHandler(ResponseHandlers, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatWorkflowErrorHandler.<init>(ResponseHandlers, String)"})
  void testNewChatWorkflowErrorHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "Template Name",
        new ChatWorkflowErrorHandler(mock(ResponseHandlers.class), "Template Name").templateName);
  }

  /**
   * Test {@link ChatWorkflowErrorHandler#handleError(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable(String)} with {@code Not all who wander are lost}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ChatWorkflowErrorHandler#handleError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test handleError(Throwable); when Throwable(String) with 'Not all who wander are lost'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatWorkflowErrorHandler.handleError(Throwable)"})
  void testHandleError_whenThrowableWithNotAllWhoWanderAreLost_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    chatWorkflowErrorHandler.handleError(new Throwable("Not all who wander are lost"));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link ChatWorkflowErrorHandler#handleError(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ChatWorkflowErrorHandler#handleError(Throwable)}
   */
  @Test
  @DisplayName("Test handleError(Throwable); when Throwable(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatWorkflowErrorHandler.handleError(Throwable)"})
  void testHandleError_whenThrowable_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    chatWorkflowErrorHandler.handleError(new Throwable());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
