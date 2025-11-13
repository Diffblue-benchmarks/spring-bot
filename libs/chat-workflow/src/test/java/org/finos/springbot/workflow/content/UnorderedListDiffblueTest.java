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
import org.finos.springbot.workflow.content.UnorderedList.UnorderedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnorderedListDiffblueTest {
  /**
   * Test {@link UnorderedList#of(Paragraph[])}.
   *
   * <p>Method under test: {@link UnorderedList#of(Paragraph[])}
   */
  @Test
  @DisplayName("Test of(Paragraph[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnorderedList UnorderedList.of(Paragraph[])"})
  void testOf() {
    // Arrange
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());

    // Act
    UnorderedList actualOfResult = UnorderedList.of(messageImpl);

    // Assert
    assertTrue(actualOfResult instanceof UnorderedListImpl);
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
   * Test UnorderedListImpl {@link UnorderedListImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return Contents is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UnorderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl buildAnother(List); then return Contents is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnorderedList UnorderedListImpl.buildAnother(List)"})
  void testUnorderedListImplBuildAnother_thenReturnContentsIsArrayList() {
    // Arrange
    UnorderedListImpl unorderedListImpl = new UnorderedListImpl(new ArrayList<>());

    ArrayList<Paragraph> contents = new ArrayList<>();
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());
    contents.add(messageImpl);

    // Act
    UnorderedList actualBuildAnotherResult = unorderedListImpl.buildAnother(contents);

    // Assert
    assertTrue(actualBuildAnotherResult instanceof UnorderedListImpl);
    assertSame(contents, actualBuildAnotherResult.getContents());
    Iterator<Paragraph> iteratorResult = actualBuildAnotherResult.iterator();
    Paragraph actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(messageImpl, actualNextResult);
    assertEquals(1, actualBuildAnotherResult.size());
  }

  /**
   * Test UnorderedListImpl {@link UnorderedListImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return {@link UnorderedListImpl#UnorderedListImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UnorderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test UnorderedListImpl buildAnother(List); then return UnorderedListImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UnorderedList UnorderedListImpl.buildAnother(List)"})
  void testUnorderedListImplBuildAnother_thenReturnUnorderedListImplWithCIsArrayList() {
    // Arrange
    UnorderedListImpl unorderedListImpl = new UnorderedListImpl(new ArrayList<>());

    // Act
    UnorderedList actualBuildAnotherResult = unorderedListImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof UnorderedListImpl);
    assertEquals(unorderedListImpl, actualBuildAnotherResult);
  }

  /**
   * Test UnorderedListImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnorderedListImpl#UnorderedListImpl(List)}
   *   <li>{@link UnorderedListImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test UnorderedListImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnorderedListImpl.<init>(List)",
    "java.lang.String UnorderedListImpl.toString()"
  })
  void testUnorderedListImplGettersAndSetters() {
    // Arrange
    ArrayList<Paragraph> c = new ArrayList<>();

    // Act
    UnorderedListImpl actualUnorderedListImpl = new UnorderedListImpl(c);

    // Assert
    assertEquals("UnorderedList [[]]", actualUnorderedListImpl.toString());
    List<Paragraph> contents = actualUnorderedListImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test UnorderedListImpl {@link UnorderedListImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link UnorderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl rightClass(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnorderedListImpl.rightClass(Object)"})
  void testUnorderedListImplRightClass_thenReturnTrue() {
    // Arrange
    UnorderedListImpl unorderedListImpl = new UnorderedListImpl(new ArrayList<>());

    // Act
    boolean actualRightClassResult =
        unorderedListImpl.rightClass(new UnorderedListImpl(new ArrayList<>()));

    // Assert
    assertTrue(actualRightClassResult);
  }

  /**
   * Test UnorderedListImpl {@link UnorderedListImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UnorderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnorderedListImpl.rightClass(Object)"})
  void testUnorderedListImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new UnorderedListImpl(new ArrayList<>()).rightClass("Obj"));
  }
}
