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
import org.finos.springbot.teams.bot.BotController;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.content.serialization.TeamsMarkupWriter;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.form.TeamsFormConverter;
import org.finos.springbot.teams.history.StateStorageBasedTeamsHistory;
import org.finos.springbot.teams.history.TeamsHistory;
import org.finos.springbot.teams.messages.FileActivityHandler;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater;
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
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class TeamsWorkflowConfigDiffblueTest {
  /**
   * Test {@link TeamsWorkflowConfig#teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)}
   */
  @Test
  @DisplayName("Test teamsMarkupTemplater(String, String, String, TeamsMarkupWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.response.templating.EntityMarkupTemplateProvider org.finos.springbot.teams.TeamsWorkflowConfig.teamsMarkupTemplater(java.lang.String, java.lang.String, java.lang.String, org.finos.springbot.teams.content.serialization.TeamsMarkupWriter)"})
  void testTeamsMarkupTemplater() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
    assertNull(teamsWorkflowConfig.teamsMarkupTemplater("Prefix", "Suffix", "Default Name", new TeamsMarkupWriter())
        .getTemplateForName("Name"));
  }

  /**
   * Test {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}.
   * <ul>
   *   <li>When {@code TeamsWorkflowConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}
   */
  @Test
  @DisplayName("Test thymeleafWorkTemplater(String, String, String, ThymeleafTemplater); when 'org.finos.springbot.teams.TeamsWorkflowConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplateProvider org.finos.springbot.teams.TeamsWorkflowConfig.thymeleafWorkTemplater(java.lang.String, java.lang.String, java.lang.String, org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater)"})
  void testThymeleafWorkTemplater_whenOrgFinosSpringbotTeamsTeamsWorkflowConfig() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .thymeleafWorkTemplater("org.finos.springbot.teams.TeamsWorkflowConfig", "Suffix", "Default Name",
                new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()))
            .getTemplateForName("Name"));
  }

  /**
   * Test {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}.
   * <ul>
   *   <li>When {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#thymeleafWorkTemplater(String, String, String, ThymeleafTemplater)}
   */
  @Test
  @DisplayName("Test thymeleafWorkTemplater(String, String, String, ThymeleafTemplater); when 'Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplateProvider org.finos.springbot.teams.TeamsWorkflowConfig.thymeleafWorkTemplater(java.lang.String, java.lang.String, java.lang.String, org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater)"})
  void testThymeleafWorkTemplater_whenPrefix() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();

    // Act and Assert
    assertNull(
        teamsWorkflowConfig
            .thymeleafWorkTemplater("Prefix", "Suffix", "Default Name",
                new ThymeleafTemplater(fieldConverters, new ThymeleafRendering()))
            .getTemplateForName("Name"));
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsStorageIDResponseHandler(TeamsStateStorage)}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsStorageIDResponseHandler(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsStorageIDResponseHandler(TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.history.StorageIDResponseHandler org.finos.springbot.teams.TeamsWorkflowConfig.teamsStorageIDResponseHandler(org.finos.springbot.teams.state.TeamsStateStorage)"})
  void testTeamsStorageIDResponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertEquals(Integer.MIN_VALUE,
        teamsWorkflowConfig
            .teamsStorageIDResponseHandler(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))
            .getOrder());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsInMemoryStateStorage()}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsInMemoryStateStorage()}
   */
  @Test
  @DisplayName("Test teamsInMemoryStateStorage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.state.TeamsStateStorage org.finos.springbot.teams.TeamsWorkflowConfig.teamsInMemoryStateStorage()"})
  void testTeamsInMemoryStateStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new TeamsWorkflowConfig()).teamsInMemoryStateStorage() instanceof MemoryStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsInFileStateStorage(String)}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsInFileStateStorage(String)}
   */
  @Test
  @DisplayName("Test teamsInFileStateStorage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.state.TeamsStateStorage org.finos.springbot.teams.TeamsWorkflowConfig.teamsInFileStateStorage(java.lang.String)"})
  void testTeamsInFileStateStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new TeamsWorkflowConfig()).teamsInFileStateStorage("/directory/foo.txt") instanceof FileStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsHistory(TeamsStateStorage)}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsHistory(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsHistory(TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.history.TeamsHistory org.finos.springbot.teams.TeamsWorkflowConfig.teamsHistory(org.finos.springbot.teams.state.TeamsStateStorage)"})
  void testTeamsHistory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    TeamsHistory actualTeamsHistoryResult = teamsWorkflowConfig
        .teamsHistory(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualTeamsHistoryResult instanceof StateStorageBasedTeamsHistory);
    assertTrue(((StateStorageBasedTeamsHistory) actualTeamsHistoryResult).tss instanceof MemoryStateStorage);
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsFormConverter(AllConversations)}.
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsFormConverter(AllConversations)}
   */
  @Test
  @DisplayName("Test teamsFormConverter(AllConversations)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.form.TeamsFormConverter org.finos.springbot.teams.TeamsWorkflowConfig.teamsFormConverter(org.finos.springbot.workflow.conversations.AllConversations)"})
  void testTeamsFormConverter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    // Act and Assert
    ObjectMapper objectMapper = teamsWorkflowConfig.teamsFormConverter(new AllConversations()).getObjectMapper();
    JsonFactory factory = objectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(objectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
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
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   * <ul>
   *   <li>Given {@link ActionConsumer}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ActionConsumer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName("Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; when ArrayList() add ActionConsumer")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.microsoft.bot.builder.teams.TeamsActivityHandler org.finos.springbot.teams.TeamsWorkflowConfig.teamsActivityHandler(java.util.List, org.finos.springbot.teams.content.serialization.TeamsHTMLParser, org.finos.springbot.workflow.form.FormValidationProcessor, org.finos.springbot.teams.conversations.TeamsConversations, org.finos.springbot.teams.state.TeamsStateStorage, org.finos.springbot.teams.form.TeamsFormConverter)"})
  void testTeamsActivityHandler_givenActionConsumer_whenArrayListAddActionConsumer()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(JsonMapper.builder().findAndAddModules().build()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   * <ul>
   *   <li>Given {@link ActionConsumer}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ActionConsumer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName("Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); given ActionConsumer; when ArrayList() add ActionConsumer")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.microsoft.bot.builder.teams.TeamsActivityHandler org.finos.springbot.teams.TeamsWorkflowConfig.teamsActivityHandler(java.util.List, org.finos.springbot.teams.content.serialization.TeamsHTMLParser, org.finos.springbot.workflow.form.FormValidationProcessor, org.finos.springbot.teams.conversations.TeamsConversations, org.finos.springbot.teams.state.TeamsStateStorage, org.finos.springbot.teams.form.TeamsFormConverter)"})
  void testTeamsActivityHandler_givenActionConsumer_whenArrayListAddActionConsumer2()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    messageConsumers.add(mock(ActionConsumer.class));
    messageConsumers.add(mock(ActionConsumer.class));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(JsonMapper.builder().findAndAddModules().build()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter)}
   */
  @Test
  @DisplayName("Test teamsActivityHandler(List, TeamsHTMLParser, FormValidationProcessor, TeamsConversations, TeamsStateStorage, TeamsFormConverter); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.microsoft.bot.builder.teams.TeamsActivityHandler org.finos.springbot.teams.TeamsWorkflowConfig.teamsActivityHandler(java.util.List, org.finos.springbot.teams.content.serialization.TeamsHTMLParser, org.finos.springbot.workflow.form.FormValidationProcessor, org.finos.springbot.teams.conversations.TeamsConversations, org.finos.springbot.teams.state.TeamsStateStorage, org.finos.springbot.teams.form.TeamsFormConverter)"})
  void testTeamsActivityHandler_whenArrayList() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormValidationProcessor fvp = new FormValidationProcessor(new CustomValidatorBean(), mock(ResponseHandlers.class));

    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    StateStorageBasedTeamsConversations tc = new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    JsonMapper om2 = JsonMapper.builder().findAndAddModules().build();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om2, new ArrayList<>()));

    // Act
    TeamsActivityHandler actualTeamsActivityHandlerResult = teamsWorkflowConfig.teamsActivityHandler(messageConsumers,
        parser, fvp, tc, teamsStateStorage, new TeamsFormConverter(JsonMapper.builder().findAndAddModules().build()));
    BotFrameworkAdapter withAdapter = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    CompletableFuture<Void> actualOnTurnResult = actualTeamsActivityHandlerResult.onTurn(
        new DelegatingTurnContext(new TurnContextImpl(withAdapter, Activity.createContactRelationUpdateActivity())));

    // Assert
    assertTrue(actualTeamsActivityHandlerResult instanceof FileActivityHandler);
    assertNull(actualOnTurnResult.get());
    assertTrue(actualOnTurnResult.isDone());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter)}.
   * <ul>
   *   <li>Then incoming {@code null} and {@code Auth Header} StatusCode return {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter)}
   */
  @Test
  @DisplayName("Test teamsBotController(TeamsActivityHandler, BotFrameworkHttpAdapter); then incoming 'null' and 'Auth Header' StatusCode return HttpStatus")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.bot.BotController org.finos.springbot.teams.TeamsWorkflowConfig.teamsBotController(com.microsoft.bot.builder.teams.TeamsActivityHandler, com.microsoft.bot.integration.BotFrameworkHttpAdapter)"})
  void testTeamsBotController_thenIncomingNullAndAuthHeaderStatusCodeReturnHttpStatus()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    TeamsActivityHandler mah = new TeamsActivityHandler();
    ClasspathPropertiesConfiguration withConfiguration = mock(ClasspathPropertiesConfiguration.class);
    when(withConfiguration.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    BotController actualTeamsBotControllerResult = teamsWorkflowConfig.teamsBotController(mah,
        new BotFrameworkHttpAdapter(withConfiguration));

    // Assert
    verify(withConfiguration, atLeast(1)).getProperty(Mockito.<String>any());
    CompletableFuture<ResponseEntity<Object>> incomingResult = actualTeamsBotControllerResult.incoming(null,
        "Auth Header");
    ResponseEntity<Object> getResult = incomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(500, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(incomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link TeamsWorkflowConfig#teamsAddressingChecker(TeamsConversations)}.
   * <ul>
   *   <li>Then return {@link InRoomAddressingChecker}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsWorkflowConfig#teamsAddressingChecker(TeamsConversations)}
   */
  @Test
  @DisplayName("Test teamsAddressingChecker(TeamsConversations); then return InRoomAddressingChecker")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.actions.consumers.AddressingChecker org.finos.springbot.teams.TeamsWorkflowConfig.teamsAddressingChecker(org.finos.springbot.teams.conversations.TeamsConversations)"})
  void testTeamsAddressingChecker_thenReturnInRoomAddressingChecker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsWorkflowConfig teamsWorkflowConfig = new TeamsWorkflowConfig();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    AddressingChecker actualTeamsAddressingCheckerResult = teamsWorkflowConfig
        .teamsAddressingChecker(new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));
    ErrorAction errorAction = new ErrorAction(mock(Addressable.class), "Ej");

    // Assert
    assertTrue(actualTeamsAddressingCheckerResult instanceof InRoomAddressingChecker);
    assertSame(errorAction, actualTeamsAddressingCheckerResult.filter(errorAction));
  }
}
