package org.finos.springbot.teams.bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.builder.InvokeResponse;
import com.microsoft.bot.connector.authentication.AuthenticationException;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.ClasspathPropertiesConfiguration;
import com.microsoft.bot.schema.Activity;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

class BotControllerDiffblueTest {
  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CompletableFuture<InvokeResponse> completableFuture = new CompletableFuture<>();
    completableFuture.obtrudeValue(new InvokeResponse(1, "With Body"));
    BotFrameworkHttpAdapter withAdapter = mock(BotFrameworkHttpAdapter.class);
    when(withAdapter.processIncomingActivity(Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completableFuture);
    BotController botController = new BotController(withAdapter, mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withAdapter).processIncomingActivity(eq("Auth Header"), isA(Activity.class), isA(Bot.class));
    assertTrue(actualIncomingResult.isDone());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Given {@link ClasspathPropertiesConfiguration} {@link ClasspathPropertiesConfiguration#getProperty(String)} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); given ClasspathPropertiesConfiguration getProperty(String) return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_givenClasspathPropertiesConfigurationGetPropertyReturnEmptyString()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ClasspathPropertiesConfiguration withConfiguration = mock(ClasspathPropertiesConfiguration.class);
    when(withConfiguration.getProperty(Mockito.<String>any())).thenReturn("");
    BotController botController = new BotController(new BotFrameworkHttpAdapter(withConfiguration), mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withConfiguration, atLeast(1)).getProperty(Mockito.<String>any());
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Given {@link ClasspathPropertiesConfiguration} {@link ClasspathPropertiesConfiguration#getProperty(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); given ClasspathPropertiesConfiguration getProperty(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_givenClasspathPropertiesConfigurationGetPropertyReturnNull()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ClasspathPropertiesConfiguration withConfiguration = mock(ClasspathPropertiesConfiguration.class);
    when(withConfiguration.getProperty(Mockito.<String>any())).thenReturn(null);
    BotController botController = new BotController(new BotFrameworkHttpAdapter(withConfiguration), mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withConfiguration, atLeast(1)).getProperty(Mockito.<String>any());
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Given {@link ClasspathPropertiesConfiguration} {@link ClasspathPropertiesConfiguration#getProperty(String)} return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); given ClasspathPropertiesConfiguration getProperty(String) return 'Property'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_givenClasspathPropertiesConfigurationGetPropertyReturnProperty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ClasspathPropertiesConfiguration withConfiguration = mock(ClasspathPropertiesConfiguration.class);
    when(withConfiguration.getProperty(Mockito.<String>any())).thenReturn("Property");
    BotController botController = new BotController(new BotFrameworkHttpAdapter(withConfiguration), mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withConfiguration, atLeast(1)).getProperty(Mockito.<String>any());
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(401, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Then calls {@link InvokeResponse#getBody()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); then calls getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_thenCallsGetBody() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    InvokeResponse invokeResponse = mock(InvokeResponse.class);
    when(invokeResponse.getBody()).thenThrow(new AuthenticationException("An error occurred"));

    CompletableFuture<InvokeResponse> completableFuture = new CompletableFuture<>();
    completableFuture.obtrudeValue(invokeResponse);
    BotFrameworkHttpAdapter withAdapter = mock(BotFrameworkHttpAdapter.class);
    when(withAdapter.processIncomingActivity(Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completableFuture);
    BotController botController = new BotController(withAdapter, mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(invokeResponse).getBody();
    verify(withAdapter).processIncomingActivity(eq("Auth Header"), isA(Activity.class), isA(Bot.class));
    assertTrue(actualIncomingResult.isDone());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Then calls {@link BotFrameworkHttpAdapter#processIncomingActivity(String, Activity, Bot)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); then calls processIncomingActivity(String, Activity, Bot)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_thenCallsProcessIncomingActivity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BotFrameworkHttpAdapter withAdapter = mock(BotFrameworkHttpAdapter.class);
    when(withAdapter.processIncomingActivity(Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(new CompletableFuture<>());
    BotController botController = new BotController(withAdapter, mock(Bot.class));

    // Act
    botController.incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withAdapter).processIncomingActivity(eq("Auth Header"), isA(Activity.class), isA(Bot.class));
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} StatusCodeValue is five hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); then return get() StatusCodeValue is five hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_thenReturnGetStatusCodeValueIsFiveHundred() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CompletableFuture<InvokeResponse> completableFuture = new CompletableFuture<>();
    completableFuture.obtrudeException(new Throwable());
    BotFrameworkHttpAdapter withAdapter = mock(BotFrameworkHttpAdapter.class);
    when(withAdapter.processIncomingActivity(Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completableFuture);
    BotController botController = new BotController(withAdapter, mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withAdapter).processIncomingActivity(eq("Auth Header"), isA(Activity.class), isA(Bot.class));
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(500, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(getResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} StatusCodeValue is two hundred two.</li>
   * </ul>
   * <p>
   * Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String); then return get() StatusCodeValue is two hundred two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.concurrent.CompletableFuture org.finos.springbot.teams.bot.BotController.incoming(com.microsoft.bot.schema.Activity, java.lang.String)"})
  void testIncoming_thenReturnGetStatusCodeValueIsTwoHundredTwo() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    CompletableFuture<InvokeResponse> completableFuture = new CompletableFuture<>();
    completableFuture.obtrudeValue(null);
    BotFrameworkHttpAdapter withAdapter = mock(BotFrameworkHttpAdapter.class);
    when(withAdapter.processIncomingActivity(Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completableFuture);
    BotController botController = new BotController(withAdapter, mock(Bot.class));

    // Act
    CompletableFuture<ResponseEntity<Object>> actualIncomingResult = botController
        .incoming(Activity.createContactRelationUpdateActivity(), "Auth Header");

    // Assert
    verify(withAdapter).processIncomingActivity(eq("Auth Header"), isA(Activity.class), isA(Bot.class));
    ResponseEntity<Object> getResult = actualIncomingResult.get();
    HttpStatusCode statusCode = getResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(getResult.getBody());
    assertEquals(202, getResult.getStatusCodeValue());
    assertEquals(HttpStatus.ACCEPTED, statusCode);
    assertFalse(getResult.hasBody());
    assertTrue(getResult.getHeaders().isEmpty());
  }
}
