package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityJsonDiffblueTest {
  /**
   * Test {@link EntityJson#EntityJson()}.
   * <p>
   * Method under test: {@link EntityJson#EntityJson()}
   */
  @Test
  @DisplayName("Test new EntityJson()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.entityjson.EntityJson.<init>()",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float, boolean)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(java.util.Map)"})
  void testNewEntityJson() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson()).isEmpty());
  }

  /**
   * Test {@link EntityJson#EntityJson(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#EntityJson(Map)}
   */
  @Test
  @DisplayName("Test new EntityJson(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.entityjson.EntityJson.<init>()",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float, boolean)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(java.util.Map)"})
  void testNewEntityJson_whenHashMap() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson(new HashMap<>())).isEmpty());
  }

  /**
   * Test {@link EntityJson#EntityJson(int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#EntityJson(int)}
   */
  @Test
  @DisplayName("Test new EntityJson(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.entityjson.EntityJson.<init>()",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float, boolean)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(java.util.Map)"})
  void testNewEntityJson_whenOne() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson(1)).isEmpty());
  }

  /**
   * Test {@link EntityJson#EntityJson(int, float)}.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#EntityJson(int, float)}
   */
  @Test
  @DisplayName("Test new EntityJson(int, float); when ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.entityjson.EntityJson.<init>()",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float, boolean)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(java.util.Map)"})
  void testNewEntityJson_whenTen() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson(1, 10.0f)).isEmpty());
  }

  /**
   * Test {@link EntityJson#EntityJson(int, float, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#EntityJson(int, float, boolean)}
   */
  @Test
  @DisplayName("Test new EntityJson(int, float, boolean); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.entityjson.EntityJson.<init>()",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(int, float, boolean)",
      "void org.finos.springbot.entityjson.EntityJson.<init>(java.util.Map)"})
  void testNewEntityJson_whenTrue() {
    // Arrange, Act and Assert
    assertTrue((new EntityJson(1, 10.0f, true)).isEmpty());
  }

  /**
   * Test {@link EntityJson#getEntityJsonTypeName(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code java.lang.object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityJson#getEntityJsonTypeName(Class)}
   */
  @Test
  @DisplayName("Test getEntityJsonTypeName(Class); when 'java.lang.Object'; then return 'java.lang.object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.lang.String org.finos.springbot.entityjson.EntityJson.getEntityJsonTypeName(java.lang.Class)"})
  void testGetEntityJsonTypeName_whenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> cl = Object.class;

    // Act and Assert
    assertEquals("java.lang.object", EntityJson.getEntityJsonTypeName(cl));
  }
}
