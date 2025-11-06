package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.MiddlewareSet;
import com.microsoft.bot.builder.ShowTypingMiddleware;
import com.microsoft.bot.builder.SkypeMentionNormalizeMiddleware;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.connector.authentication.AuthenticationConfiguration;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleChannelProvider;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.restclient.retry.ExponentialBackoffRetryStrategy;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ConversationAccount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.content.TeamsChat;
import org.finos.springbot.teams.content.TeamsMultiwayChat;
import org.finos.springbot.teams.content.TeamsUser;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class AbstractTeamsConversationsDiffblueTest {
  /**
   * Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  void testIsSupported() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.isSupported(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  void testIsSupported2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertFalse((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).isSupported((Chat) null));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  void testIsSupported3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.isSupported(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  void testIsSupported4() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertFalse((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).isSupported((User) null));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  void testEnsureChat() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  void testEnsureChat2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();
    users.add(new TeamsUser("42", "Not implemented yet", "42"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  void testEnsureChat3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();
    users.add(new TeamsUser("42", "Not implemented yet", "42"));
    users.add(new TeamsUser("42", "Not implemented yet", "42"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers4() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers5() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers7() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel(null, "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers8() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers9() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new ShowTypingMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers10() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new SkypeMentionNormalizeMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers11() {
    // Arrange
    MicrosoftAppCredentials withCredentials = new MicrosoftAppCredentials("42", "iloveyou", "U/U");

    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  void testGetChatMembers12() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("UU", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins4() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins5() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins7() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel(null, "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins8() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins9() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new ShowTypingMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins10() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new SkypeMentionNormalizeMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins11() {
    // Arrange
    MicrosoftAppCredentials withCredentials = new MicrosoftAppCredentials("42", "iloveyou", "U/U");

    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins12() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("{UU}");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  void testGetChatAdmins13() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("UU", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  void testGetTeamsChannels() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.getTeamsChannels(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity()))));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  void testGetTeamsChannels2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setChannelData("With Channel Data");

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getTeamsChannels(new DelegatingTurnContext(
            new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity))));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  void testGetTeamsChannels3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setChannelData(42);

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getTeamsChannels(new DelegatingTurnContext(
            new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity))));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel4() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel5() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel7() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new ShowTypingMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  void testIsChannel8() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new SkypeMentionNormalizeMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUser(ChannelAccount)}
   */
  @Test
  void testGetUser() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    TeamsUser actualUser = stateStorageBasedTeamsConversations.getUser(new ChannelAccount("42"));

    // Assert
    assertEquals("42", actualUser.getKey());
    assertEquals("@null", actualUser.getText());
    assertNull(actualUser.getAadObjectId());
    assertNull(actualUser.getName());
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId4() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId5() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId7() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou", "U/U");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId8() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId9() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "; U=U");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId10() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new ShowTypingMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  void testGetOneToOneConversationId11() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("U/U");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new SkypeMentionNormalizeMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    ConversationAccount actualConversationAccount = stateStorageBasedTeamsConversations
        .getConversationAccount(new TeamsChannel("42", "Name"));

    // Assert
    assertEquals("42", actualConversationAccount.getId());
    assertEquals("botframework.com", actualConversationAccount.getTenantId());
    assertEquals("channel", actualConversationAccount.getConversationType());
    assertNull(actualConversationAccount.getRole());
    assertNull(actualConversationAccount.getAadObjectId());
    assertNull(actualConversationAccount.getName());
    assertFalse(actualConversationAccount.isGroup());
    assertTrue(actualConversationAccount.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou", "channel");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    ConversationAccount actualConversationAccount = stateStorageBasedTeamsConversations
        .getConversationAccount(new TeamsChannel("42", "Name"));

    // Assert
    assertEquals("42", actualConversationAccount.getId());
    assertEquals("channel", actualConversationAccount.getConversationType());
    assertEquals("channel", actualConversationAccount.getTenantId());
    assertNull(actualConversationAccount.getRole());
    assertNull(actualConversationAccount.getAadObjectId());
    assertNull(actualConversationAccount.getName());
    assertFalse(actualConversationAccount.isGroup());
    assertTrue(actualConversationAccount.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "channel", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount4() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getConversationAccount(null));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount5() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    ConversationAccount actualConversationAccount = stateStorageBasedTeamsConversations
        .getConversationAccount(new TeamsMultiwayChat("42", "channel"));

    // Assert
    assertEquals("42", actualConversationAccount.getId());
    assertEquals("botframework.com", actualConversationAccount.getTenantId());
    assertEquals("groupChat", actualConversationAccount.getConversationType());
    assertNull(actualConversationAccount.getRole());
    assertNull(actualConversationAccount.getAadObjectId());
    assertNull(actualConversationAccount.getName());
    assertFalse(actualConversationAccount.isGroup());
    assertTrue(actualConversationAccount.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou", "");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    ConversationAccount actualConversationAccount = stateStorageBasedTeamsConversations
        .getConversationAccount(new TeamsChannel("42", "Name"));

    // Assert
    assertEquals("42", actualConversationAccount.getId());
    assertEquals("botframework.com", actualConversationAccount.getTenantId());
    assertEquals("channel", actualConversationAccount.getConversationType());
    assertNull(actualConversationAccount.getRole());
    assertNull(actualConversationAccount.getAadObjectId());
    assertNull(actualConversationAccount.getName());
    assertFalse(actualConversationAccount.isGroup());
    assertTrue(actualConversationAccount.getProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount7() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou", "channel");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "channel", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount8() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "channel", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount9() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("channel");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "channel", "42")));
  }

  /**
   * Method under test:
   * {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  void testGetConversationAccount10() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("channel");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "channel", "42")));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById3() {
    // Arrange
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(null, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById4() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById5() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentials, withAuthConfig, withChannelProvider,
        withRetryStrategy, new MiddlewareSet());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById6() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, null, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById7() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");

    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById8() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new ShowTypingMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  void testGetUserById9() {
    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider("https://smba.trafficmanager.net/uk/");
    ExponentialBackoffRetryStrategy withRetryStrategy = new ExponentialBackoffRetryStrategy(3, 1, 3, 2);

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(withCredentialProvider, withChannelProvider, withRetryStrategy,
        new SkypeMentionNormalizeMiddleware());

    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }
}
