package org.finos.springbot.workflow.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.springbot.workflow.form.Button.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ButtonListDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ButtonList#ButtonList()}
   *   <li>{@link ButtonList#setContents(Collection)}
   *   <li>{@link ButtonList#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.form.ButtonList.<init>()",
      "void org.finos.springbot.workflow.form.ButtonList.<init>(java.util.Collection)",
      "java.util.Collection org.finos.springbot.workflow.form.ButtonList.getContents()",
      "void org.finos.springbot.workflow.form.ButtonList.setContents(java.util.Collection)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ButtonList actualButtonList = new ButtonList();
    ArrayList<Button> contents = new ArrayList<>();
    actualButtonList.setContents(contents);
    Collection<Button> actualContents = actualButtonList.getContents();

    // Assert
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ButtonList#ButtonList(Collection)}
   *   <li>{@link ButtonList#setContents(Collection)}
   *   <li>{@link ButtonList#getContents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.form.ButtonList.<init>()",
      "void org.finos.springbot.workflow.form.ButtonList.<init>(java.util.Collection)",
      "java.util.Collection org.finos.springbot.workflow.form.ButtonList.getContents()",
      "void org.finos.springbot.workflow.form.ButtonList.setContents(java.util.Collection)"})
  void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    ButtonList actualButtonList = new ButtonList(new ArrayList<>());
    ArrayList<Button> contents = new ArrayList<>();
    actualButtonList.setContents(contents);
    Collection<Button> actualContents = actualButtonList.getContents();

    // Assert
    assertTrue(actualContents instanceof List);
    assertSame(contents, actualContents);
  }

  /**
   * Test {@link ButtonList#of(Button[])}.
   * <p>
   * Method under test: {@link ButtonList#of(Button[])}
   */
  @Test
  @DisplayName("Test of(Button[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.form.ButtonList org.finos.springbot.workflow.form.ButtonList.of(org.finos.springbot.workflow.form.Button[])"})
  void testOf() {
    // Arrange
    Button button = new Button("Name", Type.ACTION, "Text");

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
   * Test {@link ButtonList#add(Button)}.
   * <ul>
   *   <li>Given {@link ButtonList#ButtonList()}.</li>
   *   <li>Then {@link ButtonList#ButtonList()} Contents size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ButtonList#add(Button)}
   */
  @Test
  @DisplayName("Test add(Button); given ButtonList(); then ButtonList() Contents size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.form.ButtonList.add(org.finos.springbot.workflow.form.Button)"})
  void testAdd_givenButtonList_thenButtonListContentsSizeIsOne() {
    // Arrange
    ButtonList buttonList = new ButtonList();
    Button button = new Button("Name", Type.ACTION, "Text");

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
   * Test {@link ButtonList#size()}.
   * <p>
   * Method under test: {@link ButtonList#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int org.finos.springbot.workflow.form.ButtonList.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ButtonList()).size());
  }
}
