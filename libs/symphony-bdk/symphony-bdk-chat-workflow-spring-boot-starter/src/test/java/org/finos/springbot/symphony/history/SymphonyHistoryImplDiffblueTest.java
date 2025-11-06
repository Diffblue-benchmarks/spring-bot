package org.finos.springbot.symphony.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.service.message.MessageService;
import com.symphony.bdk.core.service.pagination.model.PaginationAttribute;
import com.symphony.bdk.gen.api.model.MessageSearchQuery;
import com.symphony.bdk.gen.api.model.V4Message;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.conversations.StreamResolver;
import org.finos.springbot.workflow.content.Addressable;
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

@ContextConfiguration(classes = {SymphonyHistoryImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SymphonyHistoryImplDiffblueTest {
  @MockBean
  private EntityJsonConverter entityJsonConverter;

  @MockBean
  private MessageService messageService;

  @MockBean
  private StreamResolver streamResolver;

  @Autowired
  private SymphonyHistoryImpl symphonyHistoryImpl;

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassStringSymphonyAddressable() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassStringSymphonyAddressable_givenArrayListAddNull() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassStringSymphonyAddressable_thenCallsReadValue() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassStringSymphonyAddressable_thenReturnGetIs42() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals("42", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassStringSymphonyAddressable_whenNull() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type, (String) null,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassSymphonyAddressable_givenArrayListAddNull() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; given EntityJsonConverter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassSymphonyAddressable_givenEntityJsonConverter() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassSymphonyAddressable_thenCallsReadValue() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassSymphonyAddressable_thenReturnGetIs42() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put(".", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals("42", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; when 'null'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastFromHistory(Class, SymphonyAddressable)"})
  void testGetLastFromHistoryWithClassSymphonyAddressable_whenNull_thenCallsReadValue() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");

    // Act
    Optional<Object> actualLastFromHistory = symphonyHistoryImpl.getLastFromHistory(null,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassStringSymphonyAddressable() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassStringSymphonyAddressable2() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualLastEntityJsonFromHistory.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualLastEntityJsonFromHistory.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassStringSymphonyAddressable3() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type, "foo",
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)} with {@code Class}, {@code String}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, String, SymphonyAddressable) with 'Class', 'String', 'SymphonyAddressable'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, String, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassStringSymphonyAddressable_whenNull() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type,
        (String) null, mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualLastEntityJsonFromHistory.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualLastEntityJsonFromHistory.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassSymphonyAddressable() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassSymphonyAddressable2() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertFalse(actualLastEntityJsonFromHistory.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; then return get() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassSymphonyAddressable_thenReturnGetEmpty() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(type,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualLastEntityJsonFromHistory.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualLastEntityJsonFromHistory.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)} with {@code Class}, {@code SymphonyAddressable}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getLastEntityJsonFromHistory(Class, SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getLastEntityJsonFromHistory(Class, SymphonyAddressable) with 'Class', 'SymphonyAddressable'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getLastEntityJsonFromHistory(Class, SymphonyAddressable)"})
  void testGetLastEntityJsonFromHistoryWithClassSymphonyAddressable_whenNull() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");

    // Act
    Optional<EntityJson> actualLastEntityJsonFromHistory = symphonyHistoryImpl.getLastEntityJsonFromHistory(null,
        mock(SymphonyAddressable.class));

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualLastEntityJsonFromHistory.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualLastEntityJsonFromHistory.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  @DisplayName("Test convertToOptionalEntityJson(List); given EntityJsonConverter; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalEntityJson(List)"})
  void testConvertToOptionalEntityJson_givenEntityJsonConverter_whenArrayList() {
    // Arrange, Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(new ArrayList<>()).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  @DisplayName("Test convertToOptionalEntityJson(List); given 'null'; when ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalEntityJson(List)"})
  void testConvertToOptionalEntityJson_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<V4Message> out = new ArrayList<>();
    out.add(null);

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalEntityJson(out).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  @DisplayName("Test convertToOptionalEntityJson(List); then return get() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalEntityJson(List)"})
  void testConvertToOptionalEntityJson_thenReturnGetEmpty() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());

    // Act
    Optional<EntityJson> actualConvertToOptionalEntityJsonResult = symphonyHistoryImpl.convertToOptionalEntityJson(out);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualConvertToOptionalEntityJsonResult.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualConvertToOptionalEntityJsonResult.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalEntityJson(List)}
   */
  @Test
  @DisplayName("Test convertToOptionalEntityJson(List); then return get() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalEntityJson(List)"})
  void testConvertToOptionalEntityJson_thenReturnGetEmpty2() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());
    out.add(new V4Message());

    // Act
    Optional<EntityJson> actualConvertToOptionalEntityJsonResult = symphonyHistoryImpl.convertToOptionalEntityJson(out);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    EntityJson getResult = actualConvertToOptionalEntityJsonResult.get();
    assertTrue(getResult.isEmpty());
    assertTrue(actualConvertToOptionalEntityJsonResult.isPresent());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}
   */
  @Test
  @DisplayName("Test convertToOptionalInstance(Class, List); given EntityJsonConverter; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalInstance(Class, List)"})
  void testConvertToOptionalInstance_givenEntityJsonConverter_whenArrayList() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.convertToOptionalInstance(type, new ArrayList<>()).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()} {@code foo} is {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}
   */
  @Test
  @DisplayName("Test convertToOptionalInstance(Class, List); given EntityJson() 'foo' is '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalInstance(Class, List)"})
  void testConvertToOptionalInstance_givenEntityJsonFooIs42_thenReturnGetIs42() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);
    Class<Object> type = Object.class;

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());

    // Act
    Optional<Object> actualConvertToOptionalInstanceResult = symphonyHistoryImpl.convertToOptionalInstance(type, out);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertEquals("42", actualConvertToOptionalInstanceResult.get());
    assertTrue(actualConvertToOptionalInstanceResult.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}
   */
  @Test
  @DisplayName("Test convertToOptionalInstance(Class, List); when 'java.lang.Object'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalInstance(Class, List)"})
  void testConvertToOptionalInstance_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    Class<Object> type = Object.class;

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());

    // Act
    Optional<Object> actualConvertToOptionalInstanceResult = symphonyHistoryImpl.convertToOptionalInstance(type, out);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertFalse(actualConvertToOptionalInstanceResult.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#convertToOptionalInstance(Class, List)}
   */
  @Test
  @DisplayName("Test convertToOptionalInstance(Class, List); when 'java.lang.Object'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.convertToOptionalInstance(Class, List)"})
  void testConvertToOptionalInstance_whenJavaLangObject_thenReturnNotPresent2() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    Class<Object> type = Object.class;

    ArrayList<V4Message> out = new ArrayList<>();
    out.add(new V4Message());
    out.add(new V4Message());

    // Act
    Optional<Object> actualConvertToOptionalInstanceResult = symphonyHistoryImpl.convertToOptionalInstance(type, out);

    // Assert
    verify(entityJsonConverter, atLeast(1)).readValue(isNull());
    assertFalse(actualConvertToOptionalInstanceResult.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant2() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant_thenCallsReadValue() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant_thenCallsReadValue2() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter, atLeast(1)).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals(1, actualFromHistory.size());
    assertEquals("42", actualFromHistory.get(0));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)} with {@code Class}, {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, SymphonyAddressable, Instant) with 'Class', 'String', 'SymphonyAddressable', 'Instant'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, String, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassStringSymphonyAddressableInstant_whenNull() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, (String) null, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; given ArrayList() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_givenArrayListAddNull() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; given EntityJsonConverter")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_givenEntityJsonConverter() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_thenCallsReadValue() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then calls {@link EntityJsonConverter#readValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; then calls readValue(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_thenCallsReadValue2() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter, atLeast(1)).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put(".", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals(1, actualFromHistory.size());
    assertEquals("42", actualFromHistory.get(0));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetFromHistoryWithClassSymphonyAddressableInstant_whenNull() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<Object> actualFromHistory = symphonyHistoryImpl.getFromHistory(null, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(EntityJson, Class) with 'ej', 'required'; given '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getFromEntityJson(EntityJson, Class)"})
  void testGetFromEntityJsonWithEjRequired_given42_thenReturnGetIs42() {
    // Arrange
    EntityJson ej = new EntityJson();
    ej.put("foo", "42");
    Class<Object> required = Object.class;

    // Act
    Optional<Object> actualFromEntityJson = symphonyHistoryImpl.getFromEntityJson(ej, required);

    // Assert
    assertEquals("42", actualFromEntityJson.get());
    assertTrue(actualFromEntityJson.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>When {@link EntityJson#EntityJson()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(EntityJson, Class) with 'ej', 'required'; when EntityJson(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getFromEntityJson(EntityJson, Class)"})
  void testGetFromEntityJsonWithEjRequired_whenEntityJson_thenReturnNotPresent() {
    // Arrange
    EntityJson ej = new EntityJson();
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getFromEntityJson(ej, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>When {@code Map$Entry}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(EntityJson, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(EntityJson, Class) with 'ej', 'required'; when 'java.util.Map$Entry'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getFromEntityJson(EntityJson, Class)"})
  void testGetFromEntityJsonWithEjRequired_whenJavaUtilMapEntry_thenReturnNotPresent() {
    // Arrange
    EntityJson ej = new EntityJson();
    ej.put("foo", "42");
    Class<Entry> required = Entry.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getFromEntityJson(ej, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)} with {@code ej}, {@code type}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()} {@code foo} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(List, Class) with 'ej', 'type'; given EntityJson() 'foo' is '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromEntityJson(List, Class)"})
  void testGetFromEntityJsonWithEjType_givenEntityJsonFooIs42_thenReturnSizeIsOne() {
    // Arrange
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
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)} with {@code ej}, {@code type}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()} {@code foo} is {@code 42}.</li>
   *   <li>When {@code Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(List, Class) with 'ej', 'type'; given EntityJson() 'foo' is '42'; when 'java.util.Map$Entry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromEntityJson(List, Class)"})
  void testGetFromEntityJsonWithEjType_givenEntityJsonFooIs42_whenJavaUtilMapEntry() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");

    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(entityJson);
    Class<Entry> type = Entry.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)} with {@code ej}, {@code type}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(List, Class) with 'ej', 'type'; given EntityJson(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromEntityJson(List, Class)"})
  void testGetFromEntityJsonWithEjType_givenEntityJson_thenReturnEmpty() {
    // Arrange
    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(new EntityJson());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)} with {@code ej}, {@code type}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(List, Class) with 'ej', 'type'; given EntityJson(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromEntityJson(List, Class)"})
  void testGetFromEntityJsonWithEjType_givenEntityJson_thenReturnEmpty2() {
    // Arrange
    ArrayList<EntityJson> ej = new ArrayList<>();
    ej.add(new EntityJson());
    ej.add(new EntityJson());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)} with {@code ej}, {@code type}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getFromEntityJson(List, Class)}
   */
  @Test
  @DisplayName("Test getFromEntityJson(List, Class) with 'ej', 'type'; when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getFromEntityJson(List, Class)"})
  void testGetFromEntityJsonWithEjType_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<EntityJson> ej = new ArrayList<>();
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(symphonyHistoryImpl.getFromEntityJson(ej, type).isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithClassSymphonyAddressableInstant() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithClassSymphonyAddressableInstant2() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals(1, actualEntityJsonFromHistory.size());
    EntityJson getResult = actualEntityJsonFromHistory.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithClassSymphonyAddressableInstant3() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter, atLeast(1)).readValue(isNull());
    assertEquals(2, actualEntityJsonFromHistory.size());
    EntityJson getResult = actualEntityJsonFromHistory.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(entityJson, getResult);
    assertSame(entityJson, actualEntityJsonFromHistory.get(1));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)} with {@code Class}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(Class, SymphonyAddressable, Instant) with 'Class', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(Class, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithClassSymphonyAddressableInstant4() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    Class<Object> type = Object.class;
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)} with {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(String, SymphonyAddressable, Instant) with 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(String, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithStringSymphonyAddressableInstant() {
    // Arrange
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(new ArrayList<>());
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory("foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)} with {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(String, SymphonyAddressable, Instant) with 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(String, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithStringSymphonyAddressableInstant2() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory("foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals(1, actualEntityJsonFromHistory.size());
    EntityJson getResult = actualEntityJsonFromHistory.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)} with {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(String, SymphonyAddressable, Instant) with 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(String, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithStringSymphonyAddressableInstant3() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory("foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter, atLeast(1)).readValue(isNull());
    assertEquals(2, actualEntityJsonFromHistory.size());
    EntityJson getResult = actualEntityJsonFromHistory.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(entityJson, getResult);
    assertSame(entityJson, actualEntityJsonFromHistory.get(1));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)} with {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(String, SymphonyAddressable, Instant) with 'String', 'SymphonyAddressable', 'Instant'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(String, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithStringSymphonyAddressableInstant4() {
    // Arrange
    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(null);
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory("foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertTrue(actualEntityJsonFromHistory.isEmpty());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)} with {@code String}, {@code SymphonyAddressable}, {@code Instant}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJsonFromHistory(String, SymphonyAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getEntityJsonFromHistory(String, SymphonyAddressable, Instant) with 'String', 'SymphonyAddressable', 'Instant'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List SymphonyHistoryImpl.getEntityJsonFromHistory(String, SymphonyAddressable, Instant)"})
  void testGetEntityJsonFromHistoryWithStringSymphonyAddressableInstant_whenNull() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    ArrayList<V4Message> v4MessageList = new ArrayList<>();
    v4MessageList.add(new V4Message());
    when(messageService.searchMessages(Mockito.<MessageSearchQuery>any(), Mockito.<PaginationAttribute>any()))
        .thenReturn(v4MessageList);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    SymphonyAddressable address = mock(SymphonyAddressable.class);

    // Act
    List<EntityJson> actualEntityJsonFromHistory = symphonyHistoryImpl.getEntityJsonFromHistory((String) null, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(messageService).searchMessages(isA(MessageSearchQuery.class), isA(PaginationAttribute.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    verify(entityJsonConverter).readValue(isNull());
    assertEquals(1, actualEntityJsonFromHistory.size());
    EntityJson getResult = actualEntityJsonFromHistory.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(entityJson, getResult);
  }

  /**
   * Test {@link SymphonyHistoryImpl#isSupported(Addressable)}.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when Addressable; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SymphonyHistoryImpl.isSupported(Addressable)"})
  void testIsSupported_whenAddressable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(symphonyHistoryImpl.isSupported(mock(Addressable.class)));
  }

  /**
   * Test {@link SymphonyHistoryImpl#isSupported(Addressable)}.
   * <ul>
   *   <li>When {@link SymphonyAddressable}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when SymphonyAddressable; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SymphonyHistoryImpl.isSupported(Addressable)"})
  void testIsSupported_whenSymphonyAddressable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(symphonyHistoryImpl.isSupported(mock(SymphonyAddressable.class)));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJson(V4Message)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  @DisplayName("Test getEntityJson(V4Message); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityJson SymphonyHistoryImpl.getEntityJson(V4Message)"})
  void testGetEntityJson_thenReturnEmpty() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);

    // Act
    EntityJson actualEntityJson = symphonyHistoryImpl.getEntityJson(new V4Message());

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualEntityJson.isEmpty());
    assertSame(entityJson, actualEntityJson);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getEntityJson(V4Message)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getEntityJson(V4Message)}
   */
  @Test
  @DisplayName("Test getEntityJson(V4Message); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityJson SymphonyHistoryImpl.getEntityJson(V4Message)"})
  void testGetEntityJson_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(symphonyHistoryImpl.getEntityJson(null));
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(Optional, Class) with 'ej', 'required'; given '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getRelevantObject(Optional, Class)"})
  void testGetRelevantObjectWithEjRequired_given42_thenReturnGetIs42() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    Optional<EntityJson> ej = Optional.of(entityJson);
    Class<Object> required = Object.class;

    // Act
    Optional<Object> actualRelevantObject = symphonyHistoryImpl.getRelevantObject(ej, required);

    // Assert
    assertEquals("42", actualRelevantObject.get());
    assertTrue(actualRelevantObject.isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(Optional, Class) with 'ej', 'required'; given '42'; when 'java.util.Map$Entry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getRelevantObject(Optional, Class)"})
  void testGetRelevantObjectWithEjRequired_given42_whenJavaUtilMapEntry() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    Optional<EntityJson> ej = Optional.of(entityJson);
    Class<Entry> required = Entry.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getRelevantObject(ej, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(Optional, Class) with 'ej', 'required'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getRelevantObject(Optional, Class)"})
  void testGetRelevantObjectWithEjRequired_thenReturnNotPresent() {
    // Arrange
    Optional<EntityJson> ej = Optional.of(new EntityJson());
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getRelevantObject(ej, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(Optional, Class) with 'ej', 'required'; when empty; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getRelevantObject(Optional, Class)"})
  void testGetRelevantObjectWithEjRequired_whenEmpty_thenReturnNotPresent() {
    // Arrange
    Optional<EntityJson> ej = Optional.empty();
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getRelevantObject(ej, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)} with {@code ej}, {@code required}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(Optional, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(Optional, Class) with 'ej', 'required'; when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional SymphonyHistoryImpl.getRelevantObject(Optional, Class)"})
  void testGetRelevantObjectWithEjRequired_whenNull_thenReturnNotPresent() {
    // Arrange
    Class<Object> required = Object.class;

    // Act and Assert
    assertFalse(symphonyHistoryImpl.getRelevantObject((Optional<EntityJson>) null, required).isPresent());
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)} with {@code msg}, {@code required}.
   * <ul>
   *   <li>Given {@link EntityJson#EntityJson()} {@code foo} is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(V4Message, Class) with 'msg', 'required'; given EntityJson() 'foo' is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object SymphonyHistoryImpl.getRelevantObject(V4Message, Class)"})
  void testGetRelevantObjectWithMsgRequired_givenEntityJsonFooIs42_thenReturn42() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);
    V4Message msg = new V4Message();
    Class<Object> required = Object.class;

    // Act
    Object actualRelevantObject = symphonyHistoryImpl.getRelevantObject(msg, required);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertEquals("42", actualRelevantObject);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)} with {@code msg}, {@code required}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(V4Message, Class) with 'msg', 'required'; when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object SymphonyHistoryImpl.getRelevantObject(V4Message, Class)"})
  void testGetRelevantObjectWithMsgRequired_whenJavaLangObject_thenReturnNull() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());
    V4Message msg = new V4Message();
    Class<Object> required = Object.class;

    // Act
    Object actualRelevantObject = symphonyHistoryImpl.getRelevantObject(msg, required);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertNull(actualRelevantObject);
  }

  /**
   * Test {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)} with {@code msg}, {@code required}.
   * <ul>
   *   <li>When {@code Map$Entry}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyHistoryImpl#getRelevantObject(V4Message, Class)}
   */
  @Test
  @DisplayName("Test getRelevantObject(V4Message, Class) with 'msg', 'required'; when 'java.util.Map$Entry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object SymphonyHistoryImpl.getRelevantObject(V4Message, Class)"})
  void testGetRelevantObjectWithMsgRequired_whenJavaUtilMapEntry_thenReturnNull() {
    // Arrange
    EntityJson entityJson = new EntityJson();
    entityJson.put("foo", "42");
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(entityJson);
    V4Message msg = new V4Message();
    Class<Entry> required = Entry.class;

    // Act
    Object actualRelevantObject = symphonyHistoryImpl.getRelevantObject(msg, required);

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertNull(actualRelevantObject);
  }
}
