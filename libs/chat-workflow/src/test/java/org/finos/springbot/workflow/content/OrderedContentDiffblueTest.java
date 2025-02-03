package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderedContentDiffblueTest {
  /**
   * Test {@link OrderedContent#iterator()}.
   * <p>
   * Method under test: {@link OrderedContent#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator org.finos.springbot.workflow.content.OrderedContent.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new BlockQuoteImpl(new ArrayList<>())).iterator().hasNext());
  }

  /**
   * Test {@link OrderedContent#size()}.
   * <p>
   * Method under test: {@link OrderedContent#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int org.finos.springbot.workflow.content.OrderedContent.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new BlockQuoteImpl(new ArrayList<>())).size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   * <p>
   * Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Content org.finos.springbot.workflow.content.OrderedContent.removeAtStart(org.finos.springbot.workflow.content.Content)"})
  void testRemoveAtStart() {
    // Arrange and Act
    Content actualRemoveAtStartResult = (new BlockQuoteImpl(new ArrayList<>())).removeAtStart(mock(Content.class));
    String actualText = actualRemoveAtStartResult.getText();

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertEquals("", actualRemoveAtStartResult.getText());
    assertEquals("", actualText);
    assertEquals(0, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    assertFalse(((BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    assertTrue(((BlockQuoteImpl) actualRemoveAtStartResult).getContents().isEmpty());
  }

  /**
   * Test {@link OrderedContent#replace(Content, Content)}.
   * <p>
   * Method under test: {@link OrderedContent#replace(Content, Content)}
   */
  @Test
  @DisplayName("Test replace(Content, Content)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.content.Content org.finos.springbot.workflow.content.OrderedContent.replace(org.finos.springbot.workflow.content.Content, org.finos.springbot.workflow.content.Content)"})
  void testReplace() {
    // Arrange and Act
    Content actualReplaceResult = (new BlockQuoteImpl(new ArrayList<>())).replace(mock(Content.class),
        mock(Content.class));
    String actualText = actualReplaceResult.getText();

    // Assert
    assertTrue(actualReplaceResult instanceof BlockQuoteImpl);
    assertEquals("", actualReplaceResult.getText());
    assertEquals("", actualText);
    assertEquals(0, ((BlockQuoteImpl) actualReplaceResult).size());
    assertFalse(((BlockQuoteImpl) actualReplaceResult).iterator().hasNext());
    assertTrue(((BlockQuoteImpl) actualReplaceResult).getContents().isEmpty());
  }

  /**
   * Test {@link OrderedContent#startsWith(Content)}.
   * <ul>
   *   <li>Given {@link Content} {@link Content#startsWith(Content)} return {@code true}.</li>
   *   <li>When {@link Content}.</li>
   *   <li>Then calls {@link Content#startsWith(Content)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName("Test startsWith(Content); given Content startsWith(Content) return 'true'; when Content; then calls startsWith(Content)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.OrderedContent.startsWith(org.finos.springbot.workflow.content.Content)"})
  void testStartsWith_givenContentStartsWithReturnTrue_whenContent_thenCallsStartsWith() {
    // Arrange
    Content content = mock(Content.class);
    when(content.startsWith(Mockito.<Content>any())).thenReturn(true);

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);

    // Act
    boolean actualStartsWithResult = (new BlockQuoteImpl(c)).startsWith(mock(Content.class));

    // Assert
    verify(content).startsWith(isA(Content.class));
    assertTrue(actualStartsWithResult);
  }

  /**
   * Test {@link OrderedContent#startsWith(Content)}.
   * <ul>
   *   <li>When {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName("Test startsWith(Content); when BlockQuoteImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.OrderedContent.startsWith(org.finos.springbot.workflow.content.Content)"})
  void testStartsWith_whenBlockQuoteImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act and Assert
    assertTrue(blockQuoteImpl.startsWith(new BlockQuoteImpl(new ArrayList<>())));
  }

  /**
   * Test {@link OrderedContent#startsWith(Content)}.
   * <ul>
   *   <li>When {@link Content}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName("Test startsWith(Content); when Content; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean org.finos.springbot.workflow.content.OrderedContent.startsWith(org.finos.springbot.workflow.content.Content)"})
  void testStartsWith_whenContent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BlockQuoteImpl(new ArrayList<>())).startsWith(mock(Content.class)));
  }

  /**
   * Test {@link OrderedContent#only(Class)}.
   * <ul>
   *   <li>When {@code Content}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#only(Class)}
   */
  @Test
  @DisplayName("Test only(Class); when 'org.finos.springbot.workflow.content.Content'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List org.finos.springbot.workflow.content.OrderedContent.only(java.lang.Class)"})
  void testOnly_whenOrgFinosSpringbotWorkflowContentContent_thenReturnSizeIsOne() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    Class<Content> x = Content.class;

    // Act
    List<Content> actualOnlyResult = blockQuoteImpl.only(x);

    // Assert
    assertEquals(1, actualOnlyResult.size());
    assertSame(blockQuoteImpl, actualOnlyResult.get(0));
  }

  /**
   * Test {@link OrderedContent#visit(Consumer)}.
   * <p>
   * Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.OrderedContent.visit(java.util.function.Consumer)"})
  void testVisit() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    Consumer<Content> visitor = mock(Consumer.class);
    doNothing().when(visitor).accept(Mockito.<Content>any());

    // Act
    blockQuoteImpl.visit(visitor);

    // Assert
    verify(visitor).accept(isA(Content.class));
  }

  /**
   * Test {@link OrderedContent#visit(Consumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer); given ArrayList() add Content")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.OrderedContent.visit(java.util.function.Consumer)"})
  void testVisit_givenArrayListAddContent() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);
    Consumer<Content> visitor = mock(Consumer.class);
    doNothing().when(visitor).accept(Mockito.<Content>any());

    // Act
    blockQuoteImpl.visit(visitor);

    // Assert
    verify(visitor, atLeast(1)).accept(Mockito.<Content>any());
  }

  /**
   * Test {@link OrderedContent#visit(Consumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer); given ArrayList() add Content")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void org.finos.springbot.workflow.content.OrderedContent.visit(java.util.function.Consumer)"})
  void testVisit_givenArrayListAddContent2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    c.add(mock(Content.class));
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);
    Consumer<Content> visitor = mock(Consumer.class);
    doNothing().when(visitor).accept(Mockito.<Content>any());

    // Act
    blockQuoteImpl.visit(visitor);

    // Assert
    verify(visitor, atLeast(1)).accept(Mockito.<Content>any());
  }
}
