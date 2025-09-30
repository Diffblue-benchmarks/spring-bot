package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.finos.springbot.tool.rssbot.feed.Feed;
import org.finos.springbot.tool.rssbot.feed.FeedList;
import org.finos.springbot.tool.rssbot.feed.Filter;
import org.finos.springbot.tool.rssbot.feed.Filter.Type;
import org.finos.springbot.tool.rssbot.load.FeedLoader;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TimedAlerter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TimedAlerterDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private AllHistory allHistory;

  @MockitoBean private ArticleSender articleSender;

  @MockitoBean private FeedListCache feedListCache;

  @MockitoBean private FeedLoader feedLoader;

  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private TimedAlerter timedAlerter;

  /**
   * Test {@link TimedAlerter#warmFeedListCache()}.
   *
   * <p>Method under test: {@link TimedAlerter#warmFeedListCache()}
   */
  @Test
  @DisplayName("Test warmFeedListCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.warmFeedListCache()"})
  void testWarmFeedListCache() {
    // Arrange
    when(allConversations.getAllAddressables()).thenReturn(new HashSet<>());

    // Act
    timedAlerter.warmFeedListCache();

    // Assert
    verify(allConversations).getAllAddressables();
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoader() {
    // Arrange
    when(feedListCache.getKnownFeeds()).thenReturn(new HashMap<>());

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoader2() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);

    HashMap<Addressable, FeedList> addressableFeedListMap = new HashMap<>();
    addressableFeedListMap.put(mock(Addressable.class), feedList);
    when(feedListCache.getKnownFeeds()).thenReturn(addressableFeedListMap);

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader createSyndFeed(Feed) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoaderCreateSyndFeedReturnNull() throws Exception {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    FeedList feedList2 = new FeedList();
    feedList2.setAdminOnly(false);
    feedList2.setFeeds(feeds);
    feedList2.setFilters(new ArrayList<>());
    feedList2.setPaused(false);
    feedList2.setUpdateIntervalMinutes(1);

    HashMap<Addressable, FeedList> addressableFeedListMap = new HashMap<>();
    addressableFeedListMap.put(mock(Addressable.class), feedList2);
    addressableFeedListMap.put(mock(Addressable.class), feedList);
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedListCache.nextReportTime(Mockito.<FeedList>any()))
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(feedListCache.getKnownFeeds()).thenReturn(addressableFeedListMap);
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(null);

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
    verify(feedListCache).nextReportTime(isA(FeedList.class));
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@link
   *       SyndFeedImpl#SyndFeedImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName(
      "Test checkForFeedRefreshes(); given FeedLoader createSyndFeed(Feed) return SyndFeedImpl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoaderCreateSyndFeedReturnSyndFeedImpl()
      throws Exception {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    FeedList feedList2 = new FeedList();
    feedList2.setAdminOnly(false);
    feedList2.setFeeds(feeds);
    feedList2.setFilters(new ArrayList<>());
    feedList2.setPaused(false);
    feedList2.setUpdateIntervalMinutes(1);

    HashMap<Addressable, FeedList> addressableFeedListMap = new HashMap<>();
    addressableFeedListMap.put(mock(Addressable.class), feedList2);
    addressableFeedListMap.put(mock(Addressable.class), feedList);
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedListCache.nextReportTime(Mockito.<FeedList>any()))
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(feedListCache.getKnownFeeds()).thenReturn(addressableFeedListMap);
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
    verify(feedListCache).nextReportTime(isA(FeedList.class));
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} throw {@link
   *       Exception#Exception()}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName(
      "Test checkForFeedRefreshes(); given FeedLoader createSyndFeed(Feed) throw Exception()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoaderCreateSyndFeedThrowException() throws Exception {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    FeedList feedList2 = new FeedList();
    feedList2.setAdminOnly(false);
    feedList2.setFeeds(feeds);
    feedList2.setFilters(new ArrayList<>());
    feedList2.setPaused(false);
    feedList2.setUpdateIntervalMinutes(1);

    HashMap<Addressable, FeedList> addressableFeedListMap = new HashMap<>();
    addressableFeedListMap.put(mock(Addressable.class), feedList2);
    addressableFeedListMap.put(mock(Addressable.class), feedList);
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedListCache.nextReportTime(Mockito.<FeedList>any()))
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(feedListCache.getKnownFeeds()).thenReturn(addressableFeedListMap);
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenThrow(new Exception());

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
    verify(feedListCache).nextReportTime(isA(FeedList.class));
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader}.
   *   <li>Then calls {@link FeedListCache#nextReportTime(FeedList)}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName(
      "Test checkForFeedRefreshes(); given FeedLoader; then calls nextReportTime(FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes_givenFeedLoader_thenCallsNextReportTime() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);

    FeedList feedList2 = new FeedList();
    feedList2.setAdminOnly(false);
    feedList2.setFeeds(new ArrayList<>());
    feedList2.setFilters(new ArrayList<>());
    feedList2.setPaused(false);
    feedList2.setUpdateIntervalMinutes(1);

    HashMap<Addressable, FeedList> addressableFeedListMap = new HashMap<>();
    addressableFeedListMap.put(mock(Addressable.class), feedList2);
    addressableFeedListMap.put(mock(Addressable.class), feedList);
    when(feedListCache.nextReportTime(Mockito.<FeedList>any()))
        .thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(feedListCache.getKnownFeeds()).thenReturn(addressableFeedListMap);

    // Act
    timedAlerter.checkForFeedRefreshes();

    // Assert
    verify(feedListCache).getKnownFeeds();
    verify(feedListCache).nextReportTime(isA(FeedList.class));
  }

  /**
   * Test {@link TimedAlerter#onAllStreams(Function)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Addressable}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); given HashSet() add Addressable; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.onAllStreams(Function)"})
  void testOnAllStreams_givenHashSetAddAddressable_thenReturnOne() {
    // Arrange
    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    Function<Addressable, Integer> action = mock(Function.class);
    when(action.apply(Mockito.<Addressable>any())).thenReturn(1);

    // Act
    int actualOnAllStreamsResult = timedAlerter.onAllStreams(action);

    // Assert
    verify(action).apply(isA(Addressable.class));
    verify(allConversations).getAllAddressables();
    assertEquals(1, actualOnAllStreamsResult);
  }

  /**
   * Test {@link TimedAlerter#onAllStreams(Function)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Addressable}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); given HashSet() add Addressable; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.onAllStreams(Function)"})
  void testOnAllStreams_givenHashSetAddAddressable_thenReturnTwo() {
    // Arrange
    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    Function<Addressable, Integer> action = mock(Function.class);
    when(action.apply(Mockito.<Addressable>any())).thenReturn(1);

    // Act
    int actualOnAllStreamsResult = timedAlerter.onAllStreams(action);

    // Assert
    verify(action, atLeast(1)).apply(Mockito.<Addressable>any());
    verify(allConversations).getAllAddressables();
    assertEquals(2, actualOnAllStreamsResult);
  }

  /**
   * Test {@link TimedAlerter#onAllStreams(Function)}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); when Function; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.onAllStreams(Function)"})
  void testOnAllStreams_whenFunction_thenReturnZero() {
    // Arrange
    when(allConversations.getAllAddressables()).thenReturn(new HashSet<>());

    // Act
    int actualOnAllStreamsResult = timedAlerter.onAllStreams(mock(Function.class));

    // Assert
    verify(allConversations).getAllAddressables();
    assertEquals(0, actualOnAllStreamsResult);
  }

  /**
   * Test {@link TimedAlerter#firstOfTheMonth()}.
   *
   * <p>Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth() {
    // Arrange
    when(allConversations.getAllAddressables()).thenReturn(new HashSet<>());

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(allConversations).getAllAddressables();
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#setNextReportTime(FeedList)} does
   *       nothing.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName(
      "Test allItems(Addressable, FeedList); given FeedListCache setNextReportTime(FeedList) does nothing; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_givenFeedListCacheSetNextReportTimeDoesNothing_thenReturnZero()
      throws Exception {
    // Arrange
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    Addressable a = mock(Addressable.class);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setUrl("https://example.org/example");
    feed.setProxy(null);

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    Filter filter = new Filter();
    filter.setUsage(Type.EXCLUDE);

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(filter);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    fl.setFeeds(feeds);
    fl.setFilters(filters);

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); given FeedListCache; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_givenFeedListCache_thenReturnZero() {
    // Arrange
    Addressable a = mock(Addressable.class);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    // Act and Assert
    assertEquals(0, timedAlerter.allItems(a, fl));
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@code null}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName(
      "Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) return 'null'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedReturnNull_thenCallsAccept() throws Exception {
    // Arrange
    doThrow(new RuntimeException()).when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(null);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setUrl("https://example.org/example");
    feed.setProxy(null);

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    Filter filter = new Filter();
    filter.setUsage(Type.INCLUDE);

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(filter);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    fl.setFeeds(feeds);
    fl.setFilters(filters);

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@link
   *       SyndFeedImpl#SyndFeedImpl()}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName(
      "Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) return SyndFeedImpl(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedReturnSyndFeedImpl_thenCallsAccept()
      throws Exception {
    // Arrange
    doThrow(new RuntimeException()).when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setUrl("https://example.org/example");
    feed.setProxy(null);

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    Filter filter = new Filter();
    filter.setUsage(Type.INCLUDE);

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(filter);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    fl.setFeeds(feeds);
    fl.setFilters(filters);

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} throw {@link
   *       Exception#Exception()}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName(
      "Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) throw Exception(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedThrowException_thenCallsAccept() throws Exception {
    // Arrange
    doThrow(new RuntimeException()).when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenThrow(new Exception());
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setUrl("https://example.org/example");
    feed.setProxy(null);

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    Filter filter = new Filter();
    filter.setUsage(Type.INCLUDE);

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(filter);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    fl.setFeeds(feeds);
    fl.setFilters(filters);

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TimedAlerter.allItems(Addressable, FeedList)"})
  void testAllItems_thenThrowRuntimeException() throws Exception {
    // Arrange
    doThrow(new RuntimeException()).when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    doThrow(new RuntimeException()).when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setUrl("https://example.org/example");
    feed.setProxy(null);

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    Filter filter = new Filter();
    filter.setUsage(Type.INCLUDE);

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(filter);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    fl.setFeeds(feeds);
    fl.setFilters(filters);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> timedAlerter.allItems(a, fl));
    verify(responseHandlers).accept(isA(Response.class));
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
  }
}
