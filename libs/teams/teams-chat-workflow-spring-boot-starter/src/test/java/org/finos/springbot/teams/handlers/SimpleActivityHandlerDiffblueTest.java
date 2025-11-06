package org.finos.springbot.teams.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SimpleActivityHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SimpleActivityHandlerDiffblueTest {
  @Autowired
  private SimpleActivityHandler simpleActivityHandler;

  @MockBean
  private TeamsConversations teamsConversations;

  /**
   * Test {@link SimpleActivityHandler#handleActivity(Activity, TeamsAddressable)}.
   * <p>
   * Method under test: {@link SimpleActivityHandler#handleActivity(Activity, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test handleActivity(Activity, TeamsAddressable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture SimpleActivityHandler.handleActivity(Activity, TeamsAddressable)"})
  void testHandleActivity() {
    // Arrange
    CompletableFuture<ResourceResponse> completableFuture = new CompletableFuture<>();
    when(teamsConversations.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completableFuture);

    // Act
    CompletableFuture<ResourceResponse> actualHandleActivityResult = simpleActivityHandler
        .handleActivity(Activity.createContactRelationUpdateActivity(), mock(TeamsAddressable.class));

    // Assert
    verify(teamsConversations).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completableFuture, actualHandleActivityResult);
  }
}
