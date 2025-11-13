package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.annotations.ChatVariable;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.java.mapping.WildcardContent.Arity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MessageMatcherDiffblueTest {
  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.required()).thenReturn(true);
    Class<Content> expected = Content.class;

    WildcardContent wildcardContent = new WildcardContent(chatVariable, expected, Arity.ONE);

    ArrayList<Content> c = new ArrayList<>();
    c.add(wildcardContent);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(chatVariable).required();
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertFalse(actualConsumeResult);
    assertTrue(out.isEmpty());
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume2() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.required()).thenReturn(true);
    Class<Content> expected = Content.class;

    WildcardContent wildcardContent = new WildcardContent(chatVariable, expected, Arity.OPTIONAL);

    ArrayList<Content> c = new ArrayList<>();
    c.add(wildcardContent);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(chatVariable).required();
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertEquals(1, out.size());
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given ArrayList() add Content; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenArrayListAddContent_thenReturnFalse() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;
    c.add(new WildcardContent(chatVariable, expected, Arity.LIST));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertFalse(actualConsumeResult);
    assertTrue(out.isEmpty());
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>When {@link Content}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given ArrayList() add 'null'; when Content; then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenArrayListAddNull_whenContent_thenHashMapEmpty() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(null);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));
    Content message = mock(Content.class);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    assertTrue(out.isEmpty());
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link ChatVariable} {@link ChatVariable#required()} return {@code false}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given ChatVariable required() return 'false'; then HashMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenChatVariableRequiredReturnFalse_thenHashMapSizeIsOne() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.required()).thenReturn(false);
    Class<Content> expected = Content.class;

    WildcardContent wildcardContent = new WildcardContent(chatVariable, expected, Arity.LIST);

    ArrayList<Content> c = new ArrayList<>();
    c.add(wildcardContent);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(chatVariable).required();
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertEquals(1, out.size());
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link ChatVariable} {@link ChatVariable#required()} return {@code false}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given ChatVariable required() return 'false'; then HashMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenChatVariableRequiredReturnFalse_thenHashMapSizeIsOne2() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.required()).thenReturn(false);
    Class<Content> expected = Content.class;

    WildcardContent wildcardContent = new WildcardContent(chatVariable, expected, Arity.ONE);

    ArrayList<Content> c = new ArrayList<>();
    c.add(wildcardContent);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(chatVariable).required();
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertEquals(1, out.size());
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link ChatVariable} {@link ChatVariable#required()} return {@code true}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given ChatVariable required() return 'true'; then HashMap() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenChatVariableRequiredReturnTrue_thenHashMapSizeIsOne() {
    // Arrange
    ChatVariable chatVariable = mock(ChatVariable.class);
    when(chatVariable.required()).thenReturn(true);
    Class<Content> expected = Content.class;

    WildcardContent wildcardContent = new WildcardContent(chatVariable, expected, Arity.LIST);

    ArrayList<Content> c = new ArrayList<>();
    c.add(wildcardContent);
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(chatVariable).required();
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertEquals(1, out.size());
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@link MessageMatcher#MessageMatcher(Content)} with pattern is {@link Content}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given MessageMatcher(Content) with pattern is Content; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenMessageMatcherWithPatternIsContent_thenReturnFalse() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(mock(Content.class));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(message).startsWith(isA(Content.class));
    assertFalse(actualConsumeResult);
    assertTrue(out.isEmpty());
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Content} {@link Content#startsWith(Content)} return {@code true}.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName(
      "Test consume(Content, Map); given 'true'; when Content startsWith(Content) return 'true'; then HashMap() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageMatcher.consume(Content, Map)"})
  void testConsume_givenTrue_whenContentStartsWithReturnTrue_thenHashMapEmpty() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    ChatVariable chatVariable = mock(ChatVariable.class);
    Class<Content> expected = Content.class;
    c.add(new WildcardContent(chatVariable, expected, Arity.LIST));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));

    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(true);
    HashMap<ChatVariable, Object> out = new HashMap<>();

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, out);

    // Assert
    verify(message).startsWith(isA(Content.class));
    assertTrue(out.isEmpty());
    assertTrue(actualConsumeResult);
  }
}
