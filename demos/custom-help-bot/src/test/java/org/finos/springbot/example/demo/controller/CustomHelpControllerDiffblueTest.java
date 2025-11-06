package org.finos.springbot.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.symphony.content.SymphonyUser;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomHelpController.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CustomHelpControllerDiffblueTest {
  @Autowired
  private CustomHelpController customHelpController;

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   * <ul>
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User); when SymphonyUser(long) with userId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.springbot.workflow.help.HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_whenSymphonyUserWithUserIdIsOne() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(1L)).getCommands().isEmpty());
  }

  /**
   * Test {@link CustomHelpController#handleHelp(Addressable, User)}.
   * <ul>
   *   <li>When {@link SymphonyUser#SymphonyUser(long)} with userId is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomHelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User); when SymphonyUser(long) with userId is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.springbot.workflow.help.HelpPage CustomHelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_whenSymphonyUserWithUserIdIsTwo() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act and Assert
    assertTrue(customHelpController.handleHelp(a, new SymphonyUser(2L)).getCommands().isEmpty());
  }
}
