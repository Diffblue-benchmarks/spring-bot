package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class EntityJsonDiffblueTest {
  /**
   * Method under test: {@link EntityJson#getEntityJsonTypeName(Class)}
   */
  @Test
  void testGetEntityJsonTypeName() {
    // Arrange
    Class<Object> cl = Object.class;

    // Act and Assert
    assertEquals("java.lang.object", EntityJson.getEntityJsonTypeName(cl));
  }

  /**
   * Method under test: {@link EntityJson#EntityJson()}
   */
  @Test
  void testNewEntityJson() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson()).isEmpty());
    assertTrue((new EntityJson(1)).isEmpty());
    assertTrue((new EntityJson(1, 10.0f)).isEmpty());
    assertTrue((new EntityJson(1, 10.0f, true)).isEmpty());
    assertTrue((new EntityJson(new HashMap<>())).isEmpty());
  }
}
