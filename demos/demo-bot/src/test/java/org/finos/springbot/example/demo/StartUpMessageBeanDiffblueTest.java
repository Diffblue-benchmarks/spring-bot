package org.finos.springbot.example.demo;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StartUpMessageBean.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class StartUpMessageBeanDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @MockBean
  private ResponseHandlers responseHandlers;

  @Autowired
  private StartUpMessageBean startUpMessageBean;

  /**
   * Test {@link StartUpMessageBean#doSomethingAfterStartup()}.
   * <ul>
   *   <li>Given {@link AllConversations} {@link AllConversations#getExistingChat(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  @DisplayName("Test doSomethingAfterStartup(); given AllConversations getExistingChat(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.demo.StartUpMessageBean.doSomethingAfterStartup()"})
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
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StartUpMessageBean#doSomethingAfterStartup()}
   */
  @Test
  @DisplayName("Test doSomethingAfterStartup(); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.demo.StartUpMessageBean.doSomethingAfterStartup()"})
  void testDoSomethingAfterStartup_thenCallsAccept() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any())).thenReturn(new SymphonyRoom("Name", "42"));
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    startUpMessageBean.doSomethingAfterStartup();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getExistingChat(eq("${room}"));
  }
}
