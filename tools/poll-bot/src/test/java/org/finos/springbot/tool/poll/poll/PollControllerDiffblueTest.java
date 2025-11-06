package org.finos.springbot.tool.poll.poll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.response.WorkResponse;
import org.finos.springbot.workflow.tags.HeaderDetails;
import org.junit.jupiter.api.Test;

class PollControllerDiffblueTest {
  /**
   * Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  void testPollForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    assertEquals(PollCreateForm.TimeUnit.MINUTES, actualPollFormResult.getTimeUnit());
    assertTrue(actualPollFormResult.isEndAutomatically());
  }

  /**
   * Method under test: {@link PollController#pollForm(Chat)}
   */
  @Test
  void testPollForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new PollController()).pollForm(null));
  }

  /**
   * Method under test: {@link PollController#poll0(User, Question, Chat)}
   */
  @Test
  void testPoll0() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll0Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll0Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll0Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll0Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, ((Answer) formObject).getChoice().intValue());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.VIEW, actualPoll0Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll0Result.getFormClass());
    assertSame(c, actualPoll0Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link PollController#poll1(User, Question, Chat)}
   */
  @Test
  void testPoll1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll1Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll1Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll1Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll1Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(1, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll1Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll1Result.getFormClass());
    assertSame(c, actualPoll1Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link PollController#poll2(User, Question, Chat)}
   */
  @Test
  void testPoll2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll2Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll2Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll2Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll2Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(2, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll2Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll2Result.getFormClass());
    assertSame(c, actualPoll2Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link PollController#poll3(User, Question, Chat)}
   */
  @Test
  void testPoll3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll3Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll3Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll3Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll3Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(3, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll3Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll3Result.getFormClass());
    assertSame(c, actualPoll3Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link PollController#poll4(User, Question, Chat)}
   */
  @Test
  void testPoll4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll4Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll4Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll4Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll4Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(4, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll4Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll4Result.getFormClass());
    assertSame(c, actualPoll4Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link PollController#poll5(User, Question, Chat)}
   */
  @Test
  void testPoll5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    ButtonList buttons = actualPoll5Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Object formObject = actualPoll5Result.getFormObject();
    assertTrue(formObject instanceof Answer);
    Map<String, Object> data = actualPoll5Result.getData();
    assertEquals(4, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Object getResult2 = data.get("header");
    assertTrue(getResult2 instanceof HeaderDetails);
    assertEquals("answer", actualPoll5Result.getTemplateName());
    assertEquals("foo", ((Answer) formObject).getChoiceText());
    List<String> tags = ((HeaderDetails) getResult2).getTags();
    assertEquals(1, tags.size());
    assertEquals("null-a", tags.get(0));
    assertNull(((Answer) formObject).getQuestionText());
    assertNull(((HeaderDetails) getResult2).getDescription());
    assertNull(((HeaderDetails) getResult2).getName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(5, ((Answer) formObject).getChoice().intValue());
    assertEquals(WorkMode.VIEW, actualPoll5Result.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<Answer> expectedFormClass = Answer.class;
    assertEquals(expectedFormClass, actualPoll5Result.getFormClass());
    assertSame(c, actualPoll5Result.getAddress());
    assertSame(u, ((Answer) formObject).getUser());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }
}
