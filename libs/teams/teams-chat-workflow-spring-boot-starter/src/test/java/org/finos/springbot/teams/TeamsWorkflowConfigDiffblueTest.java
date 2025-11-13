package org.finos.springbot.teams;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mockito.Mockito;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class TeamsWorkflowConfigDiffblueTest {
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
   * <p>Method under test: {@link TeamsWorkflowConfig#attachmentHandler()}
   */
  @Test
  @DisplayName("Test attachmentHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttachmentHandler TeamsWorkflowConfig.attachmentHandler()"})
  void testAttachmentHandler() {
    // Arrange, Act and Assert
    assertTrue(new TeamsWorkflowConfig().attachmentHandler() instanceof SimpleAttachmentHandler);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsResponseHandler(AttachmentHandler,
   * EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider,
   * TeamsStateStorage, ActivityHandler)}
   */
  @Test
  @DisplayName(
      "Test teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.handlers.TeamsResponseHandler TeamsWorkflowConfig.teamsResponseHandler(AttachmentHandler, EntityMarkupTemplateProvider, AdaptiveCardTemplateProvider, ThymeleafTemplateProvider, TeamsStateStorage, ActivityHandler)"
  })
  void testTeamsResponseHandler() {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
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
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        Integer.MAX_VALUE,
        teamsWorkflowConfig
            .teamsResponseHandler(
                attachmentHandler,
                markupTemplater,
                null,
                displayTemplater,
                new MemoryStateStorage(ejc),
                mock(ActivityHandler.class))
            .getOrder());
  }

  /**
   * Test {@link TeamsWorkflowConfig#activityHandler(TeamsConversations)}.
   *
   * <ul>
   *   <li>Given {@link TeamsWorkflowConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#activityHandler(TeamsConversations)}
   */
  @Test
  @DisplayName(
      "Test activityHandler(TeamsConversations); given TeamsWorkflowConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ActivityHandler TeamsWorkflowConfig.activityHandler(TeamsConversations)"})
  void testActivityHandler_givenTeamsWorkflowConfig() {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    ActivityHandler actualActivityHandlerResult = teamsWorkflowConfig.activityHandler(tc);

    // Assert
    assertTrue(actualActivityHandlerResult instanceof SimpleActivityHandler);
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
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertEquals(
        Integer.MIN_VALUE,
        teamsWorkflowConfig.teamsStorageIDResponseHandler(new MemoryStateStorage(ejc)).getOrder());
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
    assertTrue(new TeamsWorkflowConfig().teamsInMemoryStateStorage() instanceof MemoryStateStorage);
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
        new TeamsWorkflowConfig().teamsInFileStateStorage("/directory/foo.txt")
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
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    TeamsHistory actualTeamsHistoryResult =
        teamsWorkflowConfig.teamsHistory(new MemoryStateStorage(ejc));

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
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
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
   * <ul>
   *   <li>Given {@link ActionConsumer}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ActionConsumer}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; when ArrayList() add ActionConsumer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_givenActionConsumer_whenArrayListAddActionConsumer()
      throws InterruptedException, ExecutionException {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(om3));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(new DelegatingTurnContext(withTurnContext));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ActionConsumer}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; when ArrayList() add ActionConsumer")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_givenActionConsumer_whenArrayListAddActionConsumer2()
      throws InterruptedException, ExecutionException {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(om3));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(new DelegatingTurnContext(withTurnContext));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser,
   * FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName(
      "Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsActivityHandler TeamsWorkflowConfig.teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)"
  })
  void testTeamsActivityHandler_whenArrayList() throws InterruptedException, ExecutionException {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    TeamsHTMLParser parser = new TeamsHTMLParser(mock(ApplicationContext.class));
    FormValidationProcessor fvp =
        new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));
    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc2 = new EntityJsonConverter(om2, new ArrayList<>());
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(ejc2);
    JsonMapper om3 = JsonMapper.builder().findAndAddModules().build();

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult =
        teamsWorkflowConfig.teamsActivityHandler(
            messageConsumers, parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(om3));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider());
    TurnContextImpl withTurnContext =
        new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity());
    CompletableFuture<Void> actualOnTurnResult =
        actualTeamsActivityHandlerResult.onTurn(new DelegatingTurnContext(withTurnContext));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler,
   * BotFrameworkHttpAdapter)}.
   *
   * <p>Method under test: {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler,
   * BotFrameworkHttpAdapter)}
   */
  @Test
  @DisplayName("Test teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.bot.BotController TeamsWorkflowConfig.teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter)"
  })
  void testTeamsBotController() {
    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
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
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations conv =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

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
