package org.finos.springbot.tool.rssbot;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

@ExtendWith(MockitoExtension.class)
class RSSConfigDiffblueTest {
  @InjectMocks private RSSConfig rSSConfig;

  @Mock private RSSProperties rSSProperties;

  /**
   * Test {@link RSSConfig#rwec(ResponseHandlers)}.
   *
   * <p>Method under test: {@link RSSConfig#rwec(ResponseHandlers)}
   */
  @Test
  @DisplayName("Test rwec(ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoomWelcomeEventConsumer RSSConfig.rwec(ResponseHandlers)"})
  void testRwec() {
    // Arrange
    RSSConfig rssConfig = new RSSConfig();

    ResponseHandlers rh = mock(ResponseHandlers.class);
    doNothing().when(rh).accept(Mockito.<Response>any());

    // Act
    RoomWelcomeEventConsumer actualRwecResult = rssConfig.rwec(rh);
    SymphonyRoom a = new SymphonyRoom();
    MemberAction t = new MemberAction(a, new SymphonyUser(), Type.ADDED, "42");
    actualRwecResult.accept(t);

    // Assert
    verify(rh).accept(isA(Response.class));
  }

  /**
   * Test {@link RSSConfig#feedLoader()}.
   *
   * <p>Method under test: {@link RSSConfig#feedLoader()}
   */
  @Test
  @DisplayName("Test feedLoader()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.springbot.tool.rssbot.load.FeedLoader RSSConfig.feedLoader()"})
  void testFeedLoader() {
    // Arrange
    when(rSSProperties.getProxies()).thenReturn(new ArrayList<>());

    // Act
    rSSConfig.feedLoader();

    // Assert
    verify(rSSProperties).getProxies();
  }

  /**
   * Test {@link RSSConfig#feedLoader()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProxyProperties} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RSSConfig#feedLoader()}
   */
  @Test
  @DisplayName("Test feedLoader(); given ArrayList() add ProxyProperties (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.finos.springbot.tool.rssbot.load.FeedLoader RSSConfig.feedLoader()"})
  void testFeedLoader_givenArrayListAddProxyProperties() {
    // Arrange
    ArrayList<ProxyProperties> proxyPropertiesList = new ArrayList<>();
    proxyPropertiesList.add(new ProxyProperties());
    when(rSSProperties.getProxies()).thenReturn(proxyPropertiesList);

    // Act
    rSSConfig.feedLoader();

    // Assert
    verify(rSSProperties).getProxies();
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
    FeedListCache actualFeedListCacheResult = new RSSConfig().feedListCache();

    // Assert
    assertTrue(actualFeedListCacheResult instanceof FeedListCacheImpl);
    assertTrue(actualFeedListCacheResult.getKnownFeeds().isEmpty());
  }

  /**
   * Test {@link RSSConfig#articleSender(ResponseHandlers, AllHistory)}.
   *
   * <p>Method under test: {@link RSSConfig#articleSender(ResponseHandlers, AllHistory)}
   */
  @Test
  @DisplayName("Test articleSender(ResponseHandlers, AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.tool.rssbot.alerter.ArticleSender RSSConfig.articleSender(ResponseHandlers, AllHistory)"
  })
  void testArticleSender() throws BeansException {
    // Arrange
    RSSConfig rssConfig = new RSSConfig();
    ResponseHandlers rh = mock(ResponseHandlers.class);

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    // Act and Assert
    assertTrue(rssConfig.articleSender(rh, h) instanceof CachingCheckingArticleSender);
  }
}
