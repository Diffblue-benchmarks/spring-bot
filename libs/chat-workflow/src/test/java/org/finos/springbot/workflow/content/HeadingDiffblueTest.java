package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.Heading.HeadingImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HeadingDiffblueTest {
  /**
   * Test HeadingImpl {@link HeadingImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return {@link HeadingImpl#HeadingImpl(List, int)} with c is {@link
   *       ArrayList#ArrayList()} and level is one.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test HeadingImpl buildAnother(List); then return HeadingImpl(List, int) with c is ArrayList() and level is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Heading HeadingImpl.buildAnother(List)"})
  void testHeadingImplBuildAnother_thenReturnHeadingImplWithCIsArrayListAndLevelIsOne() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 1);

    // Act
    Heading actualBuildAnotherResult = headingImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof HeadingImpl);
    assertEquals(headingImpl, actualBuildAnotherResult);
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}, and {@link HeadingImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test HeadingImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 1);
    HeadingImpl headingImpl2 = new HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertEquals(headingImpl, headingImpl2);
    int expectedHashCodeResult = headingImpl.hashCode();
    assertEquals(expectedHashCodeResult, headingImpl2.hashCode());
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}, and {@link HeadingImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test HeadingImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertEquals(headingImpl, headingImpl);
    int expectedHashCodeResult = headingImpl.hashCode();
    assertEquals(expectedHashCodeResult, headingImpl.hashCode());
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Word> c = new ArrayList<>();
    c.add(mock(Word.class));
    HeadingImpl headingImpl = new HeadingImpl(c, 1);

    // Act and Assert
    assertNotEquals(headingImpl, new HeadingImpl(new ArrayList<>(), 1));
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 3);

    // Act and Assert
    assertNotEquals(headingImpl, new HeadingImpl(new ArrayList<>(), 1));
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HeadingImpl(new ArrayList<>(), 1), null);
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.equals(Object)"})
  void testHeadingImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HeadingImpl(new ArrayList<>(), 1), "Different type to HeadingImpl");
  }

  /**
   * Test HeadingImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HeadingImpl#HeadingImpl(List, int)}
   *   <li>{@link HeadingImpl#toString()}
   *   <li>{@link HeadingImpl#getLevel()}
   * </ul>
   */
  @Test
  @DisplayName("Test HeadingImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HeadingImpl.<init>(List, int)",
    "int HeadingImpl.getLevel()",
    "String HeadingImpl.toString()"
  })
  void testHeadingImplGettersAndSetters() {
    // Arrange
    ArrayList<Word> c = new ArrayList<>();

    // Act
    HeadingImpl actualHeadingImpl = new HeadingImpl(c, 1);
    String actualToStringResult = actualHeadingImpl.toString();

    // Assert
    assertEquals("Heading [[]]", actualToStringResult);
    assertEquals(1, actualHeadingImpl.getLevel());
    List<Word> contents = actualHeadingImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl rightClass(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.rightClass(Object)"})
  void testHeadingImplRightClass_thenReturnTrue() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertTrue(headingImpl.rightClass(new HeadingImpl(new ArrayList<>(), 1)));
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HeadingImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HeadingImpl.rightClass(Object)"})
  void testHeadingImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new HeadingImpl(new ArrayList<>(), 1).rightClass("Obj"));
  }

  /**
   * Test {@link Heading#of(int, Word[])} with {@code level}, {@code c}.
   *
   * <p>Method under test: {@link Heading#of(int, Word[])}
   */
  @Test
  @DisplayName("Test of(int, Word[]) with 'level', 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Heading Heading.of(int, Word[])"})
  void testOfWithLevelC() {
    // Arrange and Act
    Heading actualOfResult = Heading.of(1, mock(Word.class));

    // Assert
    assertTrue(actualOfResult instanceof HeadingImpl);
    List<Word> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Word expectedNextResult = contents.get(0);
    assertEquals(1, actualOfResult.getLevel());
    assertEquals("null", actualOfResult.getText());
    Iterator<Word> iteratorResult = actualOfResult.iterator();
    Word actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }

  /**
   * Test {@link Heading#of(String, int)} with {@code str}, {@code level}.
   *
   * <p>Method under test: {@link Heading#of(String, int)}
   */
  @Test
  @DisplayName("Test of(String, int) with 'str', 'level'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Heading Heading.of(String, int)"})
  void testOfWithStrLevel() {
    // Arrange and Act
    Heading actualOfResult = Heading.of("Str", 1);

    // Assert
    assertTrue(actualOfResult instanceof HeadingImpl);
    List<Word> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Word getResult = contents.get(0);
    assertEquals("str", getResult.getIdentifier());
    assertEquals(1, actualOfResult.getLevel());
    assertEquals("Str", actualOfResult.getText());
    Iterator<Word> iteratorResult = actualOfResult.iterator();
    Word actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }
}
