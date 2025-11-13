package org.finos.springbot.symphony.messages;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.symphony.bdk.core.retry.RetryWithRecoveryBuilder;
import com.symphony.bdk.core.service.session.SessionService;
import com.symphony.bdk.core.service.stream.StreamService;
import com.symphony.bdk.core.service.user.UserService;
import com.symphony.bdk.gen.api.AuditTrailApi;
import com.symphony.bdk.gen.api.RoomMembershipApi;
import com.symphony.bdk.gen.api.SessionApi;
import com.symphony.bdk.gen.api.ShareApi;
import com.symphony.bdk.gen.api.StreamsApi;
import com.symphony.bdk.gen.api.UserApi;
import com.symphony.bdk.gen.api.UsersApi;
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
import org.finos.springbot.symphony.conversations.SymphonyConversationsImpl;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PresentationMLHandler.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class PresentationMLHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @Autowired private List<ActionConsumer> list;

  @MockitoBean private MessageMLParser messageMLParser;

  @Autowired private PresentationMLHandler presentationMLHandler;

  @MockitoBean private SymphonyConversations symphonyConversations;

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent() throws JsonProcessingException {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenThrow(new RuntimeException());

    V4Message message = new V4Message();
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent2() throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    V4Stream stream = new V4Stream();
    stream.streamType("ROOM");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(symphonyConversations).loadRoomById(null);
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent3() throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doThrow(new RuntimeException()).when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));

    V4Stream stream = new V4Stream();
    stream.streamType("ROOM");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(actionConsumer).accept(isA(Action.class));
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(symphonyConversations).loadRoomById(null);
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent4() throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenThrow(new RuntimeException());

    V4Stream stream = new V4Stream();
    stream.streamType("Stream Type");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent5() throws JsonProcessingException {
    // Arrange
    MessageMLParser messageParser = new MessageMLParser();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);

    StreamService streamsApi2 =
        new StreamService(streamsApi, membershipApi, shareApi, new RetryWithRecoveryBuilder<>());
    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);

    UserService userService =
        new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl ruBuilder =
        new SymphonyConversationsImpl(streamsApi2, userService, sessionService, true);

    PresentationMLHandler presentationMLHandler =
        new PresentationMLHandler(
            messageParser, jsonConverter, messageConsumers, ruBuilder, "janedoe");

    V4Message message = new V4Message();
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link ActionConsumer#accept(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given ActionConsumer accept(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenActionConsumerAcceptDoesNothing()
      throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));

    V4Stream stream = new V4Stream();
    stream.streamType("ROOM");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(actionConsumer).accept(isA(Action.class));
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(symphonyConversations).loadRoomById(null);
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link ActionConsumer#accept(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given ActionConsumer accept(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenActionConsumerAcceptDoesNothing2()
      throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));

    V4Stream stream = new V4Stream();
    stream.streamType("Stream Type");

    V4Message message = new V4Message();
    message.stream(stream);
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(actionConsumer).accept(isA(Action.class));
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(symphonyConversations).loadUserById(isNull());
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenNull() {
    // Arrange
    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(null);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@link V4Message} (default constructor) data {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given V4Message (default constructor) data 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenV4MessageDataSource() {
    // Arrange
    MessageMLParser messageParser = new MessageMLParser();
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());
    ArrayList<ActionConsumer> messageConsumers = new ArrayList<>();
    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);

    StreamService streamsApi2 =
        new StreamService(streamsApi, membershipApi, shareApi, new RetryWithRecoveryBuilder<>());
    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);

    UserService userService =
        new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl ruBuilder =
        new SymphonyConversationsImpl(streamsApi2, userService, sessionService, true);

    PresentationMLHandler presentationMLHandler =
        new PresentationMLHandler(
            messageParser, jsonConverter, messageConsumers, ruBuilder, "janedoe");

    V4Message message = new V4Message();
    message.user(new V4User());
    message.data("Source");
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Given {@link V4Message} (default constructor) stream {@link V4Stream} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; given V4Message (default constructor) stream V4Stream (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_givenV4MessageStreamV4Stream()
      throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4Message message = new V4Message();
    message.stream(new V4Stream());
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link MessageMLParser#apply(String, EntityJson)}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; then calls apply(String, EntityJson)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_thenCallsApply() throws JsonProcessingException {
    // Arrange
    when(messageMLParser.apply(Mockito.<String>any(), Mockito.<EntityJson>any()))
        .thenReturn(new MessageImpl(new ArrayList<>()));
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    V4Message message = new V4Message();
    message.user(new V4User());

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    message.data(jsonMapper.writeValueAsString(new EntityJson()));
    message.message("<messageML>");

    V4MessageSent v4MessageSent = new V4MessageSent();
    v4MessageSent.message(message);

    RealTimeEvent<V4MessageSent> t = mock(RealTimeEvent.class);
    when(t.getSource()).thenReturn(v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(t).getSource();
    verify(messageMLParser).apply(eq("<messageML>"), isA(EntityJson.class));
    verify(entityJsonConverter).readValue("{}");
  }

  /**
   * Test {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)} with {@code
   * RealTimeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link V4MessageSent#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link PresentationMLHandler#onApplicationEvent(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(RealTimeEvent) with 'RealTimeEvent'; then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PresentationMLHandler.onApplicationEvent(RealTimeEvent)"})
  void testOnApplicationEventWithRealTimeEvent_thenCallsGetMessage() {
    // Arrange
    V4MessageSent v4MessageSent = mock(V4MessageSent.class);
    when(v4MessageSent.getMessage()).thenThrow(new RuntimeException());
    RealTimeEvent<V4MessageSent> t = new RealTimeEvent<>(new V4Initiator(), v4MessageSent);

    // Act
    presentationMLHandler.onApplicationEvent(t);

    // Assert
    verify(v4MessageSent).getMessage();
  }
}
