package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.CodeBlock.CodeBlockImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderedContentDiffblueTest {
  /**
   * Test {@link OrderedContent#iterator()}.
   *
   * <p>Method under test: {@link OrderedContent#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator OrderedContent.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new BlockQuoteImpl(new ArrayList<>()).iterator().hasNext());
  }

  /**
   * Test {@link OrderedContent#size()}.
   *
   * <p>Method under test: {@link OrderedContent#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int OrderedContent.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new BlockQuoteImpl(new ArrayList<>()).size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    Content content = mock(Content.class);
    when(content.removeAtStart(Mockito.<Content>any())).thenReturn(null);
    when(content.getText()).thenReturn("Text");
    when(content.startsWith(Mockito.<Content>any())).thenReturn(true);
    c.add(content);
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(null);
    String actualText = actualRemoveAtStartResult.getText();

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertTrue(((BlockQuoteImpl) actualRemoveAtStartResult).getContents().isEmpty());
    assertEquals("", actualRemoveAtStartResult.getText());
    assertFalse(((BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    assertEquals(0, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    verify(content).startsWith(isNull());
    verify(content).removeAtStart(isNull());
    assertNull(null);
    List<Content> contents = blockQuoteImpl.getContents();
    assertEquals(1, contents.size());
    Content expectedNextResult = contents.get(0);
    assertSame(c, contents);
    assertEquals("Text", blockQuoteImpl.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(expectedNextResult, actualNextResult);
    assertEquals(1, blockQuoteImpl.size());
    assertEquals("", actualText);
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart2() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    c.add(blockQuoteImpl);
    BlockQuoteImpl blockQuoteImpl2 = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl2.removeAtStart(null);

    // Assert
    assertSame(blockQuoteImpl2, actualRemoveAtStartResult);
    assertNull(null);
    assertSame(c, blockQuoteImpl2.getContents());
    assertEquals("", blockQuoteImpl2.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl2.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(blockQuoteImpl, actualNextResult);
    assertEquals(1, blockQuoteImpl2.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code false}.
   *   <li>Then calls {@link Content#matches(Content)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); given 'false'; when Content matches(Content) return 'false'; then calls matches(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_givenFalse_whenContentMatchesReturnFalse_thenCallsMatches() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    ArrayList<Content> c = new ArrayList<>();
    c.add(codeBlockImpl);
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(false);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(item);

    // Assert
    assertSame(blockQuoteImpl, actualRemoveAtStartResult);
    verify(item).matches(isA(Content.class));
    assertSame(c, blockQuoteImpl.getContents());
    assertEquals("foo", blockQuoteImpl.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(codeBlockImpl, actualNextResult);
    assertEquals(1, blockQuoteImpl.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code true}.
   *   <li>Then calls {@link Content#matches(Content)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); given 'true'; when Content matches(Content) return 'true'; then calls matches(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_givenTrue_whenContentMatchesReturnTrue_thenCallsMatches() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    ArrayList<Content> c = new ArrayList<>();
    c.add(codeBlockImpl);
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(true);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(item);

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertTrue(((BlockQuoteImpl) actualRemoveAtStartResult).getContents().isEmpty());
    assertEquals("", actualRemoveAtStartResult.getText());
    assertFalse(((BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    assertEquals(0, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    verify(item, atLeast(1)).matches(isA(Content.class));
    assertSame(c, blockQuoteImpl.getContents());
    assertEquals("foo", blockQuoteImpl.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(codeBlockImpl, actualNextResult);
    assertEquals(1, blockQuoteImpl.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Then {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content); then BlockQuoteImpl(List) with c is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_thenBlockQuoteImplWithCIsArrayList() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());
    c.add(blockQuoteImpl);
    BlockQuoteImpl blockQuoteImpl2 = new BlockQuoteImpl(c);
    BlockQuoteImpl item = new BlockQuoteImpl(new ArrayList<>());

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl2.removeAtStart(item);

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertEquals(blockQuoteImpl, item);
    assertEquals(blockQuoteImpl, actualRemoveAtStartResult);
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Then {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}
   *       Contents Empty.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); then BlockQuoteImpl(List) with c is ArrayList() Contents Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_thenBlockQuoteImplWithCIsArrayListContentsEmpty() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    c.add(new CodeBlockImpl("foo"));
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);
    BlockQuoteImpl item = new BlockQuoteImpl(new ArrayList<>());

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(item);

    // Assert
    assertEquals("", item.getText());
    assertEquals(0, item.size());
    assertFalse(item.iterator().hasNext());
    assertTrue(item.getContents().isEmpty());
    assertSame(blockQuoteImpl, actualRemoveAtStartResult);
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Then {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}
   *       Text is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); then BlockQuoteImpl(List) with c is ArrayList() Text is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_thenBlockQuoteImplWithCIsArrayListTextIsFoo() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    ArrayList<Content> c = new ArrayList<>();
    c.add(codeBlockImpl);
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(null);

    // Assert
    assertSame(blockQuoteImpl, actualRemoveAtStartResult);
    assertNull(null);
    assertSame(c, blockQuoteImpl.getContents());
    assertEquals("foo", blockQuoteImpl.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(codeBlockImpl, actualNextResult);
    assertEquals(1, blockQuoteImpl.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Then Contents first return {@link BlockQuoteImpl}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content); then Contents first return BlockQuoteImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_thenContentsFirstReturnBlockQuoteImpl() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();

    ArrayList<Content> c2 = new ArrayList<>();

    Content content = mock(Content.class);
    when(content.removeAtStart(Mockito.<Content>any())).thenReturn(mock(Content.class));
    when(content.startsWith(Mockito.<Content>any())).thenReturn(true);
    c2.add(content);
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c2);
    c.add(blockQuoteImpl);
    BlockQuoteImpl blockQuoteImpl2 = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl2.removeAtStart(mock(Content.class));

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    List<Content> contents = ((BlockQuoteImpl) actualRemoveAtStartResult).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof BlockQuoteImpl);
    assertEquals("null", actualRemoveAtStartResult.getText());
    Iterator<Content> iteratorResult = ((BlockQuoteImpl) actualRemoveAtStartResult).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    verify(content, atLeast(1)).startsWith(isA(Content.class));
    verify(content).removeAtStart(isA(Content.class));
    assertSame(c, blockQuoteImpl2.getContents());
    assertEquals("null", blockQuoteImpl2.getText());
    Iterator<Content> iteratorResult2 = blockQuoteImpl2.iterator();
    Content actualNextResult2 = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(blockQuoteImpl, actualNextResult2);
    assertEquals(1, blockQuoteImpl2.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>When {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>Then {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); when CodeBlockImpl(String) with s is 'foo'; then CodeBlockImpl(String) with s is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_whenCodeBlockImplWithSIsFoo_thenCodeBlockImplWithSIsFoo() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    ArrayList<Content> c = new ArrayList<>();
    c.add(codeBlockImpl);
    CodeBlockImpl item = new CodeBlockImpl("foo");
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(item);

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertTrue(((BlockQuoteImpl) actualRemoveAtStartResult).getContents().isEmpty());
    assertEquals("", actualRemoveAtStartResult.getText());
    assertFalse(((BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    assertEquals(0, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    assertEquals(codeBlockImpl, item);
    assertSame(c, blockQuoteImpl.getContents());
    assertEquals("foo", blockQuoteImpl.getText());
    Iterator<Content> iteratorResult = blockQuoteImpl.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(codeBlockImpl, actualNextResult);
    assertEquals(1, blockQuoteImpl.size());
  }

  /**
   * Test {@link OrderedContent#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>When {@link Content}.
   *   <li>Then {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}
   *       size is zero.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); when Content; then BlockQuoteImpl(List) with c is ArrayList() size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.removeAtStart(Content)"})
  void testRemoveAtStart_whenContent_thenBlockQuoteImplWithCIsArrayListSizeIsZero() {
    // Arrange
    ArrayList<Content> c = new ArrayList<>();
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(c);

    // Act
    Content actualRemoveAtStartResult = blockQuoteImpl.removeAtStart(mock(Content.class));
    String actualText = actualRemoveAtStartResult.getText();

    // Assert
    assertTrue(actualRemoveAtStartResult instanceof BlockQuoteImpl);
    assertEquals("", blockQuoteImpl.getText());
    assertEquals("", actualRemoveAtStartResult.getText());
    assertEquals("", actualText);
    assertEquals(0, blockQuoteImpl.size());
    assertEquals(0, ((BlockQuoteImpl) actualRemoveAtStartResult).size());
    assertFalse(blockQuoteImpl.iterator().hasNext());
    assertFalse(((BlockQuoteImpl) actualRemoveAtStartResult).iterator().hasNext());
    assertTrue(((BlockQuoteImpl) actualRemoveAtStartResult).getContents().isEmpty());
    assertSame(c, blockQuoteImpl.getContents());
  }

  /**
   * Test {@link OrderedContent#replace(Content, Content)}.
   *
   * <ul>
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#replace(Content, Content)}
   */
  @Test
  @DisplayName("Test replace(Content, Content); then return Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.replace(Content, Content)"})
  void testReplace_thenReturnTextIsEmptyString() {
    // Arrange and Act
    Content actualReplaceResult =
        new BlockQuoteImpl(new ArrayList<>()).replace(mock(Content.class), mock(Content.class));
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
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#startsWith(Content)} return {@code true}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Content#startsWith(Content)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName(
      "Test startsWith(Content); given Content startsWith(Content) return 'true'; when 'null'; then calls startsWith(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedContent.startsWith(Content)"})
  void testStartsWith_givenContentStartsWithReturnTrue_whenNull_thenCallsStartsWith() {
    // Arrange
    Content content = mock(Content.class);
    when(content.startsWith(Mockito.<Content>any())).thenReturn(true);

    ArrayList<Content> c = new ArrayList<>();
    c.add(content);

    // Act
    boolean actualStartsWithResult = new BlockQuoteImpl(c).startsWith(null);

    // Assert
    verify(content).startsWith(isNull());
    assertTrue(actualStartsWithResult);
  }

  /**
   * Test {@link OrderedContent#startsWith(Content)}.
   *
   * <ul>
   *   <li>When {@link BlockQuoteImpl#BlockQuoteImpl(List)} with c is {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName(
      "Test startsWith(Content); when BlockQuoteImpl(List) with c is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedContent.startsWith(Content)"})
  void testStartsWith_whenBlockQuoteImplWithCIsArrayList_thenReturnTrue() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    // Act
    boolean actualStartsWithResult =
        blockQuoteImpl.startsWith(new BlockQuoteImpl(new ArrayList<>()));

    // Assert
    assertTrue(actualStartsWithResult);
  }

  /**
   * Test {@link OrderedContent#startsWith(Content)}.
   *
   * <ul>
   *   <li>When {@link Content}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#startsWith(Content)}
   */
  @Test
  @DisplayName("Test startsWith(Content); when Content; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedContent.startsWith(Content)"})
  void testStartsWith_whenContent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BlockQuoteImpl(new ArrayList<>()).startsWith(mock(Content.class)));
  }

  /**
   * Test {@link OrderedContent#only(Class)}.
   *
   * <ul>
   *   <li>When {@code Content}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#only(Class)}
   */
  @Test
  @DisplayName(
      "Test only(Class); when 'org.finos.springbot.workflow.content.Content'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderedContent.only(Class)"})
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
   * Test {@link OrderedContent#without(Content)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code false}.
   *   <li>Then return Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#without(Content)}
   */
  @Test
  @DisplayName(
      "Test without(Content); given 'false'; when Content matches(Content) return 'false'; then return Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content OrderedContent.without(Content)"})
  void testWithout_givenFalse_whenContentMatchesReturnFalse_thenReturnTextIsEmptyString() {
    // Arrange
    BlockQuoteImpl blockQuoteImpl = new BlockQuoteImpl(new ArrayList<>());

    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(false);

    // Act
    Content actualWithoutResult = blockQuoteImpl.without(item);
    String actualText = actualWithoutResult.getText();

    // Assert
    verify(item).matches(isA(Content.class));
    assertTrue(actualWithoutResult instanceof BlockQuoteImpl);
    assertEquals("", actualText);
    assertEquals(blockQuoteImpl, actualWithoutResult);
  }

  /**
   * Test {@link OrderedContent#visit(Consumer)}.
   *
   * <p>Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderedContent.visit(Consumer)"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer); given ArrayList() add Content")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderedContent.visit(Consumer)"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedContent#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer); given ArrayList() add Content")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderedContent.visit(Consumer)"})
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
