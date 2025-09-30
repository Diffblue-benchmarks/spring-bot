package org.finos.springbot.tool.rssbot.alerter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BasicArticleSender.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BasicArticleSenderDiffblueTest {
  @Autowired private BasicArticleSender basicArticleSender;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test {@link BasicArticleSender#post(Addressable, Article)}.
   *
   * <ul>
   *   <li>When {@link Article#Article()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BasicArticleSender#post(Addressable, Article)}
   */
  @Test
  @DisplayName("Test post(Addressable, Article); when Article(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BasicArticleSender.post(Addressable, Article)"})
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
   * Test {@link BasicArticleSender#postInner(Addressable, Article)}.
   *
   * <ul>
   *   <li>When {@link Article#Article()}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicArticleSender#postInner(Addressable, Article)}
   */
  @Test
  @DisplayName("Test postInner(Addressable, Article); when Article(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicArticleSender.postInner(Addressable, Article)"})
  void testPostInner_whenArticle_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Addressable a = mock(Addressable.class);

    // Act
    basicArticleSender.postInner(a, new Article());

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }
}
