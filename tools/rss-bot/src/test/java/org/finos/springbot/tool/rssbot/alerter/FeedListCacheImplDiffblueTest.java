package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.tool.rssbot.feed.FeedList;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {FeedListCacheImpl.class})
@ExtendWith(SpringExtension.class)
class FeedListCacheImplDiffblueTest {
  @Autowired
  private FeedListCacheImpl feedListCacheImpl;

  /**
   * Method under test: {@link FeedListCacheImpl#nextReportTime(FeedList)}
   */
  @Test
  void testNextReportTime() {
    // Arrange
    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    // Act and Assert
    assertNull(feedListCacheImpl.nextReportTime(fl));
  }

  /**
   * Method under test:
   * {@link FeedListCacheImpl#writeFeedList(Addressable, FeedList)}
   */
  @Test
  void testWriteFeedList() {
    // Arrange
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    // Act
    feedListCacheImpl.writeFeedList(a, fl);

    // Assert
    assertEquals(1, feedListCacheImpl.getKnownFeeds().size());
  }

  /**
   * Method under test: {@link FeedListCacheImpl#getKnownFeeds()}
   */
  @Test
  void testGetKnownFeeds() {
    // Arrange, Act and Assert
    assertTrue(feedListCacheImpl.getKnownFeeds().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link FeedListCacheImpl}
   */
  @Test
  void testNewFeedListCacheImpl() {
    // Arrange, Act and Assert
    assertTrue((new FeedListCacheImpl()).getKnownFeeds().isEmpty());
  }
}
