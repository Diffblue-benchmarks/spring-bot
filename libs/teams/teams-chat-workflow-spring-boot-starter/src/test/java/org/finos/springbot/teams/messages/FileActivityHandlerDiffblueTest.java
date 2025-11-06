package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import com.microsoft.bot.schema.teams.FileConsentCardResponse;
import com.microsoft.bot.schema.teams.FileUploadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

@ContextConfiguration(classes = {FileActivityHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FileActivityHandlerDiffblueTest {
  @MockBean
  private ActionConsumer actionConsumer;

  @Autowired
  private FileActivityHandler fileActivityHandler;

  @MockBean
  private FormConverter formConverter;

  @MockBean
  private FormValidationProcessor formValidationProcessor;

  @Autowired
  private List<ActionConsumer> list;

  @MockBean
  private TeamsConversations teamsConversations;

  @MockBean
  private TeamsHTMLParser teamsHTMLParser;

  @MockBean
  private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}.
   * <p>
   * Method under test: {@link FileActivityHandler#FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}
   */
  @Test
  @DisplayName("Test new FileActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void FileActivityHandler.<init>(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)"})
  void testNewFileActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(JsonMapper.builder().findAndAddModules().build());

    // Act
    FileActivityHandler actualFileActivityHandler = new FileActivityHandler(messageConsumers, teamsConversations,
        teamsStateStorage, parser, formConverter,
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class)));

    // Assert
    assertTrue(actualFileActivityHandler.formConverter.getObjectMapper() instanceof JsonMapper);
    assertTrue(actualFileActivityHandler.messageConsumers.isEmpty());
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}.
   * <p>
   * Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"})
  void testOnTeamsFileConsentDecline() {
    // Arrange
    BotAdapter withAdapter = mock(BotAdapter.class);
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(new CompletableFuture<>());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity()));

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
    fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}.
   * <p>
   * Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"})
  void testOnTeamsFileConsentDecline2() {
    // Arrange
    BotAdapter withAdapter = mock(BotAdapter.class);
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(new CompletableFuture<>());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(
        new TurnContextImpl(withAdapter, Activity.createConversationUpdateActivity()));

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
    fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}.
   * <ul>
   *   <li>Given {@link ConversationReference} (default constructor) ActivityId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); given ConversationReference (default constructor) ActivityId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"})
  void testOnTeamsFileConsentDecline_givenConversationReferenceActivityIdIs42() {
    // Arrange
    BotAdapter withAdapter = mock(BotAdapter.class);
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(new CompletableFuture<>());

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
    DelegatingTurnContext turnContext = new DelegatingTurnContext(new TurnContextImpl(withAdapter, withActivity));

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
    fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    verify(withActivity).getConversationReference();
    verify(withActivity).getDeliveryMode();
  }

  /**
   * Test {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}.
   * <ul>
   *   <li>Then calls {@link ConversationReference#getActivityId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileActivityHandler#onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)}
   */
  @Test
  @DisplayName("Test onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse); then calls getActivityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture FileActivityHandler.onTeamsFileConsentDecline(TurnContext, FileConsentCardResponse)"})
  void testOnTeamsFileConsentDecline_thenCallsGetActivityId() {
    // Arrange
    BotAdapter withAdapter = mock(BotAdapter.class);
    when(withAdapter.sendActivities(Mockito.<TurnContext>any(), Mockito.<List<Activity>>any()))
        .thenReturn(new CompletableFuture<>());
    ConversationReference conversationReference = mock(ConversationReference.class);
    when(conversationReference.getBot()).thenReturn(new ChannelAccount("42"));
    when(conversationReference.getUser()).thenReturn(new ChannelAccount("42"));
    when(conversationReference.getConversation()).thenReturn(new ConversationAccount("42"));
    when(conversationReference.getActivityId()).thenReturn("42");
    when(conversationReference.getChannelId()).thenReturn("42");
    when(conversationReference.getLocale()).thenReturn("en");
    when(conversationReference.getServiceUrl()).thenReturn("https://example.org/example");
    doNothing().when(conversationReference).setActivityId(Mockito.<String>any());
    doNothing().when(conversationReference).setBot(Mockito.<ChannelAccount>any());
    doNothing().when(conversationReference).setChannelId(Mockito.<String>any());
    doNothing().when(conversationReference).setConversation(Mockito.<ConversationAccount>any());
    doNothing().when(conversationReference).setLocale(Mockito.<String>any());
    doNothing().when(conversationReference).setServiceUrl(Mockito.<String>any());
    doNothing().when(conversationReference).setUser(Mockito.<ChannelAccount>any());
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
    DelegatingTurnContext turnContext = new DelegatingTurnContext(new TurnContextImpl(withAdapter, withActivity));

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
    fileActivityHandler.onTeamsFileConsentDecline(turnContext, fileConsentCardResponse);

    // Assert
    verify(withAdapter).sendActivities(isA(TurnContext.class), isA(List.class));
    verify(withActivity).getConversationReference();
    verify(withActivity).getDeliveryMode();
    verify(conversationReference, atLeast(1)).getActivityId();
    verify(conversationReference).getBot();
    verify(conversationReference).getChannelId();
    verify(conversationReference).getConversation();
    verify(conversationReference, atLeast(1)).getLocale();
    verify(conversationReference).getServiceUrl();
    verify(conversationReference).getUser();
    verify(conversationReference).setActivityId(eq("42"));
    verify(conversationReference).setBot(isA(ChannelAccount.class));
    verify(conversationReference).setChannelId(eq("42"));
    verify(conversationReference).setConversation(isA(ConversationAccount.class));
    verify(conversationReference).setLocale(eq("en"));
    verify(conversationReference).setServiceUrl(eq("https://example.org/example"));
    verify(conversationReference).setUser(isA(ChannelAccount.class));
  }
}
