package org.finos.springbot.teams.bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.builder.ConversationState;
import com.microsoft.bot.builder.MemoryStorage;
import com.microsoft.bot.builder.Storage;
import com.microsoft.bot.builder.UserState;
import com.microsoft.bot.builder.inspection.InspectionState;
import com.microsoft.bot.connector.authentication.ChannelProvider;
import com.microsoft.bot.connector.authentication.CredentialProvider;
import com.microsoft.bot.integration.BotFrameworkHttpAdapter;
import com.microsoft.bot.integration.ClasspathPropertiesConfiguration;
import com.microsoft.bot.integration.Configuration;
import com.microsoft.bot.integration.ConfigurationChannelProvider;
import com.microsoft.bot.integration.ConfigurationCredentialProvider;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.finos.springbot.teams.conversations.TeamsConversationsConfig;
import org.finos.springbot.teams.state.TeamsStateStorage;
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

@ContextConfiguration(classes = {TeamsConversationsConfig.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BotDependencyConfigurationDiffblueTest {
  @Autowired private ApplicationContext applicationContext;

  @Autowired private BotDependencyConfiguration botDependencyConfiguration;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link BotDependencyConfiguration#getAuthenticationConfiguration(Configuration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ClaimsValidator is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BotDependencyConfiguration#getAuthenticationConfiguration(Configuration)}
   */
  @Test
  @DisplayName(
      "Test getAuthenticationConfiguration(Configuration); when 'null'; then return ClaimsValidator is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.microsoft.bot.connector.authentication.AuthenticationConfiguration BotDependencyConfiguration.getAuthenticationConfiguration(Configuration)"
  })
  void testGetAuthenticationConfiguration_whenNull_thenReturnClaimsValidatorIsNull() {
    // Arrange, Act and Assert
    assertNull(
        botDependencyConfiguration.getAuthenticationConfiguration(null).getClaimsValidator());
  }

  /**
   * Test {@link BotDependencyConfiguration#getCredentialProvider(Configuration)}.
   *
   * <ul>
   *   <li>Then return {@link ConfigurationCredentialProvider}.
   * </ul>
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getCredentialProvider(Configuration)}
   */
  @Test
  @DisplayName(
      "Test getCredentialProvider(Configuration); then return ConfigurationCredentialProvider")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CredentialProvider BotDependencyConfiguration.getCredentialProvider(Configuration)"
  })
  void testGetCredentialProvider_thenReturnConfigurationCredentialProvider() {
    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    ClasspathPropertiesConfiguration configuration = mock(ClasspathPropertiesConfiguration.class);
    when(configuration.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    CredentialProvider actualCredentialProvider =
        teamsConversationsConfig.getCredentialProvider(configuration);

    // Assert
    verify(configuration, atLeast(1)).getProperty(Mockito.<String>any());
    assertTrue(actualCredentialProvider instanceof ConfigurationCredentialProvider);
    assertEquals(
        "Property", ((ConfigurationCredentialProvider) actualCredentialProvider).getAppId());
    assertEquals(
        "Property", ((ConfigurationCredentialProvider) actualCredentialProvider).getPassword());
  }

  /**
   * Test {@link BotDependencyConfiguration#getChannelProvider(Configuration)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   *   <li>Then return {@link ConfigurationChannelProvider}.
   * </ul>
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getChannelProvider(Configuration)}
   */
  @Test
  @DisplayName(
      "Test getChannelProvider(Configuration); given 'Property'; then return ConfigurationChannelProvider")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ChannelProvider BotDependencyConfiguration.getChannelProvider(Configuration)"
  })
  void testGetChannelProvider_givenProperty_thenReturnConfigurationChannelProvider()
      throws InterruptedException, ExecutionException {
    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    ClasspathPropertiesConfiguration configuration = mock(ClasspathPropertiesConfiguration.class);
    when(configuration.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    ChannelProvider actualChannelProvider =
        teamsConversationsConfig.getChannelProvider(configuration);

    // Assert
    verify(configuration).getProperty("ChannelService");
    assertTrue(actualChannelProvider instanceof ConfigurationChannelProvider);
    CompletableFuture<String> channelService = actualChannelProvider.getChannelService();
    assertEquals("Property", channelService.get());
    assertFalse(actualChannelProvider.isPublicAzure());
    assertTrue(channelService.isDone());
  }

  /**
   * Test {@link BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor(Configuration); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter BotDependencyConfiguration.getBotFrameworkHttpAdaptor(Configuration)"
  })
  void testGetBotFrameworkHttpAdaptor_givenEmptyString() {
    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    ClasspathPropertiesConfiguration configuration = mock(ClasspathPropertiesConfiguration.class);
    when(configuration.getProperty(Mockito.<String>any())).thenReturn("");

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor(configuration);

    // Assert
    verify(configuration, atLeast(1)).getProperty(Mockito.<String>any());
    assertNull(actualBotFrameworkHttpAdaptor.getOnTurnError());
  }

  /**
   * Test {@link BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link Configuration#getProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}
   */
  @Test
  @DisplayName(
      "Test getBotFrameworkHttpAdaptor(Configuration); given 'null'; then calls getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter BotDependencyConfiguration.getBotFrameworkHttpAdaptor(Configuration)"
  })
  void testGetBotFrameworkHttpAdaptor_givenNull_thenCallsGetProperty() {
    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    Configuration configuration = mock(Configuration.class);
    when(configuration.getProperty(Mockito.<String>any())).thenReturn(null);

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor(configuration);

    // Assert
    verify(configuration, atLeast(1)).getProperty(Mockito.<String>any());
    assertNull(actualBotFrameworkHttpAdaptor.getOnTurnError());
  }

  /**
   * Test {@link BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}.
   *
   * <ul>
   *   <li>Given {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BotDependencyConfiguration#getBotFrameworkHttpAdaptor(Configuration)}
   */
  @Test
  @DisplayName("Test getBotFrameworkHttpAdaptor(Configuration); given 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BotFrameworkHttpAdapter BotDependencyConfiguration.getBotFrameworkHttpAdaptor(Configuration)"
  })
  void testGetBotFrameworkHttpAdaptor_givenProperty() {
    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    ClasspathPropertiesConfiguration configuration = mock(ClasspathPropertiesConfiguration.class);
    when(configuration.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    BotFrameworkHttpAdapter actualBotFrameworkHttpAdaptor =
        teamsConversationsConfig.getBotFrameworkHttpAdaptor(configuration);

    // Assert
    verify(configuration, atLeast(1)).getProperty(Mockito.<String>any());
    assertNull(actualBotFrameworkHttpAdaptor.getOnTurnError());
  }

  /**
   * Test {@link BotDependencyConfiguration#getStorage()}.
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getStorage()}
   */
  @Test
  @DisplayName("Test getStorage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Storage BotDependencyConfiguration.getStorage()"})
  void testGetStorage() {
    // Arrange, Act and Assert
    assertTrue(new TeamsConversationsConfig().getStorage() instanceof MemoryStorage);
  }

  /**
   * Test {@link BotDependencyConfiguration#getConversationState(Storage)}.
   *
   * <ul>
   *   <li>When {@link MemoryStorage#MemoryStorage()}.
   *   <li>Then return clearState {@code null} Done.
   * </ul>
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getConversationState(Storage)}
   */
  @Test
  @DisplayName(
      "Test getConversationState(Storage); when MemoryStorage(); then return clearState 'null' Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConversationState BotDependencyConfiguration.getConversationState(Storage)"})
  void testGetConversationState_whenMemoryStorage_thenReturnClearStateNullDone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    ConversationState actualConversationState =
        teamsConversationsConfig.getConversationState(new MemoryStorage());

    // Assert
    assertTrue(actualConversationState.clearState(null).isDone());
    assertTrue(actualConversationState.delete(null).isDone());
  }

  /**
   * Test {@link BotDependencyConfiguration#getUserState(Storage)}.
   *
   * <ul>
   *   <li>When {@link MemoryStorage#MemoryStorage()}.
   *   <li>Then return clearState {@code null} Done.
   * </ul>
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getUserState(Storage)}
   */
  @Test
  @DisplayName(
      "Test getUserState(Storage); when MemoryStorage(); then return clearState 'null' Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserState BotDependencyConfiguration.getUserState(Storage)"})
  void testGetUserState_whenMemoryStorage_thenReturnClearStateNullDone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    UserState actualUserState = teamsConversationsConfig.getUserState(new MemoryStorage());

    // Assert
    assertTrue(actualUserState.clearState(null).isDone());
    assertTrue(actualUserState.delete(null).isDone());
  }

  /**
   * Test {@link BotDependencyConfiguration#getInspectionState(Storage)}.
   *
   * <ul>
   *   <li>When {@link MemoryStorage#MemoryStorage()}.
   *   <li>Then return clearState {@code null} Done.
   * </ul>
   *
   * <p>Method under test: {@link BotDependencyConfiguration#getInspectionState(Storage)}
   */
  @Test
  @DisplayName(
      "Test getInspectionState(Storage); when MemoryStorage(); then return clearState 'null' Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InspectionState BotDependencyConfiguration.getInspectionState(Storage)"})
  void testGetInspectionState_whenMemoryStorage_thenReturnClearStateNullDone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    InspectionState actualInspectionState =
        teamsConversationsConfig.getInspectionState(new MemoryStorage());

    // Assert
    assertTrue(actualInspectionState.clearState(null).isDone());
    assertTrue(actualInspectionState.delete(null).isDone());
  }
}
