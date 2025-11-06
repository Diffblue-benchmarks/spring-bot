package org.finos.springbot.example.claim.expenses;

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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.finos.springbot.example.claim.expenses.OpenedClaim.Status;
import org.finos.springbot.symphony.content.SymphonyRoom;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.annotations.WorkMode;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Chat;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.User;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.finos.springbot.workflow.response.MessageResponse;
import org.finos.springbot.workflow.response.Response;
import org.finos.springbot.workflow.response.WorkResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClaimController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ClaimControllerDiffblueTest {
  @MockBean
  private AllConversations allConversations;

  @Autowired
  private ClaimController claimController;

  /**
   * Test {@link ClaimController#open(Addressable)}.
   * <p>
   * Method under test: {@link ClaimController#open(Addressable)}
   */
  @Test
  @DisplayName("Test open(Addressable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NewClaim ClaimController.open(Addressable)"})
  void testOpen() {
    // Arrange and Act
    NewClaim actualOpenResult = claimController.open(mock(Addressable.class));

    // Assert
    assertNull(actualOpenResult.getAmount());
    assertNull(actualOpenResult.getDescription());
  }

  /**
   * Test {@link ClaimController#add(NewClaim, User, Addressable)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimController#add(NewClaim, User, Addressable)}
   */
  @Test
  @DisplayName("Test add(NewClaim, User, Addressable); then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClaimController.add(NewClaim, User, Addressable)"})
  void testAdd_thenReturnSizeIsTwo() {
    // Arrange
    SymphonyRoom symphonyRoom = new SymphonyRoom("Name", "42");

    when(allConversations.getExistingChat(Mockito.<String>any())).thenReturn(symphonyRoom);

    NewClaim sc = new NewClaim();
    sc.setAmount(Integer.valueOf(1));
    sc.setDescription("The characteristics of someone or something");
    Addressable from = mock(Addressable.class);

    // Act
    List<Response> actualAddResult = claimController.add(sc, new SymphonyUser(1L), from);

    // Assert
    verify(allConversations).getExistingChat(eq("Claim Approval Room"));
    assertEquals(2, actualAddResult.size());
    Response getResult = actualAddResult.get(0);
    assertTrue(((WorkResponse) getResult).getFormObject() instanceof OpenedClaim);
    Addressable address = getResult.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Response getResult2 = actualAddResult.get(1);
    assertTrue(((MessageResponse) getResult2).getMessage() instanceof MessageImpl);
    assertTrue(getResult2 instanceof MessageResponse);
    assertTrue(getResult instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertNull(((MessageResponse) getResult2).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(((MessageResponse) getResult2).getData().isEmpty());
    Class<OpenedClaim> expectedFormClass = OpenedClaim.class;
    assertEquals(expectedFormClass, ((WorkResponse) getResult).getFormClass());
    assertSame(symphonyRoom, address);
    assertSame(from, getResult2.getAddress());
  }

  /**
   * Test {@link ClaimController#add(NewClaim, User, Addressable)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimController#add(NewClaim, User, Addressable)}
   */
  @Test
  @DisplayName("Test add(NewClaim, User, Addressable); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClaimController.add(NewClaim, User, Addressable)"})
  void testAdd_thenThrowRuntimeException() {
    // Arrange
    when(allConversations.getExistingChat(Mockito.<String>any()))
        .thenThrow(new RuntimeException("Claim Approval Room"));

    NewClaim sc = new NewClaim();
    sc.setAmount(Integer.valueOf(1));
    sc.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> claimController.add(sc, new SymphonyUser(1L), mock(Addressable.class)));
    verify(allConversations).getExistingChat(eq("Claim Approval Room"));
  }

  /**
   * Test {@link ClaimController#approve(OpenedClaim, User, Chat)}.
   * <ul>
   *   <li>When {@link OpenedClaim} (default constructor) Amount is valueOf one.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimController#approve(OpenedClaim, User, Chat)}
   */
  @Test
  @DisplayName("Test approve(OpenedClaim, User, Chat); when OpenedClaim (default constructor) Amount is valueOf one; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClaimController.approve(OpenedClaim, User, Chat)"})
  void testApprove_whenOpenedClaimAmountIsValueOfOne_thenReturnSizeIsTwo() {
    // Arrange
    OpenedClaim c = new OpenedClaim();
    c.setAmount(Integer.valueOf(1));
    SymphonyUser approvedBy = new SymphonyUser(1L);
    c.setApprovedBy(approvedBy);
    SymphonyUser author = new SymphonyUser(1L);
    c.setAuthor(author);
    c.setDescription("The characteristics of someone or something");
    c.setPaidBy(new SymphonyUser(1L));
    c.setStatus(Status.OPEN);
    SymphonyUser currentUser = new SymphonyUser(1L);
    SymphonyRoom approvalRoom = new SymphonyRoom("Name", "42");

    // Act
    List<Response> actualApproveResult = claimController.approve(c, currentUser, approvalRoom);

    // Assert
    assertEquals(2, actualApproveResult.size());
    Response getResult = actualApproveResult.get(0);
    Object formObject = ((WorkResponse) getResult).getFormObject();
    assertTrue(formObject instanceof OpenedClaim);
    Response getResult2 = actualApproveResult.get(1);
    Addressable address = getResult2.getAddress();
    assertTrue(address instanceof SymphonyRoom);
    Addressable address2 = getResult.getAddress();
    assertTrue(address2 instanceof SymphonyUser);
    assertTrue(getResult instanceof WorkResponse);
    assertTrue(getResult2 instanceof WorkResponse);
    assertEquals("default-view", ((WorkResponse) getResult).getTemplateName());
    assertEquals("default-view", ((WorkResponse) getResult2).getTemplateName());
    Map<String, Object> data = ((WorkResponse) getResult).getData();
    assertEquals(3, data.size());
    Map<String, Object> data2 = ((WorkResponse) getResult2).getData();
    assertEquals(3, data2.size());
    assertEquals(Status.APPROVED, c.getStatus());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult).getMode());
    assertEquals(WorkMode.VIEW, ((WorkResponse) getResult2).getMode());
    assertTrue(data.containsKey("buttons"));
    assertTrue(data.containsKey("errors"));
    assertTrue(data.containsKey("form"));
    assertTrue(data2.containsKey("buttons"));
    assertTrue(data2.containsKey("errors"));
    assertTrue(data2.containsKey("form"));
    assertEquals(approvedBy, address2);
    Class<OpenedClaim> expectedFormClass = OpenedClaim.class;
    Class<?> formClass = ((WorkResponse) getResult).getFormClass();
    assertEquals(expectedFormClass, formClass);
    assertSame(c, formObject);
    assertSame(c, ((WorkResponse) getResult2).getFormObject());
    assertSame(approvalRoom, address);
    assertSame(author, address2);
    assertSame(formClass, ((WorkResponse) getResult2).getFormClass());
  }

  /**
   * Test {@link ClaimController#approve(OpenedClaim, User, Chat)}.
   * <ul>
   *   <li>When {@link OpenedClaim} {@link OpenedClaim#setAmount(Number)} does nothing.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimController#approve(OpenedClaim, User, Chat)}
   */
  @Test
  @DisplayName("Test approve(OpenedClaim, User, Chat); when OpenedClaim setAmount(Number) does nothing; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ClaimController.approve(OpenedClaim, User, Chat)"})
  void testApprove_whenOpenedClaimSetAmountDoesNothing_thenThrowRuntimeException() {
    // Arrange
    OpenedClaim c = mock(OpenedClaim.class);
    doNothing().when(c).setAmount(Mockito.<Number>any());
    doNothing().when(c).setApprovedBy(Mockito.<User>any());
    doNothing().when(c).setAuthor(Mockito.<User>any());
    doNothing().when(c).setDescription(Mockito.<String>any());
    doNothing().when(c).setPaidBy(Mockito.<User>any());
    doNothing().when(c).setStatus(Mockito.<Status>any());
    c.setAmount(Integer.valueOf(1));
    c.setApprovedBy(new SymphonyUser(1L));
    c.setAuthor(new SymphonyUser(1L));
    c.setDescription("The characteristics of someone or something");
    c.setPaidBy(new SymphonyUser(1L));
    c.setStatus(Status.OPEN);
    SymphonyUser currentUser = new SymphonyUser(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> claimController.approve(c, currentUser, new SymphonyRoom("Name", "42")));
    verify(c).setAmount(isA(Number.class));
    verify(c).setApprovedBy(isA(User.class));
    verify(c).setAuthor(isA(User.class));
    verify(c).setDescription(eq("The characteristics of someone or something"));
    verify(c).setPaidBy(isA(User.class));
    verify(c).setStatus(eq(Status.OPEN));
  }
}
