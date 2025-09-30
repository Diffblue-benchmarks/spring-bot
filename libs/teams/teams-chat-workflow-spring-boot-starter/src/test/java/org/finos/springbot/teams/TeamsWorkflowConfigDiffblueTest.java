package org.finos.springbot.teams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.microsoft.bot.builder.BotAdapter;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.builder.DelegatingTurnContext;
import com.microsoft.bot.builder.TurnContextImpl;
import com.microsoft.bot.builder.teams.TeamsActivityHandler;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.ClasspathPropertiesConfiguration;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.content.serialization.TeamsMarkupWriter;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.form.TeamsFormConverter;
import org.finos.springbot.teams.handlers.ActivityHandler;
import org.finos.springbot.teams.handlers.AttachmentHandler;
import org.finos.springbot.teams.handlers.SimpleActivityHandler;
import org.finos.springbot.teams.handlers.SimpleAttachmentHandler;
import org.finos.springbot.teams.history.StateStorageBasedTeamsHistory;
import org.finos.springbot.teams.history.TeamsHistory;
import org.finos.springbot.teams.messages.FileActivityHandler;
import org.finos.springbot.teams.response.templating.EntityMarkupTemplateProvider;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardTemplateProvider;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplateProvider;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.actions.consumers.AddressingChecker;
import org.finos.springbot.workflow.actions.consumers.InRoomAddressingChecker;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.Validator;

@ExtendWith(MockitoExtension.class)
class TeamsWorkflowConfigDiffblueTest {
  @Mock private EntityJsonConverter entityJsonConverter;

  @InjectMocks private TeamsWorkflowConfig teamsWorkflowConfig;

  @Mock private Validator validator;

  /**
   * Test {@link TeamsWorkflowConfig#teamsMarkupTemplater(String, String, String,
   * TeamsMarkupWriter)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsMarkupTemplater(String, String, String,
   * TeamsMarkupWriter)}
   */
  @Test
  @DisplayName("Test teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityMarkupTemplateProvider TeamsWorkflowConfig.teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)"
  })
  void testTeamsMarkupTemplater() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .teamsMarkupTemplater("Prefix", "Suffix", "Default Name", new TeamsMarkupWriter())
            .getTemplateForName("Name"));
  }

  /**
   * Test {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String,
   * ThymeleafTemplater)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String,
   * ThymeleafTemplater)}
   */
  @Test
  @DisplayName("Test thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ThymeleafTemplateProvider TeamsWorkflowConfig.thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)"
  })
  void testThymeleafWorkTemplater() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater formConverter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .thymeleafWorkTemplater("Prefix", "Suffix", "Default Name", formConverter)
            .getTemplateForName("Name"));
  }

  /**
   * Test {@link TeamsWorkflowConfig#attachmentHandler()}.
   *
   * <ul>
   *   <li>Then return {@link SimpleAttachmentHandler}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#attachmentHandler()}
   */
  @Test
  @DisplayName("Test attachmentHandler(); then return SimpleAttachmentHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttachmentHandler TeamsWorkflowConfig.attachmentHandler()"})
  void testAttachmentHandler_thenReturnSimpleAttachmentHandler() {
    // Arrange, Act and Assert
    assertTrue(teamsWorkflowConfig.attachmentHandler() instanceof SimpleAttachmentHandler);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}.
   *
   * <ul>
   *   <li>When {@link AdaptiveCardTemplateProvider}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}
   */
  @Test
  @DisplayName(
      "Test teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler); when AdaptiveCardTemplateProvider")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.handlers.TeamsResponseHandler TeamsWorkflowConfig.teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler)"
  })
  void testTeamsResponseHandler_whenAdaptiveCardTemplateProvider() {
    // Arrange
    AttachmentHandler attachmentHandler = mock(AttachmentHandler.class);
    EntityMarkupTemplateProvider markupTemplater =
        new EntityMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    AdaptiveCardTemplateProvider formTemplater = mock(AdaptiveCardTemplateProvider.class);
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    ThymeleafTemplateProvider displayTemplater =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);

    // Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        teamsWorkflowConfig
            .teamsResponseHandler(
                attachmentHandler,
                markupTemplater,
                formTemplater,
                displayTemplater,
                new MemoryStateStorage(entityJsonConverter),
                mock(ActivityHandler.class))
            .getOrder());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Order is {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}
   */
  @Test
  @DisplayName(
      "Test teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler); when 'null'; then return Order is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.handlers.TeamsResponseHandler TeamsWorkflowConfig.teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler)"
  })
  void testTeamsResponseHandler_whenNull_thenReturnOrderIsMax_value() {
    // Arrange
    AttachmentHandler attachmentHandler = mock(AttachmentHandler.class);
    EntityMarkupTemplateProvider markupTemplater =
        new EntityMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    ThymeleafTemplateProvider displayTemplater =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);

    // Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        teamsWorkflowConfig
            .teamsResponseHandler(
                attachmentHandler,
                markupTemplater,
                null,
                displayTemplater,
                new MemoryStateStorage(entityJsonConverter),
                mock(ActivityHandler.class))
            .getOrder());
  }

  /**
   * Test {@link TeamsWorkflowConfig#activityHandler(TeamsConversations)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#activityHandler(TeamsConversations)}
   */
  @Test
  @DisplayName("Test activityHandler(TeamsConversations); given EntityJsonConverter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ActivityHandler TeamsWorkflowConfig.activityHandler(TeamsConversations)"})
  void testActivityHandler_givenEntityJsonConverter() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));

    // Act and Assert
    assertTrue(teamsWorkflowConfig.activityHandler(tc) instanceof SimpleActivityHandler);
    assertTrue(tc.getAllAddressables().isEmpty());
    assertTrue(tc.getAllChats().isEmpty());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsStorageIDResponseHandler(TeamsStateStorage)}.
   *
   * <p>Method under test: {@link
   * TeamsWorkflowConfig#teamsStorageIDResponseHandler(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsStorageIDResponseHandler(TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.history.StorageIDResponseHandler TeamsWorkflowConfig.teamsStorageIDResponseHandler(TeamsStateStorage)"
  })
  void testTeamsStorageIDResponseHandler() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MIN_VALUE,
        teamsWorkflowConfig
            .teamsStorageIDResponseHandler(new MemoryStateStorage(entityJsonConverter))
            .getOrder());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsInMemoryStateStorage()}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsInMemoryStateStorage()}
   */
  @Test
  @DisplayName("Test teamsInMemoryStateStorage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsStateStorage TeamsWorkflowConfig.teamsInMemoryStateStorage()"})
  void testTeamsInMemoryStateStorage() {
    // Arrange, Act and Assert
    assertTrue(teamsWorkflowConfig.teamsInMemoryStateStorage() instanceof MemoryStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsInFileStateStorage(String)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsInFileStateStorage(String)}
   */
  @Test
  @DisplayName("Test teamsInFileStateStorage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsStateStorage TeamsWorkflowConfig.teamsInFileStateStorage(String)"})
  void testTeamsInFileStateStorage() {
    // Arrange, Act and Assert
    assertTrue(
        teamsWorkflowConfig.teamsInFileStateStorage("/directory/foo.txt")
            instanceof FileStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsHistory(TeamsStateStorage)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsHistory(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsHistory(TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsHistory TeamsWorkflowConfig.teamsHistory(TeamsStateStorage)"})
  void testTeamsHistory() {
    // Arrange and Act
    TeamsHistory actualTeamsHistoryResult =
        teamsWorkflowConfig.teamsHistory(new MemoryStateStorage(entityJsonConverter));

    // Assert
    assertTrue(actualTeamsHistoryResult instanceof StateStorageBasedTeamsHistory);
    assertTrue(
        ((StateStorageBasedTeamsHistory) actualTeamsHistoryResult).tss
            instanceof MemoryStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsFormConverter(AllConversations)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsFormConverter(AllConversations)}
   */
  @Test
  @DisplayName("Test teamsFormConverter(AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsFormConverter TeamsWorkflowConfig.teamsFormConverter(AllConversations)"})
  void testTeamsFormConverter() {
    // Arrange, Act and Assert
    ObjectMapper objectMapper =
        teamsWorkflowConfig.teamsFormConverter(new AllConversations()).getObjectMapper();
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertEquals(2, objectMapper.getRegisteredModuleIds().size());
    assertSame(factory, objectMapper.getJsonFactory());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler() {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(validator, mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(entityJsonConverter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    TeamsFormConverter fc = new TeamsFormConverter(om);

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, fc);

    // Assert
    ObjectMapper objectMapper = fc.getObjectMapper();
    assertTrue(
        objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(objectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(objectMapper instanceof JsonMapper);
    assertTrue(objectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(objectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(objectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(objectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(objectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(objectMapper.getDateFormat() instanceof StdDateFormat);
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(objectMapper.getInjectableValues());
    assertNull(objectMapper.getPropertyNamingStrategy());
    assertEquals(3, objectMapper.getRegisteredModuleIds().size());
    assertTrue(messageConsumers.isEmpty());
    assertTrue(tc.getAllAddressables().isEmpty());
    assertTrue(tc.getAllChats().isEmpty());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_givenActionConsumer_thenArrayListSizeIsOne()
      throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(validator, mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(entityJsonConverter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    TeamsFormConverter fc = new TeamsFormConverter(om);

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, fc);
    BotFrameworkAdapter withAdapter =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    Activity withActivity = Activity.createContactRelationUpdateActivity();
    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(turnContext);

    // Assert
    assertTrue(fc.getObjectMapper() instanceof JsonMapper);
    BotAdapter adapter = turnContext.getAdapter();
    assertTrue(adapter instanceof BotFrameworkAdapter);
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(turnContext.getLocale());
    assertEquals(1, messageConsumers.size());
    assertNull(actualOnTurnResult.get());
    assertFalse(turnContext.getResponded());
    assertTrue(tc.getAllAddressables().isEmpty());
    assertTrue(tc.getAllChats().isEmpty());
    assertTrue(actualOnTurnResult.isDone());
    assertSame(withAdapter, adapter);
    assertSame(withActivity, turnContext.getActivity());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_givenActionConsumer_thenArrayListSizeIsTwo()
      throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(validator, mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(entityJsonConverter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    TeamsFormConverter fc = new TeamsFormConverter(om);

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, fc);
    BotFrameworkAdapter withAdapter =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    Activity withActivity = Activity.createContactRelationUpdateActivity();
    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(turnContext);

    // Assert
    assertTrue(fc.getObjectMapper() instanceof JsonMapper);
    BotAdapter adapter = turnContext.getAdapter();
    assertTrue(adapter instanceof BotFrameworkAdapter);
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(turnContext.getLocale());
    assertEquals(2, messageConsumers.size());
    assertNull(actualOnTurnResult.get());
    assertFalse(turnContext.getResponded());
    assertTrue(tc.getAllAddressables().isEmpty());
    assertTrue(tc.getAllChats().isEmpty());
    assertTrue(actualOnTurnResult.isDone());
    assertSame(withAdapter, adapter);
    assertSame(withActivity, turnContext.getActivity());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); when ArrayList(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_whenArrayList_thenArrayListEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(validator, mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(entityJsonConverter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    TeamsFormConverter fc = new TeamsFormConverter(om);

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, fc);
    BotFrameworkAdapter withAdapter =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    Activity withActivity = Activity.createContactRelationUpdateActivity();
    TurnContextImpl withTurnContext = new TurnContextImpl(withAdapter, withActivity);
    DelegatingTurnContext turnContext = new DelegatingTurnContext(withTurnContext);
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(turnContext);

    // Assert
    assertTrue(fc.getObjectMapper() instanceof JsonMapper);
    BotAdapter adapter = turnContext.getAdapter();
    assertTrue(adapter instanceof BotFrameworkAdapter);
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(turnContext.getLocale());
    assertNull(actualOnTurnResult.get());
    assertFalse(turnContext.getResponded());
    assertTrue(messageConsumers.isEmpty());
    assertTrue(tc.getAllAddressables().isEmpty());
    assertTrue(tc.getAllChats().isEmpty());
    assertTrue(actualOnTurnResult.isDone());
    assertSame(withAdapter, adapter);
    assertSame(withActivity, turnContext.getActivity());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler,
   * BotFrameworkHttpAdapter)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then calls {@link ClasspathPropertiesConfiguration#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler,
   * BotFrameworkHttpAdapter)}
   */
  @Test
  @DisplayName(
      "Test teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter); given 'Property'; then calls getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.bot.BotController TeamsWorkflowConfig.teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter)"
  })
  void testTeamsBotController_givenProperty_thenCallsGetProperty() {
    // Arrange
    TeamsActivityHandler mah = new TeamsActivityHandler();

    ClasspathPropertiesConfiguration withConfiguration =
        mock(ClasspathPropertiesConfiguration.class);
    when(withConfiguration.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    teamsWorkflowConfig.teamsBotController(mah, new BotFrameworkHttpAdapter(withConfiguration));

    // Assert
    verify(withConfiguration, atLeast(1)).getProperty(Mockito.<String>any());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsAddressingChecker(TeamsConversations)}.
   *
   * <ul>
   *   <li>Then return {@link InRoomAddressingChecker}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsAddressingChecker(TeamsConversations)}
   */
  @Test
  @DisplayName(
      "Test teamsAddressingChecker(TeamsConversations); then return InRoomAddressingChecker")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AddressingChecker TeamsWorkflowConfig.teamsAddressingChecker(TeamsConversations)"
  })
  void testTeamsAddressingChecker_thenReturnInRoomAddressingChecker() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");

    StateStorageBasedTeamsConversations conv =
        new StateStorageBasedTeamsConversations(
            bfa, mac, botAccount, new MemoryStateStorage(entityJsonConverter));

    // Act
    AddressingChecker actualTeamsAddressingCheckerResult =
        teamsWorkflowConfig.teamsAddressingChecker(conv);
    ErrorAction errorAction = new ErrorAction(mock(Addressable.class), "Ej");
    Action actualFilterResult = actualTeamsAddressingCheckerResult.filter(errorAction);

    // Assert
    assertTrue(actualTeamsAddressingCheckerResult instanceof InRoomAddressingChecker);
    assertSame(errorAction, actualFilterResult);
  }
}
