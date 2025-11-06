package org.finos.springbot.example.claim.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.form.Button;
import org.finos.springbot.workflow.form.ButtonList;
import org.finos.springbot.workflow.form.ErrorMap;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClaimController.class, AllConversations.class})
@ExtendWith(SpringExtension.class)
class ClaimControllerDiffblueTest {
  @Autowired
  private ClaimController claimController;

  /**
   * Method under test: {@link ClaimController#open(Addressable)}
   */
  @Test
  void testOpen() {
    // Arrange and Act
    NewClaim actualOpenResult = claimController.open(new SymphonyRoom("Name", "42"));

    // Assert
    assertNull(actualOpenResult.getAmount());
    assertNull(actualOpenResult.getDescription());
  }

  /**
   * Method under test: {@link ClaimController#approve(OpenedClaim, User, Chat)}
   */
  @Test
  void testApprove() {
    // Arrange
    OpenedClaim c = new OpenedClaim();
    c.setAmount(Integer.valueOf(1));
    c.setApprovedBy(new SymphonyUser(1L));
    SymphonyUser author = new SymphonyUser(1L);
    c.setAuthor(author);
    c.setDescription("The characteristics of someone or something");
    c.setPaidBy(new SymphonyUser(1L));
    c.setStatus(OpenedClaim.Status.OPEN);
    SymphonyUser currentUser = new SymphonyUser(1L);
    SymphonyRoom approvalRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualApproveResult = claimController.approve(c, currentUser, approvalRoom);

    // Assert
    assertEquals(2, actualApproveResult.size());
    Response getResult = actualApproveResult.get(0);
    ButtonList buttons = ((WorkResponse) getResult).getButtons();
    Collection<Button> contents = buttons.getContents();
    assertTrue(contents instanceof List);
    Response getResult2 = actualApproveResult.get(1);
    ButtonList buttons2 = ((WorkResponse) getResult2).getButtons();
    Collection<Button> contents2 = buttons2.getContents();
    assertTrue(contents2 instanceof List);
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Object getResult3 = data.get("errors");
    assertTrue(getResult3 instanceof ErrorMap);
    Map<String, Object> data2 = ((WorkResponse) getResult2).getData();
    assertEquals(3, data2.size());
    Object getResult4 = data2.get("errors");
    assertTrue(getResult4 instanceof ErrorMap);
    assertTrue(getResult instanceof WorkResponse);
    assertTrue(getResult2 instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals("default-view", ((WorkResponse) getResult2).getTemplateName());
    assertEquals(0, buttons.size());
    assertEquals(0, buttons2.size());
    assertEquals(0, ((ErrorMap) getResult3).size());
    assertEquals(0, ((ErrorMap) getResult4).size());
    assertEquals(OpenedClaim.Status.APPROVED, c.getStatus());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult2).getMode());
    assertTrue(contents.isEmpty());
    assertTrue(contents2.isEmpty());
    assertTrue(((ErrorMap) getResult3).getContents().isEmpty());
    assertTrue(((ErrorMap) getResult4).getContents().isEmpty());
    Class<OpenedClaim> expectedFormClass = OpenedClaim.class;
    Class<?> formClass = ((WorkResponse) getResult).getFormClass();
    assertEquals(expectedFormClass, formClass);
    assertSame(c, data.get("form"));
    assertSame(c, data2.get("form"));
    assertSame(c, ((WorkResponse) getResult).getFormObject());
    assertSame(c, ((WorkResponse) getResult2).getFormObject());
    assertSame(approvalRoom, getResult2.getAddress());
    assertSame(author, getResult.getAddress());
    assertSame(buttons, data.get("buttons"));
    assertSame(buttons2, data2.get("buttons"));
    assertSame(formClass, ((WorkResponse) getResult2).getFormClass());
  }

  /**
   * Method under test: {@link ClaimController#approve(OpenedClaim, User, Chat)}
   */
  @Test
  void testApprove2() {
    // Arrange
    OpenedClaim c = new OpenedClaim();
    c.setAmount(Integer.valueOf(1));
    c.setApprovedBy(new SymphonyUser(1L));
    c.setAuthor(new SymphonyUser(1L));
    c.setDescription("The characteristics of someone or something");
    c.setPaidBy(new SymphonyUser(1L));
    c.setStatus(OpenedClaim.Status.APPROVED);
    SymphonyUser currentUser = new SymphonyUser(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> claimController.approve(c, currentUser, new SymphonyRoom("Name", "42")));
  }
}
