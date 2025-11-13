package org.finos.springbot.teams.handlers;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.microsoft.bot.schema.Activity;
import com.microsoft.bot.schema.Attachment;
import com.microsoft.bot.schema.Entity;
import com.microsoft.bot.schema.ResourceResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import org.finos.springbot.entityjson.ObjectMapperFactory;
import org.finos.springbot.entityjson.VersionSpace;
import org.finos.springbot.teams.TeamsException;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.handlers.TeamsResponseHandler.TemplateType;
import org.finos.springbot.teams.response.templating.EntityMarkupTemplateProvider;
import org.finos.springbot.teams.response.templating.MarkupAndEntities;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.teams.state.TeamsStateStorage;
import org.finos.springbot.teams.templating.adaptivecard.AdaptiveCardTemplateProvider;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafRendering;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplateProvider;
import org.finos.springbot.teams.templating.thymeleaf.ThymeleafTemplater;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.finos.springbot.workflow.templating.TypeConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.io.ApplicationResourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {TeamsResponseHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TeamsResponseHandlerDiffblueTest {
  @MockitoBean private ActivityHandler activityHandler;

  @MockitoBean private AdaptiveCardTemplateProvider adaptiveCardTemplateProvider;

  @MockitoBean private AttachmentHandler attachmentHandler;

  @MockitoBean private EntityMarkupTemplateProvider entityMarkupTemplateProvider;

  @Autowired private TeamsResponseHandler teamsResponseHandler;

  @MockitoBean private TeamsStateStorage teamsStateStorage;

  @MockitoBean private ThymeleafTemplateProvider thymeleafTemplateProvider;

  /**
   * Test {@link TeamsResponseHandler#initErrorHandler()}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getBean(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#initErrorHandler()}
   */
  @Test
  @DisplayName("Test initErrorHandler(); then calls getBean(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TeamsResponseHandler.initErrorHandler()"})
  void testInitErrorHandler_thenCallsGetBean() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(ErrorHandler.class)).thenReturn(mock(ErrorHandler.class));
    AttachmentHandler attachmentHandler = mock(AttachmentHandler.class);
    EntityMarkupTemplateProvider messageTemplater =
        new EntityMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    ThymeleafTemplateProvider displayTemplater =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    TeamsResponseHandler teamsResponseHandler =
        new TeamsResponseHandler(
            attachmentHandler,
            messageTemplater,
            null,
            displayTemplater,
            new MemoryStateStorage(ejc),
            mock(ActivityHandler.class));
    teamsResponseHandler.setApplicationContext(applicationContext);

    // Act
    teamsResponseHandler.initErrorHandler();

    // Assert
    verify(applicationContext).getBean(isA(Class.class));
  }

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse() {
    // Arrange, Act and Assert
    assertNull(
        teamsResponseHandler.apply(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost")));
  }

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse2() {
    // Arrange
    when(entityMarkupTemplateProvider.template(Mockito.<MessageResponse>any()))
        .thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            teamsResponseHandler.apply(
                new MessageResponse(
                    new TeamsChannel("42", "Name"), "Not all who wander are lost")));
    verify(entityMarkupTemplateProvider).template(isA(MessageResponse.class));
  }

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse3() {
    // Arrange
    when(entityMarkupTemplateProvider.template(Mockito.<MessageResponse>any()))
        .thenReturn(new MarkupAndEntities("Not all who wander are lost"));
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            teamsResponseHandler.apply(
                new MessageResponse(
                    new TeamsChannel("42", "Name"), "Not all who wander are lost")));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    verify(entityMarkupTemplateProvider).template(isA(MessageResponse.class));
  }

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@link TeamsAddressable}.
   *   <li>Then calls {@link Response#getAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; given TeamsAddressable; then calls getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenTeamsAddressable_thenCallsGetAddress() {
    // Arrange
    Response t = mock(Response.class);
    when(t.getAddress()).thenReturn(mock(TeamsAddressable.class));

    // Act
    ResourceResponse actualApplyResult = teamsResponseHandler.apply(t);

    // Assert
    verify(t, atLeast(1)).getAddress();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link TeamsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; then return Id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceResponse TeamsResponseHandler.apply(Response)"})
  void testApplyWithResponse_thenReturnIdIsNull() {
    // Arrange
    when(entityMarkupTemplateProvider.template(Mockito.<MessageResponse>any()))
        .thenReturn(new MarkupAndEntities("Not all who wander are lost"));
    ResourceResponse resourceResponse = new ResourceResponse();
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(resourceResponse);
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

    // Act
    ResourceResponse actualApplyResult =
        teamsResponseHandler.apply(
            new MessageResponse(new TeamsChannel("42", "Name"), "Not all who wander are lost"));

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    verify(entityMarkupTemplateProvider).template(isA(MessageResponse.class));
    assertNull(actualApplyResult.getId());
    assertSame(resourceResponse, actualApplyResult);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType() {
    // Arrange
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any()))
        .thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            teamsResponseHandler.getTemplateType(
                new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType2() {
    // Arrange
    when(adaptiveCardTemplateProvider.hasTemplate(Mockito.<WorkResponse>any()))
        .thenThrow(new TeamsException("An error occurred"));
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(false);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () ->
            teamsResponseHandler.getTemplateType(
                new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
    verify(adaptiveCardTemplateProvider).hasTemplate(isA(WorkResponse.class));
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType3() {
    // Arrange
    AdaptiveCardTemplateProvider workTemplater = mock(AdaptiveCardTemplateProvider.class);
    when(workTemplater.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);
    AttachmentHandler attachmentHandler = mock(AttachmentHandler.class);
    EntityMarkupTemplateProvider messageTemplater =
        new EntityMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    ThymeleafTemplateProvider displayTemplater =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    TeamsResponseHandler teamsResponseHandler =
        new TeamsResponseHandler(
            attachmentHandler,
            messageTemplater,
            workTemplater,
            displayTemplater,
            new MemoryStateStorage(ejc),
            mock(ActivityHandler.class));

    // Act
    TemplateType actualTemplateType =
        teamsResponseHandler.getTemplateType(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(workTemplater).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.ADAPTIVE_CARD, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   *
   * <ul>
   *   <li>Then return {@code ADAPTIVE_CARD}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse); then return 'ADAPTIVE_CARD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType_thenReturnAdaptiveCard() {
    // Arrange
    when(adaptiveCardTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(false);

    // Act
    TemplateType actualTemplateType =
        teamsResponseHandler.getTemplateType(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(adaptiveCardTemplateProvider).hasTemplate(isA(WorkResponse.class));
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.ADAPTIVE_CARD, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#getTemplateType(WorkResponse)}.
   *
   * <ul>
   *   <li>Then return {@code THYMELEAF}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#getTemplateType(WorkResponse)}
   */
  @Test
  @DisplayName("Test getTemplateType(WorkResponse); then return 'THYMELEAF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType TeamsResponseHandler.getTemplateType(WorkResponse)"})
  void testGetTemplateType_thenReturnThymeleaf() {
    // Arrange
    when(thymeleafTemplateProvider.hasTemplate(Mockito.<WorkResponse>any())).thenReturn(true);

    // Act
    TemplateType actualTemplateType =
        teamsResponseHandler.getTemplateType(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(thymeleafTemplateProvider).hasTemplate(isA(WorkResponse.class));
    assertEquals(TemplateType.THYMELEAF, actualTemplateType);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) As is {@link Entity} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment,
   * TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName(
      "Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); given Entity (default constructor) As is Entity (default constructor); when ArrayList() add Entity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"
  })
  void testSendXMLResponse_givenEntityAsIsEntity_whenArrayListAddEntity() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

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
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult =
        teamsResponseHandler.sendXMLResponse("Xml", attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment,
   * TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName(
      "Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); given Entity (default constructor) Type is '42'; when ArrayList() add Entity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"
  })
  void testSendXMLResponse_givenEntityTypeIs42_whenArrayListAddEntity() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

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
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult =
        teamsResponseHandler.sendXMLResponse("Xml", attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List,
   * Map)}.
   *
   * <ul>
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment,
   * TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName(
      "Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"
  })
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
    assertThrows(
        TeamsException.class,
        () ->
            teamsResponseHandler.sendXMLResponse(
                "Xml", attachment, address, entities, new HashMap<>()));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#sendXMLResponse(String, Attachment, TeamsAddressable, List,
   * Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return completedFuture {@link ResourceResponse#ResourceResponse()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendXMLResponse(String, Attachment,
   * TeamsAddressable, List, Map)}
   */
  @Test
  @DisplayName(
      "Test sendXMLResponse(String, Attachment, TeamsAddressable, List, Map); when ArrayList(); then return completedFuture ResourceResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendXMLResponse(String, Attachment, TeamsAddressable, List, Map)"
  })
  void testSendXMLResponse_whenArrayList_thenReturnCompletedFutureResourceResponse()
      throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);

    Attachment attachment = new Attachment();
    attachment.setContent("With Content");
    attachment.setContentType("text/plain");
    attachment.setContentUrl("https://example.org/example");
    attachment.setName("With Name");
    attachment.setThumbnailUrl("https://example.org/example");
    TeamsAddressable address = mock(TeamsAddressable.class);
    ArrayList<Entity> entities = new ArrayList<>();

    // Act
    CompletableFuture<ResourceResponse> actualSendXMLResponseResult =
        teamsResponseHandler.sendXMLResponse("Xml", attachment, address, entities, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualSendXMLResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable,
   * Map)}
   */
  @Test
  @DisplayName("Test sendCardResponse(JsonNode, TeamsAddressable, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"
  })
  void testSendCardResponse() throws Exception {
    // Arrange
    ActivityHandler ah = mock(ActivityHandler.class);
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(ah.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);
    AttachmentHandler attachmentHandler = mock(AttachmentHandler.class);
    EntityMarkupTemplateProvider messageTemplater =
        new EntityMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    ThymeleafTemplater converter =
        new ThymeleafTemplater(fieldConverters, new ThymeleafRendering());

    ThymeleafTemplateProvider displayTemplater =
        new ThymeleafTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, converter);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    TeamsResponseHandler teamsResponseHandler =
        new TeamsResponseHandler(
            attachmentHandler,
            messageTemplater,
            null,
            displayTemplater,
            new MemoryStateStorage(ejc),
            ah);
    DoubleNode json = DoubleNode.valueOf(10.0d);
    TeamsAddressable address = mock(TeamsAddressable.class);

    HashMap<String, Object> data = new HashMap<>();
    data.put("summary-key", null);

    // Act
    CompletableFuture<ResourceResponse> actualSendCardResponseResult =
        teamsResponseHandler.sendCardResponse(json, address, data);

    // Assert
    verify(ah).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualSendCardResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   *
   * <ul>
   *   <li>Given {@code Value}.
   *   <li>When {@link HashMap#HashMap()} {@code summary-key} is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable,
   * Map)}
   */
  @Test
  @DisplayName(
      "Test sendCardResponse(JsonNode, TeamsAddressable, Map); given 'Value'; when HashMap() 'summary-key' is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"
  })
  void testSendCardResponse_givenValue_whenHashMapSummaryKeyIsValue() throws Exception {
    // Arrange
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));
    DoubleNode json = DoubleNode.valueOf(10.0d);
    TeamsAddressable address = mock(TeamsAddressable.class);

    HashMap<String, Object> data = new HashMap<>();
    data.put("summary-key", "Value");

    // Act and Assert
    assertThrows(
        TeamsException.class, () -> teamsResponseHandler.sendCardResponse(json, address, data));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   *
   * <ul>
   *   <li>Then return completedFuture {@link ResourceResponse#ResourceResponse()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable,
   * Map)}
   */
  @Test
  @DisplayName(
      "Test sendCardResponse(JsonNode, TeamsAddressable, Map); then return completedFuture ResourceResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"
  })
  void testSendCardResponse_thenReturnCompletedFutureResourceResponse() throws Exception {
    // Arrange
    CompletableFuture<ResourceResponse> completedFutureResult =
        CompletableFuture.completedFuture(new ResourceResponse());
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenReturn(completedFutureResult);
    DoubleNode json = DoubleNode.valueOf(10.0d);
    TeamsAddressable address = mock(TeamsAddressable.class);

    // Act
    CompletableFuture<ResourceResponse> actualSendCardResponseResult =
        teamsResponseHandler.sendCardResponse(json, address, new HashMap<>());

    // Assert
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
    assertSame(completedFutureResult, actualSendCardResponseResult);
  }

  /**
   * Test {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable, Map)}.
   *
   * <ul>
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#sendCardResponse(JsonNode, TeamsAddressable,
   * Map)}
   */
  @Test
  @DisplayName("Test sendCardResponse(JsonNode, TeamsAddressable, Map); then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CompletableFuture TeamsResponseHandler.sendCardResponse(JsonNode, TeamsAddressable, Map)"
  })
  void testSendCardResponse_thenThrowTeamsException() throws Exception {
    // Arrange
    when(activityHandler.handleActivity(Mockito.<Activity>any(), Mockito.<TeamsAddressable>any()))
        .thenThrow(new TeamsException("An error occurred"));
    DoubleNode json = DoubleNode.valueOf(10.0d);
    TeamsAddressable address = mock(TeamsAddressable.class);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> teamsResponseHandler.sendCardResponse(json, address, new HashMap<>()));
    verify(activityHandler).handleActivity(isA(Activity.class), isA(TeamsAddressable.class));
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName("Test performStorage(TeamsAddressable, Map, TeamsStateStorage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);

    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getTags()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", headerDetails);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(headerDetails).getTags();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link HeaderDetails#getDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given ArrayList() add 'foo'; then calls getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenArrayListAddFoo_thenCallsGetDescription() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");

    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(headerDetails.getName()).thenReturn("Name");
    when(headerDetails.getTags()).thenReturn(stringList);

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", headerDetails);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    TeamsResponseHandler.performStorage(address, data, new MemoryStateStorage(ejc));

    // Assert
    verify(address, atLeast(1)).getKey();
    verify(headerDetails).getDescription();
    verify(headerDetails).getName();
    verify(headerDetails, atLeast(1)).getTags();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code header}.
   *   <li>Then calls {@link HeaderDetails#getDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given ArrayList() add 'header'; then calls getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenArrayListAddHeader_thenCallsGetDescription() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("header");
    stringList.add("foo");

    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(headerDetails.getName()).thenReturn("Name");
    when(headerDetails.getTags()).thenReturn(stringList);

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", headerDetails);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    TeamsResponseHandler.performStorage(address, data, new MemoryStateStorage(ejc));

    // Assert
    verify(address, atLeast(1)).getKey();
    verify(headerDetails).getDescription();
    verify(headerDetails).getName();
    verify(headerDetails, atLeast(1)).getTags();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@link HeaderDetails#HeaderDetails()}.
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@link HeaderDetails#HeaderDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given HeaderDetails(); when HashMap() 'header' is HeaderDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenHeaderDetails_whenHashMapHeaderIsHeaderDetails() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", new HeaderDetails());
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());

    // Act
    TeamsResponseHandler.performStorage(address, data, new MemoryStateStorage(ejc));

    // Assert
    verify(address, atLeast(1)).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link ArrayList#ArrayList()} add noVersion {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given 'java.lang.Object'; when ArrayList() add noVersion Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenJavaLangObject_whenArrayListAddNoVersionObject() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(headerDetails.getName()).thenReturn("Name");
    when(headerDetails.getTags()).thenReturn(new ArrayList<>());

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", headerDetails);

    ArrayList<VersionSpace> initial = new ArrayList<>();
    Class<Object> class1 = Object.class;
    initial.add(ObjectMapperFactory.noVersion(class1));
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();

    EntityJsonConverter ejc = new EntityJsonConverter(om, initial);

    // Act
    TeamsResponseHandler.performStorage(address, data, new MemoryStateStorage(ejc));

    // Assert
    verify(address, atLeast(1)).getKey();
    verify(headerDetails).getDescription();
    verify(headerDetails).getName();
    verify(headerDetails, atLeast(1)).getTags();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@code null}.
   *   <li>Then throw {@link TeamsException}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given 'null'; when HashMap() 'header' is 'null'; then throw TeamsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenNull_whenHashMapHeaderIsNull_thenThrowTeamsException() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", null);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@link TeamsException#TeamsException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given TeamsException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenTeamsExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("storageId", "Data");
    data.put("header", new HeaderDetails());

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> TeamsResponseHandler.performStorage(address, data, teamsStateStorage));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map, TeamsStateStorage)}.
   *
   * <ul>
   *   <li>Given {@link TeamsStateStorage}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#performStorage(TeamsAddressable, Map,
   * TeamsStateStorage)}
   */
  @Test
  @DisplayName(
      "Test performStorage(TeamsAddressable, Map, TeamsStateStorage); given TeamsStateStorage; when HashMap(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsResponseHandler.performStorage(TeamsAddressable, Map, TeamsStateStorage)"
  })
  void testPerformStorage_givenTeamsStateStorage_whenHashMap_thenDoesNotThrow() {
    // Arrange
    TeamsAddressable address = mock(TeamsAddressable.class);

    // Act and Assert
    assertDoesNotThrow(
        () -> TeamsResponseHandler.performStorage(address, new HashMap<>(), teamsStateStorage));
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Given {@link HeaderDetails#HeaderDetails()}.
   *   <li>When {@link HashMap#HashMap()} {@code header} is {@link HeaderDetails#HeaderDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test createStorageTags(Map, TeamsAddressable); given HeaderDetails(); when HashMap() 'header' is HeaderDetails()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenHeaderDetails_whenHashMapHeaderIsHeaderDetails() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    data.put("header", new HeaderDetails());

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Map<String, String> actualCreateStorageTagsResult =
        TeamsResponseHandler.createStorageTags(data, address);

    // Assert
    verify(address).getKey();
    assertEquals(2, actualCreateStorageTagsResult.size());
    assertEquals("Key", actualCreateStorageTagsResult.get("addressable"));
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test createStorageTags(Map, TeamsAddressable); given 'Key'; when HashMap(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenKey_whenHashMap_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenReturn("Key");

    // Act
    Map<String, String> actualCreateStorageTagsResult =
        TeamsResponseHandler.createStorageTags(data, address);

    // Assert
    verify(address).getKey();
    assertEquals(2, actualCreateStorageTagsResult.size());
    assertEquals("Key", actualCreateStorageTagsResult.get("addressable"));
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Given {@link TeamsException#TeamsException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName(
      "Test createStorageTags(Map, TeamsAddressable); given TeamsException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_givenTeamsExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();

    TeamsAddressable address = mock(TeamsAddressable.class);
    when(address.getKey()).thenThrow(new TeamsException("An error occurred"));

    // Act and Assert
    assertThrows(TeamsException.class, () -> TeamsResponseHandler.createStorageTags(data, address));
    verify(address).getKey();
  }

  /**
   * Test {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}.
   *
   * <ul>
   *   <li>Then calls {@link HeaderDetails#getTags()}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsResponseHandler#createStorageTags(Map, TeamsAddressable)}
   */
  @Test
  @DisplayName("Test createStorageTags(Map, TeamsAddressable); then calls getTags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TeamsResponseHandler.createStorageTags(Map, TeamsAddressable)"})
  void testCreateStorageTags_thenCallsGetTags() {
    // Arrange
    HeaderDetails headerDetails = mock(HeaderDetails.class);
    when(headerDetails.getTags()).thenThrow(new TeamsException("An error occurred"));

    HashMap<String, Object> data = new HashMap<>();
    data.put("header", headerDetails);

    // Act and Assert
    assertThrows(
        TeamsException.class,
        () -> TeamsResponseHandler.createStorageTags(data, mock(TeamsAddressable.class)));
    verify(headerDetails).getTags();
  }
}
