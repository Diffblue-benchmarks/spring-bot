package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Result#Result()}
   *   <li>{@link Result#setCounts(List)}
   *   <li>{@link Result#setOptions(List)}
   *   <li>{@link Result#setPoller(User)}
   *   <li>{@link Result#setQuestion(String)}
   *   <li>{@link Result#setTotalResponses(Integer)}
   *   <li>{@link Result#getCounts()}
   *   <li>{@link Result#getOptions()}
   *   <li>{@link Result#getPoller()}
   *   <li>{@link Result#getQuestion()}
   *   <li>{@link Result#getTotalResponses()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Result.<init>()",
      "void org.finos.springbot.tool.poll.poll.Result.<init>(java.util.List, java.util.List, java.lang.String, org.finos.springbot.workflow.content.User, java.lang.Integer)",
      "java.util.List org.finos.springbot.tool.poll.poll.Result.getCounts()",
      "java.util.List org.finos.springbot.tool.poll.poll.Result.getOptions()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Result.getPoller()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Result.getQuestion()",
      "java.lang.Integer org.finos.springbot.tool.poll.poll.Result.getTotalResponses()",
      "void org.finos.springbot.tool.poll.poll.Result.setCounts(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Result.setOptions(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Result.setPoller(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.tool.poll.poll.Result.setQuestion(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Result.setTotalResponses(java.lang.Integer)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Result actualResult = new Result();
    ArrayList<Integer> counts = new ArrayList<>();
    actualResult.setCounts(counts);
    ArrayList<String> options = new ArrayList<>();
    actualResult.setOptions(options);
    SymphonyUser poller = new SymphonyUser(1L);
    actualResult.setPoller(poller);
    actualResult.setQuestion("Question");
    actualResult.setTotalResponses(1);
    List<Integer> actualCounts = actualResult.getCounts();
    List<String> actualOptions = actualResult.getOptions();
    User actualPoller = actualResult.getPoller();
    String actualQuestion = actualResult.getQuestion();

    // Assert
    assertEquals("Question", actualQuestion);
    assertEquals(1, actualResult.getTotalResponses().intValue());
    assertTrue(actualCounts.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(counts, actualCounts);
    assertSame(options, actualOptions);
    assertSame(poller, actualPoller);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Result#Result(List, List, String, User, Integer)}
   *   <li>{@link Result#setCounts(List)}
   *   <li>{@link Result#setOptions(List)}
   *   <li>{@link Result#setPoller(User)}
   *   <li>{@link Result#setQuestion(String)}
   *   <li>{@link Result#setTotalResponses(Integer)}
   *   <li>{@link Result#getCounts()}
   *   <li>{@link Result#getOptions()}
   *   <li>{@link Result#getPoller()}
   *   <li>{@link Result#getQuestion()}
   *   <li>{@link Result#getTotalResponses()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.tool.poll.poll.Result.<init>()",
      "void org.finos.springbot.tool.poll.poll.Result.<init>(java.util.List, java.util.List, java.lang.String, org.finos.springbot.workflow.content.User, java.lang.Integer)",
      "java.util.List org.finos.springbot.tool.poll.poll.Result.getCounts()",
      "java.util.List org.finos.springbot.tool.poll.poll.Result.getOptions()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.tool.poll.poll.Result.getPoller()",
      "java.lang.String org.finos.springbot.tool.poll.poll.Result.getQuestion()",
      "java.lang.Integer org.finos.springbot.tool.poll.poll.Result.getTotalResponses()",
      "void org.finos.springbot.tool.poll.poll.Result.setCounts(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Result.setOptions(java.util.List)",
      "void org.finos.springbot.tool.poll.poll.Result.setPoller(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.tool.poll.poll.Result.setQuestion(java.lang.String)",
      "void org.finos.springbot.tool.poll.poll.Result.setTotalResponses(java.lang.Integer)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange
    ArrayList<Integer> counts = new ArrayList<>();
    ArrayList<String> options = new ArrayList<>();

    // Act
    Result actualResult = new Result(counts, options, "Question", new SymphonyUser(1L), 1);
    ArrayList<Integer> counts2 = new ArrayList<>();
    actualResult.setCounts(counts2);
    ArrayList<String> options2 = new ArrayList<>();
    actualResult.setOptions(options2);
    SymphonyUser poller = new SymphonyUser(1L);
    actualResult.setPoller(poller);
    actualResult.setQuestion("Question");
    actualResult.setTotalResponses(1);
    List<Integer> actualCounts = actualResult.getCounts();
    List<String> actualOptions = actualResult.getOptions();
    User actualPoller = actualResult.getPoller();
    String actualQuestion = actualResult.getQuestion();

    // Assert
    assertEquals("Question", actualQuestion);
    assertEquals(1, actualResult.getTotalResponses().intValue());
    assertTrue(actualCounts.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(counts2, actualCounts);
    assertSame(options2, actualOptions);
    assertSame(poller, actualPoller);
  }
}
