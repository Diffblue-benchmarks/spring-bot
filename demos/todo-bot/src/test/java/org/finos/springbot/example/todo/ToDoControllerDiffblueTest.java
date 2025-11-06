package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ToDoController.class})
@ExtendWith(SpringExtension.class)
class ToDoControllerDiffblueTest {
  @Autowired
  private ToDoController toDoController;

  /**
   * Test {@link ToDoController#init()}.
   * <p>
   * Method under test: {@link ToDoController#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.init()"})
  void testInit() {
    // Arrange, Act and Assert
    assertTrue(toDoController.init().getItems().isEmpty());
  }

  /**
   * Test {@link ToDoController#add1(User)}.
   * <p>
   * Method under test: {@link ToDoController#add1(User)}
   */
  @Test
  @DisplayName("Test add1(User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NewItemDetails ToDoController.add1(User)"})
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
   * Test {@link ToDoController#add(NewItemDetails, User, Optional)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  @DisplayName("Test add(NewItemDetails, User, Optional); given NumberFormatException(String) with 'foo'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.add(NewItemDetails, User, Optional)"})
  void testAdd_givenNumberFormatExceptionWithFoo_thenThrowNumberFormatException() {
    // Arrange
    NewItemDetails a = new NewItemDetails();
    a.setAssignTo(new SymphonyUser(1L));
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser(1L);
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.add(a, u, toDo));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#add(NewItemDetails, User, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return {@link ToDoList#ToDoList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  @DisplayName("Test add(NewItemDetails, User, Optional); when Optional with ToDoList(); then return ToDoList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.add(NewItemDetails, User, Optional)"})
  void testAdd_whenOptionalWithToDoList_thenReturnToDoList() {
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
   * Test {@link ToDoController#cancel(Optional)}.
   * <p>
   * Method under test: {@link ToDoController#cancel(Optional)}
   */
  @Test
  @DisplayName("Test cancel(Optional)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.cancel(Optional)"})
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
   * Test {@link ToDoController#show(Optional)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName("Test show(Optional); given NumberFormatException(String) with 'foo'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_givenNumberFormatExceptionWithFoo_thenThrowNumberFormatException() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.show(in));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#show(Optional)}.
   * <ul>
   *   <li>Given {@link ToDoItem#ToDoItem()}.</li>
   *   <li>Then return {@link ToDoList#ToDoList(List)} with items is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName("Test show(Optional); given ToDoItem(); then return ToDoList(List) with items is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_givenToDoItem_thenReturnToDoListWithItemsIsArrayList() {
    // Arrange
    ArrayList<ToDoItem> items = new ArrayList<>();
    items.add(new ToDoItem());
    ToDoList toDoList = new ToDoList(items);
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.show(in));
  }

  /**
   * Test {@link ToDoController#show(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName("Test show(Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_whenOptionalWithToDoList_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#edit(Optional)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName("Test edit(Optional); given NumberFormatException(String) with 'foo'; then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_givenNumberFormatExceptionWithFoo_thenThrowNumberFormatException() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException("foo"));
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.edit(in));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#edit(Optional)}.
   * <ul>
   *   <li>Given {@link ToDoItem#ToDoItem()}.</li>
   *   <li>Then return {@link ToDoList#ToDoList(List)} with items is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName("Test edit(Optional); given ToDoItem(); then return ToDoList(List) with items is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_givenToDoItem_thenReturnToDoListWithItemsIsArrayList() {
    // Arrange
    ArrayList<ToDoItem> items = new ArrayList<>();
    items.add(new ToDoItem());
    ToDoList toDoList = new ToDoList(items);
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.edit(in));
  }

  /**
   * Test {@link ToDoController#edit(Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName("Test edit(Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_whenOptionalWithToDoList_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>Given {@link Word} {@link Content#getText()} return {@code 42}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); given Word getText() return '42'; then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextReturn42_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>Given {@link Word} {@link Content#getText()} throw {@link NumberFormatException#NumberFormatException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); given Word getText() throw NumberFormatException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextThrowNumberFormatExceptionWithFoo() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_thenThrowNumberFormatException() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); when ArrayList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_whenArrayList_thenReturnItemsEmpty() {
    // Arrange
    ArrayList<Word> toDelete = new ArrayList<>();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualDeleteResult = toDoController.delete(toDelete, toDo);

    // Assert
    assertTrue(actualDeleteResult.getItems().isEmpty());
    assertSame(toDoList, actualDeleteResult);
  }

  /**
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_whenOptionalWithToDoList_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_whenOptionalWithToDoList_thenReturnItemsEmpty2() {
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
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>Given {@link Word} {@link Content#getText()} return {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); given Word getText() return '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenWordGetTextReturn42_thenReturnSizeIsOne() {
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
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, formObject);
    assertSame(theRoom, address);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_thenReturnSizeIsOne() {
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
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, formObject);
    assertSame(theRoom, address);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_thenThrowNumberFormatException() {
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
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); when ArrayList(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenArrayList_thenReturnSizeIsOne() {
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
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, formObject);
    assertSame(theRoom, address);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); when Optional with ToDoList(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenOptionalWithToDoList_thenReturnSizeIsOne() {
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
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, formObject);
    assertSame(theRoom, address);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName("Test complete(List, Optional, User, Optional, Chat); when Optional with ToDoList(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenOptionalWithToDoList_thenReturnSizeIsOne2() {
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
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(toDoList, formObject);
    assertSame(theRoom, address);
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>Given {@link Word} {@link Content#getText()} return {@code 42}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); given Word getText() return '42'; then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenWordGetTextReturn42_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_thenThrowNumberFormatException() {
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
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); when ArrayList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_whenArrayList_thenReturnItemsEmpty() {
    // Arrange
    ArrayList<Word> words = new ArrayList<>();
    Optional<User> by = Optional.of(new SymphonyUser(1L));
    SymphonyUser a = new SymphonyUser(1L);
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_whenOptionalWithToDoList_thenReturnItemsEmpty() {
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
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   * <ul>
   *   <li>When {@link Optional} with {@link ToDoList#ToDoList()}.</li>
   *   <li>Then return Items Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName("Test assign(List, Optional, User, Optional); when Optional with ToDoList(); then return Items Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_whenOptionalWithToDoList_thenReturnItemsEmpty2() {
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
   * Test {@link ToDoController#sendToRoom()}.
   * <p>
   * Method under test: {@link ToDoController#sendToRoom()}
   */
  @Test
  @DisplayName("Test sendToRoom()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SendToRoom ToDoController.sendToRoom()"})
  void testSendToRoom() {
    // Arrange, Act and Assert
    assertNull(toDoController.sendToRoom().getRoom());
  }

  /**
   * Test {@link ToDoController#sendToRoom(SendToRoom, ToDoList)} with {@code SendToRoom}, {@code ToDoList}.
   * <ul>
   *   <li>When {@link ToDoList#ToDoList()}.</li>
   *   <li>Then Buttons Contents return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToDoController#sendToRoom(SendToRoom, ToDoList)}
   */
  @Test
  @DisplayName("Test sendToRoom(SendToRoom, ToDoList) with 'SendToRoom', 'ToDoList'; when ToDoList(); then Buttons Contents return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WorkResponse ToDoController.sendToRoom(SendToRoom, ToDoList)"})
  void testSendToRoomWithSendToRoomToDoList_whenToDoList_thenButtonsContentsReturnList() {
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
    Object formObject = actualSendToRoomResult.getFormObject();
    assertTrue(formObject instanceof ToDoList);
    Map<String, Object> data = actualSendToRoomResult.getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertEquals("default-view", actualSendToRoomResult.getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, actualSendToRoomResult.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, actualSendToRoomResult.getFormClass());
    assertSame(tdl, data.get("form"));
    assertSame(tdl, formObject);
    assertSame(room, actualSendToRoomResult.getAddress());
    assertSame(buttons, data.get("buttons"));
  }
}
