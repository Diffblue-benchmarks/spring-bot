package org.finos.springbot.workflow.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.finos.springbot.workflow.content.CodeBlock.CodeBlockImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ContentDiffblueTest {
  /**
   * Test {@link Content#only(Class)}.
   *
   * <ul>
   *   <li>When {@code Content}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Content#only(Class)}
   */
  @Test
  @DisplayName(
      "Test only(Class); when 'org.finos.springbot.workflow.content.Content'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Content.only(Class)"})
  void testOnly_whenOrgFinosSpringbotWorkflowContentContent_thenReturnSizeIsOne() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act
    List<Content> actualOnlyResult = codeBlockImpl.only(x);

    // Assert
    assertEquals(1, actualOnlyResult.size());
    Content getResult = actualOnlyResult.get(0);
    assertTrue(getResult instanceof CodeBlockImpl);
    assertEquals("foo", getResult.getText());
    assertSame(codeBlockImpl, getResult);
  }

  /**
   * Test {@link Content#without(Content)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code false}.
   *   <li>Then return {@link CodeBlockImpl}.
   * </ul>
   *
   * <p>Method under test: {@link Content#without(Content)}
   */
  @Test
  @DisplayName(
      "Test without(Content); given 'false'; when Content matches(Content) return 'false'; then return CodeBlockImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.without(Content)"})
  void testWithout_givenFalse_whenContentMatchesReturnFalse_thenReturnCodeBlockImpl() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(false);

    // Act
    Content actualWithoutResult = codeBlockImpl.without(item);
    String actualText = actualWithoutResult.getText();

    // Assert
    verify(item).matches(isA(Content.class));
    assertTrue(actualWithoutResult instanceof CodeBlockImpl);
    assertEquals("foo", codeBlockImpl.getText());
    assertEquals("foo", actualWithoutResult.getText());
    assertEquals("foo", actualText);
  }

  /**
   * Test {@link Content#without(Content)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Content#without(Content)}
   */
  @Test
  @DisplayName(
      "Test without(Content); given 'true'; when Content matches(Content) return 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.without(Content)"})
  void testWithout_givenTrue_whenContentMatchesReturnTrue_thenReturnNull() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(true);

    // Act
    Content actualWithoutResult = codeBlockImpl.without(item);

    // Assert
    verify(item).matches(isA(Content.class));
    assertEquals("foo", codeBlockImpl.getText());
    assertNull(actualWithoutResult);
  }

  /**
   * Test {@link Content#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@link CodeBlockImpl}.
   * </ul>
   *
   * <p>Method under test: {@link Content#removeAtStart(Content)}
   */
  @Test
  @DisplayName("Test removeAtStart(Content); given 'false'; then return CodeBlockImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.removeAtStart(Content)"})
  void testRemoveAtStart_givenFalse_thenReturnCodeBlockImpl() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(false);

    // Act
    Content actualRemoveAtStartResult = codeBlockImpl.removeAtStart(item);
    String actualText = actualRemoveAtStartResult.getText();

    // Assert
    verify(item).matches(isA(Content.class));
    assertTrue(actualRemoveAtStartResult instanceof CodeBlockImpl);
    assertEquals("foo", codeBlockImpl.getText());
    assertEquals("foo", actualRemoveAtStartResult.getText());
    assertEquals("foo", actualText);
  }

  /**
   * Test {@link Content#removeAtStart(Content)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Content#removeAtStart(Content)}
   */
  @Test
  @DisplayName(
      "Test removeAtStart(Content); given 'true'; when Content matches(Content) return 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.removeAtStart(Content)"})
  void testRemoveAtStart_givenTrue_whenContentMatchesReturnTrue_thenReturnNull() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(true);

    // Act
    Content actualRemoveAtStartResult = codeBlockImpl.removeAtStart(item);

    // Assert
    verify(item).matches(isA(Content.class));
    assertEquals("foo", codeBlockImpl.getText());
    assertNull(actualRemoveAtStartResult);
  }

  /**
   * Test {@link Content#replace(Content, Content)}.
   *
   * <ul>
   *   <li>Given {@code Text}.
   *   <li>When {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link Content#replace(Content, Content)}
   */
  @Test
  @DisplayName(
      "Test replace(Content, Content); given 'Text'; when CodeBlockImpl(String) with s is 'foo'; then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.replace(Content, Content)"})
  void testReplace_givenText_whenCodeBlockImplWithSIsFoo_thenReturnText() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    CodeBlockImpl oldContent = new CodeBlockImpl("foo");
    Content newContent = mock(Content.class);
    when(newContent.getText()).thenReturn("Text");

    // Act
    String actualText = codeBlockImpl.replace(oldContent, newContent).getText();

    // Assert
    verify(newContent).getText();
    assertEquals("Text", actualText);
  }

  /**
   * Test {@link Content#replace(Content, Content)}.
   *
   * <ul>
   *   <li>When {@link Content}.
   *   <li>Then return {@link CodeBlockImpl}.
   * </ul>
   *
   * <p>Method under test: {@link Content#replace(Content, Content)}
   */
  @Test
  @DisplayName("Test replace(Content, Content); when Content; then return CodeBlockImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.replace(Content, Content)"})
  void testReplace_whenContent_thenReturnCodeBlockImpl() {
    // Arrange and Act
    Content actualReplaceResult =
        new CodeBlockImpl("foo").replace(mock(Content.class), mock(Content.class));
    String actualText = actualReplaceResult.getText();

    // Assert
    assertTrue(actualReplaceResult instanceof CodeBlockImpl);
    assertEquals("foo", actualReplaceResult.getText());
    assertEquals("foo", actualText);
  }

  /**
   * Test {@link Content#startsWith(Content)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Content#startsWith(Content)}
   */
  @Test
  @DisplayName(
      "Test startsWith(Content); given 'false'; when Content matches(Content) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Content.startsWith(Content)"})
  void testStartsWith_givenFalse_whenContentMatchesReturnFalse_thenReturnFalse() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(false);

    // Act
    boolean actualStartsWithResult = codeBlockImpl.startsWith(item);

    // Assert
    verify(item).matches(isA(Content.class));
    assertFalse(actualStartsWithResult);
  }

  /**
   * Test {@link Content#startsWith(Content)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Content} {@link Content#matches(Content)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Content#startsWith(Content)}
   */
  @Test
  @DisplayName(
      "Test startsWith(Content); given 'true'; when Content matches(Content) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Content.startsWith(Content)"})
  void testStartsWith_givenTrue_whenContentMatchesReturnTrue_thenReturnTrue() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Content item = mock(Content.class);
    when(item.matches(Mockito.<Content>any())).thenReturn(true);

    // Act
    boolean actualStartsWithResult = codeBlockImpl.startsWith(item);

    // Assert
    verify(item).matches(isA(Content.class));
    assertTrue(actualStartsWithResult);
  }

  /**
   * Test {@link Content#getNth(Class, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  @DisplayName("Test getNth(Class, int); when 'null'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Content.getNth(Class, int)"})
  void testGetNth_whenNull_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(new CodeBlockImpl("foo").getNth(null, 1).isPresent());
  }

  /**
   * Test {@link Content#getNth(Class, int)}.
   *
   * <ul>
   *   <li>When {@code Content}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  @DisplayName(
      "Test getNth(Class, int); when 'org.finos.springbot.workflow.content.Content'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Content.getNth(Class, int)"})
  void testGetNth_whenOrgFinosSpringbotWorkflowContentContent_thenReturnNotPresent() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act and Assert
    assertFalse(codeBlockImpl.getNth(x, 1).isPresent());
  }

  /**
   * Test {@link Content#getNth(Class, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then {@link Optional#get()} return {@link CodeBlockImpl}.
   * </ul>
   *
   * <p>Method under test: {@link Content#getNth(Class, int)}
   */
  @Test
  @DisplayName("Test getNth(Class, int); when zero; then get() return CodeBlockImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Content.getNth(Class, int)"})
  void testGetNth_whenZero_thenGetReturnCodeBlockImpl() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Class<Content> x = Content.class;

    // Act
    Optional<Content> actualNth = codeBlockImpl.getNth(x, 0);

    // Assert
    Content getResult = actualNth.get();
    assertTrue(getResult instanceof CodeBlockImpl);
    assertEquals("foo", getResult.getText());
    assertTrue(actualNth.isPresent());
    assertSame(codeBlockImpl, getResult);
  }

  /**
   * Test {@link Content#matches(Content)}.
   *
   * <ul>
   *   <li>Given {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>When {@link Content}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Content#matches(Content)}
   */
  @Test
  @DisplayName(
      "Test matches(Content); given CodeBlockImpl(String) with s is 'foo'; when Content; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Content.matches(Content)"})
  void testMatches_givenCodeBlockImplWithSIsFoo_whenContent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new CodeBlockImpl("foo").matches(mock(Content.class)));
  }

  /**
   * Test {@link Content#matches(Content)}.
   *
   * <ul>
   *   <li>Given {@link Content} {@link Content#matches(Content)} return {@code true}.
   *   <li>When {@link Content}.
   *   <li>Then calls {@link Content#matches(Content)}.
   * </ul>
   *
   * <p>Method under test: {@link Content#matches(Content)}
   */
  @Test
  @DisplayName(
      "Test matches(Content); given Content matches(Content) return 'true'; when Content; then calls matches(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Content.matches(Content)"})
  void testMatches_givenContentMatchesReturnTrue_whenContent_thenCallsMatches() {
    // Arrange
    Content content = mock(Content.class);
    when(content.matches(Mockito.<Content>any())).thenReturn(true);

    // Act
    content.matches(mock(Content.class));

    // Assert
    verify(content).matches(isA(Content.class));
  }

  /**
   * Test {@link Content#matches(Content)}.
   *
   * <ul>
   *   <li>When {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Content#matches(Content)}
   */
  @Test
  @DisplayName(
      "Test matches(Content); when CodeBlockImpl(String) with s is 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Content.matches(Content)"})
  void testMatches_whenCodeBlockImplWithSIsFoo_thenReturnTrue() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");

    // Act and Assert
    assertTrue(codeBlockImpl.matches(new CodeBlockImpl("foo")));
  }

  /**
   * Test {@link Content#visit(Consumer)}.
   *
   * <p>Method under test: {@link Content#visit(Consumer)}
   */
  @Test
  @DisplayName("Test visit(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Content.visit(Consumer)"})
  void testVisit() {
    // Arrange
    CodeBlockImpl codeBlockImpl = new CodeBlockImpl("foo");
    Consumer<Content> visitor = mock(Consumer.class);
    doNothing().when(visitor).accept(Mockito.<Content>any());

    // Act
    codeBlockImpl.visit(visitor);

    // Assert
    verify(visitor).accept(isA(Content.class));
  }

  /**
   * Test {@link Content#empty()}.
   *
   * <p>Method under test: {@link Content#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Content Content.empty()"})
  void testEmpty() {
    // Arrange and Act
    Content actualEmptyResult = Content.empty();

    // Assert
    assertEquals("", actualEmptyResult.getText());
    assertFalse(actualEmptyResult.matches(null));
    assertFalse(actualEmptyResult.startsWith(null));
  }
}
