package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.teams.state.TeamsStateStorage.Filter;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FileStateStorage.class, String.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class FileStateStorageDiffblueTest {
  @MockBean
  private EntityJsonConverter entityJsonConverter;

  @Autowired
  private FileStateStorage fileStateStorage;

  /**
   * Test {@link FileStateStorage#FileStateStorage(EntityJsonConverter, String)}.
   * <p>
   * Method under test: {@link FileStateStorage#FileStateStorage(EntityJsonConverter, String)}
   */
  @Test
  @DisplayName("Test new FileStateStorage(EntityJsonConverter, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.<init>(org.finos.springbot.workflow.data.EntityJsonConverter, java.lang.String)"})
  void testNewFileStateStorage() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    // Act
    FileStateStorage actualFileStateStorage = new FileStateStorage(new EntityJsonConverter(om, new ArrayList<>()),
        "/directory/foo.txt");

    // Assert
    assertTrue(actualFileStateStorage.store.isEmpty());
    assertTrue(actualFileStateStorage.tagIndex.isEmpty());
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@code [^0-9a-zA-Z/]}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code [^0-9a-zA-Z/]} is {@code foo}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given '[^0-9a-zA-Z/]'; when HashMap() '[^0-9a-zA-Z/]' is 'foo'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_given09aZAZ_whenHashMap09aZAZIsFoo_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("[^0-9a-zA-Z/]", "foo");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.</li>
   *   <li>When {@code File}.</li>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given EntityJsonConverter; when 'File'; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenEntityJsonConverter_whenFile_thenThrowTeamsException() {
    // Arrange
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#notExists(Path, LinkOption[])} return {@code false}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then calls {@link Files#notExists(Path, LinkOption[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given Files notExists(Path, LinkOption[]) return 'false'; when HashMap() 'foo' is 'foo'; then calls notExists(Path, LinkOption[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenFilesNotExistsReturnFalse_whenHashMapFooIsFoo_thenCallsNotExists() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(false);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#write(Path, byte[], OpenOption[])} throw {@link IOException#IOException(String)} with space.</li>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given Files write(Path, byte[], OpenOption[]) throw IOException(String) with space; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenFilesWriteThrowIOExceptionWithSpace_thenThrowTeamsException() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenThrow(new IOException(" "));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act and Assert
      assertThrows(TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@link Files} {@link Files#write(Path, byte[], OpenOption[])} throw {@link TeamsException#TeamsException(String)} with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given Files write(Path, byte[], OpenOption[]) throw TeamsException(String) with message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenFilesWriteThrowTeamsExceptionWithMessageIsAnErrorOccurred() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenThrow(new TeamsException("An error occurred"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act and Assert
      assertThrows(TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given {@code _messageid}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code _messageid} is {@code foo}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given '_messageid'; when HashMap() '_messageid' is 'foo'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenMessageid_whenHashMapMessageidIsFoo_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("_messageid", "foo");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link HashMap#HashMap()} space is {@code foo}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); given space; when HashMap() space is 'foo'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_givenSpace_whenHashMapSpaceIsFoo_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put(" ", "foo");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>When {@code [^0-9a-zA-Z/]}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when '[^0-9a-zA-Z/]'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_when09aZAZ_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act
      fileStateStorage.store("[^0-9a-zA-Z/]", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when HashMap() 'foo' is 'foo'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_whenHashMapFooIsFoo_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then calls {@link Files#createDirectory(Path, FileAttribute[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when '/'; then calls createDirectory(Path, FileAttribute[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.state.FileStateStorage.store(java.lang.String, java.util.Map, java.util.Map)"})
  void testStore_whenSlash_thenCallsCreateDirectory() throws IOException {
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {

      // Arrange
      mockFiles.when(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles.when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class))).thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("foo", "foo");

      // Act
      fileStateStorage.store("/", tags, new HashMap<>());

      // Assert
      mockFiles.verify(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(() -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   * <ul>
   *   <li>When {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when 'File'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional org.finos.springbot.teams.state.FileStateStorage.retrieve(java.lang.String)"})
  void testRetrieveWithFile_whenFile() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("File").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional org.finos.springbot.teams.state.FileStateStorage.retrieve(java.lang.String)"})
  void testRetrieveWithFile_whenSlash() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("/").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableInfo() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-info"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-info}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-info'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableInfo2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-info"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, false);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableType() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-type"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList(); then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList_thenReturnList() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(new ArrayList<>(), true);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code singleResultOnly}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName("Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList(); then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.Iterable org.finos.springbot.teams.state.FileStateStorage.retrieve(java.util.List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList_thenReturnList2() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(new ArrayList<>(), false);

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
