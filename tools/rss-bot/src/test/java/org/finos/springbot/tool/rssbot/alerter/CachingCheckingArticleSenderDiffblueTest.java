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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.ref.SoftReference;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CachingCheckingArticleSender.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CachingCheckingArticleSenderDiffblueTest {
  @MockBean
  private AllHistory allHistory;

  @Autowired
  private CachingCheckingArticleSender cachingCheckingArticleSender;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test {@link CachingCheckingArticleSender#CachingCheckingArticleSender(ResponseHandlers, AllHistory)}.
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#CachingCheckingArticleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  @DisplayName("Test new CachingCheckingArticleSender(ResponseHandlers, AllHistory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.<init>(org.finos.springbot.workflow.response.handlers.ResponseHandlers, org.finos.springbot.workflow.history.AllHistory)"})
  void testNewCachingCheckingArticleSender() throws BeansException {
    // Arrange
    ResponseHandlers responseHandler = mock(ResponseHandlers.class);

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertTrue((new CachingCheckingArticleSender(responseHandler, h)).alreadySent.isEmpty());
  }

  /**
   * Test {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String, Addressable)} return empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); given AllHistory getLastFromHistory(Class, String, Addressable) return empty; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.alreadyPosted(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testAlreadyPosted_givenAllHistoryGetLastFromHistoryReturnEmpty_thenReturnFalse() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);
    Addressable a = mock(Addressable.class);

    Article article = new Article();
    article.setArticleHashTag(new HashTag("42"));

    // Act
    boolean actualAlreadyPostedResult = cachingCheckingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertFalse(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Given {@code Uri}.</li>
   *   <li>Then {@link CachingCheckingArticleSender} {@link CachingCheckingArticleSender#alreadySent} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); given 'Uri'; then CachingCheckingArticleSender alreadySent size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.alreadyPosted(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testAlreadyPosted_givenUri_thenCachingCheckingArticleSenderAlreadySentSizeIsOne() {
    // Arrange
    FeedList fl = new FeedList();
    HashTag feedHashTag = new HashTag("42");
    Optional<Object> ofResult = Optional
        .of(new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    Addressable a = mock(Addressable.class);
    Article article = mock(Article.class);
    when(article.getUri()).thenReturn("Uri");
    when(article.getArticleHashTag()).thenReturn(new HashTag("42"));
    doNothing().when(article).setArticleHashTag(Mockito.<HashTag>any());
    article.setArticleHashTag(new HashTag("42"));

    // Act
    boolean actualAlreadyPostedResult = cachingCheckingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(article).getArticleHashTag();
    verify(article).getUri();
    verify(article).setArticleHashTag(isA(HashTag.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, cachingCheckingArticleSender.alreadySent.size());
    assertTrue(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.alreadyPosted(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testAlreadyPosted_thenReturnFalse() {
    // Arrange
    FeedList fl = new FeedList();
    HashTag feedHashTag = new HashTag("42");
    Optional<Object> ofResult = Optional
        .of(new Article("Dr", "JaneDoe", "Feed Name", "Uri", fl, feedHashTag, new HashTag("42")));
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    Addressable a = mock(Addressable.class);

    Article article = new Article();
    article.setArticleHashTag(new HashTag("42"));

    // Act
    boolean actualAlreadyPostedResult = cachingCheckingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertFalse(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CachingCheckingArticleSender#postInner(Addressable, Article)}.
   * <ul>
   *   <li>Then {@link CachingCheckingArticleSender} {@link CachingCheckingArticleSender#alreadySent} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName("Test postInner(Addressable, Article); then CachingCheckingArticleSender alreadySent size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.postInner(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CachingCheckingArticleSender} {@link CachingCheckingArticleSender#alreadySent} {@code null} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName("Test postInner(Addressable, Article); when 'null'; then CachingCheckingArticleSender alreadySent 'null' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.postInner(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testPostInner_whenNull_thenCachingCheckingArticleSenderAlreadySentNullSizeIsOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    cachingCheckingArticleSender.postInner(null, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    Map<Addressable, SoftReference<Set<Article>>> addressableSoftReferenceMap = cachingCheckingArticleSender.alreadySent;
    assertEquals(1, addressableSoftReferenceMap.size());
    SoftReference<Set<Article>> getResult = addressableSoftReferenceMap.get(null);
    assertEquals(1, getResult.get().size());
    assertFalse(getResult.isEnqueued());
  }

  /**
   * Test {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}
   */
  @Test
  @DisplayName("Test recordSent(Addressable, Article); when Addressable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.recordSent(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CachingCheckingArticleSender} {@link CachingCheckingArticleSender#alreadySent} {@code null} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCheckingArticleSender#recordSent(Addressable, Article)}
   */
  @Test
  @DisplayName("Test recordSent(Addressable, Article); when 'null'; then CachingCheckingArticleSender alreadySent 'null' size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender.recordSent(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testRecordSent_whenNull_thenCachingCheckingArticleSenderAlreadySentNullSizeIsOne() {
    // Arrange and Act
    cachingCheckingArticleSender.recordSent(null, new Article());

    // Assert
    Map<Addressable, SoftReference<Set<Article>>> addressableSoftReferenceMap = cachingCheckingArticleSender.alreadySent;
    assertEquals(1, addressableSoftReferenceMap.size());
    SoftReference<Set<Article>> getResult = addressableSoftReferenceMap.get(null);
    assertEquals(1, getResult.get().size());
    assertFalse(getResult.isEnqueued());
  }
}
