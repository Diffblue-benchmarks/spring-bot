package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

class CheckingArticleSenderDiffblueTest {
  /**
   * Method under test:
   * {@link CheckingArticleSender#CheckingArticleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  void testNewCheckingArticleSender() throws BeansException {
    // Arrange
    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertNull((new CheckingArticleSender(null, h)).responseHandlers);
  }
}
