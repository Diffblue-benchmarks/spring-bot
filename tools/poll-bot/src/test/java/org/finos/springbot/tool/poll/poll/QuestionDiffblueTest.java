package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QuestionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Question.<init>()",
      "void org.finos.springbot.tool.poll.poll.Question.<init>(java.lang.String, java.util.List, java.lang.String, org.finos.springbot.workflow.content.User)",
      "java.time.Instant org.finos.springbot.tool.poll.poll.Question.getEndTime()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Question.getId()",
      "java.util.List org.finos.springbot.tool.poll.poll.Question.getOptions()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Question.getPoller()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Question.getQuestion()",
      "void org.finos.springbot.tool.poll.poll.Question.setEndTime(java.time.Instant)",
      "void org.finos.springbot.tool.poll.poll.Question.setId(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Question.setOptions(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Question.setPoller(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.tool.poll.poll.Question.setQuestion(java.lang.String)"})
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

    // Assert
    assertEquals("42", actualId);
    assertEquals("Question", actualQuestion.getQuestion());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(poller, actualPoller);
    assertSame(actualEndTime.EPOCH, actualEndTime);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Question}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when 'Question'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Question.<init>()",
      "void org.finos.springbot.tool.poll.poll.Question.<init>(java.lang.String, java.util.List, java.lang.String, org.finos.springbot.workflow.content.User)",
      "java.time.Instant org.finos.springbot.tool.poll.poll.Question.getEndTime()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Question.getId()",
      "java.util.List org.finos.springbot.tool.poll.poll.Question.getOptions()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Question.getPoller()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Question.getQuestion()",
      "void org.finos.springbot.tool.poll.poll.Question.setEndTime(java.time.Instant)",
      "void org.finos.springbot.tool.poll.poll.Question.setId(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Question.setOptions(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Question.setPoller(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.tool.poll.poll.Question.setQuestion(java.lang.String)"})
  void testGettersAndSetters_whenQuestion() {
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

    // Assert
    assertEquals("42", actualId);
    assertEquals("Question", actualQuestion.getQuestion());
    assertTrue(actualOptions.isEmpty());
    assertSame(options2, actualOptions);
    assertSame(poller, actualPoller);
    assertSame(actualEndTime.EPOCH, actualEndTime);
  }
}
