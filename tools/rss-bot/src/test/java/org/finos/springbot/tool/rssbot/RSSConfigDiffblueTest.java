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
import org.finos.springbot.tool.rssbot.alerter.FeedListCache;
import org.finos.springbot.tool.rssbot.alerter.FeedListCacheImpl;
import org.finos.springbot.workflow.actions.MemberAction;
import org.finos.springbot.workflow.actions.MemberAction.Type;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RSSConfigDiffblueTest {
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
  @MethodsUnderTest({
      "org.finos.springbot.workflow.welcome.RoomWelcomeEventConsumer org.finos.springbot.tool.rssbot.RSSConfig.rwec(org.finos.springbot.workflow.response.handlers.ResponseHandlers)"})
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
  @MethodsUnderTest({
      "org.finos.springbot.tool.rssbot.alerter.FeedListCache org.finos.springbot.tool.rssbot.RSSConfig.feedListCache()"})
  void testFeedListCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    FeedListCache actualFeedListCacheResult = (new RSSConfig()).feedListCache();

    // Assert
    assertTrue(actualFeedListCacheResult instanceof FeedListCacheImpl);
    assertTrue(actualFeedListCacheResult.getKnownFeeds().isEmpty());
  }
}
