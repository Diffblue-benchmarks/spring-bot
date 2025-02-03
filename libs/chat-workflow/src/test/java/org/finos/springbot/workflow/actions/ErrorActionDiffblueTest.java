package org.finos.springbot.workflow.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.Addressable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ErrorActionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorAction#ErrorAction(Addressable, Object)}
   *   <li>{@link ErrorAction#getAddressable()}
   *   <li>{@link ErrorAction#getData()}
   *   <li>{@link ErrorAction#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.actions.ErrorAction.<init>(org.finos.springbot.workflow.content.Addressable, java.lang.Object)",
      "org.finos.springbot.workflow.content.Addressable org.finos.springbot.workflow.actions.ErrorAction.getAddressable()",
      "java.lang.Object org.finos.springbot.workflow.actions.ErrorAction.getData()",
      "org.finos.springbot.workflow.content.User org.finos.springbot.workflow.actions.ErrorAction.getUser()"})
  void testGettersAndSetters() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    ErrorAction actualErrorAction = new ErrorAction(a, "Ej");
    Addressable actualAddressable = actualErrorAction.getAddressable();
    Object actualData = actualErrorAction.getData();

    // Assert
    assertEquals("Ej", actualData);
    assertNull(actualErrorAction.getUser());
    assertSame(a, actualAddressable);
  }
}
