package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.bot.schema.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamsHTMLParser.class})
@ExtendWith(SpringExtension.class)
class TeamsHTMLParserDiffblueTest {
  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private TeamsHTMLParser teamsHTMLParser;

  /**
   * Method under test: {@link TeamsHTMLParser#apply(String, ParseContext)}
   */
  @Test
  void testApply() {
    // Arrange
    TeamsChannel within = new TeamsChannel("42", "Name");

    // Act
    Message actualApplyResult = teamsHTMLParser.apply("Not all who wander are lost",
        new ParseContext(within, new ArrayList<>()));

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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsHTMLParser.MentionFrame#MentionFrame(TeamsHTMLParser, String, Entity, TeamsAddressable)}
   *   <li>{@link TeamsHTMLParser.MentionFrame#hasContent()}
   * </ul>
   */
  @Test
  void testMentionFrameGettersAndSetters() throws IllegalArgumentException {
    // Arrange
    TeamsHTMLParser teamsHTMLParser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());

    Entity e = new Entity();
    e.setAs(new Entity());
    e.setType("With Type");

    // Act
    TeamsHTMLParser.MentionFrame actualMentionFrame = teamsHTMLParser.new MentionFrame("Q Name", e,
        new TeamsChannel("42", "Name"));
    boolean actualHasContentResult = actualMentionFrame.hasContent();

    // Assert
    Entity entity = actualMentionFrame.e;
    assertEquals("With Type", entity.getType());
    assertTrue(entity.getProperties().isEmpty());
    assertTrue(actualHasContentResult);
  }

  /**
   * Method under test: {@link TeamsHTMLParser.MentionFrame#push(Content)}
   */
  @Test
  void testMentionFramePush() {
    // Arrange
    TeamsHTMLParser teamsHTMLParser = new TeamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    Entity e = new Entity();
    TeamsHTMLParser.MentionFrame mentionFrame = teamsHTMLParser.new MentionFrame("Q Name", e,
        new TeamsChannel("42", "Name"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mentionFrame.push(new TeamsChannel("42", "Name")));
  }
}
