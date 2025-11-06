package org.finos.springbot.workflow.help;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CommandDescriptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CommandDescription#CommandDescription()}
   *   <li>{@link CommandDescription#setButton(boolean)}
   *   <li>{@link CommandDescription#setButtonName(String)}
   *   <li>{@link CommandDescription#setDescription(String)}
   *   <li>{@link CommandDescription#setExamples(List)}
   *   <li>{@link CommandDescription#setHelpOrder(int)}
   *   <li>{@link CommandDescription#getButtonName()}
   *   <li>{@link CommandDescription#getDescription()}
   *   <li>{@link CommandDescription#getExamples()}
   *   <li>{@link CommandDescription#getHelpOrder()}
   *   <li>{@link CommandDescription#isButton()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommandDescription.<init>()",
      "void CommandDescription.<init>(boolean, String, String, int, List)", "String CommandDescription.getButtonName()",
      "String CommandDescription.getDescription()", "List CommandDescription.getExamples()",
      "int CommandDescription.getHelpOrder()", "boolean CommandDescription.isButton()",
      "void CommandDescription.setButton(boolean)", "void CommandDescription.setButtonName(String)",
      "void CommandDescription.setDescription(String)", "void CommandDescription.setExamples(List)",
      "void CommandDescription.setHelpOrder(int)"})
  void testGettersAndSetters() {
    // Arrange and Act
    CommandDescription actualCommandDescription = new CommandDescription();
    actualCommandDescription.setButton(true);
    actualCommandDescription.setButtonName("Button Name");
    actualCommandDescription.setDescription("The characteristics of someone or something");
    ArrayList<String> examples = new ArrayList<>();
    actualCommandDescription.setExamples(examples);
    actualCommandDescription.setHelpOrder(1);
    String actualButtonName = actualCommandDescription.getButtonName();
    String actualDescription = actualCommandDescription.getDescription();
    List<String> actualExamples = actualCommandDescription.getExamples();
    int actualHelpOrder = actualCommandDescription.getHelpOrder();
    boolean actualIsButtonResult = actualCommandDescription.isButton();

    // Assert
    assertEquals("Button Name", actualButtonName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1, actualHelpOrder);
    assertTrue(actualExamples.isEmpty());
    assertTrue(actualIsButtonResult);
    assertSame(examples, actualExamples);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CommandDescription#CommandDescription(boolean, String, String, int, List)}
   *   <li>{@link CommandDescription#setButton(boolean)}
   *   <li>{@link CommandDescription#setButtonName(String)}
   *   <li>{@link CommandDescription#setDescription(String)}
   *   <li>{@link CommandDescription#setExamples(List)}
   *   <li>{@link CommandDescription#setHelpOrder(int)}
   *   <li>{@link CommandDescription#getButtonName()}
   *   <li>{@link CommandDescription#getDescription()}
   *   <li>{@link CommandDescription#getExamples()}
   *   <li>{@link CommandDescription#getHelpOrder()}
   *   <li>{@link CommandDescription#isButton()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CommandDescription.<init>()",
      "void CommandDescription.<init>(boolean, String, String, int, List)", "String CommandDescription.getButtonName()",
      "String CommandDescription.getDescription()", "List CommandDescription.getExamples()",
      "int CommandDescription.getHelpOrder()", "boolean CommandDescription.isButton()",
      "void CommandDescription.setButton(boolean)", "void CommandDescription.setButtonName(String)",
      "void CommandDescription.setDescription(String)", "void CommandDescription.setExamples(List)",
      "void CommandDescription.setHelpOrder(int)"})
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    CommandDescription actualCommandDescription = new CommandDescription(true, "Button Name",
        "The characteristics of someone or something", 1, new ArrayList<>());
    actualCommandDescription.setButton(true);
    actualCommandDescription.setButtonName("Button Name");
    actualCommandDescription.setDescription("The characteristics of someone or something");
    ArrayList<String> examples = new ArrayList<>();
    actualCommandDescription.setExamples(examples);
    actualCommandDescription.setHelpOrder(1);
    String actualButtonName = actualCommandDescription.getButtonName();
    String actualDescription = actualCommandDescription.getDescription();
    List<String> actualExamples = actualCommandDescription.getExamples();
    int actualHelpOrder = actualCommandDescription.getHelpOrder();
    boolean actualIsButtonResult = actualCommandDescription.isButton();

    // Assert
    assertEquals("Button Name", actualButtonName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1, actualHelpOrder);
    assertTrue(actualExamples.isEmpty());
    assertTrue(actualIsButtonResult);
    assertSame(examples, actualExamples);
  }
}
