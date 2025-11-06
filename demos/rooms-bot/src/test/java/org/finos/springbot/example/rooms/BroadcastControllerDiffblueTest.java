package org.finos.springbot.example.rooms;

import static org.junit.jupiter.api.Assertions.assertNull;
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
   * Method under test: {@link BroadcastController#createForm()}
   */
  @Test
  void testCreateForm() {
    // Arrange and Act
    Broadcast actualCreateFormResult = broadcastController.createForm();

    // Assert
    assertNull(actualCreateFormResult.getSend());
    assertNull(actualCreateFormResult.getTo());
  }
}
