package org.finos.springbot.tool.rssbot.feed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.symphony.history.SymphonyHistory;
import org.finos.springbot.tool.rssbot.ProxyProperties;
import org.finos.springbot.tool.rssbot.alerter.ArticleSender;
import org.finos.springbot.tool.rssbot.alerter.FeedListCache;
import org.finos.springbot.tool.rssbot.alerter.TimedAlerter;
import org.finos.springbot.tool.rssbot.feed.Filter.Type;
import org.finos.springbot.tool.rssbot.load.FeedLoader;
import org.finos.springbot.tool.rssbot.notify.Notifier;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedController.class, TimedAlerter.class, AllHistory.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FeedControllerDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private ArticleSender articleSender;

  @Autowired private FeedController feedController;

  @MockitoBean private FeedListCache feedListCache;

  @MockitoBean private FeedLoader feedLoader;

  @MockitoBean private Notifier notifier;

  @MockitoBean private ResponseHandlers responseHandlers;

  @MockitoBean private SymphonyHistory symphonyHistory;

  @Autowired private TimedAlerter timedAlerter;

  /**
   * Test {@link FeedController#getFeedList(SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#getFeedList(SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test getFeedList(SymphonyAddressable); given FeedList (default constructor) AdminOnly is 'true'; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.getFeedList(SymphonyAddressable)"})
  void testGetFeedList_givenFeedListAdminOnlyIsTrue_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);

    // Act
    FeedList actualFeedList = feedController.getFeedList(mock(SymphonyAddressable.class));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualFeedList);
  }

  /**
   * Test {@link FeedController#getFeedList(SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#getFeedList(SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test getFeedList(SymphonyAddressable); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.getFeedList(SymphonyAddressable)"})
  void testGetFeedList_thenThrowRuntimeException() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> feedController.getFeedList(mock(SymphonyAddressable.class)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#newSubscribeRequest()}.
   *
   * <p>Method under test: {@link FeedController#newSubscribeRequest()}
   */
  @Test
  @DisplayName("Test newSubscribeRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SubscribeRequest FeedController.newSubscribeRequest()"})
  void testNewSubscribeRequest() {
    // Arrange and Act
    SubscribeRequest actualNewSubscribeRequestResult = feedController.newSubscribeRequest();

    // Assert
    assertNull(actualNewSubscribeRequestResult.getName());
    assertNull(actualNewSubscribeRequestResult.getUrl());
  }

  /**
   * Test {@link FeedController#subscribe(SubscribeRequest, Addressable, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       does nothing.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#subscribe(SubscribeRequest, Addressable, User,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test subscribe(SubscribeRequest, Addressable, User, Optional); given FeedListCache writeFeedList(Addressable, FeedList) does nothing; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FeedList FeedController.subscribe(SubscribeRequest, Addressable, User, Optional)"
  })
  void testSubscribe_givenFeedListCacheWriteFeedListDoesNothing_thenReturnFeedList()
      throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");
    when(feedLoader.createFeed(Mockito.<String>any(), Mockito.<String>any())).thenReturn(feed);
    doNothing()
        .when(notifier)
        .sendSuccessNotification(
            Mockito.<SubscribeRequest>any(), Mockito.<Addressable>any(), Mockito.<User>any());
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    SymphonyUser author = new SymphonyUser(1L);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<FeedList> ofl = Optional.of(feedList);

    // Act
    FeedList actualSubscribeResult = feedController.subscribe(sr, a, author, ofl);

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedLoader).createFeed(eq("https://example.org/example"), eq("Name"));
    verify(notifier)
        .sendSuccessNotification(
            isA(SubscribeRequest.class), isA(Addressable.class), isA(User.class));
    assertSame(feedList, actualSubscribeResult);
  }

  /**
   * Test {@link FeedController#subscribe(SubscribeRequest, Addressable, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#subscribe(SubscribeRequest, Addressable, User,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test subscribe(SubscribeRequest, Addressable, User, Optional); given FeedListCache writeFeedList(Addressable, FeedList) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FeedList FeedController.subscribe(SubscribeRequest, Addressable, User, Optional)"
  })
  void testSubscribe_givenFeedListCacheWriteFeedListThrowRuntimeExceptionWithFoo()
      throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");
    when(feedLoader.createFeed(Mockito.<String>any(), Mockito.<String>any())).thenReturn(feed);
    doNothing()
        .when(notifier)
        .sendSuccessNotification(
            Mockito.<SubscribeRequest>any(), Mockito.<Addressable>any(), Mockito.<User>any());
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    SymphonyUser author = new SymphonyUser(1L);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<FeedList> ofl = Optional.of(feedList);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.subscribe(sr, a, author, ofl));
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedLoader).createFeed(eq("https://example.org/example"), eq("Name"));
    verify(notifier)
        .sendSuccessNotification(
            isA(SubscribeRequest.class), isA(Addressable.class), isA(User.class));
  }

  /**
   * Test {@link FeedController#subscribe(SubscribeRequest, Addressable, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link FeedLoader} {@link FeedLoader#createFeed(String, String)} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#subscribe(SubscribeRequest, Addressable, User,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test subscribe(SubscribeRequest, Addressable, User, Optional); given FeedLoader createFeed(String, String) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FeedList FeedController.subscribe(SubscribeRequest, Addressable, User, Optional)"
  })
  void testSubscribe_givenFeedLoaderCreateFeedThrowRuntimeExceptionWithFoo() throws Exception {
    // Arrange
    when(feedLoader.createFeed(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    SymphonyUser author = new SymphonyUser(1L);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<FeedList> ofl = Optional.of(feedList);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.subscribe(sr, a, author, ofl));
    verify(feedLoader).createFeed(eq("https://example.org/example"), eq("Name"));
  }

  /**
   * Test {@link FeedController#subscribe(SubscribeRequest, Addressable, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Notifier} {@link Notifier#sendSuccessNotification(SubscribeRequest,
   *       Addressable, User)} throw {@link RuntimeException#RuntimeException(String)} with {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#subscribe(SubscribeRequest, Addressable, User,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test subscribe(SubscribeRequest, Addressable, User, Optional); given Notifier sendSuccessNotification(SubscribeRequest, Addressable, User) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FeedList FeedController.subscribe(SubscribeRequest, Addressable, User, Optional)"
  })
  void testSubscribe_givenNotifierSendSuccessNotificationThrowRuntimeExceptionWithFoo()
      throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");
    when(feedLoader.createFeed(Mockito.<String>any(), Mockito.<String>any())).thenReturn(feed);
    doThrow(new RuntimeException("foo"))
        .when(notifier)
        .sendSuccessNotification(
            Mockito.<SubscribeRequest>any(), Mockito.<Addressable>any(), Mockito.<User>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    SymphonyUser author = new SymphonyUser(1L);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<FeedList> ofl = Optional.of(feedList);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.subscribe(sr, a, author, ofl));
    verify(feedLoader).createFeed(eq("https://example.org/example"), eq("Name"));
    verify(notifier)
        .sendSuccessNotification(
            isA(SubscribeRequest.class), isA(Addressable.class), isA(User.class));
  }

  /**
   * Test {@link FeedController#subscribe(SubscribeRequest, Addressable, User, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return Feeds size is one.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#subscribe(SubscribeRequest, Addressable, User,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test subscribe(SubscribeRequest, Addressable, User, Optional); when empty; then return Feeds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FeedList FeedController.subscribe(SubscribeRequest, Addressable, User, Optional)"
  })
  void testSubscribe_whenEmpty_thenReturnFeedsSizeIsOne() throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("Name");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");
    when(feedLoader.createFeed(Mockito.<String>any(), Mockito.<String>any())).thenReturn(feed);
    doNothing()
        .when(notifier)
        .sendSuccessNotification(
            Mockito.<SubscribeRequest>any(), Mockito.<Addressable>any(), Mockito.<User>any());
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    SymphonyUser author = new SymphonyUser(1L);
    Optional<FeedList> ofl = Optional.empty();

    // Act
    FeedList actualSubscribeResult = feedController.subscribe(sr, a, author, ofl);

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedLoader).createFeed(eq("https://example.org/example"), eq("Name"));
    verify(notifier)
        .sendSuccessNotification(
            isA(SubscribeRequest.class), isA(Addressable.class), isA(User.class));
    List<Feed> feeds = actualSubscribeResult.getFeeds();
    assertEquals(1, feeds.size());
    assertEquals(60, actualSubscribeResult.getUpdateIntervalMinutes().intValue());
    assertFalse(actualSubscribeResult.isAdminOnly());
    assertFalse(actualSubscribeResult.isPaused());
    assertTrue(actualSubscribeResult.getFilters().isEmpty());
    assertSame(feed, feeds.get(0));
  }

  /**
   * Test {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test pause(FeedListCache, SymphonyAddressable, User); given FeedList (default constructor) AdminOnly is 'true'; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.pause(FeedListCache, SymphonyAddressable, User)"})
  void testPause_givenFeedListAdminOnlyIsTrue_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualPauseResult = feedController.pause(feedListCache, a, new SymphonyUser(1L));

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualPauseResult);
  }

  /**
   * Test {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test pause(FeedListCache, SymphonyAddressable, User); given FeedListCache writeFeedList(Addressable, FeedList) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.pause(FeedListCache, SymphonyAddressable, User)"})
  void testPause_givenFeedListCacheWriteFeedListThrowRuntimeExceptionWithFoo() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> feedController.pause(feedListCache, a, new SymphonyUser(1L)));
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} {@link FeedList#setAdminOnly(boolean)} does nothing.
   *   <li>Then calls {@link FeedList#setAdminOnly(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test pause(FeedListCache, SymphonyAddressable, User); given FeedList setAdminOnly(boolean) does nothing; then calls setAdminOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.pause(FeedListCache, SymphonyAddressable, User)"})
  void testPause_givenFeedListSetAdminOnlyDoesNothing_thenCallsSetAdminOnly() {
    // Arrange
    FeedList feedList = mock(FeedList.class);
    doNothing().when(feedList).setAdminOnly(anyBoolean());
    doNothing().when(feedList).setFeeds(Mockito.<List<Feed>>any());
    doNothing().when(feedList).setFilters(Mockito.<List<Filter>>any());
    doNothing().when(feedList).setPaused(anyBoolean());
    doNothing().when(feedList).setUpdateIntervalMinutes(Mockito.<Integer>any());
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    feedController.pause(feedListCache, a, new SymphonyUser(1L));

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedList).setAdminOnly(eq(true));
    verify(feedList).setFeeds(isA(List.class));
    verify(feedList).setFilters(isA(List.class));
    verify(feedList).setPaused(eq(true));
    verify(feedList).setUpdateIntervalMinutes(eq(42));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistory} {@link SymphonyHistory#getLastFromHistory(Class,
   *       Addressable)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#pause(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test pause(FeedListCache, SymphonyAddressable, User); given SymphonyHistory getLastFromHistory(Class, Addressable) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.pause(FeedListCache, SymphonyAddressable, User)"})
  void testPause_givenSymphonyHistoryGetLastFromHistoryThrowRuntimeExceptionWithFoo() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> feedController.pause(feedListCache, a, new SymphonyUser(1L)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test resume(FeedListCache, SymphonyAddressable, User); given FeedList (default constructor) AdminOnly is 'true'; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.resume(FeedListCache, SymphonyAddressable, User)"})
  void testResume_givenFeedListAdminOnlyIsTrue_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualResumeResult = feedController.resume(feedListCache, a, new SymphonyUser(1L));

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualResumeResult);
  }

  /**
   * Test {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test resume(FeedListCache, SymphonyAddressable, User); given FeedListCache writeFeedList(Addressable, FeedList) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.resume(FeedListCache, SymphonyAddressable, User)"})
  void testResume_givenFeedListCacheWriteFeedListThrowRuntimeExceptionWithFoo() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> feedController.resume(feedListCache, a, new SymphonyUser(1L)));
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} {@link FeedList#setAdminOnly(boolean)} does nothing.
   *   <li>Then calls {@link FeedList#setAdminOnly(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test resume(FeedListCache, SymphonyAddressable, User); given FeedList setAdminOnly(boolean) does nothing; then calls setAdminOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.resume(FeedListCache, SymphonyAddressable, User)"})
  void testResume_givenFeedListSetAdminOnlyDoesNothing_thenCallsSetAdminOnly() {
    // Arrange
    FeedList feedList = mock(FeedList.class);
    doNothing().when(feedList).setAdminOnly(anyBoolean());
    doNothing().when(feedList).setFeeds(Mockito.<List<Feed>>any());
    doNothing().when(feedList).setFilters(Mockito.<List<Filter>>any());
    doNothing().when(feedList).setPaused(anyBoolean());
    doNothing().when(feedList).setUpdateIntervalMinutes(Mockito.<Integer>any());
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    feedController.resume(feedListCache, a, new SymphonyUser(1L));

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedList).setAdminOnly(eq(true));
    verify(feedList).setFeeds(isA(List.class));
    verify(feedList).setFilters(isA(List.class));
    verify(feedList).setPaused(eq(true));
    verify(feedList).setUpdateIntervalMinutes(eq(42));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistory} {@link SymphonyHistory#getLastFromHistory(Class,
   *       Addressable)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#resume(FeedListCache, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test resume(FeedListCache, SymphonyAddressable, User); given SymphonyHistory getLastFromHistory(Class, Addressable) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.resume(FeedListCache, SymphonyAddressable, User)"})
  void testResume_givenSymphonyHistoryGetLastFromHistoryThrowRuntimeExceptionWithFoo() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> feedController.resume(feedListCache, a, new SymphonyUser(1L)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#latest(TimedAlerter, AllHistory, SymphonyAddressable)}.
   *
   * <p>Method under test: {@link FeedController#latest(TimedAlerter, AllHistory,
   * SymphonyAddressable)}
   */
  @Test
  @DisplayName("Test latest(TimedAlerter, AllHistory, SymphonyAddressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedController.latest(TimedAlerter, AllHistory, SymphonyAddressable)"})
  void testLatest() throws BeansException {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("No New News Items"));

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> feedController.latest(timedAlerter, hist, mock(SymphonyAddressable.class)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#latest(TimedAlerter, AllHistory, SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Given {@link Feed} (default constructor) Description is {@code AllItems failed:}.
   *   <li>Then calls {@link FeedListCache#setNextReportTime(FeedList)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#latest(TimedAlerter, AllHistory,
   * SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test latest(TimedAlerter, AllHistory, SymphonyAddressable); given Feed (default constructor) Description is 'AllItems failed:'; then calls setNextReportTime(FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedController.latest(TimedAlerter, AllHistory, SymphonyAddressable)"})
  void testLatest_givenFeedDescriptionIsAllItemsFailed_thenCallsSetNextReportTime()
      throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("No New News Items");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    Feed feed2 = new Feed();
    feed2.setDescription("AllItems failed: ");
    feed2.setName("error");
    feed2.setProxy(new ProxyProperties());
    feed2.setUrl("AllItems failed: ");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed2);
    feeds.add(feed);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(feeds);
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .setNextReportTime(Mockito.<FeedList>any());
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    feedController.latest(timedAlerter, hist, mock(SymphonyAddressable.class));

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(feedListCache, atLeast(1)).setNextReportTime(isA(FeedList.class));
    verify(feedLoader, atLeast(1)).createSyndFeed(Mockito.<Feed>any());
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#latest(TimedAlerter, AllHistory, SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} does nothing.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#latest(TimedAlerter, AllHistory,
   * SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test latest(TimedAlerter, AllHistory, SymphonyAddressable); given ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedController.latest(TimedAlerter, AllHistory, SymphonyAddressable)"})
  void testLatest_givenResponseHandlersAcceptDoesNothing_thenCallsAccept() throws BeansException {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    feedController.latest(timedAlerter, hist, mock(SymphonyAddressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#latest(TimedAlerter, AllHistory, SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Given {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code No New News Items}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#latest(TimedAlerter, AllHistory,
   * SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test latest(TimedAlerter, AllHistory, SymphonyAddressable); given ResponseHandlers accept(Object) throw RuntimeException(String) with 'No New News Items'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedController.latest(TimedAlerter, AllHistory, SymphonyAddressable)"})
  void testLatest_givenResponseHandlersAcceptThrowRuntimeExceptionWithNoNewNewsItems()
      throws BeansException {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doThrow(new RuntimeException("No New News Items"))
        .when(responseHandlers)
        .accept(Mockito.<Response>any());

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> feedController.latest(timedAlerter, hist, mock(SymphonyAddressable.class)));
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#latest(TimedAlerter, AllHistory, SymphonyAddressable)}.
   *
   * <ul>
   *   <li>Then calls {@link FeedListCache#setNextReportTime(FeedList)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#latest(TimedAlerter, AllHistory,
   * SymphonyAddressable)}
   */
  @Test
  @DisplayName(
      "Test latest(TimedAlerter, AllHistory, SymphonyAddressable); then calls setNextReportTime(FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FeedController.latest(TimedAlerter, AllHistory, SymphonyAddressable)"})
  void testLatest_thenCallsSetNextReportTime() throws Exception {
    // Arrange
    Feed feed = new Feed();
    feed.setDescription("The characteristics of someone or something");
    feed.setName("No New News Items");
    feed.setProxy(new ProxyProperties());
    feed.setUrl("https://example.org/example");

    ArrayList<Feed> feeds = new ArrayList<>();
    feeds.add(feed);

    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(feeds);
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(feedLoader.createSyndFeed(Mockito.<Feed>any())).thenReturn(new SyndFeedImpl());
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .setNextReportTime(Mockito.<FeedList>any());
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory hist = new AllHistory();
    hist.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    feedController.latest(timedAlerter, hist, mock(SymphonyAddressable.class));

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(feedListCache).setNextReportTime(isA(FeedList.class));
    verify(feedLoader).createSyndFeed(isA(Feed.class));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#createFilterForm()}.
   *
   * <p>Method under test: {@link FeedController#createFilterForm()}
   */
  @Test
  @DisplayName("Test createFilterForm()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Filter FeedController.createFilterForm()"})
  void testCreateFilterForm() {
    // Arrange and Act
    Filter actualCreateFilterFormResult = feedController.createFilterForm();

    // Assert
    assertNull(actualCreateFilterFormResult.getToMatch());
    assertEquals(Type.EXCLUDE, actualCreateFilterFormResult.getUsage());
  }

  /**
   * Test {@link FeedController#filter(Filter, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#filter(Filter, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test filter(Filter, SymphonyAddressable, User); then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.filter(Filter, SymphonyAddressable, User)"})
  void testFilter_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    Filter f = new Filter();
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualFilterResult = feedController.filter(f, a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualFilterResult);
  }

  /**
   * Test {@link FeedController#filter(Filter, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then return UpdateIntervalMinutes intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#filter(Filter, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test filter(Filter, SymphonyAddressable, User); then return UpdateIntervalMinutes intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.filter(Filter, SymphonyAddressable, User)"})
  void testFilter_thenReturnUpdateIntervalMinutesIntValueIsFortyTwo() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    ArrayList<Filter> filters = new ArrayList<>();
    feedList.setFilters(filters);
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    Filter f = new Filter();
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualFilterResult = feedController.filter(f, a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertEquals(42, actualFilterResult.getUpdateIntervalMinutes().intValue());
    assertTrue(actualFilterResult.isAdminOnly());
    assertTrue(actualFilterResult.isPaused());
    assertSame(filters, actualFilterResult.getFilters());
  }

  /**
   * Test {@link FeedController#filter(Filter, SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#filter(Filter, SymphonyAddressable, User)}
   */
  @Test
  @DisplayName("Test filter(Filter, SymphonyAddressable, User); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.filter(Filter, SymphonyAddressable, User)"})
  void testFilter_thenThrowRuntimeException() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    Filter f = new Filter();
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.filter(f, a, new SymphonyUser(1L)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test makeAdminOnly(SymphonyAddressable, User); given FeedList (default constructor) AdminOnly is 'true'; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.makeAdminOnly(SymphonyAddressable, User)"})
  void testMakeAdminOnly_givenFeedListAdminOnlyIsTrue_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualMakeAdminOnlyResult = feedController.makeAdminOnly(a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualMakeAdminOnlyResult);
  }

  /**
   * Test {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test makeAdminOnly(SymphonyAddressable, User); then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.makeAdminOnly(SymphonyAddressable, User)"})
  void testMakeAdminOnly_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualMakeAdminOnlyResult = feedController.makeAdminOnly(a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualMakeAdminOnlyResult);
  }

  /**
   * Test {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#makeAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName("Test makeAdminOnly(SymphonyAddressable, User); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.makeAdminOnly(SymphonyAddressable, User)"})
  void testMakeAdminOnly_thenThrowRuntimeException() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> feedController.makeAdminOnly(a, new SymphonyUser(1L)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#notAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#notAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test notAdminOnly(SymphonyAddressable, User); given FeedList (default constructor) AdminOnly is 'true'; then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.notAdminOnly(SymphonyAddressable, User)"})
  void testNotAdminOnly_givenFeedListAdminOnlyIsTrue_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualNotAdminOnlyResult = feedController.notAdminOnly(a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualNotAdminOnlyResult);
  }

  /**
   * Test {@link FeedController#notAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then return {@link FeedList} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FeedController#notAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName(
      "Test notAdminOnly(SymphonyAddressable, User); then return FeedList (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.notAdminOnly(SymphonyAddressable, User)"})
  void testNotAdminOnly_thenReturnFeedList() {
    // Arrange
    FeedList feedList = new FeedList();
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act
    FeedList actualNotAdminOnlyResult = feedController.notAdminOnly(a, new SymphonyUser(1L));

    // Assert
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    assertSame(feedList, actualNotAdminOnlyResult);
  }

  /**
   * Test {@link FeedController#notAdminOnly(SymphonyAddressable, User)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#notAdminOnly(SymphonyAddressable, User)}
   */
  @Test
  @DisplayName("Test notAdminOnly(SymphonyAddressable, User); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.notAdminOnly(SymphonyAddressable, User)"})
  void testNotAdminOnly_thenThrowRuntimeException() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> feedController.notAdminOnly(a, new SymphonyUser(1L)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#every(SymphonyAddressable, User, Word)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       does nothing.
   *   <li>Then calls {@link FeedListCache#writeFeedList(Addressable, FeedList)}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#every(SymphonyAddressable, User, Word)}
   */
  @Test
  @DisplayName(
      "Test every(SymphonyAddressable, User, Word); given FeedListCache writeFeedList(Addressable, FeedList) does nothing; then calls writeFeedList(Addressable, FeedList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.every(SymphonyAddressable, User, Word)"})
  void testEvery_givenFeedListCacheWriteFeedListDoesNothing_thenCallsWriteFeedList() {
    // Arrange
    FeedList feedList = mock(FeedList.class);
    doNothing().when(feedList).setAdminOnly(anyBoolean());
    doNothing().when(feedList).setFeeds(Mockito.<List<Feed>>any());
    doNothing().when(feedList).setFilters(Mockito.<List<Filter>>any());
    doNothing().when(feedList).setPaused(anyBoolean());
    doNothing().when(feedList).setUpdateIntervalMinutes(Mockito.<Integer>any());
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doNothing()
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);
    SymphonyUser author = new SymphonyUser(1L);
    Word mins = mock(Word.class);
    when(mins.getText()).thenReturn("42");

    // Act
    feedController.every(a, author, mins);

    // Assert
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedList).setAdminOnly(eq(true));
    verify(feedList).setFeeds(isA(List.class));
    verify(feedList).setFilters(isA(List.class));
    verify(feedList).setPaused(eq(true));
    verify(feedList).setUpdateIntervalMinutes(eq(42));
    verify(mins).getText();
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#every(SymphonyAddressable, User, Word)}.
   *
   * <ul>
   *   <li>Given {@link FeedListCache} {@link FeedListCache#writeFeedList(Addressable, FeedList)}
   *       throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#every(SymphonyAddressable, User, Word)}
   */
  @Test
  @DisplayName(
      "Test every(SymphonyAddressable, User, Word); given FeedListCache writeFeedList(Addressable, FeedList) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.every(SymphonyAddressable, User, Word)"})
  void testEvery_givenFeedListCacheWriteFeedListThrowRuntimeExceptionWithFoo() {
    // Arrange
    FeedList feedList = mock(FeedList.class);
    doNothing().when(feedList).setAdminOnly(anyBoolean());
    doNothing().when(feedList).setFeeds(Mockito.<List<Feed>>any());
    doNothing().when(feedList).setFilters(Mockito.<List<Filter>>any());
    doNothing().when(feedList).setPaused(anyBoolean());
    doNothing().when(feedList).setUpdateIntervalMinutes(Mockito.<Integer>any());
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    doThrow(new RuntimeException("foo"))
        .when(feedListCache)
        .writeFeedList(Mockito.<Addressable>any(), Mockito.<FeedList>any());
    SymphonyAddressable a = mock(SymphonyAddressable.class);
    SymphonyUser author = new SymphonyUser(1L);
    Word mins = mock(Word.class);
    when(mins.getText()).thenReturn("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.every(a, author, mins));
    verify(feedListCache).writeFeedList(isA(Addressable.class), isA(FeedList.class));
    verify(feedList).setAdminOnly(eq(true));
    verify(feedList).setFeeds(isA(List.class));
    verify(feedList).setFilters(isA(List.class));
    verify(feedList).setPaused(eq(true));
    verify(feedList).setUpdateIntervalMinutes(eq(42));
    verify(mins).getText();
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#every(SymphonyAddressable, User, Word)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#every(SymphonyAddressable, User, Word)}
   */
  @Test
  @DisplayName(
      "Test every(SymphonyAddressable, User, Word); given RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.every(SymphonyAddressable, User, Word)"})
  void testEvery_givenRuntimeExceptionWithFoo() {
    // Arrange
    FeedList feedList = new FeedList();
    feedList.setAdminOnly(true);
    feedList.setFeeds(new ArrayList<>());
    feedList.setFilters(new ArrayList<>());
    feedList.setPaused(true);
    feedList.setUpdateIntervalMinutes(42);
    Optional<Object> ofResult = Optional.of(feedList);
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    SymphonyAddressable a = mock(SymphonyAddressable.class);
    SymphonyUser author = new SymphonyUser(1L);
    Word mins = mock(Word.class);
    when(mins.getText()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> feedController.every(a, author, mins));
    verify(mins).getText();
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }

  /**
   * Test {@link FeedController#every(SymphonyAddressable, User, Word)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistory} {@link SymphonyHistory#getLastFromHistory(Class,
   *       Addressable)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FeedController#every(SymphonyAddressable, User, Word)}
   */
  @Test
  @DisplayName(
      "Test every(SymphonyAddressable, User, Word); given SymphonyHistory getLastFromHistory(Class, Addressable) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedList FeedController.every(SymphonyAddressable, User, Word)"})
  void testEvery_givenSymphonyHistoryGetLastFromHistoryThrowRuntimeExceptionWithFoo() {
    // Arrange
    when(symphonyHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException("foo"));
    SymphonyAddressable a = mock(SymphonyAddressable.class);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> feedController.every(a, new SymphonyUser(1L), mock(Word.class)));
    verify(symphonyHistory).getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
  }
}
