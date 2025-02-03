package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpPageDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HelpPage#HelpPage()}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.help.HelpPage.<init>()",
      "void org.finos.springbot.workflow.help.HelpPage.<init>(java.util.List)",
      "java.util.List org.finos.springbot.workflow.help.HelpPage.getCommands()",
      "void org.finos.springbot.workflow.help.HelpPage.setCommands(java.util.List)"})
  void testGettersAndSetters() {
    // Arrange and Act
    HelpPage actualHelpPage = new HelpPage();
    ArrayList<CommandDescription> commands = new ArrayList<>();
    actualHelpPage.setCommands(commands);
    List<CommandDescription> actualCommands = actualHelpPage.getCommands();

    // Assert
    assertTrue(actualCommands.isEmpty());
    assertSame(commands, actualCommands);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HelpPage#HelpPage(List)}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.help.HelpPage.<init>()",
      "void org.finos.springbot.workflow.help.HelpPage.<init>(java.util.List)",
      "java.util.List org.finos.springbot.workflow.help.HelpPage.getCommands()",
      "void org.finos.springbot.workflow.help.HelpPage.setCommands(java.util.List)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    HelpPage actualHelpPage = new HelpPage(new ArrayList<>());
    ArrayList<CommandDescription> commands = new ArrayList<>();
    actualHelpPage.setCommands(commands);
    List<CommandDescription> actualCommands = actualHelpPage.getCommands();

    // Assert
    assertTrue(actualCommands.isEmpty());
    assertSame(commands, actualCommands);
  }
}
