package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.util.ArrayList;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class InMemoryRetryingActivityHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link InMemoryRetryingActivityHandler#InMemoryRetryingActivityHandler(TeamsConversations)}
   */
  @Test
  void testNewInMemoryRetryingActivityHandler() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act
    InMemoryRetryingActivityHandler actualInMemoryRetryingActivityHandler = new InMemoryRetryingActivityHandler(
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));

    // Assert
    TeamsConversations teamsConversations = actualInMemoryRetryingActivityHandler.tc;
    assertTrue(teamsConversations instanceof StateStorageBasedTeamsConversations);
    assertEquals(3L, actualInMemoryRetryingActivityHandler.teamsRetryCount);
    assertTrue(teamsConversations.getAllAddressables().isEmpty());
    assertTrue(teamsConversations.getAllChats().isEmpty());
  }
}
