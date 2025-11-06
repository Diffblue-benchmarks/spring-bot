package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.teams.content.serialization.ParseContext;
import org.finos.springbot.teams.content.serialization.TeamsHTMLParser;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

class TeamsContentConfigDiffblueTest {
  /**
   * Method under test: {@link TeamsContentConfig#teamsHTMLWriter()}
   */
  @Test
  void testTeamsHTMLWriter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new TeamsContentConfig()).teamsHTMLWriter().apply(null, null));
  }

  /**
   * Method under test:
   * {@link TeamsContentConfig#teamsHTMLParser(ApplicationContext)}
   */
  @Test
  void testTeamsHTMLParser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TeamsContentConfig teamsContentConfig = new TeamsContentConfig();
    AnnotationConfigReactiveWebApplicationContext ctx = new AnnotationConfigReactiveWebApplicationContext();

    // Act
    TeamsHTMLParser actualTeamsHTMLParserResult = teamsContentConfig.teamsHTMLParser(ctx);
    TeamsChannel within = new TeamsChannel("42", "Name");

    Message actualApplyResult = actualTeamsHTMLParserResult.apply("Not all who wander are lost",
        new ParseContext(within, new ArrayList<>()));

    // Assert
    assertTrue(actualApplyResult instanceof Message.MessageImpl);
    ConfigurableListableBeanFactory beanFactory = ctx.getBeanFactory();
    assertTrue(beanFactory instanceof DefaultListableBeanFactory);
    assertEquals("Not all who wander are lost", actualApplyResult.getText());
    List<Content> contents = actualApplyResult.getContents();
    assertEquals(6, contents.size());
    assertEquals(6, actualApplyResult.size());
    Iterator<Content> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertTrue(((DefaultListableBeanFactory) beanFactory).getBeanPostProcessors().isEmpty());
    assertTrue(ctx.getBeanFactoryPostProcessors().isEmpty());
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
