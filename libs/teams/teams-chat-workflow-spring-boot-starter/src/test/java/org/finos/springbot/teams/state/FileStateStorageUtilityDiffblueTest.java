package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import org.finos.springbot.teams.TeamsException;
import org.junit.jupiter.api.Test;

class FileStateStorageUtilityDiffblueTest {
  /**
   * Method under test: {@link FileStateStorageUtility#readFile(String)}
   */
  @Test
  void testReadFile() {
    // Arrange and Act
    Optional<String> actualReadFileResult = FileStateStorageUtility.readFile("/directory/foo.txt");

    // Assert
    assertFalse(actualReadFileResult.isPresent());
  }

  /**
   * Method under test: {@link FileStateStorageUtility#readFile(String)}
   */
  @Test
  void testReadFile2() {
    // Arrange, Act and Assert
    assertThrows(TeamsException.class, () -> FileStateStorageUtility.readFile(""));
  }

  /**
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFile(String)}
   */
  @Test
  void testCheckAndCreateFile() throws IOException {
    // Arrange, Act and Assert
    File toFileResult = FileStateStorageUtility.checkAndCreateFile("").toFile();
    assertEquals("", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link FileStateStorageUtility#checkAndCreateFolder(String)}
   */
  @Test
  void testCheckAndCreateFolder() throws IOException {
    // Arrange, Act and Assert
    File toFileResult = FileStateStorageUtility.checkAndCreateFolder("").toFile();
    assertEquals("", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }
}
