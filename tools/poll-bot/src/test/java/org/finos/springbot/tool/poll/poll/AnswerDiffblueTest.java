package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnswerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Answer#Answer()}
   *   <li>{@link Answer#setChoice(Integer)}
   *   <li>{@link Answer#setChoiceText(String)}
   *   <li>{@link Answer#setQuestionText(String)}
   *   <li>{@link Answer#setTime(Instant)}
   *   <li>{@link Answer#setUser(User)}
   *   <li>{@link Answer#getChoice()}
   *   <li>{@link Answer#getChoiceText()}
   *   <li>{@link Answer#getQuestionText()}
   *   <li>{@link Answer#getTime()}
   *   <li>{@link Answer#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Answer.<init>()",
      "void org.finos.springbot.tool.poll.poll.Answer.<init>(org.finos.springbot.workflow.content.User, java.time.Instant, java.lang.Integer, java.lang.String, java.lang.String)",
      "java.lang.Integer org.finos.springbot.tool.poll.poll.Answer.getChoice()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Answer.getChoiceText()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Answer.getQuestionText()",
      "java.time.Instant org.finos.springbot.tool.poll.poll.Answer.getTime()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Answer.getUser()",
      "void org.finos.springbot.tool.poll.poll.Answer.setChoice(java.lang.Integer)",
      "void org.finos.springbot.tool.poll.poll.Answer.setChoiceText(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Answer.setQuestionText(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Answer.setTime(java.time.Instant)",
      "void org.finos.springbot.tool.poll.poll.Answer.setUser(org.finos.springbot.workflow.content.User)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Answer actualAnswer = new Answer();
    actualAnswer.setChoice(1);
    actualAnswer.setChoiceText("Choice Text");
    actualAnswer.setQuestionText("Question Text");
    actualAnswer.setTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    SymphonyUser User = new SymphonyUser(1L);
    actualAnswer.setUser(User);
    Integer actualChoice = actualAnswer.getChoice();
    String actualChoiceText = actualAnswer.getChoiceText();
    String actualQuestionText = actualAnswer.getQuestionText();
    Instant actualTime = actualAnswer.getTime();
    User actualUser = actualAnswer.getUser();

    // Assert
    assertEquals("Choice Text", actualChoiceText);
    assertEquals("Question Text", actualQuestionText);
    assertEquals(1, actualChoice.intValue());
    assertSame(User, actualUser);
    assertSame(actualTime.EPOCH, actualTime);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Answer#Answer(User, Instant, Integer, String, String)}
   *   <li>{@link Answer#setChoice(Integer)}
   *   <li>{@link Answer#setChoiceText(String)}
   *   <li>{@link Answer#setQuestionText(String)}
   *   <li>{@link Answer#setTime(Instant)}
   *   <li>{@link Answer#setUser(User)}
   *   <li>{@link Answer#getChoice()}
   *   <li>{@link Answer#getChoiceText()}
   *   <li>{@link Answer#getQuestionText()}
   *   <li>{@link Answer#getTime()}
   *   <li>{@link Answer#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SymphonyUser(long) with userId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Answer.<init>()",
      "void org.finos.springbot.tool.poll.poll.Answer.<init>(org.finos.springbot.workflow.content.User, java.time.Instant, java.lang.Integer, java.lang.String, java.lang.String)",
      "java.lang.Integer org.finos.springbot.tool.poll.poll.Answer.getChoice()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Answer.getChoiceText()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Answer.getQuestionText()",
      "java.time.Instant org.finos.springbot.tool.poll.poll.Answer.getTime()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Answer.getUser()",
      "void org.finos.springbot.tool.poll.poll.Answer.setChoice(java.lang.Integer)",
      "void org.finos.springbot.tool.poll.poll.Answer.setChoiceText(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Answer.setQuestionText(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Answer.setTime(java.time.Instant)",
      "void org.finos.springbot.tool.poll.poll.Answer.setUser(org.finos.springbot.workflow.content.User)"})
  void testGettersAndSetters_whenSymphonyUserWithUserIdIsOne() {
    // Arrange
    SymphonyUser User = new SymphonyUser(1L);

    // Act
    Answer actualAnswer = new Answer(User, LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(),
        1, "Question Text", "Choice Text");
    actualAnswer.setChoice(1);
    actualAnswer.setChoiceText("Choice Text");
    actualAnswer.setQuestionText("Question Text");
    actualAnswer.setTime(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    SymphonyUser User2 = new SymphonyUser(1L);
    actualAnswer.setUser(User2);
    Integer actualChoice = actualAnswer.getChoice();
    String actualChoiceText = actualAnswer.getChoiceText();
    String actualQuestionText = actualAnswer.getQuestionText();
    Instant actualTime = actualAnswer.getTime();
    User actualUser = actualAnswer.getUser();

    // Assert
    assertEquals("Choice Text", actualChoiceText);
    assertEquals("Question Text", actualQuestionText);
    assertEquals(1, actualChoice.intValue());
    assertSame(User2, actualUser);
    assertSame(actualTime.EPOCH, actualTime);
  }
}
