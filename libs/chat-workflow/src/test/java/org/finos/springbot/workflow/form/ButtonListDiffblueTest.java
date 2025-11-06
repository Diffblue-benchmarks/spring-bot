package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

class ButtonListDiffblueTest {
  /**
   * Method under test: {@link ButtonList#of(Button[])}
   */
  @Test
  void testOf() {
    // Arrange
    Button button = new Button("Name", Button.Type.ACTION, "Text");

    // Act
    ButtonList actualOfResult = ButtonList.of(button);

    // Assert
    Collection<Button> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, actualOfResult.size());
    assertSame(button, ((List<Button>) contents).get(0));
  }

  /**
   * Method under test: {@link ButtonList#add(Button)}
   */
  @Test
  void testAdd() {
    // Arrange
    ButtonList buttonList = new ButtonList();
    Button button = new Button("Name", Button.Type.ACTION, "Text");

    // Act
    buttonList.add(button);

    // Assert
    Collection<Button> contents = buttonList.getContents();
    assertEquals(1, contents.size());
    assertTrue(contents instanceof List);
    assertEquals(1, buttonList.size());
    assertSame(button, ((List<Button>) contents).get(0));
  }

  /**
   * Method under test: {@link ButtonList#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ButtonList()).size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ButtonList#ButtonList()}
   *   <li>{@link ButtonList#setContents(Collection)}
   *   <li>{@link ButtonList#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ButtonList actualButtonList = new ButtonList();
    ArrayList<Button> contents = new ArrayList<>();
    actualButtonList.setContents(contents);
    Collection<Button> actualContents = actualButtonList.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ButtonList#ButtonList(Collection)}
   *   <li>{@link ButtonList#setContents(Collection)}
   *   <li>{@link ButtonList#getContents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ButtonList actualButtonList = new ButtonList(new ArrayList<>());
    ArrayList<Button> contents = new ArrayList<>();
    actualButtonList.setContents(contents);
    Collection<Button> actualContents = actualButtonList.getContents();

    // Assert that nothing has changed
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }
}
