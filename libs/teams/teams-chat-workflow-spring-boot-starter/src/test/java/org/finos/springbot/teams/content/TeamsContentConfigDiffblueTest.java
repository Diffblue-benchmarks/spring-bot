package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.teams.content.serialization.ParseContext;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
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

@ContextConfiguration(classes = {TeamsContentConfig.class})
@ExtendWith(SpringExtension.class)
class TeamsContentConfigDiffblueTest {
  @Autowired private TeamsContentConfig teamsContentConfig;

  /**
   * Test {@link TeamsContentConfig#teamsHTMLWriter()}.
   *
   * <p>Method under test: {@link TeamsContentConfig#teamsHTMLWriter()}
   */
  @Test
  @DisplayName("Test teamsHTMLWriter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.teams.content.serialization.TeamsMarkupWriter TeamsContentConfig.teamsHTMLWriter()"
  })
  void testTeamsHTMLWriter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals("", new TeamsContentConfig().teamsHTMLWriter().apply(null, null));
  }

  /**
   * Test {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}.
   *
   * <p>Method under test: {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}
   */
  @Test
  @DisplayName("Test teamsHTMLParser(ApplicationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsHTMLParser TeamsContentConfig.teamsHTMLParser(ApplicationContext)"})
  void testTeamsHTMLParser() {
    // Arrange and Act
    TeamsHTMLParser actualTeamsHTMLParserResult =
        teamsContentConfig.teamsHTMLParser(mock(ApplicationContext.class));
    TeamsAddressable within = mock(TeamsAddressable.class);
    ParseContext ctx = new ParseContext(within, new ArrayList<>());
    Message actualApplyResult =
        actualTeamsHTMLParserResult.apply("Not all who wander are lost", ctx);

    // Assert
    assertTrue(teamsContentConfig instanceof TeamsContentConfig);
    assertTrue(actualApplyResult instanceof MessageImpl);
    assertEquals("Not all who wander are lost", actualApplyResult.getText());
    List<Content> contents = actualApplyResult.getContents();
    assertEquals(6, contents.size());
    assertEquals(6, actualApplyResult.size());
    Iterator<Content> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(ctx.entities.isEmpty());
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
   * Test {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link TeamsContentConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test teamsHTMLParser(ApplicationContext); given TeamsContentConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsHTMLParser TeamsContentConfig.teamsHTMLParser(ApplicationContext)"})
  void testTeamsHTMLParser_givenTeamsContentConfig() {
    // Arrange and Act
    TeamsHTMLParser actualTeamsHTMLParserResult =
        new TeamsContentConfig().teamsHTMLParser(mock(ApplicationContext.class));
    TeamsAddressable within = mock(TeamsAddressable.class);
    ParseContext ctx = new ParseContext(within, new ArrayList<>());
    Message actualApplyResult =
        actualTeamsHTMLParserResult.apply("Not all who wander are lost", ctx);

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
   * Test {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then {@link TeamsContentConfig} {@link TeamsContentConfig}.
   * </ul>
   *
   * <p>Method under test: {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test teamsHTMLParser(ApplicationContext); then TeamsContentConfig TeamsContentConfig")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TeamsHTMLParser TeamsContentConfig.teamsHTMLParser(ApplicationContext)"})
  void testTeamsHTMLParser_thenTeamsContentConfigTeamsContentConfig() {
    // Arrange and Act
    teamsContentConfig.teamsHTMLParser(mock(ApplicationContext.class));

    // Assert that nothing has changed
    assertTrue(teamsContentConfig instanceof TeamsContentConfig);
  }
}
