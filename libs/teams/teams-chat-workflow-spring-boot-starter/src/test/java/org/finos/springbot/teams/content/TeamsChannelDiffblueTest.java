package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsChannelDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#TeamsChannel()}
   *   <li>{@link TeamsChannel#setKey(String)}
   *   <li>{@link TeamsChannel#setName(String)}
   *   <li>{@link TeamsChannel#getKey()}
   *   <li>{@link TeamsChannel#getName()}
   *   <li>{@link TeamsChannel#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TeamsChannel.<init>()", "void TeamsChannel.<init>(String, String)",
      "String TeamsChannel.getKey()", "String TeamsChannel.getName()",
      "org.finos.springbot.workflow.content.Tag.Type TeamsChannel.getTagType()", "void TeamsChannel.setKey(String)",
      "void TeamsChannel.setName(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsChannel actualTeamsChannel = new TeamsChannel();
    actualTeamsChannel.setKey("Key");
    actualTeamsChannel.setName("Name");
    String actualKey = actualTeamsChannel.getKey();
    String actualName = actualTeamsChannel.getName();
    actualTeamsChannel.getTagType();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#TeamsChannel(String, String)}
   *   <li>{@link TeamsChannel#setKey(String)}
   *   <li>{@link TeamsChannel#setName(String)}
   *   <li>{@link TeamsChannel#getKey()}
   *   <li>{@link TeamsChannel#getName()}
   *   <li>{@link TeamsChannel#getTagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TeamsChannel.<init>()", "void TeamsChannel.<init>(String, String)",
      "String TeamsChannel.getKey()", "String TeamsChannel.getName()",
      "org.finos.springbot.workflow.content.Tag.Type TeamsChannel.getTagType()", "void TeamsChannel.setKey(String)",
      "void TeamsChannel.setName(String)"})
  void testGettersAndSetters_when42() {
    // Arrange and Act
    TeamsChannel actualTeamsChannel = new TeamsChannel("42", "Name");
    actualTeamsChannel.setKey("Key");
    actualTeamsChannel.setName("Name");
    String actualKey = actualTeamsChannel.getKey();
    String actualName = actualTeamsChannel.getName();
    actualTeamsChannel.getTagType();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link TeamsChannel#getText()}.
   * <p>
   * Method under test: {@link TeamsChannel#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TeamsChannel.getText()"})
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("@Name", (new TeamsChannel("42", "Name")).getText());
  }

  /**
   * Test {@link TeamsChannel#equals(Object)}, and {@link TeamsChannel#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#equals(Object)}
   *   <li>{@link TeamsChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsChannel.equals(Object)", "int TeamsChannel.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsChannel teamsChannel = new TeamsChannel("42", "Name");
    TeamsChannel teamsChannel2 = new TeamsChannel("42", "Name");

    // Act and Assert
    assertEquals(teamsChannel, teamsChannel2);
    int expectedHashCodeResult = teamsChannel.hashCode();
    assertEquals(expectedHashCodeResult, teamsChannel2.hashCode());
  }

  /**
   * Test {@link TeamsChannel#equals(Object)}, and {@link TeamsChannel#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#equals(Object)}
   *   <li>{@link TeamsChannel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsChannel.equals(Object)", "int TeamsChannel.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsChannel teamsChannel = new TeamsChannel("42", "Name");

    // Act and Assert
    assertEquals(teamsChannel, teamsChannel);
    int expectedHashCodeResult = teamsChannel.hashCode();
    assertEquals(expectedHashCodeResult, teamsChannel.hashCode());
  }

  /**
   * Test {@link TeamsChannel#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsChannel.equals(Object)", "int TeamsChannel.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsChannel teamsChannel = new TeamsChannel("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsChannel, new TeamsChannel("42", "Name"));
  }

  /**
   * Test {@link TeamsChannel#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsChannel.equals(Object)", "int TeamsChannel.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsChannel("42", "Name"), null);
  }

  /**
   * Test {@link TeamsChannel#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TeamsChannel.equals(Object)", "int TeamsChannel.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsChannel("42", "Name"), "Different type to TeamsChannel");
  }
}
