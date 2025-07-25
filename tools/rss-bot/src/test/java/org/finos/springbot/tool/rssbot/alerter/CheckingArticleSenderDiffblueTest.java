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
import org.springframework.beans.factory.annotation.Autowired;
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
    HashTag feedHashTag = new HashTag("42");

    // Act
    int actualPostResult =
        checkingArticleSender.post(
            a,
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>When {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test post(Addressable, Article); given FeedList (default constructor) AdminOnly is 'true'; when FeedList (default constructor) AdminOnly is 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_givenFeedListAdminOnlyIsTrue_whenFeedListAdminOnlyIsTrue_thenReturnZero() {
    // Arrange
    FeedList fl = new FeedList();
    fl.setAdminOnly(true);
    fl.setFeeds(new ArrayList<>());
    fl.setFilters(new ArrayList<>());
    fl.setPaused(true);
    fl.setUpdateIntervalMinutes(42);
    HashTag feedHashTag = new HashTag("42");
    Optional<Object> ofResult =
        Optional.of(
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));
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
    HashTag feedHashTag2 = new HashTag("42");

    // Act
    int actualPostResult =
        checkingArticleSender.post(
            a,
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl2, feedHashTag2, new HashTag("42")));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(0, actualPostResult);
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
    HashTag feedHashTag = new HashTag("42");

    // Act
    boolean actualAlreadyPostedResult =
        checkingArticleSender.alreadyPosted(
            a,
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
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
    HashTag feedHashTag = new HashTag("42");
    Optional<Object> ofResult =
        Optional.of(
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));
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
    HashTag feedHashTag2 = new HashTag("42");

    // Act
    boolean actualAlreadyPostedResult =
        checkingArticleSender.alreadyPosted(
            a,
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl2, feedHashTag2, new HashTag("42")));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertTrue(actualAlreadyPostedResult);
  }
}
