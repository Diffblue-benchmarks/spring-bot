package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ObjectMapperFactoryDiffblueTest {
  /**
   * Test {@link ObjectMapperFactory#noVersion(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@link VersionSpace#writeVersion} is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ObjectMapperFactory#noVersion(Class)}
   */
  @Test
  @DisplayName("Test noVersion(Class); when 'java.lang.Object'; then return writeVersion is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.entityjson.VersionSpace org.finos.springbot.entityjson.ObjectMapperFactory.noVersion(java.lang.Class)"})
  void testNoVersion_whenJavaLangObject_thenReturnWriteVersionIsEmptyString() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act
    VersionSpace actualNoVersionResult = ObjectMapperFactory.noVersion(class1);

    // Assert
    assertEquals("", actualNoVersionResult.writeVersion);
    assertEquals(", ", actualNoVersionResult.getVersions());
    assertEquals("java.lang.object", actualNoVersionResult.typeName);
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, actualNoVersionResult.getToUse());
  }
}
