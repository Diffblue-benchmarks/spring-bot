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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DisabledInAotMode
@ContextConfiguration(classes = {StateStorageBasedTeamsHistory.class})
@ExtendWith(SpringExtension.class)
class StateStorageBasedTeamsHistoryDiffblueTest {
  @MockBean
  private TeamsStateStorage teamsStateStorage;

  @Autowired
  private StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory;

  /**
   * Test {@link StateStorageBasedTeamsHistory#StateStorageBasedTeamsHistory(TeamsStateStorage)}.
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#StateStorageBasedTeamsHistory(TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test new StateStorageBasedTeamsHistory(TeamsStateStorage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.<init>(org.finos.springbot.teams.state.TeamsStateStorage)"})
  void testNewStateStorageBasedTeamsHistory() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).tss instanceof MemoryStateStorage);
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when Addressable; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.isSupported(org.finos.springbot.workflow.content.Addressable)"})
  void testIsSupported_whenAddressable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(stateStorageBasedTeamsHistory.isSupported(mock(Addressable.class)));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}.
   * <ul>
   *   <li>When {@link TeamsChannel#TeamsChannel(String, String)} with id is {@code 42} and {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  @DisplayName("Test isSupported(Addressable); when TeamsChannel(String, String) with id is '42' and 'Name'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.isSupported(org.finos.springbot.workflow.content.Addressable)"})
  void testIsSupported_whenTeamsChannelWithIdIs42AndName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(stateStorageBasedTeamsHistory.isSupported(new TeamsChannel("42", "Name")));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with {@code type}, {@code address}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code .} is {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; given HashMap() '.' is '42'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeAddress_givenHashMapDotIs42_thenReturnGetIs42() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(".", "42");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertEquals("42", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with {@code type}, {@code address}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; when 'java.lang.Object'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeAddress_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)} with {@code type}, {@code address}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, TeamsAddressable) with 'type', 'address'; when 'java.lang.Object'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeAddress_whenJavaLangObject_thenReturnNotPresent2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)} with {@code type}, {@code expectedTag}, {@code address}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnGetIs42() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "42");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag",
        address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertEquals("42", actualLastFromHistory.get());
    assertTrue(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)} with {@code type}, {@code expectedTag}, {@code address}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnNotPresent() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag",
        address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)} with {@code type}, {@code expectedTag}, {@code address}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test getLastFromHistory(Class, String, TeamsAddressable) with 'type', 'expectedTag', 'address'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getLastFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable)"})
  void testGetLastFromHistoryWithTypeExpectedTagAddress_thenReturnNotPresent2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Optional<Object> actualLastFromHistory = stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag",
        address);

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(true));
    verify(address).getKey();
    assertFalse(actualLastFromHistory.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@link Optional#get()} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  @DisplayName("Test findObjectFromItem(Class, Iterable, boolean); given HashMap() 'foo' is '42'; when 'java.lang.Object'; then return get() is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectFromItem(java.lang.Class, java.lang.Iterable, boolean)"})
  void testFindObjectFromItem_givenHashMapFooIs42_whenJavaLangObject_thenReturnGetIs42() {
    // Arrange
    Class<Object> type = Object.class;

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(stringObjectMap);

    // Act
    Optional<Object> actualFindObjectFromItemResult = StateStorageBasedTeamsHistory.findObjectFromItem(type, data,
        true);

    // Assert
    assertEquals("42", actualFindObjectFromItemResult.get());
    assertTrue(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  @DisplayName("Test findObjectFromItem(Class, Iterable, boolean); given HashMap(); when 'false'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectFromItem(java.lang.Class, java.lang.Iterable, boolean)"})
  void testFindObjectFromItem_givenHashMap_whenFalse_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(new HashMap<>());

    // Act
    Optional<Object> actualFindObjectFromItemResult = StateStorageBasedTeamsHistory.findObjectFromItem(type, data,
        false);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  @DisplayName("Test findObjectFromItem(Class, Iterable, boolean); given HashMap(); when 'java.lang.Object'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectFromItem(java.lang.Class, java.lang.Iterable, boolean)"})
  void testFindObjectFromItem_givenHashMap_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(new HashMap<>());

    // Act
    Optional<Object> actualFindObjectFromItemResult = StateStorageBasedTeamsHistory.findObjectFromItem(type, data,
        true);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  @DisplayName("Test findObjectFromItem(Class, Iterable, boolean); when ArrayList(); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectFromItem(java.lang.Class, java.lang.Iterable, boolean)"})
  void testFindObjectFromItem_whenArrayList_thenReturnNotPresent() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualFindObjectFromItemResult = StateStorageBasedTeamsHistory.findObjectFromItem(type,
        new ArrayList<>(), true);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  @DisplayName("Test findObjectsFromItems(Class, Iterable); given HashMap() 'foo' is '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectsFromItems(java.lang.Class, java.lang.Iterable)"})
  void testFindObjectsFromItems_givenHashMapFooIs42_thenReturnSizeIsOne() {
    // Arrange
    Class<Object> type = Object.class;

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("foo", "42");

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(stringObjectMap);

    // Act
    List<Object> actualFindObjectsFromItemsResult = StateStorageBasedTeamsHistory.findObjectsFromItems(type, data);

    // Assert
    assertEquals(1, actualFindObjectsFromItemsResult.size());
    assertEquals("42", actualFindObjectsFromItemsResult.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  @DisplayName("Test findObjectsFromItems(Class, Iterable); given HashMap(); when 'java.lang.Object'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectsFromItems(java.lang.Class, java.lang.Iterable)"})
  void testFindObjectsFromItems_givenHashMap_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    data.add(new HashMap<>());

    // Act
    List<Object> actualFindObjectsFromItemsResult = StateStorageBasedTeamsHistory.findObjectsFromItems(type, data);

    // Assert
    assertTrue(actualFindObjectsFromItemsResult.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  @DisplayName("Test findObjectsFromItems(Class, Iterable); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.findObjectsFromItems(java.lang.Class, java.lang.Iterable)"})
  void testFindObjectsFromItems_whenArrayList_thenReturnEmpty() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    List<Object> actualFindObjectsFromItemsResult = StateStorageBasedTeamsHistory.findObjectsFromItems(type,
        new ArrayList<>());

    // Assert
    assertTrue(actualFindObjectsFromItemsResult.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashMap#HashMap()}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}
   */
  @Test
  @DisplayName("Test getList(Class, String, String, Instant); given ArrayList() add HashMap(); when 'java.lang.Object'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getList(java.lang.Class, java.lang.String, java.lang.String, java.time.Instant)"})
  void testGetList_givenArrayListAddHashMap_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList = stateStorageBasedTeamsHistory.getList(type, "Expected Tag", "/directory",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertTrue(actualList.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code tag} is {@code 42}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}
   */
  @Test
  @DisplayName("Test getList(Class, String, String, Instant); given HashMap() 'tag' is '42'; when 'java.lang.Object'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getList(java.lang.Class, java.lang.String, java.lang.String, java.time.Instant)"})
  void testGetList_givenHashMapTagIs42_whenJavaLangObject_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "42");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList = stateStorageBasedTeamsHistory.getList(type, "Expected Tag", "/directory",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertEquals(1, actualList.size());
    assertEquals("42", actualList.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}
   */
  @Test
  @DisplayName("Test getList(Class, String, String, Instant); when 'java.lang.Object'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getList(java.lang.Class, java.lang.String, java.lang.String, java.time.Instant)"})
  void testGetList_whenJavaLangObject_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;

    // Act
    List<Object> actualList = stateStorageBasedTeamsHistory.getList(type, "Expected Tag", "/directory",
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    assertTrue(actualList.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnEmpty2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)} with {@code Class}, {@code String}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, String, TeamsAddressable, Instant) with 'Class', 'String', 'TeamsAddressable', 'Instant'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, java.lang.String, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassStringTeamsAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("tag", "42");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, "foo", address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertEquals(1, actualFromHistory.size());
    assertEquals("42", actualFromHistory.get(0));
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)} with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnEmpty() {
    // Arrange
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(new ArrayList<>());
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)} with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnEmpty2() {
    // Arrange
    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(new HashMap<>());
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertTrue(actualFromHistory.isEmpty());
  }

  /**
   * Test {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)} with {@code Class}, {@code TeamsAddressable}, {@code Instant}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   */
  @Test
  @DisplayName("Test getFromHistory(Class, TeamsAddressable, Instant) with 'Class', 'TeamsAddressable', 'Instant'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.teams.history.StateStorageBasedTeamsHistory.getFromHistory(java.lang.Class, org.finos.springbot.teams.content.TeamsAddressable, java.time.Instant)"})
  void testGetFromHistoryWithClassTeamsAddressableInstant_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(".", "42");

    ArrayList<Map<String, Object>> mapList = new ArrayList<>();
    mapList.add(stringObjectMap);
    when(teamsStateStorage.retrieve(Mockito.<List<Filter>>any(), anyBoolean())).thenReturn(mapList);
    Class<Object> type = Object.class;
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    List<Object> actualFromHistory = stateStorageBasedTeamsHistory.getFromHistory(type, address,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(teamsStateStorage).retrieve(isA(List.class), eq(false));
    verify(address).getKey();
    assertEquals(1, actualFromHistory.size());
    assertEquals("42", actualFromHistory.get(0));
  }
}
