package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Optional;
import org.finos.springbot.teams.TeamsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class FileStateStorageUtilityDiffblueTest {
  /**
   * Test {@link FileStateStorageUtility#readFile(String)}.
   * <ul>
   *   <li>When {@code /directory/foo.txt}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#readFile(String)}
   */
  @Test
  @DisplayName("Test readFile(String); when '/directory/foo.txt'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FileStateStorageUtility.readFile(String)"})
  void testReadFile_whenDirectoryFooTxt_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualReadFileResult = FileStateStorageUtility.readFile("/directory/foo.txt");

    // Assert
    assertFalse(actualReadFileResult.isPresent());
  }

  /**
   * Test {@link FileStateStorageUtility#readFile(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#readFile(String)}
   */
  @Test
  @DisplayName("Test readFile(String); when empty string; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FileStateStorageUtility.readFile(String)"})
  void testReadFile_whenEmptyString_thenThrowTeamsException() {
    // Arrange, Act and Assert
    assertThrows(TeamsException.class, () -> FileStateStorageUtility.readFile(""));
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFile(String)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#notExists(Path, LinkOption[])} return {@code false}.</li>
   *   <li>Then return toFile Name is {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFile(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFile(String); given Files notExists(Path, LinkOption[]) return 'false'; then return toFile Name is 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFile(String)"})
  void testCheckAndCreateFile_givenFilesNotExistsReturnFalse_thenReturnToFileNameIsFile() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);

      // Act
      Path actualCheckAndCreateFileResult = FileStateStorageUtility.checkAndCreateFile("File");

      // Assert
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      File toFileResult = actualCheckAndCreateFileResult.toFile();
      assertEquals("File", toFileResult.getName());
      assertFalse(toFileResult.isAbsolute());
    }
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFile(String)}.
   * <ul>
   *   <li>Then return toFile Name is {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFile(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFile(String); then return toFile Name is 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFile(String)"})
  void testCheckAndCreateFile_thenReturnToFileNameIsFile() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      // Act
      Path actualCheckAndCreateFileResult = FileStateStorageUtility.checkAndCreateFile("File");

      // Assert
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      File toFileResult = actualCheckAndCreateFileResult.toFile();
      assertEquals("File", toFileResult.getName());
      assertFalse(toFileResult.isAbsolute());
    }
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFile(String)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFile(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFile(String); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFile(String)"})
  void testCheckAndCreateFile_thenThrowIOException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException("foo"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      // Act and Assert
      assertThrows(IOException.class, () -> FileStateStorageUtility.checkAndCreateFile("File"));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFolder(String)}.
   * <ul>
   *   <li>Then return toFile Name is {@code Path Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFolder(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFolder(String); then return toFile Name is 'Path Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFolder(String)"})
  void testCheckAndCreateFolder_thenReturnToFileNameIsPathStr() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);

      // Act
      Path actualCheckAndCreateFolderResult = FileStateStorageUtility.checkAndCreateFolder("Path Str");

      // Assert
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      File toFileResult = actualCheckAndCreateFolderResult.toFile();
      assertEquals("Path Str", toFileResult.getName());
      assertFalse(toFileResult.isAbsolute());
    }
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFolder(String)}.
   * <ul>
   *   <li>Then return toFile Name is {@code test.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFolder(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFolder(String); then return toFile Name is 'test.txt'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFolder(String)"})
  void testCheckAndCreateFolder_thenReturnToFileNameIsTestTxt() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      // Act
      Path actualCheckAndCreateFolderResult = FileStateStorageUtility.checkAndCreateFolder("Path Str");

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      File toFileResult = actualCheckAndCreateFolderResult.toFile();
      assertEquals("test.txt", toFileResult.getName());
      assertTrue(toFileResult.isAbsolute());
    }
  }

  /**
   * Test {@link FileStateStorageUtility#checkAndCreateFolder(String)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorageUtility#checkAndCreateFolder(String)}
   */
  @Test
  @DisplayName("Test checkAndCreateFolder(String); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path FileStateStorageUtility.checkAndCreateFolder(String)"})
  void testCheckAndCreateFolder_thenThrowIOException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException("foo"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);

      // Act and Assert
      assertThrows(IOException.class, () -> FileStateStorageUtility.checkAndCreateFolder("Path Str"));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }
}
