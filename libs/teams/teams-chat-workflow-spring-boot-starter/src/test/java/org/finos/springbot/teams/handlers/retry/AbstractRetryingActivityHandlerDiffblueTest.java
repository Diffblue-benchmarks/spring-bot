package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class AbstractRetryingActivityHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractRetryingActivityHandler#isTooManyRequest(Throwable)}
   */
  @Test
  void testIsTooManyRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    InMemoryRetryingActivityHandler inMemoryRetryingActivityHandler = new InMemoryRetryingActivityHandler(
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));

    // Act and Assert
    assertFalse(inMemoryRetryingActivityHandler.isTooManyRequest(new Throwable()));
  }

  /**
   * Method under test: {@link AbstractRetryingActivityHandler#failed(Throwable)}
   */
  @Test
  void testFailed() {
    // Arrange and Act
    CompletableFuture<Object> actualFailedResult = AbstractRetryingActivityHandler.failed(new Throwable());

    // Assert
    assertTrue(actualFailedResult.isDone());
  }
}
