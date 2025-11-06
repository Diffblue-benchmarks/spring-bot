package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ButtonDiffblueTest {
  /**
   * Method under test: {@link Button#compareTo(Button)}
   */
  @Test
  void testCompareTo() {
    // Arrange
    Button button = new Button("Name", Button.Type.ACTION, "Text");

    // Act and Assert
    assertEquals(0, button.compareTo(new Button("Name", Button.Type.ACTION, "Text")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Button#Button()}
   *   <li>{@link Button#setButtonType(Button.Type)}
   *   <li>{@link Button#setName(String)}
   *   <li>{@link Button#setText(String)}
   *   <li>{@link Button#getButtonType()}
   *   <li>{@link Button#getName()}
   *   <li>{@link Button#getText()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Button actualButton = new Button();
    actualButton.setButtonType(Button.Type.ACTION);
    actualButton.setName("Name");
    actualButton.setText("Text");
    Button.Type actualButtonType = actualButton.getButtonType();
    String actualName = actualButton.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Text", actualButton.getText());
    assertEquals(Button.Type.ACTION, actualButtonType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Button#Button(String, Button.Type, String)}
   *   <li>{@link Button#setButtonType(Button.Type)}
   *   <li>{@link Button#setName(String)}
   *   <li>{@link Button#setText(String)}
   *   <li>{@link Button#getButtonType()}
   *   <li>{@link Button#getName()}
   *   <li>{@link Button#getText()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Button actualButton = new Button("Name", Button.Type.ACTION, "Text");
    actualButton.setButtonType(Button.Type.ACTION);
    actualButton.setName("Name");
    actualButton.setText("Text");
    Button.Type actualButtonType = actualButton.getButtonType();
    String actualName = actualButton.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Text", actualButton.getText());
    assertEquals(Button.Type.ACTION, actualButtonType);
  }

  /**
   * Method under test: {@link Button#Button(Class, String, Button.Type, String)}
   */
  @Test
  void testNewButton() {
    // Arrange
    Class<Object> c = Object.class;

    // Act
    Button actualButton = new Button(c, "Method Name", Button.Type.ACTION, "Text");

    // Assert
    assertEquals("Text", actualButton.getText());
    assertEquals("java.lang.Object-Method Name", actualButton.getName());
    assertEquals(Button.Type.ACTION, actualButton.getButtonType());
  }
}
