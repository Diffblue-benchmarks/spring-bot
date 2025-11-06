package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class HeadingDiffblueTest {
  /**
   * Method under test: {@link Heading.HeadingImpl#buildAnother(List)}
   */
  @Test
  void testHeadingImplBuildAnother() {
    // Arrange
    Heading.HeadingImpl headingImpl = new Heading.HeadingImpl(new ArrayList<>(), 1);

    // Act
    Heading actualBuildAnotherResult = headingImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof Heading.HeadingImpl);
    assertEquals(headingImpl, actualBuildAnotherResult);
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#equals(Object)}
   */
  @Test
  void testHeadingImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Heading.HeadingImpl headingImpl = new Heading.HeadingImpl(new ArrayList<>(), 1);
    Heading.HeadingImpl headingImpl2 = new Heading.HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertEquals(headingImpl, headingImpl2);
    int expectedHashCodeResult = headingImpl.hashCode();
    assertEquals(expectedHashCodeResult, headingImpl2.hashCode());
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#equals(Object)}
   */
  @Test
  void testHeadingImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Heading.HeadingImpl headingImpl = new Heading.HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertEquals(headingImpl, headingImpl);
    int expectedHashCodeResult = headingImpl.hashCode();
    assertEquals(expectedHashCodeResult, headingImpl.hashCode());
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#equals(Object)}
   */
  @Test
  void testHeadingImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Heading.HeadingImpl headingImpl = new Heading.HeadingImpl(new ArrayList<>(), 3);

    // Act and Assert
    assertNotEquals(headingImpl, new Heading.HeadingImpl(new ArrayList<>(), 1));
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#equals(Object)}
   */
  @Test
  void testHeadingImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Heading.HeadingImpl(new ArrayList<>(), 1), null);
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#equals(Object)}
   */
  @Test
  void testHeadingImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Heading.HeadingImpl(new ArrayList<>(), 1), "Different type to HeadingImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Heading.HeadingImpl#HeadingImpl(List, int)}
   *   <li>{@link Heading.HeadingImpl#toString()}
   *   <li>{@link Heading.HeadingImpl#getLevel()}
   * </ul>
   */
  @Test
  void testHeadingImplGettersAndSetters() {
    // Arrange
    ArrayList<Word> c = new ArrayList<>();

    // Act
    Heading.HeadingImpl actualHeadingImpl = new Heading.HeadingImpl(c, 1);
    String actualToStringResult = actualHeadingImpl.toString();

    // Assert
    assertEquals("Heading [[]]", actualToStringResult);
    assertEquals(1, actualHeadingImpl.getLevel());
    List<Word> contents = actualHeadingImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#rightClass(Object)}
   */
  @Test
  void testHeadingImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new Heading.HeadingImpl(new ArrayList<>(), 1)).rightClass("Obj"));
  }

  /**
   * Method under test: {@link Heading.HeadingImpl#rightClass(Object)}
   */
  @Test
  void testHeadingImplRightClass2() {
    // Arrange
    Heading.HeadingImpl headingImpl = new Heading.HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertTrue(headingImpl.rightClass(new Heading.HeadingImpl(new ArrayList<>(), 1)));
  }
}
