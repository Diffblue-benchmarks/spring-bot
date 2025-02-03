package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.finos.springbot.tool.rssbot.feed.Feed;
import org.finos.springbot.tool.rssbot.feed.FeedList;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TimedAlerter.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class TimedAlerterDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @MockBean
  private AllHistory allHistory;

  @MockBean
  private ArticleSender articleSender;

  @MockBean
  private FeedListCache feedListCache;

  @MockBean
  private FeedLoader feedLoader;

  @MockBean
  private ResponseHandlers responseHandlers;

  @Autowired
  private TimedAlerter timedAlerter;

  /**
   * Test {@link TimedAlerter#warmFeedListCache()}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#warmFeedListCache()}
   */
  @Test
  @DisplayName("Test warmFeedListCache(); given AllHistory getLastFromHistory(Class, Addressable) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.warmFeedListCache()"})
  void testWarmFeedListCache_givenAllHistoryGetLastFromHistoryReturnEmpty() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.warmFeedListCache();

    // Assert
    verify(allConversations).getAllAddressables();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link TimedAlerter#warmFeedListCache()}.
   * <ul>
   *   <li>Given {@link FeedListCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#warmFeedListCache()}
   */
  @Test
  @DisplayName("Test warmFeedListCache(); given FeedListCache")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.warmFeedListCache()"})
  void testWarmFeedListCache_givenFeedListCache() {
    // Arrange
    when(allConversations.getAllAddressables()).thenReturn(new HashSet<>());

    // Act
    timedAlerter.warmFeedListCache();

    // Assert
    verify(allConversations).getAllAddressables();
  }

  /**
   * Test {@link TimedAlerter#warmFeedListCache()}.
   * <ul>
   *   <li>Then calls {@link FeedListCache#writeFeedList(Addressable, FeedList)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#warmFeedListCache()}
   */
  @Test
  @DisplayName("Test warmFeedListCache(); then calls writeFeedList(Addressable, FeedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.warmFeedListCache()"})
  void testWarmFeedListCache_thenCallsWriteFeedList() {
    // Arrange
    doNothing().when(feedListCache).writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.warmFeedListCache();

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(allConversations).getAllAddressables();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link TimedAlerter#warmFeedListCache()}.
   * <ul>
   *   <li>Then calls {@link FeedListCache#writeFeedList(Addressable, FeedList)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#warmFeedListCache()}
   */
  @Test
  @DisplayName("Test warmFeedListCache(); then calls writeFeedList(Addressable, FeedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.warmFeedListCache()"})
  void testWarmFeedListCache_thenCallsWriteFeedList2() {
    // Arrange
    doNothing().when(feedListCache).writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.warmFeedListCache();

    // Assert
    verify(feedListCache, atLeast(1)).writeFeedList(Mockito.<Addressable>any(), isA(FeedList.class));
    verify(allConversations).getAllAddressables();
    verify(allHistory, atLeast(1)).getLastFromHistory(isA(Class.class), Mockito.<Addressable>any());
  }

  /**
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes() {
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
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes2() {
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
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
  void testCheckForFeedRefreshes3() {
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
   * Test {@link TimedAlerter#checkForFeedRefreshes()}.
   * <ul>
   *   <li>Given {@link FeedLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
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
   * <ul>
   *   <li>Given {@link FeedLoader}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
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
   * <ul>
   *   <li>Given {@link FeedLoader}.</li>
   *   <li>Then calls {@link FeedListCache#nextReportTime(FeedList)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#checkForFeedRefreshes()}
   */
  @Test
  @DisplayName("Test checkForFeedRefreshes(); given FeedLoader; then calls nextReportTime(FeedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.checkForFeedRefreshes()"})
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Addressable}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); given HashSet() add Addressable; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.onAllStreams(java.util.function.Function)"})
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Addressable}.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); given HashSet() add Addressable; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.onAllStreams(java.util.function.Function)"})
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
   * <ul>
   *   <li>When {@link Function}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#onAllStreams(Function)}
   */
  @Test
  @DisplayName("Test onAllStreams(Function); when Function; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.onAllStreams(java.util.function.Function)"})
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
   * <ul>
   *   <li>Given {@link AllHistory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth(); given AllHistory")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth_givenAllHistory() {
    // Arrange
    when(allConversations.getAllAddressables()).thenReturn(new HashSet<>());

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(allConversations).getAllAddressables();
  }

  /**
   * Test {@link TimedAlerter#firstOfTheMonth()}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth(); given AllHistory getLastFromHistory(Class, Addressable) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth_givenAllHistoryGetLastFromHistoryReturnEmpty() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(allConversations).getAllAddressables();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link TimedAlerter#firstOfTheMonth()}.
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.</li>
   *   <li>Then calls {@link AllHistory#getLastFromHistory(Class, Addressable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth(); given FeedList (default constructor) AdminOnly is 'true'; then calls getLastFromHistory(Class, Addressable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth_givenFeedListAdminOnlyIsTrue_thenCallsGetLastFromHistory() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(allConversations).getAllAddressables();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link TimedAlerter#firstOfTheMonth()}.
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth(); given FeedListCache writeFeedList(Addressable, FeedList) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth_givenFeedListCacheWriteFeedListDoesNothing_thenCallsAccept() {
    // Arrange
    doNothing().when(feedListCache).writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    FeedList feedList = mock(FeedList.class);
    when(feedList.isPaused()).thenReturn(false);
    doNothing().when(feedList).setPaused(anyBoolean());
    Optional<Object> ofResult = Optional.of(feedList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedList).isPaused();
    verify(feedList).setPaused(eq(true));
    verify(allConversations).getAllAddressables();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link TimedAlerter#firstOfTheMonth()}.
   * <ul>
   *   <li>Given {@link FeedList} {@link FeedList#isPaused()} return {@code true}.</li>
   *   <li>Then calls {@link FeedList#isPaused()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#firstOfTheMonth()}
   */
  @Test
  @DisplayName("Test firstOfTheMonth(); given FeedList isPaused() return 'true'; then calls isPaused()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.rssbot.alerter.TimedAlerter.firstOfTheMonth()"})
  void testFirstOfTheMonth_givenFeedListIsPausedReturnTrue_thenCallsIsPaused() {
    // Arrange
    FeedList feedList = mock(FeedList.class);
    when(feedList.isPaused()).thenReturn(true);
    Optional<Object> ofResult = Optional.of(feedList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any())).thenReturn(ofResult);

    HashSet<Addressable> addressableSet = new HashSet<>();
    addressableSet.add(mock(Addressable.class));
    addressableSet.add(mock(Addressable.class));
    when(allConversations.getAllAddressables()).thenReturn(addressableSet);

    // Act
    timedAlerter.firstOfTheMonth();

    // Assert
    verify(feedList, atLeast(1)).isPaused();
    verify(allConversations).getAllAddressables();
    verify(allHistory, atLeast(1)).getLastFromHistory(isA(Class.class), Mockito.<Addressable>any());
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   * <ul>
   *   <li>Given {@link FeedListCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); given FeedListCache")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.allItems(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.FeedList)"})
  void testAllItems_givenFeedListCache() {
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
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@code null}.</li>
   *   <li>Then calls {@link FeedListCache#setNextReportTime(FeedList)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) return 'null'; then calls setNextReportTime(FeedList)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.allItems(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedReturnNull_thenCallsSetNextReportTime() throws Exception {
    // Arrange
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(null);
    Addressable a = mock(Addressable.class);

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

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} return {@link SyndFeedImpl#SyndFeedImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) return SyndFeedImpl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.allItems(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedReturnSyndFeedImpl() throws Exception {
    // Arrange
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    Addressable a = mock(Addressable.class);

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

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }

  /**
   * Test {@link TimedAlerter#allItems(Addressable, FeedList)}.
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createSyndFeed(Feed)} throw {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimedAlerter#allItems(Addressable, FeedList)}
   */
  @Test
  @DisplayName("Test allItems(Addressable, FeedList); given FeedLoader createSyndFeed(Feed) throw Exception(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.TimedAlerter.allItems(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.FeedList)"})
  void testAllItems_givenFeedLoaderCreateSyndFeedThrowExceptionWithFoo() throws Exception {
    // Arrange
    doNothing().when(feedListCache).setNextReportTime(Mockito.<FeedList>any());
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenThrow(new Exception("foo"));
    Addressable a = mock(Addressable.class);

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

    // Act
    int actualAllItemsResult = timedAlerter.allItems(a, fl);

    // Assert
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    assertEquals(0, actualAllItemsResult);
  }
}
