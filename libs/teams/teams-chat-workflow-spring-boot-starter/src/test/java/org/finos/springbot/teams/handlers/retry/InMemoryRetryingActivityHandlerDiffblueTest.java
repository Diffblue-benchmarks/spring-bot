package org.finos.springbot.teams.handlers.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.microsoft.bot.builder.BotFrameworkAdapter;
import com.microsoft.bot.connector.authentication.MicrosoftAppCredentials;
import com.microsoft.bot.connector.authentication.SimpleCredentialProvider;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ChannelAccount;
import com.microsoft.bot.schema.ResourceResponse;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.controller.TeamsHandlerMappingTest;
import org.finos.springbot.teams.conversations.StateStorageBasedTeamsConversations;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.finos.springbot.teams.state.FileStateStorage;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InMemoryRetryingActivityHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class InMemoryRetryingActivityHandlerDiffblueTest {
  @Autowired private InMemoryRetryingActivityHandler inMemoryRetryingActivityHandler;

  @MockitoBean private TeamsConversations teamsConversations;

  /**
   * Test {@link
   * InMemoryRetryingActivityHandler#InMemoryRetryingActivityHandler(TeamsConversations)}.
   *
   * <p>Method under test: {@link
   * InMemoryRetryingActivityHandler#InMemoryRetryingActivityHandler(TeamsConversations)}
   */
  @Test
  @DisplayName("Test new InMemoryRetryingActivityHandler(TeamsConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InMemoryRetryingActivityHandler.<init>(TeamsConversations)"})
  void testNewInMemoryRetryingActivityHandler() {
    // Arrange
    BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
    MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
    ChannelAccount botAccount = new ChannelAccount();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    StateStorageBasedTeamsConversations tc =
        new StateStorageBasedTeamsConversations(bfa, mac, botAccount, new MemoryStateStorage(ejc));

    // Act
    InMemoryRetryingActivityHandler actualInMemoryRetryingActivityHandler =
        new InMemoryRetryingActivityHandler(tc);

    // Assert
    TeamsConversations teamsConversations = actualInMemoryRetryingActivityHandler.tc;
    assertTrue(teamsConversations instanceof StateStorageBasedTeamsConversations);
    assertEquals(3L, actualInMemoryRetryingActivityHandler.teamsRetryCount);
    assertTrue(teamsConversations.getAllAddressables().isEmpty());
    assertTrue(teamsConversations.getAllChats().isEmpty());
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   *
   * <p>Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"
  })
  void testHandleActivity() {
    // Arrange
    CompletionException completionException =
        new CompletionException("An error occurred", new Throwable());
    when(teamsConversations.handleActivity(
            Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(completionException);

    // Act and Assert
    assertThrows(
        CompletionException.class,
        () ->
            inMemoryRetryingActivityHandler.handleActivity(
                Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class)));
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then calls {@link Files#exists(Path, LinkOption[])}.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test handleActivity(Activity, TeamsAddressable); then calls exists(Path, LinkOption[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"
  })
  void testHandleActivity_thenCallsExists() {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      CompletionException completionException =
          new CompletionException("An error occurred", new Throwable());
      mockFiles
          .when(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(completionException);
      CompletionException completionException2 =
          new CompletionException("An error occurred", new Throwable());
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(completionException2);
      BotFrameworkAdapter bfa = new BotFrameworkAdapter(new SimpleCredentialProvider());
      MicrosoftAppCredentials mac = MicrosoftAppCredentials.empty();
      ChannelAccount botAccount = new ChannelAccount();

      StateStorageBasedTeamsConversations tc =
          new StateStorageBasedTeamsConversations(
              bfa, mac, botAccount, new FileStateStorage(null, "/directory/foo.txt"));
      InMemoryRetryingActivityHandler inMemoryRetryingActivityHandler =
          new InMemoryRetryingActivityHandler(tc);
      Activity activity = Activity.createContactRelationUpdateActivity();

      TeamsAddressable resultTo = mock(TeamsAddressable.class);
      when(resultTo.getKey()).thenReturn("Key");

      // Act and Assert
      assertThrows(
          CompletionException.class,
          () -> inMemoryRetryingActivityHandler.handleActivity(activity, resultTo));
      mockFiles.verify(() -> Files.exists(Mockito.<Path>any(), isA(LinkOption[].class)));
      verify(resultTo, atLeast(1)).getKey();
    }
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"
  })
  void testHandleActivity_thenReturnDone() {
    // Arrange
    CompletableFuture<ResourceResponse> failedResult =
        TeamsHandlerMappingTest.failed(new Throwable());
    when(teamsConversations.handleActivity(
            Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(failedResult);

    // Act
    CompletableFuture<ResourceResponse> actualHandleActivityResult =
        inMemoryRetryingActivityHandler.handleActivity(
            Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertTrue(actualHandleActivityResult.isDone());
  }

  /**
   * Test {@link InMemoryRetryingActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then return {@link CompletableFuture#get()} Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InMemoryRetryingActivityHandler#handleActivity(Activity,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable); then return get() Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture InMemoryRetryingActivityHandler.handleActivity(Activity, TeamsAddressable)"
  })
  void testHandleActivity_thenReturnGetIdIsNull() throws InterruptedException, ExecutionException {
    // Arrange
    ResourceResponse resourceResponse = new ResourceResponse();
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(resourceResponse);
    when(teamsConversations.handleActivity(
            Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

    // Act
    CompletableFuture<ResourceResponse> actualHandleActivityResult =
        inMemoryRetryingActivityHandler.handleActivity(
            Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    ResourceResponse getResult = actualHandleActivityResult.get();
    assertNull(getResult.getId());
    assertSame(resourceResponse, getResult);
  }
}
