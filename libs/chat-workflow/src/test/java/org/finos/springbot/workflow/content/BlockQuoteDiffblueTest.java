package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockQuoteDiffblueTest {
  /**
   * Test BlockQuoteImpl {@link BlockQuoteImpl#buildAnother(List)}.
   * <ul>
   *   <li>Then return {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockQuoteImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test BlockQuoteImpl buildAnother(List); then return BlockQuoteImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.BlockQuote org.finos.springbot.workflow.content.BlockQuote$BlockQuoteImpl.buildAnother(java.util.List)"})
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BlockQuoteImpl#BlockQuoteImpl(List)}
   *   <li>{@link BlockQuoteImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test BlockQuoteImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.BlockQuote$BlockQuoteImpl.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.content.BlockQuote$BlockQuoteImpl.toString()"})
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
   * <ul>
   *   <li>When {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test BlockQuoteImpl rightClass(Object); when BlockQuoteImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.BlockQuote$BlockQuoteImpl.rightClass(java.lang.Object)"})
  void testBlockQuoteImplRightClass_whenBlockQuoteImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(blockQuoteImpl.rightClass(new BlockQuoteImpl(new ArrayList<>())));
  }

  /**
   * Test BlockQuoteImpl {@link BlockQuoteImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test BlockQuoteImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.BlockQuote$BlockQuoteImpl.rightClass(java.lang.Object)"})
  void testBlockQuoteImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BlockQuoteImpl(new ArrayList<>())).rightClass("Obj"));
  }
}
