package org.finos.springbot.symphony.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.CashTag;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.symphony.content.serialization.MessageMLParser.TagFrame;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MessageMLParser.class})
@ExtendWith(SpringExtension.class)
class MessageMLParserDiffblueTest {
  @Autowired private MessageMLParser messageMLParser;

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code <messageML><messageML>}.
   *   <li>Then throw {@link SymphonyException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String) with 'source'; when '<messageML><messageML>'; then throw SymphonyException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageMLParser.apply(String)"})
  void testApplyWithSource_whenMessageMLMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML><messageML>"));
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code <messageML>}.
   *   <li>Then throw {@link SymphonyException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'source'; when '<messageML>'; then throw SymphonyException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageMLParser.apply(String)"})
  void testApplyWithSource_whenMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML>"));
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code Source<messageML>}.
   *   <li>Then throw {@link SymphonyException}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName(
      "Test apply(String) with 'source'; when 'Source<messageML>'; then throw SymphonyException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageMLParser.apply(String)"})
  void testApplyWithSource_whenSourceMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("Source<messageML>"));
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   *
   * <ul>
   *   <li>When {@code Source}.
   *   <li>Then return {@link Message.MessageImpl}.
   * </ul>
   *
   * <p>Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'source'; when 'Source'; then return MessageImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageMLParser.apply(String)"})
  void testApplyWithSource_whenSource_thenReturnMessageImpl() {
    // Arrange and Act
    Message actualApplyResult = messageMLParser.apply("Source");

    // Assert
    assertTrue(actualApplyResult instanceof MessageImpl);
    List<Content> contents = actualApplyResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("Source", actualApplyResult.getText());
    Iterator<Content> iteratorResult = actualApplyResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualApplyResult.size());
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   *
   * <ul>
   *   <li>Given {@link CashTag#CashTag(String)} with id is {@code 42}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName(
      "Test TagFrame bufferWithoutPrefix(); given CashTag(String) with id is '42'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenCashTagWithIdIs42_thenReturnEmptyString() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   *
   * <ul>
   *   <li>Given {@link HashTag#HashTag(String)} with id is {@code 42}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName(
      "Test TagFrame bufferWithoutPrefix(); given HashTag(String) with id is '42'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenHashTagWithIdIs42_thenReturnEmptyString() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new HashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   *
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.
   * </ul>
   *
   * <p>Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName("Test TagFrame bufferWithoutPrefix(); given SymphonyUser(long) with userId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenSymphonyUserWithUserIdIsOne() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   *
   * <p>Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName("Test TagFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.springbot.workflow.content.Tag TagFrame.getContents()"})
  void testTagFrameGetContents() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act
    org.finos.springbot.workflow.content.Tag actualContents = tagFrame.getContents();

    // Assert
    assertSame(tagFrame.contents, actualContents);
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   *
   * <p>Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName("Test TagFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.springbot.workflow.content.Tag TagFrame.getContents()"})
  void testTagFrameGetContents2() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new SymphonyUser("Name", "42 Main St"));

    // Act
    org.finos.springbot.workflow.content.Tag actualContents = tagFrame.getContents();

    // Assert
    assertSame(tagFrame.contents, actualContents);
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   *
   * <ul>
   *   <li>Then return {@link TagFrame#TagFrame(String, Tag)} with {@code Q Name} and contents is
   *       {@link CashTag#CashTag(String)} {@link TagFrame#contents}.
   * </ul>
   *
   * <p>Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName(
      "Test TagFrame getContents(); then return TagFrame(String, Tag) with 'Q Name' and contents is CashTag(String) contents")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.springbot.workflow.content.Tag TagFrame.getContents()"})
  void testTagFrameGetContents_thenReturnTagFrameWithQNameAndContentsIsCashTagContents() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new CashTag("42"));

    // Act
    org.finos.springbot.workflow.content.Tag actualContents = tagFrame.getContents();

    // Assert
    assertSame(tagFrame.contents, actualContents);
  }

  /**
   * Test TagFrame getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TagFrame#TagFrame(String, org.finos.springbot.workflow.content.Tag)}
   *   <li>{@link TagFrame#hasContent()}
   * </ul>
   */
  @Test
  @DisplayName("Test TagFrame getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TagFrame.<init>(String, org.finos.springbot.workflow.content.Tag)",
    "boolean TagFrame.hasContent()"
  })
  void testTagFrameGettersAndSetters() {
    // Arrange and Act
    TagFrame<org.finos.springbot.workflow.content.Tag> actualTagFrame =
        new TagFrame<>("Q Name", new CashTag("42"));

    // Assert
    assertTrue(actualTagFrame.hasContent());
  }

  /**
   * Test TagFrame {@link TagFrame#isEnding(String)}.
   *
   * <p>Method under test: {@link TagFrame#isEnding(String)}
   */
  @Test
  @DisplayName("Test TagFrame isEnding(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TagFrame.isEnding(String)"})
  void testTagFrameIsEnding() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertTrue(tagFrame.isEnding("Q Name"));
  }

  /**
   * Test TagFrame {@link TagFrame#push(Content)} with {@code c}.
   *
   * <p>Method under test: {@link TagFrame#push(Content)}
   */
  @Test
  @DisplayName("Test TagFrame push(Content) with 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TagFrame.push(Content)"})
  void testTagFramePushWithC() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame =
        new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> tagFrame.push(mock(Content.class)));
  }
}
