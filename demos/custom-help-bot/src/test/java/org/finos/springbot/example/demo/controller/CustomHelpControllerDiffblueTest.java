package org.finos.springbot.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomHelpController.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CustomHelpControllerDiffblueTest {
  @Autowired
  private CustomHelpController customHelpController;

  /**
   * Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  void testHandleHelp() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(1L)).getCommands().isEmpty());
  }

  /**
   * Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  void testHandleHelp2() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(2L)).getCommands().isEmpty());
  }
}
