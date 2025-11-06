package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TeamsMultiwayChatDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#equals(Object)}
   *   <li>{@link TeamsMultiwayChat#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("42", "Name");

    // Act and Assert
    assertEquals(teamsMultiwayChat, teamsMultiwayChat);
    int expectedHashCodeResult = teamsMultiwayChat.hashCode();
    assertEquals(expectedHashCodeResult, teamsMultiwayChat.hashCode());
  }

  /**
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsMultiwayChat teamsMultiwayChat = new TeamsMultiwayChat("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsMultiwayChat, new TeamsMultiwayChat("42", "Name"));
  }

  /**
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), null);
  }

  /**
   * Method under test: {@link TeamsMultiwayChat#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsMultiwayChat("42", "Name"), "Different type to TeamsMultiwayChat");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat()}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsMultiwayChat actualTeamsMultiwayChat = new TeamsMultiwayChat();
    String actualKey = actualTeamsMultiwayChat.getKey();

    // Assert
    assertNull(actualKey);
    assertNull(actualTeamsMultiwayChat.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsMultiwayChat#TeamsMultiwayChat(String, String)}
   *   <li>{@link TeamsMultiwayChat#getKey()}
   *   <li>{@link TeamsMultiwayChat#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TeamsMultiwayChat actualTeamsMultiwayChat = new TeamsMultiwayChat("42", "Name");
    String actualKey = actualTeamsMultiwayChat.getKey();

    // Assert
    assertEquals("42", actualKey);
    assertEquals("Name", actualTeamsMultiwayChat.getName());
  }
}
