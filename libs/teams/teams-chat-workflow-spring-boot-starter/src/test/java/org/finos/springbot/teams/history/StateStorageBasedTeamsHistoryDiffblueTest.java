package org.finos.springbot.teams.history;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;

class StateStorageBasedTeamsHistoryDiffblueTest {
  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  void testIsSupported() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));

    // Act and Assert
    assertTrue(stateStorageBasedTeamsHistory.isSupported(new TeamsChannel("42", "Name")));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#isSupported(Addressable)}
   */
  @Test
  void testIsSupported2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertFalse(
        (new StateStorageBasedTeamsHistory(new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>()))))
            .isSupported(null));
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, String, TeamsAddressable)}
   */
  @Test
  void testGetLastFromHistory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(stateStorageBasedTeamsHistory.getLastFromHistory(type, "Expected Tag", new TeamsChannel("42", "Name"))
        .isPresent());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getLastFromHistory(Class, TeamsAddressable)}
   */
  @Test
  void testGetLastFromHistory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(stateStorageBasedTeamsHistory.getLastFromHistory(type, new TeamsChannel("42", "Name")).isPresent());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  void testFindObjectFromItem() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Optional<Object> actualFindObjectFromItemResult = StateStorageBasedTeamsHistory.findObjectFromItem(type,
        new ArrayList<>(), true);

    // Assert
    assertFalse(actualFindObjectFromItemResult.isPresent());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  void testFindObjectFromItem2() {
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
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  void testFindObjectFromItem3() {
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
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectFromItem(Class, Iterable, boolean)}
   */
  @Test
  void testFindObjectFromItem4() {
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
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  void testFindObjectsFromItems() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    List<Object> actualFindObjectsFromItemsResult = StateStorageBasedTeamsHistory.findObjectsFromItems(type,
        new ArrayList<>());

    // Assert
    assertTrue(actualFindObjectsFromItemsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  void testFindObjectsFromItems2() {
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
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#findObjectsFromItems(Class, Iterable)}
   */
  @Test
  void testFindObjectsFromItems3() {
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
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}
   */
  @Test
  void testGetList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(
        stateStorageBasedTeamsHistory
            .getList(type, "Expected Tag", "/directory",
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getList(Class, String, String, Instant)}
   */
  @Test
  void testGetList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(stateStorageBasedTeamsHistory.getList(type, "Expected Tag", "/directory", null).isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)}
   */
  @Test
  void testGetFromHistory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;
    TeamsChannel address = new TeamsChannel("42", "Name");

    // Act and Assert
    assertTrue(
        stateStorageBasedTeamsHistory
            .getFromHistory(type, "foo", address,
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getFromHistory(Class, String, TeamsAddressable, Instant)}
   */
  @Test
  void testGetFromHistory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(
        stateStorageBasedTeamsHistory.getFromHistory(type, "foo", new TeamsChannel("42", "Name"), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   */
  @Test
  void testGetFromHistory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;
    TeamsChannel address = new TeamsChannel("42", "Name");

    // Act and Assert
    assertTrue(stateStorageBasedTeamsHistory
        .getFromHistory(type, address, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#getFromHistory(Class, TeamsAddressable, Instant)}
   */
  @Test
  void testGetFromHistory4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    StateStorageBasedTeamsHistory stateStorageBasedTeamsHistory = new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())));
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue(stateStorageBasedTeamsHistory.getFromHistory(type, new TeamsChannel("42", "Name"), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link StateStorageBasedTeamsHistory#StateStorageBasedTeamsHistory(TeamsStateStorage)}
   */
  @Test
  void testNewStateStorageBasedTeamsHistory() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertTrue((new StateStorageBasedTeamsHistory(
        new MemoryStateStorage(new EntityJsonConverter(om, new ArrayList<>())))).tss instanceof MemoryStateStorage);
  }
}
