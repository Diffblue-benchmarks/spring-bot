package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LinkDiffblueTest {
  /**
   * Method under test: {@link Link.LinkImpl#buildAnother(List)}
   */
  @Test
  void testLinkImplBuildAnother() {
    // Arrange
    Link.LinkImpl linkImpl = new Link.LinkImpl("Href", new ArrayList<>());

    // Act
    Link actualBuildAnotherResult = linkImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof Link.LinkImpl);
    assertEquals(linkImpl, actualBuildAnotherResult);
  }

  /**
   * Method under test: {@link Link.LinkImpl#equals(Object)}
   */
  @Test
  void testLinkImplEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Link.LinkImpl linkImpl = new Link.LinkImpl("Href", new ArrayList<>());
    Link.LinkImpl linkImpl2 = new Link.LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertEquals(linkImpl, linkImpl2);
    int expectedHashCodeResult = linkImpl.hashCode();
    assertEquals(expectedHashCodeResult, linkImpl2.hashCode());
  }

  /**
   * Method under test: {@link Link.LinkImpl#equals(Object)}
   */
  @Test
  void testLinkImplEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Link.LinkImpl linkImpl = new Link.LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertEquals(linkImpl, linkImpl);
    int expectedHashCodeResult = linkImpl.hashCode();
    assertEquals(expectedHashCodeResult, linkImpl.hashCode());
  }

  /**
   * Method under test: {@link Link.LinkImpl#equals(Object)}
   */
  @Test
  void testLinkImplEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Link.LinkImpl linkImpl = new Link.LinkImpl("org.finos.springbot.workflow.content.Link", new ArrayList<>());

    // Act and Assert
    assertNotEquals(linkImpl, new Link.LinkImpl("Href", new ArrayList<>()));
  }

  /**
   * Method under test: {@link Link.LinkImpl#equals(Object)}
   */
  @Test
  void testLinkImplEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Link.LinkImpl("Href", new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link Link.LinkImpl#equals(Object)}
   */
  @Test
  void testLinkImplEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Link.LinkImpl("Href", new ArrayList<>()), "Different type to LinkImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Link.LinkImpl#LinkImpl(String, List)}
   *   <li>{@link Link.LinkImpl#toString()}
   *   <li>{@link Link.LinkImpl#getHRef()}
   * </ul>
   */
  @Test
  void testLinkImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    Link.LinkImpl actualLinkImpl = new Link.LinkImpl("Href", c);
    String actualToStringResult = actualLinkImpl.toString();

    // Assert
    assertEquals("Href", actualLinkImpl.getHRef());
    assertEquals("Link [[]]", actualToStringResult);
    List<Content> contents = actualLinkImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link Link.LinkImpl#rightClass(Object)}
   */
  @Test
  void testLinkImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new Link.LinkImpl("Href", new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link Link.LinkImpl#rightClass(Object)}
   */
  @Test
  void testLinkImplRightClass2() {
    // Arrange
    Link.LinkImpl linkImpl = new Link.LinkImpl("Href", new ArrayList<>());

    // Act and Assert
    assertTrue(linkImpl.rightClass(new Link.LinkImpl("Href", new ArrayList<>())));
  }
}
