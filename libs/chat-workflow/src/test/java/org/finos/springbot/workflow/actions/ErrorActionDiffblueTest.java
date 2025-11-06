package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.Test;

class ErrorActionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorAction#ErrorAction(Addressable, Object)}
   *   <li>{@link ErrorAction#getAddressable()}
   *   <li>{@link ErrorAction#getData()}
   *   <li>{@link ErrorAction#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorAction actualErrorAction = new ErrorAction(null, "Ej");
    Addressable actualAddressable = actualErrorAction.getAddressable();
    Object actualData = actualErrorAction.getData();

    // Assert
    assertEquals("Ej", actualData);
    assertNull(actualAddressable);
    assertNull(actualErrorAction.getUser());
  }
}
