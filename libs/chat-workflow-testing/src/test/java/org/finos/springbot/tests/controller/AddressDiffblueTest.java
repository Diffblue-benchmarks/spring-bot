package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AddressDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Address#Address()}
   *   <li>{@link Address#setCity(String)}
   *   <li>{@link Address#getCity()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Address actualAddress = new Address();
    actualAddress.setCity("Oxford");

    // Assert that nothing has changed
    assertEquals("Oxford", actualAddress.getCity());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Address#Address(String)}
   *   <li>{@link Address#setCity(String)}
   *   <li>{@link Address#getCity()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Address actualAddress = new Address("Oxford");
    actualAddress.setCity("Oxford");

    // Assert that nothing has changed
    assertEquals("Oxford", actualAddress.getCity());
  }
}
