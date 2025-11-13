package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.springbot.testing.content.TestRoom;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.Table.TableImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.form.FormSubmission;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OurController.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class OurControllerDiffblueTest {
  @Autowired private OurController ourController;

  /**
   * Test {@link OurController#listenToEverything(Message)}.
   *
   * <p>Method under test: {@link OurController#listenToEverything(Message)}
   */
  @Test
  @DisplayName("Test listenToEverything(Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.listenToEverything(Message)"})
  void testListenToEverything() {
    // Arrange
    MessageImpl m = new MessageImpl(new ArrayList<>());

    // Act
    ourController.listenToEverything(m);

    // Assert
    assertEquals("listenToEverything", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Test {@link OurController#callPerson(Person)}.
   *
   * <p>Method under test: {@link OurController#callPerson(Person)}
   */
  @Test
  @DisplayName("Test callPerson(Person)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection OurController.callPerson(Person)"})
  void testCallPerson() {
    // Arrange
    Person arg = new Person();

    // Act
    Collection<TestObject> actualCallPersonResult = ourController.callPerson(arg);

    // Assert
    assertTrue(actualCallPersonResult instanceof List);
    assertEquals("callPerson", ourController.lastMethod);
    assertEquals(1, actualCallPersonResult.size());
    TestObject getResult = ((List<TestObject>) actualCallPersonResult).get(0);
    assertNull(getResult.getAskQty());
    assertNull(getResult.getBidQty());
    assertNull(getResult.getCreator());
    assertNull(getResult.getIsin());
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertFalse(getResult.isAskAxed());
    assertFalse(getResult.isBidAxed());
    assertSame(arg, objectList.get(0));
  }

  /**
   * Test {@link OurController#startNewClaim(StartClaim)}.
   *
   * <p>Method under test: {@link OurController#startNewClaim(StartClaim)}
   */
  @Test
  @DisplayName("Test startNewClaim(StartClaim)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TestObject OurController.startNewClaim(StartClaim)"})
  void testStartNewClaim() {
    // Arrange
    StartClaim sc = new StartClaim();
    sc.setAmount(10.0f);
    sc.setDescription("The characteristics of someone or something");

    // Act
    TestObject actualStartNewClaimResult = ourController.startNewClaim(sc);

    // Assert
    assertEquals("startNewClaim", ourController.lastMethod);
    assertNull(actualStartNewClaimResult.getAskQty());
    assertNull(actualStartNewClaimResult.getBidQty());
    assertNull(actualStartNewClaimResult.getCreator());
    assertNull(actualStartNewClaimResult.getIsin());
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertFalse(actualStartNewClaimResult.isAskAxed());
    assertFalse(actualStartNewClaimResult.isBidAxed());
    assertSame(sc, objectList.get(0));
  }

  /**
   * Test {@link OurController#processForm(FormSubmission)}.
   *
   * <p>Method under test: {@link OurController#processForm(FormSubmission)}
   */
  @Test
  @DisplayName("Test processForm(FormSubmission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.processForm(FormSubmission)"})
  void testProcessForm() {
    // Arrange
    FormSubmission f = new FormSubmission("Form Name", "Structure");

    // Act
    ourController.processForm(f);

    // Assert
    assertEquals("processForm", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(f, objectList.get(0));
  }

  /**
   * Test {@link OurController#doCommand(Message)}.
   *
   * <p>Method under test: {@link OurController#doCommand(Message)}
   */
  @Test
  @DisplayName("Test doCommand(Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.doCommand(Message)"})
  void testDoCommand() {
    // Arrange
    MessageImpl m = new MessageImpl(new ArrayList<>());

    // Act
    ourController.doCommand(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Test {@link OurController#dontDoCommand(Message)}.
   *
   * <p>Method under test: {@link OurController#dontDoCommand(Message)}
   */
  @Test
  @DisplayName("Test dontDoCommand(Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.dontDoCommand(Message)"})
  void testDontDoCommand() {
    // Arrange
    MessageImpl m = new MessageImpl(new ArrayList<>());

    // Act
    ourController.dontDoCommand(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Test {@link OurController#dontDoCommand2(Message)}.
   *
   * <p>Method under test: {@link OurController#dontDoCommand2(Message)}
   */
  @Test
  @DisplayName("Test dontDoCommand2(Message)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.dontDoCommand2(Message)"})
  void testDontDoCommand2() {
    // Arrange
    MessageImpl m = new MessageImpl(new ArrayList<>());

    // Act
    ourController.dontDoCommand2(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Test {@link OurController#userDetails(User)}.
   *
   * <p>Method under test: {@link OurController#userDetails(User)}
   */
  @Test
  @DisplayName("Test userDetails(User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.userDetails(User)"})
  void testUserDetails() {
    // Arrange
    User u = mock(User.class);

    // Act
    ourController.userDetails(u);

    // Assert
    assertEquals("userDetails", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(u, objectList.get(0));
  }

  /**
   * Test {@link OurController#userDetails2(User, User)}.
   *
   * <p>Method under test: {@link OurController#userDetails2(User, User)}
   */
  @Test
  @DisplayName("Test userDetails2(User, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.userDetails2(User, User)"})
  void testUserDetails2() {
    // Arrange
    User u = mock(User.class);
    User author = mock(User.class);

    // Act
    ourController.userDetails2(u, author);

    // Assert
    assertEquals("userDetails2", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertSame(u, objectList.get(0));
    assertSame(author, objectList.get(1));
  }

  /**
   * Test {@link OurController#process1(Table, User)}.
   *
   * <p>Method under test: {@link OurController#process1(Table, User)}
   */
  @Test
  @DisplayName("Test process1(Table, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.process1(Table, User)"})
  void testProcess1() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    TableImpl t = new TableImpl(columns, new ArrayList<>());
    User u = mock(User.class);

    // Act
    ourController.process1(t, u);

    // Assert
    assertEquals("process-table", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertSame(t, objectList.get(0));
    assertSame(u, objectList.get(1));
  }

  /**
   * Test {@link OurController#process2(CodeBlock)}.
   *
   * <p>Method under test: {@link OurController#process2(CodeBlock)}
   */
  @Test
  @DisplayName("Test process2(CodeBlock)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.process2(CodeBlock)"})
  void testProcess2() {
    // Arrange
    CodeBlock cb = mock(CodeBlock.class);

    // Act
    ourController.process2(cb);

    // Assert
    assertEquals("process2", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(cb, objectList.get(0));
  }

  /**
   * Test {@link OurController#addUserToTopic(User, Tag)}.
   *
   * <p>Method under test: {@link OurController#addUserToTopic(User,
   * org.finos.springbot.workflow.content.Tag)}
   */
  @Test
  @DisplayName("Test addUserToTopic(User, Tag)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OurController.addUserToTopic(User, org.finos.springbot.workflow.content.Tag)"
  })
  void testAddUserToTopic() {
    // Arrange
    User u = mock(User.class);
    org.finos.springbot.workflow.content.Tag t =
        mock(org.finos.springbot.workflow.content.Tag.class);

    // Act
    ourController.addUserToTopic(u, t);

    // Assert
    assertEquals("addUserToTopic", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertSame(t, objectList.get(1));
    assertSame(u, objectList.get(0));
  }

  /**
   * Test {@link OurController#removeUserFromRoom(User, Chat)}.
   *
   * <p>Method under test: {@link OurController#removeUserFromRoom(User, Chat)}
   */
  @Test
  @DisplayName("Test removeUserFromRoom(User, Chat)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.removeUserFromRoom(User, Chat)"})
  void testRemoveUserFromRoom() {
    // Arrange
    User u = mock(User.class);
    TestRoom r = new TestRoom("Key", "Name");

    // Act
    ourController.removeUserFromRoom(u, r);

    // Assert
    assertEquals("removeUserFromRoom", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertSame(r, objectList.get(1));
    assertSame(u, objectList.get(0));
  }

  /**
   * Test {@link OurController#banWord(Word, Addressable)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link OurController#banWord(Word, Addressable)}
   */
  @Test
  @DisplayName(
      "Test banWord(Word, Addressable); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.springbot.workflow.response.MessageResponse OurController.banWord(Word, Addressable)"
  })
  void testBanWord_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    Word w = mock(Word.class);
    when(w.getText()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ourController.banWord(w, mock(Addressable.class)));
    verify(w).getText();
  }

  /**
   * Test {@link OurController#attachment(Addressable)}.
   *
   * <p>Method under test: {@link OurController#attachment(Addressable)}
   */
  @Test
  @DisplayName("Test attachment(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttachmentResponse OurController.attachment(Addressable)"})
  void testAttachment() throws UnsupportedEncodingException {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    AttachmentResponse actualAttachmentResult = ourController.attachment(a);

    // Assert
    assertEquals("attachment", ourController.lastMethod);
    assertEquals("somefile", actualAttachmentResult.getName());
    assertEquals("txt", actualAttachmentResult.getExtension());
    assertNull(actualAttachmentResult.getTemplateName());
    assertTrue(ourController.lastArguments.isEmpty());
    assertTrue(actualAttachmentResult.getData().isEmpty());
    assertSame(a, actualAttachmentResult.getAddress());
    assertArrayEquals("payload".getBytes("UTF-8"), actualAttachmentResult.getAttachment());
  }

  /**
   * Test {@link OurController#form1(Addressable)}.
   *
   * <p>Method under test: {@link OurController#form1(Addressable)}
   */
  @Test
  @DisplayName("Test form1(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WorkResponse OurController.form1(Addressable)"})
  void testForm1() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    WorkResponse actualForm1Result = ourController.form1(a);

    // Assert
    ButtonList buttons = actualForm1Result.getButtons();
    Collection<Button> contents = buttons.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    Object formObject = actualForm1Result.getFormObject();
    assertTrue(formObject instanceof TestObject);
    Map<String, Object> data = actualForm1Result.getData();
    assertEquals(3, data.size());
    assertTrue(data.get("errors") instanceof ErrorMap);
    assertEquals("default-edit", actualForm1Result.getTemplateName());
    assertNull(((TestObject) formObject).getAskQty());
    assertNull(((TestObject) formObject).getBidQty());
    assertNull(((TestObject) formObject).getCreator());
    assertNull(((TestObject) formObject).getIsin());
    assertEquals(1, buttons.size());
    assertEquals(WorkMode.EDIT, actualForm1Result.getMode());
    assertFalse(((TestObject) formObject).isAskAxed());
    assertFalse(((TestObject) formObject).isBidAxed());
    Class<TestObject> expectedFormClass = TestObject.class;
    assertEquals(expectedFormClass, actualForm1Result.getFormClass());
    assertSame(buttons, data.get("buttons"));
    assertSame(a, actualForm1Result.getAddress());
    assertSame(formObject, data.get("form"));
  }

  /**
   * Test {@link OurController#form2(Addressable)}.
   *
   * <p>Method under test: {@link OurController#form2(Addressable)}
   */
  @Test
  @DisplayName("Test form2(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TestObject OurController.form2(Addressable)"})
  void testForm2() {
    // Arrange and Act
    TestObject actualForm2Result = ourController.form2(mock(Addressable.class));

    // Assert
    assertNull(actualForm2Result.getAskQty());
    assertNull(actualForm2Result.getBidQty());
    assertNull(actualForm2Result.getCreator());
    assertNull(actualForm2Result.getIsin());
    assertFalse(actualForm2Result.isAskAxed());
    assertFalse(actualForm2Result.isBidAxed());
  }

  /**
   * Test {@link OurController#ok(Person)}.
   *
   * <p>Method under test: {@link OurController#ok(Person)}
   */
  @Test
  @DisplayName("Test ok(Person)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TestObject OurController.ok(Person)"})
  void testOk() {
    // Arrange, Act and Assert
    assertNull(ourController.ok(new Person()));
  }

  /**
   * Test {@link OurController#throwsError()}.
   *
   * <p>Method under test: {@link OurController#throwsError()}
   */
  @Test
  @DisplayName("Test throwsError()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TestObject OurController.throwsError()"})
  void testThrowsError() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ourController.throwsError());
  }

  /**
   * Test {@link OurController#doList(List, Optional, Word)}.
   *
   * <ul>
   *   <li>Given {@link Word}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Word}.
   * </ul>
   *
   * <p>Method under test: {@link OurController#doList(List, Optional, Word)}
   */
  @Test
  @DisplayName("Test doList(List, Optional, Word); given Word; when ArrayList() add Word")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.doList(List, Optional, Word)"})
  void testDoList_givenWord_whenArrayListAddWord() {
    // Arrange
    ArrayList<Word> word = new ArrayList<>();
    word.add(mock(Word.class));
    Optional<User> u = Optional.of(mock(User.class));
    Word w = mock(Word.class);

    // Act
    ourController.doList(word, u, w);

    // Assert
    assertEquals("doList", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(3, objectList.size());
    assertSame(word, objectList.get(0));
    assertSame(u, objectList.get(1));
    assertSame(w, objectList.get(2));
  }

  /**
   * Test {@link OurController#doList(List, Optional, Word)}.
   *
   * <ul>
   *   <li>Given {@link Word}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Word}.
   * </ul>
   *
   * <p>Method under test: {@link OurController#doList(List, Optional, Word)}
   */
  @Test
  @DisplayName("Test doList(List, Optional, Word); given Word; when ArrayList() add Word")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.doList(List, Optional, Word)"})
  void testDoList_givenWord_whenArrayListAddWord2() {
    // Arrange
    ArrayList<Word> word = new ArrayList<>();
    word.add(mock(Word.class));
    word.add(mock(Word.class));
    Optional<User> u = Optional.of(mock(User.class));
    Word w = mock(Word.class);

    // Act
    ourController.doList(word, u, w);

    // Assert
    assertEquals("doList", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(3, objectList.size());
    assertSame(word, objectList.get(0));
    assertSame(u, objectList.get(1));
    assertSame(w, objectList.get(2));
  }

  /**
   * Test {@link OurController#doList(List, Optional, Word)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OurController#doList(List, Optional, Word)}
   */
  @Test
  @DisplayName("Test doList(List, Optional, Word); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OurController.doList(List, Optional, Word)"})
  void testDoList_whenArrayList() {
    // Arrange
    ArrayList<Word> word = new ArrayList<>();
    Optional<User> u = Optional.of(mock(User.class));
    Word w = mock(Word.class);

    // Act
    ourController.doList(word, u, w);

    // Assert
    assertEquals("doList", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(3, objectList.size());
    assertSame(word, objectList.get(0));
    assertSame(u, objectList.get(1));
    assertSame(w, objectList.get(2));
  }
}
