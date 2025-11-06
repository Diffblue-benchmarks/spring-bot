package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TeamsUserDiffblueTest {
  /**
   * Method under test: {@link TeamsUser#getText()}
   */
  @Test
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("@Name", (new TeamsUser("42", "Name", "42")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#equals(Object)}
   *   <li>{@link TeamsUser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");
    TeamsUser teamsUser2 = new TeamsUser("42", "Name", "42");

    // Act and Assert
    assertEquals(teamsUser, teamsUser2);
    int expectedHashCodeResult = teamsUser.hashCode();
    assertEquals(expectedHashCodeResult, teamsUser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#equals(Object)}
   *   <li>{@link TeamsUser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");

    // Act and Assert
    assertEquals(teamsUser, teamsUser);
    int expectedHashCodeResult = teamsUser.hashCode();
    assertEquals(expectedHashCodeResult, teamsUser.hashCode());
  }

  /**
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsUser teamsUser = new TeamsUser("Id", "Name", "42");

    // Act and Assert
    assertNotEquals(teamsUser, new TeamsUser("42", "Name", "42"));
  }

  /**
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsUser("42", "Name", "42"), null);
  }

  /**
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsUser("42", "Name", "42"), "Different type to TeamsUser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#TeamsUser()}
   *   <li>{@link TeamsUser#setAadObjectId(String)}
   *   <li>{@link TeamsUser#setKey(String)}
   *   <li>{@link TeamsUser#setName(String)}
   *   <li>{@link TeamsUser#getAadObjectId()}
   *   <li>{@link TeamsUser#getKey()}
   *   <li>{@link TeamsUser#getName()}
   *   <li>{@link TeamsUser#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsUser actualTeamsUser = new TeamsUser();
    actualTeamsUser.setAadObjectId("42");
    actualTeamsUser.setKey("Key");
    actualTeamsUser.setName("Name");
    String actualAadObjectId = actualTeamsUser.getAadObjectId();
    String actualKey = actualTeamsUser.getKey();
    String actualName = actualTeamsUser.getName();
    actualTeamsUser.getTagType();

    // Assert that nothing has changed
    assertEquals("42", actualAadObjectId);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#TeamsUser(String, String, String)}
   *   <li>{@link TeamsUser#setAadObjectId(String)}
   *   <li>{@link TeamsUser#setKey(String)}
   *   <li>{@link TeamsUser#setName(String)}
   *   <li>{@link TeamsUser#getAadObjectId()}
   *   <li>{@link TeamsUser#getKey()}
   *   <li>{@link TeamsUser#getName()}
   *   <li>{@link TeamsUser#getTagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TeamsUser actualTeamsUser = new TeamsUser("42", "Name", "42");
    actualTeamsUser.setAadObjectId("42");
    actualTeamsUser.setKey("Key");
    actualTeamsUser.setName("Name");
    String actualAadObjectId = actualTeamsUser.getAadObjectId();
    String actualKey = actualTeamsUser.getKey();
    String actualName = actualTeamsUser.getName();
    actualTeamsUser.getTagType();

    // Assert that nothing has changed
    assertEquals("42", actualAadObjectId);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }
}
