package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyAddressable;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.symphony.history.SymphonyHistoryImpl;
import org.finos.springbot.teams.history.StateStorageBasedTeamsHistory;
import org.finos.springbot.teams.state.MemoryStateStorage;
import org.finos.springbot.tool.poll.poll.PollCreateForm.TimeUnit;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.data.EntityJsonConverter;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PollController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class PollControllerDiffblueTest {
  @MockitoBean private AllConversations allConversations;

  @MockitoBean private AllHistory allHistory;

  @Autowired private PollController pollController;

  @MockitoBean private ResponseHandlers responseHandlers;

  @MockitoBean private TaskScheduler taskScheduler;

  /**
   * Test {@link PollController#pollForm(Chat)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  @DisplayName("Test pollForm(Chat); when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PollCreateForm PollController.pollForm(Chat)"})
  void testPollForm_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new PollController().pollForm(null));
  }

  /**
   * Test {@link PollController#pollForm(Chat)}.
   *
   * <ul>
   *   <li>When {@link SymphonyRoom#SymphonyRoom()}.
   *   <li>Then return Option1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  @DisplayName("Test pollForm(Chat); when SymphonyRoom(); then return Option1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PollCreateForm PollController.pollForm(Chat)"})
  void testPollForm_whenSymphonyRoom_thenReturnOption1IsNull() {
    // Arrange
    PollController pollController = new PollController();

    // Act
    PollCreateForm actualPollFormResult = pollController.pollForm(new SymphonyRoom());

    // Assert
    assertNull(actualPollFormResult.getOption1());
    assertNull(actualPollFormResult.getOption2());
    assertNull(actualPollFormResult.getOption3());
    assertNull(actualPollFormResult.getOption4());
    assertNull(actualPollFormResult.getOption5());
    assertNull(actualPollFormResult.getOption6());
    assertNull(actualPollFormResult.getQuestion());
    assertEquals(15, actualPollFormResult.getTime().intValue());
    assertEquals(TimeUnit.MINUTES, actualPollFormResult.getTimeUnit());
    assertTrue(actualPollFormResult.isEndAutomatically());
  }

  /**
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link PollCreateForm} (default constructor) EndAutomatically is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); given 'false'; when PollCreateForm (default constructor) EndAutomatically is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_givenFalse_whenPollCreateFormEndAutomaticallyIsFalse() {
    // Arrange
    PollController pollController = new PollController();

    PollCreateForm cf = new PollCreateForm();
    cf.setOption1("Option1");
    cf.setOption2("Option2");
    cf.setOption3("Option3");
    cf.setOption4("Option4");
    cf.setOption5("Option5");
    cf.setOption6("Option6");
    cf.setQuestion("Question");
    cf.setTime(1);
    cf.setEndAutomatically(false);
    cf.setTimeUnit(TimeUnit.MINUTES);
    SymphonyRoom r = new SymphonyRoom();

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser());

    // Assert
    assertEquals(2, actualPollResult.size());
    DataResponse getResult = actualPollResult.get(0);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    DataResponse getResult2 = actualPollResult.get(1);
    assertTrue(((WorkResponse) getResult2).getFormObject() instanceof Question);
    assertTrue(((MessageResponse) getResult).getMessage() instanceof MessageImpl);
    assertTrue(getResult instanceof MessageResponse);
    assertTrue(getResult2 instanceof WorkResponse);
    assertEquals("question", getResult2.getTemplateName());
    assertNull(getResult.getTemplateName());
    Map<String, Object> data = getResult2.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult2).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    assertTrue(getResult.getData().isEmpty());
    Class<Question> expectedFormClass = Question.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult2).getFormClass());
    assertSame(r, address);
    assertSame(r, getResult2.getAddress());
  }

  /**
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PollCreateForm} (default constructor) TimeUnit is {@code null}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); given 'null'; when PollCreateForm (default constructor) TimeUnit is 'null'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_givenNull_whenPollCreateFormTimeUnitIsNull_thenReturnSizeIsTwo() {
    // Arrange
    PollController pollController = new PollController();

    PollCreateForm cf = new PollCreateForm();
    cf.setEndAutomatically(true);
    cf.setOption1("Option1");
    cf.setOption2("Option2");
    cf.setOption3("Option3");
    cf.setOption4("Option4");
    cf.setOption5("Option5");
    cf.setOption6("Option6");
    cf.setQuestion("Question");
    cf.setTime(1);
    cf.setTimeUnit(null);
    SymphonyRoom r = new SymphonyRoom();

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser());

    // Assert
    assertEquals(2, actualPollResult.size());
    DataResponse getResult = actualPollResult.get(0);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    DataResponse getResult2 = actualPollResult.get(1);
    assertTrue(((WorkResponse) getResult2).getFormObject() instanceof Question);
    assertTrue(((MessageResponse) getResult).getMessage() instanceof MessageImpl);
    assertTrue(getResult instanceof MessageResponse);
    assertTrue(getResult2 instanceof WorkResponse);
    assertEquals("question", getResult2.getTemplateName());
    assertNull(getResult.getTemplateName());
    Map<String, Object> data = getResult2.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult2).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    assertTrue(getResult.getData().isEmpty());
    Class<Question> expectedFormClass = Question.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult2).getFormClass());
    assertSame(r, address);
    assertSame(r, getResult2.getAddress());
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName("Test end(Word, Chat, AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd() throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    JsonMapper om = JsonMapper.builder().findAndAddModules().build();
    EntityJsonConverter ejc = new EntityJsonConverter(om, new ArrayList<>());
    when(applicationContext.getBean(Mockito.<String>any()))
        .thenReturn(new StateStorageBasedTeamsHistory(new MemoryStateStorage(ejc)));
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, h));
    verify(pollId).getText();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName("Test end(Word, Chat, AllHistory)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd2() throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    Question question = new Question();
    question.setOptions(new ArrayList<>());
    Optional<Question> ofResult = Optional.of(question);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any(),
            Mockito.<Instant>any()))
        .thenReturn(new ArrayList<>());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Question>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"foo", "42"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act
    Result actualEndResult = pollController.end(pollId, r, h);

    // Assert
    verify(symphonyHistoryImpl, atLeast(1))
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(SymphonyAddressable.class), isNull());
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), eq("Text-q"), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(isA(Addressable.class));
    verify(pollId, atLeast(1)).getText();
    verify(applicationContext, atLeast(1)).getBean(Mockito.<String>any());
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertNull(actualEndResult.getQuestion());
    assertNull(actualEndResult.getPoller());
    assertEquals(0, actualEndResult.getTotalResponses().intValue());
    assertTrue(actualEndResult.getCounts().isEmpty());
    assertTrue(actualEndResult.getOptions().isEmpty());
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getFromHistory(Class, String, Addressable,
   *       Instant)} return {@link ArrayList#ArrayList()}.
   *   <li>Then return Question is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given AllHistory getFromHistory(Class, String, Addressable, Instant) return ArrayList(); then return Question is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenAllHistoryGetFromHistoryReturnArrayList_thenReturnQuestionIsNull() {
    // Arrange
    Question question = new Question();
    question.setOptions(new ArrayList<>());
    Optional<Question> ofResult = Optional.of(question);
    when(allHistory.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Instant>any()))
        .thenReturn(new ArrayList<>());
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Question>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");

    // Act
    Result actualEndResult = pollController.end(pollId, new SymphonyRoom(), allHistory);

    // Assert
    verify(pollId, atLeast(1)).getText();
    verify(allHistory)
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), isNull());
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
    assertNull(actualEndResult.getQuestion());
    assertNull(actualEndResult.getPoller());
    assertEquals(0, actualEndResult.getTotalResponses().intValue());
    assertTrue(actualEndResult.getCounts().isEmpty());
    assertTrue(actualEndResult.getOptions().isEmpty());
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getFromHistory(Class, String, Addressable,
   *       Instant)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given AllHistory getFromHistory(Class, String, Addressable, Instant) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenAllHistoryGetFromHistoryThrowRuntimeException() {
    // Arrange
    when(allHistory.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Instant>any()))
        .thenThrow(new RuntimeException());
    Optional<Question> ofResult = Optional.of(new Question());
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Question>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> pollController.end(pollId, new SymphonyRoom(), allHistory));
    verify(pollId, atLeast(1)).getText();
    verify(allHistory)
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), isNull());
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getLastFromHistory(Class, String,
   *       Addressable)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given AllHistory getLastFromHistory(Class, String, Addressable) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenAllHistoryGetLastFromHistoryThrowRuntimeException() {
    // Arrange
    when(allHistory.getLastFromHistory(
            Mockito.<Class<Question>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenThrow(new RuntimeException());

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> pollController.end(pollId, new SymphonyRoom(), allHistory));
    verify(pollId).getText();
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link AllHistory}.
   *   <li>When {@link Word} {@link Word#getText()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given AllHistory; when Word getText() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenAllHistory_whenWordGetTextThrowRuntimeException() {
    // Arrange
    Word pollId = mock(Word.class);
    when(pollId.getText()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> pollController.end(pollId, new SymphonyRoom(), allHistory));
    verify(pollId).getText();
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationContext} {@link ApplicationContext#getBeanNamesForType(Class)}
   *       return empty array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given ApplicationContext getBeanNamesForType(Class) return empty array of String")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenApplicationContextGetBeanNamesForTypeReturnEmptyArrayOfString()
      throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, h));
    verify(pollId).getText();
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given ArrayList() add 'foo'; then return Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenArrayListAddFoo_thenReturnOptionsSizeIsOne() throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");

    Question question = new Question();
    question.setOptions(options);
    Optional<Question> ofResult = Optional.of(question);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any(),
            Mockito.<Instant>any()))
        .thenReturn(new ArrayList<>());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Question>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act
    Result actualEndResult = pollController.end(pollId, r, h);

    // Assert
    verify(symphonyHistoryImpl)
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(SymphonyAddressable.class), isNull());
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), eq("Text-q"), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(isA(Addressable.class));
    verify(pollId, atLeast(1)).getText();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    List<String> options2 = actualEndResult.getOptions();
    assertEquals(1, options2.size());
    assertEquals("foo", options2.get(0));
    List<Integer> counts = actualEndResult.getCounts();
    assertEquals(1, counts.size());
    assertEquals(0, counts.get(0).intValue());
    assertSame(options, options2);
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#getFromHistory(Class,
   *       String, SymphonyAddressable, Instant)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given SymphonyHistoryImpl getFromHistory(Class, String, SymphonyAddressable, Instant) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenSymphonyHistoryImplGetFromHistoryThrowRuntimeException() throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any(),
            Mockito.<Instant>any()))
        .thenThrow(new RuntimeException());
    Optional<Question> ofResult = Optional.of(new Question());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Question>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, h));
    verify(symphonyHistoryImpl)
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(SymphonyAddressable.class), isNull());
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), eq("Text-q"), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(isA(Addressable.class));
    verify(pollId, atLeast(1)).getText();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link SymphonyHistoryImpl} {@link SymphonyHistoryImpl#getLastFromHistory(Class,
   *       String, SymphonyAddressable)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given SymphonyHistoryImpl getLastFromHistory(Class, String, SymphonyAddressable) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenSymphonyHistoryImplGetLastFromHistoryThrowRuntimeException()
      throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Question>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any()))
        .thenThrow(new RuntimeException());
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, h));
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), eq("Text-q"), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl).isSupported(isA(Addressable.class));
    verify(pollId).getText();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Then return Question is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName("Test end(Word, Chat, AllHistory); then return Question is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_thenReturnQuestionIsNull() throws BeansException {
    // Arrange
    PollController pollController = new PollController();

    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom();

    Question question = new Question();
    question.setOptions(new ArrayList<>());
    Optional<Question> ofResult = Optional.of(question);

    SymphonyHistoryImpl symphonyHistoryImpl = mock(SymphonyHistoryImpl.class);
    when(symphonyHistoryImpl.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any(),
            Mockito.<Instant>any()))
        .thenReturn(new ArrayList<>());
    when(symphonyHistoryImpl.getLastFromHistory(
            Mockito.<Class<Question>>any(),
            Mockito.<String>any(),
            Mockito.<SymphonyAddressable>any()))
        .thenReturn(ofResult);
    when(symphonyHistoryImpl.isSupported(Mockito.<Addressable>any())).thenReturn(true);

    ApplicationContext applicationContext = mock(ApplicationContext.class);
    when(applicationContext.getBean(Mockito.<String>any())).thenReturn(symphonyHistoryImpl);
    when(applicationContext.getBeanNamesForType(Mockito.<Class<?>>any()))
        .thenReturn(new String[] {"Bean Names For Type"});

    AllHistory h = new AllHistory();
    h.setApplicationContext(applicationContext);

    // Act
    Result actualEndResult = pollController.end(pollId, r, h);

    // Assert
    verify(symphonyHistoryImpl)
        .getFromHistory(isA(Class.class), eq("Text-a"), isA(SymphonyAddressable.class), isNull());
    verify(symphonyHistoryImpl)
        .getLastFromHistory(isA(Class.class), eq("Text-q"), isA(SymphonyAddressable.class));
    verify(symphonyHistoryImpl, atLeast(1)).isSupported(isA(Addressable.class));
    verify(pollId, atLeast(1)).getText();
    verify(applicationContext).getBean("Bean Names For Type");
    verify(applicationContext).getBeanNamesForType(isA(Class.class));
    assertNull(actualEndResult.getQuestion());
    assertNull(actualEndResult.getPoller());
    assertEquals(0, actualEndResult.getTotalResponses().intValue());
    assertTrue(actualEndResult.getCounts().isEmpty());
    assertTrue(actualEndResult.getOptions().isEmpty());
  }

  /**
   * Test {@link PollController#poll0(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll0(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll0(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll0(User, Question, Chat)"})
  void testPoll0_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll0Result = pollController.poll0(u, q, c);

    // Assert
    ButtonList buttons = actualPoll0Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll0Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll0Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll0Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll0Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, ((Answer) formObject).getChoice().intValue());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, actualPoll0Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll0Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll1(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll1(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll1(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll1(User, Question, Chat)"})
  void testPoll1_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll1Result = pollController.poll1(u, q, c);

    // Assert
    ButtonList buttons = actualPoll1Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll1Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll1Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll1Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll1Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(1, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll1Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll1Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll2(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll2(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll2(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll2(User, Question, Chat)"})
  void testPoll2_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll2Result = pollController.poll2(u, q, c);

    // Assert
    ButtonList buttons = actualPoll2Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll2Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll2Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll2Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll2Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(2, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll2Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll2Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll3(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll3(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll3(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll3(User, Question, Chat)"})
  void testPoll3_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll3Result = pollController.poll3(u, q, c);

    // Assert
    ButtonList buttons = actualPoll3Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll3Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll3Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll3Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll3Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(3, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll3Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll3Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll4(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll4(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll4(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll4(User, Question, Chat)"})
  void testPoll4_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll4Result = pollController.poll4(u, q, c);

    // Assert
    ButtonList buttons = actualPoll4Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll4Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll4Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll4Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll4Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(4, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll4Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll4Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll5(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll5(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll5(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll5(User, Question, Chat)"})
  void testPoll5_givenOptions_whenArrayListAddOptions_thenButtonsContentsReturnList() {
    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser();

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser());
    SymphonyRoom c = new SymphonyRoom();

    // Act
    WorkResponse actualPoll5Result = pollController.poll5(u, q, c);

    // Assert
    ButtonList buttons = actualPoll5Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = actualPoll5Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Object formObject = actualPoll5Result.getFormObject();
    User user = ((Answer) formObject).getUser();
    assertTrue(user instanceof SymphonyUser);
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll5Result.getData();
    assertEquals(4, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(data.get("header") instanceof HeaderDetails);
    assertEquals("Options", ((Answer) formObject).getChoiceText());
    assertEquals("Question", ((Answer) formObject).getQuestionText());
    assertEquals("answer", actualPoll5Result.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(5, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll5Result.getMode());
    assertTrue(contents.isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll5Result.getFormClass());
    assertSame(c, address);
    assertSame(u, user);
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }
}
