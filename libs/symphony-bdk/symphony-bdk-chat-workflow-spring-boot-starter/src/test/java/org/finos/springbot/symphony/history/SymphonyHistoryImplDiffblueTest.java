package org.finos.springbot.symphony.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.symphony.bdk.gen.api.model.V4Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.conversations.SymphonyConversationsImpl;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class SymphonyHistoryImplDiffblueTest {
  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(new ArrayList<>()).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());
    out.add(new V4Message());

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(null, null, new SymphonyConversationsImpl(
        streamsApi2, userService, new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    V4Message v4Message = new V4Message();
    v4Message.data("Data");

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(v4Message);

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  void testConvertToOptionalEntityJson6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(null);

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}
   */
  @Test
  void testConvertToOptionalInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalInstance(type, new ArrayList<>()).isPresent());
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  void testGetFromEntityJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));
    ArrayList<EntityJson> ej = new ArrayList<>();
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  void testGetFromEntityJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(new EntityJson());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  void testGetFromEntityJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(new EntityJson());
    ej.add(new EntityJson());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  void testGetFromEntityJson4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");

    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(entityJson);
    Class<Object> type = Object.class;

    // Act
    List<Object> actualFromEntityJson = symphonyHistoryImpl.getFromEntityJson(ej, type);

    // Assert
    assertEquals(1, actualFromEntityJson.size());
    assertEquals("42", actualFromEntityJson.get(0));
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)}
   */
  @Test
  void testGetFromEntityJson5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));
    EntityJson ej = new EntityJson();
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getFromEntityJson(ej, required).isPresent());
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#isSupported(Addressable)}
   */
  @Test
  void testIsSupported() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    // Act and Assert
    assertTrue(symphonyHistoryImpl.isSupported(new SymphonyRoom("Name", "42")));
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  void testGetEntityJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    // Act and Assert
    assertNull(symphonyHistoryImpl.getEntityJson(new V4Message()));
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  void testGetEntityJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(null, null, new SymphonyConversationsImpl(
        streamsApi2, userService, new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    // Act and Assert
    assertNull(symphonyHistoryImpl.getEntityJson(new V4Message()));
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  void testGetEntityJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));

    V4Message msg = new V4Message();
    msg.data("Data");

    // Act and Assert
    assertNull(symphonyHistoryImpl.getEntityJson(msg));
  }

  /**
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  void testGetEntityJson4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);

    // Act and Assert
    assertNull((new SymphonyHistoryImpl(jsonConverter, null, new SymphonyConversationsImpl(streamsApi2, userService,
        new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true))).getEntityJson(null));
  }

  /**
   * Method under test:
   * {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  void testGetRelevantObject() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    EntityJsonConverter jsonConverter = new EntityJsonConverter(om, new ArrayList<>());

    StreamsApi streamsApi = new StreamsApi(null);
    RoomMembershipApi membershipApi = new RoomMembershipApi(null);
    ShareApi shareApi = new ShareApi(null);
    StreamService streamsApi2 = new StreamService(streamsApi, membershipApi, shareApi,
        new RetryWithRecoveryBuilder<>());

    UserApi userApi = new UserApi(null);
    UsersApi usersApi = new UsersApi(null);
    AuditTrailApi auditTrailApi = new AuditTrailApi(null);
    UserService userService = new UserService(userApi, usersApi, auditTrailApi, new RetryWithRecoveryBuilder<>());

    SessionApi sessionApi = new SessionApi(null);
    SymphonyHistoryImpl symphonyHistoryImpl = new SymphonyHistoryImpl(jsonConverter, null,
        new SymphonyConversationsImpl(streamsApi2, userService,
            new SessionService(sessionApi, new RetryWithRecoveryBuilder<>()), true));
    Optional<EntityJson> ej = Optional.of(new EntityJson());
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getRelevantObject(ej, required).isPresent());
  }
}
