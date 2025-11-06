package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HelpController.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class HelpControllerDiffblueTest {
  @Autowired
  private HelpController helpController;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link HelpController}
   *   <li>{@link HelpController#setApplicationContext(ApplicationContext)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HelpController.<init>()", "void HelpController.setApplicationContext(ApplicationContext)"})
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    HelpController actualHelpController = new HelpController();
    actualHelpController.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert
    assertNull(actualHelpController.exposedHandlers);
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User); when Addressable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_whenAddressable() {
    // Arrange, Act and Assert
    assertTrue(helpController.handleHelp(mock(Addressable.class), mock(User.class)).getCommands().isEmpty());
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Test {@link HelpController#handleHelp(Addressable, User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HelpController#handleHelp(Addressable, User)}
   */
  @Test
  @DisplayName("Test handleHelp(Addressable, User); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.finos.springbot.workflow.help.HelpPage HelpController.handleHelp(Addressable, User)"})
  void testHandleHelp_whenNull() {
    // Arrange, Act and Assert
    assertTrue(helpController.handleHelp(null, mock(User.class)).getCommands().isEmpty());
    assertTrue(helpController.exposedHandlers.isEmpty());
  }

  /**
   * Test {@link HelpController#initExposedHandlers()}.
   * <p>
   * Method under test: {@link HelpController#initExposedHandlers()}
   */
  @Test
  @DisplayName("Test initExposedHandlers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HelpController.initExposedHandlers()"})
  void testInitExposedHandlers() {
    // Arrange and Act
    helpController.initExposedHandlers();

    // Assert
    assertTrue(helpController.exposedHandlers.isEmpty());
  }
}
