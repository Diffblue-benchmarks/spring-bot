package org.finos.springbot.symphony.data;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegacyFormatModuleDiffblueTest {
  /**
   * Test {@link LegacyFormatModule#version()}.
   *
   * <p>Method under test: {@link LegacyFormatModule#version()}
   */
  @Test
  @DisplayName("Test version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version LegacyFormatModule.version()"})
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult = new LegacyFormatModule().version();

    // Assert
    assertEquals("legacy-hashtag-module", actualVersionResult.getArtifactId());
    assertEquals("org.finos.springbot.symphony.data", actualVersionResult.getGroupId());
    assertEquals(
        "org.finos.springbot.symphony.data/legacy-hashtag-module/1.0.0",
        actualVersionResult.toFullString());
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
   *   <li>default or parameterless constructor of {@link LegacyFormatModule}
   *   <li>{@link LegacyFormatModule#getModuleName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LegacyFormatModule.<init>()",
    "java.lang.String LegacyFormatModule.getModuleName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Symphony Workflow Module", new LegacyFormatModule().getModuleName());
  }

  /**
   * Test {@link LegacyFormatModule#setupModule(SetupContext)}.
   *
   * <p>Method under test: {@link LegacyFormatModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyFormatModule.setupModule(SetupContext)"})
  void testSetupModule() {
    // Arrange
    LegacyFormatModule legacyFormatModule = new LegacyFormatModule();
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());

    // Act
    legacyFormatModule.setupModule(context);

    // Assert
    verify(context).addDeserializers(isA(Deserializers.class));
  }
}
