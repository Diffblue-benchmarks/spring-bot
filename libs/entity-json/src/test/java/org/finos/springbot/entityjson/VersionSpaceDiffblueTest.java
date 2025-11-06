package org.finos.springbot.entityjson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class VersionSpaceDiffblueTest {
  /**
   * Method under test: {@link VersionSpace#toPattern(String)}
   */
  @Test
  void testToPattern() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).toPattern("1.0.2").test("foo"));
  }

  /**
   * Method under test: {@link VersionSpace#toPattern(String)}
   */
  @Test
  void testToPattern2() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).toPattern("").test("foo"));
  }

  /**
   * Method under test: {@link VersionSpace#typeMatches(Object)}
   */
  @Test
  void testTypeMatches() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);

    // Act and Assert
    assertFalse(noVersionResult.typeMatches((Object) "In"));
    Class<Object> expectedToUse = Object.class;
    Class<?> toUse = noVersionResult.getToUse();
    assertEquals(expectedToUse, toUse);
    assertSame(class1, toUse);
  }

  /**
   * Method under test: {@link VersionSpace#typeMatches(Object)}
   */
  @Test
  void testTypeMatches2() {
    // Arrange
    Class<Object> class1 = Object.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);
    Class<Object> forNameResult = Object.class;

    // Act and Assert
    assertTrue(noVersionResult.typeMatches(forNameResult));
    Class<Object> expectedToUse = Object.class;
    Class<?> toUse = noVersionResult.getToUse();
    assertEquals(expectedToUse, toUse);
    assertSame(forNameResult, toUse);
  }

  /**
   * Method under test: {@link VersionSpace#typeMatches(String)}
   */
  @Test
  void testTypeMatches3() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).typeMatches("In"));
  }

  /**
   * Method under test: {@link VersionSpace#typeMatches(String)}
   */
  @Test
  void testTypeMatches4() {
    // Arrange
    Class<Class> class1 = Class.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).typeMatches("java.lang.Class"));
  }

  /**
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  void testVersionMatches() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertFalse(ObjectMapperFactory.noVersion(class1).versionMatches("In"));
  }

  /**
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  void testVersionMatches2() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertFalse((new VersionSpace(toUse, "1.0.2", "1.0.2")).versionMatches("In"));
  }

  /**
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  void testVersionMatches3() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertTrue(ObjectMapperFactory.noVersion(class1).versionMatches(""));
  }

  /**
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  void testVersionMatches4() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertTrue((new VersionSpace(toUse, "1.0.2", "In")).versionMatches("In"));
  }

  /**
   * Method under test: {@link VersionSpace#versionMatches(String)}
   */
  @Test
  void testVersionMatches5() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertTrue((new VersionSpace(toUse, "1.0.2", "1.0.2", "In")).versionMatches("In"));
  }

  /**
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  void testGetVersions() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertEquals(", ", ObjectMapperFactory.noVersion(class1).getVersions());
  }

  /**
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  void testGetVersions2() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertEquals("1.0.2, , 1.0.2", (new VersionSpace(toUse, "1.0.2", "1.0.2")).getVersions());
  }

  /**
   * Method under test: {@link VersionSpace#getVersions()}
   */
  @Test
  void testGetVersions3() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act and Assert
    assertEquals("1.0.2, , 1.0.2, Read Versions",
        (new VersionSpace(toUse, "1.0.2", "1.0.2", "Read Versions")).getVersions());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#equals(Object)}
   *   <li>{@link VersionSpace#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#equals(Object)}
   *   <li>{@link VersionSpace#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Class<Class> class1 = Class.class;
    VersionSpace noVersionResult = ObjectMapperFactory.noVersion(class1);
    Class<Object> class12 = Object.class;

    // Act and Assert
    assertNotEquals(noVersionResult, ObjectMapperFactory.noVersion(class12));
  }

  /**
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Class<Object> toUse = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse);
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(versionSpace, ObjectMapperFactory.noVersion(class1));
  }

  /**
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Class<Object> toUse = Object.class;
    VersionSpace versionSpace = new VersionSpace(toUse, "1.0.2", "1.0.2");
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(versionSpace, ObjectMapperFactory.noVersion(class1));
  }

  /**
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(ObjectMapperFactory.noVersion(class1), null);
  }

  /**
   * Method under test: {@link VersionSpace#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Class<Object> class1 = Object.class;

    // Act and Assert
    assertNotEquals(ObjectMapperFactory.noVersion(class1), "Different type to VersionSpace");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link VersionSpace#VersionSpace(String, Class, String, String[])}
   *   <li>{@link VersionSpace#toString()}
   *   <li>{@link VersionSpace#getToUse()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link VersionSpace#VersionSpace(Class)}
   */
  @Test
  void testNewVersionSpace() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act
    VersionSpace actualVersionSpace = new VersionSpace(toUse);

    // Assert
    assertEquals("1.0", actualVersionSpace.writeVersion);
    assertEquals("1.0, ", actualVersionSpace.getVersions());
    assertEquals("java.lang.object", actualVersionSpace.typeName);
    Class<Object> expectedToUse = Object.class;
    Class<?> toUse2 = actualVersionSpace.getToUse();
    assertEquals(expectedToUse, toUse2);
    assertSame(toUse, toUse2);
  }

  /**
   * Method under test: {@link VersionSpace#VersionSpace(Class, String, String[])}
   */
  @Test
  void testNewVersionSpace2() {
    // Arrange
    Class<Object> toUse = Object.class;

    // Act
    VersionSpace actualVersionSpace = new VersionSpace(toUse, "1.0.2", "1.0.2");

    // Assert
    assertEquals("1.0.2", actualVersionSpace.writeVersion);
    assertEquals("1.0.2, , 1.0.2", actualVersionSpace.getVersions());
    assertEquals("java.lang.object", actualVersionSpace.typeName);
    Class<Object> expectedToUse = Object.class;
    Class<?> toUse2 = actualVersionSpace.getToUse();
    assertEquals(expectedToUse, toUse2);
    assertSame(toUse, toUse2);
  }
}
