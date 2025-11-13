package org.finos.springbot.tool.reminders.alerter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Consumer;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.history.SymphonyHistoryImpl;
import org.finos.springbot.teams.content.TeamsChannel;
import org.finos.springbot.teams.history.StateStorageBasedTeamsHistory;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.tool.reminders.ReminderList;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.data.EntityJsonConverter;
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
import org.springframework.context.ApplicationContext;
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
    chatSet.add(new SymphonyRoom());
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
  void testEveryFiveMinutesWeekday2() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
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
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday3() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
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
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName("Test everyFiveMinutesWeekday()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday4() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(mock(ResponseHandlers.class), h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(rooms).getAllChats();
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testEveryFiveMinutesWeekday5() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc)));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(mock(ResponseHandlers.class), h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testEveryFiveMinutesWeekday6() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    Optional<ReminderList> ofResult = Optional.of(new ReminderList());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testEveryFiveMinutesWeekday7() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"TimedAlerter waking", "error"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(reminderList).getReminders();
    verify(rooms).getAllChats();
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testEveryFiveMinutesWeekday8() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    Optional<Object> ofResult2 = Optional.of("Value");
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult2);
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
    chatSet.add(new TeamsChannel());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(symphonyHistoryImpl, atLeast(1))
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(Mockito.<Addressable>any());
    verify(reminderList).getReminders();
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
    chatSet.add(new SymphonyRoom());
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
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       Bean}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName(
      "Test everyFiveMinutesWeekday(); given ApplicationContext getBean(String) return 'Bean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenApplicationContextGetBeanReturnBean()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn("Bean");
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#everyFiveMinutesWeekday()}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#everyFiveMinutesWeekday()}
   */
  @Test
  @DisplayName(
      "Test everyFiveMinutesWeekday(); given ApplicationContext getBean(String) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.everyFiveMinutesWeekday()"})
  void testEveryFiveMinutesWeekday_givenApplicationContextGetBeanReturnNull()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
    chatSet.add(new SymphonyRoom());
    when(allConversations.getAllChats()).thenReturn(chatSet);

    // Act
    scheduler.everyFiveMinutesWeekday();

    // Assert
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
  void testOnAllStreams() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
    chatSet.add(new SymphonyRoom("TimedAlerter waking", "42"));
    when(allConversations.getAllChats()).thenReturn(chatSet);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(reminderList, atLeast(1)).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory, atLeast(1)).getLastFromHistory(isA(Class.class), Mockito.<Addressable>any());
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
  void testOnAllStreams2() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(mock(ResponseHandlers.class), h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(rooms).getAllChats();
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testOnAllStreams3() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc)));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(mock(ResponseHandlers.class), h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testOnAllStreams4() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"TimedAlerter waking", "error"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(reminderList).getReminders();
    verify(rooms).getAllChats();
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testOnAllStreams5() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    Optional<Object> ofResult2 = Optional.of("Value");
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Object>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult2);
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
    chatSet.add(new TeamsChannel());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers, atLeast(1)).accept(Mockito.<Response>any());
    verify(symphonyHistoryImpl, atLeast(1))
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(Mockito.<Addressable>any());
    verify(reminderList).getReminders();
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

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
    chatSet.add(new SymphonyRoom());
    when(allConversations.getAllChats()).thenReturn(chatSet);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

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
    chatSet.add(new SymphonyRoom());
    when(allConversations.getAllChats()).thenReturn(chatSet);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       of {@link ReminderList}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given AllHistory getLastFromHistory(Class, Addressable) return of ReminderList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenAllHistoryGetLastFromHistoryReturnOfReminderList2() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenReturn(new ArrayList<>());
    Optional<ReminderList> ofResult = Optional.of(reminderList);
    when(allHistory.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());
    when(allConversations.getAllChats()).thenReturn(chatSet);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(reminderList).getReminders();
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       Bean}.
   *   <li>Then calls {@link ApplicationContext#getBean(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given ApplicationContext getBean(String) return 'Bean'; then calls getBean(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenApplicationContextGetBeanReturnBean_thenCallsGetBean()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn("Bean");
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       null}.
   *   <li>Then calls {@link ApplicationContext#getBean(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given ApplicationContext getBean(String) return 'null'; then calls getBean(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenApplicationContextGetBeanReturnNull_thenCallsGetBean()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
    chatSet.add(new SymphonyRoom());
    when(allConversations.getAllChats()).thenReturn(chatSet);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(allConversations).getAllChats();
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }

  /**
   * Test {@link Scheduler#onAllStreams(Consumer)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#getLastFromHistory(Class,
   *       SymphonyAddressable)} return of {@link ReminderList#ReminderList()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#onAllStreams(Consumer)}
   */
  @Test
  @DisplayName(
      "Test onAllStreams(Consumer); given SymphonyHistoryImpl getLastFromHistory(Class, SymphonyAddressable) return of ReminderList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.onAllStreams(Consumer)"})
  void testOnAllStreams_givenSymphonyHistoryImplGetLastFromHistoryReturnOfReminderList()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    Optional<ReminderList> ofResult = Optional.of(new ReminderList());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<ReminderList>>any(), Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    HashSet<Chat> chatSet = new HashSet<>();
    chatSet.add(new SymphonyRoom());

    AllConversations rooms = mock(AllConversations.class);
    when(rooms.getAllChats()).thenReturn(chatSet);

    Scheduler scheduler = new Scheduler(responseHandlers, h, rooms);
    Consumer<Addressable> action = scheduler::handleFeed;

    // Act
    scheduler.onAllStreams(action);

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(rooms).getAllChats();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
  void testHandleFeed2() throws BeansException {
    // Arrange
    ApplicationContext applicationContext = mock(ApplicationContext.class);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc)));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
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
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} return
   *       {@link Optional} with {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given AllHistory getLastFromHistory(Class, Addressable) return Optional with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenAllHistoryGetLastFromHistoryReturnOptionalWithValue() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> ofResult = Optional.of("Value");
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
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, Addressable)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given AllHistory getLastFromHistory(Class, Addressable) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenAllHistoryGetLastFromHistoryThrowRuntimeException() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenThrow(new RuntimeException());

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
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBeanNamesForType(Class)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given ApplicationContext getBeanNamesForType(Class) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenApplicationContextGetBeanNamesForTypeThrowRuntimeException()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       Bean}.
   *   <li>Then calls {@link ApplicationContext#getBean(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given ApplicationContext getBean(String) return 'Bean'; then calls getBean(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenApplicationContextGetBeanReturnBean_thenCallsGetBean()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn("Bean");
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} return {@code
   *       null}.
   *   <li>Then calls {@link ApplicationContext#getBean(String)}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given ApplicationContext getBean(String) return 'null'; then calls getBean(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenApplicationContextGetBeanReturnNull_thenCallsGetBean()
      throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(null);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBean(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given ApplicationContext getBean(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenApplicationContextGetBeanThrowRuntimeException() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenThrow(new RuntimeException());
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ReminderList} {@link ReminderList#getReminders()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName("Test handleFeed(Addressable); given ReminderList getReminders() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenReminderListGetRemindersReturnArrayList() {
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

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link ReminderList} {@link ReminderList#getReminders()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given ReminderList getReminders() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenReminderListGetRemindersThrowRuntimeException() {
    // Arrange
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    ReminderList reminderList = mock(ReminderList.class);
    when(reminderList.getReminders()).thenThrow(new RuntimeException());
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
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#isSupported(Addressable)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given SymphonyHistoryImpl isSupported(Addressable) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenSymphonyHistoryImplIsSupportedReturnFalse() throws BeansException {
    // Arrange
    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(false);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"error", "message"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(isA(Addressable.class));
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#isSupported(Addressable)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given SymphonyHistoryImpl isSupported(Addressable) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenSymphonyHistoryImplIsSupportedReturnTrue() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#isSupported(Addressable)}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName(
      "Test handleFeed(Addressable); given SymphonyHistoryImpl isSupported(Addressable) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_givenSymphonyHistoryImplIsSupportedReturnTrue2() throws BeansException {
    // Arrange
    ResponseHandlers responseHandlers = mock(ResponseHandlers.class);
    doNothing().when(responseHandlers).accept(Mockito.<Response>any());

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"error", "message"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    Scheduler scheduler = new Scheduler(responseHandlers, h, new AllConversations());

    // Act
    scheduler.handleFeed(mock(Addressable.class));

    // Assert
    verify(responseHandlers).accept(isA(Response.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link Scheduler#handleFeed(Addressable)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link Scheduler#handleFeed(Addressable)}
   */
  @Test
  @DisplayName("Test handleFeed(Addressable); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Scheduler.handleFeed(Addressable)"})
  void testHandleFeed_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(responseHandlers).accept(Mockito.<Response>any());
    Optional<Object> ofResult = Optional.of("Value");
    when(allHistory.getLastFromHistory(Mockito.<Class<Object>>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> scheduler.handleFeed(mock(Addressable.class)));
    verify(responseHandlers).accept(isA(Response.class));
    verify(allHistory).getLastFromHistory(isA(Class.class), isA(Addressable.class));
  }
}
