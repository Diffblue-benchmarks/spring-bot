package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class HelpPageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HelpPage#HelpPage()}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HelpPage actualHelpPage = new HelpPage();
    ArrayList<CommandDescription> commands = new ArrayList<>();
    actualHelpPage.setCommands(commands);
    List<CommandDescription> actualCommands = actualHelpPage.getCommands();

    // Assert that nothing has changed
    assertTrue(actualCommands.isEmpty());
    assertSame(commands, actualCommands);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HelpPage#HelpPage(List)}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    HelpPage actualHelpPage = new HelpPage(new ArrayList<>());
    ArrayList<CommandDescription> commands = new ArrayList<>();
    actualHelpPage.setCommands(commands);
    List<CommandDescription> actualCommands = actualHelpPage.getCommands();

    // Assert that nothing has changed
    assertTrue(actualCommands.isEmpty());
    assertSame(commands, actualCommands);
  }
}
