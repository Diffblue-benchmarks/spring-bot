package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.tool.rssbot.alerter.CachingCheckingArticleSender;
import org.finos.springbot.tool.rssbot.alerter.FeedListCache;
import org.finos.springbot.tool.rssbot.alerter.FeedListCacheImpl;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

@ExtendWith(MockitoExtension.class)
class RSSConfigDiffblueTest {
  @InjectMocks private RSSConfig rSSConfig;

  @InjectMocks private RSSProperties rSSProperties;

  /**
   * Test {@link RSSConfig#rwec(ResponseHandlers)}.
   *
   * <ul>
   *   <li>When {@link ResponseHandlers} {@link ResponseHandlers#accept(Object)} does nothing.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link RSSConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test rwec(ResponseHandlers); when ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer RSSConfig.rwec(ResponseHandlers)"})
  void testRwec_whenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = rSSConfig.rwec(rh);
    SymphonyRoom a = new SymphonyRoom("Name", "42");
    MemberAction t = new MemberAction(a, new SymphonyUser(1L), Type.ADDED, "42");
    actualRwecResult.accept(t);

    // Assert
    verify(rh).accept(isA(Response.class));
  }

  /**
   * Test {@link RSSConfig#feedListCache()}.
   *
   * <p>Method under test: {@link RSSConfig#feedListCache()}
   */
  @Test
  @DisplayName("Test feedListCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeedListCache RSSConfig.feedListCache()"})
  void testFeedListCache() {
    // Arrange and Act
    FeedListCache actualFeedListCacheResult = rSSConfig.feedListCache();

    // Assert
    assertTrue(actualFeedListCacheResult instanceof FeedListCacheImpl);
    assertTrue(actualFeedListCacheResult.getKnownFeeds().isEmpty());
  }

  /**
   * Test {@link RSSConfig#articleSender(ResponseHandlers, AllHistory)}.
   *
   * <ul>
   *   <li>Then return {@link CachingCheckingArticleSender}.
   * </ul>
   *
   * <p>Method under test: {@link RSSConfig#articleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test articleSender(ResponseHandlers, AllHistory); then return CachingCheckingArticleSender")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.alerter.ArticleSender RSSConfig.articleSender(ResponseHandlers, AllHistory)"
  })
  void testArticleSender_thenReturnCachingCheckingArticleSender() throws BeansException {
    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    // Act and Assert
    assertTrue(rSSConfig.articleSender(rh, h) instanceof CachingCheckingArticleSender);
  }
}
