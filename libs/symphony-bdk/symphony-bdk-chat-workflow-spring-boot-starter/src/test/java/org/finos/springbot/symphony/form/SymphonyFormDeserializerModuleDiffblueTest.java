package org.finos.springbot.symphony.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.fasterxml.jackson.core.Version;
import org.finos.springbot.workflow.conversations.AllConversations;
import org.junit.jupiter.api.Test;

class SymphonyFormDeserializerModuleDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SymphonyFormDeserializerModule#SymphonyFormDeserializerModule(AllConversations)}
   *   <li>{@link SymphonyFormDeserializerModule#getModuleName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Symphony Form Deserializer Module",
        (new SymphonyFormDeserializerModule(new AllConversations())).getModuleName());
  }

  /**
   * Method under test: {@link SymphonyFormDeserializerModule#version()}
   */
  @Test
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult = (new SymphonyFormDeserializerModule(new AllConversations())).version();

    // Assert
    assertEquals("org.finos.springbot.symphony.form", actualVersionResult.getGroupId());
    assertEquals("org.finos.springbot.symphony.form/symphony-form-deserializer-module/1.0.0",
        actualVersionResult.toFullString());
    assertEquals("symphony-form-deserializer-module", actualVersionResult.getArtifactId());
    assertEquals(0, actualVersionResult.getMinorVersion());
    assertEquals(0, actualVersionResult.getPatchLevel());
    assertEquals(1, actualVersionResult.getMajorVersion());
    assertFalse(actualVersionResult.isSnapshot());
    assertFalse(actualVersionResult.isUknownVersion());
    assertFalse(actualVersionResult.isUnknownVersion());
  }
}
