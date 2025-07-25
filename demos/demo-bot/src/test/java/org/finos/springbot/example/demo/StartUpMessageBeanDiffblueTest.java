package org.finos.springbot.example.demo;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
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

@ContextConfiguration(classes = {StartUpMessageBean.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StartUpMessageBeanDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private StartUpMessageBean startUpMessageBean;

  /**
   * Test {@link StartUpMessageBean#doSomethingAfterStartup()}.
   *
   * <ul>
   *   <li>Given {@link AllConversations} {@link AllConversations#getExistingChat(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  @DisplayName(
      "Test doSomethingAfterStartup(); given AllConversations getExistingChat(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StartUpMessageBean.doSomethingAfterStartup()"})
  void testDoSomethingAfterStartup_givenAllConversationsGetExistingChatReturnNull() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any())).thenReturn(null);

    // Act
    startUpMessageBean.doSomethingAfterStartup();

    // Assert
    verify(allConversations).getExistingChat(eq("${room}"));
  }

  /**
   * Test {@link StartUpMessageBean#doSomethingAfterStartup()}.
   *
   * <ul>
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  @DisplayName("Test doSomethingAfterStartup(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StartUpMessageBean.doSomethingAfterStartup()"})
  void testDoSomethingAfterStartup_thenCallsAccept() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    startUpMessageBean.doSomethingAfterStartup();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getExistingChat(eq("${room}"));
  }
}
