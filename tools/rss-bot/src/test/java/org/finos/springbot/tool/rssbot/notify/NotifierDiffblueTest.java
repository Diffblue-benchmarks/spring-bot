package org.finos.springbot.tool.rssbot.notify;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.tool.rssbot.RSSProperties;
import org.finos.springbot.tool.rssbot.feed.SubscribeRequest;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
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

@ContextConfiguration(classes = {Notifier.class, RSSProperties.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class NotifierDiffblueTest {
  @Autowired private Notifier notifier;

  @Autowired private RSSProperties rSSProperties;

  @MockitoBean private ResponseHandlers responseHandlers;

  /**
   * Test {@link Notifier#sendSuccessNotification(SubscribeRequest, Addressable, User)}.
   *
   * <p>Method under test: {@link Notifier#sendSuccessNotification(SubscribeRequest, Addressable,
   * User)}
   */
  @Test
  @DisplayName("Test sendSuccessNotification(SubscribeRequest, Addressable, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Notifier.sendSuccessNotification(SubscribeRequest, Addressable, User)"})
  void testSendSuccessNotification() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);

    // Act
    notifier.sendSuccessNotification(sr, a, new SymphonyUser(1L));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link Notifier#sendFailureNotification(SubscribeRequest, Addressable, Exception, User)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code \n}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Notifier#sendFailureNotification(SubscribeRequest, Addressable,
   * Exception, User)}
   */
  @Test
  @DisplayName(
      "Test sendFailureNotification(SubscribeRequest, Addressable, Exception, User); when Exception(String) with '\\n'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Notifier.sendFailureNotification(SubscribeRequest, Addressable, Exception, User)"
  })
  void testSendFailureNotification_whenExceptionWithN_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    Exception e = new Exception("\\n");

    // Act
    notifier.sendFailureNotification(sr, a, e, new SymphonyUser(1L));

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
  }

  /**
   * Test {@link Notifier#sendFailureNotification(SubscribeRequest, Addressable, Exception, User)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then calls {@link ResponseHandlers#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link Notifier#sendFailureNotification(SubscribeRequest, Addressable,
   * Exception, User)}
   */
  @Test
  @DisplayName(
      "Test sendFailureNotification(SubscribeRequest, Addressable, Exception, User); when Exception(); then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Notifier.sendFailureNotification(SubscribeRequest, Addressable, Exception, User)"
  })
  void testSendFailureNotification_whenException_thenCallsAccept() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SubscribeRequest sr = new SubscribeRequest();
    sr.setName("Name");
    sr.setUrl("https://example.org/example");
    Addressable a = mock(Addressable.class);
    Exception e = new Exception();

    // Act
    notifier.sendFailureNotification(sr, a, e, new SymphonyUser(1L));

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
  }

  /**
   * Test new {@link Notifier} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Notifier}
   */
  @Test
  @DisplayName("Test new Notifier (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Notifier.<init>()"})
  void testNewNotifier() {
    // Arrange and Act
    Notifier actualNotifier = new Notifier();

    // Assert
    assertNull(actualNotifier.properties);
    assertNull(actualNotifier.rh);
  }
}
