package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.finos.springbot.entityjson.ObjectMapperFactory;
import org.finos.springbot.entityjson.VersionSpace;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FileStateStorage.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FileStateStorageDiffblueTest {
  @MockitoBean private EntityJsonConverter entityJsonConverter;

  @Autowired private FileStateStorage fileStateStorage;

  /**
   * Test {@link FileStateStorage#FileStateStorage(EntityJsonConverter, String)}.
   *
   * <p>Method under test: {@link FileStateStorage#FileStateStorage(EntityJsonConverter, String)}
   */
  @Test
  @DisplayName("Test new FileStateStorage(EntityJsonConverter, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.<init>(EntityJsonConverter, String)"})
  void testNewFileStateStorage() {
    // Arrange
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    FileStateStorage actualFileStateStorage = new FileStateStorage(ejc, "/directory/foo.txt");

    // Assert
    assertTrue(actualFileStateStorage.store.isEmpty());
    assertTrue(actualFileStateStorage.tagIndex.isEmpty());
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any()))
          .thenThrow(new TeamsException("An error occurred"));

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act and Assert
      assertThrows(
          TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code [^0-9a-zA-Z/]}.
   *   <li>When {@link HashMap#HashMap()} {@code [^0-9a-zA-Z/]} is {@code 42}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given '[^0-9a-zA-Z/]'; when HashMap() '[^0-9a-zA-Z/]' is '42'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_given09aZAZ_whenHashMap09aZAZIs42_thenCallsWriteValue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("[^0-9a-zA-Z/]", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter} {@link EntityJsonConverter#writeValue(Object)} return
   *       {@code 42}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given EntityJsonConverter writeValue(Object) return '42'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenEntityJsonConverterWriteValueReturn42_thenCallsWriteValue()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.
   *   <li>When {@code File}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given EntityJsonConverter; when 'File'; then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenEntityJsonConverter_whenFile_thenThrowTeamsException() {
    // Arrange
    HashMap<String, String> tags = new HashMap<>();

    // Act and Assert
    assertThrows(TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link EntityJsonConverter}.
   *   <li>When {@code /}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given EntityJsonConverter; when '/'; then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenEntityJsonConverter_whenSlash_thenThrowTeamsException() {
    // Arrange, Act and Assert
    assertThrows(TeamsException.class, () -> fileStateStorage.store("/", null, null));
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createDirectory(Path, FileAttribute[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files createDirectory(Path, FileAttribute[]) throw IOException(); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesCreateDirectoryThrowIOException_thenThrowTeamsException()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act and Assert
      assertThrows(
          TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createFile(Path, FileAttribute[])} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files createFile(Path, FileAttribute[]) throw IOException(); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesCreateFileThrowIOException_thenThrowTeamsException() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new IOException());
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act and Assert
      assertThrows(
          TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#createFile(Path, FileAttribute[])} throw {@link
   *       TeamsException#TeamsException(String)} with message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files createFile(Path, FileAttribute[]) throw TeamsException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesCreateFileThrowTeamsExceptionWithMessageIsAnErrorOccurred()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenThrow(new TeamsException("An error occurred"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act and Assert
      assertThrows(
          TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#notExists(Path, LinkOption[])} return {@code false}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files notExists(Path, LinkOption[]) return 'false'; when HashMap() 'Key' is '42'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesNotExistsReturnFalse_whenHashMapKeyIs42_thenCallsWriteValue()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(false);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#notExists(Path, LinkOption[])} throw {@link
   *       TeamsException#TeamsException(String)} with message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files notExists(Path, LinkOption[]) throw TeamsException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesNotExistsThrowTeamsExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenThrow(new TeamsException("An error occurred"));

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act and Assert
      assertThrows(
          TeamsException.class, () -> fileStateStorage.store("File", tags, new HashMap<>()));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#readAttributes(Path, Class, LinkOption[])} return {@code
   *       null}.
   *   <li>Then calls {@link Builder#findAndAddModules()}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given Files readAttributes(Path, Class, LinkOption[]) return 'null'; then calls findAndAddModules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenFilesReadAttributesReturnNull_thenCallsFindAndAddModules()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(), eq(BasicFileAttributes.class), isA(LinkOption[].class)))
          .thenReturn(null);

      Builder builder = mock(Builder.class);
      when(builder.findAndAddModules()).thenReturn(JsonMapper.builder());
      JsonMapper om = builder.findAndAddModules().build();
      EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
      FileStateStorage fileStateStorage = new FileStateStorage(ejc, "/directory/foo.txt");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      verify(builder).findAndAddModules();
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code 42}.
   *   <li>Then calls {@link Builder#findAndAddModules()}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given 'java.lang.Object'; when HashMap() 'Key' is '42'; then calls findAndAddModules()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenJavaLangObject_whenHashMapKeyIs42_thenCallsFindAndAddModules()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(), eq(BasicFileAttributes.class), isA(LinkOption[].class)))
          .thenReturn(null);

      Builder builder = mock(Builder.class);
      when(builder.findAndAddModules()).thenReturn(JsonMapper.builder());
      JsonMapper om = builder.findAndAddModules().build();

      ArrayList<VersionSpace> initial = new ArrayList<>();
      Class<Object> class1 = Object.class;
      initial.add(ObjectMapperFactory.noVersion(class1));

      EntityJsonConverter ejc = new EntityJsonConverter(om, initial);
      FileStateStorage fileStateStorage = new FileStateStorage(ejc, "/directory/foo.txt");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      verify(builder).findAndAddModules();
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code _messageid}.
   *   <li>When {@link HashMap#HashMap()} {@code _messageid} is {@code 42}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given '_messageid'; when HashMap() '_messageid' is '42'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenMessageid_whenHashMapMessageidIs42_thenCallsWriteValue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("_messageid", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>Given {@code /}.
   *   <li>When {@link HashMap#HashMap()} {@code /} is space.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test store(String, Map, Map); given '/'; when HashMap() '/' is space; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_givenSlash_whenHashMapSlashIsSpace_thenCallsWriteValue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("/", " ");
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("File", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>When {@code [^0-9a-zA-Z/]}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when '[^0-9a-zA-Z/]'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_when09aZAZ_thenCallsWriteValue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("[^0-9a-zA-Z/]", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#store(String, Map, Map)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then calls {@link EntityJsonConverter#writeValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#store(String, Map, Map)}
   */
  @Test
  @DisplayName("Test store(String, Map, Map); when '/'; then calls writeValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileStateStorage.store(String, Map, Map)"})
  void testStore_whenSlash_thenCallsWriteValue() throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles
          .when(
              () ->
                  Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)))
          .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      when(entityJsonConverter.writeValue(Mockito.<Object>any())).thenReturn("42");

      HashMap<String, String> tags = new HashMap<>();
      tags.put("Key", "42");

      // Act
      fileStateStorage.store("/", tags, new HashMap<>());

      // Assert
      mockFiles.verify(
          () -> Files.createDirectory(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.createFile(Mockito.<Path>any(), isA(FileAttribute[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)), atLeast(1));
      mockFiles.verify(
          () -> Files.write(Mockito.<Path>any(), Mockito.<byte[]>any(), isA(OpenOption[].class)));
      verify(entityJsonConverter).writeValue(isA(Object.class));
    }
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code [^0-9a-zA-Z/]}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '[^0-9a-zA-Z/]'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_when09aZAZ_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("[^0-9a-zA-Z/]").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code [^0-9a-zA-Z/]}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '[^0-9a-zA-Z/]'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_when09aZAZ_thenReturnNotPresent2() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve(" [^0-9a-zA-Z/]").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code 42[^0-9a-zA-Z/]}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '42[^0-9a-zA-Z/]'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_when4209aZAZ_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("42[^0-9a-zA-Z/]").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code File[^0-9a-zA-Z/]}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; when 'File[^0-9a-zA-Z/]'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenFile09aZAZ_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("File[^0-9a-zA-Z/]").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code File}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when 'File'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenFile_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("File").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code /File}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '/File'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenFile_thenReturnNotPresent2() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("/File").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '/'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenSlash_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(fileStateStorage.retrieve("/").isPresent());
  }

  /**
   * Test {@link FileStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; when '/'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional FileStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenSlash_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fileStateStorage.retrieve(" /"));
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKey2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("Key"));
    tags.add(new Filter("Key"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-info}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableInfo() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-info"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, false);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-info}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-info'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableInfo2() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-info"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>Given {@link Filter#Filter(String)} with key is {@code addressable-type}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; given Filter(String) with key is 'addressable-type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_givenFilterWithKeyIsAddressableType() {
    // Arrange
    ArrayList<Filter> tags = new ArrayList<>();
    tags.add(new Filter("addressable-type"));

    // Act
    Iterable<Map<String, Object>> actualRetrieveResult = fileStateStorage.retrieve(tags, false);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList_thenReturnList() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult =
        fileStateStorage.retrieve(new ArrayList<>(), true);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }

  /**
   * Test {@link FileStateStorage#retrieve(List, boolean)} with {@code tags}, {@code
   * singleResultOnly}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FileStateStorage#retrieve(List, boolean)}
   */
  @Test
  @DisplayName(
      "Test retrieve(List, boolean) with 'tags', 'singleResultOnly'; when ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable FileStateStorage.retrieve(List, boolean)"})
  void testRetrieveWithTagsSingleResultOnly_whenArrayList_thenReturnList2() {
    // Arrange and Act
    Iterable<Map<String, Object>> actualRetrieveResult =
        fileStateStorage.retrieve(new ArrayList<>(), false);
    Iterator<Map<String, Object>> actualIteratorResult = actualRetrieveResult.iterator();

    // Assert
    assertTrue(actualRetrieveResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Map<String, Object>>) actualRetrieveResult).isEmpty());
  }
}
