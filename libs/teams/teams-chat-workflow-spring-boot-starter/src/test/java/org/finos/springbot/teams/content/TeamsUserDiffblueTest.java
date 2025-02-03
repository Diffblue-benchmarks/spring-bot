package org.finos.springbot.teams.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TeamsUserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.content.TeamsUser.<init>()",
      "void org.finos.springbot.teams.content.TeamsUser.<init>(java.lang.String, java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getAadObjectId()",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getKey()",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getName()",
      "org.finos.springbot.workflow.content.Tag$Type org.finos.springbot.teams.content.TeamsUser.getTagType()",
      "void org.finos.springbot.teams.content.TeamsUser.setAadObjectId(java.lang.String)",
      "void org.finos.springbot.teams.content.TeamsUser.setKey(java.lang.String)",
      "void org.finos.springbot.teams.content.TeamsUser.setName(java.lang.String)"})
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

    // Assert
    assertEquals("42", actualAadObjectId);
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
  @DisplayName("Test getters and setters; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.teams.content.TeamsUser.<init>()",
      "void org.finos.springbot.teams.content.TeamsUser.<init>(java.lang.String, java.lang.String, java.lang.String)",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getAadObjectId()",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getKey()",
      "java.lang.String org.finos.springbot.teams.content.TeamsUser.getName()",
      "org.finos.springbot.workflow.content.Tag$Type org.finos.springbot.teams.content.TeamsUser.getTagType()",
      "void org.finos.springbot.teams.content.TeamsUser.setAadObjectId(java.lang.String)",
      "void org.finos.springbot.teams.content.TeamsUser.setKey(java.lang.String)",
      "void org.finos.springbot.teams.content.TeamsUser.setName(java.lang.String)"})
  void testGettersAndSetters_when42() {
    // Arrange and Act
    TeamsUser actualTeamsUser = new TeamsUser("42", "Name", "42");
    actualTeamsUser.setAadObjectId("42");
    actualTeamsUser.setKey("Key");
    actualTeamsUser.setName("Name");
    String actualAadObjectId = actualTeamsUser.getAadObjectId();
    String actualKey = actualTeamsUser.getKey();
    String actualName = actualTeamsUser.getName();
    actualTeamsUser.getTagType();

    // Assert
    assertEquals("42", actualAadObjectId);
    assertEquals("Key", actualKey);
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link TeamsUser#getText()}.
   * <p>
   * Method under test: {@link TeamsUser#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String org.finos.springbot.teams.content.TeamsUser.getText()"})
  void testGetText() {
    // Arrange, Act and Assert
    assertEquals("@Name", (new TeamsUser("42", "Name", "42")).getText());
  }

  /**
   * Test {@link TeamsUser#equals(Object)}, and {@link TeamsUser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#equals(Object)}
   *   <li>{@link TeamsUser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsUser.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsUser.hashCode()"})
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
   * Test {@link TeamsUser#equals(Object)}, and {@link TeamsUser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsUser#equals(Object)}
   *   <li>{@link TeamsUser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsUser.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsUser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TeamsUser teamsUser = new TeamsUser("42", "Name", "42");

    // Act and Assert
    assertEquals(teamsUser, teamsUser);
    int expectedHashCodeResult = teamsUser.hashCode();
    assertEquals(expectedHashCodeResult, teamsUser.hashCode());
  }

  /**
   * Test {@link TeamsUser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsUser.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsUser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TeamsUser teamsUser = new TeamsUser("Id", "Name", "42");

    // Act and Assert
    assertNotEquals(teamsUser, new TeamsUser("42", "Name", "42"));
  }

  /**
   * Test {@link TeamsUser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsUser.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsUser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsUser("42", "Name", "42"), null);
  }

  /**
   * Test {@link TeamsUser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TeamsUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.teams.content.TeamsUser.equals(java.lang.Object)",
      "int org.finos.springbot.teams.content.TeamsUser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TeamsUser("42", "Name", "42"), "Different type to TeamsUser");
  }
}
