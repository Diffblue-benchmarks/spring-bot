package org.finos.springbot.symphony.messages;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.gen.api.model.V4Initiator;
import com.symphony.bdk.gen.api.model.V4Message;
import com.symphony.bdk.gen.api.model.V4MessageSent;
import com.symphony.bdk.gen.api.model.V4Stream;
import com.symphony.bdk.gen.api.model.V4User;
import com.symphony.bdk.spring.events.RealTimeEvent;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.symphony.content.serialization.MessageMLParser;
import org.finos.springbot.symphony.conversations.SymphonyConversations;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.data.EntityJsonConverter;
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

@ContextConfiguration(classes = {PresentationMLHandler.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PresentationMLHandlerDiffblueTest {
  @MockBean
  private ActionConsumer actionConsumer;

  @MockBean
  private EntityJsonConverter entityJsonConverter;

  @Autowired
  private List<ActionConsumer> list;

  @MockBean
  private MessageMLParser messageMLParser;

  @Autowired
  private PresentationMLHandler presentationMLHandler;

  @MockBean
  private SymphonyConversations symphonyConversations;

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code RealTimeEvent}.
   * <p>
   * Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent() {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));

    V4User user = new V4User();
    user.username("janedoe");
    V4Stream stream = mock(V4Stream.class);
    when(stream.getStreamType()).thenReturn("Stream Type");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(user);

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    // Act
    presentationMLHandler.onApplicationEvent(new RealTimeEvent<>(new V4Initiator(), v4MessageSent));

    // Assert
    verify(stream).getStreamType();
    verify(actionConsumer).accept(isA(Action.class));
    verify(messageMLParser).apply((String) isNull(), isA(EntityJson.class));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code RealTimeEvent}.
   * <ul>
   *   <li>Given {@link ActionConsumer}.</li>
   *   <li>Then calls {@link MessageMLParser#apply(String, EntityJson)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given ActionConsumer; then calls apply(String, EntityJson)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenActionConsumer_thenCallsApply() {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4User user = new V4User();
    user.username("janedoe");

    V4Message message = new V4Message();
    message.user(user);

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    // Act
    presentationMLHandler.onApplicationEvent(new RealTimeEvent<>(new V4Initiator(), v4MessageSent));

    // Assert
    verify(messageMLParser).apply((String) isNull(), isA(EntityJson.class));
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code RealTimeEvent}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link RealTimeEvent#getSource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given 'null'; then calls getSource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenNull_thenCallsGetSource() {
    // Arrange
    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(null);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code RealTimeEvent}.
   * <ul>
   *   <li>Given {@link V4Message} (default constructor) stream {@link V4Stream} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given V4Message (default constructor) stream V4Stream (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenV4MessageStreamV4Stream() {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4User user = new V4User();
    user.username("janedoe");

    V4Message message = new V4Message();
    message.stream(new V4Stream());
    message.user(user);

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    // Act
    presentationMLHandler.onApplicationEvent(new RealTimeEvent<>(new V4Initiator(), v4MessageSent));

    // Assert
    verify(messageMLParser).apply((String) isNull(), isA(EntityJson.class));
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code RealTimeEvent}.
   * <ul>
   *   <li>Then calls {@link V4Stream#getStreamId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; then calls getStreamId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_thenCallsGetStreamId() {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadRoomById(Mockito.<String>any())).thenReturn(new SymphonyRoom("Name", "42"));
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));

    V4User user = new V4User();
    user.username("janedoe");
    V4Stream stream = mock(V4Stream.class);
    when(stream.getStreamId()).thenReturn("42");
    when(stream.getStreamType()).thenReturn("ROOM");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(user);

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    // Act
    presentationMLHandler.onApplicationEvent(new RealTimeEvent<>(new V4Initiator(), v4MessageSent));

    // Assert
    verify(stream).getStreamId();
    verify(stream).getStreamType();
    verify(actionConsumer).accept(isA(Action.class));
    verify(messageMLParser).apply((String) isNull(), isA(EntityJson.class));
    verify(symphonyConversations).loadRoomById(eq("42"));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue(isNull());
  }
}
