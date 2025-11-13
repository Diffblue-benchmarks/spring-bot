package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.springbot.tool.rssbot.feed.FeedList;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedListCacheImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class FeedListCacheImplDiffblueTest {
  @Autowired private FeedListCacheImpl feedListCacheImpl;

  /**
   * Test {@link FeedListCacheImpl#nextReportTime(FeedList)}.
   *
   * <p>Method under test: {@link FeedListCacheImpl#nextReportTime(FeedList)}
   */
  @Test
  @DisplayName("Test nextReportTime(FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.time.Instant FeedListCacheImpl.nextReportTime(FeedList)"})
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
   * Test {@link FeedListCacheImpl#writeFeedList(Addressable, FeedList)}.
   *
   * <p>Method under test: {@link FeedListCacheImpl#writeFeedList(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test writeFeedList(Addressable, FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedListCacheImpl.writeFeedList(Addressable, FeedList)"})
  void testWriteFeedList() {
    // Arrange
    Addressable a = mock(Addressable.class);

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
   * Test {@link FeedListCacheImpl#getKnownFeeds()}.
   *
   * <p>Method under test: {@link FeedListCacheImpl#getKnownFeeds()}
   */
  @Test
  @DisplayName("Test getKnownFeeds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map FeedListCacheImpl.getKnownFeeds()"})
  void testGetKnownFeeds() {
    // Arrange, Act and Assert
    assertTrue(feedListCacheImpl.getKnownFeeds().isEmpty());
  }

  /**
   * Test new {@link FeedListCacheImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FeedListCacheImpl}
   */
  @Test
  @DisplayName("Test new FeedListCacheImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedListCacheImpl.<init>()"})
  void testNewFeedListCacheImpl() {
    // Arrange, Act and Assert
    assertTrue(new FeedListCacheImpl().getKnownFeeds().isEmpty());
  }
}
