package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.OrderedList.OrderedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderedListDiffblueTest {
  /**
   * Test {@link OrderedList#of(Paragraph[])}.
   *
   * <p>Method under test: {@link OrderedList#of(Paragraph[])}
   */
  @Test
  @DisplayName("Test of(Paragraph[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderedList OrderedList.of(Paragraph[])"})
  void testOf() {
    // Arrange
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());

    // Act
    OrderedList actualOfResult = OrderedList.of(messageImpl);

    // Assert
    assertTrue(actualOfResult instanceof OrderedListImpl);
    List<Paragraph> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    assertSame(messageImpl, contents.get(0));
    assertEquals("", actualOfResult.getText());
    Iterator<Paragraph> iteratorResult = actualOfResult.iterator();
    Paragraph actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(messageImpl, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }

  /**
   * Test OrderedListImpl {@link OrderedListImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test OrderedListImpl buildAnother(List); then return Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderedList OrderedListImpl.buildAnother(List)"})
  void testOrderedListImplBuildAnother_thenReturnContentsIsArrayList() {
    // Arrange
    OrderedListImpl orderedListImpl = new OrderedListImpl(new ArrayList<>());

    ArrayList<Paragraph> contents = new ArrayList<>();
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());
    contents.add(messageImpl);

    // Act
    OrderedList actualBuildAnotherResult = orderedListImpl.buildAnother(contents);

    // Assert
    assertTrue(actualBuildAnotherResult instanceof OrderedListImpl);
    assertSame(contents, actualBuildAnotherResult.getContents());
    Iterator<Paragraph> iteratorResult = actualBuildAnotherResult.iterator();
    Paragraph actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(messageImpl, actualNextResult);
    assertEquals(1, actualBuildAnotherResult.size());
  }

  /**
   * Test OrderedListImpl {@link OrderedListImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return {@link OrderedListImpl#OrderedListImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test OrderedListImpl buildAnother(List); then return OrderedListImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderedList OrderedListImpl.buildAnother(List)"})
  void testOrderedListImplBuildAnother_thenReturnOrderedListImplWithCIsArrayList() {
    // Arrange
    OrderedListImpl orderedListImpl = new OrderedListImpl(new ArrayList<>());

    // Act
    OrderedList actualBuildAnotherResult = orderedListImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof OrderedListImpl);
    assertEquals(orderedListImpl, actualBuildAnotherResult);
  }

  /**
   * Test OrderedListImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedListImpl#OrderedListImpl(List)}
   *   <li>{@link OrderedListImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test OrderedListImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedListImpl.<init>(List)",
    "java.lang.String OrderedListImpl.toString()"
  })
  void testOrderedListImplGettersAndSetters() {
    // Arrange
    ArrayList<Paragraph> c = new ArrayList<>();

    // Act
    OrderedListImpl actualOrderedListImpl = new OrderedListImpl(c);

    // Assert
    assertEquals("OrderedList [[]]", actualOrderedListImpl.toString());
    List<Paragraph> contents = actualOrderedListImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test OrderedListImpl {@link OrderedListImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test OrderedListImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedListImpl.rightClass(Object)"})
  void testOrderedListImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new OrderedListImpl(new ArrayList<>()).rightClass("Obj"));
  }

  /**
   * Test OrderedListImpl {@link OrderedListImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@link OrderedListImpl#OrderedListImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedListImpl rightClass(Object); when OrderedListImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedListImpl.rightClass(Object)"})
  void testOrderedListImplRightClass_whenOrderedListImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    OrderedListImpl orderedListImpl = new OrderedListImpl(new ArrayList<>());

    // Act
    boolean actualRightClassResult =
        orderedListImpl.rightClass(new OrderedListImpl(new ArrayList<>()));

    // Assert
    assertTrue(actualRightClassResult);
  }
}
