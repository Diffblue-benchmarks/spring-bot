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
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ParagraphDiffblueTest {
  /**
   * Test {@link Paragraph#of(Content[])} with {@code c}.
   *
   * <p>Method under test: {@link Paragraph#of(Content[])}
   */
  @Test
  @DisplayName("Test of(Content[]) with 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paragraph Paragraph.of(Content[])"})
  void testOfWithC() {
    // Arrange and Act
    Paragraph actualOfResult = Paragraph.of(mock(Content.class));

    // Assert
    assertTrue(actualOfResult instanceof ParagraphImpl);
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

  /**
   * Test {@link Paragraph#of(String)} with {@code str}.
   *
   * <p>Method under test: {@link Paragraph#of(String)}
   */
  @Test
  @DisplayName("Test of(String) with 'str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paragraph Paragraph.of(String)"})
  void testOfWithStr() {
    // Arrange and Act
    Paragraph actualOfResult = Paragraph.of("Str");

    // Assert
    assertTrue(actualOfResult instanceof ParagraphImpl);
    List<Content> contents = actualOfResult.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertEquals("Str", actualOfResult.getText());
    Iterator<Content> iteratorResult = actualOfResult.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, actualOfResult.size());
  }

  /**
   * Test ParagraphImpl {@link ParagraphImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>Then return {@link ParagraphImpl#ParagraphImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ParagraphImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test ParagraphImpl buildAnother(List); then return ParagraphImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paragraph ParagraphImpl.buildAnother(List)"})
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParagraphImpl#ParagraphImpl(List)}
   *   <li>{@link ParagraphImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParagraphImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParagraphImpl.<init>(List)", "String ParagraphImpl.toString()"})
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
   *
   * <ul>
   *   <li>When {@link MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParagraphImpl#rightClass(Object)}
   */
  @Test
  @DisplayName(
      "Test ParagraphImpl rightClass(Object); when MessageImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParagraphImpl.rightClass(Object)"})
  void testParagraphImplRightClass_whenMessageImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    ParagraphImpl paragraphImpl = new ParagraphImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(paragraphImpl.rightClass(new MessageImpl(new ArrayList<>())));
  }

  /**
   * Test ParagraphImpl {@link ParagraphImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParagraphImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test ParagraphImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ParagraphImpl.rightClass(Object)"})
  void testParagraphImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ParagraphImpl(new ArrayList<>()).rightClass("Obj"));
  }
}
