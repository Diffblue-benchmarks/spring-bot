package org.finos.springbot.workflow.java.mapping;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {ChatHandlerMappingActionConsumer.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ChatHandlerMappingActionConsumerDiffblueTest {
  @MockBean
  private AddressingChecker addressingChecker;

  @MockBean
  private ChatHandlerMapping<Object> chatHandlerMapping;

  @Autowired
  private ChatHandlerMappingActionConsumer chatHandlerMappingActionConsumer;

  @MockBean
  private ErrorHandler errorHandler;

  @Autowired
  private List<ChatHandlerMapping<Object>> list;

  @Autowired
  private List<AddressingChecker> list2;

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   * <ul>
   *   <li>Given {@link ChatHandlerExecutor} {@link ChatHandlerExecutor#execute()} does nothing.</li>
   *   <li>Then calls {@link ChatHandlerExecutor#execute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); given ChatHandlerExecutor execute() does nothing; then calls execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer.acceptInner(org.finos.springbot.workflow.actions.Action)"})
  void testAcceptInner_givenChatHandlerExecutorExecuteDoesNothing_thenCallsExecute() throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any())).thenReturn(chatHandlerExecutorList);

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
  }

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   * <ul>
   *   <li>Given {@link ChatHandlerExecutor} {@link ChatHandlerExecutor#execute()} does nothing.</li>
   *   <li>Then calls {@link ChatHandlerExecutor#execute()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); given ChatHandlerExecutor execute() does nothing; then calls execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer.acceptInner(org.finos.springbot.workflow.actions.Action)"})
  void testAcceptInner_givenChatHandlerExecutorExecuteDoesNothing_thenCallsExecute2() throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor).execute();
    ChatHandlerExecutor chatHandlerExecutor2 = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor2).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor2);
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any())).thenReturn(chatHandlerExecutorList);

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor2).execute();
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
  }

  /**
   * Test {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}.
   * <ul>
   *   <li>Given {@link ErrorHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); given ErrorHandler")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer.acceptInner(org.finos.springbot.workflow.actions.Action)"})
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
   * <ul>
   *   <li>Then calls {@link ErrorHandler#handleError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChatHandlerMappingActionConsumer#acceptInner(Action)}
   */
  @Test
  @DisplayName("Test acceptInner(Action); then calls handleError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.mapping.ChatHandlerMappingActionConsumer.acceptInner(org.finos.springbot.workflow.actions.Action)"})
  void testAcceptInner_thenCallsHandleError() throws Throwable {
    // Arrange
    ChatHandlerExecutor chatHandlerExecutor = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor).execute();
    ChatHandlerExecutor chatHandlerExecutor2 = mock(ChatHandlerExecutor.class);
    doNothing().when(chatHandlerExecutor2).execute();
    ChatHandlerExecutor chatHandlerExecutor3 = mock(ChatHandlerExecutor.class);
    doThrow(new Throwable()).when(chatHandlerExecutor3).execute();

    ArrayList<ChatHandlerExecutor> chatHandlerExecutorList = new ArrayList<>();
    chatHandlerExecutorList.add(chatHandlerExecutor3);
    chatHandlerExecutorList.add(chatHandlerExecutor2);
    chatHandlerExecutorList.add(chatHandlerExecutor);
    when(chatHandlerMapping.getExecutors(Mockito.<Action>any())).thenReturn(chatHandlerExecutorList);
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    // Act
    chatHandlerMappingActionConsumer.acceptInner(Action.NULL_ACTION);

    // Assert
    verify(chatHandlerExecutor3).execute();
    verify(chatHandlerExecutor2).execute();
    verify(chatHandlerExecutor).execute();
    verify(chatHandlerMapping).getExecutors(isA(Action.class));
    verify(errorHandler).handleError(isA(Throwable.class));
  }
}
