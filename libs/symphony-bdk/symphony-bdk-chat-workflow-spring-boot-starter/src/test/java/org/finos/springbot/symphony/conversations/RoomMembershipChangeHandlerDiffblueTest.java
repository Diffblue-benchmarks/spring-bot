package org.finos.springbot.symphony.conversations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.gen.api.model.V4Initiator;
import com.symphony.bdk.gen.api.model.V4RoomCreated;
import com.symphony.bdk.gen.api.model.V4RoomProperties;
import com.symphony.bdk.gen.api.model.V4Stream;
import com.symphony.bdk.gen.api.model.V4User;
import com.symphony.bdk.gen.api.model.V4UserJoinedRoom;
import com.symphony.bdk.gen.api.model.V4UserLeftRoom;
import com.symphony.bdk.spring.events.RealTimeEvent;
import java.util.List;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.consumers.ActionConsumer;
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

@ContextConfiguration(classes = {RoomMembershipChangeHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RoomMembershipChangeHandlerDiffblueTest {
  @MockitoBean private ActionConsumer actionConsumer;

  @Autowired private List<ActionConsumer> list;

  @Autowired private RoomMembershipChangeHandler roomMembershipChangeHandler;

  @MockitoBean private SymphonyConversations symphonyConversations;

  /**
   * Test {@link RoomMembershipChangeHandler#created(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link V4RoomProperties} (default constructor) creatorUser {@link V4User} (default
   *       constructor).
   *   <li>Then calls {@link ActionConsumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RoomMembershipChangeHandler#created(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test created(RealTimeEvent); given V4RoomProperties (default constructor) creatorUser V4User (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RoomMembershipChangeHandler.created(RealTimeEvent)"})
  void testCreated_givenV4RoomPropertiesCreatorUserV4User_thenCallsAccept() {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));

    V4Stream stream = new V4Stream();
    stream.streamId("42");

    V4RoomProperties roomProperties = new V4RoomProperties();
    roomProperties.creatorUser(new V4User());

    V4RoomCreated v4RoomCreated = new V4RoomCreated();
    v4RoomCreated.roomProperties(roomProperties);
    v4RoomCreated.stream(stream);

    // Act
    roomMembershipChangeHandler.created(new RealTimeEvent<>(new V4Initiator(), v4RoomCreated));

    // Assert
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadRoomById(eq("42"));
    verify(symphonyConversations).loadUserById(isNull());
  }

  /**
   * Test {@link RoomMembershipChangeHandler#joined(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link V4User} (default constructor).
   *   <li>When {@link V4UserJoinedRoom} (default constructor) affectedUser {@link V4User} (default
   *       constructor).
   *   <li>Then calls {@link ActionConsumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RoomMembershipChangeHandler#joined(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test joined(RealTimeEvent); given V4User (default constructor); when V4UserJoinedRoom (default constructor) affectedUser V4User (default constructor); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RoomMembershipChangeHandler.joined(RealTimeEvent)"})
  void testJoined_givenV4User_whenV4UserJoinedRoomAffectedUserV4User_thenCallsAccept() {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));

    V4Stream stream = new V4Stream();
    stream.streamId("42");

    V4UserJoinedRoom v4UserJoinedRoom = new V4UserJoinedRoom();
    v4UserJoinedRoom.affectedUser(new V4User());
    v4UserJoinedRoom.stream(stream);

    // Act
    roomMembershipChangeHandler.joined(new RealTimeEvent<>(new V4Initiator(), v4UserJoinedRoom));

    // Assert
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadRoomById(eq("42"));
    verify(symphonyConversations).loadUserById(isNull());
  }

  /**
   * Test {@link RoomMembershipChangeHandler#left(RealTimeEvent)}.
   *
   * <ul>
   *   <li>Given {@link ActionConsumer} {@link ActionConsumer#accept(Object)} does nothing.
   *   <li>Then calls {@link ActionConsumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RoomMembershipChangeHandler#left(RealTimeEvent)}
   */
  @Test
  @DisplayName(
      "Test left(RealTimeEvent); given ActionConsumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RoomMembershipChangeHandler.left(RealTimeEvent)"})
  void testLeft_givenActionConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    doNothing().when(actionConsumer).accept(Mockito.<Action>any());
    when(symphonyConversations.loadUserById(Mockito.<Long>any())).thenReturn(new SymphonyUser(1L));
    when(symphonyConversations.loadRoomById(Mockito.<String>any()))
        .thenReturn(new SymphonyRoom("Name", "42"));

    V4Stream stream = new V4Stream();
    stream.streamId("42");

    V4UserLeftRoom v4UserLeftRoom = new V4UserLeftRoom();
    v4UserLeftRoom.affectedUser(new V4User());
    v4UserLeftRoom.stream(stream);

    // Act
    roomMembershipChangeHandler.left(new RealTimeEvent<>(new V4Initiator(), v4UserLeftRoom));

    // Assert
    verify(actionConsumer).accept(isA(Action.class));
    verify(symphonyConversations).loadRoomById(eq("42"));
    verify(symphonyConversations).loadUserById(isNull());
  }
}
