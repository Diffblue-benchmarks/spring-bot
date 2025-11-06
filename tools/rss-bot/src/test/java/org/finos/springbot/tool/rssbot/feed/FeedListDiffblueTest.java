package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeedListDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FeedList}
   *   <li>{@link FeedList#setAdminOnly(boolean)}
   *   <li>{@link FeedList#setFeeds(List)}
   *   <li>{@link FeedList#setFilters(List)}
   *   <li>{@link FeedList#setPaused(boolean)}
   *   <li>{@link FeedList#setUpdateIntervalMinutes(Integer)}
   *   <li>{@link FeedList#getFeeds()}
   *   <li>{@link FeedList#getFilters()}
   *   <li>{@link FeedList#getUpdateIntervalMinutes()}
   *   <li>{@link FeedList#isAdminOnly()}
   *   <li>{@link FeedList#isPaused()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeedList.<init>()", "List FeedList.getFeeds()", "List FeedList.getFilters()",
      "Integer FeedList.getUpdateIntervalMinutes()", "boolean FeedList.isAdminOnly()", "boolean FeedList.isPaused()",
      "void FeedList.setAdminOnly(boolean)", "void FeedList.setFeeds(List)", "void FeedList.setFilters(List)",
      "void FeedList.setPaused(boolean)", "void FeedList.setUpdateIntervalMinutes(Integer)"})
  void testGettersAndSetters() {
    // Arrange and Act
    FeedList actualFeedList = new FeedList();
    actualFeedList.setAdminOnly(true);
    ArrayList<Feed> feeds = new ArrayList<>();
    actualFeedList.setFeeds(feeds);
    ArrayList<Filter> filters = new ArrayList<>();
    actualFeedList.setFilters(filters);
    actualFeedList.setPaused(true);
    actualFeedList.setUpdateIntervalMinutes(42);
    List<Feed> actualFeeds = actualFeedList.getFeeds();
    List<Filter> actualFilters = actualFeedList.getFilters();
    Integer actualUpdateIntervalMinutes = actualFeedList.getUpdateIntervalMinutes();
    boolean actualIsAdminOnlyResult = actualFeedList.isAdminOnly();
    boolean actualIsPausedResult = actualFeedList.isPaused();

    // Assert
    assertEquals(42, actualUpdateIntervalMinutes.intValue());
    assertTrue(actualFeeds.isEmpty());
    assertTrue(actualFilters.isEmpty());
    assertTrue(actualIsAdminOnlyResult);
    assertTrue(actualIsPausedResult);
    assertSame(feeds, actualFeeds);
    assertSame(filters, actualFilters);
  }
}
