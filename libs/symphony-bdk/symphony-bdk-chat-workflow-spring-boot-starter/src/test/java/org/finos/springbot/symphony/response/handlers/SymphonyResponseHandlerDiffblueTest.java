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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.symphony.bdk.core.service.message.MessageService;
import com.symphony.bdk.core.service.message.model.Message;
import com.symphony.bdk.gen.api.model.V4Message;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.conversations.StreamResolver;
import org.finos.springbot.symphony.templating.SymphonyTemplateProvider;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.data.DataHandler;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.templating.Markup;
import org.finos.springbot.workflow.response.templating.MarkupTemplateProvider;
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

@ContextConfiguration(classes = {SymphonyResponseHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SymphonyResponseHandlerDiffblueTest {
  @MockBean
  private DataHandler dataHandler;

  @MockBean
  private MarkupTemplateProvider<Markup> markupTemplateProvider;

  @MockBean
  private MessageService messageService;

  @MockBean
  private StreamResolver streamResolver;

  @Autowired
  private SymphonyResponseHandler symphonyResponseHandler;

  @MockBean
  private SymphonyTemplateProvider symphonyTemplateProvider;

  /**
   * Test {@link SymphonyResponseHandler#apply(Response)} with {@code Response}.
   * <ul>
   *   <li>Given {@link Addressable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; given Addressable; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.symphony.bdk.gen.api.model.V4Message org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.apply(org.finos.springbot.workflow.response.Response)"})
  void testApplyWithResponse_givenAddressable_thenReturnNull() {
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
   * <ul>
   *   <li>Then throw {@link SymphonyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; then throw SymphonyException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.symphony.bdk.gen.api.model.V4Message org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.apply(org.finos.springbot.workflow.response.Response)"})
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
   * <p>
   * Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.buildTemplate(org.finos.springbot.workflow.response.DataResponse)"})
  void testBuildTemplate() throws UnsupportedEncodingException {
    // Arrange
    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenThrow(new SymphonyException("An error occurred"));
    when(markupTemplateProvider.template(Mockito.<MessageResponse>any())).thenReturn(markup);
    Addressable stream = mock(Addressable.class);

    // Act and Assert
    assertThrows(SymphonyException.class, () -> symphonyResponseHandler
        .buildTemplate(new AttachmentResponse(stream, "AXAXAXAX".getBytes("UTF-8"), "Name", "Extension")));
    verify(markup).getContents();
    verify(markupTemplateProvider).template(isA(MessageResponse.class));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   * <ul>
   *   <li>Given {@link MarkupTemplateProvider}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse); given MarkupTemplateProvider")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.buildTemplate(org.finos.springbot.workflow.response.DataResponse)"})
  void testBuildTemplate_givenMarkupTemplateProvider() {
    // Arrange
    Addressable resultTo = mock(Addressable.class);

    // Act and Assert
    assertThrows(SymphonyException.class,
        () -> symphonyResponseHandler.buildTemplate(new DataResponse(resultTo, new HashMap<>(), "Template Name")));
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse); then return 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.buildTemplate(org.finos.springbot.workflow.response.DataResponse)"})
  void testBuildTemplate_thenReturnNotAllWhoWanderAreLost() throws UnsupportedEncodingException {
    // Arrange
    Markup markup = mock(Markup.class);
    when(markup.getContents()).thenReturn("Not all who wander are lost");
    when(markupTemplateProvider.template(Mockito.<MessageResponse>any())).thenReturn(markup);
    Addressable stream = mock(Addressable.class);

    // Act
    String actualBuildTemplateResult = symphonyResponseHandler
        .buildTemplate(new AttachmentResponse(stream, "AXAXAXAX".getBytes("UTF-8"), "Name", "Extension"));

    // Assert
    verify(markup).getContents();
    verify(markupTemplateProvider).template(isA(MessageResponse.class));
    assertEquals("Not all who wander are lost", actualBuildTemplateResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#buildTemplate(DataResponse)}.
   * <ul>
   *   <li>Then return {@code Template}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#buildTemplate(DataResponse)}
   */
  @Test
  @DisplayName("Test buildTemplate(DataResponse); then return 'Template'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.buildTemplate(org.finos.springbot.workflow.response.DataResponse)"})
  void testBuildTemplate_thenReturnTemplate() {
    // Arrange
    when(symphonyTemplateProvider.template(Mockito.<WorkResponse>any())).thenReturn("Template");
    Addressable stream = mock(Addressable.class);

    // Act
    String actualBuildTemplateResult = symphonyResponseHandler
        .buildTemplate(new ErrorResponse(stream, new Throwable()));

    // Assert
    verify(symphonyTemplateProvider).template(isA(WorkResponse.class));
    assertEquals("Template", actualBuildTemplateResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}.
   * <ul>
   *   <li>Given {@link MessageService}.</li>
   *   <li>When {@link Addressable}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}
   */
  @Test
  @DisplayName("Test sendResponse(String, byte[], String, Addressable, String); given MessageService; when Addressable; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.symphony.bdk.gen.api.model.V4Message org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.sendResponse(java.lang.String, byte[], java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.String)"})
  void testSendResponse_givenMessageService_whenAddressable_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(symphonyResponseHandler.sendResponse("Template", "AXAXAXAX".getBytes("UTF-8"), "Data",
        mock(Addressable.class), "foo.txt"));
  }

  /**
   * Test {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}.
   * <ul>
   *   <li>Then return {@link V4Message} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}
   */
  @Test
  @DisplayName("Test sendResponse(String, byte[], String, Addressable, String); then return V4Message (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.symphony.bdk.gen.api.model.V4Message org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.sendResponse(java.lang.String, byte[], java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.String)"})
  void testSendResponse_thenReturnV4Message() throws UnsupportedEncodingException {
    // Arrange
    V4Message v4Message = new V4Message();
    when(messageService.send(Mockito.<String>any(), Mockito.<Message>any())).thenReturn(v4Message);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    V4Message actualSendResponseResult = symphonyResponseHandler.sendResponse("Template", attachment, "Data",
        new SymphonyRoom("Name", "42"), "foo.txt");

    // Assert
    verify(messageService).send(eq("Stream For"), isA(Message.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertSame(v4Message, actualSendResponseResult);
  }

  /**
   * Test {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link V4Message} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SymphonyResponseHandler#sendResponse(String, byte[], String, Addressable, String)}
   */
  @Test
  @DisplayName("Test sendResponse(String, byte[], String, Addressable, String); when 'null'; then return V4Message (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.symphony.bdk.gen.api.model.V4Message org.finos.springbot.symphony.response.handlers.SymphonyResponseHandler.sendResponse(java.lang.String, byte[], java.lang.String, org.finos.springbot.workflow.content.Addressable, java.lang.String)"})
  void testSendResponse_whenNull_thenReturnV4Message() {
    // Arrange
    V4Message v4Message = new V4Message();
    when(messageService.send(Mockito.<String>any(), Mockito.<Message>any())).thenReturn(v4Message);
    when(streamResolver.getStreamFor(Mockito.<SymphonyAddressable>any())).thenReturn("Stream For");

    // Act
    V4Message actualSendResponseResult = symphonyResponseHandler.sendResponse("Template", null, "Data",
        new SymphonyRoom("Name", "42"), "foo.txt");

    // Assert
    verify(messageService).send(eq("Stream For"), isA(Message.class));
    verify(streamResolver).getStreamFor(isA(SymphonyAddressable.class));
    assertSame(v4Message, actualSendResponseResult);
  }
}
