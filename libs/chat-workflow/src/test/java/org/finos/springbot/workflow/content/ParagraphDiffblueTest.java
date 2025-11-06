package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParagraphDiffblueTest {
  /**
   * Method under test: {@link Paragraph.ParagraphImpl#buildAnother(List)}
   */
  @Test
  void testParagraphImplBuildAnother() {
    // Arrange
    Paragraph.ParagraphImpl paragraphImpl = new Paragraph.ParagraphImpl(new ArrayList<>());

    // Act
    Paragraph actualBuildAnotherResult = paragraphImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof Paragraph.ParagraphImpl);
    assertEquals(paragraphImpl, actualBuildAnotherResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Paragraph.ParagraphImpl#ParagraphImpl(List)}
   *   <li>{@link Paragraph.ParagraphImpl#toString()}
   * </ul>
   */
  @Test
  void testParagraphImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    Paragraph.ParagraphImpl actualParagraphImpl = new Paragraph.ParagraphImpl(c);

    // Assert
    assertEquals("Paragraph [[]]", actualParagraphImpl.toString());
    List<Content> contents = actualParagraphImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Method under test: {@link Paragraph.ParagraphImpl#rightClass(Object)}
   */
  @Test
  void testParagraphImplRightClass() {
    // Arrange, Act and Assert
    assertFalse((new Paragraph.ParagraphImpl(new ArrayList<>())).rightClass("Obj"));
  }

  /**
   * Method under test: {@link Paragraph.ParagraphImpl#rightClass(Object)}
   */
  @Test
  void testParagraphImplRightClass2() {
    // Arrange
    Paragraph.ParagraphImpl paragraphImpl = new Paragraph.ParagraphImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(paragraphImpl.rightClass(new Message.MessageImpl(new ArrayList<>())));
  }
}
