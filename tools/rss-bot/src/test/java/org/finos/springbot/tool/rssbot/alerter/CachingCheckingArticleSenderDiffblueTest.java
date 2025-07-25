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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CachingCheckingArticleSender.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CachingCheckingArticleSenderDiffblueTest {
  @MockitoBean private AllHistory allHistory;

  @Autowired private CachingCheckingArticleSender cachingCheckingArticleSender;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test {@link CachingCheckingArticleSender#CachingCheckingArticleSender(ResponseHandlers,
   * AllHistory)}.
   *
   * <p>Method under test: {@link
   * CachingCheckingArticleSender#CachingCheckingArticleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  @DisplayName("Test new CachingCheckingArticleSender(ResponseHandlers, AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingCheckingArticleSender.<init>(ResponseHandlers, AllHistory)"})
  void testNewCachingCheckingArticleSender() throws BeansException {
    // Arrange
    ResponseHandlers responseHandler = mock(ResponseHandlers.class);

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertTrue(new CachingCheckingArticleSender(responseHandler, h).alreadySent.isEmpty());
  }

  /**
   * Test {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}.
   *
   * <ul>
   *   <li>Given {@link FeedList} (default constructor) AdminOnly is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test alreadyPosted(Addressable, Article); given FeedList (default constructor) AdminOnly is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CachingCheckingArticleSender.alreadyPosted(Addressable, Article)"})
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
        cachingCheckingArticleSender.alreadyPosted(
            a,
            new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl2, feedHashTag2, new HashTag("42")));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, cachingCheckingArticleSender.alreadySent.size());
    assertTrue(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CachingCheckingArticleSender#postInner(Addressable, Article)}.
   *
   * <ul>
   *   <li>Then {@link CachingCheckingArticleSender} {@link
   *       CachingCheckingArticleSender#alreadySent} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CachingCheckingArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test postInner(Addressable, Article); then CachingCheckingArticleSender alreadySent size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingCheckingArticleSender.postInner(Addressable, Article)"})
  void testPostInner_thenCachingCheckingArticleSenderAlreadySentSizeIsOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    // Act
    cachingCheckingArticleSender.postInner(a, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    assertEquals(1, cachingCheckingArticleSender.alreadySent.size());
  }

  /**
   * Test {@link CachingCheckingArticleSender#postInner(Addressable, Article)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CachingCheckingArticleSender} {@link
   *       CachingCheckingArticleSender#alreadySent} {@code null} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CachingCheckingArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test postInner(Addressable, Article); when 'null'; then CachingCheckingArticleSender alreadySent 'null' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingCheckingArticleSender.postInner(Addressable, Article)"})
  void testPostInner_whenNull_thenCachingCheckingArticleSenderAlreadySentNullSizeIsOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    cachingCheckingArticleSender.postInner(null, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    Map<Addressable, SoftReference<Set<Article>>> addressableSoftReferenceMap =
        cachingCheckingArticleSender.alreadySent;
    assertEquals(1, addressableSoftReferenceMap.size());
    SoftReference<Set<Article>> getResult = addressableSoftReferenceMap.get(null);
    assertEquals(1, getResult.get().size());
    assertFalse(getResult.isEnqueued());
  }

  /**
   * Test {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}.
   *
   * <ul>
   *   <li>When {@link Addressable}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}
   */
  @Test
  @DisplayName("Test recordSent(Addressable, Article); when Addressable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingCheckingArticleSender.recordSent(Addressable, Article)"})
  void testRecordSent_whenAddressable() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    cachingCheckingArticleSender.recordSent(a, new Article());

    // Assert
    assertEquals(1, cachingCheckingArticleSender.alreadySent.size());
  }

  /**
   * Test {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CachingCheckingArticleSender} {@link
   *       CachingCheckingArticleSender#alreadySent} {@code null} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}
   */
  @Test
  @DisplayName(
      "Test recordSent(Addressable, Article); when 'null'; then CachingCheckingArticleSender alreadySent 'null' size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachingCheckingArticleSender.recordSent(Addressable, Article)"})
  void testRecordSent_whenNull_thenCachingCheckingArticleSenderAlreadySentNullSizeIsOne() {
    // Arrange and Act
    cachingCheckingArticleSender.recordSent(null, new Article());

    // Assert
    Map<Addressable, SoftReference<Set<Article>>> addressableSoftReferenceMap =
        cachingCheckingArticleSender.alreadySent;
    assertEquals(1, addressableSoftReferenceMap.size());
    SoftReference<Set<Article>> getResult = addressableSoftReferenceMap.get(null);
    assertEquals(1, getResult.get().size());
    assertFalse(getResult.isEnqueued());
  }
}
