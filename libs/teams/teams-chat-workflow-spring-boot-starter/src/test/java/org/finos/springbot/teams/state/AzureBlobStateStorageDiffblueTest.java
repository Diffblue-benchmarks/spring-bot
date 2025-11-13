package org.finos.springbot.teams.state;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.netty.implementation.NettyAsyncHttpBufferedResponse;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobStorageException;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AzureBlobStateStorageDiffblueTest {
  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile() {
    // Arrange
    NettyAsyncHttpBufferedResponse response = mock(NettyAsyncHttpBufferedResponse.class);
    when(response.getRequest())
        .thenReturn(new HttpRequest(HttpMethod.GET, "https://example.org/example"));
    when(response.getStatusCode()).thenReturn(404);
    BlobStorageException blobStorageException =
        new BlobStorageException("An error occurred", response, "Value");

    BlobClient blobClient = mock(BlobClient.class);
    doThrow(blobStorageException).when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve("File");

    // Assert
    verify(response, atLeast(1)).getRequest();
    verify(response, atLeast(1)).getStatusCode();
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("File");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When {@code [^0-9a-zA-Z/]}.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; given BlobClient download(OutputStream) does nothing; when '[^0-9a-zA-Z/]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_givenBlobClientDownloadDoesNothing_when09aZAZ() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult =
        azureBlobStateStorage.retrieve("[^0-9a-zA-Z/]");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("__0_9a_zA_Z/_");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When {@code '}.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; given BlobClient download(OutputStream) does nothing; when '''")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_givenBlobClientDownloadDoesNothing_whenApostrophe() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve("'");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("_");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; given BlobClient download(OutputStream) does nothing; when 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_givenBlobClientDownloadDoesNothing_whenFile() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve("File");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("File");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Given {@link BlobClient} {@link BlobClient#download(OutputStream)} does nothing.
   *   <li>When space.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; given BlobClient download(OutputStream) does nothing; when space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_givenBlobClientDownloadDoesNothing_whenSpace() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve(" ");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("_");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>Given {@link NettyAsyncHttpBufferedResponse} {@link
   *       NettyAsyncHttpBufferedResponse#getStatusCode()} return one.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; given NettyAsyncHttpBufferedResponse getStatusCode() return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_givenNettyAsyncHttpBufferedResponseGetStatusCodeReturnOne() {
    // Arrange
    NettyAsyncHttpBufferedResponse response = mock(NettyAsyncHttpBufferedResponse.class);
    when(response.getRequest())
        .thenReturn(new HttpRequest(HttpMethod.GET, "https://example.org/example"));
    when(response.getStatusCode()).thenReturn(1);
    BlobStorageException blobStorageException =
        new BlobStorageException("An error occurred", response, "Value");

    BlobClient blobClient = mock(BlobClient.class);
    doThrow(blobStorageException).when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve("File");

    // Assert
    verify(response, atLeast(1)).getRequest();
    verify(response, atLeast(1)).getStatusCode();
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("File");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code [^0-9a-zA-Z/]}.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when '[^0-9a-zA-Z/]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_when09aZAZ() {
    // Arrange
    NettyAsyncHttpBufferedResponse response = mock(NettyAsyncHttpBufferedResponse.class);
    when(response.getRequest())
        .thenReturn(new HttpRequest(HttpMethod.GET, "https://example.org/example"));
    when(response.getStatusCode()).thenReturn(1);
    BlobStorageException blobStorageException =
        new BlobStorageException("An error occurred", response, "Value");

    BlobClient blobClient = mock(BlobClient.class);
    doThrow(blobStorageException).when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult =
        azureBlobStateStorage.retrieve(" [^0-9a-zA-Z/]");

    // Assert
    verify(response, atLeast(1)).getRequest();
    verify(response, atLeast(1)).getStatusCode();
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("___0_9a_zA_Z/_");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When {@code AzureBlobStateStorage}.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName(
      "Test retrieve(String) with 'file'; when 'org.finos.springbot.teams.state.AzureBlobStateStorage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenOrgFinosSpringbotTeamsStateAzureBlobStateStorage() {
    // Arrange
    BlobClient blobClient = mock(BlobClient.class);
    doNothing().when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult =
        azureBlobStateStorage.retrieve("org.finos.springbot.teams.state.AzureBlobStateStorage");

    // Assert
    verify(blobContainerClient).exists();
    verify(blobContainerClient)
        .getBlobClient("org_finos_springbot_teams_state_AzureBlobStateStorage");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }

  /**
   * Test {@link AzureBlobStateStorage#retrieve(String)} with {@code file}.
   *
   * <ul>
   *   <li>When space space.
   * </ul>
   *
   * <p>Method under test: {@link AzureBlobStateStorage#retrieve(String)}
   */
  @Test
  @DisplayName("Test retrieve(String) with 'file'; when space space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional AzureBlobStateStorage.retrieve(String)"})
  void testRetrieveWithFile_whenSpaceSpace() {
    // Arrange
    NettyAsyncHttpBufferedResponse response = mock(NettyAsyncHttpBufferedResponse.class);
    when(response.getRequest())
        .thenReturn(new HttpRequest(HttpMethod.GET, "https://example.org/example"));
    when(response.getStatusCode()).thenReturn(1);
    BlobStorageException blobStorageException =
        new BlobStorageException("An error occurred", response, "Value");

    BlobClient blobClient = mock(BlobClient.class);
    doThrow(blobStorageException).when(blobClient).download(Mockito.<OutputStream>any());

    BlobContainerClient blobContainerClient = mock(BlobContainerClient.class);
    when(blobContainerClient.exists()).thenReturn(true);
    when(blobContainerClient.getBlobClient(Mockito.<String>any())).thenReturn(blobClient);

    BlobServiceClient bsc = mock(BlobServiceClient.class);
    when(bsc.getBlobContainerClient(Mockito.<String>any())).thenReturn(blobContainerClient);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    AzureBlobStateStorage azureBlobStateStorage = new AzureBlobStateStorage(bsc, ejc, "Container");

    // Act
    Optional<Map<String, Object>> actualRetrieveResult = azureBlobStateStorage.retrieve("  ");

    // Assert
    verify(response, atLeast(1)).getRequest();
    verify(response, atLeast(1)).getStatusCode();
    verify(blobContainerClient).exists();
    verify(blobContainerClient).getBlobClient("__");
    verify(bsc).getBlobContainerClient("Container");
    verify(blobClient).download(isA(OutputStream.class));
    assertFalse(actualRetrieveResult.isPresent());
  }
}
