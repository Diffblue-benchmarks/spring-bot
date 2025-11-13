package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsConversationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsConversation#TeamsConversation()}
   *   <li>{@link TeamsConversation#setKey(String)}
   *   <li>{@link TeamsConversation#setName(String)}
   *   <li>{@link TeamsConversation#getKey()}
   *   <li>{@link TeamsConversation#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsConversation.<init>()",
    "void TeamsConversation.<init>(String, String)",
    "String TeamsConversation.getKey()",
    "String TeamsConversation.getName()",
    "void TeamsConversation.setKey(String)",
    "void TeamsConversation.setName(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TeamsConversation actualTeamsConversation = new TeamsConversation();
    actualTeamsConversation.setKey("Key");
    actualTeamsConversation.setName("Name");
    String actualKey = actualTeamsConversation.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTeamsConversation.getName());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsConversation#TeamsConversation(String, String)}
   *   <li>{@link TeamsConversation#setKey(String)}
   *   <li>{@link TeamsConversation#setName(String)}
   *   <li>{@link TeamsConversation#getKey()}
   *   <li>{@link TeamsConversation#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TeamsConversation.<init>()",
    "void TeamsConversation.<init>(String, String)",
    "String TeamsConversation.getKey()",
    "String TeamsConversation.getName()",
    "void TeamsConversation.setKey(String)",
    "void TeamsConversation.setName(String)"
  })
  void testGettersAndSetters_when42() {
    // Arrange and Act
    TeamsConversation actualTeamsConversation = new TeamsConversation("42", "Name");
    actualTeamsConversation.setKey("Key");
    actualTeamsConversation.setName("Name");
    String actualKey = actualTeamsConversation.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Name", actualTeamsConversation.getName());
  }

  /**
   * Test {@link TeamsConversation#getMessageId()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversation#getMessageId()}
   */
  @Test
  @DisplayName("Test getMessageId(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TeamsConversation.getMessageId()"})
  void testGetMessageId_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new TeamsConversation("messageid=", "Name").getMessageId());
  }

  /**
   * Test {@link TeamsConversation#getChannelId()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversation#getChannelId()}
   */
  @Test
  @DisplayName("Test getChannelId(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TeamsConversation.getChannelId()"})
  void testGetChannelId_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new TeamsConversation(";", "Name").getChannelId());
  }

  /**
   * Test {@link TeamsConversation#equals(Object)}, and {@link TeamsConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsConversation#equals(Object)}
   *   <li>{@link TeamsConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsConversation.equals(Object)",
    "int TeamsConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("42", "Name");
    TeamsConversation teamsConversation2 = new TeamsConversation("42", "Name");

    // Act and Assert
    assertEquals(teamsConversation, teamsConversation2);
    assertEquals(teamsConversation.hashCode(), teamsConversation2.hashCode());
  }

  /**
   * Test {@link TeamsConversation#equals(Object)}, and {@link TeamsConversation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TeamsConversation#equals(Object)}
   *   <li>{@link TeamsConversation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsConversation.equals(Object)",
    "int TeamsConversation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("42", "Name");

    // Act and Assert
    assertEquals(teamsConversation, teamsConversation);
    int expectedHashCodeResult = teamsConversation.hashCode();
    assertEquals(expectedHashCodeResult, teamsConversation.hashCode());
  }

  /**
   * Test {@link TeamsConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsConversation.equals(Object)",
    "int TeamsConversation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsConversation teamsConversation = new TeamsConversation("Id", "Name");

    // Act and Assert
    assertNotEquals(teamsConversation, new TeamsConversation("42", "Name"));
  }

  /**
   * Test {@link TeamsConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsConversation.equals(Object)",
    "int TeamsConversation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsConversation("42", "Name"), null);
  }

  /**
   * Test {@link TeamsConversation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TeamsConversation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TeamsConversation.equals(Object)",
    "int TeamsConversation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsConversation("42", "Name"), "Different type to TeamsConversation");
  }
}
