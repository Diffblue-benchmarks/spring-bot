package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockQuoteDiffblueTest {
  /**
   * Test BlockQuoteImpl {@link BlockQuoteImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BlockQuoteImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test BlockQuoteImpl buildAnother(List); then return BlockQuoteImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockQuote BlockQuoteImpl.buildAnother(List)"})
  void testBlockQuoteImplBuildAnother_thenReturnBlockQuoteImplWithCIsArrayList() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act
    BlockQuote actualBuildAnotherResult = blockQuoteImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof BlockQuoteImpl);
    assertEquals(blockQuoteImpl, actualBuildAnotherResult);
  }

  /**
   * Test BlockQuoteImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockQuoteImpl#BlockQuoteImpl(List)}
   *   <li>{@link BlockQuoteImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test BlockQuoteImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockQuoteImpl.<init>(List)",
    "java.lang.String BlockQuoteImpl.toString()"
  })
  void testBlockQuoteImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    BlockQuoteImpl actualBlockQuoteImpl = new BlockQuoteImpl(c);

    // Assert
    assertEquals("BlockQuote [[]]", actualBlockQuoteImpl.toString());
    List<Content> contents = actualBlockQuoteImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test BlockQuoteImpl {@link BlockQuoteImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  @DisplayName(
      "Test BlockQuoteImpl rightClass(Object); when BlockQuoteImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockQuoteImpl.rightClass(Object)"})
  void testBlockQuoteImplRightClass_whenBlockQuoteImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act
    boolean actualRightClassResult =
        blockQuoteImpl.rightClass(new BlockQuoteImpl(new ArrayList<>()));

    // Assert
    assertTrue(actualRightClassResult);
  }

  /**
   * Test BlockQuoteImpl {@link BlockQuoteImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test BlockQuoteImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BlockQuoteImpl.rightClass(Object)"})
  void testBlockQuoteImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BlockQuoteImpl(new ArrayList<>()).rightClass("Obj"));
  }

  /**
   * Test {@link BlockQuote#of(Content[])} with {@code c}.
   *
   * <p>Method under test: {@link BlockQuote#of(Content[])}
   */
  @Test
  @DisplayName("Test of(Content[]) with 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockQuote BlockQuote.of(Content[])"})
  void testOfWithC() {
    // Arrange and Act
    BlockQuote actualOfResult = BlockQuote.of(mock(Content.class));

    // Assert
    assertTrue(actualOfResult instanceof BlockQuoteImpl);
    List<Content> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("null", actualOfResult.getText());
    Iterator<Content> iteratorResult = actualOfResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }
}
