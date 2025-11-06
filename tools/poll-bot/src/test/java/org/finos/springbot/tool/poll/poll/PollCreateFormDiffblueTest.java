package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

class PollCreateFormDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PollCreateForm#setEndAutomatically(boolean)}
   *   <li>{@link PollCreateForm#setOption1(String)}
   *   <li>{@link PollCreateForm#setOption2(String)}
   *   <li>{@link PollCreateForm#setOption3(String)}
   *   <li>{@link PollCreateForm#setOption4(String)}
   *   <li>{@link PollCreateForm#setOption5(String)}
   *   <li>{@link PollCreateForm#setOption6(String)}
   *   <li>{@link PollCreateForm#setQuestion(String)}
   *   <li>{@link PollCreateForm#setTime(Integer)}
   *   <li>{@link PollCreateForm#setTimeUnit(PollCreateForm.TimeUnit)}
   *   <li>{@link PollCreateForm#getOption1()}
   *   <li>{@link PollCreateForm#getOption2()}
   *   <li>{@link PollCreateForm#getOption3()}
   *   <li>{@link PollCreateForm#getOption4()}
   *   <li>{@link PollCreateForm#getOption5()}
   *   <li>{@link PollCreateForm#getOption6()}
   *   <li>{@link PollCreateForm#getQuestion()}
   *   <li>{@link PollCreateForm#getTime()}
   *   <li>{@link PollCreateForm#getTimeUnit()}
   *   <li>{@link PollCreateForm#isEndAutomatically()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PollCreateForm pollCreateForm = new PollCreateForm();

    // Act
    pollCreateForm.setEndAutomatically(true);
    pollCreateForm.setOption1("Option1");
    pollCreateForm.setOption2("Option2");
    pollCreateForm.setOption3("Option3");
    pollCreateForm.setOption4("Option4");
    pollCreateForm.setOption5("Option5");
    pollCreateForm.setOption6("Option6");
    pollCreateForm.setQuestion("Question");
    pollCreateForm.setTime(1);
    pollCreateForm.setTimeUnit(PollCreateForm.TimeUnit.MINUTES);
    String actualOption1 = pollCreateForm.getOption1();
    String actualOption2 = pollCreateForm.getOption2();
    String actualOption3 = pollCreateForm.getOption3();
    String actualOption4 = pollCreateForm.getOption4();
    String actualOption5 = pollCreateForm.getOption5();
    String actualOption6 = pollCreateForm.getOption6();
    String actualQuestion = pollCreateForm.getQuestion();
    Integer actualTime = pollCreateForm.getTime();
    PollCreateForm.TimeUnit actualTimeUnit = pollCreateForm.getTimeUnit();
    boolean actualIsEndAutomaticallyResult = pollCreateForm.isEndAutomatically();

    // Assert that nothing has changed
    assertEquals("Option1", actualOption1);
    assertEquals("Option2", actualOption2);
    assertEquals("Option3", actualOption3);
    assertEquals("Option4", actualOption4);
    assertEquals("Option5", actualOption5);
    assertEquals("Option6", actualOption6);
    assertEquals("Question", actualQuestion);
    assertEquals(1, actualTime.intValue());
    assertEquals(PollCreateForm.TimeUnit.MINUTES, actualTimeUnit);
    assertTrue(actualIsEndAutomaticallyResult);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PollCreateForm}
   */
  @Test
  void testNewPollCreateForm() {
    // Arrange and Act
    PollCreateForm actualPollCreateForm = new PollCreateForm();

    // Assert
    assertNull(actualPollCreateForm.getOption1());
    assertNull(actualPollCreateForm.getOption2());
    assertNull(actualPollCreateForm.getOption3());
    assertNull(actualPollCreateForm.getOption4());
    assertNull(actualPollCreateForm.getOption5());
    assertNull(actualPollCreateForm.getOption6());
    assertNull(actualPollCreateForm.getQuestion());
    assertEquals(15, actualPollCreateForm.getTime().intValue());
    assertEquals(PollCreateForm.TimeUnit.MINUTES, actualPollCreateForm.getTimeUnit());
    assertTrue(actualPollCreateForm.isEndAutomatically());
  }

  /**
   * Method under test: {@link PollCreateForm.TimeUnit#getChronoUnit()}
   */
  @Test
  void testTimeUnitGetChronoUnit() {
    // Arrange, Act and Assert
    assertEquals(ChronoUnit.MINUTES, PollCreateForm.TimeUnit.MINUTES.getChronoUnit());
    assertEquals(ChronoUnit.HOURS, PollCreateForm.TimeUnit.HOURS.getChronoUnit());
    assertEquals(ChronoUnit.DAYS, PollCreateForm.TimeUnit.DAYS.getChronoUnit());
  }

  /**
   * Method under test: {@link PollCreateForm.TimeUnit#toString()}
   */
  @Test
  void testTimeUnitToString() {
    // Arrange, Act and Assert
    assertEquals("Minutes", PollCreateForm.TimeUnit.valueOf("MINUTES").toString());
  }
}
