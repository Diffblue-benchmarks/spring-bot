package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionSpaceDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#VersionSpace(String, Class, String, String[])}
   *   <li>{@link VersionSpace#toString()}
   *   <li>{@link VersionSpace#getToUse()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionSpace.<init>(String, Class, String, String[])", "Class VersionSpace.getToUse()",
      "String VersionSpace.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act
    VersionSpace actualVersionSpace = new VersionSpace("Type Name", toUse, "1.0.2", "1.0.2");
    String actualToStringResult = actualVersionSpace.toString();
    Class<?> actualToUse = actualVersionSpace.getToUse();

    // Assert
    assertEquals("VersionSpace [typeName=Type Name, writeVersion=1.0.2, readVersions=[1.0.2], toUse=class"
        + " java.lang.Object]", actualToStringResult);
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, actualToUse);
    assertSame(toUse, actualToUse);
  }

  /**
   * Test {@link VersionSpace#VersionSpace(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@link VersionSpace#writeVersion} is {@code 1.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#VersionSpace(Class)}
   */
  @Test
  @DisplayName("Test new VersionSpace(Class); when 'java.lang.Object'; then return writeVersion is '1.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionSpace.<init>(Class)"})
  void testNewVersionSpace_whenJavaLangObject_thenReturnWriteVersionIs10() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act
    VersionSpace actualVersionSpace = new VersionSpace(toUse);

    // Assert
    assertEquals("1.0", actualVersionSpace.writeVersion);
    assertEquals("1.0, ", actualVersionSpace.getVersions());
    assertEquals("java.lang.object", actualVersionSpace.typeName);
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, actualVersionSpace.getToUse());
  }

  /**
   * Test {@link VersionSpace#VersionSpace(Class, String, String[])}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@link VersionSpace#writeVersion} is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#VersionSpace(Class, String, String[])}
   */
  @Test
  @DisplayName("Test new VersionSpace(Class, String, String[]); when 'java.lang.Object'; then return writeVersion is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionSpace.<init>(Class, String, String[])"})
  void testNewVersionSpace_whenJavaLangObject_thenReturnWriteVersionIs102() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act
    VersionSpace actualVersionSpace = new VersionSpace(toUse, "1.0.2", "1.0.2");

    // Assert
    assertEquals("1.0.2", actualVersionSpace.writeVersion);
    assertEquals("1.0.2, , 1.0.2", actualVersionSpace.getVersions());
    assertEquals("java.lang.object", actualVersionSpace.typeName);
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, actualVersionSpace.getToUse());
  }

  /**
   * Test {@link VersionSpace#toPattern(String)}.
   * <ul>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then return not test {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#toPattern(String)}
   */
  @Test
  @DisplayName("Test toPattern(String); when '1.0.2'; then return not test 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.function.Predicate VersionSpace.toPattern(String)"})
  void testToPattern_when102_thenReturnNotTestFoo() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).toPattern("1.0.2").test("foo"));
  }

  /**
   * Test {@link VersionSpace#toPattern(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return test {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#toPattern(String)}
   */
  @Test
  @DisplayName("Test toPattern(String); when empty string; then return test 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.function.Predicate VersionSpace.toPattern(String)"})
  void testToPattern_whenEmptyString_thenReturnTestFoo() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).toPattern("").test("foo"));
  }

  /**
   * Test {@link VersionSpace#typeMatches(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#typeMatches(Object)}
   */
  @Test
  @DisplayName("Test typeMatches(Object) with 'Object'; when 'In'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.typeMatches(Object)"})
  void testTypeMatchesWithObject_whenIn_thenReturnFalse() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);

    // Act and Assert
    assertFalse(noVersionResult.typeMatches((Object) "In"));
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, noVersionResult.getToUse());
  }

  /**
   * Test {@link VersionSpace#typeMatches(Object)} with {@code Object}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#typeMatches(Object)}
   */
  @Test
  @DisplayName("Test typeMatches(Object) with 'Object'; when 'java.lang.Object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.typeMatches(Object)"})
  void testTypeMatchesWithObject_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertTrue(noVersionResult.typeMatches(forNameResult));
    Class<Object> expectedToUse = Object.class;
    assertEquals(expectedToUse, noVersionResult.getToUse());
  }

  /**
   * Test {@link VersionSpace#typeMatches(String)} with {@code String}.
   * <ul>
   *   <li>Given {@code Class}.</li>
   *   <li>When {@code Class}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#typeMatches(String)}
   */
  @Test
  @DisplayName("Test typeMatches(String) with 'String'; given 'java.lang.Class'; when 'java.lang.Class'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.typeMatches(String)"})
  void testTypeMatchesWithString_givenJavaLangClass_whenJavaLangClass_thenReturnTrue() {
    // Arrange
    Class<Class> class1 = Class.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).typeMatches("java.lang.Class"));
  }

  /**
   * Test {@link VersionSpace#typeMatches(String)} with {@code String}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#typeMatches(String)}
   */
  @Test
  @DisplayName("Test typeMatches(String) with 'String'; given 'java.lang.Object'; when 'In'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.typeMatches(String)"})
  void testTypeMatchesWithString_givenJavaLangObject_whenIn_thenReturnFalse() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).typeMatches("In"));
  }

  /**
   * Test {@link VersionSpace#versionMatches(String)}.
   * <p>
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  @DisplayName("Test versionMatches(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.versionMatches(String)"})
  void testVersionMatches() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertFalse((new VersionSpace(toUse, "1.0.2", "1.0.2")).versionMatches("In"));
  }

  /**
   * Test {@link VersionSpace#versionMatches(String)}.
   * <p>
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  @DisplayName("Test versionMatches(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.versionMatches(String)"})
  void testVersionMatches2() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertTrue((new VersionSpace(toUse, "1.0.2", "In")).versionMatches("In"));
  }

  /**
   * Test {@link VersionSpace#versionMatches(String)}.
   * <p>
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  @DisplayName("Test versionMatches(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.versionMatches(String)"})
  void testVersionMatches3() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertTrue((new VersionSpace(toUse, "1.0.2", "1.0.2", "In")).versionMatches("In"));
  }

  /**
   * Test {@link VersionSpace#versionMatches(String)}.
   * <ul>
   *   <li>Given noVersion {@link Object}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  @DisplayName("Test versionMatches(String); given noVersion Object; when empty string; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.versionMatches(String)"})
  void testVersionMatches_givenNoVersionObject_whenEmptyString_thenReturnTrue() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).versionMatches(""));
  }

  /**
   * Test {@link VersionSpace#versionMatches(String)}.
   * <ul>
   *   <li>Given noVersion {@link Object}.</li>
   *   <li>When {@code In}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  @DisplayName("Test versionMatches(String); given noVersion Object; when 'In'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.versionMatches(String)"})
  void testVersionMatches_givenNoVersionObject_whenIn_thenReturnFalse() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).versionMatches("In"));
  }

  /**
   * Test {@link VersionSpace#getVersions()}.
   * <ul>
   *   <li>Given noVersion {@link Object}.</li>
   *   <li>Then return {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions(); given noVersion Object; then return ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionSpace.getVersions()"})
  void testGetVersions_givenNoVersionObject_thenReturnComma() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertEquals(", ", ObjectMapperFactory.noVersion(class1).getVersions());
  }

  /**
   * Test {@link VersionSpace#getVersions()}.
   * <ul>
   *   <li>Then return {@code 1.0.2, , 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions(); then return '1.0.2, , 1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionSpace.getVersions()"})
  void testGetVersions_thenReturn102102() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertEquals("1.0.2, , 1.0.2", (new VersionSpace(toUse, "1.0.2", "1.0.2")).getVersions());
  }

  /**
   * Test {@link VersionSpace#getVersions()}.
   * <ul>
   *   <li>Then return {@code 1.0.2, , 1.0.2, Read Versions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions(); then return '1.0.2, , 1.0.2, Read Versions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionSpace.getVersions()"})
  void testGetVersions_thenReturn102102ReadVersions() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertEquals("1.0.2, , 1.0.2, Read Versions",
        (new VersionSpace(toUse, "1.0.2", "1.0.2", "Read Versions")).getVersions());
  }

  /**
   * Test {@link VersionSpace#equals(Object)}, and {@link VersionSpace#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#equals(Object)}
   *   <li>{@link VersionSpace#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);
    Class<Object> class12 = Object.class;
    VersionSpace noVersionResult2 = ObjectMapperFactory.noVersion(class12);

    // Act and Assert
    assertEquals(noVersionResult, noVersionResult2);
    int expectedHashCodeResult = noVersionResult.hashCode();
    assertEquals(expectedHashCodeResult, noVersionResult2.hashCode());
  }

  /**
   * Test {@link VersionSpace#equals(Object)}, and {@link VersionSpace#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#equals(Object)}
   *   <li>{@link VersionSpace#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);

    // Act and Assert
    assertEquals(noVersionResult, noVersionResult);
    int expectedHashCodeResult = noVersionResult.hashCode();
    assertEquals(expectedHashCodeResult, noVersionResult.hashCode());
  }

  /**
   * Test {@link VersionSpace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<Class> class1 = Class.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);
    Class<Object> class12 = Object.class;

    // Act and Assert
    assertNotEquals(noVersionResult, ObjectMapperFactory.noVersion(class12));
  }

  /**
   * Test {@link VersionSpace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Class<Object> toUse = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(versionSpace, ObjectMapperFactory.noVersion(class1));
  }

  /**
   * Test {@link VersionSpace#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Class<Object> toUse = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse, "1.0.2", "1.0.2");
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(versionSpace, ObjectMapperFactory.noVersion(class1));
  }

  /**
   * Test {@link VersionSpace#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(ObjectMapperFactory.noVersion(class1), null);
  }

  /**
   * Test {@link VersionSpace#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionSpace.equals(Object)", "int VersionSpace.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(ObjectMapperFactory.noVersion(class1), "Different type to VersionSpace");
  }
}
