package org.finos.springbot.teams.bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleChannelProvider;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.messages.FileActivityHandler;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.CustomValidatorBean;

class BotControllerDiffblueTest {
  /**
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  void testIncoming() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    BotFrameworkHttpAdapter withAdapter = new BotFrameworkHttpAdapter(withCredentialProvider,
        new SimpleChannelProvider("With Channel Service"));

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(null));

    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(new ObjectMapper());
    BotController botController = new BotController(withAdapter,
        new FileActivityHandler(messageConsumers, teamsConversations, teamsStateStorage, parser, formConverter,
            new FormValidationProcessor(new CustomValidatorBean(), null)));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(actualIncomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  void testIncoming2() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    BotFrameworkHttpAdapter withAdapter = new BotFrameworkHttpAdapter(withCredentialProvider,
        new SimpleChannelProvider(null));

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(null));

    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(new ObjectMapper());
    BotController botController = new BotController(withAdapter,
        new FileActivityHandler(messageConsumers, teamsConversations, teamsStateStorage, parser, formConverter,
            new FormValidationProcessor(new CustomValidatorBean(), null)));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(actualIncomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  void testIncoming3() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    BotFrameworkHttpAdapter withAdapter = new BotFrameworkHttpAdapter(withCredentialProvider,
        new SimpleChannelProvider(""));

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(null));

    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(new ObjectMapper());
    BotController botController = new BotController(withAdapter,
        new FileActivityHandler(messageConsumers, teamsConversations, teamsStateStorage, parser, formConverter,
            new FormValidationProcessor(new CustomValidatorBean(), null)));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(actualIncomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  void testIncoming4() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    BotFrameworkHttpAdapter withAdapter = new BotFrameworkHttpAdapter(withCredentialProvider,
        new SimpleChannelProvider("With Channel Service"));

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(null));

    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(new ObjectMapper());

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = (new BotController(withAdapter,
        new FileActivityHandler(messageConsumers, teamsConversations, teamsStateStorage, parser, formConverter,
            new FormValidationProcessor(new CustomValidatorBean(), null))))
        .incoming(null, "Auth Header");

    // Assert
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(500, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(actualIncomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  void testIncoming5() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SimpleCredentialProvider withCredentialProvider = new SimpleCredentialProvider("42", "iloveyou");

    BotFrameworkHttpAdapter withAdapter = new BotFrameworkHttpAdapter(withCredentialProvider,
        new SimpleChannelProvider("With Channel Service"));

    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    StateStorageBasedTeamsConversations teamsConversations = new StateStorageBasedTeamsConversations(bfa, mac,
        botAccount, new MemoryStateStorage(null));

    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage teamsStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    TeamsHTMLParser parser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    FormConverter formConverter = new FormConverter(new ObjectMapper());
    BotController botController = new BotController(withAdapter,
        new FileActivityHandler(messageConsumers, teamsConversations, teamsStateStorage, parser, formConverter,
            new FormValidationProcessor(new CustomValidatorBean(), null)));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), null);

    // Assert
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(actualIncomingResult.isDone());
    assertTrue(getResult.getHeaders().isEmpty());
  }
}
