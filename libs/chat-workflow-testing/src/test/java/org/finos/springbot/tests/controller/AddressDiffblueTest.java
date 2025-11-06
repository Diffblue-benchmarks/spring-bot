package org.finos.springbot.tests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AddressDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Address#Address()}
   *   <li>{@link Address#setCity(String)}
   *   <li>{@link Address#getCity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Address.<init>()", "void Address.<init>(String)", "String Address.getCity()",
      "void Address.setCity(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Address actualAddress = new Address();
    actualAddress.setCity("Oxford");

    // Assert
    assertEquals("Oxford", actualAddress.getCity());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Oxford}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Address#Address(String)}
   *   <li>{@link Address#setCity(String)}
   *   <li>{@link Address#getCity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Oxford'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Address.<init>()", "void Address.<init>(String)", "String Address.getCity()",
      "void Address.setCity(String)"})
  void testGettersAndSetters_whenOxford() {
    // Arrange and Act
    Address actualAddress = new Address("Oxford");
    actualAddress.setCity("Oxford");

    // Assert
    assertEquals("Oxford", actualAddress.getCity());
  }
}
