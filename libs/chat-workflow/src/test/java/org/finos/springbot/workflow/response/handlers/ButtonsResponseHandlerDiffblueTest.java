package org.finos.springbot.workflow.response.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.finos.springbot.workflow.annotations.ChatButton;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.ChatButtonChatHandlerMapping;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.finos.springbot.workflow.response.ErrorResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ButtonsResponseHandler.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class ButtonsResponseHandlerDiffblueTest {
  @Autowired private ButtonsResponseHandler buttonsResponseHandler;

  /**
   * Test {@link ButtonsResponseHandler#formatFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#formatFieldName(String)}
   */
  @Test
  @DisplayName("Test formatFieldName(String); when 'Field Name'; then return 'Field Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ButtonsResponseHandler.formatFieldName(String)"})
  void testFormatFieldName_whenFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field  Name", ButtonsResponseHandler.formatFieldName("Field Name"));
  }

  /**
   * Test {@link ButtonsResponseHandler#formatFieldName(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#formatFieldName(String)}
   */
  @Test
  @DisplayName("Test formatFieldName(String); when space; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ButtonsResponseHandler.formatFieldName(String)"})
  void testFormatFieldName_whenSpace_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ButtonsResponseHandler.formatFieldName(" "));
  }

  /**
   * Test {@link ButtonsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ButtonsResponseHandler.apply(Response)"})
  void testApplyWithResponse() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse t = new ErrorResponse(stream, new Throwable());

    // Act
    buttonsResponseHandler.apply(t);

    // Assert
    ButtonList buttons = t.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    assertEquals(0, buttons.size());
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ButtonsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ButtonsResponseHandler.apply(Response)"})
  void testApplyWithResponse2() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    ErrorResponse t = new ErrorResponse(stream, new Throwable(), "Template Name");

    // Act
    buttonsResponseHandler.apply(t);

    // Assert
    ButtonList buttons = t.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    assertEquals(0, buttons.size());
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(data.containsKey("error"));
    assertTrue(data.containsKey("message"));
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ButtonsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <p>Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ButtonsResponseHandler.apply(Response)"})
  void testApplyWithResponse3() {
    // Arrange
    WorkResponse t = new WorkResponse(mock(Addressable.class), "42", WorkMode.BOTH);

    // Act
    buttonsResponseHandler.apply(t);

    // Assert that nothing has changed
    ButtonList buttons = t.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    assertEquals(0, buttons.size());
    Map<String, Object> data = t.getData();
    assertEquals(3, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ButtonsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName(
      "Test apply(Response) with 'Response'; then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ButtonsResponseHandler.apply(Response)"})
  void testApplyWithResponse_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    ButtonList buttonList = mock(ButtonList.class);
    when(buttonList.getContents()).thenThrow(new FactoryBeanNotInitializedException("Msg"));

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("buttons", buttonList);
    ErrorResponse t = mock(ErrorResponse.class);
    when(t.getData()).thenReturn(stringObjectMap);
    when(t.getFormObject()).thenReturn("Form Object");
    when(t.getMode()).thenReturn(WorkMode.BOTH);

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class, () -> buttonsResponseHandler.apply(t));
    verify(buttonList).getContents();
    verify(t).getData();
    verify(t).getFormObject();
    verify(t).getMode();
  }

  /**
   * Test {@link ButtonsResponseHandler#apply(Response)} with {@code Response}.
   *
   * <ul>
   *   <li>When {@link Response}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#apply(Response)}
   */
  @Test
  @DisplayName("Test apply(Response) with 'Response'; when Response; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Void ButtonsResponseHandler.apply(Response)"})
  void testApplyWithResponse_whenResponse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(buttonsResponseHandler.apply(mock(Response.class)));
  }

  /**
   * Test {@link ButtonsResponseHandler#initExposedHandlerMappings()}.
   *
   * <p>Method under test: {@link ButtonsResponseHandler#initExposedHandlerMappings()}
   */
  @Test
  @DisplayName("Test initExposedHandlerMappings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ButtonsResponseHandler.initExposedHandlerMappings()"})
  void testInitExposedHandlerMappings() throws BeansException {
    // Arrange
    ClassPathXmlApplicationContext applicationContext = mock(ClassPathXmlApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations()));
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"foo", null});
    doNothing()
        .when(applicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    applicationContext.addBeanFactoryPostProcessor(new CustomAutowireConfigurer());

    ButtonsResponseHandler buttonsResponseHandler = new ButtonsResponseHandler();
    buttonsResponseHandler.setApplicationContext(applicationContext);

    // Act
    buttonsResponseHandler.initExposedHandlerMappings();

    // Assert
    verify(applicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
  }

  /**
   * Test {@link ButtonsResponseHandler#initExposedHandlerMappings()}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       ClassPathXmlApplicationContext#addBeanFactoryPostProcessor(BeanFactoryPostProcessor)}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#initExposedHandlerMappings()}
   */
  @Test
  @DisplayName(
      "Test initExposedHandlerMappings(); then calls addBeanFactoryPostProcessor(BeanFactoryPostProcessor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ButtonsResponseHandler.initExposedHandlerMappings()"})
  void testInitExposedHandlerMappings_thenCallsAddBeanFactoryPostProcessor() throws BeansException {
    // Arrange
    ClassPathXmlApplicationContext applicationContext = mock(ClassPathXmlApplicationContext.class);
    WorkflowResolversFactory wrf = new WorkflowResolversFactory();
    ResponseConverters converters = mock(ResponseConverters.class);
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new ChatButtonChatHandlerMapping(wrf, converters, new AllConversations()));
    when(applicationContext.getBeanNamesForType(Mockito.<ResolvableType>any()))
        .thenReturn(new String[] {"Bean Names For Type"});
    doNothing()
        .when(applicationContext)
        .addBeanFactoryPostProcessor(Mockito.<BeanFactoryPostProcessor>any());
    applicationContext.addBeanFactoryPostProcessor(new CustomAutowireConfigurer());

    ButtonsResponseHandler buttonsResponseHandler = new ButtonsResponseHandler();
    buttonsResponseHandler.setApplicationContext(applicationContext);

    // Act
    buttonsResponseHandler.initExposedHandlerMappings();

    // Assert
    verify(applicationContext).addBeanFactoryPostProcessor(isA(BeanFactoryPostProcessor.class));
    verify(applicationContext).getBean(eq("Bean Names For Type"));
    verify(applicationContext).getBeanNamesForType(isA(ResolvableType.class));
  }

  /**
   * Test {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}
   */
  @Test
  @DisplayName(
      "Test exposedMatchesObject(ChatButton, Object); given 'java.lang.Object'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ButtonsResponseHandler.exposedMatchesObject(ChatButton, Object)"})
  void testExposedMatchesObject_givenJavaLangObject_thenReturnTrue() {
    // Arrange
    ChatButton e = mock(ChatButton.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(e.value()).thenReturn(forNameResult);

    // Act
    boolean actualExposedMatchesObjectResult = buttonsResponseHandler.exposedMatchesObject(e, "42");

    // Assert
    verify(e).value();
    assertTrue(actualExposedMatchesObjectResult);
  }

  /**
   * Test {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When {@link ChatButton} {@link ChatButton#value()} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}
   */
  @Test
  @DisplayName(
      "Test exposedMatchesObject(ChatButton, Object); given 'java.util.List'; when ChatButton value() return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ButtonsResponseHandler.exposedMatchesObject(ChatButton, Object)"})
  void testExposedMatchesObject_givenJavaUtilList_whenChatButtonValueReturnList() {
    // Arrange
    ChatButton e = mock(ChatButton.class);
    Class<List> forNameResult = List.class;
    Mockito.<Class<?>>when(e.value()).thenReturn(forNameResult);

    // Act
    boolean actualExposedMatchesObjectResult = buttonsResponseHandler.exposedMatchesObject(e, "42");

    // Assert
    verify(e).value();
    assertFalse(actualExposedMatchesObjectResult);
  }

  /**
   * Test {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}
   */
  @Test
  @DisplayName(
      "Test exposedMatchesObject(ChatButton, Object); then throw FactoryBeanNotInitializedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ButtonsResponseHandler.exposedMatchesObject(ChatButton, Object)"})
  void testExposedMatchesObject_thenThrowFactoryBeanNotInitializedException() {
    // Arrange
    ChatButton e = mock(ChatButton.class);
    Mockito.<Class<?>>when(e.value()).thenThrow(new FactoryBeanNotInitializedException("Msg"));

    // Act and Assert
    assertThrows(
        FactoryBeanNotInitializedException.class,
        () -> buttonsResponseHandler.exposedMatchesObject(e, "42"));
    verify(e).value();
  }

  /**
   * Test {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}.
   *
   * <ul>
   *   <li>When {@link ChatButton}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ButtonsResponseHandler#exposedMatchesObject(ChatButton, Object)}
   */
  @Test
  @DisplayName(
      "Test exposedMatchesObject(ChatButton, Object); when ChatButton; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ButtonsResponseHandler.exposedMatchesObject(ChatButton, Object)"})
  void testExposedMatchesObject_whenChatButton_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(buttonsResponseHandler.exposedMatchesObject(mock(ChatButton.class), null));
  }

  /**
   * Test {@link ButtonsResponseHandler#getOrder()}.
   *
   * <p>Method under test: {@link ButtonsResponseHandler#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ButtonsResponseHandler.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, buttonsResponseHandler.getOrder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ButtonsResponseHandler}
   *   <li>{@link ButtonsResponseHandler#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ButtonsResponseHandler.<init>()",
    "void ButtonsResponseHandler.setApplicationContext(ApplicationContext)"
  })
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    ButtonsResponseHandler actualButtonsResponseHandler = new ButtonsResponseHandler();
    actualButtonsResponseHandler.setApplicationContext(
        new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertEquals(ResponseHandler.MEDIUM_PRIORITY, actualButtonsResponseHandler.getOrder());
  }
}
