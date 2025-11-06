package org.finos.springbot.symphony.form;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.function.Consumer;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ElementsHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ElementsHandlerDiffblueTest {
  @MockBean
  private ActionConsumer actionConsumer;

  @Autowired
  private ElementsHandler elementsHandler;

  @MockBean
  private EntityJsonConverter entityJsonConverter;

  @MockBean
  private FormConverter formConverter;

  @MockBean
  private FormValidationProcessor formValidationProcessor;

  @Autowired
  private List<ActionConsumer> list;

  @MockBean
  private MessageService messageService;

  @MockBean
  private SymphonyConversations symphonyConversations;

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given ActionConsumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenActionConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);
    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any()))
        .thenReturn(new FormAction(a, u, "Form Data", "Action", new HashMap<>()));

    V4Initiator initiator = new V4Initiator();
    initiator.user(new V4User());
    V4Stream v4Stream = mock(V4Stream.class);
    when(v4Stream.getStreamType()).thenReturn("Stream Type");
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    // Act
    elementsHandler.accept(new RealTimeEvent<>(initiator, v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4Stream).getStreamType();
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isNull(), isNull(), isA(Supplier.class));
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@link FormValidationProcessor} {@link FormValidationProcessor#validationCheck(String, Addressable, Object, Supplier)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given FormValidationProcessor validationCheck(String, Addressable, Object, Supplier) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenFormValidationProcessorValidationCheckReturnNull() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any())).thenReturn(null);

    V4Initiator initiator = new V4Initiator();
    initiator.user(new V4User());
    V4Stream v4Stream = mock(V4Stream.class);
    when(v4Stream.getStreamType()).thenReturn("Stream Type");
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    // Act
    elementsHandler.accept(new RealTimeEvent<>(initiator, v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4Stream).getStreamType();
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isNull(), isNull(), isA(Supplier.class));
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@code Form Values}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given 'Form Values'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenFormValues() {
    // Arrange
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getFormValues()).thenReturn("Form Values");

    // Act
    elementsHandler.accept(new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction));

    // Assert
    verify(v4SymphonyElementsAction).getFormValues();
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@link MessageService} {@link MessageService#getMessage(String)} return {@code null}.</li>
   *   <li>Then calls {@link MessageService#getMessage(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given MessageService getMessage(String) return 'null'; then calls getMessage(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenMessageServiceGetMessageReturnNull_thenCallsGetMessage() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(null);
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    // Act
    elementsHandler.accept(new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link V4SymphonyElementsAction} {@link V4SymphonyElementsAction#getStream()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given 'null'; when V4SymphonyElementsAction getStream() return 'null'")
  @Tag("MaintainedByDiffblue")
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

    // Act
    elementsHandler.accept(new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@link V4Stream} {@link V4Stream#getStreamType()} return {@code Stream Type}.</li>
   *   <li>Then calls {@link V4Stream#getStreamType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given V4Stream getStreamType() return 'Stream Type'; then calls getStreamType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_givenV4StreamGetStreamTypeReturnStreamType_thenCallsGetStreamType() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    V4Stream v4Stream = mock(V4Stream.class);
    when(v4Stream.getStreamType()).thenReturn("Stream Type");
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    // Act
    elementsHandler.accept(new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4Stream).getStreamType();
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Given {@link V4Stream} (default constructor).</li>
   *   <li>When {@link V4SymphonyElementsAction} {@link V4SymphonyElementsAction#getStream()} return {@link V4Stream} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); given V4Stream (default constructor); when V4SymphonyElementsAction getStream() return V4Stream (default constructor)")
  @Tag("MaintainedByDiffblue")
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

    // Act
    elementsHandler.accept(new RealTimeEvent<>(new V4Initiator(), v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction).getStream();
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link ElementsHandler#accept(RealTimeEvent)}.
   * <ul>
   *   <li>Then calls {@link V4Stream#getStreamId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementsHandler#accept(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test accept(RealTimeEvent); then calls getStreamId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementsHandler.accept(RealTimeEvent)"})
  void testAccept_thenCallsGetStreamId() {
    // Arrange
    when(messageService.getMessage(Mockito.<String>any())).thenReturn(new V4Message());
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadRoomById(Mockito.<String>any())).thenReturn(new SymphonyRoom("Name", "42"));
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);
    when(formValidationProcessor.validationCheck(Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Object>any(), Mockito.<Supplier<FormAction>>any()))
        .thenReturn(new FormAction(a, u, "Form Data", "Action", new HashMap<>()));

    V4Initiator initiator = new V4Initiator();
    initiator.user(new V4User());
    V4Stream v4Stream = mock(V4Stream.class);
    when(v4Stream.getStreamId()).thenReturn("42");
    when(v4Stream.getStreamType()).thenReturn("ROOM");
    V4SymphonyElementsAction v4SymphonyElementsAction = mock(V4SymphonyElementsAction.class);
    when(v4SymphonyElementsAction.getStream()).thenReturn(v4Stream);
    when(v4SymphonyElementsAction.getFormId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormMessageId()).thenReturn("42");
    when(v4SymphonyElementsAction.getFormValues()).thenReturn(new HashMap<>());

    // Act
    elementsHandler.accept(new RealTimeEvent<>(initiator, v4SymphonyElementsAction));

    // Assert
    verify(messageService).getMessage(eq("42"));
    verify(v4Stream).getStreamId();
    verify(v4Stream).getStreamType();
    verify(v4SymphonyElementsAction).getFormId();
    verify(v4SymphonyElementsAction).getFormMessageId();
    verify(v4SymphonyElementsAction).getFormValues();
    verify(v4SymphonyElementsAction, atLeast(1)).getStream();
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadRoomById(eq("42"));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(isNull());
    verify(formValidationProcessor).validationCheck(isNull(), isA(Addressable.class), isNull(), isA(Supplier.class));
  }
}
