package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.temporal.ChronoUnit;
import org.finos.springbot.tool.poll.poll.PollCreateForm.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PollCreateFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link PollCreateForm#setTimeUnit(TimeUnit)}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String PollCreateForm.getOption1()",
    "String PollCreateForm.getOption2()",
    "String PollCreateForm.getOption3()",
    "String PollCreateForm.getOption4()",
    "String PollCreateForm.getOption5()",
    "String PollCreateForm.getOption6()",
    "String PollCreateForm.getQuestion()",
    "Integer PollCreateForm.getTime()",
    "TimeUnit PollCreateForm.getTimeUnit()",
    "boolean PollCreateForm.isEndAutomatically()",
    "void PollCreateForm.setEndAutomatically(boolean)",
    "void PollCreateForm.setOption1(String)",
    "void PollCreateForm.setOption2(String)",
    "void PollCreateForm.setOption3(String)",
    "void PollCreateForm.setOption4(String)",
    "void PollCreateForm.setOption5(String)",
    "void PollCreateForm.setOption6(String)",
    "void PollCreateForm.setQuestion(String)",
    "void PollCreateForm.setTime(Integer)",
    "void PollCreateForm.setTimeUnit(TimeUnit)"
  })
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
    pollCreateForm.setTimeUnit(TimeUnit.MINUTES);
    String actualOption1 = pollCreateForm.getOption1();
    String actualOption2 = pollCreateForm.getOption2();
    String actualOption3 = pollCreateForm.getOption3();
    String actualOption4 = pollCreateForm.getOption4();
    String actualOption5 = pollCreateForm.getOption5();
    String actualOption6 = pollCreateForm.getOption6();
    String actualQuestion = pollCreateForm.getQuestion();
    Integer actualTime = pollCreateForm.getTime();
    TimeUnit actualTimeUnit = pollCreateForm.getTimeUnit();
    boolean actualIsEndAutomaticallyResult = pollCreateForm.isEndAutomatically();

    // Assert
    assertEquals("Option1", actualOption1);
    assertEquals("Option2", actualOption2);
    assertEquals("Option3", actualOption3);
    assertEquals("Option4", actualOption4);
    assertEquals("Option5", actualOption5);
    assertEquals("Option6", actualOption6);
    assertEquals("Question", actualQuestion);
    assertEquals(1, actualTime.intValue());
    assertEquals(TimeUnit.MINUTES, actualTimeUnit);
    assertTrue(actualIsEndAutomaticallyResult);
  }

  /**
   * Test new {@link PollCreateForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PollCreateForm}
   */
  @Test
  @DisplayName("Test new PollCreateForm (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PollCreateForm.<init>()"})
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
    assertEquals(TimeUnit.MINUTES, actualPollCreateForm.getTimeUnit());
    assertTrue(actualPollCreateForm.isEndAutomatically());
  }

  /**
   * Test TimeUnit {@link TimeUnit#getChronoUnit()}.
   *
   * <ul>
   *   <li>Given {@code DAYS}.
   *   <li>Then return {@code DAYS}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUnit#getChronoUnit()}
   */
  @Test
  @DisplayName("Test TimeUnit getChronoUnit(); given 'DAYS'; then return 'DAYS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChronoUnit TimeUnit.getChronoUnit()"})
  void testTimeUnitGetChronoUnit_givenDays_thenReturnDays() {
    // Arrange, Act and Assert
    assertEquals(ChronoUnit.DAYS, TimeUnit.DAYS.getChronoUnit());
  }

  /**
   * Test TimeUnit {@link TimeUnit#getChronoUnit()}.
   *
   * <ul>
   *   <li>Given {@code HOURS}.
   *   <li>Then return {@code HOURS}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUnit#getChronoUnit()}
   */
  @Test
  @DisplayName("Test TimeUnit getChronoUnit(); given 'HOURS'; then return 'HOURS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChronoUnit TimeUnit.getChronoUnit()"})
  void testTimeUnitGetChronoUnit_givenHours_thenReturnHours() {
    // Arrange, Act and Assert
    assertEquals(ChronoUnit.HOURS, TimeUnit.HOURS.getChronoUnit());
  }

  /**
   * Test TimeUnit {@link TimeUnit#getChronoUnit()}.
   *
   * <ul>
   *   <li>Given {@code MINUTES}.
   *   <li>Then return {@code MINUTES}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUnit#getChronoUnit()}
   */
  @Test
  @DisplayName("Test TimeUnit getChronoUnit(); given 'MINUTES'; then return 'MINUTES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChronoUnit TimeUnit.getChronoUnit()"})
  void testTimeUnitGetChronoUnit_givenMinutes_thenReturnMinutes() {
    // Arrange, Act and Assert
    assertEquals(ChronoUnit.MINUTES, TimeUnit.MINUTES.getChronoUnit());
  }

  /**
   * Test TimeUnit {@link TimeUnit#toString()}.
   *
   * <p>Method under test: {@link TimeUnit#toString()}
   */
  @Test
  @DisplayName("Test TimeUnit toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TimeUnit.toString()"})
  void testTimeUnitToString() {
    // Arrange, Act and Assert
    assertEquals("Minutes", TimeUnit.valueOf("MINUTES").toString());
  }
}
