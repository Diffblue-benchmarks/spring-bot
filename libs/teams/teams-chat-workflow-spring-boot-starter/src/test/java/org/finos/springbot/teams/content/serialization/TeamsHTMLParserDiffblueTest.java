package org.finos.springbot.teams.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.bot.schema.Entity;
import com.microsoft.bot.schema.Mention;
import com.microsoft.bot.schema.RoleTypes;
import com.microsoft.bot.schema.teams.TeamsChannelAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.teams.content.TeamsAddressable;
import org.finos.springbot.teams.content.TeamsContent;
import org.finos.springbot.teams.content.TeamsUser;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser.MentionFrame;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamsHTMLParser.class})
@ExtendWith(SpringExtension.class)
class TeamsHTMLParserDiffblueTest {
  @Autowired private ApplicationContext applicationContext;

  @Autowired private TeamsHTMLParser teamsHTMLParser;

  /**
   * Test {@link TeamsHTMLParser#apply(String, ParseContext)} with {@code String}, {@code
   * ParseContext}.
   *
   * <p>Method under test: {@link TeamsHTMLParser#apply(String, ParseContext)}
   */
  @Test
  @DisplayName("Test apply(String, ParseContext) with 'String', 'ParseContext'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message TeamsHTMLParser.apply(String, ParseContext)"})
  void testApplyWithStringParseContext() {
    // Arrange
    TeamsAddressable within = mock(TeamsAddressable.class);
    ParseContext ctx = new ParseContext(within, new ArrayList<>());

    // Act
    Message actualApplyResult = teamsHTMLParser.apply("Not all who wander are lost", ctx);

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
   * Test MentionFrame {@link MentionFrame#getContents()}.
   *
   * <ul>
   *   <li>Given {@link TeamsChannelAccount} (default constructor) Id is {@code 42}.
   *   <li>Then return {@link TeamsUser}.
   * </ul>
   *
   * <p>Method under test: {@link MentionFrame#getContents()}
   */
  @Test
  @DisplayName(
      "Test MentionFrame getContents(); given TeamsChannelAccount (default constructor) Id is '42'; then return TeamsUser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsContent MentionFrame.getContents()"})
  void testMentionFrameGetContents_givenTeamsChannelAccountIdIs42_thenReturnTeamsUser()
      throws IllegalArgumentException {
    // Arrange
    TeamsChannelAccount withMentioned = new TeamsChannelAccount();
    withMentioned.setAadObjectId("42");
    withMentioned.setEmail("jane.doe@example.org");
    withMentioned.setGivenName("With Given Name");
    withMentioned.setId("42");
    withMentioned.setName("With Name");
    withMentioned.setRole(RoleTypes.USER);
    withMentioned.setSurname("Doe");
    withMentioned.setTenantId("42");
    withMentioned.setUserPrincipalName("With User Principal Name");
    withMentioned.setUserRole("With User Role");

    Mention mention = new Mention();
    mention.setMentioned(withMentioned);
    mention.setText("With Text");

    Entity e = new Entity();
    e.setAs(mention);
    e.setType("With Type");
    MentionFrame mentionFrame =
        new TeamsHTMLParser(mock(ApplicationContext.class))
        .new MentionFrame("Q Name", e, mock(TeamsAddressable.class));

    // Act
    TeamsContent actualContents = mentionFrame.getContents();
    String actualText = actualContents.getText();

    // Assert
    assertTrue(actualContents instanceof TeamsUser);
    assertEquals("42", ((TeamsUser) actualContents).getKey());
    assertEquals("@With Name", actualContents.getText());
    assertEquals("@With Name", actualText);
    assertEquals("With Name", ((TeamsUser) actualContents).getName());
    assertNull(((TeamsUser) actualContents).getAadObjectId());
  }

  /**
   * Test MentionFrame getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MentionFrame#MentionFrame(TeamsHTMLParser, String, Entity, TeamsAddressable)}
   *   <li>{@link MentionFrame#hasContent()}
   * </ul>
   */
  @Test
  @DisplayName("Test MentionFrame getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MentionFrame.<init>(TeamsHTMLParser, String, Entity, TeamsAddressable)",
    "boolean MentionFrame.hasContent()"
  })
  void testMentionFrameGettersAndSetters() throws IllegalArgumentException {
    // Arrange
    TeamsHTMLParser teamsHTMLParser = new TeamsHTMLParser(mock(ApplicationContext.class));

    Entity e = new Entity();
    e.setAs(new Entity());
    e.setType("With Type");

    // Act
    MentionFrame actualMentionFrame =
        teamsHTMLParser.new MentionFrame("Q Name", e, mock(TeamsAddressable.class));
    boolean actualHasContentResult = actualMentionFrame.hasContent();

    // Assert
    Entity entity = actualMentionFrame.e;
    assertEquals("With Type", entity.getType());
    assertTrue(entity.getProperties().isEmpty());
    assertTrue(actualHasContentResult);
  }

  /**
   * Test MentionFrame {@link MentionFrame#push(Content)} with {@code c}.
   *
   * <p>Method under test: {@link MentionFrame#push(Content)}
   */
  @Test
  @DisplayName("Test MentionFrame push(Content) with 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MentionFrame.push(Content)"})
  void testMentionFramePushWithC() throws IllegalArgumentException {
    // Arrange
    Entity e = new Entity();
    e.setAs(new Entity());
    e.setType("With Type");
    MentionFrame mentionFrame =
        new TeamsHTMLParser(mock(ApplicationContext.class))
        .new MentionFrame("Q Name", e, mock(TeamsAddressable.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> mentionFrame.push(mock(Content.class)));
  }
}
