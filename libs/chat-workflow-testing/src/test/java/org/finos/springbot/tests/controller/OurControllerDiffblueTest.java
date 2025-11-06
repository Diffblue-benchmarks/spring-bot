package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.Tag;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.form.FormSubmission;
import org.finos.springbot.workflow.response.AttachmentResponse;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OurController.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OurControllerDiffblueTest {
  @Autowired
  private OurController ourController;

  /**
   * Method under test: {@link OurController#listenToEverything(Message)}
   */
  @Test
  void testListenToEverything() {
    // Arrange
    Message.MessageImpl m = new Message.MessageImpl(new ArrayList<>());

    // Act
    ourController.listenToEverything(m);

    // Assert
    assertEquals("listenToEverything", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#callPerson(Person)}
   */
  @Test
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
   * Method under test: {@link OurController#startNewClaim(StartClaim)}
   */
  @Test
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
   * Method under test: {@link OurController#processForm(FormSubmission)}
   */
  @Test
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
   * Method under test: {@link OurController#doCommand(Message)}
   */
  @Test
  void testDoCommand() {
    // Arrange
    Message.MessageImpl m = new Message.MessageImpl(new ArrayList<>());

    // Act
    ourController.doCommand(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#dontDoCommand(Message)}
   */
  @Test
  void testDontDoCommand() {
    // Arrange
    Message.MessageImpl m = new Message.MessageImpl(new ArrayList<>());

    // Act
    ourController.dontDoCommand(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#dontDoCommand2(Message)}
   */
  @Test
  void testDontDoCommand2() {
    // Arrange
    Message.MessageImpl m = new Message.MessageImpl(new ArrayList<>());

    // Act
    ourController.dontDoCommand2(m);

    // Assert
    assertEquals("doCommand", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(m, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#userDetails(User)}
   */
  @Test
  void testUserDetails() {
    // Arrange and Act
    ourController.userDetails(null);

    // Assert
    assertEquals("userDetails", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertNull(objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#userDetails2(User, User)}
   */
  @Test
  void testUserDetails2() {
    // Arrange and Act
    ourController.userDetails2(null, null);

    // Assert
    assertEquals("userDetails2", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertNull(objectList.get(0));
    assertNull(objectList.get(1));
  }

  /**
   * Method under test: {@link OurController#process1(Table, User)}
   */
  @Test
  void testProcess1() {
    // Arrange
    ArrayList<Content> columns = new ArrayList<>();
    Table.TableImpl t = new Table.TableImpl(columns, new ArrayList<>());

    // Act
    ourController.process1(t, null);

    // Assert
    assertEquals("process-table", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertNull(objectList.get(1));
    assertSame(t, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#process2(CodeBlock)}
   */
  @Test
  void testProcess2() {
    // Arrange
    CodeBlock.CodeBlockImpl cb = new CodeBlock.CodeBlockImpl("foo");

    // Act
    ourController.process2(cb);

    // Assert
    assertEquals("process2", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(1, objectList.size());
    assertSame(cb, objectList.get(0));
  }

  /**
   * Method under test: {@link OurController#addUserToTopic(User, Tag)}
   */
  @Test
  void testAddUserToTopic() {
    // Arrange and Act
    ourController.addUserToTopic(null, null);

    // Assert
    assertEquals("addUserToTopic", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertNull(objectList.get(0));
    assertNull(objectList.get(1));
  }

  /**
   * Method under test: {@link OurController#removeUserFromRoom(User, Chat)}
   */
  @Test
  void testRemoveUserFromRoom() {
    // Arrange
    TestRoom r = new TestRoom("Key", "Name");

    // Act
    ourController.removeUserFromRoom(null, r);

    // Assert
    assertEquals("removeUserFromRoom", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(2, objectList.size());
    assertNull(objectList.get(0));
    assertSame(r, objectList.get(1));
  }

  /**
   * Method under test: {@link OurController#attachment(Addressable)}
   */
  @Test
  void testAttachment() throws UnsupportedEncodingException {
    // Arrange
    TestRoom a = new TestRoom("Key", "Name");

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
    byte[] expectedAttachment = "payload".getBytes("UTF-8");
    assertArrayEquals(expectedAttachment, actualAttachmentResult.getAttachment());
  }

  /**
   * Method under test: {@link OurController#form1(Addressable)}
   */
  @Test
  void testForm1() {
    // Arrange
    TestRoom a = new TestRoom("Key", "Name");

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
    Object getResult = data.get("errors");
    assertTrue(getResult instanceof ErrorMap);
    Button getResult2 = ((List<Button>) contents).get(0);
    assertEquals("Do The Thing", getResult2.getText());
    assertEquals("default-edit", actualForm1Result.getTemplateName());
    assertEquals("go", getResult2.getName());
    assertNull(((TestObject) formObject).getAskQty());
    assertNull(((TestObject) formObject).getBidQty());
    assertNull(((TestObject) formObject).getCreator());
    assertNull(((TestObject) formObject).getIsin());
    assertEquals(0, ((ErrorMap) getResult).size());
    assertEquals(1, buttons.size());
    assertEquals(WorkMode.EDIT, actualForm1Result.getMode());
    assertEquals(Button.Type.ACTION, getResult2.getButtonType());
    assertFalse(((TestObject) formObject).isAskAxed());
    assertFalse(((TestObject) formObject).isBidAxed());
    assertTrue(((ErrorMap) getResult).getContents().isEmpty());
    Class<TestObject> expectedFormClass = TestObject.class;
    assertEquals(expectedFormClass, actualForm1Result.getFormClass());
    assertSame(a, actualForm1Result.getAddress());
    assertSame(buttons, data.get("buttons"));
    assertSame(formObject, data.get("form"));
  }

  /**
   * Method under test: {@link OurController#form2(Addressable)}
   */
  @Test
  void testForm2() {
    // Arrange and Act
    TestObject actualForm2Result = ourController.form2(new TestRoom("Key", "Name"));

    // Assert
    assertNull(actualForm2Result.getAskQty());
    assertNull(actualForm2Result.getBidQty());
    assertNull(actualForm2Result.getCreator());
    assertNull(actualForm2Result.getIsin());
    assertFalse(actualForm2Result.isAskAxed());
    assertFalse(actualForm2Result.isBidAxed());
  }

  /**
   * Method under test: {@link OurController#ok(Person)}
   */
  @Test
  void testOk() {
    // Arrange, Act and Assert
    assertNull(ourController.ok(new Person()));
  }

  /**
   * Method under test: {@link OurController#throwsError()}
   */
  @Test
  void testThrowsError() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ourController.throwsError());
  }

  /**
   * Method under test: {@link OurController#doList(List, Optional, Word)}
   */
  @Test
  void testDoList() {
    // Arrange
    ArrayList<Word> word = new ArrayList<>();
    Optional<User> u = Optional.empty();

    // Act
    ourController.doList(word, u, null);

    // Assert
    assertEquals("doList", ourController.lastMethod);
    List<Object> objectList = ourController.lastArguments;
    assertEquals(3, objectList.size());
    assertNull(objectList.get(2));
    assertSame(word, objectList.get(0));
    assertSame(u, objectList.get(1));
  }
}
