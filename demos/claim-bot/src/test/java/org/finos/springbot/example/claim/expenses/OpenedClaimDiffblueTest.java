package org.finos.springbot.example.claim.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.example.claim.expenses.OpenedClaim.Status;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OpenedClaimDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OpenedClaim#setAmount(Number)}
   *   <li>{@link OpenedClaim#setApprovedBy(User)}
   *   <li>{@link OpenedClaim#setAuthor(User)}
   *   <li>{@link OpenedClaim#setDescription(String)}
   *   <li>{@link OpenedClaim#setPaidBy(User)}
   *   <li>{@link OpenedClaim#setStatus(Status)}
   *   <li>{@link OpenedClaim#getAmount()}
   *   <li>{@link OpenedClaim#getApprovedBy()}
   *   <li>{@link OpenedClaim#getAuthor()}
   *   <li>{@link OpenedClaim#getDescription()}
   *   <li>{@link OpenedClaim#getPaidBy()}
   *   <li>{@link OpenedClaim#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Number org.finos.springbot.example.claim.expenses.OpenedClaim.getAmount()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.claim.expenses.OpenedClaim.getApprovedBy()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.claim.expenses.OpenedClaim.getAuthor()",
      "java.lang.String org.finos.springbot.example.claim.expenses.OpenedClaim.getDescription()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.example.claim.expenses.OpenedClaim.getPaidBy()",
      "org.finos.springbot.example.claim.expenses.OpenedClaim$Status org.finos.springbot.example.claim.expenses.OpenedClaim.getStatus()",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setAmount(java.lang.Number)",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setApprovedBy(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setAuthor(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setDescription(java.lang.String)",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setPaidBy(org.finos.springbot.workflow.content.User)",
      "void org.finos.springbot.example.claim.expenses.OpenedClaim.setStatus(org.finos.springbot.example.claim.expenses.OpenedClaim$Status)"})
  void testGettersAndSetters() {
    // Arrange
    OpenedClaim openedClaim = new OpenedClaim();
    Integer amount = Integer.valueOf(1);

    // Act
    openedClaim.setAmount(amount);
    SymphonyUser approvedBy = new SymphonyUser(1L);
    openedClaim.setApprovedBy(approvedBy);
    SymphonyUser author = new SymphonyUser(1L);
    openedClaim.setAuthor(author);
    openedClaim.setDescription("The characteristics of someone or something");
    SymphonyUser paidBy = new SymphonyUser(1L);
    openedClaim.setPaidBy(paidBy);
    openedClaim.setStatus(Status.OPEN);
    Number actualAmount = openedClaim.getAmount();
    User actualApprovedBy = openedClaim.getApprovedBy();
    User actualAuthor = openedClaim.getAuthor();
    String actualDescription = openedClaim.getDescription();
    User actualPaidBy = openedClaim.getPaidBy();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(Status.OPEN, openedClaim.getStatus());
    assertSame(approvedBy, actualApprovedBy);
    assertSame(author, actualAuthor);
    assertSame(paidBy, actualPaidBy);
    assertSame(amount, actualAmount);
  }

  /**
   * Test new {@link OpenedClaim} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OpenedClaim}
   */
  @Test
  @DisplayName("Test new OpenedClaim (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.example.claim.expenses.OpenedClaim.<init>()"})
  void testNewOpenedClaim() {
    // Arrange and Act
    OpenedClaim actualOpenedClaim = new OpenedClaim();

    // Assert
    assertNull(actualOpenedClaim.getAmount());
    assertNull(actualOpenedClaim.getDescription());
    assertNull(actualOpenedClaim.getApprovedBy());
    assertNull(actualOpenedClaim.getAuthor());
    assertNull(actualOpenedClaim.getPaidBy());
    assertEquals(Status.OPEN, actualOpenedClaim.getStatus());
  }
}
