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
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.util.Context;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.TaggedBlobItem;
import com.azure.storage.blob.options.FindBlobsOptions;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.ChannelAccount;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChat;
import org.finos.springbot.teams.state.AzureBlobStateStorage;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

class StateStorageBasedTeamsConversationsDiffblueTest {
  /**
   * Test {@link
   * StateStorageBasedTeamsConversations#StateStorageBasedTeamsConversations(BotFrameworkAdapter,
   * MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)}.
   *
   * <p>Method under test: {@link
   * StateStorageBasedTeamsConversations#StateStorageBasedTeamsConversations(BotFrameworkAdapter,
   * MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test new StateStorageBasedTeamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StateStorageBasedTeamsConversations.<init>(BotFrameworkAdapter, MicrosoftAppCredentials, ChannelAccount, TeamsStateStorage)"
  })
  void testNewStateStorageBasedTeamsConversations() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    StateStorageBasedTeamsConversations actualStateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Assert
    assertTrue(actualStateStorageBasedTeamsConversations.tss instanceof MemoryStateStorage);
    assertTrue(actualStateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
    assertTrue(actualStateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllAddressables()}.
   *
   * <ul>
   *   <li>Given {@link BlobContainerClient} {@link BlobContainerClient#exists()} return {@code
   *       true}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getAllAddressables()}
   */
  @Test
  @DisplayName(
      "Test getAllAddressables(); given BlobContainerClient exists() return 'true'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StateStorageBasedTeamsConversations.getAllAddressables()"})
  void testGetAllAddressables_givenBlobContainerClientExistsReturnTrue_thenCallsExists() {
    // Arrange
    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);

    Function<Integer, Mono<PagedResponse<TaggedBlobItem>>> firstPageRetriever =
        mock(Function.class);
    HttpRequest request = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers = new HttpHeaders(1);
    HttpRequest request2 = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers2 = new HttpHeaders(1);
    Mono<PagedResponse<TaggedBlobItem>> justResult =
        Mono.just(
            new PagedResponseBase<>(
                request,
                1,
                headers,
                new PagedResponseBase<>(
                    request2,
                    1,
                    headers2,
                    new ArrayList<>(),
                    "https://example.org/example",
                    "Deserialized Headers"),
                "Deserialized Headers"));
    when(firstPageRetriever.apply(Mockito.<Integer>any())).thenReturn(justResult);
    PagedFlux<TaggedBlobItem> pagedFlux = new PagedFlux<>(firstPageRetriever);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.findBlobsByTags(
            Mockito.<FindBlobsOptions>any(), Mockito.<Duration>any(), Mockito.<Context>any()))
        .thenReturn(new PagedIterable<>(pagedFlux));
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss =
        new AzureBlobStateStorage(bsc, ejc, StateStorageBasedTeamsConversations.ADDRESSABLE_INFO);
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    Set<Addressable> actualAllAddressables =
        stateStorageBasedTeamsConversations.getAllAddressables();

    // Assert
    verify(blobContainerClient).exists();
    verify(bsc)
        .findBlobsByTags(isA(FindBlobsOptions.class), isA(Duration.class), isA(Context.class));
    verify(bsc).getBlobContainerClient("addressable-info");
    verify(firstPageRetriever).apply(isNull());
    assertTrue(actualAllAddressables.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllAddressables()}.
   *
   * <ul>
   *   <li>Given {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)} with ejc is
   *       {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getAllAddressables()}
   */
  @Test
  @DisplayName(
      "Test getAllAddressables(); given MemoryStateStorage(EntityJsonConverter) with ejc is EntityJsonConverter(ObjectMapper, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StateStorageBasedTeamsConversations.getAllAddressables()"})
  void testGetAllAddressables_givenMemoryStateStorageWithEjcIsEntityJsonConverter() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.getAllAddressables().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllChats()}.
   *
   * <ul>
   *   <li>Given {@link BlobContainerClient} {@link BlobContainerClient#exists()} return {@code
   *       true}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getAllChats()}
   */
  @Test
  @DisplayName(
      "Test getAllChats(); given BlobContainerClient exists() return 'true'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StateStorageBasedTeamsConversations.getAllChats()"})
  void testGetAllChats_givenBlobContainerClientExistsReturnTrue_thenCallsExists() {
    // Arrange
    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);

    Function<Integer, Mono<PagedResponse<TaggedBlobItem>>> firstPageRetriever =
        mock(Function.class);
    HttpRequest request = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers = new HttpHeaders(1);
    HttpRequest request2 = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers2 = new HttpHeaders(1);
    Mono<PagedResponse<TaggedBlobItem>> justResult =
        Mono.just(
            new PagedResponseBase<>(
                request,
                1,
                headers,
                new PagedResponseBase<>(
                    request2,
                    1,
                    headers2,
                    new ArrayList<>(),
                    "https://example.org/example",
                    "Deserialized Headers"),
                "Deserialized Headers"));
    when(firstPageRetriever.apply(Mockito.<Integer>any())).thenReturn(justResult);
    PagedFlux<TaggedBlobItem> pagedFlux = new PagedFlux<>(firstPageRetriever);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.findBlobsByTags(
            Mockito.<FindBlobsOptions>any(), Mockito.<Duration>any(), Mockito.<Context>any()))
        .thenReturn(new PagedIterable<>(pagedFlux));
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss =
        new AzureBlobStateStorage(bsc, ejc, StateStorageBasedTeamsConversations.ADDRESSABLE_INFO);
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    Set<TeamsChat> actualAllChats = stateStorageBasedTeamsConversations.getAllChats();

    // Assert
    verify(blobContainerClient).exists();
    verify(bsc)
        .findBlobsByTags(isA(FindBlobsOptions.class), isA(Duration.class), isA(Context.class));
    verify(bsc).getBlobContainerClient("addressable-info");
    verify(firstPageRetriever).apply(isNull());
    assertTrue(actualAllChats.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getAllChats()}.
   *
   * <ul>
   *   <li>Given {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)} with ejc is
   *       {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getAllChats()}
   */
  @Test
  @DisplayName(
      "Test getAllChats(); given MemoryStateStorage(EntityJsonConverter) with ejc is EntityJsonConverter(ObjectMapper, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set StateStorageBasedTeamsConversations.getAllChats()"})
  void testGetAllChats_givenMemoryStateStorageWithEjcIsEntityJsonConverter() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>Given {@link BlobContainerClient} {@link BlobContainerClient#exists()} return {@code
   *       true}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName(
      "Test getExistingChat(String); given BlobContainerClient exists() return 'true'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getExistingChat(String)"})
  void testGetExistingChat_givenBlobContainerClientExistsReturnTrue_thenCallsExists() {
    // Arrange
    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);

    Function<Integer, Mono<PagedResponse<TaggedBlobItem>>> firstPageRetriever =
        mock(Function.class);
    HttpRequest request = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers = new HttpHeaders(1);
    HttpRequest request2 = new HttpRequest(HttpMethod.GET, "https://example.org/example");
    HttpHeaders headers2 = new HttpHeaders(1);
    Mono<PagedResponse<TaggedBlobItem>> justResult =
        Mono.just(
            new PagedResponseBase<>(
                request,
                1,
                headers,
                new PagedResponseBase<>(
                    request2,
                    1,
                    headers2,
                    new ArrayList<>(),
                    "https://example.org/example",
                    "Deserialized Headers"),
                "Deserialized Headers"));
    when(firstPageRetriever.apply(Mockito.<Integer>any())).thenReturn(justResult);
    PagedFlux<TaggedBlobItem> pagedFlux = new PagedFlux<>(firstPageRetriever);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.findBlobsByTags(
            Mockito.<FindBlobsOptions>any(), Mockito.<Duration>any(), Mockito.<Context>any()))
        .thenReturn(new PagedIterable<>(pagedFlux));
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss =
        new AzureBlobStateStorage(bsc, ejc, StateStorageBasedTeamsConversations.ADDRESSABLE_INFO);
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualExistingChat = stateStorageBasedTeamsConversations.getExistingChat("Name");

    // Assert
    verify(blobContainerClient).exists();
    verify(bsc)
        .findBlobsByTags(isA(FindBlobsOptions.class), isA(Duration.class), isA(Context.class));
    verify(bsc).getBlobContainerClient("addressable-info");
    verify(firstPageRetriever).apply(isNull());
    assertNull(actualExistingChat);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getExistingChat(String)}.
   *
   * <ul>
   *   <li>Given {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)} with ejc is
   *       {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getExistingChat(String)}
   */
  @Test
  @DisplayName(
      "Test getExistingChat(String); given MemoryStateStorage(EntityJsonConverter) with ejc is EntityJsonConverter(ObjectMapper, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getExistingChat(String)"})
  void testGetExistingChat_givenMemoryStateStorageWithEjcIsEntityJsonConverter() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getExistingChat("Name"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When {@code [^0-9a-zA-Z/]}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); given BlobClient download(OutputStream) does nothing; when '[^0-9a-zA-Z/]'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_givenBlobClientDownloadDoesNothing_when09aZAZ_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById = stateStorageBasedTeamsConversations.getChatById("[^0-9a-zA-Z/]");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("__0_9a_zA_Z/_/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); given BlobClient download(OutputStream) does nothing; when '42'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_givenBlobClientDownloadDoesNothing_when42_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById = stateStorageBasedTeamsConversations.getChatById("42 ");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("42_/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When space.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); given BlobClient download(OutputStream) does nothing; when space; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_givenBlobClientDownloadDoesNothing_whenSpace_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById = stateStorageBasedTeamsConversations.getChatById(" ");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("_/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>Given {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)} with ejc is
   *       {@link EntityJsonConverter#EntityJsonConverter(ObjectMapper, List)}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); given MemoryStateStorage(EntityJsonConverter) with ejc is EntityJsonConverter(ObjectMapper, List); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_givenMemoryStateStorageWithEjcIsEntityJsonConverter_when42() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getChatById("42"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_when42() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getChatById("42"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_when422() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getChatById("42 "));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_INFO}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_INFO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenAddressable_info() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(
        stateStorageBasedTeamsConversations.getChatById(
            StateStorageBasedTeamsConversations.ADDRESSABLE_INFO));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_INFO}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_INFO; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenAddressable_info_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById =
        stateStorageBasedTeamsConversations.getChatById(
            StateStorageBasedTeamsConversations.ADDRESSABLE_INFO);

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("addressable_info/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_TYPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenAddressable_type() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(
        stateStorageBasedTeamsConversations.getChatById(
            StateStorageBasedTeamsConversations.ADDRESSABLE_TYPE));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@link StateStorageBasedTeamsConversations#ADDRESSABLE_TYPE}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when ADDRESSABLE_TYPE; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenAddressable_type_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById =
        stateStorageBasedTeamsConversations.getChatById(
            StateStorageBasedTeamsConversations.ADDRESSABLE_TYPE);

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("addressable_type/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code =}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenEqualsSign() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getChatById("="));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code =}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when '='; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenEqualsSign_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById = stateStorageBasedTeamsConversations.getChatById("=");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("_/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code TeamsChat}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when 'org.finos.springbot.teams.content.TeamsChat'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenOrgFinosSpringbotTeamsContentTeamsChat() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(
        stateStorageBasedTeamsConversations.getChatById(
            "org.finos.springbot.teams.content.TeamsChat"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code TeamsChat}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); when 'org.finos.springbot.teams.content.TeamsChat'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenOrgFinosSpringbotTeamsContentTeamsChat_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById =
        stateStorageBasedTeamsConversations.getChatById(
            "org.finos.springbot.teams.content.TeamsChat");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient)
        .getBlobClient("org_finos_springbot_teams_content_TeamsChat/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code Addressable}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when 'org.finos.springbot.workflow.content.Addressable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenOrgFinosSpringbotWorkflowContentAddressable() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(
        stateStorageBasedTeamsConversations.getChatById(
            "org.finos.springbot.workflow.content.Addressable"));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When {@code Addressable}.
   *   <li>Then calls {@link BlobContainerClient#exists()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName(
      "Test getChatById(String); when 'org.finos.springbot.workflow.content.Addressable'; then calls exists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenOrgFinosSpringbotWorkflowContentAddressable_thenCallsExists() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage tss = new AzureBlobStateStorage(bsc, ejc, "Container");
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

    // Act
    TeamsChat actualChatById =
        stateStorageBasedTeamsConversations.getChatById(
            "org.finos.springbot.workflow.content.Addressable");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient)
        .getBlobClient("org_finos_springbot_workflow_content_Addressable/addressable");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertNull(actualChatById);
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#getChatById(String)}.
   *
   * <ul>
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsConversations#getChatById(String)}
   */
  @Test
  @DisplayName("Test getChatById(String); when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsChat StateStorageBasedTeamsConversations.getChatById(String)"})
  void testGetChatById_whenSpace() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new FileStateStorage(ejc, "/directory/foo.txt"));

    // Act and Assert
    assertNull(stateStorageBasedTeamsConversations.getChatById(" "));
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then calls {@link Files#exists(Path, LinkOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test ensureRoomRecorded(TeamsAddressable); then calls exists(Path, LinkOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StateStorageBasedTeamsConversations.ensureRoomRecorded(TeamsAddressable)"
  })
  void testEnsureRoomRecorded_thenCallsExists() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readAllLines(Mockito.<Path>any())).thenReturn(new ArrayList<>());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);

      EntityJsonConverter ejc = mock(EntityJsonConverter.class);
      when(ejc.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
      FileStateStorage tss = new FileStateStorage(ejc, "/directory/foo.txt");
      BotFrameworkAdapter bfa =
          new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
      MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

      StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
          new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

      TeamsAddressable resultTo = mock(TeamsAddressable.class);
      when(resultTo.getKey()).thenReturn("Key");

      // Act
      stateStorageBasedTeamsConversations.ensureRoomRecorded(resultTo);

      // Assert
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(() -> Files.readAllLines(Mockito.<Path>any()));
      verify(resultTo).getKey();
      verify(ejc).readValue("");
    }
  }

  /**
   * Test {@link StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then calls {@link TeamsStateStorage#retrieve(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StateStorageBasedTeamsConversations#ensureRoomRecorded(TeamsAddressable)}
   */
  @Test
  @DisplayName("Test ensureRoomRecorded(TeamsAddressable); then calls retrieve(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StateStorageBasedTeamsConversations.ensureRoomRecorded(TeamsAddressable)"
  })
  void testEnsureRoomRecorded_thenCallsRetrieve() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.readAllLines(Mockito.<Path>any())).thenReturn(new ArrayList<>());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);

      TeamsStateStorage tss = mock(TeamsStateStorage.class);
      Optional<Map<String, Object>> emptyResult = Optional.empty();
      when(tss.retrieve(Mockito.<String>any())).thenReturn(emptyResult);
      doNothing()
          .when(tss)
          .store(
              Mockito.<String>any(),
              Mockito.<Map<String, String>>any(),
              Mockito.<Map<String, Object>>any());
      BotFrameworkAdapter bfa =
          new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
      MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();

      StateStorageBasedTeamsConversations stateStorageBasedTeamsConversations =
          new StateStorageBasedTeamsConversations(bfa, mac, new ChannelAccount("42"), tss);

      TeamsAddressable resultTo = mock(TeamsAddressable.class);
      when(resultTo.getKey()).thenReturn("Key");

      // Act
      stateStorageBasedTeamsConversations.ensureRoomRecorded(resultTo);

      // Assert
      verify(tss).retrieve("Key/addressable");
      verify(tss).store(eq("Key/addressable"), isA(Map.class), isA(Map.class));
      verify(resultTo, atLeast(1)).getKey();
    }
  }
}
