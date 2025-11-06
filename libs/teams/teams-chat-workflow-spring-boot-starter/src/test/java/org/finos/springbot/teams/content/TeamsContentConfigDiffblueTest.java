package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

class TeamsContentConfigDiffblueTest {
  /**
   * Test {@link TeamsContentConfig#teamsHTMLWriter()}.
   * <p>
   * Method under test: {@link TeamsContentConfig#teamsHTMLWriter()}
   */
  @Test
  @DisplayName("Test teamsHTMLWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.teams.content.serialization.TeamsMarkupWriter TeamsContentConfig.teamsHTMLWriter()"})
  void testTeamsHTMLWriter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertEquals("", (new TeamsContentConfig()).teamsHTMLWriter().apply(null, null));
  }

  /**
   * Test {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}.
   * <p>
   * Method under test: {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}
   */
  @Test
  @DisplayName("Test teamsHTMLParser(ApplicationContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TeamsHTMLParser TeamsContentConfig.teamsHTMLParser(ApplicationContext)"})
  void testTeamsHTMLParser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TeamsContentConfig teamsContentConfig = new TeamsContentConfig();

    // Act
    TeamsHTMLParser actualTeamsHTMLParserResult = teamsContentConfig
        .teamsHTMLParser(new AnnotationConfigReactiveWebApplicationContext());
    TeamsAddressable within = mock(TeamsAddressable.class);
    Message actualApplyResult = actualTeamsHTMLParserResult.apply("Not all who wander are lost",
        new ParseContext(within, new ArrayList<>()));

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
}
