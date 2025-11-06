package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
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
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

@ExtendWith(MockitoExtension.class)
class RSSConfigDiffblueTest {
  @InjectMocks
  private RSSConfig rSSConfig;

  @InjectMocks
  private RSSProperties rSSProperties;

  /**
   * Test {@link RSSConfig#rwec(ResponseHandlers)}.
   * <ul>
   *   <li>When {@link ResponseHandlers} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RSSConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test rwec(ResponseHandlers); when ResponseHandlers accept(Object) does nothing; then calls accept(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoomWelcomeEventConsumer RSSConfig.rwec(ResponseHandlers)"})
  void testRwec_whenResponseHandlersAcceptDoesNothing_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    RSSConfig rssConfig = new RSSConfig();
    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = rssConfig.rwec(rh);
    SymphonyRoom a = new SymphonyRoom("Name", "42");

    actualRwecResult.accept(new MemberAction(a, new SymphonyUser(1L), Type.ADDED, "42"));

    // Assert
    verify(rh).accept(isA(Response.class));
  }

  /**
   * Test {@link RSSConfig#feedListCache()}.
   * <p>
   * Method under test: {@link RSSConfig#feedListCache()}
   */
  @Test
  @DisplayName("Test feedListCache()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link RSSConfig#articleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  @DisplayName("Test articleSender(ResponseHandlers, AllHistory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.rssbot.alerter.ArticleSender RSSConfig.articleSender(ResponseHandlers, AllHistory)"})
  void testArticleSender() throws BeansException {
    // Arrange
    ResponseHandlers rh = mock(ResponseHandlers.class);

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertTrue(rSSConfig.articleSender(rh, h) instanceof CachingCheckingArticleSender);
  }
}
