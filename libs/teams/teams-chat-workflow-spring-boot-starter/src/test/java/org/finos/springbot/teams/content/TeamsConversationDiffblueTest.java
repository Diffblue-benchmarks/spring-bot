package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TeamsConversationDiffblueTest {
  /**
   * Method under test: {@link TeamsConversation#getMessageId()}
   */
  @Test
  void testGetMessageId() {
    // Arrange, Act and Assert
    assertEquals("", (new TeamsConversation("messageid=", "Name")).getMessageId());
  }

  /**
   * Method under test: {@link TeamsConversation#getChannelId()}
   */
  @Test
  void testGetChannelId() {
    // Arrange, Act and Assert
    assertEquals("", (new TeamsConversation(";", "Name")).getChannelId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsConversation#equals(Object)}
   *   <li>{@link TeamsConversation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("42", "Name");
    TeamsConversation teamsConversation2 = new TeamsConversation("42", "Name");

    // Act and Assert
    assertEquals(teamsConversation, teamsConversation2);
    int expectedHashCodeResult = teamsConversation.hashCode();
    assertEquals(expectedHashCodeResult, teamsConversation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsConversation#equals(Object)}
   *   <li>{@link TeamsConversation#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("42", "Name");

    // Act and Assert
    assertEquals(teamsConversation, teamsConversation);
    int expectedHashCodeResult = teamsConversation.hashCode();
    assertEquals(expectedHashCodeResult, teamsConversation.hashCode());
  }

  /**
   * Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsConversation, new TeamsConversation("42", "Name"));
  }

  /**
   * Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsConversation("42", "Name"), null);
  }

  /**
   * Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsConversation("42", "Name"), "Different type to TeamsConversation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsConversation#TeamsConversation()}
   *   <li>{@link TeamsConversation#setKey(String)}
   *   <li>{@link TeamsConversation#setName(String)}
   *   <li>{@link TeamsConversation#getKey()}
   *   <li>{@link TeamsConversation#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsConversation actualTeamsConversation = new TeamsConversation();
    actualTeamsConversation.setKey("Key");
    actualTeamsConversation.setName("Name");
    String actualKey = actualTeamsConversation.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTeamsConversation.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsConversation#TeamsConversation(String, String)}
   *   <li>{@link TeamsConversation#setKey(String)}
   *   <li>{@link TeamsConversation#setName(String)}
   *   <li>{@link TeamsConversation#getKey()}
   *   <li>{@link TeamsConversation#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TeamsConversation actualTeamsConversation = new TeamsConversation("42", "Name");
    actualTeamsConversation.setKey("Key");
    actualTeamsConversation.setName("Name");
    String actualKey = actualTeamsConversation.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTeamsConversation.getName());
  }
}
