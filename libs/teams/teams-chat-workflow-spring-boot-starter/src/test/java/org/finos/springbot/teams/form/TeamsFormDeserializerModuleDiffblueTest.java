package org.finos.springbot.teams.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.deser.Deserializers;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TeamsFormDeserializerModuleDiffblueTest {
  /**
   * Test {@link TeamsFormDeserializerModule#version()}.
   * <p>
   * Method under test: {@link TeamsFormDeserializerModule#version()}
   */
  @Test
  @DisplayName("Test version()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.fasterxml.jackson.core.Version org.finos.springbot.teams.form.TeamsFormDeserializerModule.version()"})
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TeamsFormDeserializerModule#TeamsFormDeserializerModule(AllConversations)}
   *   <li>{@link TeamsFormDeserializerModule#getModuleName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.form.TeamsFormDeserializerModule.<init>(org.finos.springbot.workflow.conversations.AllConversations)",
      "java.lang.String org.finos.springbot.teams.form.TeamsFormDeserializerModule.getModuleName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Teams Form Deserializer Module",
        (new TeamsFormDeserializerModule(new AllConversations())).getModuleName());
  }

  /**
   * Test {@link TeamsFormDeserializerModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link TeamsFormDeserializerModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.teams.form.TeamsFormDeserializerModule.setupModule(com.fasterxml.jackson.databind.Module$SetupContext)"})
  void testSetupModule() {
    // Arrange
    TeamsFormDeserializerModule teamsFormDeserializerModule = new TeamsFormDeserializerModule(new AllConversations());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());

    // Act
    teamsFormDeserializerModule.setupModule(context);

    // Assert
    verify(context).addDeserializers(isA(Deserializers.class));
  }
}
