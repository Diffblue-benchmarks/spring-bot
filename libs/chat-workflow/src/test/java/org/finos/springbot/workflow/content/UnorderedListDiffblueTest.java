package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.UnorderedList.UnorderedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnorderedListDiffblueTest {
  /**
   * Test UnorderedListImpl {@link UnorderedListImpl#buildAnother(List)}.
   * <ul>
   *   <li>Then return {@link UnorderedListImpl#UnorderedListImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnorderedListImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl buildAnother(List); then return UnorderedListImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UnorderedListImpl#UnorderedListImpl(List)}
   *   <li>{@link UnorderedListImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test UnorderedListImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UnorderedListImpl.<init>(List)", "java.lang.String UnorderedListImpl.toString()"})
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
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnorderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl rightClass(Object); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnorderedListImpl.rightClass(Object)"})
  void testUnorderedListImplRightClass_thenReturnTrue() {
    // Arrange
    UnorderedListImpl unorderedListImpl = new UnorderedListImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(unorderedListImpl.rightClass(new UnorderedListImpl(new ArrayList<>())));
  }

  /**
   * Test UnorderedListImpl {@link UnorderedListImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnorderedListImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test UnorderedListImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UnorderedListImpl.rightClass(Object)"})
  void testUnorderedListImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new UnorderedListImpl(new ArrayList<>())).rightClass("Obj"));
  }
}
