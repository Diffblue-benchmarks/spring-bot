package org.finos.springbot.example.rooms;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadcastController.class})
@ExtendWith(SpringExtension.class)
class BroadcastControllerDiffblueTest {
  @Autowired
  private BroadcastController broadcastController;

  /**
   * Test {@link BroadcastController#createForm()}.
   * <p>
   * Method under test: {@link BroadcastController#createForm()}
   */
  @Test
  @DisplayName("Test createForm()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.example.rooms.Broadcast org.finos.springbot.example.rooms.BroadcastController.createForm()"})
  void testCreateForm() {
    // Arrange and Act
    Broadcast actualCreateFormResult = broadcastController.createForm();

    // Assert
    assertNull(actualCreateFormResult.getSend());
    assertNull(actualCreateFormResult.getTo());
  }
}
