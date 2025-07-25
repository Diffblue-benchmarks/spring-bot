package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.annotations.ChatResponseBody;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.java.mapping.ChatHandlerExecutor;
import org.finos.springbot.workflow.java.mapping.ChatHandlerMethod;
import org.finos.springbot.workflow.java.mapping.ChatMapping;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WorkResponseConverter.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class WorkResponseConverterDiffblueTest {
  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private WorkResponseConverter workResponseConverter;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WorkResponseConverter#WorkResponseConverter(ResponseHandlers)}
   *   <li>{@link WorkResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WorkResponseConverter.<init>(ResponseHandlers)",
    "int WorkResponseConverter.getOrder()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        Integer.MAX_VALUE, new WorkResponseConverter(mock(ResponseHandlers.class)).getOrder());
  }

  /**
   * Test {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Given {@link ChatHandlerMethod} {@link ChatHandlerMethod#getMethodAnnotation(Class)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, ChatHandlerExecutor); given ChatHandlerMethod getMethodAnnotation(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response WorkResponseConverter.convert(Object, ChatHandlerExecutor)"})
  void testConvert_givenChatHandlerMethodGetMethodAnnotationReturnNull() {
    // Arrange
    ChatHandlerMethod chatHandlerMethod = mock(ChatHandlerMethod.class);
    when(chatHandlerMethod.getMethodAnnotation(Mockito.<Class<ChatResponseBody>>any()))
        .thenReturn(null);
    ChatMapping<Object> chatMapping = mock(ChatMapping.class);
    when(chatMapping.getHandlerMethod()).thenReturn(chatHandlerMethod);
    ChatHandlerExecutor creator = mock(ChatHandlerExecutor.class);
    Mockito.<ChatMapping<?>>when(creator.getOriginatingMapping()).thenReturn(chatMapping);
    when(creator.action()).thenReturn(Action.NULL_ACTION);

    // Act
    Response actualConvertResult = workResponseConverter.convert("Source", creator);
    Addressable actualAddress = actualConvertResult.getAddress();

    // Assert
    verify(creator).action();
    verify(creator).getOriginatingMapping();
    verify(chatHandlerMethod).getMethodAnnotation(isA(Class.class));
    verify(chatMapping).getHandlerMethod();
    assertTrue(actualConvertResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) actualConvertResult).getTemplateName());
    assertNull(actualConvertResult.getAddress());
    assertNull(actualAddress);
    assertEquals(WorkMode.VIEW, ((WorkResponse) actualConvertResult).getMode());
  }

  /**
   * Test {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Given {@link ChatResponseBody} {@link ChatResponseBody#template()} return space.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, ChatHandlerExecutor); given ChatResponseBody template() return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response WorkResponseConverter.convert(Object, ChatHandlerExecutor)"})
  void testConvert_givenChatResponseBodyTemplateReturnSpace() {
    // Arrange
    ChatResponseBody chatResponseBody = mock(ChatResponseBody.class);
    when(chatResponseBody.template()).thenReturn(" ");
    when(chatResponseBody.workMode()).thenReturn(WorkMode.BOTH);
    ChatHandlerMethod chatHandlerMethod = mock(ChatHandlerMethod.class);
    when(chatHandlerMethod.getMethodAnnotation(Mockito.<Class<ChatResponseBody>>any()))
        .thenReturn(chatResponseBody);
    ChatMapping<Object> chatMapping = mock(ChatMapping.class);
    when(chatMapping.getHandlerMethod()).thenReturn(chatHandlerMethod);
    ChatHandlerExecutor creator = mock(ChatHandlerExecutor.class);
    Mockito.<ChatMapping<?>>when(creator.getOriginatingMapping()).thenReturn(chatMapping);
    when(creator.action()).thenReturn(Action.NULL_ACTION);

    // Act
    Response actualConvertResult = workResponseConverter.convert("Source", creator);
    Addressable actualAddress = actualConvertResult.getAddress();

    // Assert
    verify(chatResponseBody).template();
    verify(chatResponseBody).workMode();
    verify(creator).action();
    verify(creator).getOriginatingMapping();
    verify(chatHandlerMethod).getMethodAnnotation(isA(Class.class));
    verify(chatMapping).getHandlerMethod();
    assertTrue(actualConvertResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) actualConvertResult).getTemplateName());
    assertNull(actualConvertResult.getAddress());
    assertNull(actualAddress);
    assertEquals(WorkMode.VIEW, ((WorkResponse) actualConvertResult).getMode());
  }

  /**
   * Test {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Given {@link ChatResponseBody} {@link ChatResponseBody#workMode()} return {@code EDIT}.
   *   <li>Then return Mode is {@code EDIT}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName(
      "Test convert(Object, ChatHandlerExecutor); given ChatResponseBody workMode() return 'EDIT'; then return Mode is 'EDIT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response WorkResponseConverter.convert(Object, ChatHandlerExecutor)"})
  void testConvert_givenChatResponseBodyWorkModeReturnEdit_thenReturnModeIsEdit() {
    // Arrange
    ChatResponseBody chatResponseBody = mock(ChatResponseBody.class);
    when(chatResponseBody.template()).thenReturn("Template");
    when(chatResponseBody.workMode()).thenReturn(WorkMode.EDIT);
    ChatHandlerMethod chatHandlerMethod = mock(ChatHandlerMethod.class);
    when(chatHandlerMethod.getMethodAnnotation(Mockito.<Class<ChatResponseBody>>any()))
        .thenReturn(chatResponseBody);
    ChatMapping<Object> chatMapping = mock(ChatMapping.class);
    when(chatMapping.getHandlerMethod()).thenReturn(chatHandlerMethod);
    ChatHandlerExecutor creator = mock(ChatHandlerExecutor.class);
    Mockito.<ChatMapping<?>>when(creator.getOriginatingMapping()).thenReturn(chatMapping);
    when(creator.action()).thenReturn(Action.NULL_ACTION);

    // Act
    Response actualConvertResult = workResponseConverter.convert("Source", creator);
    Addressable actualAddress = actualConvertResult.getAddress();

    // Assert
    verify(chatResponseBody).template();
    verify(chatResponseBody).workMode();
    verify(creator).action();
    verify(creator).getOriginatingMapping();
    verify(chatHandlerMethod).getMethodAnnotation(isA(Class.class));
    verify(chatMapping).getHandlerMethod();
    assertTrue(actualConvertResult instanceof WorkResponse);
    assertEquals("Template", ((WorkResponse) actualConvertResult).getTemplateName());
    assertNull(actualConvertResult.getAddress());
    assertNull(actualAddress);
    assertEquals(WorkMode.EDIT, ((WorkResponse) actualConvertResult).getMode());
  }

  /**
   * Test {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test convert(Object, ChatHandlerExecutor); then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response WorkResponseConverter.convert(Object, ChatHandlerExecutor)"})
  void testConvert_thenButtonsContentsReturnList() {
    // Arrange
    ChatResponseBody chatResponseBody = mock(ChatResponseBody.class);
    when(chatResponseBody.template()).thenReturn("Template");
    when(chatResponseBody.workMode()).thenReturn(WorkMode.BOTH);
    ChatHandlerMethod chatHandlerMethod = mock(ChatHandlerMethod.class);
    when(chatHandlerMethod.getMethodAnnotation(Mockito.<Class<ChatResponseBody>>any()))
        .thenReturn(chatResponseBody);
    ChatMapping<Object> chatMapping = mock(ChatMapping.class);
    when(chatMapping.getHandlerMethod()).thenReturn(chatHandlerMethod);
    ChatHandlerExecutor creator = mock(ChatHandlerExecutor.class);
    Mockito.<ChatMapping<?>>when(creator.getOriginatingMapping()).thenReturn(chatMapping);
    when(creator.action()).thenReturn(new ErrorAction(mock(Addressable.class), "Ej"));

    // Act
    Response actualConvertResult = workResponseConverter.convert("Source", creator);
    actualConvertResult.getAddress();

    // Assert
    verify(chatResponseBody).template();
    verify(chatResponseBody).workMode();
    verify(creator).action();
    verify(creator).getOriginatingMapping();
    verify(chatHandlerMethod).getMethodAnnotation(isA(Class.class));
    verify(chatMapping).getHandlerMethod();
    ButtonList buttons = ((WorkResponse) actualConvertResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) actualConvertResult).getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(actualConvertResult instanceof WorkResponse);
    assertEquals("Source", data.get("form"));
    assertEquals("Source", ((WorkResponse) actualConvertResult).getFormObject());
    assertEquals(0, buttons.size());
    assertTrue(contents.isEmpty());
    Class<String> expectedFormClass = String.class;
    assertEquals(expectedFormClass, ((WorkResponse) actualConvertResult).getFormClass());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}.
   *
   * <ul>
   *   <li>Then return TemplateName is {@code Template}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#convert(Object, ChatHandlerExecutor)}
   */
  @Test
  @DisplayName("Test convert(Object, ChatHandlerExecutor); then return TemplateName is 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response WorkResponseConverter.convert(Object, ChatHandlerExecutor)"})
  void testConvert_thenReturnTemplateNameIsTemplate() {
    // Arrange
    ChatResponseBody chatResponseBody = mock(ChatResponseBody.class);
    when(chatResponseBody.template()).thenReturn("Template");
    when(chatResponseBody.workMode()).thenReturn(WorkMode.BOTH);
    ChatHandlerMethod chatHandlerMethod = mock(ChatHandlerMethod.class);
    when(chatHandlerMethod.getMethodAnnotation(Mockito.<Class<ChatResponseBody>>any()))
        .thenReturn(chatResponseBody);
    ChatMapping<Object> chatMapping = mock(ChatMapping.class);
    when(chatMapping.getHandlerMethod()).thenReturn(chatHandlerMethod);
    ChatHandlerExecutor creator = mock(ChatHandlerExecutor.class);
    Mockito.<ChatMapping<?>>when(creator.getOriginatingMapping()).thenReturn(chatMapping);
    when(creator.action()).thenReturn(Action.NULL_ACTION);

    // Act
    Response actualConvertResult = workResponseConverter.convert("Source", creator);
    Addressable actualAddress = actualConvertResult.getAddress();

    // Assert
    verify(chatResponseBody).template();
    verify(chatResponseBody).workMode();
    verify(creator).action();
    verify(creator).getOriginatingMapping();
    verify(chatHandlerMethod).getMethodAnnotation(isA(Class.class));
    verify(chatMapping).getHandlerMethod();
    assertTrue(actualConvertResult instanceof WorkResponse);
    assertEquals("Template", ((WorkResponse) actualConvertResult).getTemplateName());
    assertNull(actualConvertResult.getAddress());
    assertNull(actualAddress);
    assertEquals(WorkMode.VIEW, ((WorkResponse) actualConvertResult).getMode());
  }

  /**
   * Test {@link WorkResponseConverter#canConvert(Object)}.
   *
   * <ul>
   *   <li>When {@code In}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#canConvert(Object)}
   */
  @Test
  @DisplayName("Test canConvert(Object); when 'In'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WorkResponseConverter.canConvert(Object)"})
  void testCanConvert_whenIn() {
    // Arrange, Act and Assert
    assertFalse(workResponseConverter.canConvert("In"));
  }

  /**
   * Test {@link WorkResponseConverter#canConvert(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WorkResponseConverter#canConvert(Object)}
   */
  @Test
  @DisplayName("Test canConvert(Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean WorkResponseConverter.canConvert(Object)"})
  void testCanConvert_whenNull() {
    // Arrange, Act and Assert
    assertFalse(workResponseConverter.canConvert(null));
  }
}
