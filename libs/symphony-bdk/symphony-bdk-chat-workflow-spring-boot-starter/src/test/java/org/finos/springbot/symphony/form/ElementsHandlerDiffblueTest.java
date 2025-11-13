package org.finos.springbot.symphony.form;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.service.message.MessageService;
import com.symphony.bdk.gen.api.model.V4Initiator;
import com.symphony.bdk.gen.api.model.V4Message;
import com.symphony.bdk.gen.api.model.V4Stream;
import com.symphony.bdk.gen.api.model.V4SymphonyElementsAction;
import com.symphony.bdk.gen.api.model.V4User;
import com.symphony.bdk.spring.events.RealTimeEvent;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.symphony.conversations.SymphonyConversations;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.FormAction;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.FormConverter;
import org.finos.springbot.workflow.form.FormValidationProcessor;
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

@ContextConfiguration(classes = {ElementsHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ElementsHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @Autowired private ElementsHandler elementsHandler;

  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @MockitoBean private FormConverter formConverter;

  @MockitoBean private FormValidationProcessor formValidationProcessor;

  @Autowired private List<ActionConsumer> list;

  @MockitoBean private MessageService messageService;

  @MockitoBean private SymphonyConversations symphonyConversations;

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link ActionConsumer#accept(Object)} does nothing.
   *   <li>Then calls {@link ActionConsumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given ActionConsumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenActionConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());
    when(formValidationProcessor.validationCheck(
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Object>any(),
            Mockito.<Supplier<FormAction>>any()))
        .thenReturn(formAction);

    V4Initiator initiator = new V4Initiator();
    initiator.user(new V4User());

    V4Stream v4Stream = new V4Stream();
    v4Stream.streamType("action");

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(initiator, v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(null);
    verify(formValidationProcessor)
        .validationCheck(isNull(), isNull(), isNull(), isA(Supplier.class));
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@code Form Values}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given 'Form Values'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenFormValues() {
    // Arrange
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getFormValues()).thenReturn("Form Values");
    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(v4SymphonyElementsAction).getFormValues();
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link MessageService} {@link MessageService#getMessage(String)} return {@code
   *       null}.
   *   <li>Then calls {@link MessageService#getMessage(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given MessageService getMessage(String) return 'null'; then calls getMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenMessageServiceGetMessageReturnNull_thenCallsGetMessage() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(null);

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());
    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RealTimeEvent} {@link RealTimeEvent#getSource()} return {@code null}.
   *   <li>Then calls {@link RealTimeEvent#getSource()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given 'null'; when RealTimeEvent getSource() return 'null'; then calls getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenNull_whenRealTimeEventGetSourceReturnNull_thenCallsGetSource() {
    // Arrange
    RealTimeEvent<V4SymphonyElementsAction> event = mock(RealTimeEvent.class);
    when(event.getSource()).thenReturn(null);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(event).getSource();
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link V4SymphonyElementsAction} {@link V4SymphonyElementsAction#getStream()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given 'null'; when V4SymphonyElementsAction getStream() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenNull_whenV4SymphonyElementsActionGetStreamReturnNull() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(null);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());
    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(null);
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link V4Stream} (default constructor) streamType {@code action}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given V4Stream (default constructor) streamType 'action'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenV4StreamStreamTypeAction() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4Stream v4Stream = new V4Stream();
    v4Stream.streamType("action");

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());
    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(null);
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link V4Stream} (default constructor).
   *   <li>When {@link V4SymphonyElementsAction} {@link V4SymphonyElementsAction#getStream()} return
   *       {@link V4Stream} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test accept(RealTimeEvent); given V4Stream (default constructor); when V4SymphonyElementsAction getStream() return V4Stream (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenV4Stream_whenV4SymphonyElementsActionGetStreamReturnV4Stream() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(new V4Stream());
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());
    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(null);
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link SymphonyConversations#loadRoomById(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); then calls loadRoomById(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_thenCallsLoadRoomById() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);

    FormAction formAction = new FormAction(a, u, "Form Data", "Action", new HashMap<>());
    when(formValidationProcessor.validationCheck(
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Object>any(),
            Mockito.<Supplier<FormAction>>any()))
        .thenReturn(formAction);

    V4Initiator initiator = new V4Initiator();
    initiator.user(new V4User());

    V4Stream v4Stream = new V4Stream();
    v4Stream.streamType("ROOM");

    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    RealTimeEvent<V4SymphonyElementsAction> event =
        new RealTimeEvent<>(initiator, v4SymphonyElementsAction);

    // Act
    elementsHandler.accept(event);

    // Assert
    verify(messageService).getMessage("42");
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction, atLeast(1)).getStream();
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadRoomById(null);
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(null);
    verify(formValidationProcessor)
        .validationCheck(isNull(), isA(Addressable.class), isNull(), isA(Supplier.class));
  }
}
