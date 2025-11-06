package org.finos.springbot.symphony.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fasterxml.jackson.core.Version;
import org.junit.jupiter.api.Test;

class LegacyFormatModuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LegacyFormatModule}
   *   <li>{@link LegacyFormatModule#getModuleName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Symphony Workflow Module", (new LegacyFormatModule()).getModuleName());
  }

  /**
   * Method under test: {@link LegacyFormatModule#version()}
   */
  @Test
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult = (new LegacyFormatModule()).version();

    // Assert
    assertEquals("legacy-hashtag-module", actualVersionResult.getArtifactId());
    assertEquals("org.finos.springbot.symphony.data", actualVersionResult.getGroupId());
    assertEquals("org.finos.springbot.symphony.data/legacy-hashtag-module/1.0.0", actualVersionResult.toFullString());
    assertEquals(0, actualVersionResult.getMinorVersion());
    assertEquals(0, actualVersionResult.getPatchLevel());
    assertEquals(1, actualVersionResult.getMajorVersion());
    assertFalse(actualVersionResult.isSnapshot());
    assertFalse(actualVersionResult.isUknownVersion());
    assertFalse(actualVersionResult.isUnknownVersion());
  }
}
