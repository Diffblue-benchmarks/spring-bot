package org.finos.springbot.teams.messages;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

@ContextConfiguration(classes = {MessageActivityHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class MessageActivityHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @MockitoBean private FormConverter formConverter;

  @MockitoBean private FormValidationProcessor formValidationProcessor;

  @Autowired private List<ActionConsumer> list;

  @Autowired private MessageActivityHandler messageActivityHandler;

  @MockitoBean private TeamsConversations teamsConversations;

  @MockitoBean private TeamsHTMLParser teamsHTMLParser;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link MessageActivityHandler#MessageActivityHandler(List, TeamsConversations,
   * TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)}.
   *
   * <p>Method under test: {@link MessageActivityHandler#MessageActivityHandler(List,
   * TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter,
   * FormValidationProcessor)}
   */
  @Test
  @DisplayName(
      "Test new MessageActivityHandler(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MessageActivityHandler.<init>(List, TeamsConversations, TeamsStateStorage, TeamsHTMLParser, FormConverter, FormValidationProcessor)"
  })
  void testNewMessageActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
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
    MessageActivityHandler actualMessageActivityHandler =
        new MessageActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);

    // Assert
    assertTrue(actualMessageActivityHandler.formConverter.getObjectMapper() instanceof JsonMapper);
    assertTrue(actualMessageActivityHandler.messageConsumers.isEmpty());
  }

  /**
   * Test {@link MessageActivityHandler#onMessageActivity(TurnContext)}.
   *
   * <p>Method under test: {@link MessageActivityHandler#onMessageActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test onMessageActivity(TurnContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture MessageActivityHandler.onMessageActivity(TurnContext)"})
  void testOnMessageActivity() throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
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

    MessageActivityHandler messageActivityHandler =
        new MessageActivityHandler(
            messageConsumers,
            teamsConversations,
            teamsStateStorage,
            parser,
            formConverter,
            validationProcessor);
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());

    // Act
    CompletableFuture<Void> actualOnMessageActivityResult =
        messageActivityHandler.onMessageActivity(new DelegatingTurnContext(withTurnContext));

    // Assert
    assertNull(actualOnMessageActivityResult.get());
    assertTrue(actualOnMessageActivityResult.isDone());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link ActionConsumer#accept(Object)} does nothing.
   *   <li>Then calls {@link ActionConsumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName(
      "Test handleActivity(TurnContext); given ActionConsumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageActivityHandler.handleActivity(TurnContext)"})
  void testHandleActivity_givenActionConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(mock(TeamsAddressable.class));
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(teamsUser);

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setText("\\n");
    TurnContextImpl withTurnContext =
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity);

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(withTurnContext));

    // Assert
    verify(actionConsumer).accept(isA(Action.class));
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer}.
   *   <li>Then calls {@link TeamsConversations#getTeamsAddressable(ConversationAccount)}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName(
      "Test handleActivity(TurnContext); given ActionConsumer; then calls getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageActivityHandler.handleActivity(TurnContext)"})
  void testHandleActivity_givenActionConsumer_thenCallsGetTeamsAddressable() {
    // Arrange
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(mock(TeamsAddressable.class));
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(teamsUser);
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(withTurnContext));

    // Assert
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName("Test handleActivity(TurnContext); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageActivityHandler.handleActivity(TurnContext)"})
  void testHandleActivity_givenArrayList() {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(mock(TeamsAddressable.class));
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(teamsUser);

    Activity withActivity = Activity.createContactRelationUpdateActivity();
    withActivity.setAttachments(new ArrayList<>());
    withActivity.setText("\\n");
    TurnContextImpl withTurnContext =
        new TurnContextImpl(new BotFrameworkAdapter(new SimpleCredentialProvider()), withActivity);

    // Act
    messageActivityHandler.handleActivity(new DelegatingTurnContext(withTurnContext));

    // Assert
    verify(actionConsumer).accept(isA(Action.class));
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
  }

  /**
   * Test {@link MessageActivityHandler#handleActivity(TurnContext)}.
   *
   * <ul>
   *   <li>Given {@link TeamsConversations}.
   *   <li>Then calls {@link TurnContextImpl#getActivity()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#handleActivity(TurnContext)}
   */
  @Test
  @DisplayName(
      "Test handleActivity(TurnContext); given TeamsConversations; then calls getActivity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageActivityHandler.handleActivity(TurnContext)"})
  void testHandleActivity_givenTeamsConversations_thenCallsGetActivity() {
    // Arrange
    TurnContextImpl turnContext = mock(TurnContextImpl.class);
    when(turnContext.getActivity()).thenReturn(null);

    // Act
    messageActivityHandler.handleActivity(turnContext);

    // Assert
    verify(turnContext).getActivity();
  }

  /**
   * Test {@link MessageActivityHandler#processForm(TurnContext, Activity)}.
   *
   * <p>Method under test: {@link MessageActivityHandler#processForm(TurnContext, Activity)}
   */
  @Test
  @DisplayName("Test processForm(TurnContext, Activity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FormAction MessageActivityHandler.processForm(TurnContext, Activity)"})
  void testProcessForm() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(teamsAddressable);
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(teamsUser);
    Optional<Map<String, Object>> emptyResult = Optional.empty();
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(emptyResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any()))
        .thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());
    when(formValidationProcessor.validationCheck(
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Object>any(),
            Mockito.<Supplier<FormAction>>any()))
        .thenReturn(formAction);

    TurnContextImpl turnContext = mock(TurnContextImpl.class);
    when(turnContext.getActivity()).thenReturn(Activity.createContactRelationUpdateActivity());

    Activity a2 = Activity.createContactRelationUpdateActivity();
    a2.setValue(new HashMap<>());

    // Act
    FormAction actualProcessFormResult = messageActivityHandler.processForm(turnContext, a2);

    // Assert
    verify(turnContext).getActivity();
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
    verify(teamsStateStorage).retrieve("Key/null");
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor)
        .validationCheck(isNull(), isA(Addressable.class), isA(Object.class), isA(Supplier.class));
    assertSame(formAction, actualProcessFormResult);
  }

  /**
   * Test {@link MessageActivityHandler#processForm(TurnContext, Activity)}.
   *
   * <ul>
   *   <li>Then calls {@link TeamsConversations#getTeamsAddressable(ConversationAccount)}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#processForm(TurnContext, Activity)}
   */
  @Test
  @DisplayName(
      "Test processForm(TurnContext, Activity); then calls getTeamsAddressable(ConversationAccount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FormAction MessageActivityHandler.processForm(TurnContext, Activity)"})
  void testProcessForm_thenCallsGetTeamsAddressable() throws ClassNotFoundException {
    // Arrange
    TeamsAddressable teamsAddressable = mock(TeamsAddressable.class);
    when(teamsAddressable.getKey()).thenReturn("Key");
    when(teamsConversations.getTeamsAddressable(Mockito.<ConversationAccount>any()))
        .thenReturn(teamsAddressable);
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    when(teamsConversations.getUser(Mockito.<ChannelAccount>any())).thenReturn(teamsUser);
    Optional<Map<String, Object>> ofResult = Optional.of(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<String>any())).thenReturn(ofResult);
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any()))
        .thenReturn("Convert");
    Addressable a = mock(Addressable.class);
    TeamsUser u = new TeamsUser("42", "Name", "42");

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());
    when(formValidationProcessor.validationCheck(
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Object>any(),
            Mockito.<Supplier<FormAction>>any()))
        .thenReturn(formAction);
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    Activity a2 = Activity.createContactRelationUpdateActivity();
    a2.setValue(new HashMap<>());

    // Act
    messageActivityHandler.processForm(turnContext, a2);

    // Assert
    verify(teamsConversations).getTeamsAddressable(isNull());
    verify(teamsConversations).getUser(isNull());
    verify(teamsStateStorage).retrieve("Key/null");
    verify(teamsAddressable).getKey();
    verify(formConverter).convert(isA(Map.class), isNull());
    verify(formValidationProcessor)
        .validationCheck(isNull(), isA(Addressable.class), isA(Object.class), isA(Supplier.class));
  }

  /**
   * Test {@link MessageActivityHandler#processForm(TurnContext, Activity)}.
   *
   * <ul>
   *   <li>Then throw {@link ClassNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageActivityHandler#processForm(TurnContext, Activity)}
   */
  @Test
  @DisplayName("Test processForm(TurnContext, Activity); then throw ClassNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FormAction MessageActivityHandler.processForm(TurnContext, Activity)"})
  void testProcessForm_thenThrowClassNotFoundException() throws ClassNotFoundException {
    // Arrange
    when(formConverter.convert(Mockito.<Map<String, Object>>any(), Mockito.<String>any()))
        .thenThrow(new ClassNotFoundException());
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);

    Activity a = Activity.createContactRelationUpdateActivity();
    a.setValue(new HashMap<>());

    // Act and Assert
    assertThrows(
        ClassNotFoundException.class, () -> messageActivityHandler.processForm(turnContext, a));
    verify(formConverter).convert(isA(Map.class), isNull());
  }
}
