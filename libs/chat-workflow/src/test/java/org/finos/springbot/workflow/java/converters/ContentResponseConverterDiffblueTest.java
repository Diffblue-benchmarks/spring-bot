package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
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

@ContextConfiguration(classes = {ContentResponseConverter.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ContentResponseConverterDiffblueTest {
  @Autowired
  private ContentResponseConverter contentResponseConverter;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContentResponseConverter#ContentResponseConverter(ResponseHandlers)}
   *   <li>{@link ContentResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.converters.ContentResponseConverter.<init>(org.finos.springbot.workflow.response.handlers.ResponseHandlers)",
      "int org.finos.springbot.workflow.java.converters.ContentResponseConverter.getOrder()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new ContentResponseConverter(mock(ResponseHandlers.class))).getOrder());
  }

  /**
   * Test {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code Object}, {@code ChatHandlerExecutor}.
   * <ul>
   *   <li>Given {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable} and {@code Ej}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; given ErrorAction(Addressable, Object) with a is Addressable and 'Ej'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.converters.ContentResponseConverter.accept(java.lang.Object, org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_givenErrorActionWithAIsAddressableAndEj() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    ChatHandlerExecutor u = mock(ChatHandlerExecutor.class);
    when(u.action()).thenReturn(new ErrorAction(mock(Addressable.class), "Ej"));

    // Act
    contentResponseConverter.accept(blockQuoteImpl, u);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(u).action();
  }

  /**
   * Test {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code Object}, {@code ChatHandlerExecutor}.
   * <ul>
   *   <li>Given {@link Action#NULL_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; given NULL_ACTION")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.converters.ContentResponseConverter.accept(java.lang.Object, org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_givenNull_action() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    ChatHandlerExecutor u = mock(ChatHandlerExecutor.class);
    when(u.action()).thenReturn(Action.NULL_ACTION);

    // Act
    contentResponseConverter.accept(blockQuoteImpl, u);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(u).action();
  }

  /**
   * Test {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)} with {@code Object}, {@code ChatHandlerExecutor}.
   * <ul>
   *   <li>When {@link Message.MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentResponseConverter#accept(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test accept(Object, ChatHandlerExecutor) with 'Object', 'ChatHandlerExecutor'; when MessageImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.java.converters.ContentResponseConverter.accept(java.lang.Object, org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor)"})
  void testAcceptWithObjectChatHandlerExecutor_whenMessageImplWithCIsArrayList() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());
    ChatHandlerExecutor u = mock(ChatHandlerExecutor.class);
    when(u.action()).thenReturn(Action.NULL_ACTION);

    // Act
    contentResponseConverter.accept(messageImpl, u);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(u).action();
  }
}
