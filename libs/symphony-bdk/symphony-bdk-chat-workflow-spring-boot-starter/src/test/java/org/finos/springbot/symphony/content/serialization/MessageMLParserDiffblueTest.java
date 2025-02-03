package org.finos.springbot.symphony.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
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
  @Autowired
  private MessageMLParser messageMLParser;

  /**
   * Test {@link MessageMLParser#apply(String, EntityJson)} with {@code message}, {@code jsonObjects}.
   * <ul>
   *   <li>When {@code <messageML>}.</li>
   *   <li>Then throw {@link SymphonyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#apply(String, EntityJson)}
   */
  @Test
  @DisplayName("Test apply(String, EntityJson) with 'message', 'jsonObjects'; when '<messageML>'; then throw SymphonyException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Message org.finos.springbot.symphony.content.serialization.MessageMLParser.apply(java.lang.String, org.finos.springbot.entityjson.EntityJson)"})
  void testApplyWithMessageJsonObjects_whenMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML>", new EntityJson()));
  }

  /**
   * Test {@link MessageMLParser#apply(String, EntityJson)} with {@code message}, {@code jsonObjects}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return {@link Message.MessageImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#apply(String, EntityJson)}
   */
  @Test
  @DisplayName("Test apply(String, EntityJson) with 'message', 'jsonObjects'; when 'Not all who wander are lost'; then return MessageImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Message org.finos.springbot.symphony.content.serialization.MessageMLParser.apply(java.lang.String, org.finos.springbot.entityjson.EntityJson)"})
  void testApplyWithMessageJsonObjects_whenNotAllWhoWanderAreLost_thenReturnMessageImpl() {
    // Arrange and Act
    Message actualApplyResult = messageMLParser.apply("Not all who wander are lost", new EntityJson());

    // Assert
    assertTrue(actualApplyResult instanceof MessageImpl);
    assertEquals("Not all who wander are lost", actualApplyResult.getText());
    List<Content> contents = actualApplyResult.getContents();
    assertEquals(6, contents.size());
    assertEquals(6, actualApplyResult.size());
    Iterator<Content> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult.hasNext());
    Content expectedNextResult = contents.get(0);
    assertSame(expectedNextResult, iteratorResult.next());
    Content expectedNextResult2 = contents.get(1);
    assertSame(expectedNextResult2, iteratorResult.next());
    Content expectedNextResult3 = contents.get(2);
    assertSame(expectedNextResult3, iteratorResult.next());
    Content expectedNextResult4 = contents.get(3);
    assertSame(expectedNextResult4, iteratorResult.next());
    Content expectedNextResult5 = contents.get(4);
    assertSame(expectedNextResult5, iteratorResult.next());
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   * <ul>
   *   <li>When {@code http://apache.org/xml/features/disallow-doctype-decl<messageML>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'source'; when 'http://apache.org/xml/features/disallow-doctype-decl<messageML>'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Message org.finos.springbot.symphony.content.serialization.MessageMLParser.apply(java.lang.String)"})
  void testApplyWithSource_whenHttpApacheOrgXmlFeaturesDisallowDoctypeDeclMessageML() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class,
        () -> messageMLParser.apply("http://apache.org/xml/features/disallow-doctype-decl<messageML>"));
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   * <ul>
   *   <li>When {@code <messageML><messageML>}.</li>
   *   <li>Then throw {@link SymphonyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'source'; when '<messageML><messageML>'; then throw SymphonyException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Message org.finos.springbot.symphony.content.serialization.MessageMLParser.apply(java.lang.String)"})
  void testApplyWithSource_whenMessageMLMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML><messageML>"));
  }

  /**
   * Test {@link MessageMLParser#apply(String)} with {@code source}.
   * <ul>
   *   <li>When {@code <messageML>}.</li>
   *   <li>Then throw {@link SymphonyException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String) with 'source'; when '<messageML>'; then throw SymphonyException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Message org.finos.springbot.symphony.content.serialization.MessageMLParser.apply(java.lang.String)"})
  void testApplyWithSource_whenMessageML_thenThrowSymphonyException() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML>"));
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   * <ul>
   *   <li>Given {@link CashTag#CashTag(String)} with id is {@code 42}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName("Test TagFrame bufferWithoutPrefix(); given CashTag(String) with id is '42'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenCashTagWithIdIs42_thenReturnEmptyString() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   * <ul>
   *   <li>Given {@link HashTag#HashTag(String)} with id is {@code 42}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName("Test TagFrame bufferWithoutPrefix(); given HashTag(String) with id is '42'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenHashTagWithIdIs42_thenReturnEmptyString() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new HashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#bufferWithoutPrefix()}.
   * <ul>
   *   <li>Given {@link SymphonyUser#SymphonyUser(long)} with userId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagFrame#bufferWithoutPrefix()}
   */
  @Test
  @DisplayName("Test TagFrame bufferWithoutPrefix(); given SymphonyUser(long) with userId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.bufferWithoutPrefix()"})
  void testTagFrameBufferWithoutPrefix_givenSymphonyUserWithUserIdIsOne() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   * <p>
   * Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName("Test TagFrame getContents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Tag org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.getContents()"})
  void testTagFrameGetContents() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   * <p>
   * Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName("Test TagFrame getContents()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Tag org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.getContents()"})
  void testTagFrameGetContents2() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name",
        new SymphonyUser("Name", "42 Main St"));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Test TagFrame {@link TagFrame#getContents()}.
   * <ul>
   *   <li>Then return {@link TagFrame#TagFrame(String, Tag)} with {@code Q Name} and contents is {@link CashTag#CashTag(String)} {@link TagFrame#contents}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TagFrame#getContents()}
   */
  @Test
  @DisplayName("Test TagFrame getContents(); then return TagFrame(String, Tag) with 'Q Name' and contents is CashTag(String) contents")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Tag org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.getContents()"})
  void testTagFrameGetContents_thenReturnTagFrameWithQNameAndContentsIsCashTagContents() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Test TagFrame getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TagFrame#TagFrame(String, org.finos.springbot.workflow.content.Tag)}
   *   <li>{@link TagFrame#hasContent()}
   * </ul>
   */
  @Test
  @DisplayName("Test TagFrame getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.<init>(java.lang.String, org.finos.springbot.workflow.content.Tag)",
      "boolean org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.hasContent()"})
  void testTagFrameGettersAndSetters() {
    // Arrange and Act
    TagFrame<org.finos.springbot.workflow.content.Tag> actualTagFrame = new TagFrame<>("Q Name", new CashTag("42"));

    // Assert
    assertTrue(actualTagFrame.hasContent());
  }

  /**
   * Test TagFrame {@link TagFrame#isEnding(String)}.
   * <p>
   * Method under test: {@link TagFrame#isEnding(String)}
   */
  @Test
  @DisplayName("Test TagFrame isEnding(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.isEnding(java.lang.String)"})
  void testTagFrameIsEnding() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertTrue(tagFrame.isEnding("Q Name"));
  }

  /**
   * Test TagFrame {@link TagFrame#push(Content)} with {@code c}.
   * <p>
   * Method under test: {@link TagFrame#push(Content)}
   */
  @Test
  @DisplayName("Test TagFrame push(Content) with 'c'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.symphony.content.serialization.MessageMLParser$TagFrame.push(org.finos.springbot.workflow.content.Content)"})
  void testTagFramePushWithC() {
    // Arrange
    TagFrame<org.finos.springbot.workflow.content.Tag> tagFrame = new TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> tagFrame.push(mock(Content.class)));
  }
}
