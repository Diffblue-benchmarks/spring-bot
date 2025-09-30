package org.finos.springbot.teams.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.springframework.core.env.StandardEnvironment;

@ExtendWith(MockitoExtension.class)
class TeamsConversationsConfigDiffblueTest {
  @Mock private ApplicationContext applicationContext;

  @InjectMocks private TeamsConversationsConfig teamsConversationsConfig;

  /**
   * Test {@link TeamsConversationsConfig#microsoftCredentials(String)}.
   *
   * <ul>
   *   <li>Then return ChannelAuthTenant is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversationsConfig#microsoftCredentials(String)}
   */
  @Test
  @DisplayName("Test microsoftCredentials(String); then return ChannelAuthTenant is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MicrosoftAppCredentials TeamsConversationsConfig.microsoftCredentials(String)"
  })
  void testMicrosoftCredentials_thenReturnChannelAuthTenantIs42() {
    // Arrange
    when(applicationContext.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    MicrosoftAppCredentials actualMicrosoftCredentialsResult =
        teamsConversationsConfig.microsoftCredentials("42");

    // Assert
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertEquals("42", actualMicrosoftCredentialsResult.getChannelAuthTenant());
    assertNull(actualMicrosoftCredentialsResult.getAppId());
    assertNull(actualMicrosoftCredentialsResult.getAppPassword());
  }

  /**
   * Test {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter,
   * MicrosoftAppCredentials, String, TeamsStateStorage)}.
   *
   * <p>Method under test: {@link TeamsConversationsConfig#teamsConversations(BotFrameworkAdapter,
   * MicrosoftAppCredentials, String, TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TeamsConversations TeamsConversationsConfig.teamsConversations(BotFrameworkAdapter, MicrosoftAppCredentials, String, TeamsStateStorage)"
  })
  void testTeamsConversations() {
    // Arrange
    BotFrameworkAdapter bfa =
        new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    TeamsConversations actualTeamsConversationsResult =
        teamsConversationsConfig.teamsConversations(bfa, mac, "42", new MemoryStateStorage(ejc));

    // Assert
    assertTrue(actualTeamsConversationsResult instanceof StateStorageBasedTeamsConversations);
    assertTrue(
        ((StateStorageBasedTeamsConversations) actualTeamsConversationsResult).tss
            instanceof MemoryStateStorage);
    assertTrue(actualTeamsConversationsResult.getAllAddressables().isEmpty());
    assertTrue(actualTeamsConversationsResult.getAllChats().isEmpty());
  }

  /**
   * Test {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}.
   *
   * <p>Method under test: {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter TeamsConversationsConfig.getBotFrameworkHttpAdaptor()"
  })
  void testGetBotFrameworkHttpAdaptor() {
    // Arrange
    when(applicationContext.getEnvironment()).thenReturn(new StandardReactiveWebEnvironment());

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor();

    // Assert
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertTrue(actualBotFrameworkHttpAdaptor instanceof AdapterWithErrorHandler);
  }

  /**
   * Test {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}.
   *
   * <p>Method under test: {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter TeamsConversationsConfig.getBotFrameworkHttpAdaptor()"
  })
  void testGetBotFrameworkHttpAdaptor2() {
    // Arrange
    StandardEnvironment standardEnvironment = mock(StandardEnvironment.class);
    when(standardEnvironment.getProperty(Mockito.<String>any())).thenReturn("");
    when(applicationContext.getEnvironment()).thenReturn(standardEnvironment);

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor();

    // Assert
    verify(standardEnvironment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertTrue(actualBotFrameworkHttpAdaptor instanceof AdapterWithErrorHandler);
  }

  /**
   * Test {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}.
   *
   * <ul>
   *   <li>Given {@link StandardEnvironment} {@link StandardEnvironment#getProperty(String)} return
   *       {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversationsConfig#getBotFrameworkHttpAdaptor()}
   */
  @Test
  @DisplayName(
      "Test getBotFrameworkHttpAdaptor(); given StandardEnvironment getProperty(String) return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter TeamsConversationsConfig.getBotFrameworkHttpAdaptor()"
  })
  void testGetBotFrameworkHttpAdaptor_givenStandardEnvironmentGetPropertyReturnProperty() {
    // Arrange
    StandardEnvironment standardEnvironment = mock(StandardEnvironment.class);
    when(standardEnvironment.getProperty(Mockito.<String>any())).thenReturn("Property");
    when(applicationContext.getEnvironment()).thenReturn(standardEnvironment);

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor();

    // Assert
    verify(standardEnvironment, atLeast(1)).getProperty(Mockito.<String>any());
    verify(applicationContext, atLeast(1)).getEnvironment();
    assertTrue(actualBotFrameworkHttpAdaptor instanceof AdapterWithErrorHandler);
  }
}
