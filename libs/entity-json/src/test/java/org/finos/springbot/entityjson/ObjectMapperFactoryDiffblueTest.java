package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ObjectMapperFactoryDiffblueTest {
  /**
   * Method under test: {@link ObjectMapperFactory#noVersion(Class)}
   */
  @Test
  void testNoVersion() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act
    VersionSpace actualNoVersionResult = ObjectMapperFactory.noVersion(class1);

    // Assert
    assertEquals("", actualNoVersionResult.writeVersion);
    assertEquals(", ", actualNoVersionResult.getVersions());
    assertEquals("java.lang.object", actualNoVersionResult.typeName);
    Class<Object> expectedToUse = Object.class;
    Class<?> toUse = actualNoVersionResult.getToUse();
    assertEquals(expectedToUse, toUse);
    assertSame(class1, toUse);
  }
}
