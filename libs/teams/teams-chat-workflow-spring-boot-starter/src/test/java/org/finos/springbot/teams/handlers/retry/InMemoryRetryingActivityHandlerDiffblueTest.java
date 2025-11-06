package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ResourceResponse;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InMemoryRetryingActivityHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class InMemoryRetryingActivityHandlerDiffblueTest {
  @Autowired
  private InMemoryRetryingActivityHandler inMemoryRetryingActivityHandler;

  @MockBean
  private TeamsConversations teamsConversations;

  /**
   * Test {@link InMemoryRetryingActivityHandler#InMemoryRetryingActivityHandler(TeamsConversations)}.
   * <p>
   * Method under test: {@link InMemoryRetryingActivityHandler#InMemoryRetryingActivityHandler(TeamsConversations)}
   */
  @Test
  @DisplayName("Test new InMemoryRetryingActivityHandler(TeamsConversations)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InMemoryRetryingActivityHandler.<init>(TeamsConversations)"})
  void testNewInMemoryRetryingActivityHandler() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider("42", "iloveyou"));
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount("42");
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    InMemoryRetryingActivityHandler actualInMemoryRetryingActivityHandler = new InMemoryRetryingActivityHandler(
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount,
            new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))));

    // Assert
    TeamsConversations teamsConversations = actualInMemoryRetryingActivityHandler.tc;
    assertTrue(teamsConversations instanceof StateStorageBasedTeamsConversations);
    assertEquals(3L, actualInMemoryRetryingActivityHandler.teamsRetryCount);
    assertTrue(teamsConversations.getAllAddressables().isEmpty());
    assertTrue(teamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   * <ul>
   *   <li>Given {@link TeamsConversations} {@link TeamsConversations#handleActivity(Activity, TeamsAddressable)} return {@link CompletableFuture#CompletableFuture()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable); given TeamsConversations handleActivity(Activity, TeamsAddressable) return CompletableFuture()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"})
  void testHandleActivity_givenTeamsConversationsHandleActivityReturnCompletableFuture() {
    // Arrange
    when(teamsConversations.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(new CompletableFuture<>());

    // Act
    inMemoryRetryingActivityHandler.handleActivity(Activity.createContactRelationUpdateActivity(),
        mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   * <ul>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable); then return Done")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"})
  void testHandleActivity_thenReturnDone() {
    // Arrange
    CompletableFuture<ResourceResponse> failedResult = AbstractRetryingActivityHandler.failed(new Throwable());
    when(teamsConversations.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(failedResult);

    // Act
    CompletableFuture<ResourceResponse> actualHandleActivityResult = inMemoryRetryingActivityHandler
        .handleActivity(Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertTrue(actualHandleActivityResult.isDone());
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   * <ul>
   *   <li>Then throw {@link CompletionException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable); then throw CompletionException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"})
  void testHandleActivity_thenThrowCompletionException() {
    // Arrange
    when(teamsConversations.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new CompletionException("foo", new Throwable()));

    // Act and Assert
    assertThrows(CompletionException.class, () -> inMemoryRetryingActivityHandler
        .handleActivity(Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class)));
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }
}
