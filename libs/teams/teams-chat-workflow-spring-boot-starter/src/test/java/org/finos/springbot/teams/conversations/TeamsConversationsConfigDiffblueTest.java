package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.integration.AdapterWithErrorHandler;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import java.util.ArrayList;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.StandardEnvironment;

@ExtendWith(MockitoExtension.class)
class TeamsConversationsConfigDiffblueTest {
  @Mock
  private ApplicationContext applicationContext;

  @InjectMocks
  private TeamsConversationsConfig teamsConversationsConfig;

  /**
   * Test {@link TeamsConversationsConfig#microsoftCredentials(String)}.
   * <ul>
   *   <li>Then return ChannelAuthTenant is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsConversationsConfig#microsoftCredentials(String)}
   */
  @Test
  @DisplayName("Test microsoftCredentials(String); then return ChannelAuthTenant is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MicrosoftAppCredentials TeamsConversationsConfig.microsoftCredentials(String)"})
  void testMicrosoftCredentials_thenReturnChannelAuthTenantIs42() {
    // Arrange
    when(applicationContext.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    MicrosoftAppCredentials actualMicrosoftCredentialsResult = teamsConversationsConfig.microsoftCredentials("42");

    // Assert
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertEquals("42", actualMicrosoftCredentialsResult.getChannelAuthTenant());
    assertNull(actualMicrosoftCredentialsResult.getAppId());
    assertNull(actualMicrosoftCredentialsResult.getAppPassword());
  }

  /**
   * Test {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)}.
   * <p>
   * Method under test: {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TeamsConversations TeamsConversationsConfig.teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)"})
  void testTeamsConversations() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    TeamsConversations actualTeamsConversationsResult = teamsConversationsConfig.teamsConversations(bfa, mac, "42",
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Assert
    assertTrue(actualTeamsConversationsResult instanceof StateStorageBasedTeamsConversations);
    assertTrue(
        ((StateStorageBasedTeamsConversations) actualTeamsConversationsResult).tss instanceof MemoryStateStorage);
    assertTrue(actualTeamsConversationsResult.getAllAddressables().isEmpty());
    assertTrue(actualTeamsConversationsResult.getAllChats().isEmpty());
  }

  /**
   * Test {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}.
   * <p>
   * Method under test: {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BotFrameworkHttpAdapter TeamsConversationsConfig.getBotFrameworkHttpAdaptor()"})
  void testGetBotFrameworkHttpAdaptor() {
    // Arrange
    when(applicationContext.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor = teamsConversationsConfig.getBotFrameworkHttpAdaptor();

    // Assert
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertTrue(actualBotFrameworkHttpAdaptor instanceof AdapterWithErrorHandler);
  }

  /**
   * Test {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}.
   * <ul>
   *   <li>Then calls {@link AbstractEnvironment#getProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor(); then calls getProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BotFrameworkHttpAdapter TeamsConversationsConfig.getBotFrameworkHttpAdaptor()"})
  void testGetBotFrameworkHttpAdaptor_thenCallsGetProperty() {
    // Arrange
    StandardEnvironment standardEnvironment = mock(StandardEnvironment.class);
    when(standardEnvironment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(applicationContext.getEnvironment()).thenReturn(standardEnvironment);

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor = teamsConversationsConfig.getBotFrameworkHttpAdaptor();

    // Assert
    verify(standardEnvironment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertTrue(actualBotFrameworkHttpAdaptor instanceof AdapterWithErrorHandler);
  }
}
