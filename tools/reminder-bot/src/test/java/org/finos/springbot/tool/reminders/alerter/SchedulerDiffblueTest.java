package org.finos.springbot.tool.reminders.alerter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.tool.reminders.ReminderList;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Scheduler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class SchedulerDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private AllHistory allHistory;

  @MockitoBean private ResponseHandlers responseHandlers;

  @Autowired private Scheduler scheduler;

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<ReminderList> ofResult = Optional.of(new ReminderList());
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday2() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    // Act
    new Scheduler(responseHandlers, h, rooms).everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Given {@link AllHistory}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday(); given AllHistory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenAllHistory() {
    // Arrange
    when(allConversations.getAllChats()).thenReturn(new HashSet<>());

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(allConversations).getAllChats();
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       empty.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName(
      "Test everyFiveMinutesWeekday(); given AllHistory getLastFromHistory(Class, Addressable) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenAllHistoryGetLastFromHistoryReturnEmpty() {
    // Arrange
    Optional<ReminderList> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link SymphonyRoom#SymphonyRoom(String, String)}
   *       with {@code Name} and id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName(
      "Test everyFiveMinutesWeekday(); given HashSet() add SymphonyRoom(String, String) with 'Name' and id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenHashSetAddSymphonyRoomWithNameAndIdIs42() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("Name", "42"));
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(reminderList, atLeast(1)).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory, atLeast(1)).getLastFromHistory(isA(Class.class), Mockito.<Addressable>any());
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Given {@link ReminderList#ReminderList()} TimeZone is ofTotalSeconds one.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName(
      "Test everyFiveMinutesWeekday(); given ReminderList() TimeZone is ofTotalSeconds one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenReminderListTimeZoneIsOfTotalSecondsOne() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    reminderList.setTimeZone(ZoneOffset.ofTotalSeconds(1));
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Then calls {@link ReminderList#getReminders()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday(); then calls getReminders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_thenCallsGetReminders() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(reminderList).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName("Test onAllStreams(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);
    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName("Test onAllStreams(Consumer); given AllHistory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenAllHistory() {
    // Arrange
    when(allConversations.getAllChats()).thenReturn(new HashSet<>());

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(allConversations).getAllChats();
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       empty.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given AllHistory getLastFromHistory(Class, Addressable) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenAllHistoryGetLastFromHistoryReturnEmpty() {
    // Arrange
    Optional<ReminderList> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       of {@link ReminderList#ReminderList()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given AllHistory getLastFromHistory(Class, Addressable) return of ReminderList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenAllHistoryGetLastFromHistoryReturnOfReminderList() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<ReminderList> ofResult = Optional.of(new ReminderList());
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link SymphonyRoom#SymphonyRoom(String, String)}
   *       with {@code Name} and id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given HashSet() add SymphonyRoom(String, String) with 'Name' and id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenHashSetAddSymphonyRoomWithNameAndIdIs42() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("Name", "42"));
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(reminderList, atLeast(1)).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory, atLeast(1)).getLastFromHistory(isA(Class.class), Mockito.<Addressable>any());
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link ReminderList#ReminderList()} TimeZone is ofTotalSeconds one.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName("Test onAllStreams(Consumer); given ReminderList() TimeZone is ofTotalSeconds one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenReminderListTimeZoneIsOfTotalSecondsOne() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    reminderList.setTimeZone(ZoneOffset.ofTotalSeconds(1));
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link ReminderList#getReminders()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName("Test onAllStreams(Consumer); then calls getReminders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_thenCallsGetReminders() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.onAllStreams(scheduler::handleFeed);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(reminderList).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName("Test handleFeed(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    AllHistory h = new AllHistory();
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    new Scheduler(responseHandlers, h, new AllConversations()).handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       empty.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given AllHistory getLastFromHistory(Class, Addressable) return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenAllHistoryGetLastFromHistoryReturnEmpty() {
    // Arrange
    Optional<Object> emptyResult = Optional.empty();
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(emptyResult);

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       {@link Optional} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given AllHistory getLastFromHistory(Class, Addressable) return Optional with '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenAllHistoryGetLastFromHistoryReturnOptionalWith42() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> ofResult = Optional.of("42");
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       {@link Optional} with {@link ReminderList#ReminderList()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given AllHistory getLastFromHistory(Class, Addressable) return Optional with ReminderList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenAllHistoryGetLastFromHistoryReturnOptionalWithReminderList() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> ofResult = Optional.of(new ReminderList());
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ReminderList#ReminderList()} TimeZone is ofTotalSeconds one.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName("Test handleFeed(Addressable); given ReminderList() TimeZone is ofTotalSeconds one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenReminderListTimeZoneIsOfTotalSecondsOne() {
    // Arrange
    ReminderList reminderList = new ReminderList();
    reminderList.setTimeZone(ZoneOffset.ofTotalSeconds(1));
    Optional<Object> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Then calls {@link ReminderList#getReminders()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName("Test handleFeed(Addressable); then calls getReminders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_thenCallsGetReminders() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<Object> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(reminderList).getReminders();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }
}
