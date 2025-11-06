package org.finos.springbot.teams.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fasterxml.jackson.core.Version;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.junit.jupiter.api.Test;

class TeamsFormDeserializerModuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TeamsFormDeserializerModule#TeamsFormDeserializerModule(AllConversations)}
   *   <li>{@link TeamsFormDeserializerModule#getModuleName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Teams Form Deserializer Module",
        (new TeamsFormDeserializerModule(new AllConversations())).getModuleName());
  }

  /**
   * Method under test: {@link TeamsFormDeserializerModule#version()}
   */
  @Test
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult = (new TeamsFormDeserializerModule(new AllConversations())).version();

    // Assert
    assertEquals("org.finos.springbot.teams.form", actualVersionResult.getGroupId());
    assertEquals("org.finos.springbot.teams.form/teams-form-deserializer-module/1.0.0",
        actualVersionResult.toFullString());
    assertEquals("teams-form-deserializer-module", actualVersionResult.getArtifactId());
    assertEquals(0, actualVersionResult.getMinorVersion());
    assertEquals(0, actualVersionResult.getPatchLevel());
    assertEquals(1, actualVersionResult.getMajorVersion());
    assertFalse(actualVersionResult.isSnapshot());
    assertFalse(actualVersionResult.isUknownVersion());
    assertFalse(actualVersionResult.isUnknownVersion());
  }
}
