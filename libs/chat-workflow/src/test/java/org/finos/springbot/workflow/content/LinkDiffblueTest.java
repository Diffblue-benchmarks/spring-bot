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
import org.finos.springbot.workflow.content.Link.LinkImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LinkDiffblueTest {
  /**
   * Test LinkImpl {@link LinkImpl#buildAnother(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link LinkImpl#LinkImpl(String, List)} with {@code Href} and c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test LinkImpl buildAnother(List); when ArrayList(); then return LinkImpl(String, List) with 'Href' and c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Link LinkImpl.buildAnother(List)"})
  void testLinkImplBuildAnother_whenArrayList_thenReturnLinkImplWithHrefAndCIsArrayList() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("Href", new ArrayList<>());

    // Act
    Link actualBuildAnotherResult = linkImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof LinkImpl);
    assertEquals(linkImpl, actualBuildAnotherResult);
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("Href", new ArrayList<>());
    LinkImpl linkImpl2 = new LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertEquals(linkImpl, linkImpl2);
    int expectedHashCodeResult = linkImpl.hashCode();
    assertEquals(expectedHashCodeResult, linkImpl2.hashCode());
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}, and {@link AbstractOrderedContent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertEquals(linkImpl, linkImpl);
    int expectedHashCodeResult = linkImpl.hashCode();
    assertEquals(expectedHashCodeResult, linkImpl.hashCode());
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("org.finos.springbot.workflow.content.Link", new ArrayList<>());

    // Act and Assert
    assertNotEquals(linkImpl, new LinkImpl("Href", new ArrayList<>()));
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new LinkImpl("Href", new ArrayList<>()));
    LinkImpl linkImpl = new LinkImpl("Href", c);

    ArrayList<Content> c2 = new ArrayList<>();
    c2.add(mock(Content.class));

    // Act and Assert
    assertNotEquals(linkImpl, new LinkImpl("Href", c2));
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LinkImpl("Href", new ArrayList<>()), null);
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LinkImpl("Href", new ArrayList<>()), "Different type to LinkImpl");
  }

  /**
   * Test LinkImpl getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LinkImpl#LinkImpl(String, List)}
   *   <li>{@link LinkImpl#toString()}
   *   <li>{@link LinkImpl#getHRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test LinkImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LinkImpl.<init>(String, List)", "String LinkImpl.getHRef()", "String LinkImpl.toString()"})
  void testLinkImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    LinkImpl actualLinkImpl = new LinkImpl("Href", c);
    String actualToStringResult = actualLinkImpl.toString();

    // Assert
    assertEquals("Href", actualLinkImpl.getHRef());
    assertEquals("Link [[]]", actualToStringResult);
    List<Content> contents = actualLinkImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test LinkImpl {@link LinkImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@link LinkImpl#LinkImpl(String, List)} with {@code Href} and c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl rightClass(Object); when LinkImpl(String, List) with 'Href' and c is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.rightClass(Object)"})
  void testLinkImplRightClass_whenLinkImplWithHrefAndCIsArrayList_thenReturnTrue() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertTrue(linkImpl.rightClass(new LinkImpl("Href", new ArrayList<>())));
  }

  /**
   * Test LinkImpl {@link LinkImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LinkImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LinkImpl.rightClass(Object)"})
  void testLinkImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LinkImpl("Href", new ArrayList<>())).rightClass("Obj"));
  }
}
