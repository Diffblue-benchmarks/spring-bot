package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.junit.jupiter.api.Test;

class ArticleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Article#Article()}
   *   <li>{@link Article#setArticleHashTag(HashTag)}
   *   <li>{@link Article#setAuthor(String)}
   *   <li>{@link Article#setFeedHashTag(HashTag)}
   *   <li>{@link Article#setFeedName(String)}
   *   <li>{@link Article#setFeedUrls(List)}
   *   <li>{@link Article#setPubDate(String)}
   *   <li>{@link Article#setTitle(String)}
   *   <li>{@link Article#setUri(String)}
   *   <li>{@link Article#getArticleHashTag()}
   *   <li>{@link Article#getAuthor()}
   *   <li>{@link Article#getFeedHashTag()}
   *   <li>{@link Article#getFeedName()}
   *   <li>{@link Article#getFeedUrls()}
   *   <li>{@link Article#getPubDate()}
   *   <li>{@link Article#getTitle()}
   *   <li>{@link Article#getUri()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Article actualArticle = new Article();
    HashTag articleHashTag = new HashTag("42");
    actualArticle.setArticleHashTag(articleHashTag);
    actualArticle.setAuthor("JaneDoe");
    HashTag feedHashTag = new HashTag("42");
    actualArticle.setFeedHashTag(feedHashTag);
    actualArticle.setFeedName("Feed Name");
    ArrayList<String> feedUrls = new ArrayList<>();
    actualArticle.setFeedUrls(feedUrls);
    actualArticle.setPubDate("2020-03-01");
    actualArticle.setTitle("Dr");
    actualArticle.setUri("Uri");
    HashTag actualArticleHashTag = actualArticle.getArticleHashTag();
    String actualAuthor = actualArticle.getAuthor();
    HashTag actualFeedHashTag = actualArticle.getFeedHashTag();
    String actualFeedName = actualArticle.getFeedName();
    List<String> actualFeedUrls = actualArticle.getFeedUrls();
    String actualPubDate = actualArticle.getPubDate();
    String actualTitle = actualArticle.getTitle();

    // Assert that nothing has changed
    assertEquals("2020-03-01", actualPubDate);
    assertEquals("Dr", actualTitle);
    assertEquals("Feed Name", actualFeedName);
    assertEquals("JaneDoe", actualAuthor);
    assertEquals("Uri", actualArticle.getUri());
    assertTrue(actualFeedUrls.isEmpty());
    assertSame(feedUrls, actualFeedUrls);
    assertSame(articleHashTag, actualArticleHashTag);
    assertSame(feedHashTag, actualFeedHashTag);
  }

  /**
   * Method under test:
   * {@link Article#Article(String, String, String, String, FeedList, HashTag, HashTag)}
   */
  @Test
  void testNewArticle() {
    // Arrange
    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag("42");
    HashTag articleHashTag = new HashTag("42");

    // Act
    Article actualArticle = new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, articleHashTag);

    // Assert
    assertEquals("Dr", actualArticle.getTitle());
    assertEquals("Feed Name", actualArticle.getFeedName());
    assertEquals("JaneDoe", actualArticle.getAuthor());
    assertEquals("Uri", actualArticle.getUri());
    assertNull(actualArticle.getPubDate());
    assertTrue(actualArticle.getFeedUrls().isEmpty());
    assertSame(articleHashTag, actualArticle.getArticleHashTag());
    assertSame(feedHashTag, actualArticle.getFeedHashTag());
  }

  /**
   * Method under test:
   * {@link Article#Article(String, String, String, String, FeedList, HashTag, HashTag)}
   */
  @Test
  void testNewArticle2() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(feeds);
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag("42");
    HashTag articleHashTag = new HashTag("42");

    // Act
    Article actualArticle = new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, articleHashTag);

    // Assert
    assertEquals("Dr", actualArticle.getTitle());
    assertEquals("Feed Name", actualArticle.getFeedName());
    assertEquals("JaneDoe", actualArticle.getAuthor());
    assertEquals("Uri", actualArticle.getUri());
    List<String> feedUrls = actualArticle.getFeedUrls();
    assertEquals(1, feedUrls.size());
    assertEquals("https://example.org/example", feedUrls.get(0));
    assertNull(actualArticle.getPubDate());
    assertSame(articleHashTag, actualArticle.getArticleHashTag());
    assertSame(feedHashTag, actualArticle.getFeedHashTag());
  }

  /**
   * Method under test:
   * {@link Article#Article(String, String, String, String, FeedList, HashTag, HashTag)}
   */
  @Test
  void testNewArticle3() {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    Feed feed2 = new Feed();
    feed2.setDescription("Description");
    feed2.setName("42");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl("Url");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed2);
    feeds.add(feed);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(feeds);
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag("42");
    HashTag articleHashTag = new HashTag("42");

    // Act
    Article actualArticle = new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, articleHashTag);

    // Assert
    assertEquals("Dr", actualArticle.getTitle());
    assertEquals("Feed Name", actualArticle.getFeedName());
    assertEquals("JaneDoe", actualArticle.getAuthor());
    assertEquals("Uri", actualArticle.getUri());
    List<String> feedUrls = actualArticle.getFeedUrls();
    assertEquals(2, feedUrls.size());
    assertEquals("Url", feedUrls.get(0));
    assertEquals("https://example.org/example", feedUrls.get(1));
    assertNull(actualArticle.getPubDate());
    assertSame(articleHashTag, actualArticle.getArticleHashTag());
    assertSame(feedHashTag, actualArticle.getFeedHashTag());
  }
}
