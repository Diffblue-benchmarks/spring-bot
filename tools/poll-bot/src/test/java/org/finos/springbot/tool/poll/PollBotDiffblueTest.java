package org.finos.springbot.tool.poll;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

class PollBotDiffblueTest {
  /**
   * Test {@link PollBot#taskScheduler()}.
   * <p>
   * Method under test: {@link PollBot#taskScheduler()}
   */
  @Test
  @DisplayName("Test taskScheduler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.scheduling.TaskScheduler org.finos.springbot.tool.poll.PollBot.taskScheduler()"})
  void testTaskScheduler() {
    // Arrange, Act and Assert
    assertTrue((new PollBot()).taskScheduler() instanceof ConcurrentTaskScheduler);
  }
}
