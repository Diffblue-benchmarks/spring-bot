package org.finos.springbot.example.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private ToDoController toDoController;

  /**
   * Test {@link ToDoController#init()}.
   *
   * <p>Method under test: {@link ToDoController#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.init()"})
  void testInit() {
    // Arrange, Act and Assert
    assertTrue(toDoController.init().getItems().isEmpty());
  }

  /**
   * Test {@link ToDoController#add1(User)}.
   *
   * <p>Method under test: {@link ToDoController#add1(User)}
   */
  @Test
  @DisplayName("Test add1(User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NewItemDetails ToDoController.add1(User)"})
  void testAdd1() {
    // Arrange
    SymphonyUser author = new SymphonyUser();

    // Act
    NewItemDetails actualAdd1Result = toDoController.add1(author);

    // Assert
    User assignTo = actualAdd1Result.getAssignTo();
    assertTrue(assignTo instanceof SymphonyUser);
    assertNull(actualAdd1Result.getDescription());
    assertNull(((SymphonyUser) assignTo).getId());
    assertSame(author, assignTo);
  }

  /**
   * Test {@link ToDoController#add(NewItemDetails, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test add(NewItemDetails, User, Optional); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.add(NewItemDetails, User, Optional)"})
  void testAdd_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    NewItemDetails a = new NewItemDetails();
    a.setAssignTo(new SymphonyUser());
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser();

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.add(a, u, toDo));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#add(NewItemDetails, User, Optional)}.
   *
   * <ul>
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return {@link ToDoList#ToDoList()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#add(NewItemDetails, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test add(NewItemDetails, User, Optional); when of ToDoList(); then return ToDoList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.add(NewItemDetails, User, Optional)"})
  void testAdd_whenOfToDoList_thenReturnToDoList() {
    // Arrange
    NewItemDetails a = new NewItemDetails();
    a.setAssignTo(new SymphonyUser());
    a.setDescription("The characteristics of someone or something");
    SymphonyUser u = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertSame(toDoList, toDoController.add(a, u, toDo));
  }

  /**
   * Test {@link ToDoController#cancel(Optional)}.
   *
   * <p>Method under test: {@link ToDoController#cancel(Optional)}
   */
  @Test
  @DisplayName("Test cancel(Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName("Test show(Optional); given ArrayList() add ToDoItem(); then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_givenArrayListAddToDoItem_thenCallsGetItems() {
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
   * Test {@link ToDoController#show(Optional)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName(
      "Test show(Optional); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.show(in));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#show(Optional)}.
   *
   * <ul>
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#show(Optional)}
   */
  @Test
  @DisplayName("Test show(Optional); when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.show(Optional)"})
  void testShow_whenOfToDoList_thenReturnItemsEmpty() {
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName("Test edit(Optional); given ArrayList() add ToDoItem(); then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_givenArrayListAddToDoItem_thenCallsGetItems() {
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
   * Test {@link ToDoController#edit(Optional)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName(
      "Test edit(Optional); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> in = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.edit(in));
    verify(toDoList).getItems();
  }

  /**
   * Test {@link ToDoController#edit(Optional)}.
   *
   * <ul>
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#edit(Optional)}
   */
  @Test
  @DisplayName("Test edit(Optional); when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.edit(Optional)"})
  void testEdit_whenOfToDoList_thenReturnItemsEmpty() {
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given ArrayList() add ToDoItem(); then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenArrayListAddToDoItem_thenCallsGetItems() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word2);
    toDelete.add(word);

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    toDoController.delete(toDelete, toDo);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#delete(List, Optional)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word2);
    toDelete.add(word);

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.delete(toDelete, toDo));
    verify(toDoList).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#delete(List, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code 42}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given Word getText() return '42'; then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextReturn42_thenCallsGetItems() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");

    ArrayList<Word> toDelete = new ArrayList<>();
    toDelete.add(word2);
    toDelete.add(word);

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    toDoController.delete(toDelete, toDo);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#delete(List, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code Text}.
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given Word getText() return 'Text'; when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextReturnText_whenOfToDoList_thenReturnItemsEmpty() {
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
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code Text}.
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given Word getText() return 'Text'; when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextReturnText_whenOfToDoList_thenReturnItemsEmpty2() {
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
   * Test {@link ToDoController#delete(List, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName(
      "Test delete(List, Optional); given Word getText() throw NumberFormatException(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.delete(List, Optional)"})
  void testDelete_givenWordGetTextThrowNumberFormatException_thenReturnItemsEmpty() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenThrow(new NumberFormatException());

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#delete(List, Optional)}
   */
  @Test
  @DisplayName("Test delete(List, Optional); when ArrayList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then first Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); given ArrayList() add ToDoItem(); then first Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenArrayListAddToDoItem_thenFirstButtonsContentsReturnList() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom();

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(theRoom, address);
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then first Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); given ArrayList() add ToDoItem(); then first Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenArrayListAddToDoItem_thenFirstButtonsContentsReturnList2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom();

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(theRoom, address);
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> toDoController.complete(words, by, a, toDo, new SymphonyRoom()));
    verify(toDoList).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code 42}.
   *   <li>Then first Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); given Word getText() return '42'; then first Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenWordGetTextReturn42_thenFirstButtonsContentsReturnList() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);
    SymphonyRoom theRoom = new SymphonyRoom();

    // Act
    List<Response> actualCompleteResult = toDoController.complete(words, by, a, toDo, theRoom);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(contents.isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(theRoom, address);
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); given Word getText() throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_givenWordGetTextThrowNumberFormatException() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenThrow(new NumberFormatException());

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    List<Response> actualCompleteResult =
        toDoController.complete(words, by, a, toDo, new SymphonyRoom());

    // Assert
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    assertTrue(getResult instanceof WorkResponse);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    assertTrue(data.containsKey("errors"));
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, formObject);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return first Buttons Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); when ArrayList(); then return first Buttons Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenArrayList_thenReturnFirstButtonsContentsIsArrayList() {
    // Arrange
    ArrayList<Word> words = new ArrayList<>();
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    List<Response> actualCompleteResult =
        toDoController.complete(words, by, a, toDo, new SymphonyRoom());

    // Assert
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    assertTrue(getResult instanceof WorkResponse);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    assertTrue(data.containsKey("errors"));
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    assertEquals(words, buttons.getContents());
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, formObject);
    assertSame(buttons, data.get("buttons"));
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then first FormObject return {@link ToDoList}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); when of ToDoList(); then first FormObject return ToDoList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenOfToDoList_thenFirstFormObjectReturnToDoList() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    List<Response> actualCompleteResult =
        toDoController.complete(words, by, a, toDo, new SymphonyRoom());

    // Assert
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    assertTrue(getResult instanceof WorkResponse);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    assertTrue(data.containsKey("errors"));
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, formObject);
  }

  /**
   * Test {@link ToDoController#complete(List, Optional, User, Optional, Chat)}.
   *
   * <ul>
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then first FormObject return {@link ToDoList}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#complete(List, Optional, User, Optional, Chat)}
   */
  @Test
  @DisplayName(
      "Test complete(List, Optional, User, Optional, Chat); when of ToDoList(); then first FormObject return ToDoList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ToDoController.complete(List, Optional, User, Optional, Chat)"})
  void testComplete_whenOfToDoList_thenFirstFormObjectReturnToDoList2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    List<Response> actualCompleteResult =
        toDoController.complete(words, by, a, toDo, new SymphonyRoom());

    // Assert
    verify(word2).getText();
    verify(word).getText();
    assertEquals(1, actualCompleteResult.size());
    Response getResult = actualCompleteResult.get(0);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof ToDoList);
    assertTrue(getResult instanceof WorkResponse);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    assertTrue(data.containsKey("errors"));
    assertSame(toDoList, data.get("form"));
    assertSame(toDoList, formObject);
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given ArrayList() add ToDoItem(); then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenArrayListAddToDoItem_thenCallsGetItems() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    toDoController.assign(words, by, a, toDo);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToDoItem#ToDoItem()}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given ArrayList() add ToDoItem(); then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenArrayListAddToDoItem_thenCallsGetItems2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    toDoController.assign(words, by, a, toDo);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given NumberFormatException(); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenNumberFormatException_thenThrowNumberFormatException() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenThrow(new NumberFormatException());
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> toDoController.assign(words, by, a, toDo));
    verify(toDoList).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code 42}.
   *   <li>Then calls {@link ToDoList#getItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given Word getText() return '42'; then calls getItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenWordGetTextReturn42_thenCallsGetItems() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("42");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();

    ArrayList<ToDoItem> toDoItemList = new ArrayList<>();
    toDoItemList.add(new ToDoItem());

    ToDoList toDoList = mock(ToDoList.class);
    when(toDoList.getItems()).thenReturn(toDoItemList);
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    toDoController.assign(words, by, a, toDo);

    // Assert
    verify(toDoList, atLeast(1)).getItems();
    verify(word2).getText();
    verify(word).getText();
  }

  /**
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code Text}.
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given Word getText() return 'Text'; when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenWordGetTextReturnText_whenOfToDoList_thenReturnItemsEmpty() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
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
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} return {@code Text}.
   *   <li>When of {@link ToDoList#ToDoList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given Word getText() return 'Text'; when of ToDoList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenWordGetTextReturnText_whenOfToDoList_thenReturnItemsEmpty2() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> words = new ArrayList<>();
    words.add(word2);
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
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
   * Test {@link ToDoController#assign(List, Optional, User, Optional)}.
   *
   * <ul>
   *   <li>Given {@link Word} {@link Word#getText()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); given Word getText() throw NumberFormatException(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_givenWordGetTextThrowNumberFormatException_thenReturnItemsEmpty() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenThrow(new NumberFormatException());

    ArrayList<Word> words = new ArrayList<>();
    words.add(word);
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Items Empty.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#assign(List, Optional, User, Optional)}
   */
  @Test
  @DisplayName(
      "Test assign(List, Optional, User, Optional); when ArrayList(); then return Items Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ToDoList ToDoController.assign(List, Optional, User, Optional)"})
  void testAssign_whenArrayList_thenReturnItemsEmpty() {
    // Arrange
    ArrayList<Word> words = new ArrayList<>();
    Optional<User> by = Optional.of(new SymphonyUser());
    SymphonyUser a = new SymphonyUser();
    ToDoList toDoList = new ToDoList();
    Optional<ToDoList> toDo = Optional.of(toDoList);

    // Act
    ToDoList actualAssignResult = toDoController.assign(words, by, a, toDo);

    // Assert
    assertTrue(actualAssignResult.getItems().isEmpty());
    assertSame(toDoList, actualAssignResult);
  }

  /**
   * Test {@link ToDoController#sendToRoom()}.
   *
   * <p>Method under test: {@link ToDoController#sendToRoom()}
   */
  @Test
  @DisplayName("Test sendToRoom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SendToRoom ToDoController.sendToRoom()"})
  void testSendToRoom() {
    // Arrange, Act and Assert
    assertNull(toDoController.sendToRoom().getRoom());
  }

  /**
   * Test {@link ToDoController#sendToRoom(SendToRoom, ToDoList)} with {@code SendToRoom}, {@code
   * ToDoList}.
   *
   * <ul>
   *   <li>When {@link ToDoList#ToDoList()}.
   *   <li>Then Buttons Contents return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ToDoController#sendToRoom(SendToRoom, ToDoList)}
   */
  @Test
  @DisplayName(
      "Test sendToRoom(SendToRoom, ToDoList) with 'SendToRoom', 'ToDoList'; when ToDoList(); then Buttons Contents return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse ToDoController.sendToRoom(SendToRoom, ToDoList)"})
  void testSendToRoomWithSendToRoomToDoList_whenToDoList_thenButtonsContentsReturnList() {
    // Arrange
    SendToRoom theForm = new SendToRoom();
    SymphonyRoom room = new SymphonyRoom();
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
    Addressable address = actualSendToRoomResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Map<String, Object> data = actualSendToRoomResult.getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertEquals("default-view", actualSendToRoomResult.getTemplateName());
    assertNull(((SymphonyRoom) address).getId());
    assertEquals(0, buttons.size());
    assertEquals(WorkMode.VIEW, actualSendToRoomResult.getMode());
    assertTrue(contents.isEmpty());
    assertTrue(((ToDoList) formObject).getItems().isEmpty());
    Class<ToDoList> expectedFormClass = ToDoList.class;
    assertEquals(expectedFormClass, actualSendToRoomResult.getFormClass());
    assertSame(tdl, data.get("form"));
    assertSame(tdl, formObject);
    assertSame(room, address);
    assertSame(buttons, data.get("buttons"));
  }
}
