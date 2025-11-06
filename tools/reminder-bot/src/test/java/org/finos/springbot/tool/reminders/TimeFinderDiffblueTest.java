package org.finos.springbot.tool.reminders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ErrorHandler;

@ContextConfiguration(classes = {TimeFinder.class, ReminderProperties.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
class TimeFinderDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @MockBean
  private AllHistory allHistory;

  @MockBean
  private ErrorHandler errorHandler;

  @Autowired
  private ReminderProperties reminderProperties;

  @MockBean
  private ResponseHandlers responseHandlers;

  @Autowired
  private TimeFinder timeFinder;

  /**
   * Test {@link TimeFinder#TimeFinder(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)}.
   * <p>
   * Method under test: {@link TimeFinder#TimeFinder(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)}
   */
  @Test
  @DisplayName("Test new TimeFinder(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TimeFinder.<init>(ErrorHandler, AllConversations, AllHistory, ReminderProperties, ResponseHandlers)"})
  void testNewTimeFinder() throws BeansException {
    // Arrange
    ErrorHandler errorHandler = mock(ErrorHandler.class);
    AllConversations rooms = new AllConversations();

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    ReminderProperties reminderProperties = new ReminderProperties();
    reminderProperties.setDefaultRemindBefore(1);
    ZoneOffset defaultTimeZone = ZoneOffset.ofTotalSeconds(1);
    reminderProperties.setDefaultTimeZone(defaultTimeZone);
    reminderProperties.setWelcomeMessage("Welcome Message");

    // Act and Assert
    ReminderProperties reminderProperties2 = (new TimeFinder(errorHandler, rooms, h, reminderProperties,
        mock(ResponseHandlers.class))).reminderProperties;
    ZoneId defaultTimeZone2 = reminderProperties2.getDefaultTimeZone();
    assertEquals("+00:00:01", defaultTimeZone2.toString());
    assertEquals("Welcome Message", reminderProperties2.getWelcomeMessage());
    assertEquals(1, reminderProperties2.getDefaultRemindBefore());
    assertSame(defaultTimeZone, defaultTimeZone2);
  }

  /**
   * Test {@link TimeFinder#initializingStanfordProperties()}.
   * <p>
   * Method under test: {@link TimeFinder#initializingStanfordProperties()}
   */
  @Test
  @DisplayName("Test initializingStanfordProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.initializingStanfordProperties()"})
  void testInitializingStanfordProperties() {
    // Arrange and Act
    timeFinder.initializingStanfordProperties();

    // Assert
    StanfordCoreNLP stanfordCoreNLP = timeFinder.stanfordCoreNLP;
    assertEquals("UTF-8", stanfordCoreNLP.getEncoding());
    Properties properties = stanfordCoreNLP.getProperties();
    assertEquals(2, properties.size());
    assertEquals("tokenize,pos,lemma,ner", properties.get("annotators"));
    String expectedString = Boolean.TRUE.toString();
    assertEquals(expectedString, properties.get("ner.docdate.usePresent"));
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code 1st}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return '1st'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn1st_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("1st");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code '99}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return ''99'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn99_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("'99");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code 0999}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return '0999'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn0999_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("0999");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code 999999T999999,999+9999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return '999999T999999,999+9999'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn999999t9999999999999() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("999999T999999,999+9999");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code 9999-99-99}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return '9999-99-99'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn99999999_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("9999-99-99");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code 9,999,999.9}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return '9,999,999.9'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturn99999999_thenCallsGetText2() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("9,999,999.9");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code Text}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return 'Text'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturnText_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("Text");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#getText()} return {@code zero-zero}.</li>
   *   <li>Then calls {@link Content#getText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given Content getText() return 'zero-zero'; then calls getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenContentGetTextReturnZeroZero_thenCallsGetText() {
    // Arrange
    Content content = mock(Content.class);
    when(content.getText()).thenReturn("zero-zero");

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);
    MessageImpl messageImpl = new MessageImpl(c);
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(messageImpl);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(content).getText();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Given {@link Message.MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; given MessageImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_givenMessageImplWithCIsArrayList() {
    // Arrange
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(new MessageImpl(new ArrayList<>()));
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
  }

  /**
   * Test {@link TimeFinder#accept(Action)} with {@code Action}.
   * <ul>
   *   <li>Then calls {@link ErrorHandler#handleError(Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeFinder#accept(Action)}
   */
  @Test
  @DisplayName("Test accept(Action) with 'Action'; then calls handleError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TimeFinder.accept(Action)"})
  void testAcceptWithAction_thenCallsHandleError() {
    // Arrange
    doNothing().when(errorHandler).handleError(Mockito.<Throwable>any());
    SimpleMessageAction t = mock(SimpleMessageAction.class);
    when(t.getAddressable()).thenReturn(mock(Addressable.class));
    when(t.getMessage()).thenReturn(null);
    when(t.getUser()).thenReturn(new SymphonyUser(1L));

    // Act
    timeFinder.accept(t);

    // Assert
    verify(t).getAddressable();
    verify(t).getMessage();
    verify(t).getUser();
    verify(errorHandler).handleError(isA(Throwable.class));
  }
}
