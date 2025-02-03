package org.finos.springbot.workflow.java.mapping;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.OrderedList;
import org.finos.springbot.workflow.content.OrderedList.OrderedListImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MessageMatcherDiffblueTest {
  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given ArrayList() add Content; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenArrayListAddContent_thenReturnFalse() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));
    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, new HashMap<>());

    // Assert
    verify(message, atLeast(1)).startsWith(Mockito.<Content>any());
    assertFalse(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.</li>
   *   <li>When {@link Content} {@link Content#startsWith(Content)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given ArrayList() add Content; when Content startsWith(Content) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenArrayListAddContent_whenContentStartsWithReturnTrue() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(c));
    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(true);

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, new HashMap<>());

    // Assert
    verify(message).startsWith(isA(Content.class));
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Message.MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given ArrayList() add MessageImpl(List) with c is ArrayList(); when Content")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenArrayListAddMessageImplWithCIsArrayList_whenContent() {
    // Arrange
    ArrayList<Paragraph> c = new ArrayList<>();
    c.add(new MessageImpl(new ArrayList<>()));
    MessageMatcher messageMatcher = new MessageMatcher(new OrderedListImpl(c));
    Content message = mock(Content.class);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Content}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given BlockQuoteImpl(List) with c is ArrayList(); when Content; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenBlockQuoteImplWithCIsArrayList_whenContent_thenReturnTrue() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(new BlockQuoteImpl(new ArrayList<>()));
    Content message = mock(Content.class);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link MessageMatcher#MessageMatcher(Content)} with pattern is {@link Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given MessageMatcher(Content) with pattern is Content")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenMessageMatcherWithPatternIsContent() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(mock(Content.class));
    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(true);

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, new HashMap<>());

    // Assert
    verify(message).startsWith(isA(Content.class));
    assertTrue(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link MessageMatcher#MessageMatcher(Content)} with pattern is {@link Content}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given MessageMatcher(Content) with pattern is Content; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenMessageMatcherWithPatternIsContent_thenReturnFalse() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(mock(Content.class));
    Content message = mock(Content.class);
    when(message.startsWith(Mockito.<Content>any())).thenReturn(false);

    // Act
    boolean actualConsumeResult = messageMatcher.consume(message, new HashMap<>());

    // Assert
    verify(message).startsWith(isA(Content.class));
    assertFalse(actualConsumeResult);
  }

  /**
   * Test {@link MessageMatcher#consume(Content, Map)}.
   * <ul>
   *   <li>Given {@link MessageMatcher#MessageMatcher(Content)} with pattern is {@code null}.</li>
   *   <li>When {@link Content}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMatcher#consume(Content, Map)}
   */
  @Test
  @DisplayName("Test consume(Content, Map); given MessageMatcher(Content) with pattern is 'null'; when Content; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.java.mapping.MessageMatcher.consume(org.finos.springbot.workflow.content.Content, java.util.Map)"})
  void testConsume_givenMessageMatcherWithPatternIsNull_whenContent_thenReturnTrue() {
    // Arrange
    MessageMatcher messageMatcher = new MessageMatcher(null);
    Content message = mock(Content.class);

    // Act and Assert
    assertTrue(messageMatcher.consume(message, new HashMap<>()));
  }
}
