package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ParagraphDiffblueTest {
  /**
   * Test ParagraphImpl {@link ParagraphImpl#buildAnother(List)}.
   * <ul>
   *   <li>Then return {@link ParagraphImpl#ParagraphImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParagraphImpl#buildAnother(List)}
   */
  @Test
  @DisplayName("Test ParagraphImpl buildAnother(List); then return ParagraphImpl(List) with c is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Paragraph org.finos.springbot.workflow.content.Paragraph$ParagraphImpl.buildAnother(java.util.List)"})
  void testParagraphImplBuildAnother_thenReturnParagraphImplWithCIsArrayList() {
    // Arrange
    ParagraphImpl paragraphImpl = new ParagraphImpl(new ArrayList<>());

    // Act
    Paragraph actualBuildAnotherResult = paragraphImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof ParagraphImpl);
    assertEquals(paragraphImpl, actualBuildAnotherResult);
  }

  /**
   * Test ParagraphImpl getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParagraphImpl#ParagraphImpl(List)}
   *   <li>{@link ParagraphImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParagraphImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.Paragraph$ParagraphImpl.<init>(java.util.List)",
      "java.lang.String org.finos.springbot.workflow.content.Paragraph$ParagraphImpl.toString()"})
  void testParagraphImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    ParagraphImpl actualParagraphImpl = new ParagraphImpl(c);

    // Assert
    assertEquals("Paragraph [[]]", actualParagraphImpl.toString());
    List<Content> contents = actualParagraphImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test ParagraphImpl {@link ParagraphImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@link MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParagraphImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test ParagraphImpl rightClass(Object); when MessageImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.Paragraph$ParagraphImpl.rightClass(java.lang.Object)"})
  void testParagraphImplRightClass_whenMessageImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    ParagraphImpl paragraphImpl = new ParagraphImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(paragraphImpl.rightClass(new MessageImpl(new ArrayList<>())));
  }

  /**
   * Test ParagraphImpl {@link ParagraphImpl#rightClass(Object)}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParagraphImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test ParagraphImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.Paragraph$ParagraphImpl.rightClass(java.lang.Object)"})
  void testParagraphImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ParagraphImpl(new ArrayList<>())).rightClass("Obj"));
  }
}
