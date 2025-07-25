package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HelpPageDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HelpPage#HelpPage()}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HelpPage.<init>()",
    "void HelpPage.<init>(List)",
    "List HelpPage.getCommands()",
    "void HelpPage.setCommands(List)"
  })
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HelpPage#HelpPage(List)}
   *   <li>{@link HelpPage#setCommands(List)}
   *   <li>{@link HelpPage#getCommands()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HelpPage.<init>()",
    "void HelpPage.<init>(List)",
    "List HelpPage.getCommands()",
    "void HelpPage.setCommands(List)"
  })
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
