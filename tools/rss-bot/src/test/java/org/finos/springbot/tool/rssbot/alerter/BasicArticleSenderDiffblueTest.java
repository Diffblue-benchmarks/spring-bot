package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;

class BasicArticleSenderDiffblueTest {
  /**
   * Method under test:
   * {@link BasicArticleSender#BasicArticleSender(ResponseHandlers)}
   */
  @Test
  void testNewBasicArticleSender() {
    // Arrange, Act and Assert
    assertNull((new BasicArticleSender(null)).responseHandlers);
  }
}
