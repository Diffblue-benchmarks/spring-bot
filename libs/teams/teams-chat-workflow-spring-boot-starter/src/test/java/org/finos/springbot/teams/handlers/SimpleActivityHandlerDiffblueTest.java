package org.finos.springbot.teams.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.ResourceResponse;
import java.util.concurrent.CompletableFuture;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.conversations.TeamsConversations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SimpleActivityHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SimpleActivityHandlerDiffblueTest {
  @Autowired private SimpleActivityHandler simpleActivityHandler;

  @MockitoBean private TeamsConversations teamsConversations;

  /**
   * Test {@link SimpleActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   *
   * <p>Method under test: {@link SimpleActivityHandler#handleActivity(Activity, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture SimpleActivityHandler.handleActivity(Activity, TeamsAddressable)"
  })
  void testHandleActivity() {
    // Arrange
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(teamsConversations.handleActivity(
            Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

    // Act
    CompletableFuture<ResourceResponse> actualHandleActivityResult =
        simpleActivityHandler.handleActivity(
            Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualHandleActivityResult);
  }
}
