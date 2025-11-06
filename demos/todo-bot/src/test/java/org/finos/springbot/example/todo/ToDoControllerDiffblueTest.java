package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ToDoController.class})
@ExtendWith(SpringExtension.class)
class ToDoControllerDiffblueTest {
  @Autowired
  private ToDoController toDoController;

  /**
   * Method under test: {@link ToDoController#init()}
   */
  @Test
  void testInit() {
    // Arrange, Act and Assert
    assertTrue(toDoController.init().getItems().isEmpty());
  }

  /**
   * Method under test: {@link ToDoController#add1(User)}
   */
  @Test
  void testAdd1() {
    // Arrange
    SymphonyUser author = new SymphonyUser(1L);

    // Act
    NewItemDetails actualAdd1Result = toDoController.add1(author);

    // Assert
    assertNull(actualAdd1Result.getDescription());
    assertSame(author, actualAdd1Result.getAssignTo());
  }

  /**
   * Method under test: {@link ToDoController#add1(User)}
   */
  @Test
  void testAdd12() {
    // Arrange
    User author = mock(User.class);

    // Act
    NewItemDetails actualAdd1Result = toDoController.add1(author);

    // Assert
    assertNull(actualAdd1Result.getDescription());
    assertSame(author, actualAdd1Result.getAssignTo());
  }

  /**
   * Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  void testAdd() {
    // Arrange
    NewItemDetails a = new NewItemDetails();
    a.setAssignTo(new SymphonyUser(1L));
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.add(a, u, toDo));
  }

  /**
   * Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  void testAdd2() {
    // Arrange
    NewItemDetails a = mock(NewItemDetails.class);
    when(a.getDescription()).thenReturn("The characteristics of someone or something");
    when(a.getAssignTo()).thenReturn(new SymphonyUser(1L));
    doNothing().when(a).setAssignTo(Mockito.<User>any());
    doNothing().when(a).setDescription(Mockito.<String>any());
    a.setAssignTo(new SymphonyUser(1L));
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAddResult = toDoController.add(a, u, toDo);

    // Assert
    verify(a).getAssignTo();
    verify(a).getDescription();
    verify(a).setAssignTo(isA(User.class));
    verify(a).setDescription(eq("The characteristics of someone or something"));
    assertSame(toDoList, actualAddResult);
  }

  /**
   * Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  void testAdd3() {
    // Arrange
    NewItemDetails a = mock(NewItemDetails.class);
    doNothing().when(a).setAssignTo(Mockito.<User>any());
    doNothing().when(a).setDescription(Mockito.<String>any());
    a.setAssignTo(new SymphonyUser(1L));
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser(1L);
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.add(a, u, toDo));
    verify(a).setAssignTo(isA(User.class));
    verify(a).setDescription(eq("The characteristics of someone or something"));
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#cancel(Optional)}
   */
  @Test
  void testCancel() {
    // Arrange
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualCancelResult = toDoController.cancel(toDo);

    // Assert
    assertTrue(actualCancelResult.getItems().isEmpty());
    assertSame(toDoList, actualCancelResult);
  }

  /**
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  void testShow() {
    // Arrange
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    ToDoList actualShowResult = toDoController.show(in);

    // Assert
    assertTrue(actualShowResult.getItems().isEmpty());
    assertSame(toDoList, actualShowResult);
  }

  /**
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  void testShow2() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(new ArrayList<>());
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    toDoController.show(in);

    // Assert
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  void testShow3() {
    // Arrange
    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    toDoController.show(in);

    // Assert
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  void testShow4() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.show(in));
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  void testEdit() {
    // Arrange
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    ToDoList actualEditResult = toDoController.edit(in);

    // Assert
    assertTrue(actualEditResult.getItems().isEmpty());
    assertSame(toDoList, actualEditResult);
  }

  /**
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  void testEdit2() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(new ArrayList<>());
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    toDoController.edit(in);

    // Assert
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  void testEdit3() {
    // Arrange
    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act
    toDoController.edit(in);

    // Assert
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  void testEdit4() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.edit(in));
    verify(toDoList).getItems();
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete() {
    // Arrange
    ArrayList<Word> toDelete = new ArrayList<>();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.delete(toDelete, toDo));
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualDeleteResult = toDoController.delete(toDelete, toDo);

    // Assert
    verify(word).getText();
    assertTrue(actualDeleteResult.getItems().isEmpty());
    assertSame(toDoList, actualDeleteResult);
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete3() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word2);
    toDelete.add(word);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualDeleteResult = toDoController.delete(toDelete, toDo);

    // Assert
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualDeleteResult.getItems().isEmpty());
    assertSame(toDoList, actualDeleteResult);
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete4() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word3);
    toDelete.add(word2);
    toDelete.add(word);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualDeleteResult = toDoController.delete(toDelete, toDo);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualDeleteResult.getItems().isEmpty());
    assertSame(toDoList, actualDeleteResult);
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete5() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word3);
    toDelete.add(word2);
    toDelete.add(word);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualDeleteResult = toDoController.delete(toDelete, toDo);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualDeleteResult.getItems().isEmpty());
    assertSame(toDoList, actualDeleteResult);
  }

  /**
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  void testDelete6() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word3);
    toDelete.add(word2);
    toDelete.add(word);
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.delete(toDelete, toDo));
    verify(toDoList).getItems();
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete() {
    // Arrange
    ArrayList<Word> words = new ArrayList<>();
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult2 = data.get("errors");
    assertTrue(getResult2 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, ((WorkResponse) getResult).getFormObject());
    assertSame(theRoom, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult2 = data.get("errors");
    assertTrue(getResult2 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, ((WorkResponse) getResult).getFormObject());
    assertSame(theRoom, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete3() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult2 = data.get("errors");
    assertTrue(getResult2 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, ((WorkResponse) getResult).getFormObject());
    assertSame(theRoom, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete4() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("buttons"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult2 = data.get("errors");
    assertTrue(getResult2 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, ((WorkResponse) getResult).getFormObject());
    assertSame(theRoom, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete5() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("buttons"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult2 = data.get("errors");
    assertTrue(getResult2 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult2).size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult2).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, ((WorkResponse) getResult).getFormObject());
    assertSame(theRoom, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test:
   * {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  void testComplete6() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("buttons"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> toDoController.complete(words, by, a, toDo, new SymphonyRoom("Name", "42")));
    verify(toDoList).getItems();
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign() {
    // Arrange
    ArrayList<Word> words = new ArrayList<>();
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.assign(words, by, a, toDo));
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    verify(word).getText();
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign3() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign4() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign5() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Method under test:
   * {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  void testAssign6() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");
    Word word3 = mock(Word.class);
    when(word3.getText()).thenThrow(new NumberFormatException("foo"));

    ArrayList<Word> words = new ArrayList<>();
    words.add(word3);
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.assign(words, by, a, toDo));
    verify(toDoList).getItems();
    verify(word3).getText();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Method under test: {@link ToDoController#sendToRoom()}
   */
  @Test
  void testSendToRoom() {
    // Arrange, Act and Assert
    assertNull(toDoController.sendToRoom().getRoom());
  }

  /**
   * Method under test: {@link ToDoController#sendToRoom(SendToRoom, ToDoList)}
   */
  @Test
  void testSendToRoom2() {
    // Arrange
    SendToRoom theForm = new SendToRoom();
    SymphonyRoom room = new SymphonyRoom("Name", "42");

    theForm.setRoom(room);
    ToDoList tdl = new ToDoList();

    // Act
    WorkResponse actualSendToRoomResult = toDoController.sendToRoom(theForm, tdl);

    // Assert
    ButtonList buttons = actualSendToRoomResult.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualSendToRoomResult.getData();
    assertEquals(3, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("default-view", actualSendToRoomResult.getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.VIEW, actualSendToRoomResult.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, actualSendToRoomResult.getFormClass());
    assertSame(tdl, data.get("form"));
    assertSame(tdl, actualSendToRoomResult.getFormObject());
    assertSame(room, actualSendToRoomResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Method under test: {@link ToDoController#sendToRoom(SendToRoom, ToDoList)}
   */
  @Test
  void testSendToRoom3() {
    // Arrange
    SendToRoom theForm = mock(SendToRoom.class);
    doNothing().when(theForm).setRoom(Mockito.<Chat>any());
    theForm.setRoom(new SymphonyRoom("Name", "42"));
    ToDoList tdl = new ToDoList();

    // Act
    WorkResponse actualSendToRoomResult = toDoController.sendToRoom(theForm, tdl);

    // Assert
    verify(theForm).setRoom(isA(Chat.class));
    ButtonList buttons = actualSendToRoomResult.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Map<String, Object> data = actualSendToRoomResult.getData();
    assertEquals(3, data.size());
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    assertEquals("default-view", actualSendToRoomResult.getTemplateName());
    assertNull(actualSendToRoomResult.getAddress());
    assertEquals(0, buttons.size());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(WorkMode.VIEW, actualSendToRoomResult.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, actualSendToRoomResult.getFormClass());
    assertSame(tdl, data.get("form"));
    assertSame(tdl, actualSendToRoomResult.getFormObject());
    assertSame(buttons, data.get("buttons"));
  }
}
