package org.finos.springbot.tool.poll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

class PollBotDiffblueTest {
  /**
   * Method under test: {@link PollBot#taskScheduler()}
   */
  @Test
  void testTaskScheduler() {
    // Arrange, Act and Assert
    assertTrue((new PollBot()).taskScheduler() instanceof ConcurrentTaskScheduler);
  }
}
