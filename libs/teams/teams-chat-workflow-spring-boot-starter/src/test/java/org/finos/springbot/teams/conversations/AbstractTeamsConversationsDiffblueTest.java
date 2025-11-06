package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractTeamsConversationsDiffblueTest {
  /**
   * Test {@link AbstractTeamsConversations#isSupported(Chat)} with {@code r}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  @DisplayName("Test isSupported(Chat) with 'r'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(Chat)"})
  void testIsSupportedWithR_whenNull_thenReturnFalse() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertFalse((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).isSupported((Chat) null));
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(Chat)} with {@code r}.
   * <ul>
   *   <li>When {@link TeamsChannel#TeamsChannel(String, String)} with id is {@code 42} and {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  @DisplayName("Test isSupported(Chat) with 'r'; when TeamsChannel(String, String) with id is '42' and 'Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(Chat)"})
  void testIsSupportedWithR_whenTeamsChannelWithIdIs42AndName_thenReturnTrue() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.isSupported(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(User)} with {@code u}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  @DisplayName("Test isSupported(User) with 'u'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(User)"})
  void testIsSupportedWithU_thenReturnTrue() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.isSupported(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(User)} with {@code u}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  @DisplayName("Test isSupported(User) with 'u'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(User)"})
  void testIsSupportedWithU_whenNull_thenReturnFalse() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertFalse((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).isSupported((User) null));
  }

  /**
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code TeamsChat}, {@code List}, {@code Map}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code TeamsChat}, {@code List}, {@code Map}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code TeamsChat}, {@code List}, {@code Map}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap_whenArrayList() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatMembers(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatMembers(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatMembers(TeamsChat)"})
  void testGetChatMembersWithTeamsChat() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatMembers(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatMembers(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatMembers(TeamsChat)"})
  void testGetChatMembersWithTeamsChat2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatMembers(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatMembers(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatMembers(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatMembers(TeamsChat)"})
  void testGetChatMembersWithTeamsChat3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatMembers(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatAdmins(TeamsChat)"})
  void testGetChatAdminsWithTeamsChat() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatAdmins(TeamsChat)"})
  void testGetChatAdminsWithTeamsChat2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)} with {@code TeamsChat}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getChatAdmins(TeamsChat)}
   */
  @Test
  @DisplayName("Test getChatAdmins(TeamsChat) with 'TeamsChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getChatAdmins(TeamsChat)"})
  void testGetChatAdminsWithTeamsChat3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getChatAdmins(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   * <ul>
   *   <li>Given forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); given forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_givenFortyTwo() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   * <ul>
   *   <li>Given {@code With Channel Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); given 'With Channel Data'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_givenWithChannelData() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   * <ul>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_thenThrowTeamsException() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.getTeamsChannels(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity()))));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount("42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUser(ChannelAccount)}.
   * <ul>
   *   <li>When {@link ChannelAccount#ChannelAccount(String)} with withId is {@code 42}.</li>
   *   <li>Then return Key is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getUser(ChannelAccount)}
   */
  @Test
  @DisplayName("Test getUser(ChannelAccount); when ChannelAccount(String) with withId is '42'; then return Key is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUser(ChannelAccount)"})
  void testGetUser_whenChannelAccountWithWithIdIs42_thenReturnKeyIs42() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  @DisplayName("Test getOneToOneConversationId(TeamsUser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTeamsConversations.getOneToOneConversationId(TeamsUser)"})
  void testGetOneToOneConversationId() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  @DisplayName("Test getOneToOneConversationId(TeamsUser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTeamsConversations.getOneToOneConversationId(TeamsUser)"})
  void testGetOneToOneConversationId2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getOneToOneConversationId(TeamsUser)}
   */
  @Test
  @DisplayName("Test getOneToOneConversationId(TeamsUser)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractTeamsConversations.getOneToOneConversationId(TeamsUser)"})
  void testGetOneToOneConversationId3() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getOneToOneConversationId(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider(null, "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <ul>
   *   <li>Then return ConversationType is {@code channel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable); then return ConversationType is 'channel'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount_thenReturnConversationTypeIsChannel() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
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
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <ul>
   *   <li>Then return ConversationType is {@code groupChat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable); then return ConversationType is 'groupChat'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount_thenReturnConversationTypeIsGroupChat() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act
    ConversationAccount actualConversationAccount = stateStorageBasedTeamsConversations
        .getConversationAccount(new TeamsMultiwayChat("42", "Name"));

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
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <ul>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable); then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount_thenThrowTeamsException() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> stateStorageBasedTeamsConversations.getConversationAccount(new TeamsUser("42", "Name", "42")));
  }

  /**
   * Test {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}.
   * <ul>
   *   <li>When {@link TeamsAddressable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getConversationAccount(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getConversationAccount(TeamsAddressable); when TeamsAddressable; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConversationAccount AbstractTeamsConversations.getConversationAccount(TeamsAddressable)"})
  void testGetConversationAccount_whenTeamsAddressable_thenReturnNull() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))))
        .getConversationAccount(mock(TeamsAddressable.class)));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   * <p>
   * Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById3() {
    // Arrange
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(null, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getUserById("42"));
  }
}
