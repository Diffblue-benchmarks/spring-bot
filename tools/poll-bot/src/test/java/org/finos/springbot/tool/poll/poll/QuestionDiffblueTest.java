package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class QuestionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Question#Question()}
   *   <li>{@link Question#setEndTime(Instant)}
   *   <li>{@link Question#setId(String)}
   *   <li>{@link Question#setOptions(List)}
   *   <li>{@link Question#setPoller(User)}
   *   <li>{@link Question#setQuestion(String)}
   *   <li>{@link Question#getEndTime()}
   *   <li>{@link Question#getId()}
   *   <li>{@link Question#getOptions()}
   *   <li>{@link Question#getPoller()}
   *   <li>{@link Question#getQuestion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Question actualQuestion = new Question();
    actualQuestion.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualQuestion.setId("42");
    ArrayList<String> options = new ArrayList<>();
    actualQuestion.setOptions(options);
    SymphonyUser poller = new SymphonyUser(1L);
    actualQuestion.setPoller(poller);
    actualQuestion.setQuestion("Question");
    Instant actualEndTime = actualQuestion.getEndTime();
    String actualId = actualQuestion.getId();
    List<String> actualOptions = actualQuestion.getOptions();
    User actualPoller = actualQuestion.getPoller();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("Question", actualQuestion.getQuestion());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(poller, actualPoller);
    assertSame(actualEndTime.EPOCH, actualEndTime);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Question#Question(String, List, String, User)}
   *   <li>{@link Question#setEndTime(Instant)}
   *   <li>{@link Question#setId(String)}
   *   <li>{@link Question#setOptions(List)}
   *   <li>{@link Question#setPoller(User)}
   *   <li>{@link Question#setQuestion(String)}
   *   <li>{@link Question#getEndTime()}
   *   <li>{@link Question#getId()}
   *   <li>{@link Question#getOptions()}
   *   <li>{@link Question#getPoller()}
   *   <li>{@link Question#getQuestion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    ArrayList<String> options = new ArrayList<>();

    // Act
    Question actualQuestion = new Question("Question", options, "42", new SymphonyUser(1L));
    actualQuestion.setEndTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualQuestion.setId("42");
    ArrayList<String> options2 = new ArrayList<>();
    actualQuestion.setOptions(options2);
    SymphonyUser poller = new SymphonyUser(1L);
    actualQuestion.setPoller(poller);
    actualQuestion.setQuestion("Question");
    Instant actualEndTime = actualQuestion.getEndTime();
    String actualId = actualQuestion.getId();
    List<String> actualOptions = actualQuestion.getOptions();
    User actualPoller = actualQuestion.getPoller();

    // Assert that nothing has changed
    assertEquals("42", actualId);
    assertEquals("Question", actualQuestion.getQuestion());
    assertTrue(actualOptions.isEmpty());
    assertSame(options2, actualOptions);
    assertSame(poller, actualPoller);
    assertSame(actualEndTime.EPOCH, actualEndTime);
  }
}
