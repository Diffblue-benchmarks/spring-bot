package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotAdapter;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ConversationAccount;
import com.microsoft.bot.schema.ConversationReference;
import com.microsoft.bot.schema.ResourceResponse;
import com.microsoft.bot.schema.teams.FileConsentCardResponse;
import com.microsoft.bot.schema.teams.FileUploadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

@ContextConfiguration(classes = {FileActivityHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FileActivityHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @Autowired private FileActivityHandler fileActivityHandler;

  @MockitoBean private FormConverter formConverter;

  @MockitoBean private FormValidationProcessor formValidationProcessor;

  @Autowired private List<ActionConsumer> list;

  @MockitoBean private TeamsConversations teamsConversations;

  @MockitoBean private TeamsHTMLParser teamsHTMLParser;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations,
   * TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}.
   *
   * <p>Method under test: {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations,
   * TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}
   */
  @Test
  @DisplayName(
      "Test new FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileActivityHandler.<init>(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)"
  })
  void testNewFileActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    // Act
    FileActivityHandler actualFileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    // Assert
    assertTrue(actualFileActivityHandler.formConverter.getObjectMapper() instanceof JsonMapper);
    assertTrue(actualFileActivityHandler.messageConsumers.isEmpty());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline() throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    FileActivityHandler fileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    BotAdapter withAdapter = mock(BotAdapter.class);
    CompletableFuture<ResourceResponse[]> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse[] {new ResourceResponse("42")});
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(completedFutureResult);
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setUploadInfo(withUploadInfo);
    fileConsentCardResponse.setContext(new HashMap<>());

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    assertNull(actualOnTeamsFileConsentDeclineResult.get());
    assertTrue(turnContext.getResponded());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline2() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    FileActivityHandler fileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    BotAdapter withAdapter = mock(BotAdapter.class);
    CompletableFuture<ResourceResponse[]> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse[] {null});
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(completedFutureResult);
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setUploadInfo(withUploadInfo);
    fileConsentCardResponse.setContext(new HashMap<>());

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    assertFalse(turnContext.getResponded());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline_given42() throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    FileActivityHandler fileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    BotAdapter withAdapter = mock(BotAdapter.class);
    CompletableFuture<ResourceResponse[]> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse[] {new ResourceResponse("42")});
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(completedFutureResult);

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setId("42");

    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setUploadInfo(withUploadInfo);
    fileConsentCardResponse.setContext(new HashMap<>());

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    assertNull(actualOnTeamsFileConsentDeclineResult.get());
    assertTrue(turnContext.getResponded());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <ul>
   *   <li>Given {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); given 'en'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline_givenEn() throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    FileActivityHandler fileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    BotAdapter withAdapter = mock(BotAdapter.class);
    CompletableFuture<ResourceResponse[]> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse[] {new ResourceResponse("42")});
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(completedFutureResult);

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setLocale("en");

    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setUploadInfo(withUploadInfo);
    fileConsentCardResponse.setContext(new HashMap<>());

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    assertNull(actualOnTeamsFileConsentDeclineResult.get());
    assertTrue(turnContext.getResponded());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link Activity#getConversationReference()}.
   * </ul>
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName(
      "Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); then calls getConversationReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline_thenCallsGetConversationReference()
      throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations teamsConversations =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();
    FormConverter formConverter = new FormConverter(om3);
    FormValidationProcessor validationProcessor =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    FileActivityHandler fileActivityHandler =
        new FileActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    BotAdapter withAdapter = mock(BotAdapter.class);
    CompletableFuture<ResourceResponse[]> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse[] {new ResourceResponse("42")});
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(completedFutureResult);

    ConversationReference conversationReference = new ConversationReference();
    conversationReference.setActivityId("42");
    conversationReference.setBot(new ChannelAccount("42"));
    conversationReference.setChannelId("42");
    conversationReference.setConversation(new ConversationAccount("42"));
    conversationReference.setLocale("en");
    conversationReference.setServiceUrl("https://example.org/example");
    conversationReference.setUser(new ChannelAccount("42"));

    Activity withActivity = mock(Activity.class);
    when(withActivity.getDeliveryMode()).thenReturn("Delivery Mode");
    when(withActivity.getConversationReference()).thenReturn(conversationReference);

    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setUploadInfo(withUploadInfo);
    fileConsentCardResponse.setContext(new HashMap<>());

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    verify(withActivity).getConversationReference();
    verify(withActivity).getDeliveryMode();
    assertNull(actualOnTeamsFileConsentDeclineResult.get());
    assertTrue(turnContext.getResponded());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link TurnContextImpl#sendActivity(Activity)}.
   * </ul>
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName(
      "Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); then calls sendActivity(Activity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline_thenCallsSendActivity()
      throws InterruptedException, ExecutionException {
    // Arrange
    TurnContextImpl withTurnContext = mock(TurnContextImpl.class);
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse("42"));
    when(withTurnContext.sendActivity(Mockito.<Activity>any())).thenReturn(completedFutureResult);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setContext(new HashMap<>());
    fileConsentCardResponse.setUploadInfo(withUploadInfo);

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withTurnContext).sendActivity(isA(Activity.class));
    assertNull(actualOnTeamsFileConsentDeclineResult.get());
    assertTrue(actualOnTeamsFileConsentDeclineResult.isDone());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}.
   *
   * <ul>
   *   <li>Then return completedFuture {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext,
   * FileConsentCardResponse)}
   */
  @Test
  @DisplayName(
      "Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); then return completedFuture 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"
  })
  void testOnTeamsFileConsentDecline_thenReturnCompletedFutureNull() {
    // Arrange
    TurnContext turnContext = mock(TurnContext.class);
    CompletableFuture<Void> completedFutureResult = CompletableFuture.completedFuture(null);
    when(turnContext.sendActivityBlind(Mockito.<Activity>any())).thenReturn(completedFutureResult);

    FileUploadInfo withUploadInfo = new FileUploadInfo();
    withUploadInfo.setContentUrl("https://example.org/example");
    withUploadInfo.setFileType("With File Type");
    withUploadInfo.setName("With Name");
    withUploadInfo.setUniqueId("42");
    withUploadInfo.setUploadUrl("https://example.org/example");

    FileConsentCardResponse fileConsentCardResponse = new FileConsentCardResponse();
    fileConsentCardResponse.setAction("With Action");
    fileConsentCardResponse.setContext(new HashMap<>());
    fileConsentCardResponse.setUploadInfo(withUploadInfo);

    // Act
    CompletableFuture<Void> actualOnTeamsFileConsentDeclineResult =
        fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(turnContext).sendActivityBlind(isA(Activity.class));
    assertSame(completedFutureResult, actualOnTeamsFileConsentDeclineResult);
  }
}
