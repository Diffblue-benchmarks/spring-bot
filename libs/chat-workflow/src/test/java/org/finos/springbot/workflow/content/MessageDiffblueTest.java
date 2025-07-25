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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageDiffblueTest {
  /**
   * Test MessageImpl {@link MessageImpl#buildAnother(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link MessageImpl#MessageImpl(List)} with c is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MessageImpl#buildAnother(List)}
   */
  @Test
  @DisplayName(
      "Test MessageImpl buildAnother(List); when ArrayList(); then return MessageImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageImpl.buildAnother(List)"})
  void testMessageImplBuildAnother_whenArrayList_thenReturnMessageImplWithCIsArrayList() {
    // Arrange
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());

    // Act
    Message actualBuildAnotherResult = messageImpl.buildAnother(new ArrayList<>());

    // Assert
    assertTrue(actualBuildAnotherResult instanceof MessageImpl);
    assertEquals(messageImpl, actualBuildAnotherResult);
  }

  /**
   * Test MessageImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageImpl#MessageImpl(List)}
   *   <li>{@link MessageImpl#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test MessageImpl getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageImpl.<init>(List)", "java.lang.String MessageImpl.toString()"})
  void testMessageImplGettersAndSetters() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    // Act
    MessageImpl actualMessageImpl = new MessageImpl(c);

    // Assert
    assertEquals("Message [[]]", actualMessageImpl.toString());
    List<Content> contents = actualMessageImpl.getContents();
    assertTrue(contents.isEmpty());
    assertSame(c, contents);
  }

  /**
   * Test MessageImpl {@link MessageImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@link MessageImpl#MessageImpl(List)} with c is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MessageImpl#rightClass(Object)}
   */
  @Test
  @DisplayName(
      "Test MessageImpl rightClass(Object); when MessageImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageImpl.rightClass(Object)"})
  void testMessageImplRightClass_whenMessageImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    MessageImpl messageImpl = new MessageImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(messageImpl.rightClass(new MessageImpl(new ArrayList<>())));
  }

  /**
   * Test MessageImpl {@link MessageImpl#rightClass(Object)}.
   *
   * <ul>
   *   <li>When {@code Obj}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MessageImpl#rightClass(Object)}
   */
  @Test
  @DisplayName("Test MessageImpl rightClass(Object); when 'Obj'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MessageImpl.rightClass(Object)"})
  void testMessageImplRightClass_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MessageImpl(new ArrayList<>()).rightClass("Obj"));
  }

  /**
   * Test {@link Message#of(Content[])} with {@code Content[]}.
   *
   * <p>Method under test: {@link Message#of(Content[])}
   */
  @Test
  @DisplayName("Test of(Content[]) with 'Content[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message Message.of(Content[])"})
  void testOfWithContent() {
    // Arrange and Act
    Message actualOfResult = Message.of(mock(Content.class));

    // Assert
    assertTrue(actualOfResult instanceof MessageImpl);
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
   * Test {@link Message#of(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Message#of(List)}
   */
  @Test
  @DisplayName("Test of(List) with 'List'; when ArrayList(); then return Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message Message.of(List)"})
  void testOfWithList_whenArrayList_thenReturnTextIsEmptyString() {
    // Arrange and Act
    Message actualOfResult = Message.of(new ArrayList<>());

    // Assert
    assertTrue(actualOfResult instanceof MessageImpl);
    assertEquals("", actualOfResult.getText());
    assertEquals(0, actualOfResult.size());
    assertFalse(actualOfResult.iterator().hasNext());
    assertTrue(actualOfResult.getContents().isEmpty());
  }
}
