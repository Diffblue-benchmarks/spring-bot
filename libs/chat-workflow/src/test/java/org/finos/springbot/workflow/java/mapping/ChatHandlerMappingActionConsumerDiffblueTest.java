package org.finos.springbot.workflow.java.mapping;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.consumers.AddressingChecker;
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
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {ChatHandlerMappingActionConsumer.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatHandlerMappingActionConsumerDiffblueTest {
  @MockitoBean private AddressingChecker addressingChecker;

  @MockitoBean private ChatHandlerMapping<Object> chatHandlerMapping;

  @Autowired private ChatHandlerMappingActionConsumer chatHandlerMappingActionConsumer;

  @MockitoBean private ErrorHandler errorHandler;

  @Autowired private List<ChatHandlerMapping<Object>> list;

  @Autowired private List<AddressingChecker> list2;

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   *
   * <ul>
   *   <li>Given {@link ChatHandlerExecutor} {@link ChatHandlerExecutor#execute()} does nothing.
   *   <li>Then calls {@link ChatHandlerExecutor#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName(
      "Test acceptInner(Action); given ChatHandlerExecutor execute() does nothing; then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatHandlerMappingActionConsumer.acceptInner(Action)"})
  void testAcceptInner_givenChatHandlerExecutorExecuteDoesNothing_thenCallsExecute()
      throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any()))
        .thenReturn(chatHandlerExecutorList);

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
  }

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   *
   * <ul>
   *   <li>Given {@link ErrorHandler}.
   * </ul>
   *
   * <p>Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); given ErrorHandler")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatHandlerMappingActionConsumer.acceptInner(Action)"})
  void testAcceptInner_givenErrorHandler() {
    // Arrange
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any())).thenReturn(new ArrayList<>());

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
  }

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   *
   * <ul>
   *   <li>Then calls {@link ErrorHandler#handleError(Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); then calls handleError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatHandlerMappingActionConsumer.acceptInner(Action)"})
  void testAcceptInner_thenCallsHandleError() throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doThrow(new Throwable()).when(chatHandlerExecutor).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any()))
        .thenReturn(chatHandlerExecutorList);
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
    verify(errorHandler).handleError(isA(Throwable.class));
  }

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   *
   * <ul>
   *   <li>Then calls {@link ErrorHandler#handleError(Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); then calls handleError(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ChatHandlerMappingActionConsumer.acceptInner(Action)"})
  void testAcceptInner_thenCallsHandleError2() throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doThrow(new Throwable()).when(chatHandlerExecutor).execute();
    ChatHandlerExecutor chatHandlerExecutor2 = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor2).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor2);
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any()))
        .thenReturn(chatHandlerExecutorList);
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor2).execute();
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
    verify(errorHandler).handleError(isA(Throwable.class));
  }
}
