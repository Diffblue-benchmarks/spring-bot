package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.util.ArrayList;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class StateStorageBasedTeamsConversationsDiffblueTest {
  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getAllAddressables()}
   */
  @Test
  void testGetAllAddressables() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getAllAddressables().isEmpty());
  }

  /**
   * Method under test: {@link StateStorageBasedTeamsConversations#getAllChats()}
   */
  @Test
  void testGetAllChats() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getAllChats().isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getExistingChat(String)}
   */
  @Test
  void testGetExistingChat() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getExistingChat("Name"));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getChatById("42"));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById("42"));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById(" "));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById4() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById("="));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById5() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt")))
        .getChatById(StateStorageBasedTeamsConversations.ADDRESSABLE_INFO));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  void testGetChatById6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt")))
        .getChatById(StateStorageBasedTeamsConversations.ADDRESSABLE_TYPE));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsConversations#StateStorageBasedTeamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)}
   */
  @Test
  void testNewStateStorageBasedTeamsConversations() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act
    StateStorageBasedTeamsConversations actualStateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualStateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertTrue(actualStateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(actualStateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }
}
