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
import org.finos.springbot.workflow.content.Link.LinkImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LinkDiffblueTest {
  /**
   * Test LinkImpl {@link LinkImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link LinkImpl#LinkImpl(String, List)} with {@code Href} and c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test LinkImpl buildAnother(List); when ArrayList(); then return LinkImpl(String, List) with 'Href' and c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test LinkImpl {@link LinkImpl#equals(Object)}, and {@link LinkImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test LinkImpl equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test LinkImpl {@link LinkImpl#equals(Object)}, and {@link LinkImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test LinkImpl equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LinkImpl linkImpl =
        new LinkImpl("org.finos.springbot.workflow.content.Link", new ArrayList<>());

    // Act and Assert
    assertNotEquals(linkImpl, new LinkImpl("Href", new ArrayList<>()));
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LinkImpl("Href", new ArrayList<>()), null);
  }

  /**
   * Test LinkImpl {@link LinkImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#equals(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LinkImpl.equals(Object)"})
  void testLinkImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LinkImpl("Href", new ArrayList<>()), "Different type to LinkImpl");
  }

  /**
   * Test LinkImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LinkImpl#LinkImpl(String, List)}
   *   <li>{@link LinkImpl#toString()}
   *   <li>{@link LinkImpl#getHRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test LinkImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LinkImpl.<init>(String, List)",
    "String LinkImpl.getHRef()",
    "String LinkImpl.toString()"
  })
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
   *
   * <ul>
   *   <li>When {@link LinkImpl#LinkImpl(String, List)} with {@code Href} and c is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#rightClass(Object)}
   */
  @Test
  @DisplayName(
      "Test LinkImpl rightClass(Object); when LinkImpl(String, List) with 'Href' and c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LinkImpl.rightClass(Object)"})
  void testLinkImplRightClass_whenLinkImplWithHrefAndCIsArrayList_thenReturnTrue() {
    // Arrange
    LinkImpl linkImpl = new LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertTrue(linkImpl.rightClass(new LinkImpl("Href", new ArrayList<>())));
  }

  /**
   * Test LinkImpl {@link LinkImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LinkImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test LinkImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LinkImpl.rightClass(Object)"})
  void testLinkImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new LinkImpl("Href", new ArrayList<>()).rightClass("Obj"));
  }

  /**
   * Test {@link Link#of(String, Content[])} with {@code href}, {@code c}.
   *
   * <p>Method under test: {@link Link#of(String, Content[])}
   */
  @Test
  @DisplayName("Test of(String, Content[]) with 'href', 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Link Link.of(String, Content[])"})
  void testOfWithHrefC() {
    // Arrange and Act
    Link actualOfResult = Link.of("Href", mock(Content.class));

    // Assert
    assertTrue(actualOfResult instanceof LinkImpl);
    List<Content> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("Href", actualOfResult.getHRef());
    assertEquals("null", actualOfResult.getText());
    Iterator<Content> iteratorResult = actualOfResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }

  /**
   * Test {@link Link#of(String, String)} with {@code href}, {@code text}.
   *
   * <p>Method under test: {@link Link#of(String, String)}
   */
  @Test
  @DisplayName("Test of(String, String) with 'href', 'text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Link Link.of(String, String)"})
  void testOfWithHrefText() {
    // Arrange and Act
    Link actualOfResult = Link.of("Href", "Text");

    // Assert
    assertTrue(actualOfResult instanceof LinkImpl);
    List<Content> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("Href", actualOfResult.getHRef());
    assertEquals("Text", actualOfResult.getText());
    Iterator<Content> iteratorResult = actualOfResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }
}
