package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsUser;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.content.Addressable;
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

@ContextConfiguration(classes = {MessageActivityHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MessageActivityHandlerDiffblueTest {
  @MockBean
  private ActionConsumer actionConsumer;

  @MockBean
  private FormConverter formConverter;

  @MockBean
  private FormValidationProcessor formValidationProcessor;

  @Autowired
  private List<ActionConsumer> list;

  @Autowired
  private MessageActivityHandler messageActivityHandler;

  @MockBean
  private TeamsConversations teamsConversations;

  @MockBean
  private TeamsHTMLParser teamsHTMLParser;

  @MockBean
  private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link MessageActivityHandler#MessageActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}.
   * <p>
   * Method under test: {@link MessageActivityHandler#MessageActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}
   */
  @Test
  @DisplayName("Test new MessageActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.<init>(java.util.List, org.finos.springbot.teams.conversations.TeamsConversations, org.finos.springbot.teams.state.TeamsStateStorage, org.finos.springbot.teams.content.serialization.TeamsHTMLParser, org.finos.springbot.workflow.form.FormConverter, org.finos.springbot.workflow.form.FormValidationProcessor)"})
  void testNewMessageActivityHandler() {
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
    MessageActivityHandler actualMessageActivityHandler = new MessageActivityHandler(messageConsumers,
        teamsConversations, teamsStateStorage, parser, formConverter,
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class)));

    // Assert
    assertTrue(actualMessageActivityHandler.formConverter.getObjectMapper() instanceof JsonMapper);
    assertTrue(actualMessageActivityHandler.messageConsumers.isEmpty());
  }

  /**
   * Test {@link MessageActivityHandler#onMessageActivity(TurnContext)}.
   * <p>
   * Method under test: {@link MessageActivityHandler#onMessageActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test onMessageActivity(TurnContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.messages.MessageActivityHandler.onMessageActivity(com.microsoft.bot.builder.TurnContext)"})
  void testOnMessageActivity() throws InterruptedException, ExecutionException {
    // Arrange
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());

    // Act
    CompletableFuture<Void> actualOnMessageActivityResult = messageActivityHandler.onMessageActivity(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertNull(actualOnMessageActivityResult.get());
    assertTrue(actualOnMessageActivityResult.isDone());
  }

  /**
   * Test {@link MessageActivityHandler#onMessageActivity(TurnContext)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#onMessageActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test onMessageActivity(TurnContext); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.messages.MessageActivityHandler.onMessageActivity(com.microsoft.bot.builder.TurnContext)"})
  void testOnMessageActivity_whenNull() throws InterruptedException, ExecutionException {
    // Arrange and Act
    CompletableFuture<Void> actualOnMessageActivityResult = messageActivityHandler.onMessageActivity(null);

    // Assert
    assertNull(actualOnMessageActivityResult.get());
    assertTrue(actualOnMessageActivityResult.isDone());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity() {
    // Arrange
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(mock(TeamsAddressable.class));
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());

    // Act
    messageActivityHandler.handleActivity(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given ActionConsumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity_givenActionConsumerAcceptDoesNothing_thenCallsAccept() throws ClassNotFoundException {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    Optional<Map<String, Object>> ofResult = Optional.of(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(ofResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any()))
        .thenReturn(new FormAction(a, u, "Form Data", "Action", new HashMap<>()));
    Activity withActivity = mock(Activity.class);
    when(withActivity.getFrom()).thenReturn(new ChannelAccount("42"));
    when(withActivity.getConversation()).thenReturn(new ConversationAccount("42"));
    when(withActivity.getValue()).thenReturn(new HashMap<>());

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity)));

    // Assert
    verify(withActivity).getConversation();
    verify(withActivity).getFrom();
    verify(withActivity, atLeast(1)).getValue();
    verify(actionConsumer).accept(isA(Action.class));
    verify(teamsConversations).getTeamsAddressable(isA(ConversationAccount.class));
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isA(Object.class),
        isA(Supplier.class));
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <ul>
   *   <li>Given {@link FormValidationProcessor} {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given FormValidationProcessor validationCheck(String, Addressable, Object, Supplier) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity_givenFormValidationProcessorValidationCheckReturnNull() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    Optional<Map<String, Object>> ofResult = Optional.of(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(ofResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any())).thenReturn(null);
    Activity withActivity = mock(Activity.class);
    when(withActivity.getFrom()).thenReturn(new ChannelAccount("42"));
    when(withActivity.getConversation()).thenReturn(new ConversationAccount("42"));
    when(withActivity.getValue()).thenReturn(new HashMap<>());

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity)));

    // Assert
    verify(withActivity).getConversation();
    verify(withActivity).getFrom();
    verify(withActivity, atLeast(1)).getValue();
    verify(teamsConversations).getTeamsAddressable(isA(ConversationAccount.class));
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isA(Object.class),
        isA(Supplier.class));
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <ul>
   *   <li>Given {@link TeamsStateStorage} {@link TeamsStateStorage#retrieve(String)} return empty.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given TeamsStateStorage retrieve(String) return empty; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity_givenTeamsStateStorageRetrieveReturnEmpty_thenCallsAccept() throws ClassNotFoundException {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    Optional<Map<String, Object>> emptyResult = Optional.empty();
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(emptyResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any()))
        .thenReturn(new FormAction(a, u, "Form Data", "Action", new HashMap<>()));
    Activity withActivity = mock(Activity.class);
    when(withActivity.getFrom()).thenReturn(new ChannelAccount("42"));
    when(withActivity.getConversation()).thenReturn(new ConversationAccount("42"));
    when(withActivity.getValue()).thenReturn(new HashMap<>());

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity)));

    // Assert
    verify(withActivity).getConversation();
    verify(withActivity).getFrom();
    verify(withActivity, atLeast(1)).getValue();
    verify(actionConsumer).accept(isA(Action.class));
    verify(teamsConversations).getTeamsAddressable(isA(ConversationAccount.class));
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isA(Object.class),
        isA(Supplier.class));
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <ul>
   *   <li>Given {@link TeamsStateStorage} {@link TeamsStateStorage#retrieve(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given TeamsStateStorage retrieve(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity_givenTeamsStateStorageRetrieveReturnNull() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(null);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    Activity withActivity = mock(Activity.class);
    when(withActivity.getFrom()).thenReturn(new ChannelAccount("42"));
    when(withActivity.getConversation()).thenReturn(new ConversationAccount("42"));
    when(withActivity.getValue()).thenReturn(new HashMap<>());

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity)));

    // Assert
    verify(withActivity).getConversation();
    verify(withActivity).getFrom();
    verify(withActivity, atLeast(1)).getValue();
    verify(teamsConversations).getTeamsAddressable(isA(ConversationAccount.class));
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>When {@link Activity} {@link Activity#getValue()} return {@code Value}.</li>
   *   <li>Then calls {@link Activity#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given 'Value'; when Activity getValue() return 'Value'; then calls getValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.messages.MessageActivityHandler.handleActivity(com.microsoft.bot.builder.TurnContext)"})
  void testHandleActivity_givenValue_whenActivityGetValueReturnValue_thenCallsGetValue() {
    // Arrange
    Activity withActivity = mock(Activity.class);
    when(withActivity.getValue()).thenReturn("Value");

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity)));

    // Assert
    verify(withActivity, atLeast(1)).getValue();
  }

  /**
   * Test {@link MessageActivityHandler#processForm(TurnContext, Activity)}.
   * <p>
   * Method under test: {@link MessageActivityHandler#processForm(TurnContext, Activity)}
   */
  @Test
  @DisplayName("Test processForm(TurnContext, Activity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.FormAction org.finos.springbot.teams.messages.MessageActivityHandler.processForm(com.microsoft.bot.builder.TurnContext, com.microsoft.bot.schema.Activity)"})
  void testProcessForm() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    Optional<Map<String, Object>> ofResult = Optional.of(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(ofResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any())).thenReturn(formAction);
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity()));
    Activity a2 = mock(Activity.class);
    when(a2.getFrom()).thenReturn(new ChannelAccount("42"));
    when(a2.getValue()).thenReturn(new HashMap<>());

    // Act
    FormAction actualProcessFormResult = messageActivityHandler.processForm(turnContext, a2);

    // Assert
    verify(a2).getFrom();
    verify(a2).getValue();
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isA(Object.class),
        isA(Supplier.class));
    assertSame(formAction, actualProcessFormResult);
  }

  /**
   * Test {@link MessageActivityHandler#processForm(TurnContext, Activity)}.
   * <ul>
   *   <li>Given {@link TeamsStateStorage} {@link TeamsStateStorage#retrieve(String)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageActivityHandler#processForm(TurnContext, Activity)}
   */
  @Test
  @DisplayName("Test processForm(TurnContext, Activity); given TeamsStateStorage retrieve(String) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.FormAction org.finos.springbot.teams.messages.MessageActivityHandler.processForm(com.microsoft.bot.builder.TurnContext, com.microsoft.bot.schema.Activity)"})
  void testProcessForm_givenTeamsStateStorageRetrieveReturnEmpty() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any())).thenReturn(teamsAddressable);
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(new TeamsUser("42", "Name", "42"));
    Optional<Map<String, Object>> emptyResult = Optional.empty();
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(emptyResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any())).thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());

    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any())).thenReturn(formAction);
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity()));
    Activity a2 = mock(Activity.class);
    when(a2.getFrom()).thenReturn(new ChannelAccount("42"));
    when(a2.getValue()).thenReturn(new HashMap<>());

    // Act
    FormAction actualProcessFormResult = messageActivityHandler.processForm(turnContext, a2);

    // Assert
    verify(a2).getFrom();
    verify(a2).getValue();
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isA(ChannelAccount.class));
    verify(teamsStateStorage).retrieve(eq("Key/null"));
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isA(Object.class),
        isA(Supplier.class));
    assertSame(formAction, actualProcessFormResult);
  }
}
