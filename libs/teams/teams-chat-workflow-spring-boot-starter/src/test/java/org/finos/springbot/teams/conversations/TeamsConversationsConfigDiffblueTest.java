package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import java.util.ArrayList;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsConversationsConfigDiffblueTest {
  /**
   * Test {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)}.
   * <p>
   * Method under test: {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.conversations.TeamsConversations org.finos.springbot.teams.conversations.TeamsConversationsConfig.teamsConversations(com.microsoft.bot.builder.BotFrameworkAdapter, com.microsoft.bot.connector.authentication.MicrosoftAppCredentials, java.lang.String, org.finos.springbot.teams.state.TeamsStateStorage)"})
  void testTeamsConversations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

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
