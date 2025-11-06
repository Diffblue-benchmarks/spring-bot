package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.tool.rssbot.feed.FeedList;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;

class TimedAlerterDiffblueTest {
  /**
   * Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  void testAllItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TimedAlerter timedAlerter = new TimedAlerter();
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    // Act and Assert
    assertEquals(0, timedAlerter.allItems(a, fl));
  }
}
