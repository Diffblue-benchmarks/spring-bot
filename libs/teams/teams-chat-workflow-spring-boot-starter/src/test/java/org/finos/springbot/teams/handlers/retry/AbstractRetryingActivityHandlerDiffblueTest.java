package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.connector.rest.ErrorResponseException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import okhttp3.ResponseBody;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import retrofit2.Response;

@ContextConfiguration(classes = {InMemoryRetryingActivityHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class AbstractRetryingActivityHandlerDiffblueTest {
  @Autowired private AbstractRetryingActivityHandler abstractRetryingActivityHandler;

  @MockitoBean private TeamsConversations teamsConversations;

  /**
   * Test {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}.
   *
   * <ul>
   *   <li>Given four hundred twenty-nine.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  @DisplayName(
      "Test isTooManyRequest(Throwable); given four hundred twenty-nine; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRetryingActivityHandler.isTooManyRequest(Throwable)"})
  void testIsTooManyRequest_givenFourHundredTwentyNine_thenReturnTrue() {
    // Arrange
    Response<ResponseBody> response = mock(Response.class);
    when(response.code()).thenReturn(429);
    ErrorResponseException errorResponseException =
        new ErrorResponseException("An error occurred", response);

    // Act
    boolean actualIsTooManyRequestResult =
        abstractRetryingActivityHandler.isTooManyRequest(
            new CompletionException(errorResponseException));

    // Assert
    verify(response).code();
    assertTrue(actualIsTooManyRequestResult);
  }

  /**
   * Test {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Response} {@link Response#code()} return one.
   *   <li>Then calls {@link Response#code()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  @DisplayName(
      "Test isTooManyRequest(Throwable); given one; when Response code() return one; then calls code()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRetryingActivityHandler.isTooManyRequest(Throwable)"})
  void testIsTooManyRequest_givenOne_whenResponseCodeReturnOne_thenCallsCode() {
    // Arrange
    Response<ResponseBody> response = mock(Response.class);
    when(response.code()).thenReturn(1);
    ErrorResponseException errorResponseException =
        new ErrorResponseException("An error occurred", response);

    // Act
    boolean actualIsTooManyRequestResult =
        abstractRetryingActivityHandler.isTooManyRequest(
            new CompletionException(errorResponseException));

    // Assert
    verify(response).code();
    assertFalse(actualIsTooManyRequestResult);
  }

  /**
   * Test {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}.
   *
   * <ul>
   *   <li>When {@link CompletionException#CompletionException(Throwable)} with {@link
   *       Throwable#Throwable()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  @DisplayName(
      "Test isTooManyRequest(Throwable); when CompletionException(Throwable) with Throwable(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRetryingActivityHandler.isTooManyRequest(Throwable)"})
  void testIsTooManyRequest_whenCompletionExceptionWithThrowable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        abstractRetryingActivityHandler.isTooManyRequest(new CompletionException(new Throwable())));
  }

  /**
   * Test {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  @DisplayName("Test isTooManyRequest(Throwable); when Throwable(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractRetryingActivityHandler.isTooManyRequest(Throwable)"})
  void testIsTooManyRequest_whenThrowable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractRetryingActivityHandler.isTooManyRequest(new Throwable()));
  }

  /**
   * Test {@link AbstractRetryingActivityHandler#failed(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRetryingActivityHandler#failed(Throwable)}
   */
  @Test
  @DisplayName("Test failed(Throwable); when Throwable(); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture AbstractRetryingActivityHandler.failed(Throwable)"})
  void testFailed_whenThrowable_thenReturnDone() {
    // Arrange and Act
    CompletableFuture<Object> actualFailedResult =
        AbstractRetryingActivityHandler.failed(new Throwable());

    // Assert
    assertTrue(actualFailedResult.isDone());
  }
}
