package org.finos.springbot.example.claim.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;

class OpenedClaimDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OpenedClaim#setAmount(Number)}
   *   <li>{@link OpenedClaim#setApprovedBy(User)}
   *   <li>{@link OpenedClaim#setAuthor(User)}
   *   <li>{@link OpenedClaim#setDescription(String)}
   *   <li>{@link OpenedClaim#setPaidBy(User)}
   *   <li>{@link OpenedClaim#setStatus(OpenedClaim.Status)}
   *   <li>{@link OpenedClaim#getAmount()}
   *   <li>{@link OpenedClaim#getApprovedBy()}
   *   <li>{@link OpenedClaim#getAuthor()}
   *   <li>{@link OpenedClaim#getDescription()}
   *   <li>{@link OpenedClaim#getPaidBy()}
   *   <li>{@link OpenedClaim#getStatus()}
   * </ul>
   */
  @Test
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
    openedClaim.setStatus(OpenedClaim.Status.OPEN);
    Number actualAmount = openedClaim.getAmount();
    User actualApprovedBy = openedClaim.getApprovedBy();
    User actualAuthor = openedClaim.getAuthor();
    String actualDescription = openedClaim.getDescription();
    User actualPaidBy = openedClaim.getPaidBy();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(OpenedClaim.Status.OPEN, openedClaim.getStatus());
    assertSame(approvedBy, actualApprovedBy);
    assertSame(author, actualAuthor);
    assertSame(paidBy, actualPaidBy);
    assertSame(amount, actualAmount);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OpenedClaim}
   */
  @Test
  void testNewOpenedClaim() {
    // Arrange and Act
    OpenedClaim actualOpenedClaim = new OpenedClaim();

    // Assert
    assertNull(actualOpenedClaim.getAmount());
    assertNull(actualOpenedClaim.getDescription());
    assertNull(actualOpenedClaim.getApprovedBy());
    assertNull(actualOpenedClaim.getAuthor());
    assertNull(actualOpenedClaim.getPaidBy());
    assertEquals(OpenedClaim.Status.OPEN, actualOpenedClaim.getStatus());
  }
}
