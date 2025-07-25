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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.tool.poll.poll.PollCreateForm.TimeUnit;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.history.AllHistory;
import org.finos.springbot.workflow.response.DataResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;

@ExtendWith(MockitoExtension.class)
class PollControllerDiffblueTest {
  @InjectMocks private PollController pollController;

  @Mock private TaskScheduler taskScheduler;

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
    assertThrows(RuntimeException.class, () -> pollController.pollForm(null));
  }

  /**
   * Test {@link PollController#pollForm(Chat)}.
   *
   * <ul>
   *   <li>When {@link SymphonyRoom#SymphonyRoom(String, String)} with {@code Name} and id is {@code
   *       42}.
   *   <li>Then return Option1 is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  @DisplayName(
      "Test pollForm(Chat); when SymphonyRoom(String, String) with 'Name' and id is '42'; then return Option1 is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PollCreateForm PollController.pollForm(Chat)"})
  void testPollForm_whenSymphonyRoomWithNameAndIdIs42_thenReturnOption1IsNull() {
    // Arrange and Act
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
   *
   * <ul>
   *   <li>Given {@link TaskScheduler} {@link TaskScheduler#schedule(Runnable, Instant)} throw
   *       {@link RuntimeException#RuntimeException(String)} with {@code buttons}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); given TaskScheduler schedule(Runnable, Instant) throw RuntimeException(String) with 'buttons'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_givenTaskSchedulerScheduleThrowRuntimeExceptionWithButtons() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            taskScheduler.schedule(Mockito.<Runnable>any(), Mockito.<Instant>any()))
        .thenThrow(new RuntimeException("buttons"));

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
    cf.setTimeUnit(TimeUnit.MINUTES);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.poll(cf, r, new SymphonyUser(1L)));
    verify(taskScheduler).schedule(isA(Runnable.class), isA(Instant.class));
  }

  /**
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   *
   * <ul>
   *   <li>Then return second Buttons Contents size is six.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); then return second Buttons Contents size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_thenReturnSecondButtonsContentsSizeIsSix() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            taskScheduler.schedule(Mockito.<Runnable>any(), Mockito.<Instant>any()))
        .thenReturn(null);

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
    cf.setTimeUnit(TimeUnit.MINUTES);
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser(1L));

    // Assert
    verify(taskScheduler).schedule(isA(Runnable.class), isA(Instant.class));
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
   *
   * <ul>
   *   <li>When {@link PollCreateForm} (default constructor) EndAutomatically is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm (default constructor) EndAutomatically is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormEndAutomaticallyIsFalse() {
    // Arrange
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
    cf.setTimeUnit(null);
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
   *
   * <ul>
   *   <li>When {@link PollCreateForm} {@link PollCreateForm#getTime()} return one.
   *   <li>Then calls {@link PollCreateForm#getTime()}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm getTime() return one; then calls getTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormGetTimeReturnOne_thenCallsGetTime() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            taskScheduler.schedule(Mockito.<Runnable>any(), Mockito.<Instant>any()))
        .thenReturn(null);
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.getTime()).thenReturn(1);
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

    // Act
    List<DataResponse> actualPollResult = pollController.poll(cf, r, new SymphonyUser(1L));

    // Assert
    verify(cf).getQuestion();
    verify(cf).getTime();
    verify(cf, atLeast(1)).getTimeUnit();
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
    verify(taskScheduler).schedule(isA(Runnable.class), isA(Instant.class));
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
   *
   * <ul>
   *   <li>When {@link PollCreateForm} {@link PollCreateForm#getTime()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code buttons}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm getTime() throw RuntimeException(String) with 'buttons'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormGetTimeThrowRuntimeExceptionWithButtons() {
    // Arrange
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.getTime()).thenThrow(new RuntimeException("buttons"));
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
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   *
   * <ul>
   *   <li>When {@link PollCreateForm} {@link PollCreateForm#getTimeUnit()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm getTimeUnit() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormGetTimeUnitReturnNull() {
    // Arrange
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
    assertNull(((Question) formObject).getEndTime());
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
   *
   * <ul>
   *   <li>When {@link PollCreateForm} {@link PollCreateForm#getTimeUnit()} throw {@link
   *       RuntimeException#RuntimeException(String)} with {@code buttons}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm getTimeUnit() throw RuntimeException(String) with 'buttons'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormGetTimeUnitThrowRuntimeExceptionWithButtons() {
    // Arrange
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.getTimeUnit()).thenThrow(new RuntimeException("buttons"));
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
   * Test {@link PollController#poll(PollCreateForm, Chat, User)}.
   *
   * <ul>
   *   <li>When {@link PollCreateForm} {@link PollCreateForm#isEndAutomatically()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll(PollCreateForm, Chat, User)}
   */
  @Test
  @DisplayName(
      "Test poll(PollCreateForm, Chat, User); when PollCreateForm isEndAutomatically() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PollController.poll(PollCreateForm, Chat, User)"})
  void testPoll_whenPollCreateFormIsEndAutomaticallyReturnFalse() {
    // Arrange
    PollCreateForm cf = mock(PollCreateForm.class);
    when(cf.isEndAutomatically()).thenReturn(false);
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
    assertNull(((Question) formObject).getEndTime());
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
   * Test {@link PollController#end(Word, Chat, AllHistory)}.
   *
   * <ul>
   *   <li>Given {@link Question#Question()} Options is {@link ArrayList#ArrayList()}.
   *   <li>Then return Question is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); given Question() Options is ArrayList(); then return Question is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_givenQuestionOptionsIsArrayList_thenReturnQuestionIsNull() throws BeansException {
    // Arrange
    PollController pollController = new PollController();
    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    Question question = new Question();
    question.setOptions(new ArrayList<>());
    Optional<Question> ofResult = Optional.of(question);
    AllHistory h = mock(AllHistory.class);
    when(h.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Instant>any()))
        .thenReturn(new ArrayList<>());
    when(h.getLastFromHistory(
            Mockito.<Class<Question>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    doNothing().when(h).setApplicationContext(Mockito.<ApplicationContext>any());
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act
    Result actualEndResult = pollController.end(pollId, r, h);

    // Assert
    verify(pollId, atLeast(1)).getText();
    verify(h).getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), isNull());
    verify(h).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
    verify(h).setApplicationContext(isA(ApplicationContext.class));
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
   *   <li>When {@link AllHistory} {@link AllHistory#getFromHistory(Class, String, Addressable,
   *       Instant)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#end(Word, Chat, AllHistory)}
   */
  @Test
  @DisplayName(
      "Test end(Word, Chat, AllHistory); when AllHistory getFromHistory(Class, String, Addressable, Instant) throw RuntimeException(String) with 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Result PollController.end(Word, Chat, AllHistory)"})
  void testEnd_whenAllHistoryGetFromHistoryThrowRuntimeExceptionWithFoo() throws BeansException {
    // Arrange
    PollController pollController = new PollController();
    Word pollId = mock(Word.class);
    when(pollId.getText()).thenReturn("Text");
    SymphonyRoom r = new SymphonyRoom("Name", "42");

    AllHistory h = mock(AllHistory.class);
    when(h.getFromHistory(
            Mockito.<Class<Answer>>any(),
            Mockito.<String>any(),
            Mockito.<Addressable>any(),
            Mockito.<Instant>any()))
        .thenThrow(new RuntimeException("foo"));
    Optional<Question> ofResult = Optional.of(new Question());
    when(h.getLastFromHistory(
            Mockito.<Class<Question>>any(), Mockito.<String>any(), Mockito.<Addressable>any()))
        .thenReturn(ofResult);
    doNothing().when(h).setApplicationContext(Mockito.<ApplicationContext>any());
    h.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> pollController.end(pollId, r, h));
    verify(pollId, atLeast(1)).getText();
    verify(h).getFromHistory(isA(Class.class), eq("Text-a"), isA(Addressable.class), isNull());
    verify(h).getLastFromHistory(isA(Class.class), eq("Text-q"), isA(Addressable.class));
    verify(h).setApplicationContext(isA(ApplicationContext.class));
  }

  /**
   * Test {@link PollController#poll0(User, Question, Chat)}.
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll0(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll0(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll0(User, Question, Chat)"})
  void testPoll0_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll1(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll1(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll1(User, Question, Chat)"})
  void testPoll1_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll2(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll2(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll2(User, Question, Chat)"})
  void testPoll2_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll3(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll3(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll3(User, Question, Chat)"})
  void testPoll3_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll4(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll4(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll4(User, Question, Chat)"})
  void testPoll4_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
   *
   * <ul>
   *   <li>Given {@code Options}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Options}.
   *   <li>Then Address return {@link SymphonyRoom}.
   * </ul>
   *
   * <p>Method under test: {@link PollController#poll5(User, Question, Chat)}
   */
  @Test
  @DisplayName(
      "Test poll5(User, Question, Chat); given 'Options'; when ArrayList() add 'Options'; then Address return SymphonyRoom")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse PollController.poll5(User, Question, Chat)"})
  void testPoll5_givenOptions_whenArrayListAddOptions_thenAddressReturnSymphonyRoom() {
    // Arrange
    SymphonyUser u = new SymphonyUser(1L);

    ArrayList<String> options = new ArrayList<>();
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    options.add("Options");
    Question q = new Question("Question", options, "42", new SymphonyUser(1L));

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
