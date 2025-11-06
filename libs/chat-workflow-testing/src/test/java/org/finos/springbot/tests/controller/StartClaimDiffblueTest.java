package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StartClaimDiffblueTest {
  /**
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
  void testGettersAndSetters() {
    // Arrange and Act
    StartClaim actualStartClaim = new StartClaim();
    actualStartClaim.setAmount(10.0f);
    actualStartClaim.setDescription("The characteristics of someone or something");
    float actualAmount = actualStartClaim.getAmount();

    // Assert that nothing has changed
    assertEquals("The characteristics of someone or something", actualStartClaim.getDescription());
    assertEquals(10.0f, actualAmount);
  }
}
