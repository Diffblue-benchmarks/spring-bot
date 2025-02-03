package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.springbot.workflow.form.Button.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ButtonDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#Button()}
   *   <li>{@link Button#setButtonType(Type)}
   *   <li>{@link Button#setName(String)}
   *   <li>{@link Button#setText(String)}
   *   <li>{@link Button#getButtonType()}
   *   <li>{@link Button#getName()}
   *   <li>{@link Button#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.form.Button.<init>()",
      "void org.finos.springbot.workflow.form.Button.<init>(java.lang.String, org.finos.springbot.workflow.form.Button$Type, java.lang.String)",
      "org.finos.springbot.workflow.form.Button$Type org.finos.springbot.workflow.form.Button.getButtonType()",
      "java.lang.String org.finos.springbot.workflow.form.Button.getName()",
      "java.lang.String org.finos.springbot.workflow.form.Button.getText()",
      "void org.finos.springbot.workflow.form.Button.setButtonType(org.finos.springbot.workflow.form.Button$Type)",
      "void org.finos.springbot.workflow.form.Button.setName(java.lang.String)",
      "void org.finos.springbot.workflow.form.Button.setText(java.lang.String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    Button actualButton = new Button();
    actualButton.setButtonType(Type.ACTION);
    actualButton.setName("Name");
    actualButton.setText("Text");
    Type actualButtonType = actualButton.getButtonType();
    String actualName = actualButton.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Text", actualButton.getText());
    assertEquals(Type.ACTION, actualButtonType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#Button(String, Type, String)}
   *   <li>{@link Button#setButtonType(Type)}
   *   <li>{@link Button#setName(String)}
   *   <li>{@link Button#setText(String)}
   *   <li>{@link Button#getButtonType()}
   *   <li>{@link Button#getName()}
   *   <li>{@link Button#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.form.Button.<init>()",
      "void org.finos.springbot.workflow.form.Button.<init>(java.lang.String, org.finos.springbot.workflow.form.Button$Type, java.lang.String)",
      "org.finos.springbot.workflow.form.Button$Type org.finos.springbot.workflow.form.Button.getButtonType()",
      "java.lang.String org.finos.springbot.workflow.form.Button.getName()",
      "java.lang.String org.finos.springbot.workflow.form.Button.getText()",
      "void org.finos.springbot.workflow.form.Button.setButtonType(org.finos.springbot.workflow.form.Button$Type)",
      "void org.finos.springbot.workflow.form.Button.setName(java.lang.String)",
      "void org.finos.springbot.workflow.form.Button.setText(java.lang.String)"})
  void testGettersAndSetters_whenName() {
    // Arrange and Act
    Button actualButton = new Button("Name", Type.ACTION, "Text");
    actualButton.setButtonType(Type.ACTION);
    actualButton.setName("Name");
    actualButton.setText("Text");
    Type actualButtonType = actualButton.getButtonType();
    String actualName = actualButton.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Text", actualButton.getText());
    assertEquals(Type.ACTION, actualButtonType);
  }

  /**
   * Test {@link Button#Button(Class, String, Type, String)}.
   * <p>
   * Method under test: {@link Button#Button(Class, String, Type, String)}
   */
  @Test
  @DisplayName("Test new Button(Class, String, Type, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.form.Button.<init>(java.lang.Class, java.lang.String, org.finos.springbot.workflow.form.Button$Type, java.lang.String)"})
  void testNewButton() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Button actualButton = new Button(c, "Method Name", Type.ACTION, "Text");

    // Assert
    assertEquals("Text", actualButton.getText());
    assertEquals("java.lang.Object-Method Name", actualButton.getName());
    assertEquals(Type.ACTION, actualButton.getButtonType());
  }

  /**
   * Test {@link Button#compareTo(Button)} with {@code Button}.
   * <ul>
   *   <li>Given {@link Button#Button(String, Type, String)} with {@code Name} and type is {@code ACTION} and {@code Text}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#compareTo(Button)}
   */
  @Test
  @DisplayName("Test compareTo(Button) with 'Button'; given Button(String, Type, String) with 'Name' and type is 'ACTION' and 'Text'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "int org.finos.springbot.workflow.form.Button.compareTo(org.finos.springbot.workflow.form.Button)"})
  void testCompareToWithButton_givenButtonWithNameAndTypeIsActionAndText_thenReturnZero() {
    // Arrange
    Button button = new Button("Name", Type.ACTION, "Text");

    // Act and Assert
    assertEquals(0, button.compareTo(new Button("Name", Type.ACTION, "Text")));
  }
}
