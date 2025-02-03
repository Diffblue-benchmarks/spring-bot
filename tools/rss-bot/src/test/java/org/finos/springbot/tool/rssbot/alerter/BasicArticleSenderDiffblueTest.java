package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.finos.springbot.tool.rssbot.feed.Article;
import org.finos.springbot.workflow.content.Addressable;
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

@ContextConfiguration(classes = {BasicArticleSender.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BasicArticleSenderDiffblueTest {
  @Autowired
  private BasicArticleSender basicArticleSender;

  @MockBean
  private ResponseHandlers responseHandlers;

  /**
   * Test {@link BasicArticleSender#post(Addressable, Article)}.
   * <ul>
   *   <li>When {@link Article#Article()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); when Article(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.BasicArticleSender.post(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testPost_whenArticle_thenReturnOne() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    // Act
    int actualPostResult = basicArticleSender.post(a, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link BasicArticleSender#post(Addressable, Article)}.
   * <ul>
   *   <li>When {@link Article}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); when Article; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.tool.rssbot.alerter.BasicArticleSender.post(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testPost_whenArticle_thenReturnOne2() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    int actualPostResult = basicArticleSender.post(mock(Addressable.class), mock(Article.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    assertEquals(1, actualPostResult);
  }

  /**
   * Test {@link BasicArticleSender#postInner(Addressable, Article)}.
   * <ul>
   *   <li>When {@link Article#Article()}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName("Test postInner(Addressable, Article); when Article(); then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.BasicArticleSender.postInner(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testPostInner_whenArticle_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    // Act
    basicArticleSender.postInner(a, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link BasicArticleSender#postInner(Addressable, Article)}.
   * <ul>
   *   <li>When {@link Article}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasicArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName("Test postInner(Addressable, Article); when Article; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.tool.rssbot.alerter.BasicArticleSender.postInner(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.tool.rssbot.feed.Article)"})
  void testPostInner_whenArticle_thenCallsAccept2() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    // Act
    basicArticleSender.postInner(mock(Addressable.class), mock(Article.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
