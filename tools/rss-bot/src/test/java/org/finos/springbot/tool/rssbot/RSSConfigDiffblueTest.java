package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.tool.rssbot.alerter.FeedListCache;
import org.finos.springbot.tool.rssbot.alerter.FeedListCacheImpl;
import org.junit.jupiter.api.Test;

class RSSConfigDiffblueTest {
  /**
   * Method under test: {@link RSSConfig#feedListCache()}
   */
  @Test
  void testFeedListCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FeedListCache actualFeedListCacheResult = (new RSSConfig()).feedListCache();

    // Assert
    assertTrue(actualFeedListCacheResult instanceof FeedListCacheImpl);
    assertTrue(actualFeedListCacheResult.getKnownFeeds().isEmpty());
  }
}
