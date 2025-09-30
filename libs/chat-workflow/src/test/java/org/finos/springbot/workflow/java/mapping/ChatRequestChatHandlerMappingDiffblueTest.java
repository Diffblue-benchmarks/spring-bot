package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.ErrorAction;
import org.finos.springbot.workflow.annotations.ChatRequest;
import org.finos.springbot.workflow.annotations.ChatVariable;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.java.converters.ResponseConverters;
import org.finos.springbot.workflow.java.mapping.WildcardContent.Arity;
import org.finos.springbot.workflow.java.resolvers.WorkflowResolversFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ChatRequestChatHandlerMapping.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ChatRequestChatHandlerMappingDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @Autowired private ChatRequestChatHandlerMapping chatRequestChatHandlerMapping;

  @MockitoBean private ResponseConverters responseConverters;

  @MockitoBean private WorkflowResolversFactory workflowResolversFactory;

  /**
   * Test {@link
   * ChatRequestChatHandlerMapping#ChatRequestChatHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}.
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#ChatRequestChatHandlerMapping(WorkflowResolversFactory,
   * ResponseConverters, AllConversations)}
   */
  @Test
  @DisplayName(
      "Test new ChatRequestChatHandlerMapping(WorkflowResolversFactory, ResponseConverters, AllConversations)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChatRequestChatHandlerMapping.<init>(WorkflowResolversFactory, ResponseConverters, AllConversations)"
  })
  void testNewChatRequestChatHandlerMapping() throws IllegalStateException {
    // Arrange and Act
    ChatRequestChatHandlerMapping actualChatRequestChatHandlerMapping =
        new ChatRequestChatHandlerMapping(
            workflowResolversFactory, mock(ResponseConverters.class), allConversations);

    // Assert
    assertNull(actualChatRequestChatHandlerMapping.getApplicationContext());
    assertTrue(actualChatRequestChatHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualChatRequestChatHandlerMapping.mappingRegistry.getRegistrations().isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getHandlers(Action)}.
   *
   * <ul>
   *   <li>When {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable}
   *       and {@code Ej}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  @DisplayName(
      "Test getHandlers(Action); when ErrorAction(Addressable, Object) with a is Addressable and 'Ej'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.getHandlers(Action)"})
  void testGetHandlers_whenErrorActionWithAIsAddressableAndEj_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        chatRequestChatHandlerMapping
            .getHandlers(new ErrorAction(mock(Addressable.class), "Ej"))
            .isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getHandlers(Action)}.
   *
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getHandlers(Action)}
   */
  @Test
  @DisplayName("Test getHandlers(Action); when NULL_ACTION; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.getHandlers(Action)"})
  void testGetHandlers_whenNull_action_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(chatRequestChatHandlerMapping.getHandlers(Action.NULL_ACTION).isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getAllHandlers(Addressable, User)}.
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getAllHandlers(Addressable, User)}
   */
  @Test
  @DisplayName("Test getAllHandlers(Addressable, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.getAllHandlers(Addressable, User)"})
  void testGetAllHandlers() {
    // Arrange, Act and Assert
    assertTrue(
        chatRequestChatHandlerMapping
            .getAllHandlers(mock(Addressable.class), mock(User.class))
            .isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getExecutors(Action)}.
   *
   * <ul>
   *   <li>When {@link ErrorAction#ErrorAction(Addressable, Object)} with a is {@link Addressable}
   *       and {@code Ej}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  @DisplayName(
      "Test getExecutors(Action); when ErrorAction(Addressable, Object) with a is Addressable and 'Ej'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.getExecutors(Action)"})
  void testGetExecutors_whenErrorActionWithAIsAddressableAndEj_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        chatRequestChatHandlerMapping
            .getExecutors(new ErrorAction(mock(Addressable.class), "Ej"))
            .isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getExecutors(Action)}.
   *
   * <ul>
   *   <li>When {@link Action#NULL_ACTION}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getExecutors(Action)}
   */
  @Test
  @DisplayName("Test getExecutors(Action); when NULL_ACTION; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.getExecutors(Action)"})
  void testGetExecutors_whenNull_action_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(chatRequestChatHandlerMapping.getExecutors(Action.NULL_ACTION).isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName(
      "Test createMessageMatchers(ChatRequest, List); given array of String with '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_givenArrayOfStringWith42_thenReturnSizeIsOne() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"42"});

    // Act
    List<MessageMatcher> actualCreateMessageMatchersResult =
        chatRequestChatHandlerMapping.createMessageMatchers(mapping, new ArrayList<>());

    // Assert
    verify(mapping).value();
    assertEquals(1, actualCreateMessageMatchersResult.size());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Given empty array of {@link String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName(
      "Test createMessageMatchers(ChatRequest, List); given empty array of String; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_givenEmptyArrayOfString_thenReturnEmpty() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {});

    // Act
    List<MessageMatcher> actualCreateMessageMatchersResult =
        chatRequestChatHandlerMapping.createMessageMatchers(mapping, new ArrayList<>());

    // Assert
    verify(mapping).value();
    assertTrue(actualCreateMessageMatchersResult.isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Given {@code Content}.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName(
      "Test createMessageMatchers(ChatRequest, List); given 'org.finos.springbot.workflow.content.Content'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_givenOrgFinosSpringbotWorkflowContentContent() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"42"});

    ArrayList<WildcardContent> chatVariables = new ArrayList<>();
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;
    chatVariables.add(new WildcardContent(chatVariable, expected, Arity.ONE));

    // Act
    List<MessageMatcher> actualCreateMessageMatchersResult =
        chatRequestChatHandlerMapping.createMessageMatchers(mapping, chatVariables);

    // Assert
    verify(mapping).value();
    assertEquals(1, actualCreateMessageMatchersResult.size());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Given {@code Content}.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName(
      "Test createMessageMatchers(ChatRequest, List); given 'org.finos.springbot.workflow.content.Content'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_givenOrgFinosSpringbotWorkflowContentContent2() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"42"});

    ArrayList<WildcardContent> chatVariables = new ArrayList<>();
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;
    chatVariables.add(new WildcardContent(chatVariable, expected, Arity.ONE));
    ChatVariable chatVariable2 = mock(ChatVariable.class);
    Class<Content> expected2 = Content.class;
    chatVariables.add(new WildcardContent(chatVariable2, expected2, Arity.ONE));

    // Act
    List<MessageMatcher> actualCreateMessageMatchersResult =
        chatRequestChatHandlerMapping.createMessageMatchers(mapping, chatVariables);

    // Assert
    verify(mapping).value();
    assertEquals(1, actualCreateMessageMatchersResult.size());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName("Test createMessageMatchers(ChatRequest, List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_thenReturnSizeIsTwo() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"\\s", "{"});

    // Act
    List<MessageMatcher> actualCreateMessageMatchersResult =
        chatRequestChatHandlerMapping.createMessageMatchers(mapping, new ArrayList<>());

    // Assert
    verify(mapping).value();
    assertEquals(2, actualCreateMessageMatchersResult.size());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createMessageMatchers(ChatRequest,
   * List)}
   */
  @Test
  @DisplayName(
      "Test createMessageMatchers(ChatRequest, List); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChatRequestChatHandlerMapping.createMessageMatchers(ChatRequest, List)"})
  void testCreateMessageMatchers_thenThrowUnsupportedOperationException() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMessageMatchers(mapping, new ArrayList<>()));
    verify(mapping).value();
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}.
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}
   */
  @Test
  @DisplayName("Test createWildcardContent(ChatRequest, ChatHandlerMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChatRequestChatHandlerMapping.createWildcardContent(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateWildcardContent() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);

    MethodParameter methodParameter = mock(MethodParameter.class);
    when(methodParameter.getGenericParameterType()).thenReturn(new TypePlaceHolder(1));
    when(methodParameter.getParameterAnnotation(Mockito.<Class<ChatVariable>>any()))
        .thenReturn(mock(ChatVariable.class));

    ChatHandlerMethod method = mock(ChatHandlerMethod.class);
    when(method.getMethodParameters()).thenReturn(new MethodParameter[] {methodParameter});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createWildcardContent(mapping, method));
    verify(method).getMethodParameters();
    verify(methodParameter).getGenericParameterType();
    verify(methodParameter, atLeast(1)).getParameterAnnotation(isA(Class.class));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}.
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}
   */
  @Test
  @DisplayName("Test createWildcardContent(ChatRequest, ChatHandlerMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChatRequestChatHandlerMapping.createWildcardContent(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateWildcardContent2() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);

    MethodParameter methodParameter = mock(MethodParameter.class);
    when(methodParameter.getGenericParameterType()).thenThrow(new UnsupportedOperationException());
    when(methodParameter.getParameterAnnotation(Mockito.<Class<ChatVariable>>any()))
        .thenReturn(mock(ChatVariable.class));

    ChatHandlerMethod method = mock(ChatHandlerMethod.class);
    when(method.getMethodParameters()).thenReturn(new MethodParameter[] {methodParameter});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createWildcardContent(mapping, method));
    verify(method).getMethodParameters();
    verify(methodParameter).getGenericParameterType();
    verify(methodParameter, atLeast(1)).getParameterAnnotation(isA(Class.class));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}.
   *
   * <ul>
   *   <li>Given empty array of {@link MethodParameter}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#createWildcardContent(ChatRequest,
   * ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createWildcardContent(ChatRequest, ChatHandlerMethod); given empty array of MethodParameter; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChatRequestChatHandlerMapping.createWildcardContent(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateWildcardContent_givenEmptyArrayOfMethodParameter_thenReturnEmpty() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);

    ChatHandlerMethod method = mock(ChatHandlerMethod.class);
    when(method.getMethodParameters()).thenReturn(new MethodParameter[] {});

    // Act
    List<WildcardContent> actualCreateWildcardContentResult =
        chatRequestChatHandlerMapping.createWildcardContent(mapping, method);

    // Assert
    verify(method).getMethodParameters();
    assertTrue(actualCreateWildcardContentResult.isEmpty());
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}.
   *
   * <ul>
   *   <li>Then return {@link Content}.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  @DisplayName("Test getContentClassFromType(Type); then return Content")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ChatRequestChatHandlerMapping.getContentClassFromType(Type)"})
  void testGetContentClassFromType_thenReturnContent() {
    // Arrange
    Class<Content> t = Content.class;

    // Act
    Class<? extends Content> actualContentClassFromType =
        chatRequestChatHandlerMapping.getContentClassFromType(t);

    // Assert
    Class<Content> expectedContentClassFromType = Content.class;
    assertEquals(expectedContentClassFromType, actualContentClassFromType);
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  @DisplayName("Test getContentClassFromType(Type); when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ChatRequestChatHandlerMapping.getContentClassFromType(Type)"})
  void testGetContentClassFromType_whenJavaLangObject() {
    // Arrange
    Class<Object> t = Object.class;

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.getContentClassFromType(t));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}.
   *
   * <ul>
   *   <li>When {@link TypePlaceHolder#TypePlaceHolder(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link ChatRequestChatHandlerMapping#getContentClassFromType(Type)}
   */
  @Test
  @DisplayName("Test getContentClassFromType(Type); when TypePlaceHolder(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class ChatRequestChatHandlerMapping.getContentClassFromType(Type)"})
  void testGetContentClassFromType_whenTypePlaceHolderWithOrdinalIsOne() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.getContentClassFromType(new TypePlaceHolder(1)));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest,
   * ChatHandlerMethod)} with {@code ChatRequest}, {@code ChatHandlerMethod}.
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest, ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createMappingRegistration(ChatRequest, ChatHandlerMethod) with 'ChatRequest', 'ChatHandlerMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistration ChatRequestChatHandlerMapping.createMappingRegistration(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateMappingRegistrationWithChatRequestChatHandlerMethod() {
    // Arrange
    MethodParameter methodParameter = mock(MethodParameter.class);
    when(methodParameter.getGenericParameterType()).thenReturn(new TypePlaceHolder(1));
    when(methodParameter.getParameterAnnotation(Mockito.<Class<ChatVariable>>any()))
        .thenReturn(mock(ChatVariable.class));

    ChatHandlerMethod handlerMethod = mock(ChatHandlerMethod.class);
    when(handlerMethod.getMethodParameters()).thenReturn(new MethodParameter[] {methodParameter});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMappingRegistration(null, handlerMethod));
    verify(handlerMethod).getMethodParameters();
    verify(methodParameter).getGenericParameterType();
    verify(methodParameter, atLeast(1)).getParameterAnnotation(isA(Class.class));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest,
   * ChatHandlerMethod)} with {@code ChatRequest}, {@code ChatHandlerMethod}.
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest, ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createMappingRegistration(ChatRequest, ChatHandlerMethod) with 'ChatRequest', 'ChatHandlerMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistration ChatRequestChatHandlerMapping.createMappingRegistration(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateMappingRegistrationWithChatRequestChatHandlerMethod2() {
    // Arrange
    MethodParameter methodParameter = mock(MethodParameter.class);
    when(methodParameter.getGenericParameterType()).thenThrow(new UnsupportedOperationException());
    when(methodParameter.getParameterAnnotation(Mockito.<Class<ChatVariable>>any()))
        .thenReturn(mock(ChatVariable.class));

    ChatHandlerMethod handlerMethod = mock(ChatHandlerMethod.class);
    when(handlerMethod.getMethodParameters()).thenReturn(new MethodParameter[] {methodParameter});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMappingRegistration(null, handlerMethod));
    verify(handlerMethod).getMethodParameters();
    verify(methodParameter).getGenericParameterType();
    verify(methodParameter, atLeast(1)).getParameterAnnotation(isA(Class.class));
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest,
   * ChatHandlerMethod)} with {@code ChatRequest}, {@code ChatHandlerMethod}.
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest, ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createMappingRegistration(ChatRequest, ChatHandlerMethod) with 'ChatRequest', 'ChatHandlerMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistration ChatRequestChatHandlerMapping.createMappingRegistration(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateMappingRegistrationWithChatRequestChatHandlerMethod3() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"42"});

    ChatHandlerMethod handlerMethod = mock(ChatHandlerMethod.class);
    Mockito.<Class<?>>when(handlerMethod.getBeanType())
        .thenThrow(new UnsupportedOperationException());
    when(handlerMethod.getMethodParameters()).thenReturn(new MethodParameter[] {});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMappingRegistration(mapping, handlerMethod));
    verify(mapping).value();
    verify(handlerMethod).getBeanType();
    verify(handlerMethod).getMethodParameters();
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest,
   * ChatHandlerMethod)} with {@code ChatRequest}, {@code ChatHandlerMethod}.
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest, ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createMappingRegistration(ChatRequest, ChatHandlerMethod) with 'ChatRequest', 'ChatHandlerMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistration ChatRequestChatHandlerMapping.createMappingRegistration(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateMappingRegistrationWithChatRequestChatHandlerMethod4() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"Mapping must not be null"});

    ChatHandlerMethod handlerMethod = mock(ChatHandlerMethod.class);
    when(handlerMethod.getMethod()).thenThrow(new UnsupportedOperationException());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(handlerMethod.getBeanType()).thenReturn(forNameResult);
    when(handlerMethod.getMethodParameters()).thenReturn(new MethodParameter[] {});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMappingRegistration(mapping, handlerMethod));
    verify(mapping).value();
    verify(handlerMethod).getBeanType();
    verify(handlerMethod).getMethod();
    verify(handlerMethod).getMethodParameters();
  }

  /**
   * Test {@link ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest,
   * ChatHandlerMethod)} with {@code ChatRequest}, {@code ChatHandlerMethod}.
   *
   * <ul>
   *   <li>Then calls {@link ChatHandlerMethod#getMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ChatRequestChatHandlerMapping#createMappingRegistration(ChatRequest, ChatHandlerMethod)}
   */
  @Test
  @DisplayName(
      "Test createMappingRegistration(ChatRequest, ChatHandlerMethod) with 'ChatRequest', 'ChatHandlerMethod'; then calls getMethod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.java.mapping.AbstractSpringComponentHandlerMapping.MappingRegistration ChatRequestChatHandlerMapping.createMappingRegistration(ChatRequest, ChatHandlerMethod)"
  })
  void testCreateMappingRegistrationWithChatRequestChatHandlerMethod_thenCallsGetMethod() {
    // Arrange
    ChatRequest mapping = mock(ChatRequest.class);
    when(mapping.value()).thenReturn(new String[] {"42"});

    ChatHandlerMethod handlerMethod = mock(ChatHandlerMethod.class);
    when(handlerMethod.getMethod()).thenThrow(new UnsupportedOperationException());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(handlerMethod.getBeanType()).thenReturn(forNameResult);
    when(handlerMethod.getMethodParameters()).thenReturn(new MethodParameter[] {});

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> chatRequestChatHandlerMapping.createMappingRegistration(mapping, handlerMethod));
    verify(mapping).value();
    verify(handlerMethod).getBeanType();
    verify(handlerMethod).getMethod();
    verify(handlerMethod).getMethodParameters();
  }
}
