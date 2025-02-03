package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletableFuture;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisabledInAotMode
@ContextConfiguration(classes = {InMemoryRetryingActivityHandler.class})
@ExtendWith(SpringExtension.class)
class AbstractRetryingActivityHandlerDiffblueTest {
  @MockBean
  private TeamsConversations teamsConversations;

  @Autowired
  private AbstractRetryingActivityHandler abstractRetryingActivityHandler;

  /**
   * Test {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}.
   * <p>
   * Method under test: {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  @DisplayName("Test isTooManyRequest(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.teams.handlers.retry.AbstractRetryingActivityHandler.isTooManyRequest(java.lang.Throwable)"})
  void testIsTooManyRequest() {
    // Arrange, Act and Assert
    assertFalse(abstractRetryingActivityHandler.isTooManyRequest(new Throwable()));
  }

  /**
   * Test {@link AbstractRetryingActivityHandler#failed(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractRetryingActivityHandler#failed(Throwable)}
   */
  @Test
  @DisplayName("Test failed(Throwable); when Throwable(); then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.handlers.retry.AbstractRetryingActivityHandler.failed(java.lang.Throwable)"})
  void testFailed_whenThrowable_thenReturnDone() {
    // Arrange and Act
    CompletableFuture<Object> actualFailedResult = AbstractRetryingActivityHandler.failed(new Throwable());

    // Assert
    assertTrue(actualFailedResult.isDone());
  }
}
