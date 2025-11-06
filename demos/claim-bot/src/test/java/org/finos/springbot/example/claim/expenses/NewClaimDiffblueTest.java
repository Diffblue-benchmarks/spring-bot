package org.finos.springbot.example.claim.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class NewClaimDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NewClaim}
   *   <li>{@link NewClaim#setAmount(Number)}
   *   <li>{@link NewClaim#setDescription(String)}
   *   <li>{@link NewClaim#getAmount()}
   *   <li>{@link NewClaim#getDescription()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NewClaim actualNewClaim = new NewClaim();
    Integer amount = Integer.valueOf(1);
    actualNewClaim.setAmount(amount);
    actualNewClaim.setDescription("The characteristics of someone or something");
    Number actualAmount = actualNewClaim.getAmount();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualNewClaim.getDescription());
    assertSame(amount, actualAmount);
  }
}
