package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FileStateStorage.class, EntityJsonConverter.class, String.class, ObjectMapper.class})
@ExtendWith(SpringExtension.class)
class FileStateStorageDiffblueTest {
  @Autowired
  private FileStateStorage fileStateStorage;

  /**
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    FileStateStorage fileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  void testStore2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> (new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()), "/directory/foo.txt")).store("/",
            null, null));
  }

  /**
   * Method under test:
   * {@link FileStateStorage#FileStateStorage(EntityJsonConverter, String)}
   */
  @Test
  void testNewFileStateStorage() {
    // Arrange
    ObjectMapper om = new ObjectMapper();

    // Act
    FileStateStorage actualFileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");

    // Assert
    assertTrue(actualFileStateStorage.store.isEmpty());
    assertTrue(actualFileStateStorage.tagIndex.isEmpty());
  }

  /**
   * Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  void testRetrieve() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("File").isPresent());
    assertFalse(fileStateStorage.retrieve("/").isPresent());
    assertFalse(fileStateStorage.retrieve("[^0-9a-zA-Z/]").isPresent());
    assertFalse(fileStateStorage.retrieve("/File").isPresent());
    assertThrows(UnsupportedOperationException.class, () -> fileStateStorage.retrieve(" /"));
    assertFalse(fileStateStorage.retrieve(" [^0-9a-zA-Z/]").isPresent());
  }

  /**
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    FileStateStorage fileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(new ArrayList<>(), true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    FileStateStorage fileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");

    ArrayList<TeamsStateStorage.Filter> tags = new ArrayList<>();
    tags.add(new TeamsStateStorage.Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  void testRetrieve4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ObjectMapper om = new ObjectMapper();
    FileStateStorage fileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");

    ArrayList<TeamsStateStorage.Filter> tags = new ArrayList<>();
    tags.add(new TeamsStateStorage.Filter("Key"));
    tags.add(new TeamsStateStorage.Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualRetrieveResult.iterator().hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
