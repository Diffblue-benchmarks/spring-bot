package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.Middleware;
import com.microsoft.bot.builder.NextDelegate;
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
import java.util.concurrent.CompletableFuture;
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
import org.mockito.Mockito;

class AbstractTeamsConversationsDiffblueTest {
  /**
   * Test {@link AbstractTeamsConversations#isSupported(Chat)} with {@code r}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  @DisplayName("Test isSupported(Chat) with 'r'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(Chat)"})
  void testIsSupportedWithR_whenNull_thenReturnFalse() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertFalse(stateStorageBasedTeamsConversations.isSupported((Chat) null));
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(Chat)} with {@code r}.
   *
   * <ul>
   *   <li>When {@link TeamsChannel#TeamsChannel(String, String)} with id is {@code 42} and {@code
   *       Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isSupported(Chat)}
   */
  @Test
  @DisplayName(
      "Test isSupported(Chat) with 'r'; when TeamsChannel(String, String) with id is '42' and 'Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(Chat)"})
  void testIsSupportedWithR_whenTeamsChannelWithIdIs42AndName_thenReturnTrue() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    boolean actualIsSupportedResult =
        stateStorageBasedTeamsConversations.isSupported(new TeamsChannel("42", "Name"));

    // Assert
    assertTrue(actualIsSupportedResult);
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(User)} with {@code u}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  @DisplayName("Test isSupported(User) with 'u'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(User)"})
  void testIsSupportedWithU_thenReturnTrue() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    TeamsUser u = new TeamsUser("42", "Name", "42");

    // Act
    boolean actualIsSupportedResult = stateStorageBasedTeamsConversations.isSupported(u);

    // Assert
    assertTrue(actualIsSupportedResult);
  }

  /**
   * Test {@link AbstractTeamsConversations#isSupported(User)} with {@code u}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isSupported(User)}
   */
  @Test
  @DisplayName("Test isSupported(User) with 'u'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isSupported(User)"})
  void testIsSupportedWithU_whenNull_thenReturnFalse() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertFalse(stateStorageBasedTeamsConversations.isSupported((User) null));
  }

  /**
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code
   * TeamsChat}, {@code List}, {@code Map}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();
    TeamsUser teamsUser = new TeamsUser("42", "Not implemented yet", "42");
    users.add(teamsUser);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code
   * TeamsChat}, {@code List}, {@code Map}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap2() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    TeamsChannel r = new TeamsChannel("42", "Name");

    ArrayList<TeamsUser> users = new ArrayList<>();
    TeamsUser teamsUser = new TeamsUser("42", "Not implemented yet", "42");
    users.add(teamsUser);
    TeamsUser teamsUser2 = new TeamsUser("42", "Not implemented yet", "42");
    users.add(teamsUser2);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)} with {@code
   * TeamsChat}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#ensureChat(TeamsChat, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(TeamsChat, List, Map) with 'TeamsChat', 'List', 'Map'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat AbstractTeamsConversations.ensureChat(TeamsChat, List, Map)"})
  void testEnsureChatWithTeamsChatListMap_whenArrayList() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    TeamsChannel r = new TeamsChannel("42", "Name");
    ArrayList<TeamsUser> users = new ArrayList<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> stateStorageBasedTeamsConversations.ensureChat(r, users, new HashMap<>()));
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   *
   * <ul>
   *   <li>Given forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); given forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_givenFortyTwo() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setChannelData(42);
    TurnContextImpl withTurnContext =
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            stateStorageBasedTeamsConversations.getTeamsChannels(
                new DelegatingTurnContext(withTurnContext)));
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   *
   * <ul>
   *   <li>Given {@code With Channel Data}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); given 'With Channel Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_givenWithChannelData() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setChannelData("With Channel Data");
    TurnContextImpl withTurnContext =
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            stateStorageBasedTeamsConversations.getTeamsChannels(
                new DelegatingTurnContext(withTurnContext)));
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}.
   *
   * <ul>
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getTeamsChannels(TurnContext)}
   */
  @Test
  @DisplayName("Test getTeamsChannels(TurnContext); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AbstractTeamsConversations.getTeamsChannels(TurnContext)"})
  void testGetTeamsChannels_thenThrowTeamsException() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            stateStorageBasedTeamsConversations.getTeamsChannels(
                new DelegatingTurnContext(withTurnContext)));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount()));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel2() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount()));
  }

  /**
   * Test {@link AbstractTeamsConversations#isChannel(ChannelAccount)}.
   *
   * <ul>
   *   <li>Then calls {@link Middleware#onTurn(TurnContext, NextDelegate)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#isChannel(ChannelAccount)}
   */
  @Test
  @DisplayName("Test isChannel(ChannelAccount); then calls onTurn(TurnContext, NextDelegate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTeamsConversations.isChannel(ChannelAccount)"})
  void testIsChannel_thenCallsOnTurn() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenThrow(new UnsupportedOperationException());
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> stateStorageBasedTeamsConversations.isChannel(new ChannelAccount()));
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUser(ChannelAccount)}.
   *
   * <ul>
   *   <li>When {@link ChannelAccount#ChannelAccount()}.
   *   <li>Then return Text is {@code @null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUser(ChannelAccount)}
   */
  @Test
  @DisplayName("Test getUser(ChannelAccount); when ChannelAccount(); then return Text is '@null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUser(ChannelAccount)"})
  void testGetUser_whenChannelAccount_thenReturnTextIsNull() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    TeamsUser actualUser = stateStorageBasedTeamsConversations.getUser(new ChannelAccount());

    // Assert
    assertEquals("@null", actualUser.getText());
    assertNull(actualUser.getAadObjectId());
    assertNull(actualUser.getKey());
    assertNull(actualUser.getName());
  }

  /**
   * Test {@link AbstractTeamsConversations#lookupUser(String)}.
   *
   * <ul>
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#lookupUser(String)}
   */
  @Test
  @DisplayName("Test lookupUser(String); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.lookupUser(String)"})
  void testLookupUser_thenThrowTeamsException() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenThrow(new UnsupportedOperationException());
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertThrows(TeamsException.class, () -> stateStorageBasedTeamsConversations.lookupUser("42"));
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName("Test getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable() {
    // Arrange
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(null, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName("Test getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable2() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName("Test getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable3() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    SimpleCredentialProvider withCredentialProvider =
        new SimpleCredentialProvider("42", "iloveyou");
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName("Test getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable4() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider, null, new ExponentialBackoffRetryStrategy(), withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName("Test getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable5() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider, new SimpleChannelProvider(), null, withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <ul>
   *   <li>Given {@code channel}.
   *   <li>Then return {@link TeamsChannel}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName(
      "Test getTeamsAddressable(ConversationAccount); given 'channel'; then return TeamsChannel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable_givenChannel_thenReturnTeamsChannel() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("channel");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    assertTrue(actualTeamsAddressable instanceof TeamsChannel);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals("@Tcd", ((TeamsChannel) actualTeamsAddressable).getText());
    assertEquals("Tcd", tcd.getName());
    assertEquals("Tcd", ((TeamsChannel) actualTeamsAddressable).getName());
    assertEquals("channel", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <ul>
   *   <li>Given {@link Middleware} {@link Middleware#onTurn(TurnContext, NextDelegate)} throw
   *       {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName(
      "Test getTeamsAddressable(ConversationAccount); given Middleware onTurn(TurnContext, NextDelegate) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable_givenMiddlewareOnTurnThrowUnsupportedOperationException() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenThrow(new UnsupportedOperationException());
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("groupChat");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertTrue(actualTeamsAddressable instanceof TeamsMultiwayChat);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals(
        "Group Chat (Unknown Participants)",
        ((TeamsMultiwayChat) actualTeamsAddressable).getName());
    assertEquals("Tcd", tcd.getName());
    assertEquals("groupChat", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <ul>
   *   <li>Given {@code personal}.
   *   <li>Then return {@link TeamsUser}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName(
      "Test getTeamsAddressable(ConversationAccount); given 'personal'; then return TeamsUser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable_givenPersonal_thenReturnTeamsUser() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    ConversationAccount tcd = new ConversationAccount("42");
    tcd.setConversationType("personal");
    tcd.setName("Tcd");

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);
    String actualKey = actualTeamsAddressable.getKey();

    // Assert
    assertTrue(actualTeamsAddressable instanceof TeamsUser);
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertEquals("42", tcd.getId());
    assertEquals("42", actualTeamsAddressable.getKey());
    assertEquals("42", actualKey);
    assertEquals("@Tcd", ((TeamsUser) actualTeamsAddressable).getText());
    assertEquals("Tcd", tcd.getName());
    assertEquals("Tcd", ((TeamsUser) actualTeamsAddressable).getName());
    assertEquals("personal", tcd.getConversationType());
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getTenantId());
    assertNull(((TeamsUser) actualTeamsAddressable).getAadObjectId());
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}.
   *
   * <ul>
   *   <li>Then {@link ConversationAccount#ConversationAccount()} Role is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractTeamsConversations#getTeamsAddressable(ConversationAccount)}
   */
  @Test
  @DisplayName(
      "Test getTeamsAddressable(ConversationAccount); then ConversationAccount() Role is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsAddressable AbstractTeamsConversations.getTeamsAddressable(ConversationAccount)"
  })
  void testGetTeamsAddressable_thenConversationAccountRoleIsNull() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    ConversationAccount tcd = new ConversationAccount();

    // Act
    TeamsAddressable actualTeamsAddressable =
        stateStorageBasedTeamsConversations.getTeamsAddressable(tcd);

    // Assert
    assertTrue(stateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertNull(tcd.getRole());
    assertNull(tcd.getAadObjectId());
    assertNull(tcd.getConversationType());
    assertNull(tcd.getId());
    assertNull(tcd.getName());
    assertNull(tcd.getTenantId());
    assertNull(actualTeamsAddressable);
    assertFalse(tcd.isGroup());
    assertTrue(tcd.getProperties().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById2() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById3() {
    // Arrange
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(null, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById4() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    TeamsUser actualUserById = stateStorageBasedTeamsConversations.getUserById("42");

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertNull(actualUserById);
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById5() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentials,
            withAuthConfig,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    TeamsUser actualUserById = stateStorageBasedTeamsConversations.getUserById("42");

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertNull(actualUserById);
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById6() {
    // Arrange
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentials,
            withAuthConfig,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            mock(Middleware.class));
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, null, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getUserById("42"));
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName("Test getUserById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById7() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenReturn(completedFutureResult);
    MicrosoftAppCredentials withCredentials = MicrosoftAppCredentials.empty();
    AuthenticationConfiguration withAuthConfig = new AuthenticationConfiguration();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentials,
            withAuthConfig,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = new MicrosoftAppCredentials("42", "iloveyou");
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    TeamsUser actualUserById = stateStorageBasedTeamsConversations.getUserById("42");

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertNull(actualUserById);
  }

  /**
   * Test {@link AbstractTeamsConversations#getUserById(String)}.
   *
   * <ul>
   *   <li>Given {@link Middleware} {@link Middleware#onTurn(TurnContext, NextDelegate)} throw
   *       {@link UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTeamsConversations#getUserById(String)}
   */
  @Test
  @DisplayName(
      "Test getUserById(String); given Middleware onTurn(TurnContext, NextDelegate) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsUser AbstractTeamsConversations.getUserById(String)"})
  void testGetUserById_givenMiddlewareOnTurnThrowUnsupportedOperationException() {
    // Arrange
    Middleware withMiddleware = mock(Middleware.class);
    when(withMiddleware.onTurn(Mockito.<TurnContext>any(), Mockito.<NextDelegate>any()))
        .thenThrow(new UnsupportedOperationException());
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider();
    SimpleChannelProvider withChannelProvider = new SimpleChannelProvider();

    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(
            withCredentialProvider,
            withChannelProvider,
            new ExponentialBackoffRetryStrategy(),
            withMiddleware);
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    TeamsUser actualUserById = stateStorageBasedTeamsConversations.getUserById("42");

    // Assert
    verify(withMiddleware).onTurn(isA(TurnContext.class), isA(NextDelegate.class));
    assertNull(actualUserById);
  }
}
