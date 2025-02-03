package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.OrderedList.OrderedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderedListDiffblueTest {
  /**
   * Test OrderedListImpl {@link OrderedListImpl#buildAnother(List)}.
   * <ul>
   *   <li>Then return {@link OrderedListImpl#OrderedListImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test OrderedListImpl buildAnother(List); then return OrderedListImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.OrderedList org.finos.springbot.workflow.content.OrderedList$OrderedListImpl.buildAnother(java.util.List)"})
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedListImpl#OrderedListImpl(List)}
   *   <li>{@link OrderedListImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test OrderedListImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.OrderedList$OrderedListImpl.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.content.OrderedList$OrderedListImpl.toString()"})
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
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test OrderedListImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.OrderedList$OrderedListImpl.rightClass(java.lang.Object)"})
  void testOrderedListImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderedListImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Test OrderedListImpl {@link OrderedListImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@link OrderedListImpl#OrderedListImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test OrderedListImpl rightClass(Object); when OrderedListImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.OrderedList$OrderedListImpl.rightClass(java.lang.Object)"})
  void testOrderedListImplRightClass_whenOrderedListImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    OrderedListImpl orderedListImpl = new OrderedListImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(orderedListImpl.rightClass(new OrderedListImpl(new ArrayList<>())));
  }
}
