package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.entityjson.ObjectMapperFactory;
import org.finos.springbot.entityjson.VersionSpace;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MemoryStateStorage.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class MemoryStateStorageDiffblueTest {
  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @Autowired private MemoryStateStorage memoryStateStorage;

  /**
   * Test {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)}.
   *
   * <p>Method under test: {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)}
   */
  @Test
  @DisplayName("Test new MemoryStateStorage(EntityJsonConverter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.<init>(EntityJsonConverter)"})
  void testNewMemoryStateStorage() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    MemoryStateStorage actualMemoryStateStorage = new MemoryStateStorage(ejc);

    // Assert
    assertTrue(actualMemoryStateStorage.store.isEmpty());
    assertTrue(actualMemoryStateStorage.tagIndex.isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any()))
        .thenThrow(new TeamsException("An error occurred"));
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
    verify(entityJsonConverter).writeValue(isA(Object.class));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore2() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(ejc);
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter} {@link EntityJsonConverter#writeValue(Object)} return
   *       {@code 42}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given EntityJsonConverter writeValue(Object) return '42'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_givenEntityJsonConverterWriteValueReturn42_thenCallsWriteValue() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
    verify(entityJsonConverter).writeValue(isA(Object.class));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter} {@link EntityJsonConverter#writeValue(Object)} return
   *       {@code 42}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given EntityJsonConverter writeValue(Object) return '42'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_givenEntityJsonConverterWriteValueReturn42_whenNull() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.store("File", null, null));
    verify(entityJsonConverter).writeValue(isNull());
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given 'java.lang.Object'; when HashMap(); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_givenJavaLangObject_whenHashMap_thenThrowTeamsException() {
    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> class1 = Object.class;
    initial.add(ObjectMapperFactory.noVersion(class1));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter ejc = new EntityJsonConverter(om, initial);
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(ejc);
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then {@link MemoryStateStorage} {@link MemoryStateStorage#store} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given 'Key'; when HashMap() 'Key' is '42'; then MemoryStateStorage store size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_givenKey_whenHashMapKeyIs42_thenMemoryStateStorageStoreSizeIsOne() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

    HashMap<String, String> tags = new HashMap<>();
    tags.put("Key", "42");

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
    assertEquals("42", toListResult.get(1));
    assertEquals("Key", toListResult.get(0));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>Then {@link MemoryStateStorage} {@link MemoryStateStorage#tagIndex} {@code File} size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given 'Value'; then MemoryStateStorage tagIndex 'File' size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_givenValue_thenMemoryStateStorageTagIndexFileSizeIsTwo() {
    // Arrange
    when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

    HashMap<String, String> tags = new HashMap<>();
    tags.put("42", "Value");
    tags.put("Key", "42");

    // Act
    memoryStateStorage.store("File", tags, new HashMap<>());

    // Assert
    verify(entityJsonConverter).writeValue(isA(Object.class));
    Map<String, List<Pair<String, String>>> stringListMap = memoryStateStorage.tagIndex;
    assertEquals(1, stringListMap.size());
    List<Pair<String, String>> getResult = stringListMap.get("File");
    assertEquals(2, getResult.size());
    List<Object> toListResult = getResult.get(0).toList();
    assertEquals(2, toListResult.size());
    assertEquals("42", toListResult.get(0));
    List<Object> toListResult2 = getResult.get(1).toList();
    assertEquals(2, toListResult2.size());
    assertEquals("42", toListResult2.get(1));
    assertEquals("Key", toListResult2.get(0));
    assertEquals("Value", toListResult.get(1));
  }

  /**
   * Test {@link MemoryStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MemoryStateStorage.store(String, Map, Map)"})
  void testStore_whenNull() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(ejc);

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> memoryStateStorage.store("File", new HashMap<>(), null));
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; then return get() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MemoryStateStorage.retrieve(String)"})
  void testRetrieveWithFile_thenReturnGetEmpty() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any())).thenReturn(new EntityJson());

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve("File");

    // Assert
    verify(entityJsonConverter).readValue(null);
    assertTrue(actualRetrieveResult.get().isEmpty());
    assertTrue(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MemoryStateStorage.retrieve(String)"})
  void testRetrieveWithFile_thenReturnNotPresent() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act and Assert
    assertFalse(new MemoryStateStorage(ejc).retrieve("File").isPresent());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MemoryStateStorage.retrieve(String)"})
  void testRetrieveWithFile_thenThrowTeamsException() {
    // Arrange
    when(entityJsonConverter.readValue(Mockito.<String>any()))
        .thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.retrieve("File"));
    verify(entityJsonConverter).readValue(null);
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable MemoryStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable MemoryStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable MemoryStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult =
        memoryStateStorage.retrieve(new ArrayList<>(), true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link MemoryStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable MemoryStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenFalse() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult =
        memoryStateStorage.retrieve(new ArrayList<>(), false);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
