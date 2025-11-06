package org.finos.springbot.teams.bot;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.bot.builder.ConversationState;
import com.microsoft.bot.builder.MemoryStorage;
import com.microsoft.bot.builder.Storage;
import com.microsoft.bot.builder.UserState;
import com.microsoft.bot.builder.inspection.InspectionState;
import com.microsoft.bot.integration.Configuration;
import org.finos.springbot.teams.conversations.TeamsConversationsConfig;
import org.junit.jupiter.api.Test;

class BotDependencyConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link BotDependencyConfiguration#getAuthenticationConfiguration(Configuration)}
   */
  @Test
  void testGetAuthenticationConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TeamsConversationsConfig()).getAuthenticationConfiguration(null).getClaimsValidator());
  }

  /**
   * Method under test: {@link BotDependencyConfiguration#getStorage()}
   */
  @Test
  void testGetStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Storage actualStorage = (new TeamsConversationsConfig()).getStorage();

    // Assert
    assertTrue(actualStorage instanceof MemoryStorage);
    assertTrue(actualStorage.delete(null).isDone());
    assertTrue(actualStorage.read(null).isDone());
  }

  /**
   * Method under test:
   * {@link BotDependencyConfiguration#getConversationState(Storage)}
   */
  @Test
  void testGetConversationState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    ConversationState actualConversationState = teamsConversationsConfig.getConversationState(new MemoryStorage());

    // Assert
    assertTrue(actualConversationState.clearState(null).isDone());
    assertTrue(actualConversationState.delete(null).isDone());
  }

  /**
   * Method under test: {@link BotDependencyConfiguration#getUserState(Storage)}
   */
  @Test
  void testGetUserState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    UserState actualUserState = teamsConversationsConfig.getUserState(new MemoryStorage());

    // Assert
    assertTrue(actualUserState.clearState(null).isDone());
    assertTrue(actualUserState.delete(null).isDone());
  }

  /**
   * Method under test:
   * {@link BotDependencyConfiguration#getInspectionState(Storage)}
   */
  @Test
  void testGetInspectionState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsConversationsConfig teamsConversationsConfig = new TeamsConversationsConfig();

    // Act
    InspectionState actualInspectionState = teamsConversationsConfig.getInspectionState(new MemoryStorage());

    // Assert
    assertTrue(actualInspectionState.clearState(null).isDone());
    assertTrue(actualInspectionState.delete(null).isDone());
  }
}
