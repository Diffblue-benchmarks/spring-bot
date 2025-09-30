package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Properties;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.actions.Action;
import org.finos.springbot.workflow.actions.SimpleMessageAction;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {TimeFinder.class, ReminderProperties.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class TimeFinderDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private AllHistory allHistory;

  @MockitoBean private ErrorHandler errorHandler;

  @Autowired private ReminderProperties reminderProperties;

  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private TimeFinder timeFinder;

  @InjectMocks private TimeFinder timeFinder2;

  /**
   * Test {@link TimeFinder#TimeFinder(ErrorHandler, AllConversations, AllHistory,
   * ReminderProperties, ResponseHandlers)}.
   *
   * <p>Method under test: {@link TimeFinder#TimeFinder(ErrorHandler, AllConversations, AllHistory,
   * ReminderProperties, ResponseHandlers)}
   */
  @Test
  @DisplayName(
      "Test new TimeFinder(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimeFinder.<init>(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)"
  })
  void testNewTimeFinder() throws BeansException {
    // Arrange
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    AllConversations rooms = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    ReminderProperties reminderProperties = new ReminderProperties();
    reminderProperties.setDefaultRemindBefore(1);
    ZoneOffset defaultTimeZone = ZoneOffset.ofTotalSeconds(1);
    reminderProperties.setDefaultTimeZone(defaultTimeZone);
    reminderProperties.setWelcomeMessage("Welcome Message");

    // Act
    TimeFinder actualTimeFinder =
        new TimeFinder(errorHandler, rooms, h, reminderProperties, mock(ResponseHandlers.class));

    // Assert
    ReminderProperties reminderProperties2 = actualTimeFinder.reminderProperties;
    ZoneId defaultTimeZone2 = reminderProperties2.getDefaultTimeZone();
    assertEquals("+00:00:01", defaultTimeZone2.toString());
    assertEquals("Welcome Message", reminderProperties2.getWelcomeMessage());
    assertEquals(1, reminderProperties2.getDefaultRemindBefore());
    assertSame(defaultTimeZone, defaultTimeZone2);
  }

  /**
   * Test {@link TimeFinder#initializingStanfordProperties()}.
   *
   * <p>Method under test: {@link TimeFinder#initializingStanfordProperties()}
   */
  @Test
  @DisplayName("Test initializingStanfordProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.initializingStanfordProperties()"})
  void testInitializingStanfordProperties() {
    // Arrange and Act
    timeFinder2.initializingStanfordProperties();

    // Assert
    StanfordCoreNLP stanfordCoreNLP = timeFinder2.stanfordCoreNLP;
    assertEquals("UTF-8", stanfordCoreNLP.getEncoding());
    Properties properties = stanfordCoreNLP.getProperties();
    assertEquals(2, properties.size());
    assertEquals("tokenize,pos,lemma,ner", properties.get("annotators"));
    assertEquals(Boolean.TRUE.toString(), properties.get("ner.docdate.usePresent"));
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Message} {@link Message#getText()} return {@code 42}.
   *   <li>Then calls {@link Message#getText()}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName(
      "Test accept(Action) with 'Action'; given '42'; when Message getText() return '42'; then calls getText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_given42_whenMessageGetTextReturn42_thenCallsGetText() {
    // Arrange
    Message words = mock(Message.class);
    when(words.getText()).thenReturn("42");
    Addressable a = mock(Addressable.class);

    SimpleMessageAction t = new SimpleMessageAction(a, new SymphonyUser(1L), words, "Ej");

    // Act
    timeFinder.accept(t);

    // Assert
    verify(words).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} (default constructor) ApplicationContext is {@link
   *       ApplicationContext}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName(
      "Test accept(Action) with 'Action'; given AllHistory (default constructor) ApplicationContext is ApplicationContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenAllHistoryApplicationContextIsApplicationContext()
      throws BeansException {
    // Arrange
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    ReminderProperties reminderProperties = new ReminderProperties();
    reminderProperties.setDefaultRemindBefore(1);
    reminderProperties.setDefaultTimeZone(ZoneOffset.ofTotalSeconds(1));
    reminderProperties.setWelcomeMessage("Welcome Message");

    TimeFinder timeFinder =
        new TimeFinder(
            errorHandler,
            new AllConversations(),
            h,
            reminderProperties,
            mock(ResponseHandlers.class));
    Addressable a = mock(Addressable.class);
    SymphonyUser u = new SymphonyUser(1L);

    SimpleMessageAction t = new SimpleMessageAction(a, u, new MessageImpl(new ArrayList<>()), "Ej");

    // Act
    timeFinder.accept(t);

    // Assert
    verify(errorHandler).handleError(isA(Throwable.class));
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.
   *   <li>Then calls {@link Content#getText()}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName(
      "Test accept(Action) with 'Action'; given Content getText() return 'Text'; then calls getText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturnText_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl words = new MessageImpl(c);
    Addressable a = mock(Addressable.class);

    SimpleMessageAction t = new SimpleMessageAction(a, new SymphonyUser(1L), words, "Ej");

    // Act
    timeFinder.accept(t);

    // Assert
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link Content#getText()}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName(
      "Test accept(Action) with 'Action'; given Content getText() throw RuntimeException(); then calls getText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextThrowRuntimeException_thenCallsGetText() {
    // Arrange
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    Content content = mock(Content.class);
    when(content.getText()).thenThrow(new RuntimeException());

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl words = new MessageImpl(c);
    Addressable a = mock(Addressable.class);

    SimpleMessageAction t = new SimpleMessageAction(a, new SymphonyUser(1L), words, "Ej");

    // Act
    timeFinder.accept(t);

    // Assert
    verify(content).getText();
    verify(errorHandler).handleError(isA(Throwable.class));
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link SimpleMessageAction#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName(
      "Test accept(Action) with 'Action'; given RuntimeException(); then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenRuntimeException_thenCallsGetMessage() throws BeansException {
    // Arrange
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());

    AllHistory h = new AllHistory();
    h.setApplicationContext(mock(ApplicationContext.class));

    ReminderProperties reminderProperties = new ReminderProperties();
    reminderProperties.setDefaultRemindBefore(1);
    reminderProperties.setDefaultTimeZone(ZoneOffset.ofTotalSeconds(1));
    reminderProperties.setWelcomeMessage("Welcome Message");

    TimeFinder timeFinder =
        new TimeFinder(
            errorHandler,
            new AllConversations(),
            h,
            reminderProperties,
            mock(ResponseHandlers.class));

    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getMessage()).thenThrow(new RuntimeException());

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getMessage();
    verify(errorHandler).handleError(isA(Throwable.class));
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(errorHandler).handleError(Mockito.<Throwable>any());

    Content content = mock(Content.class);
    when(content.getText()).thenThrow(new RuntimeException());

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl words = new MessageImpl(c);
    Addressable a = mock(Addressable.class);

    SimpleMessageAction t = new SimpleMessageAction(a, new SymphonyUser(1L), words, "Ej");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> timeFinder.accept(t));
    verify(content).getText();
    verify(errorHandler).handleError(isA(Throwable.class));
  }
}
