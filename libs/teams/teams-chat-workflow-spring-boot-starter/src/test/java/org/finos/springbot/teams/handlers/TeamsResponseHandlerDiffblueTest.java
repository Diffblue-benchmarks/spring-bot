package org.finos.springbot.teams.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.Attachment;
import com.microsoft.bot.schema.Entity;
import com.microsoft.bot.schema.ResourceResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.handlers.TeamsResponseHandler.TemplateType;
import org.finos.springbot.teams.response.templating.EntityMarkupTemplateProvider;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardTemplateProvider;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplateProvider;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.templating.AbstractResourceTemplateProvider;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamsResponseHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TeamsResponseHandlerDiffblueTest {
  @MockBean
  private ActivityHandler activityHandler;

  @MockBean
  private AdaptiveCardTemplateProvider adaptiveCardTemplateProvider;

  @MockBean
  private AttachmentHandler attachmentHandler;

  @MockBean
  private EntityMarkupTemplateProvider entityMarkupTemplateProvider;

  @Autowired
  private TeamsResponseHandler teamsResponseHandler;

  @MockBean
  private TeamsStateStorage teamsStateStorage;

  @MockBean
  private ThymeleafTemplateProvider thymeleafTemplateProvider;

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>Given {@link Addressable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; given Addressable; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenAddressable_thenReturnNull() {
    // Arrange
    Response t = mock(Response.class);
    when(t.getAddress()).thenReturn(mock(Addressable.class));

    // Act
    ResourceResponse actualApplyResult = teamsResponseHandler.apply(t);

    // Assert
    verify(t).getAddress();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   * <ul>
   *   <li>Given {@link ThymeleafTemplateProvider} {@link AbstractResourceTemplateProvider#hasTemplate(DataResponse)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse); given ThymeleafTemplateProvider hasTemplate(DataResponse) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType_givenThymeleafTemplateProviderHasTemplateReturnTrue() {
    // Arrange
    when(adaptiveCardTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);

    // Act
    TemplateType actualTemplateType = teamsResponseHandler
        .getTemplateType(new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.THYMELEAF, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   * <ul>
   *   <li>Then return {@code ADAPTIVE_CARD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse); then return 'ADAPTIVE_CARD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType_thenReturnAdaptiveCard() {
    // Arrange
    when(adaptiveCardTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(false);

    // Act
    TemplateType actualTemplateType = teamsResponseHandler
        .getTemplateType(new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(adaptiveCardTemplateProvider).hasTemplate(isA(WorkResponse.class));
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.ADAPTIVE_CARD, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   * <ul>
   *   <li>Then return {@code THYMELEAF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse); then return 'THYMELEAF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType_thenReturnThymeleaf() {
    // Arrange
    when(adaptiveCardTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(false);
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(false);

    // Act
    TemplateType actualTemplateType = teamsResponseHandler
        .getTemplateType(new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(adaptiveCardTemplateProvider).hasTemplate(isA(WorkResponse.class));
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.THYMELEAF, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) As is {@link Entity} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName("Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); given Entity (default constructor) As is Entity (default constructor); when ArrayList() add Entity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"})
  void testSendXMLResponse_givenEntityAsIsEntity_whenArrayListAddEntity() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completableFuture = new CompletableFuture<>();
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completableFuture);

    Attachment attachment = new Attachment();
    attachment.setContent("With Content");
    attachment.setContentType("text/plain");
    attachment.setContentUrl("https://example.org/example");
    attachment.setName("With Name");
    attachment.setThumbnailUrl("https://example.org/example");
    TeamsAddressable address = mock(TeamsAddressable.class);

    Entity entity = new Entity();
    entity.setAs(new Entity());
    entity.setType("With Type");

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(entity);

    // Act
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult = teamsResponseHandler.sendXMLResponse("Xml",
        attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completableFuture, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}.
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName("Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); given Entity (default constructor) Type is '42'; when ArrayList() add Entity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"})
  void testSendXMLResponse_givenEntityTypeIs42_whenArrayListAddEntity() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completableFuture = new CompletableFuture<>();
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completableFuture);

    Attachment attachment = new Attachment();
    attachment.setContent("With Content");
    attachment.setContentType("text/plain");
    attachment.setContentUrl("https://example.org/example");
    attachment.setName("With Name");
    attachment.setThumbnailUrl("https://example.org/example");
    TeamsAddressable address = mock(TeamsAddressable.class);

    Entity entity = new Entity();
    entity.setAs(new Entity());
    entity.setType("With Type");

    Entity entity2 = new Entity();
    entity2.setAs(new Entity());
    entity2.setType("42");

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(entity2);
    entities.add(entity);

    // Act
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult = teamsResponseHandler.sendXMLResponse("Xml",
        attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completableFuture, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}.
   * <ul>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName("Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"})
  void testSendXMLResponse_thenThrowTeamsException() throws Exception {
    // Arrange
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));

    Attachment attachment = new Attachment();
    attachment.setContent("With Content");
    attachment.setContentType("text/plain");
    attachment.setContentUrl("https://example.org/example");
    attachment.setName("With Name");
    attachment.setThumbnailUrl("https://example.org/example");
    TeamsAddressable address = mock(TeamsAddressable.class);
    ArrayList<Entity> entities = new ArrayList<>();

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> teamsResponseHandler.sendXMLResponse("Xml", attachment, address, entities, new HashMap<>()));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link CompletableFuture#CompletableFuture()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName("Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); when ArrayList(); then return CompletableFuture()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"})
  void testSendXMLResponse_whenArrayList_thenReturnCompletableFuture() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completableFuture = new CompletableFuture<>();
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completableFuture);

    Attachment attachment = new Attachment();
    attachment.setContent("With Content");
    attachment.setContentType("text/plain");
    attachment.setContentUrl("https://example.org/example");
    attachment.setName("With Name");
    attachment.setThumbnailUrl("https://example.org/example");
    TeamsAddressable address = mock(TeamsAddressable.class);
    ArrayList<Entity> entities = new ArrayList<>();

    // Act
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult = teamsResponseHandler.sendXMLResponse("Xml",
        attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completableFuture, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   * <ul>
   *   <li>Given {@code summary-key}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code summary-key} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}
   */
  @Test
  @DisplayName("Test sendCardResponse(JsonNode, TeamsAddressable, Map); given 'summary-key'; when HashMap() 'summary-key' is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"})
  void testSendCardResponse_givenSummaryKey_whenHashMapSummaryKeyIs42() throws Exception {
    // Arrange
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));
    MissingNode json = MissingNode.getInstance();
    TeamsAddressable address = mock(TeamsAddressable.class);

    HashMap<String, Object> data = new HashMap<>();
    data.put("summary-key", "42");

    // Act and Assert
    assertThrows(TeamsException.class, () -> teamsResponseHandler.sendCardResponse(json, address, data));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   * <ul>
   *   <li>Then return {@link CompletableFuture#CompletableFuture()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}
   */
  @Test
  @DisplayName("Test sendCardResponse(JsonNode, TeamsAddressable, Map); then return CompletableFuture()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"})
  void testSendCardResponse_thenReturnCompletableFuture() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completableFuture = new CompletableFuture<>();
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completableFuture);
    MissingNode json = MissingNode.getInstance();
    TeamsAddressable address = mock(TeamsAddressable.class);

    // Act
    CompletableFuture<ResourceResponse> actualSendCardResponseResult = teamsResponseHandler.sendCardResponse(json,
        address, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completableFuture, actualSendCardResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   * <ul>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}
   */
  @Test
  @DisplayName("Test sendCardResponse(JsonNode, TeamsAddressable, Map); then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"})
  void testSendCardResponse_thenThrowTeamsException() throws Exception {
    // Arrange
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));
    MissingNode json = MissingNode.getInstance();
    TeamsAddressable address = mock(TeamsAddressable.class);

    // Act and Assert
    assertThrows(TeamsException.class, () -> teamsResponseHandler.sendCardResponse(json, address, new HashMap<>()));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   * <ul>
   *   <li>Given {@link HeaderDetails#HeaderDetails()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@link HeaderDetails#HeaderDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given HeaderDetails(); when HashMap() 'header' is HeaderDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"})
  void testPerformStorage_givenHeaderDetails_whenHashMapHeaderIsHeaderDetails() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", new HeaderDetails());

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   * <ul>
   *   <li>Given {@link TeamsException#TeamsException(String)} with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given TeamsException(String) with message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"})
  void testPerformStorage_givenTeamsExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", null);

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   * <ul>
   *   <li>Then calls {@link HeaderDetails#getTags()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test performStorage(TeamsAddressable, Map, TeamsStateStorage); then calls getTags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"})
  void testPerformStorage_thenCallsGetTags() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getTags()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", headerDetails);

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(headerDetails).getTags();
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   * <ul>
   *   <li>Given {@link HeaderDetails#HeaderDetails()}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@link HeaderDetails#HeaderDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test createStorageTags(Map, TeamsAddressable); given HeaderDetails(); when HashMap() 'header' is HeaderDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenHeaderDetails_whenHashMapHeaderIsHeaderDetails() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("header", new HeaderDetails());
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.createStorageTags(data, address));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test createStorageTags(Map, TeamsAddressable); given 'Key'; when HashMap(); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenKey_whenHashMap_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Map<String, String> actualCreateStorageTagsResult = TeamsResponseHandler.createStorageTags(data, address);

    // Assert
    verify(address).getKey();
    assertEquals(2, actualCreateStorageTagsResult.size());
    assertEquals("Key", actualCreateStorageTagsResult.get("addressable"));
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@code null}.</li>
   *   <li>Then throw {@link TeamsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test createStorageTags(Map, TeamsAddressable); given 'null'; when HashMap() 'header' is 'null'; then throw TeamsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenNull_whenHashMapHeaderIsNull_thenThrowTeamsException() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("header", null);
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.createStorageTags(data, address));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   * <ul>
   *   <li>Then calls {@link HeaderDetails#getTags()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test createStorageTags(Map, TeamsAddressable); then calls getTags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_thenCallsGetTags() {
    // Arrange
    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getTags()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("header", headerDetails);

    // Act and Assert
    assertThrows(TeamsException.class,
        () -> TeamsResponseHandler.createStorageTags(data, mock(TeamsAddressable.class)));
    verify(headerDetails).getTags();
  }
}
