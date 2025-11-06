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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CheckingArticleSender.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CheckingArticleSenderDiffblueTest {
  @MockBean
  private AllHistory allHistory;

  @Autowired
  private CheckingArticleSender checkingArticleSender;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   * <p>
   * Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
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
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   * <p>
   * Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost2() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    FeedList fl = new FeedList();
    HashTag feedHashTag = new HashTag("42");
    Optional<Object> ofResult = Optional
        .of(new Article("Dr", "JaneDoe", "Feed Name", "java.util.List", fl, feedHashTag, new HashTag("42")));
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    Addressable a = mock(Addressable.class);
    Article article = mock(Article.class);
    when(article.getUri()).thenReturn("Uri");
    when(article.getArticleHashTag()).thenReturn(new HashTag("42"));
    doNothing().when(article).setArticleHashTag(Mockito.<HashTag>any());
    article.setArticleHashTag(new HashTag("42"));

    // Act
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(article).getArticleHashTag();
    verify(article).getUri();
    verify(article).setArticleHashTag(isA(HashTag.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String, Addressable)} return empty.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); given AllHistory getLastFromHistory(Class, String, Addressable) return empty; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_givenAllHistoryGetLastFromHistoryReturnEmpty_thenReturnOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);
    Addressable a = mock(Addressable.class);

    Article article = new Article();
    article.setArticleHashTag(new HashTag("42"));

    // Act
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#post(Addressable, Article)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckingArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CheckingArticleSender.post(Addressable, Article)"})
  void testPost_thenReturnZero() {
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
    int actualPostResult = checkingArticleSender.post(a, article);

    // Assert
    verify(article).getArticleHashTag();
    verify(article).getUri();
    verify(article).setArticleHashTag(isA(HashTag.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertEquals(0, actualPostResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String, Addressable)} return empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); given AllHistory getLastFromHistory(Class, String, Addressable) return empty; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
  void testAlreadyPosted_givenAllHistoryGetLastFromHistoryReturnEmpty_thenReturnFalse() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);
    Addressable a = mock(Addressable.class);

    Article article = new Article();
    article.setArticleHashTag(new HashTag("42"));

    // Act
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertFalse(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Given {@code Uri}.</li>
   *   <li>When {@link Article} {@link Article#getUri()} return {@code Uri}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); given 'Uri'; when Article getUri() return 'Uri'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
  void testAlreadyPosted_givenUri_whenArticleGetUriReturnUri_thenReturnTrue() {
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
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(article).getArticleHashTag();
    verify(article).getUri();
    verify(article).setArticleHashTag(isA(HashTag.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertTrue(actualAlreadyPostedResult);
  }

  /**
   * Test {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckingArticleSender#alreadyPosted(Addressable, Article)}
   */
  @Test
  @DisplayName("Test alreadyPosted(Addressable, Article); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CheckingArticleSender.alreadyPosted(Addressable, Article)"})
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
    boolean actualAlreadyPostedResult = checkingArticleSender.alreadyPosted(a, article);

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("42"), isA(Addressable.class));
    assertFalse(actualAlreadyPostedResult);
  }
}
