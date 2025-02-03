package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsMultiwayChatDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Key is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat()}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.content.TeamsMultiwayChat.<init>()",
      "void org.finos.springbot.teams.content.TeamsMultiwayChat.<init>(java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.teams.content.TeamsMultiwayChat.getKey()",
      "java.lang.String org.finos.springbot.teams.content.TeamsMultiwayChat.getName()"})
  void testGettersAndSetters_thenReturnKeyIsNull() {
    // Arrange and Act
    TeamsMultiwayChat actualTeamsMultiwayChat = new TeamsMultiwayChat();
    String actualKey = actualTeamsMultiwayChat.getKey();

    // Assert
    assertNull(actualKey);
    assertNull(actualTeamsMultiwayChat.getName());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Key is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat(String, String)}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Key is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.content.TeamsMultiwayChat.<init>()",
      "void org.finos.springbot.teams.content.TeamsMultiwayChat.<init>(java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.teams.content.TeamsMultiwayChat.getKey()",
      "java.lang.String org.finos.springbot.teams.content.TeamsMultiwayChat.getName()"})
  void testGettersAndSetters_when42_thenReturnKeyIs42() {
    // Arrange and Act
    TeamsMultiwayChat actualTeamsMultiwayChat = new TeamsMultiwayChat("42", "Name");
    String actualKey = actualTeamsMultiwayChat.getKey();

    // Assert
    assertEquals("42", actualKey);
    assertEquals("Name", actualTeamsMultiwayChat.getName());
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}, and {@link TeamsMultiwayChat#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsMultiwayChat.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsMultiwayChat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("42", "Name");
    TeamsMultiwayChat teamsMultiwayChat2 = new TeamsMultiwayChat("42", "Name");

    // Act and Assert
    assertEquals(teamsMultiwayChat, teamsMultiwayChat2);
    int expectedHashCodeResult = teamsMultiwayChat.hashCode();
    assertEquals(expectedHashCodeResult, teamsMultiwayChat2.hashCode());
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}, and {@link TeamsMultiwayChat#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsMultiwayChat.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsMultiwayChat.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("42", "Name");

    // Act and Assert
    assertEquals(teamsMultiwayChat, teamsMultiwayChat);
    int expectedHashCodeResult = teamsMultiwayChat.hashCode();
    assertEquals(expectedHashCodeResult, teamsMultiwayChat.hashCode());
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsMultiwayChat.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsMultiwayChat.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsMultiwayChat, new TeamsMultiwayChat("42", "Name"));
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsMultiwayChat.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsMultiwayChat.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), null);
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsMultiwayChat.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsMultiwayChat.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), "Different type to TeamsMultiwayChat");
  }
}
