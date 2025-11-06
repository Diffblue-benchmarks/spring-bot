package org.finos.springbot.symphony.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.entityjson.EntityJson;
import org.finos.springbot.symphony.SymphonyException;
import org.finos.springbot.symphony.content.CashTag;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Tag;
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
   * Method under test: {@link MessageMLParser#apply(String)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML>"));
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML><messageML>"));
    assertThrows(SymphonyException.class,
        () -> messageMLParser.apply("http://apache.org/xml/features/disallow-doctype-decl<messageML>"));
    assertThrows(SymphonyException.class, () -> messageMLParser.apply("<messageML>", new EntityJson()));
  }

  /**
   * Method under test: {@link MessageMLParser#apply(String, EntityJson)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    Message actualApplyResult = messageMLParser.apply("Not all who wander are lost", new EntityJson());

    // Assert
    assertTrue(actualApplyResult instanceof Message.MessageImpl);
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
   * Method under test: {@link MessageMLParser.TagFrame#bufferWithoutPrefix()}
   */
  @Test
  void testTagFrameBufferWithoutPrefix() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#bufferWithoutPrefix()}
   */
  @Test
  void testTagFrameBufferWithoutPrefix2() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new HashTag("42"));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#bufferWithoutPrefix()}
   */
  @Test
  void testTagFrameBufferWithoutPrefix3() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act and Assert
    assertEquals("", tagFrame.bufferWithoutPrefix());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#getContents()}
   */
  @Test
  void testTagFrameGetContents() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#getContents()}
   */
  @Test
  void testTagFrameGetContents2() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new SymphonyUser(1L));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#getContents()}
   */
  @Test
  void testTagFrameGetContents3() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name",
        new SymphonyUser("Name", "42 Main St"));

    // Act and Assert
    assertSame(tagFrame.contents, tagFrame.getContents());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MessageMLParser.TagFrame#TagFrame(String, Tag)}
   *   <li>{@link MessageMLParser.TagFrame#hasContent()}
   * </ul>
   */
  @Test
  void testTagFrameGettersAndSetters() {
    // Arrange and Act
    MessageMLParser.TagFrame<Tag> actualTagFrame = new MessageMLParser.TagFrame<>("Q Name", new CashTag("42"));

    // Assert
    assertTrue(actualTagFrame.hasContent());
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#isEnding(String)}
   */
  @Test
  void testTagFrameIsEnding() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertTrue(tagFrame.isEnding("Q Name"));
  }

  /**
   * Method under test: {@link MessageMLParser.TagFrame#push(Content)}
   */
  @Test
  void testTagFramePush() {
    // Arrange
    MessageMLParser.TagFrame<Tag> tagFrame = new MessageMLParser.TagFrame<>("Q Name", new CashTag("42"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> tagFrame.push(new CashTag("42")));
  }
}
