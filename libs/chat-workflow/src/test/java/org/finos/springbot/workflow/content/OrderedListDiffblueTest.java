package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderedListDiffblueTest {
  /**
   * Method under test: {@link OrderedList.OrderedListImpl#buildAnother(List)}
   */
  @Test
  void testOrderedListImplBuildAnother() {
    // Arrange
    OrderedList.OrderedListImpl orderedListImpl = new OrderedList.OrderedListImpl(new ArrayList<>());

    // Act
    OrderedList actualBuildAnotherResult = orderedListImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof OrderedList.OrderedListImpl);
    assertEquals(orderedListImpl, actualBuildAnotherResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedList.OrderedListImpl#OrderedListImpl(List)}
   *   <li>{@link OrderedList.OrderedListImpl#toString()}
   * </ul>
   */
  @Test
  void testOrderedListImplGettersAndSetters() {
    // Arrange
    ArrayList<Paragraph> c = new ArrayList<>();

    // Act
    OrderedList.OrderedListImpl actualOrderedListImpl = new OrderedList.OrderedListImpl(c);

    // Assert
    assertEquals("OrderedList [[]]", actualOrderedListImpl.toString());
    List<Paragraph> contents = actualOrderedListImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link OrderedList.OrderedListImpl#rightClass(Object)}
   */
  @Test
  void testOrderedListImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new OrderedList.OrderedListImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link OrderedList.OrderedListImpl#rightClass(Object)}
   */
  @Test
  void testOrderedListImplRightClass2() {
    // Arrange
    OrderedList.OrderedListImpl orderedListImpl = new OrderedList.OrderedListImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(orderedListImpl.rightClass(new OrderedList.OrderedListImpl(new ArrayList<>())));
  }
}
