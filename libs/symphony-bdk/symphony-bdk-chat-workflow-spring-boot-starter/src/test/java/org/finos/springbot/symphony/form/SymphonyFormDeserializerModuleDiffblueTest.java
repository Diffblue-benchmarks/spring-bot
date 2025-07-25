package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class SymphonyFormDeserializerModuleDiffblueTest {
  /**
   * Test {@link SymphonyFormDeserializerModule#version()}.
   *
   * <p>Method under test: {@link SymphonyFormDeserializerModule#version()}
   */
  @Test
  @DisplayName("Test version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version SymphonyFormDeserializerModule.version()"})
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult =
        new SymphonyFormDeserializerModule(new AllConversations()).version();

    // Assert
    assertEquals("org.finos.springbot.symphony.form", actualVersionResult.getGroupId());
    assertEquals(
        "org.finos.springbot.symphony.form/symphony-form-deserializer-module/1.0.0",
        actualVersionResult.toFullString());
    assertEquals("symphony-form-deserializer-module", actualVersionResult.getArtifactId());
    assertEquals(0, actualVersionResult.getMinorVersion());
    assertEquals(0, actualVersionResult.getPatchLevel());
    assertEquals(1, actualVersionResult.getMajorVersion());
    assertFalse(actualVersionResult.isSnapshot());
    assertFalse(actualVersionResult.isUknownVersion());
    assertFalse(actualVersionResult.isUnknownVersion());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SymphonyFormDeserializerModule#SymphonyFormDeserializerModule(AllConversations)}
   *   <li>{@link SymphonyFormDeserializerModule#getModuleName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SymphonyFormDeserializerModule.<init>(AllConversations)",
    "java.lang.String SymphonyFormDeserializerModule.getModuleName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Symphony Form Deserializer Module",
        new SymphonyFormDeserializerModule(new AllConversations()).getModuleName());
  }

  /**
   * Test {@link SymphonyFormDeserializerModule#setupModule(SetupContext)}.
   *
   * <p>Method under test: {@link SymphonyFormDeserializerModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SymphonyFormDeserializerModule.setupModule(SetupContext)"})
  void testSetupModule() {
    // Arrange
    SymphonyFormDeserializerModule symphonyFormDeserializerModule =
        new SymphonyFormDeserializerModule(new AllConversations());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());

    // Act
    symphonyFormDeserializerModule.setupModule(context);

    // Assert
    verify(context).addDeserializers(isA(Deserializers.class));
  }
}
