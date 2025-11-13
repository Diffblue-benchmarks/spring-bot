package org.finos.springbot.teams.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage.Filter;
import org.finos.springbot.workflow.content.Addressable;
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

@ContextConfiguration(classes = {StateStorageBasedTeamsHistory.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class StateStorageBasedTeamsHistoryDiffblueTest {
  @Autowired private StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  /**
   * Test {@link StateStorageBasedTeamsHistory#StateStorageBasedTeamsHistory(TeamsStateStorage)}.
   *
   * <p>Method under test: {@link
   * StateStorageBasedTeamsHistory#StateStorageBasedTeamsHistory(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test new StateStorageBasedTeamsHistory(TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StateStorageBasedTeamsHistory.<init>(TeamsStateStorage)"})
  void testNewStateStorageBasedTeamsHistory() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertTrue(
        new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc)).tss
            instanceof MemoryStateStorage);
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}.
   *
   * <ul>
   *   <li>When {@link Addressable}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when Addressable; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateStorageBasedTeamsHistory.isSupported(Addressable)"})
  void testIsSupported_whenAddressable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(stateStorageBasedTeamsHistory.isSupported(mock(Addressable.class)));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}.
   *
   * <ul>
   *   <li>When {@link TeamsAddressable}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when TeamsAddressable; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StateStorageBasedTeamsHistory.isSupported(Addressable)"})
  void testIsSupported_whenTeamsAddressable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(stateStorageBasedTeamsHistory.isSupported(mock(TeamsAddressable.class)));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with
   * {@code type}, {@code address}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; then return get() is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeAddress_thenReturnGetIsValue() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(".", "Value");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertEquals("Value", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with
   * {@code type}, {@code address}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; when 'java.lang.Object'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeAddress_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with
   * {@code type}, {@code address}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; when 'java.lang.Object'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeAddress_whenJavaLangObject_thenReturnNotPresent2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   * with {@code type}, {@code expectedTag}, {@code address}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return get() is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, String, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnGetIsValue() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "Value");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag", address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertEquals("Value", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   * with {@code type}, {@code expectedTag}, {@code address}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, String, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnNotPresent() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag", address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   * with {@code type}, {@code expectedTag}, {@code address}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String,
   * TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.getLastFromHistory(Class, String, TeamsAddressable)"
  })
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnNotPresent2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory =
        stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag", address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is {@code Value}.
   *   <li>Then return {@link Optional#get()} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findObjectFromItem(Class, Iterable, boolean); given HashMap() 'Key' is 'Value'; then return get() is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.findObjectFromItem(Class, Iterable, boolean)"
  })
  void testFindObjectFromItem_givenHashMapKeyIsValue_thenReturnGetIsValue() {
    // Arrange
    Class<Object> type = Object.class;

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("Key", "Value");

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(stringObjectMap);

    // Act
    Optional<Object> actualFindObjectFromItemResult =
        StateStorageBasedTeamsHistory.findObjectFromItem(type, data, true);

    // Assert
    assertEquals("Value", actualFindObjectFromItemResult.get());
    assertTrue(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@code Object}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findObjectFromItem(Class, Iterable, boolean); given HashMap(); when 'java.lang.Object'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.findObjectFromItem(Class, Iterable, boolean)"
  })
  void testFindObjectFromItem_givenHashMap_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(new HashMap<>());

    // Act
    Optional<Object> actualFindObjectFromItemResult =
        StateStorageBasedTeamsHistory.findObjectFromItem(type, data, true);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findObjectFromItem(Class, Iterable, boolean); given HashMap(); when LinkedHashSet() add HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.findObjectFromItem(Class, Iterable, boolean)"
  })
  void testFindObjectFromItem_givenHashMap_whenLinkedHashSetAddHashMap() {
    // Arrange
    Class<Object> type = Object.class;

    LinkedHashSet<Map<String, Object>> data = new LinkedHashSet<>();
    data.add(new HashMap<>());

    // Act
    Optional<Object> actualFindObjectFromItemResult =
        StateStorageBasedTeamsHistory.findObjectFromItem(type, data, false);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findObjectFromItem(Class, Iterable, boolean); when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional StateStorageBasedTeamsHistory.findObjectFromItem(Class, Iterable, boolean)"
  })
  void testFindObjectFromItem_whenArrayList_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualFindObjectFromItemResult =
        StateStorageBasedTeamsHistory.findObjectFromItem(type, new ArrayList<>(), true);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is {@code Value}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class,
   * Iterable)}
   */
  @Test
  @DisplayName(
      "Test findObjectsFromItems(Class, Iterable); given HashMap() 'Key' is 'Value'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.findObjectsFromItems(Class, Iterable)"})
  void testFindObjectsFromItems_givenHashMapKeyIsValue_thenReturnSizeIsOne() {
    // Arrange
    Class<Object> type = Object.class;

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("Key", "Value");

    LinkedHashSet<Map<String, Object>> data = new LinkedHashSet<>();
    data.add(stringObjectMap);

    // Act
    List<Object> actualFindObjectsFromItemsResult =
        StateStorageBasedTeamsHistory.findObjectsFromItems(type, data);

    // Assert
    assertEquals(1, actualFindObjectsFromItemsResult.size());
    assertEquals("Value", actualFindObjectsFromItemsResult.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@code Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class,
   * Iterable)}
   */
  @Test
  @DisplayName(
      "Test findObjectsFromItems(Class, Iterable); given HashMap(); when 'java.lang.Object'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.findObjectsFromItems(Class, Iterable)"})
  void testFindObjectsFromItems_givenHashMap_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    LinkedHashSet<Map<String, Object>> data = new LinkedHashSet<>();
    data.add(new HashMap<>());

    // Act
    List<Object> actualFindObjectsFromItemsResult =
        StateStorageBasedTeamsHistory.findObjectsFromItems(type, data);

    // Assert
    assertTrue(actualFindObjectsFromItemsResult.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class,
   * Iterable)}
   */
  @Test
  @DisplayName("Test findObjectsFromItems(Class, Iterable); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.findObjectsFromItems(Class, Iterable)"})
  void testFindObjectsFromItems_whenArrayList_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    List<Object> actualFindObjectsFromItemsResult =
        StateStorageBasedTeamsHistory.findObjectsFromItems(type, new ArrayList<>());

    // Assert
    assertTrue(actualFindObjectsFromItemsResult.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.
   *   <li>When {@code Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test getList(Class, String, String, Instant); given ArrayList() add HashMap(); when 'java.lang.Object'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.getList(Class, String, String, Instant)"})
  void testGetList_givenArrayListAddHashMap_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList =
        stateStorageBasedTeamsHistory.getList(
            type,
            "Expected Tag",
            "/directory",
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertTrue(actualList.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code tag} is {@code Value}.
   *   <li>When {@code Object}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test getList(Class, String, String, Instant); given HashMap() 'tag' is 'Value'; when 'java.lang.Object'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.getList(Class, String, String, Instant)"})
  void testGetList_givenHashMapTagIsValue_whenJavaLangObject_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "Value");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList =
        stateStorageBasedTeamsHistory.getList(
            type,
            "Expected Tag",
            "/directory",
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertEquals(1, actualList.size());
    assertEquals("Value", actualList.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String,
   * Instant)}
   */
  @Test
  @DisplayName(
      "Test getList(Class, String, String, Instant); when 'java.lang.Object'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.getList(Class, String, String, Instant)"})
  void testGetList_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList =
        stateStorageBasedTeamsHistory.getList(
            type,
            "Expected Tag",
            "/directory",
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertTrue(actualList.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String,
   * Instant)}
   */
  @Test
  @DisplayName("Test getList(Class, String, String, Instant); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List StateStorageBasedTeamsHistory.getList(Class, String, String, Instant)"})
  void testGetList_whenNull_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList =
        stateStorageBasedTeamsHistory.getList(type, "Expected Tag", "/directory", null);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertTrue(actualList.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable,
   * Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, String, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassStringTeamsAddressableInstant() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory =
        new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc));
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(type, "foo", address, null);

    // Assert
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable,
   * Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, String, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            "foo",
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable,
   * Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, String, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnEmpty2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            "foo",
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable,
   * Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, String, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "Value");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            "foo",
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertEquals(1, actualFromHistory.size());
    assertEquals("Value", actualFromHistory.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   * with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassTeamsAddressableInstant() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory =
        new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc));
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(type, address, null);

    // Assert
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   * with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   * with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnEmpty2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   * with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class,
   * TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName(
      "Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List StateStorageBasedTeamsHistory.getFromHistory(Class, TeamsAddressable, Instant)"
  })
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(".", "Value");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory =
        stateStorageBasedTeamsHistory.getFromHistory(
            type,
            address,
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertEquals(1, actualFromHistory.size());
    assertEquals("Value", actualFromHistory.get(0));
  }
}
