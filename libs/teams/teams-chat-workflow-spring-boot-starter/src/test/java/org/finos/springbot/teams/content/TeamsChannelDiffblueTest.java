package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TeamsChannelDiffblueTest {
  /**
   * Method under test: {@link TeamsChannel#getText()}
   */
  @Test
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("@Name", (new TeamsChannel("42", "Name")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#equals(Object)}
   *   <li>{@link TeamsChannel#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsChannel#equals(Object)}
   *   <li>{@link TeamsChannel#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsChannel teamsChannel = new TeamsChannel("42", "Name");

    // Act and Assert
    assertEquals(teamsChannel, teamsChannel);
    int expectedHashCodeResult = teamsChannel.hashCode();
    assertEquals(expectedHashCodeResult, teamsChannel.hashCode());
  }

  /**
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsChannel teamsChannel = new TeamsChannel("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsChannel, new TeamsChannel("42", "Name"));
  }

  /**
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsChannel("42", "Name"), null);
  }

  /**
   * Method under test: {@link TeamsChannel#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsChannel("42", "Name"), "Different type to TeamsChannel");
  }

  /**
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
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsChannel actualTeamsChannel = new TeamsChannel();
    actualTeamsChannel.setKey("Key");
    actualTeamsChannel.setName("Name");
    String actualKey = actualTeamsChannel.getKey();
    String actualName = actualTeamsChannel.getName();
    actualTeamsChannel.getTagType();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }

  /**
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
  void testGettersAndSetters2() {
    // Arrange and Act
    TeamsChannel actualTeamsChannel = new TeamsChannel("42", "Name");
    actualTeamsChannel.setKey("Key");
    actualTeamsChannel.setName("Name");
    String actualKey = actualTeamsChannel.getKey();
    String actualName = actualTeamsChannel.getName();
    actualTeamsChannel.getTagType();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }
}
