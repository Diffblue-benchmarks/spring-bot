package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.teams.state.TeamsStateStorage.Filter;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.javatuples.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MemoryStateStorage.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class MemoryStateStorageDiffblueTest {
  @MockBean
  private EntityJsonConverter entityJsonConverter;

  @Autowired
  private MemoryStateStorage memoryStateStorage;

  /**
   * Test {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)}.
   * <p>
   * Method under test: {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)}
   */
  @Test
  @DisplayName("Test new MemoryStateStorage(EntityJsonConverter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.MemoryStateStorage.<init>(org.finos.springbot.workflow.data.EntityJsonConverter)"})
  void testNewMemoryStateStorage() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    MemoryStateStorage actualMemoryStateStorage = new MemoryStateStorage(
        new EntityJsonConverter(om, new ArrayList<>()));

    // Assert
    assertTrue(actualMemoryStateStorage.store.isEmpty());
    assertTrue(actualMemoryStateStorage.tagIndex.isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   * <p>
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.MemoryStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenThrow(new TeamsException("An error occurred"));
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
    verify(entityJsonConverter).writeValue(isA(Object.class));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then {@link MemoryStateStorage} {@link MemoryStateStorage#tagIndex} {@code File} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given '42'; when HashMap() '42' is '42'; then MemoryStateStorage tagIndex 'File' size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.MemoryStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_given42_whenHashMap42Is42_thenMemoryStateStorageTagIndexFileSizeIsTwo() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

    HashMap<String, String> tags = new HashMap<>();
    tags.put("42", "42");
    tags.put("foo", "foo");

    // Act
    memoryStateStorage.store("File", tags, new HashMap<>());

    // Assert
    verify(entityJsonConverter).writeValue(isA(Object.class));
    Map<String, List<Pair<String, String>>> stringListMap = memoryStateStorage.tagIndex;
    assertEquals(1, stringListMap.size());
    List<Pair<String, String>> getResult = stringListMap.get("File");
    assertEquals(2, getResult.size());
    List<Object> toListResult = getResult.get(1).toList();
    assertEquals(2, toListResult.size());
    assertEquals("42", toListResult.get(0));
    assertEquals("42", toListResult.get(1));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter} {@link EntityJsonConverter#writeValue(Object)} return {@code 42}.</li>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given EntityJsonConverter writeValue(Object) return '42'; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.MemoryStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenEntityJsonConverterWriteValueReturn42_thenThrowTeamsException() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
    verify(entityJsonConverter).writeValue(isA(Object.class));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then {@link MemoryStateStorage} {@link MemoryStateStorage#store} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given 'foo'; when HashMap() 'foo' is 'foo'; then MemoryStateStorage store size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.MemoryStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenFoo_whenHashMapFooIsFoo_thenMemoryStateStorageStoreSizeIsOne() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

    HashMap<String, String> tags = new HashMap<>();
    tags.put("foo", "foo");

    // Act
    memoryStateStorage.store("File", tags, new HashMap<>());

    // Assert
    verify(entityJsonConverter).writeValue(isA(Object.class));
    Map<String, String> stringStringMap = memoryStateStorage.store;
    assertEquals(1, stringStringMap.size());
    assertEquals("42", stringStringMap.get("File"));
    Map<String, List<Pair<String, String>>> stringListMap = memoryStateStorage.tagIndex;
    assertEquals(1, stringListMap.size());
    List<Pair<String, String>> getResult = stringListMap.get("File");
    assertEquals(1, getResult.size());
    List<Object> toListResult = getResult.get(0).toList();
    assertEquals(2, toListResult.size());
    assertEquals("foo", toListResult.get(0));
    assertEquals("foo", toListResult.get(1));
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(String)} with {@code file}.
   * <ul>
   *   <li>Then return {@link Optional#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; then return get() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.lang.String)"})
  void testRetrieveWithFile_thenReturnGetEmpty() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve("File");

    // Assert
    verify(entityJsonConverter).readValue(isNull());
    assertTrue(actualRetrieveResult.get().isEmpty());
    assertTrue(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(String)} with {@code file}.
   * <ul>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.Optional org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.lang.String)"})
  void testRetrieveWithFile_thenThrowTeamsException() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.retrieve("File"));
    verify(entityJsonConverter).readValue(isNull());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(new ArrayList<>(), true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.MemoryStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenFalse() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(new ArrayList<>(), false);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
