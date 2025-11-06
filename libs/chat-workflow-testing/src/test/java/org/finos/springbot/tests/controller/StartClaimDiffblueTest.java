package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StartClaimDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StartClaim}
   *   <li>{@link StartClaim#setAmount(float)}
   *   <li>{@link StartClaim#setDescription(String)}
   *   <li>{@link StartClaim#getAmount()}
   *   <li>{@link StartClaim#getDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StartClaim.<init>()", "float StartClaim.getAmount()", "String StartClaim.getDescription()",
      "void StartClaim.setAmount(float)", "void StartClaim.setDescription(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    StartClaim actualStartClaim = new StartClaim();
    actualStartClaim.setAmount(10.0f);
    actualStartClaim.setDescription("The characteristics of someone or something");
    float actualAmount = actualStartClaim.getAmount();

    // Assert
    assertEquals("The characteristics of someone or something", actualStartClaim.getDescription());
    assertEquals(10.0f, actualAmount);
  }
}
