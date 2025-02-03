package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.Heading.HeadingImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HeadingDiffblueTest {
  /**
   * Test HeadingImpl {@link HeadingImpl#buildAnother(List)}.
   * <ul>
   *   <li>Then return {@link HeadingImpl#HeadingImpl(List, int)} with c is {@link ArrayList#ArrayList()} and level is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test HeadingImpl buildAnother(List); then return HeadingImpl(List, int) with c is ArrayList() and level is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Heading org.finos.springbot.workflow.content.Heading$HeadingImpl.buildAnother(java.util.List)"})
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
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
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
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
  void testHeadingImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 3);

    // Act and Assert
    assertNotEquals(headingImpl, new HeadingImpl(new ArrayList<>(), 1));
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
  void testHeadingImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HeadingImpl(new ArrayList<>(), 1), null);
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.equals(java.lang.Object)"})
  void testHeadingImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HeadingImpl(new ArrayList<>(), 1), "Different type to HeadingImpl");
  }

  /**
   * Test HeadingImpl getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HeadingImpl#HeadingImpl(List, int)}
   *   <li>{@link HeadingImpl#toString()}
   *   <li>{@link HeadingImpl#getLevel()}
   * </ul>
   */
  @Test
  @DisplayName("Test HeadingImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.Heading$HeadingImpl.<init>(java.util.List, int)",
      "int org.finos.springbot.workflow.content.Heading$HeadingImpl.getLevel()",
      "java.lang.String org.finos.springbot.workflow.content.Heading$HeadingImpl.toString()"})
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
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl rightClass(Object); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.rightClass(java.lang.Object)"})
  void testHeadingImplRightClass_thenReturnTrue() {
    // Arrange
    HeadingImpl headingImpl = new HeadingImpl(new ArrayList<>(), 1);

    // Act and Assert
    assertTrue(headingImpl.rightClass(new HeadingImpl(new ArrayList<>(), 1)));
  }

  /**
   * Test HeadingImpl {@link HeadingImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HeadingImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test HeadingImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean org.finos.springbot.workflow.content.Heading$HeadingImpl.rightClass(java.lang.Object)"})
  void testHeadingImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new HeadingImpl(new ArrayList<>(), 1)).rightClass("Obj"));
  }
}
