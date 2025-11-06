package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class UnorderedListDiffblueTest {
  /**
   * Method under test: {@link UnorderedList.UnorderedListImpl#buildAnother(List)}
   */
  @Test
  void testUnorderedListImplBuildAnother() {
    // Arrange
    UnorderedList.UnorderedListImpl unorderedListImpl = new UnorderedList.UnorderedListImpl(new ArrayList<>());

    // Act
    UnorderedList actualBuildAnotherResult = unorderedListImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof UnorderedList.UnorderedListImpl);
    assertEquals(unorderedListImpl, actualBuildAnotherResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnorderedList.UnorderedListImpl#UnorderedListImpl(List)}
   *   <li>{@link UnorderedList.UnorderedListImpl#toString()}
   * </ul>
   */
  @Test
  void testUnorderedListImplGettersAndSetters() {
    // Arrange
    ArrayList<Paragraph> c = new ArrayList<>();

    // Act
    UnorderedList.UnorderedListImpl actualUnorderedListImpl = new UnorderedList.UnorderedListImpl(c);

    // Assert
    assertEquals("UnorderedList [[]]", actualUnorderedListImpl.toString());
    List<Paragraph> contents = actualUnorderedListImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link UnorderedList.UnorderedListImpl#rightClass(Object)}
   */
  @Test
  void testUnorderedListImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new UnorderedList.UnorderedListImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link UnorderedList.UnorderedListImpl#rightClass(Object)}
   */
  @Test
  void testUnorderedListImplRightClass2() {
    // Arrange
    UnorderedList.UnorderedListImpl unorderedListImpl = new UnorderedList.UnorderedListImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(unorderedListImpl.rightClass(new UnorderedList.UnorderedListImpl(new ArrayList<>())));
  }
}
