package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class StateStorageBasedTeamsConversationsDiffblueTest {
  /**
   * Test {@link StateStorageBasedTeamsConversations#StateStorageBasedTeamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)}.
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#StateStorageBasedTeamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test new StateStorageBasedTeamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.<init>(com.microsoft.bot.builder.BotFrameworkAdapter, com.microsoft.bot.connector.authentication.MicrosoftAppCredentials, com.microsoft.bot.schema.ChannelAccount, org.finos.springbot.teams.state.TeamsStateStorage)"})
  void testNewStateStorageBasedTeamsConversations() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    StateStorageBasedTeamsConversations actualStateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualStateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertTrue(actualStateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(actualStateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllAddressables()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getAllAddressables()}
   */
  @Test
  @DisplayName("Test getAllAddressables(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Set org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getAllAddressables()"})
  void testGetAllAddressables_thenReturnEmpty() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getAllAddressables().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllChats()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getAllChats()}
   */
  @Test
  @DisplayName("Test getAllChats(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Set org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getAllChats()"})
  void testGetAllChats_thenReturnEmpty() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getAllChats().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getExistingChat(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName("Test getExistingChat(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getExistingChat(java.lang.String)"})
  void testGetExistingChat_thenReturnNull() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getExistingChat("Name"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>Given {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)} with ejc is {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); given MemoryStateStorage(EntityJsonConverter) with ejc is EntityJsonConverter(ObjectMapper, List); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_givenMemoryStateStorageWithEjcIsEntityJsonConverter_when42() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).getChatById("42"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_when42() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById("42"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_INFO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_INFO")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_whenAddressable_info() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt")))
        .getChatById(StateStorageBasedTeamsConversations.ADDRESSABLE_INFO));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_TYPE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_whenAddressable_type() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt")))
        .getChatById(StateStorageBasedTeamsConversations.ADDRESSABLE_TYPE));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>When {@code =}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '='")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_whenEqualsSign() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById("="));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   * <ul>
   *   <li>When space.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.TeamsChat org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.getChatById(java.lang.String)"})
  void testGetChatById_whenSpace() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertNull((new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt"))).getChatById(" "));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test ensureRoomRecorded(TeamsAddressable); then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.ensureRoomRecorded(org.finos.springbot.teams.content.TeamsAddressable)"})
  void testEnsureRoomRecorded_thenCallsReadValue() {
    // Arrange
    EntityJsonConverter ejc = mock(EntityJsonConverter.class);
    when(ejc.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    MemoryStateStorage tss = new MemoryStateStorage(ejc);
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
        bfa, mac, new ChannelAccount("42"), tss);
    TeamsAddressable resultTo = mock(TeamsAddressable.class);
    when(resultTo.getKey()).thenReturn("Key");

    // Act
    stateStorageBasedTeamsConversations.ensureRoomRecorded(resultTo);

    // Assert
    verify(resultTo).getKey();
    verify(ejc).readValue(isNull());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}.
   * <ul>
   *   <li>Then calls {@link TeamsStateStorage#retrieve(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test ensureRoomRecorded(TeamsAddressable); then calls retrieve(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations.ensureRoomRecorded(org.finos.springbot.teams.content.TeamsAddressable)"})
  void testEnsureRoomRecorded_thenCallsRetrieve() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.readAllLines(Mockito.<Path>any())).thenReturn(new ArrayList<>());
      mockFiles.when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      TeamsStateStorage tss = mock(TeamsStateStorage.class);
      Optional<Map<String, Object>> emptyResult = Optional.empty();
      when(tss.retrieve(Mockito.<String>any())).thenReturn(emptyResult);
      doNothing().when(tss)
          .store(Mockito.<String>any(), Mockito.<Map<String, String>>any(), Mockito.<Map<String, Object>>any());
      BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
      MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
      StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations = new StateStorageBasedTeamsConversations(
          bfa, mac, new ChannelAccount("42"), tss);
      TeamsAddressable resultTo = mock(TeamsAddressable.class);
      when(resultTo.getKey()).thenReturn("Key");

      // Act
      stateStorageBasedTeamsConversations.ensureRoomRecorded(resultTo);

      // Assert
      verify(tss).retrieve(eq("Key/addressable"));
      verify(tss).store(eq("Key/addressable"), isA(Map.class), isA(Map.class));
      verify(resultTo, atLeast(1)).getKey();
    }
  }
}
