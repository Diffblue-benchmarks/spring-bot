package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsMultiwayChatDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Key is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat()}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsMultiwayChat.<init>()",
    "void TeamsMultiwayChat.<init>(String, String)",
    "String TeamsMultiwayChat.getKey()",
    "String TeamsMultiwayChat.getName()"
  })
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
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Key is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat(String, String)}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'; then return Key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsMultiwayChat.<init>()",
    "void TeamsMultiwayChat.<init>(String, String)",
    "String TeamsMultiwayChat.getKey()",
    "String TeamsMultiwayChat.getName()"
  })
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsMultiwayChat.equals(Object)",
    "int TeamsMultiwayChat.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("42", "Name");
    TeamsMultiwayChat teamsMultiwayChat2 = new TeamsMultiwayChat("42", "Name");

    // Act and Assert
    assertEquals(teamsMultiwayChat, teamsMultiwayChat2);
    assertEquals(teamsMultiwayChat.hashCode(), teamsMultiwayChat2.hashCode());
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}, and {@link TeamsMultiwayChat#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsMultiwayChat.equals(Object)",
    "int TeamsMultiwayChat.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsMultiwayChat.equals(Object)",
    "int TeamsMultiwayChat.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsMultiwayChat, new TeamsMultiwayChat("42", "Name"));
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsMultiwayChat.equals(Object)",
    "int TeamsMultiwayChat.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), null);
  }

  /**
   * Test {@link TeamsMultiwayChat#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsMultiwayChat.equals(Object)",
    "int TeamsMultiwayChat.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), "Different type to TeamsMultiwayChat");
  }
}
