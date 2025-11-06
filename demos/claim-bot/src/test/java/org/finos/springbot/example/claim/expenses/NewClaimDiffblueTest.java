package org.finos.springbot.example.claim.expenses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NewClaimDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NewClaim.<init>()", "Number NewClaim.getAmount()", "String NewClaim.getDescription()",
      "void NewClaim.setAmount(Number)", "void NewClaim.setDescription(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    NewClaim actualNewClaim = new NewClaim();
    Integer amount = Integer.valueOf(1);
    actualNewClaim.setAmount(amount);
    actualNewClaim.setDescription("The characteristics of someone or something");
    Number actualAmount = actualNewClaim.getAmount();

    // Assert
    assertEquals("The characteristics of someone or something", actualNewClaim.getDescription());
    assertSame(amount, actualAmount);
  }
}
