package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.tool.rssbot.feed.Article;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

class CachingCheckingArticleSenderDiffblueTest {
  /**
   * Method under test:
   * {@link CachingCheckingArticleSender#CachingCheckingArticleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  void testNewCachingCheckingArticleSender() throws BeansException {
    // Arrange
    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertTrue((new CachingCheckingArticleSender(null, h)).alreadySent.isEmpty());
  }

  /**
   * Method under test:
   * {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}
   */
  @Test
  void testRecordSent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCheckingArticleSender cachingCheckingArticleSender = new CachingCheckingArticleSender(null,
        new AllHistory());
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    // Act
    cachingCheckingArticleSender.recordSent(a, new Article());

    // Assert
    assertEquals(1, cachingCheckingArticleSender.alreadySent.size());
  }
}
