package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HelpController.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class HelpControllerDiffblueTest {
  @Autowired
  private HelpController helpController;

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HelpController}
   *   <li>{@link HelpController#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    HelpController actualHelpController = new HelpController();
    actualHelpController.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertNull(actualHelpController.exposedHandlers);
  }

  /**
   * Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  void testHandleHelp() {
    // Arrange, Act and Assert
    assertTrue(helpController.handleHelp(null, null).getCommands().isEmpty());
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  void testInitExposedHandlers() {
    // Arrange and Act
    helpController.initExposedHandlers();

    // Assert
    assertTrue(helpController.exposedHandlers.isEmpty());
  }
}
