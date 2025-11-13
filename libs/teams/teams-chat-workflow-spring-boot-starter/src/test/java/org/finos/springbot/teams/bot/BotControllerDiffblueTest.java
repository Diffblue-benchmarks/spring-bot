package org.finos.springbot.teams.bot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.builder.InvokeResponse;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.schema.Activity;
import java.util.concurrent.CompletableFuture;
import org.finos.springbot.teams.controller.TeamsHandlerMappingTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BotController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BotControllerDiffblueTest {
  @MockitoBean private Bot bot;

  @Autowired private BotController botController;

  @MockitoBean private BotFrameworkHttpAdapter botFrameworkHttpAdapter;

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   *
   * <p>Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture BotController.incoming(Activity, String)"})
  void testIncoming() throws Exception {
    // Arrange
    CompletableFuture<InvokeResponse> completedFutureResult =
        CompletableFuture.completedFuture(new InvokeResponse(1, "With Body"));
    when(botFrameworkHttpAdapter.processIncomingActivity(
            Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completedFutureResult);

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/messages")
            .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(Activity.createContactRelationUpdateActivity()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(botController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   *
   * <p>Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture BotController.incoming(Activity, String)"})
  void testIncoming2() throws Exception {
    // Arrange
    CompletableFuture<InvokeResponse> completedFutureResult =
        CompletableFuture.completedFuture(null);
    when(botFrameworkHttpAdapter.processIncomingActivity(
            Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(completedFutureResult);

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/messages")
            .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(Activity.createContactRelationUpdateActivity()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(botController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   *
   * <p>Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture BotController.incoming(Activity, String)"})
  void testIncoming3() throws Exception {
    // Arrange
    when(botFrameworkHttpAdapter.processIncomingActivity(
            Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(new CompletableFuture<>());

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/messages")
            .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(Activity.createContactRelationUpdateActivity()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(botController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link BotController#incoming(Activity, String)}.
   *
   * <p>Method under test: {@link BotController#incoming(Activity, String)}
   */
  @Test
  @DisplayName("Test incoming(Activity, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CompletableFuture BotController.incoming(Activity, String)"})
  void testIncoming4() throws Exception {
    // Arrange
    CompletableFuture<InvokeResponse> failedResult =
        TeamsHandlerMappingTest.failed(new Throwable());
    when(botFrameworkHttpAdapter.processIncomingActivity(
            Mockito.<String>any(), Mockito.<Activity>any(), Mockito.<Bot>any()))
        .thenReturn(failedResult);

    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/messages")
            .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(Activity.createContactRelationUpdateActivity()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(botController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
