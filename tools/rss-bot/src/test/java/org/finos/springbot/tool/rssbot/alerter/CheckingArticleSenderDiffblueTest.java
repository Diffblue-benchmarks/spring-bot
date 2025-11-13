package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.springbot.symphony.content.HashTag;
import org.finos.springbot.tool.rssbot.feed.Article;
import org.finos.springbot.tool.rssbot.feed.FeedList;
import org.finos.springbot.workflow.content.Addressable;
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
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CheckingArticleSender.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CheckingArticleSenderDiffblueTest {
  @MockitoBean private AllHistory allHistory;

  @Autowired private CheckingArticleSender checkingArticleSender;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String,
   *       Addressable)} return empty.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test post(Addressable, Article); given AllHistory getLastFromHistory(Class, String, Addressable) return empty; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_givenAllHistoryGetLastFromHistoryReturnEmpty_thenReturnOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);
    Addressable a = mock(Addressable.class);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    HashTag articleHashTag = mock(HashTag.class);
    when(articleHashTag.getName()).thenReturn("Name");

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, new HashTag(), articleHashTag);

    // Act
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(articleHashTag).getName();
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Name"), isA(Addressable.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test post(Addressable, Article); given FeedList (default constructor) AdminOnly is 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_givenFeedListAdminOnlyIsTrue_thenReturnZero() {
    // Arrange
    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag();

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag());
    Optional<Object> ofResult = Optional.of(article);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    Addressable a = mock(Addressable.class);

    FeedList fl2 = new FeedList();
    fl2.setAdminOnly(true);
    fl2.setFeeds(new ArrayList<>());
    fl2.setFilters(new ArrayList<>());
    fl2.setPaused(true);
    fl2.setUpdateIntervalMinutes(42);

    HashTag articleHashTag = mock(HashTag.class);
    when(articleHashTag.getName()).thenReturn("Name");

    Article article2 =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl2, new HashTag(), articleHashTag);

    // Act
    int actualPostResult = checkingArticleSender.post(a, article2);

    // Assert
    verify(articleHashTag).getName();
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Name"), isA(Addressable.class));
    assertEquals(0, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getBeanNamesForType(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); then calls getBeanNamesForType(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_thenCallsGetBeanNamesForType() throws BeansException {
    // Arrange
    ResponseHandlers responseHandler = mock(ResponseHandlers.class);
    doNothing().when(responseHandler).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    CheckingArticleSender checkingArticleSender = new CheckingArticleSender(responseHandler, h);
    Addressable a = mock(Addressable.class);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag();

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42"));

    // Act
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(responseHandler).accept(isA(Response.class));
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String,
   *       Addressable)} return empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test alreadyPosted(Addressable, Article); given AllHistory getLastFromHistory(Class, String, Addressable) return empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
  void testAlreadyPosted_givenAllHistoryGetLastFromHistoryReturnEmpty_thenReturnFalse() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);
    Addressable a = mock(Addressable.class);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);

    HashTag articleHashTag = mock(HashTag.class);
    when(articleHashTag.getName()).thenReturn("Name");

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, new HashTag(), articleHashTag);

    // Act
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(articleHashTag).getName();
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Name"), isA(Addressable.class));
    assertFalse(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test alreadyPosted(Addressable, Article); given FeedList (default constructor) AdminOnly is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
  void testAlreadyPosted_givenFeedListAdminOnlyIsTrue_thenReturnTrue() {
    // Arrange
    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag();

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag());
    Optional<Object> ofResult = Optional.of(article);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    Addressable a = mock(Addressable.class);

    FeedList fl2 = new FeedList();
    fl2.setAdminOnly(true);
    fl2.setFeeds(new ArrayList<>());
    fl2.setFilters(new ArrayList<>());
    fl2.setPaused(true);
    fl2.setUpdateIntervalMinutes(42);

    HashTag articleHashTag = mock(HashTag.class);
    when(articleHashTag.getName()).thenReturn("Name");

    Article article2 =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl2, new HashTag(), articleHashTag);

    // Act
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article2);

    // Assert
    verify(articleHashTag).getName();
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Name"), isA(Addressable.class));
    assertTrue(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationContext#getBeanNamesForType(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); then calls getBeanNamesForType(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
  void testAlreadyPosted_thenCallsGetBeanNamesForType() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);
    CheckingArticleSender checkingArticleSender =
        new CheckingArticleSender(mock(ResponseHandlers.class), h);
    Addressable a = mock(Addressable.class);

    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag();

    Article article =
        new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42"));

    // Act
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertFalse(actualAlreadyPostedResult);
  }
}
