package org.finos.springbot.symphony.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.service.message.MessageService;
import com.symphony.bdk.core.service.message.model.Message;
import com.symphony.bdk.gen.api.model.V4Message;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.conversations.StreamResolver;
import org.finos.springbot.symphony.response.templating.SymphonyMarkupTemplateProvider;
import org.finos.springbot.symphony.templating.FreemarkerRendering;
import org.finos.springbot.symphony.templating.FreemarkerWorkTemplater;
import org.finos.springbot.symphony.templating.SymphonyTemplateProvider;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.data.DataHandler;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.templating.Markup;
import org.finos.springbot.workflow.response.templating.MarkupTemplateProvider;
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

@ContextConfiguration(classes = {SymphonyResponseHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SymphonyResponseHandlerDiffblueTest {
  @MockitoBean private DataHandler dataHandler;

  @MockitoBean private MarkupTemplateProvider<Markup> markupTemplateProvider;

  @MockitoBean private MessageService messageService;

  @MockitoBean private StreamResolver streamResolver;

  @Autowired private SymphonyResponseHandler symphonyResponseHandler;

  @MockitoBean private SymphonyTemplateProvider symphonyTemplateProvider;

  /**
   * Test {@link SymphonyResponseHandler#initErrorHandler()}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getBean(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#initErrorHandler()}
   */
  @Test
  @DisplayName("Test initErrorHandler(); then calls getBean(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyResponseHandler.initErrorHandler()"})
  void testInitErrorHandler_thenCallsGetBean() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<Class<ErrorHandler>>any()))
        .thenReturn(mock(ErrorHandler.class));
    DataHandler dataHandler = mock(DataHandler.class);
    SymphonyMarkupTemplateProvider messageTemplater =
        new SymphonyMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            mock(BiFunction.class));
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    FreemarkerWorkTemplater formConverter =
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering());

    SymphonyTemplateProvider workTemplater =
        new SymphonyTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, formConverter);

    SymphonyResponseHandler symphonyResponseHandler =
        new SymphonyResponseHandler(
            null, dataHandler, messageTemplater, workTemplater, mock(StreamResolver.class));
    symphonyResponseHandler.setApplicationContext(applicationContext);

    // Act
    symphonyResponseHandler.initErrorHandler();

    // Assert
    verify(applicationContext).getBean(isA(Class.class));
  }

  /**
   * Test {@link SymphonyResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@link Addressable}.
   *   <li>When {@link Response} {@link Response#getAddress()} return {@link Addressable}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; given Addressable; when Response getAddress() return Addressable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"V4Message SymphonyResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenAddressable_whenResponseGetAddressReturnAddressable() {
    // Arrange
    Response t = mock(Response.class);
    when(t.getAddress()).thenReturn(mock(Addressable.class));

    // Act
    V4Message actualApplyResult = symphonyResponseHandler.apply(t);

    // Assert
    verify(t).getAddress();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Given {@link SymphonyAddressable}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; given SymphonyAddressable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"V4Message SymphonyResponseHandler.apply(Response)"})
  void testApplyWithResponse_givenSymphonyAddressable() {
    // Arrange
    Response t = mock(Response.class);
    when(t.getAddress()).thenReturn(mock(SymphonyAddressable.class));

    // Act
    V4Message actualApplyResult = symphonyResponseHandler.apply(t);

    // Assert
    verify(t).getAddress();
    assertNull(actualApplyResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Then throw {@link SymphonyException}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; then throw SymphonyException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"V4Message SymphonyResponseHandler.apply(Response)"})
  void testApplyWithResponse_thenThrowSymphonyException() {
    // Arrange
    Response t = mock(Response.class);
    when(t.getAddress()).thenThrow(new SymphonyException("An error occurred"));

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyResponseHandler.apply(t));
    verify(t).getAddress();
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);
    DataResponse t = new DataResponse(resultTo, new HashMap<>(), "Template Name");

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyResponseHandler.buildTemplate(t));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate2() {
    // Arrange
    when(markupTemplateProvider.template(Mockito.<MessageResponse>any()))
        .thenThrow(new SymphonyException("An error occurred"));

    // Act and Assert
    assertThrows(
        SymphonyException.class,
        () ->
            symphonyResponseHandler.buildTemplate(
                new MessageResponse(mock(Addressable.class), "Not all who wander are lost")));
    verify(markupTemplateProvider).template(isA(MessageResponse.class));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate3() {
    // Arrange
    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenThrow(new SymphonyException("An error occurred"));
    when(markupTemplateProvider.template(Mockito.<MessageResponse>any())).thenReturn(markup);

    // Act and Assert
    assertThrows(
        SymphonyException.class,
        () ->
            symphonyResponseHandler.buildTemplate(
                new MessageResponse(mock(Addressable.class), "Not all who wander are lost")));
    verify(markup).getContents();
    verify(markupTemplateProvider).template(isA(MessageResponse.class));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate4() {
    // Arrange
    when(symphonyTemplateProvider.template(Mockito.<WorkResponse>any()))
        .thenThrow(new SymphonyException("An error occurred"));

    // Act and Assert
    assertThrows(
        SymphonyException.class,
        () ->
            symphonyResponseHandler.buildTemplate(
                new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH)));
    verify(symphonyTemplateProvider).template(isA(WorkResponse.class));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <ul>
   *   <li>Given {@link BiFunction} {@link BiFunction#apply(Object, Object)} return {@code Apply}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName(
      "Test buildTemplate(DataResponse); given BiFunction apply(Object, Object) return 'Apply'; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate_givenBiFunctionApplyReturnApply_thenReturnApply()
      throws UnsupportedEncodingException {
    // Arrange
    BiFunction<Content, Markup, String> converter = mock(BiFunction.class);
    when(converter.apply(Mockito.<Content>any(), Mockito.<Markup>any())).thenReturn("Apply");
    SymphonyMarkupTemplateProvider messageTemplater =
        new SymphonyMarkupTemplateProvider(
            "Template Prefix",
            "Template Suffix",
            "Default Template Name",
            new ApplicationResourceLoader(),
            converter);
    DataHandler dataHandler = mock(DataHandler.class);
    ApplicationResourceLoader rl = new ApplicationResourceLoader();
    ArrayList<TypeConverter<String>> fieldConverters = new ArrayList<>();
    FreemarkerWorkTemplater formConverter =
        new FreemarkerWorkTemplater(fieldConverters, new FreemarkerRendering());

    SymphonyTemplateProvider workTemplater =
        new SymphonyTemplateProvider(
            "Template Prefix", "Template Suffix", "Default Template Name", rl, formConverter);

    SymphonyResponseHandler symphonyResponseHandler =
        new SymphonyResponseHandler(
            null, dataHandler, messageTemplater, workTemplater, mock(StreamResolver.class));
    AttachmentResponse t =
        new AttachmentResponse(
            mock(Addressable.class), "AXAXAXAX".getBytes("UTF-8"), "Name", "Extension");

    // Act
    String actualBuildTemplateResult = symphonyResponseHandler.buildTemplate(t);

    // Assert
    verify(converter).apply(isA(Content.class), isA(Markup.class));
    assertEquals("Apply", actualBuildTemplateResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse); then return 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenReturn("Not all who wander are lost");
    when(markupTemplateProvider.template(Mockito.<MessageResponse>any())).thenReturn(markup);

    // Act
    String actualBuildTemplateResult =
        symphonyResponseHandler.buildTemplate(
            new MessageResponse(mock(Addressable.class), "Not all who wander are lost"));

    // Assert
    verify(markup).getContents();
    verify(markupTemplateProvider).template(isA(MessageResponse.class));
    assertEquals("Not all who wander are lost", actualBuildTemplateResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   *
   * <ul>
   *   <li>Then return {@code Template}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse); then return 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SymphonyResponseHandler.buildTemplate(DataResponse)"})
  void testBuildTemplate_thenReturnTemplate() {
    // Arrange
    when(symphonyTemplateProvider.template(Mockito.<WorkResponse>any())).thenReturn("Template");

    // Act
    String actualBuildTemplateResult =
        symphonyResponseHandler.buildTemplate(
            new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH));

    // Assert
    verify(symphonyTemplateProvider).template(isA(WorkResponse.class));
    assertEquals("Template", actualBuildTemplateResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}.
   *
   * <ul>
   *   <li>Given {@link MessageService} {@link MessageService#send(String, Message)} return {@link
   *       V4Message} (default constructor).
   *   <li>Then return {@link V4Message} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#sendResponse(String, byte[], String,
   * Addressable, String)}
   */
  @Test
  @DisplayName(
      "Test sendResponse(String, byte[], String, Addressable, String); given MessageService send(String, Message) return V4Message (default constructor); then return V4Message (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "V4Message SymphonyResponseHandler.sendResponse(String, byte[], String, Addressable, String)"
  })
  void testSendResponse_givenMessageServiceSendReturnV4Message_thenReturnV4Message() {
    // Arrange
    V4Message v4Message = new V4Message();
    when(messageService.send(Mockito.<String>any(), Mockito.<Message>any())).thenReturn(v4Message);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");

    // Act
    V4Message actualSendResponseResult =
        symphonyResponseHandler.sendResponse(
            "Template", null, "Data", mock(SymphonyAddressable.class), "");

    // Assert
    verify(messageService).send(eq("Stream For"), isA(Message.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertSame(v4Message, actualSendResponseResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}.
   *
   * <ul>
   *   <li>Given {@link StreamResolver}.
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SymphonyResponseHandler#sendResponse(String, byte[], String,
   * Addressable, String)}
   */
  @Test
  @DisplayName(
      "Test sendResponse(String, byte[], String, Addressable, String); given StreamResolver; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "V4Message SymphonyResponseHandler.sendResponse(String, byte[], String, Addressable, String)"
  })
  void testSendResponse_givenStreamResolver_whenAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        symphonyResponseHandler.sendResponse(
            "Template", "AXAXAXAX".getBytes("UTF-8"), "Data", mock(Addressable.class), "foo.txt"));
  }
}
