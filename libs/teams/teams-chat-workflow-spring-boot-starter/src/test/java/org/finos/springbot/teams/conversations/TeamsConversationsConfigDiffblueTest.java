package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import java.util.ArrayList;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class TeamsConversationsConfigDiffblueTest {
  /**
   * Method under test:
   * {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)}
   */
  @Test
  void testTeamsConversations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ObjectMapper om = new ObjectMapper();

    // Act
    TeamsConversations actualTeamsConversationsResult = teamsConversationsConfig.teamsConversations(bfa, mac, "42",
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualTeamsConversationsResult instanceof StateStorageBasedTeamsConversations);
    assertTrue(
        ((StateStorageBasedTeamsConversations) actualTeamsConversationsResult).tss instanceof MemoryStateStorage);
    assertTrue(actualTeamsConversationsResult.getAllAddressables().isEmpty());
    assertTrue(actualTeamsConversationsResult.getAllChats().isEmpty());
  }
}
