package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BlockQuoteDiffblueTest {
  /**
   * Method under test: {@link BlockQuote.BlockQuoteImpl#buildAnother(List)}
   */
  @Test
  void testBlockQuoteImplBuildAnother() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act
    BlockQuote actualBuildAnotherResult = blockQuoteImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof BlockQuote.BlockQuoteImpl);
    assertEquals(blockQuoteImpl, actualBuildAnotherResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BlockQuote.BlockQuoteImpl#BlockQuoteImpl(List)}
   *   <li>{@link BlockQuote.BlockQuoteImpl#toString()}
   * </ul>
   */
  @Test
  void testBlockQuoteImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    BlockQuote.BlockQuoteImpl actualBlockQuoteImpl = new BlockQuote.BlockQuoteImpl(c);

    // Assert
    assertEquals("BlockQuote [[]]", actualBlockQuoteImpl.toString());
    List<Content> contents = actualBlockQuoteImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link BlockQuote.BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  void testBlockQuoteImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new BlockQuote.BlockQuoteImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link BlockQuote.BlockQuoteImpl#rightClass(Object)}
   */
  @Test
  void testBlockQuoteImplRightClass2() {
    // Arrange
    BlockQuote.BlockQuoteImpl blockQuoteImpl = new BlockQuote.BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(blockQuoteImpl.rightClass(new BlockQuote.BlockQuoteImpl(new ArrayList<>())));
  }
}
