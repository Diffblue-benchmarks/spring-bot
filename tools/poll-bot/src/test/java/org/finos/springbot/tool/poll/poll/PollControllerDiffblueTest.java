package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.tool.poll.poll.PollCreateForm.TimeUnit;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PollController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PollControllerDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @MockBean
  private AllHistory allHistory;

  @Autowired
  private PollController pollController;

  @MockBean
  private ResponseHandlers responseHandlers;

  @MockBean
  private TaskScheduler taskScheduler;

  /**
   * Test {@link PollController#pollForm(Chat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  @DisplayName("Test pollForm(Chat); when 'null'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.poll.poll.PollCreateForm org.finos.springbot.tool.poll.poll.PollController.pollForm(org.finos.springbot.workflow.content.Chat)"})
  void testPollForm_whenNull_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new PollController()).pollForm(null));
  }

  /**
   * Test {@link PollController#pollForm(Chat)}.
   * <ul>
   *   <li>When {@link SymphonyRoom#SymphonyRoom(String, String)} with {@code Name} and id is {@code 42}.</li>
   *   <li>Then return Option1 is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  @DisplayName("Test pollForm(Chat); when SymphonyRoom(String, String) with 'Name' and id is '42'; then return Option1 is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.poll.poll.PollCreateForm org.finos.springbot.tool.poll.poll.PollController.pollForm(org.finos.springbot.workflow.content.Chat)"})
  void testPollForm_whenSymphonyRoomWithNameAndIdIs42_thenReturnOption1IsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();

    // Act
    PollCreateForm actualPollFormResult = pollController.pollForm(new SymphonyRoom("Name", "42"));

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
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return second Buttons Contents size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName("Test poll(PollCreateForm, Chat, User); given 'false'; then return second Buttons Contents size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.tool.poll.poll.PollController.poll(org.finos.springbot.tool.poll.poll.PollCreateForm, org.finos.springbot.workflow.content.Chat, org.finos.springbot.workflow.content.User)"})
  void testPoll_givenFalse_thenReturnSecondButtonsContentsSizeIsSix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    cf.setTimeUnit(TimeUnit.MINUTES);
    cf.setEndAutomatically(false);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser(1L));

    // Assert
    assertEquals(2, actualPollResult.size());
    DataResponse getResult = actualPollResult.get(1);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertEquals(6, contents.size());
    assertTrue(contents instanceof List);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof Question);
    assertTrue(getResult instanceof WorkResponse);
    Map<String, Object> data = getResult.getData();
    assertEquals(4, data.size());
    assertEquals(6, ((Question) formObject).getOptions().size());
    assertEquals(6, buttons.size());
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("header"));
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return second Buttons size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName("Test poll(PollCreateForm, Chat, User); given 'null'; then return second Buttons size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.tool.poll.poll.PollController.poll(org.finos.springbot.tool.poll.poll.PollCreateForm, org.finos.springbot.workflow.content.Chat, org.finos.springbot.workflow.content.User)"})
  void testPoll_givenNull_thenReturnSecondButtonsSizeIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.getTimeUnit()).thenReturn(null);
    when(cf.isEndAutomatically()).thenReturn(true);
    when(cf.getQuestion()).thenReturn("Question");
    doNothing().when(cf).setEndAutomatically(anyBoolean());
    doNothing().when(cf).setOption1(Mockito.<String>any());
    doNothing().when(cf).setOption2(Mockito.<String>any());
    doNothing().when(cf).setOption3(Mockito.<String>any());
    doNothing().when(cf).setOption4(Mockito.<String>any());
    doNothing().when(cf).setOption5(Mockito.<String>any());
    doNothing().when(cf).setOption6(Mockito.<String>any());
    doNothing().when(cf).setQuestion(Mockito.<String>any());
    doNothing().when(cf).setTime(Mockito.<Integer>any());
    doNothing().when(cf).setTimeUnit(Mockito.<TimeUnit>any());
    cf.setEndAutomatically(true);
    cf.setOption1("Option1");
    cf.setOption2("Option2");
    cf.setOption3("Option3");
    cf.setOption4("Option4");
    cf.setOption5("Option5");
    cf.setOption6("Option6");
    cf.setQuestion("Question");
    cf.setTime(1);
    cf.setTimeUnit(TimeUnit.MINUTES);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser(1L));

    // Assert
    verify(cf).getQuestion();
    verify(cf).getTimeUnit();
    verify(cf).isEndAutomatically();
    verify(cf).setEndAutomatically(eq(true));
    verify(cf).setOption1(eq("Option1"));
    verify(cf).setOption2(eq("Option2"));
    verify(cf).setOption3(eq("Option3"));
    verify(cf).setOption4(eq("Option4"));
    verify(cf).setOption5(eq("Option5"));
    verify(cf).setOption6(eq("Option6"));
    verify(cf).setQuestion(eq("Question"));
    verify(cf).setTime(eq(1));
    verify(cf).setTimeUnit(eq(TimeUnit.MINUTES));
    assertEquals(2, actualPollResult.size());
    DataResponse getResult = actualPollResult.get(1);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof Question);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals(0, buttons.size());
    Map<String, Object> data = getResult.getData();
    assertEquals(4, data.size());
    assertTrue(contents.isEmpty());
    assertTrue(((Question) formObject).getOptions().isEmpty());
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("header"));
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName("Test poll(PollCreateForm, Chat, User); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List org.finos.springbot.tool.poll.poll.PollController.poll(org.finos.springbot.tool.poll.poll.PollCreateForm, org.finos.springbot.workflow.content.Chat, org.finos.springbot.workflow.content.User)"})
  void testPoll_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.getTime()).thenThrow(new RuntimeException("foo"));
    when(cf.getTimeUnit()).thenReturn(TimeUnit.MINUTES);
    when(cf.isEndAutomatically()).thenReturn(true);
    when(cf.getQuestion()).thenReturn("Question");
    doNothing().when(cf).setEndAutomatically(anyBoolean());
    doNothing().when(cf).setOption1(Mockito.<String>any());
    doNothing().when(cf).setOption2(Mockito.<String>any());
    doNothing().when(cf).setOption3(Mockito.<String>any());
    doNothing().when(cf).setOption4(Mockito.<String>any());
    doNothing().when(cf).setOption5(Mockito.<String>any());
    doNothing().when(cf).setOption6(Mockito.<String>any());
    doNothing().when(cf).setQuestion(Mockito.<String>any());
    doNothing().when(cf).setTime(Mockito.<Integer>any());
    doNothing().when(cf).setTimeUnit(Mockito.<TimeUnit>any());
    cf.setEndAutomatically(true);
    cf.setOption1("Option1");
    cf.setOption2("Option2");
    cf.setOption3("Option3");
    cf.setOption4("Option4");
    cf.setOption5("Option5");
    cf.setOption6("Option6");
    cf.setQuestion("Question");
    cf.setTime(1);
    cf.setTimeUnit(TimeUnit.MINUTES);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.poll(cf, r, new SymphonyUser(1L)));
    verify(cf).getQuestion();
    verify(cf).getTime();
    verify(cf).getTimeUnit();
    verify(cf).isEndAutomatically();
    verify(cf).setEndAutomatically(eq(true));
    verify(cf).setOption1(eq("Option1"));
    verify(cf).setOption2(eq("Option2"));
    verify(cf).setOption3(eq("Option3"));
    verify(cf).setOption4(eq("Option4"));
    verify(cf).setOption5(eq("Option5"));
    verify(cf).setOption6(eq("Option6"));
    verify(cf).setQuestion(eq("Question"));
    verify(cf).setTime(eq(1));
    verify(cf).setTimeUnit(eq(TimeUnit.MINUTES));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   * <ul>
   *   <li>Given {@link AllHistory} {@link AllHistory#getFromHistory(Class, String, Addressable, Instant)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName("Test end(Word, Chat, AllHistory); given AllHistory getFromHistory(Class, String, Addressable, Instant) throw RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.poll.poll.Result org.finos.springbot.tool.poll.poll.PollController.end(org.finos.springbot.workflow.content.Word, org.finos.springbot.workflow.content.Chat, org.finos.springbot.workflow.history.AllHistory)"})
  void testEnd_givenAllHistoryGetFromHistoryThrowRuntimeExceptionWithFoo() throws BeansException {
    // Arrange
    when(allHistory.getFromHistory(Mockito.<Class<Answer>>any(), Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Instant>any())).thenThrow(new RuntimeException("foo"));
    Optional<Question> ofResult = Optional.of(new Question());
    when(allHistory.getLastFromHistory(Mockito.<Class<Question>>any(), Mockito.<String>any(),
        Mockito.<Addressable>any())).thenReturn(ofResult);
    doNothing().when(allHistory).setApplicationContext(Mockito.<ApplicationContext>any());
    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    allHistory.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, allHistory));
    verify(pollId, atLeast(1)).getText();
    verify(allHistory).getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), (Instant) isNull());
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
    verify(allHistory).setApplicationContext(isA(ApplicationContext.class));
  }

  /**
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   * <ul>
   *   <li>Given {@link Question#Question()} Options is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Question is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName("Test end(Word, Chat, AllHistory); given Question() Options is ArrayList(); then return Question is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.tool.poll.poll.Result org.finos.springbot.tool.poll.poll.PollController.end(org.finos.springbot.workflow.content.Word, org.finos.springbot.workflow.content.Chat, org.finos.springbot.workflow.history.AllHistory)"})
  void testEnd_givenQuestionOptionsIsArrayList_thenReturnQuestionIsNull() throws BeansException {
    // Arrange
    Question question = new Question();
    question.setOptions(new ArrayList<>());
    Optional<Question> ofResult = Optional.of(question);
    when(allHistory.getFromHistory(Mockito.<Class<Answer>>any(), Mockito.<String>any(), Mockito.<Addressable>any(),
        Mockito.<Instant>any())).thenReturn(new ArrayList<>());
    when(allHistory.getLastFromHistory(Mockito.<Class<Question>>any(), Mockito.<String>any(),
        Mockito.<Addressable>any())).thenReturn(ofResult);
    doNothing().when(allHistory).setApplicationContext(Mockito.<ApplicationContext>any());
    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    allHistory.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    Result actualEndResult = pollController.end(pollId, r, allHistory);

    // Assert
    verify(pollId, atLeast(1)).getText();
    verify(allHistory).getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), (Instant) isNull());
    verify(allHistory).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
    verify(allHistory).setApplicationContext(isA(ApplicationContext.class));
    assertNull(actualEndResult.getQuestion());
    assertNull(actualEndResult.getPoller());
    assertEquals(0, actualEndResult.getTotalResponses().intValue());
    assertTrue(actualEndResult.getCounts().isEmpty());
    assertTrue(actualEndResult.getOptions().isEmpty());
  }

  /**
   * Test {@link PollController#poll0(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll0(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll0(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll0(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll0_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll0Result = pollController.poll0(u, q, c);

    // Assert
    Addressable address = actualPoll0Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll0Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll0Result.getTemplateName());
    Map<String, Object> data = actualPoll0Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll0Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll0Result.getFormClass());
    assertSame(c, address);
  }

  /**
   * Test {@link PollController#poll1(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll1(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll1(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll1(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll1_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll1Result = pollController.poll1(u, q, c);

    // Assert
    Addressable address = actualPoll1Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll1Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll1Result.getTemplateName());
    Map<String, Object> data = actualPoll1Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll1Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll1Result.getFormClass());
    assertSame(c, address);
  }

  /**
   * Test {@link PollController#poll2(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll2(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll2(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll2(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll2_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");
    options.add("foo");
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll2Result = pollController.poll2(u, q, c);

    // Assert
    Addressable address = actualPoll2Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll2Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll2Result.getTemplateName());
    Map<String, Object> data = actualPoll2Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll2Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll2Result.getFormClass());
    assertSame(c, address);
  }

  /**
   * Test {@link PollController#poll3(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll3(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll3(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll3(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll3_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll3Result = pollController.poll3(u, q, c);

    // Assert
    Addressable address = actualPoll3Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll3Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll3Result.getTemplateName());
    Map<String, Object> data = actualPoll3Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll3Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll3Result.getFormClass());
    assertSame(c, address);
  }

  /**
   * Test {@link PollController#poll4(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll4(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll4(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll4(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll4_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll4Result = pollController.poll4(u, q, c);

    // Assert
    Addressable address = actualPoll4Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll4Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll4Result.getTemplateName());
    Map<String, Object> data = actualPoll4Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll4Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll4Result.getFormClass());
    assertSame(c, address);
  }

  /**
   * Test {@link PollController#poll5(User, Question, Chat)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then Address return {@link SymphonyRoom}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PollController#poll5(User, Question, Chat)}
   */
  @Test
  @DisplayName("Test poll5(User, Question, Chat); given ArrayList() add 'foo'; then Address return SymphonyRoom")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.WorkResponse org.finos.springbot.tool.poll.poll.PollController.poll5(org.finos.springbot.workflow.content.User, org.finos.springbot.tool.poll.poll.Question, org.finos.springbot.workflow.content.Chat)"})
  void testPoll5_givenArrayListAddFoo_thenAddressReturnSymphonyRoom() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PollController pollController = new PollController();
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");
    options.add("foo");

    Question q = new Question();
    q.setOptions(options);
    SymphonyRoom c = new SymphonyRoom("Name", "42");

    // Act
    WorkResponse actualPoll5Result = pollController.poll5(u, q, c);

    // Assert
    Addressable address = actualPoll5Result.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(actualPoll5Result.getFormObject() instanceof Answer);
    assertEquals("answer", actualPoll5Result.getTemplateName());
    Map<String, Object> data = actualPoll5Result.getData();
    assertEquals(4, data.size());
    assertEquals(WorkMode.VIEW, actualPoll5Result.getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data.containsKey("header"));
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll5Result.getFormClass());
    assertSame(c, address);
  }
}
