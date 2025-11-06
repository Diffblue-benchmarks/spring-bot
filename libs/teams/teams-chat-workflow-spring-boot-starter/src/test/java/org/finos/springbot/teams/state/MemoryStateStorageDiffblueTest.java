package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

class MemoryStateStorageDiffblueTest {
  /**
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> (new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))).store("File", null, null));
  }

  /**
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> toUse = Object.class;
    initial.add(new VersionSpace(toUse));
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(
        new EntityJsonConverter(new ObjectMapper(), initial));
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> memoryStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));

    HashMap<String, String> tags = new HashMap<>();
    tags.put("foo", "foo");

    // Act
    memoryStateStorage.store("File", tags, new HashMap<>());

    // Assert
    Map<String, List<Pair<String, String>>> stringListMap = memoryStateStorage.tagIndex;
    assertEquals(1, stringListMap.size());
    List<Pair<String, String>> getResult = stringListMap.get("File");
    assertEquals(1, getResult.size());
    List<Object> toListResult = getResult.get(0).toList();
    assertEquals(2, toListResult.size());
    assertEquals("foo", toListResult.get(0));
    assertEquals("foo", toListResult.get(1));
    Map<String, String> stringStringMap = memoryStateStorage.store;
    assertEquals(1, stringStringMap.size());
    assertEquals("{}", stringStringMap.get("File"));
  }

  /**
   * Method under test: {@link MemoryStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));

    HashMap<String, String> tags = new HashMap<>();
    tags.put("42", "42");
    tags.put("foo", "foo");

    // Act
    memoryStateStorage.store("File", tags, new HashMap<>());

    // Assert
    Map<String, List<Pair<String, String>>> stringListMap = memoryStateStorage.tagIndex;
    assertEquals(1, stringListMap.size());
    List<Pair<String, String>> getResult = stringListMap.get("File");
    assertEquals(2, getResult.size());
    List<Object> toListResult = getResult.get(1).toList();
    assertEquals(2, toListResult.size());
    assertEquals("42", toListResult.get(0));
    assertEquals("42", toListResult.get(1));
    List<Object> toListResult2 = getResult.get(0).toList();
    assertEquals(2, toListResult2.size());
    assertEquals("foo", toListResult2.get(0));
    assertEquals("foo", toListResult2.get(1));
    Map<String, String> stringStringMap = memoryStateStorage.store;
    assertEquals(1, stringStringMap.size());
    assertEquals("{}", stringStringMap.get("File"));
  }

  /**
   * Method under test:
   * {@link MemoryStateStorage#MemoryStateStorage(EntityJsonConverter)}
   */
  @Test
  void testNewMemoryStateStorage() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act
    MemoryStateStorage actualMemoryStateStorage = new MemoryStateStorage(
        new EntityJsonConverter(om, new ArrayList<>()));

    // Assert
    assertTrue(actualMemoryStateStorage.store.isEmpty());
    assertTrue(actualMemoryStateStorage.tagIndex.isEmpty());
  }

  /**
   * Method under test: {@link MemoryStateStorage#retrieve(String)}
   */
  @Test
  void testRetrieve() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertFalse((new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))).retrieve("File").isPresent());
  }

  /**
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(new ArrayList<>(), true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));

    ArrayList<TeamsStateStorage.Filter> tags = new ArrayList<>();
    tags.add(new TeamsStateStorage.Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Method under test: {@link MemoryStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    MemoryStateStorage memoryStateStorage = new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()));

    ArrayList<TeamsStateStorage.Filter> tags = new ArrayList<>();
    tags.add(new TeamsStateStorage.Filter("Key"));
    tags.add(new TeamsStateStorage.Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = memoryStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
