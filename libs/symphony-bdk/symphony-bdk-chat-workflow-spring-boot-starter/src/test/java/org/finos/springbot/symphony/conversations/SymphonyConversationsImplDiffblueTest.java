package org.finos.springbot.symphony.conversations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.auth.AuthSession;
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
import com.symphony.bdk.gen.api.model.RoomSystemInfo;
import com.symphony.bdk.gen.api.model.V2RoomSearchCriteria;
import com.symphony.bdk.gen.api.model.V3RoomAttributes;
import com.symphony.bdk.gen.api.model.V3RoomDetail;
import com.symphony.bdk.gen.api.model.V3RoomSearchResults;
import com.symphony.user.StreamID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.RoomName;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.symphonyoss.TaxonomyElement;

class SymphonyConversationsImplDiffblueTest {
  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    StreamService streamsApi = mock(StreamService.class);
    when(streamsApi.create(Mockito.<V3RoomAttributes>any()))
        .thenThrow(new SymphonyException("An error occurred"));
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act and Assert
    assertThrows(
        SymphonyException.class, () -> symphonyConversationsImpl.ensureChat(r, users, meta));
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName("Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doThrow(new SymphonyException("An error occurred"))
        .when(streamsApi)
        .addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act and Assert
    assertThrows(
        SymphonyException.class, () -> symphonyConversationsImpl.ensureChat(r, users, meta));
    verify(streamsApi).addMemberToRoom(1L, null);
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then calls {@link RoomMembershipApi#getApiClient()}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then calls getApiClient()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenCallsGetApiClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RoomMembershipApi membershipApi = mock(RoomMembershipApi.class);
    when(membershipApi.getApiClient()).thenThrow(new SymphonyException("An error occurred"));
    StreamService streamsApi =
        new StreamService(
            mock(StreamsApi.class),
            membershipApi,
            mock(ShareApi.class),
            mock(RetryWithRecoveryBuilder.class));

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act and Assert
    assertThrows(
        SymphonyException.class, () -> symphonyConversationsImpl.ensureChat(r, users, meta));
    verify(membershipApi).getApiClient();
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then calls {@link StreamsApi#getApiClient()}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then calls getApiClient()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenCallsGetApiClient2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    StreamsApi streamsApi = mock(StreamsApi.class);
    when(streamsApi.getApiClient()).thenThrow(new SymphonyException("An error occurred"));
    StreamService streamsApi2 =
        new StreamService(
            streamsApi,
            mock(RoomMembershipApi.class),
            mock(ShareApi.class),
            mock(AuthSession.class),
            mock(RetryWithRecoveryBuilder.class));

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi2, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act and Assert
    assertThrows(
        SymphonyException.class, () -> symphonyConversationsImpl.ensureChat(r, users, meta));
    verify(streamsApi).getApiClient();
    verify(r).getKey();
    verify(r).getName();
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then calls {@link SymphonyUser#getUserId()}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then calls getUserId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenCallsGetUserId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    SymphonyUser symphonyUser = mock(SymphonyUser.class);
    when(symphonyUser.getUserId()).thenReturn("42");

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(symphonyUser);
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(Mockito.<Long>any(), isNull());
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).promoteUserToRoomOwner(42L, null);
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    verify(symphonyUser).getUserId();
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof RoomName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("Name", actualEnsureChatResult.getName());
    assertEquals("Name", getResult.getValue());
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then Id first return {@link StreamID}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then Id first return StreamID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenIdFirstReturnStreamID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    RoomSystemInfo roomSystemInfo = new RoomSystemInfo();
    roomSystemInfo.id("42");

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(roomSystemInfo);

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(1L, "42");
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).promoteUserToRoomOwner(1L, "42");
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(0);
    assertTrue(getResult instanceof StreamID);
    assertEquals("42", actualEnsureChatResult.getKey());
    assertEquals("42", getResult.getValue());
    assertEquals("@", getResult.getSymbolPrefix());
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then Id second return {@link RoomName}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then Id second return RoomName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenIdSecondReturnRoomName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(1L, null);
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).promoteUserToRoomOwner(1L, null);
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof RoomName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("Name", actualEnsureChatResult.getName());
    assertEquals("Name", getResult.getValue());
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then Id second return {@link RoomName}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then Id second return RoomName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenIdSecondReturnRoomName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    defaultAdministrators.add(new SymphonyUser(1L));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(new SymphonyUser(1L));

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(1L, null);
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi, atLeast(1)).promoteUserToRoomOwner(1L, null);
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof RoomName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("Name", actualEnsureChatResult.getName());
    assertEquals("Name", getResult.getValue());
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenReturnKeyIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    SymphonyUser symphonyUser = mock(SymphonyUser.class);
    when(symphonyUser.getUserId()).thenReturn("42");

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(symphonyUser);
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn(null);

    SymphonyUser symphonyUser2 = mock(SymphonyUser.class);
    when(symphonyUser2.getUserId()).thenReturn("42");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(symphonyUser2);

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(42L, null);
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).promoteUserToRoomOwner(42L, null);
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    verify(symphonyUser).getUserId();
    verify(symphonyUser2).getUserId();
    assertNull(actualEnsureChatResult.getKey());
    assertNull(actualEnsureChatResult.getName());
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    assertNull(id.get(0));
    assertNull(id.get(1));
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>Then return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; then return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_thenReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(new SymphonyUser(1L));
    StreamService streamsApi =
        new StreamService(
            mock(StreamsApi.class),
            mock(RoomMembershipApi.class),
            mock(ShareApi.class),
            mock(AuthSession.class),
            mock(RetryWithRecoveryBuilder.class));
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn("Key");
    when(r.getName()).thenReturn("Name");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(null);

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(r, atLeast(1)).getKey();
    verify(r).getName();
    assertSame(r, actualEnsureChatResult);
  }

  /**
   * Test {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)} with {@code
   * SymphonyRoom}, {@code List}, {@code Map}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SymphonyUser}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyConversationsImpl#ensureChat(SymphonyRoom, List, Map)}
   */
  @Test
  @DisplayName(
      "Test ensureChat(SymphonyRoom, List, Map) with 'SymphonyRoom', 'List', 'Map'; when ArrayList() add SymphonyUser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SymphonyRoom SymphonyConversationsImpl.ensureChat(SymphonyRoom, List, Map)"})
  void testEnsureChatWithSymphonyRoomListMap_whenArrayListAddSymphonyUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<V3RoomDetail> rooms = new ArrayList<>();
    rooms.addAll(new ArrayList<>());

    V3RoomSearchResults v3RoomSearchResults = new V3RoomSearchResults();
    v3RoomSearchResults.rooms(rooms);

    V3RoomDetail v3RoomDetail = new V3RoomDetail();
    v3RoomDetail.roomSystemInfo(new RoomSystemInfo());

    StreamService streamsApi = mock(StreamService.class);
    doNothing().when(streamsApi).addMemberToRoom(Mockito.<Long>any(), Mockito.<String>any());
    doNothing().when(streamsApi).promoteUserToRoomOwner(Mockito.<Long>any(), Mockito.<String>any());
    when(streamsApi.create(Mockito.<V3RoomAttributes>any())).thenReturn(v3RoomDetail);
    when(streamsApi.searchRooms(Mockito.<V2RoomSearchCriteria>any()))
        .thenReturn(v3RoomSearchResults);

    SymphonyUser symphonyUser = mock(SymphonyUser.class);
    when(symphonyUser.getUserId()).thenReturn("42");

    ArrayList<User> defaultAdministrators = new ArrayList<>();
    defaultAdministrators.add(symphonyUser);
    UserService userService =
        new UserService(
            mock(UserApi.class),
            mock(UsersApi.class),
            mock(AuditTrailApi.class),
            mock(RetryWithRecoveryBuilder.class));
    SessionApi sessionApi = new SessionApi(null);
    SessionService sessionService =
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>());

    SymphonyConversationsImpl symphonyConversationsImpl =
        new SymphonyConversationsImpl(streamsApi, userService, sessionService, true);
    symphonyConversationsImpl.setDefaultAdministrators(defaultAdministrators);

    SymphonyRoom r = mock(SymphonyRoom.class);
    when(r.getKey()).thenReturn(null);
    when(r.getName()).thenReturn("Name");

    SymphonyUser symphonyUser2 = mock(SymphonyUser.class);
    when(symphonyUser2.getUserId()).thenReturn("42");

    ArrayList<SymphonyUser> users = new ArrayList<>();
    users.add(symphonyUser2);

    HashMap<String, Object> meta = new HashMap<>();
    meta.put(SymphonyConversations.ROOM_DESCRIPTION, "Meta");
    meta.put(SymphonyConversations.ROOM_PUBLIC, true);

    // Act
    SymphonyRoom actualEnsureChatResult = symphonyConversationsImpl.ensureChat(r, users, meta);

    // Assert
    verify(streamsApi, atLeast(1)).addMemberToRoom(42L, null);
    verify(streamsApi).create(isA(V3RoomAttributes.class));
    verify(streamsApi).promoteUserToRoomOwner(42L, null);
    verify(streamsApi).searchRooms(isA(V2RoomSearchCriteria.class));
    verify(r).getKey();
    verify(r).getName();
    verify(symphonyUser).getUserId();
    verify(symphonyUser2).getUserId();
    List<TaxonomyElement> id = actualEnsureChatResult.getId();
    assertEquals(2, id.size());
    TaxonomyElement getResult = id.get(1);
    assertTrue(getResult instanceof RoomName);
    assertEquals("@", getResult.getSymbolPrefix());
    assertEquals("Name", actualEnsureChatResult.getName());
    assertEquals("Name", getResult.getValue());
  }
}
