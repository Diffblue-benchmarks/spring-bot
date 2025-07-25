package org.finos.springbot.workflow.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.CodeBlock.CodeBlockImpl;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Heading;
import org.finos.springbot.workflow.content.Heading.HeadingImpl;
import org.finos.springbot.workflow.content.Image;
import org.finos.springbot.workflow.content.Image.ImageImpl;
import org.finos.springbot.workflow.content.Link;
import org.finos.springbot.workflow.content.Link.LinkImpl;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.Table.TableImpl;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.HeadingWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.ImageWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.LinkWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.OrderedTagWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.PlainWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.SimpleTagWriter;
import org.finos.springbot.workflow.content.serialization.MarkupWriter.TableWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MarkupWriterDiffblueTest {
  /**
   * Test HeadingWriter {@link HeadingWriter#getTagName(Content)}.
   *
   * <ul>
   *   <li>Then return {@code Tag1}.
   * </ul>
   *
   * <p>Method under test: {@link HeadingWriter#getTagName(Content)}
   */
  @Test
  @DisplayName("Test HeadingWriter getTagName(Content); then return 'Tag1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HeadingWriter.getTagName(Content)"})
  void testHeadingWriterGetTagName_thenReturnTag1() {
    // Arrange
    HeadingWriter headingWriter = new MarkupWriter().new HeadingWriter("Tag");

    // Act and Assert
    assertEquals("Tag1", headingWriter.getTagName(new HeadingImpl(new ArrayList<>(), 1)));
  }

  /**
   * Test HeadingWriter {@link HeadingWriter#getTagName(Content)}.
   *
   * <ul>
   *   <li>When {@link Content}.
   *   <li>Then return {@code Tag}.
   * </ul>
   *
   * <p>Method under test: {@link HeadingWriter#getTagName(Content)}
   */
  @Test
  @DisplayName("Test HeadingWriter getTagName(Content); when Content; then return 'Tag'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HeadingWriter.getTagName(Content)"})
  void testHeadingWriterGetTagName_whenContent_thenReturnTag() {
    // Arrange, Act and Assert
    assertEquals(
        "Tag", new MarkupWriter().new HeadingWriter("Tag").getTagName(mock(Content.class)));
  }

  /**
   * Test HeadingWriter {@link HeadingWriter#HeadingWriter(MarkupWriter, String)}.
   *
   * <p>Method under test: {@link HeadingWriter#HeadingWriter(MarkupWriter, String)}
   */
  @Test
  @DisplayName("Test HeadingWriter new HeadingWriter(MarkupWriter, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HeadingWriter.<init>(MarkupWriter, String)"})
  void testHeadingWriterNewHeadingWriter() {
    // Arrange and Act
    HeadingWriter actualHeadingWriter = new MarkupWriter().new HeadingWriter("Tag");

    // Assert
    assertEquals("Tag", actualHeadingWriter.tag);
    assertNull(actualHeadingWriter.following);
  }

  /**
   * Test ImageWriter {@link ImageWriter#getAttributes(Content)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImageWriter#getAttributes(Content)}
   */
  @Test
  @DisplayName("Test ImageWriter getAttributes(Content); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ImageWriter.getAttributes(Content)"})
  void testImageWriterGetAttributes_thenReturnSizeIsOne() {
    // Arrange
    ImageWriter imageWriter = new MarkupWriter().new ImageWriter();

    // Act
    Map<String, String> actualAttributes =
        imageWriter.getAttributes(new ImageImpl("https://example.org/example", "Alt"));

    // Assert
    assertEquals(1, actualAttributes.size());
    assertEquals("https://example.org/example", actualAttributes.get("src"));
  }

  /**
   * Test ImageWriter {@link ImageWriter#ImageWriter(MarkupWriter)}.
   *
   * <p>Method under test: {@link ImageWriter#ImageWriter(MarkupWriter)}
   */
  @Test
  @DisplayName("Test ImageWriter new ImageWriter(MarkupWriter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageWriter.<init>(MarkupWriter)"})
  void testImageWriterNewImageWriter() {
    // Arrange, Act and Assert
    assertEquals("img", new MarkupWriter().new ImageWriter().tag);
  }

  /**
   * Test LinkWriter {@link LinkWriter#getAttributes(Content)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LinkWriter#getAttributes(Content)}
   */
  @Test
  @DisplayName("Test LinkWriter getAttributes(Content); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map LinkWriter.getAttributes(Content)"})
  void testLinkWriterGetAttributes_thenReturnSizeIsOne() {
    // Arrange
    LinkWriter linkWriter = new MarkupWriter().new LinkWriter();

    // Act
    Map<String, String> actualAttributes =
        linkWriter.getAttributes(new LinkImpl("Href", new ArrayList<>()));

    // Assert
    assertEquals(1, actualAttributes.size());
    assertEquals("Href", actualAttributes.get("href"));
  }

  /**
   * Test LinkWriter {@link LinkWriter#LinkWriter(MarkupWriter)}.
   *
   * <p>Method under test: {@link LinkWriter#LinkWriter(MarkupWriter)}
   */
  @Test
  @DisplayName("Test LinkWriter new LinkWriter(MarkupWriter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LinkWriter.<init>(MarkupWriter)"})
  void testLinkWriterNewLinkWriter() {
    // Arrange, Act and Assert
    assertEquals("a", new MarkupWriter().new LinkWriter().tag);
  }

  /**
   * Test {@link MarkupWriter#MarkupWriter()}.
   *
   * <p>Method under test: {@link MarkupWriter#MarkupWriter()}
   */
  @Test
  @DisplayName("Test new MarkupWriter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkupWriter.<init>()", "void MarkupWriter.<init>(Map)"})
  void testNewMarkupWriter() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>();

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Test {@link MarkupWriter#MarkupWriter(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link MarkupWriter#MarkupWriter(Map)}
   */
  @Test
  @DisplayName("Test new MarkupWriter(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MarkupWriter.<init>()", "void MarkupWriter.<init>(Map)"})
  void testNewMarkupWriter_whenHashMap() {
    // Arrange and Act
    MarkupWriter<Object> actualMarkupWriter = new MarkupWriter<>(new HashMap<>());

    // Assert
    assertTrue(actualMarkupWriter.tagMap.isEmpty());
  }

  /**
   * Test {@link MarkupWriter#apply(Content, Object)} with {@code Content}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link MarkupWriter#MarkupWriter(Map)} with tagMap is {@link HashMap#HashMap()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Content, Object) with 'Content', 'Object'; given MarkupWriter(Map) with tagMap is HashMap(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkupWriter.apply(Content, Object)"})
  void testApplyWithContentObject_givenMarkupWriterWithTagMapIsHashMap_whenNull() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>(new HashMap<>());

    // Act and Assert
    assertEquals("", markupWriter.apply(null, "42"));
  }

  /**
   * Test {@link MarkupWriter#apply(Content, Object)} with {@code Content}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link MarkupWriter#MarkupWriter()}.
   *   <li>When {@link Content}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test apply(Content, Object) with 'Content', 'Object'; given MarkupWriter(); when Content; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkupWriter.apply(Content, Object)"})
  void testApplyWithContentObject_givenMarkupWriter_whenContent_thenReturnEmptyString() {
    // Arrange
    MarkupWriter<Object> markupWriter = new MarkupWriter<>();

    // Act and Assert
    assertEquals("", markupWriter.apply(mock(Content.class), "42"));
  }

  /**
   * Test {@link MarkupWriter#apply(Content, Object)} with {@code Content}, {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link MarkupWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test apply(Content, Object) with 'Content', 'Object'; then return 'Apply'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MarkupWriter.apply(Content, Object)"})
  void testApplyWithContentObject_thenReturnApply() {
    // Arrange
    BiFunction<Content, Object, String> mapper = mock(BiFunction.class);
    when(mapper.apply(Mockito.<Content>any(), Mockito.<Object>any())).thenReturn("Apply");

    MarkupWriter<Object> markupWriter = new MarkupWriter<>();
    Class<Content> cl = Content.class;
    markupWriter.add(cl, mapper);

    // Act
    String actualApplyResult = markupWriter.apply(mock(Content.class), "42");

    // Assert
    verify(mapper).apply(isA(Content.class), isA(Object.class));
    assertEquals("Apply", actualApplyResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject() {
    // Arrange
    BiFunction mapper = mock(BiFunction.class);
    when(mapper.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    MarkupWriter markupWriter = new MarkupWriter();
    Class<Content> cl = Content.class;
    markupWriter.add(cl, mapper);
    OrderedTagWriter orderedTagWriter = markupWriter.new OrderedTagWriter("Tag");

    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));

    // Act
    String actualApplyResult = orderedTagWriter.apply(new BlockQuoteImpl(c), "Ctx");

    // Assert
    verify(mapper).apply(isA(Object.class), isA(Object.class));
    assertEquals("<Tag> Apply</Tag>", actualApplyResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject2() {
    // Arrange
    HeadingWriter headingWriter = new MarkupWriter().new HeadingWriter("Tag");

    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));

    // Act and Assert
    assertEquals("<Tag> </Tag>", headingWriter.apply(new BlockQuoteImpl(c), "Ctx"));
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code <Tag>Apply Apply</Tag>}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'; then return '<Tag>Apply Apply</Tag>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject_thenReturnTagApplyApplyTag() {
    // Arrange
    BiFunction following = mock(BiFunction.class);
    when(following.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");
    OrderedTagWriter orderedTagWriter = new MarkupWriter().new OrderedTagWriter("Tag", following);

    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));
    c.add(null);

    // Act
    String actualApplyResult = orderedTagWriter.apply(new BlockQuoteImpl(c), "Ctx");

    // Assert
    verify(following, atLeast(1)).apply(Mockito.<Object>any(), isA(Object.class));
    assertEquals("<Tag>Apply Apply</Tag>", actualApplyResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code <Tag> Apply</Tag>}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'; then return '<Tag> Apply</Tag>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject_thenReturnTagApplyTag() {
    // Arrange
    BiFunction following = mock(BiFunction.class);
    when(following.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");
    OrderedTagWriter orderedTagWriter = new MarkupWriter().new OrderedTagWriter("Tag", following);

    ArrayList<Content> c = new ArrayList<>();
    c.add(null);

    // Act
    String actualApplyResult = orderedTagWriter.apply(new BlockQuoteImpl(c), "Ctx");

    // Assert
    verify(following).apply(isNull(), isA(Object.class));
    assertEquals("<Tag> Apply</Tag>", actualApplyResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code <Tag> </Tag>}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'; then return '<Tag> </Tag>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject_thenReturnTagTag() {
    // Arrange
    OrderedTagWriter orderedTagWriter = new MarkupWriter().new OrderedTagWriter("Tag");

    ArrayList<Content> c = new ArrayList<>();
    c.add(null);

    // Act and Assert
    assertEquals("<Tag> </Tag>", orderedTagWriter.apply(new BlockQuoteImpl(c), "Ctx"));
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code <Tag> </Tag>}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter apply(Content, Object) with 'Content', 'Object'; then return '<Tag> </Tag>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.apply(Content, Object)"})
  void testOrderedTagWriterApplyWithContentObject_thenReturnTagTag2() {
    // Arrange
    OrderedTagWriter orderedTagWriter = new MarkupWriter().new OrderedTagWriter("Tag");

    ArrayList<Content> c = new ArrayList<>();
    c.add(mock(Content.class));

    // Act and Assert
    assertEquals("<Tag> </Tag>", orderedTagWriter.apply(new BlockQuoteImpl(c), "Ctx"));
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#getTagName(Content)}.
   *
   * <p>Method under test: {@link OrderedTagWriter#getTagName(Content)}
   */
  @Test
  @DisplayName("Test OrderedTagWriter getTagName(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.getTagName(Content)"})
  void testOrderedTagWriterGetTagName() {
    // Arrange, Act and Assert
    assertEquals(
        "Tag", new MarkupWriter().new OrderedTagWriter("Tag").getTagName(mock(Content.class)));
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#OrderedTagWriter(MarkupWriter, String)}.
   *
   * <ul>
   *   <li>Then return {@link OrderedTagWriter#following} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#OrderedTagWriter(MarkupWriter, String)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter new OrderedTagWriter(MarkupWriter, String); then return following is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedTagWriter.<init>(MarkupWriter, String)",
    "void OrderedTagWriter.<init>(MarkupWriter, String, BiFunction)"
  })
  void testOrderedTagWriterNewOrderedTagWriter_thenReturnFollowingIsNull() {
    // Arrange and Act
    OrderedTagWriter actualOrderedTagWriter = new MarkupWriter().new OrderedTagWriter("Tag");

    // Assert
    assertEquals("Tag", actualOrderedTagWriter.tag);
    assertNull(actualOrderedTagWriter.following);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#OrderedTagWriter(MarkupWriter, String,
   * BiFunction)}.
   *
   * <ul>
   *   <li>When {@link BiFunction}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#OrderedTagWriter(MarkupWriter, String,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter new OrderedTagWriter(MarkupWriter, String, BiFunction); when BiFunction")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedTagWriter.<init>(MarkupWriter, String)",
    "void OrderedTagWriter.<init>(MarkupWriter, String, BiFunction)"
  })
  void testOrderedTagWriterNewOrderedTagWriter_whenBiFunction() {
    // Arrange, Act and Assert
    assertEquals("Tag", new MarkupWriter().new OrderedTagWriter("Tag", mock(BiFunction.class)).tag);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#writeInner(Content, Object)}.
   *
   * <p>Method under test: {@link OrderedTagWriter#writeInner(Content, Object)}
   */
  @Test
  @DisplayName("Test OrderedTagWriter writeInner(Content, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.writeInner(Content, Object)"})
  void testOrderedTagWriterWriteInner() {
    // Arrange
    BiFunction following = mock(BiFunction.class);
    when(following.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    // Act
    String actualWriteInnerResult =
        new MarkupWriter().new OrderedTagWriter("Tag", following)
            .writeInner(mock(Content.class), "Ctx");

    // Assert
    verify(following).apply(isA(Object.class), isA(Object.class));
    assertEquals("Apply", actualWriteInnerResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#writeInner(Content, Object)}.
   *
   * <ul>
   *   <li>Given {@code Content}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#writeInner(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter writeInner(Content, Object); given 'org.finos.springbot.workflow.content.Content'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.writeInner(Content, Object)"})
  void testOrderedTagWriterWriteInner_givenOrgFinosSpringbotWorkflowContentContent() {
    // Arrange
    BiFunction mapper = mock(BiFunction.class);
    when(mapper.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    MarkupWriter markupWriter = new MarkupWriter();
    Class<Content> cl = Content.class;
    markupWriter.add(cl, mapper);

    // Act
    String actualWriteInnerResult =
        markupWriter.new OrderedTagWriter("Tag").writeInner(mock(Content.class), "Ctx");

    // Assert
    verify(mapper).apply(isA(Object.class), isA(Object.class));
    assertEquals("Apply", actualWriteInnerResult);
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#writeInner(Content, Object)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#writeInner(Content, Object)}
   */
  @Test
  @DisplayName("Test OrderedTagWriter writeInner(Content, Object); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.writeInner(Content, Object)"})
  void testOrderedTagWriterWriteInner_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", new MarkupWriter().new OrderedTagWriter("Tag").writeInner(mock(Content.class), "Ctx"));
  }

  /**
   * Test OrderedTagWriter {@link OrderedTagWriter#writeInner(Content, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrderedTagWriter#writeInner(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test OrderedTagWriter writeInner(Content, Object); when 'null'; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderedTagWriter.writeInner(Content, Object)"})
  void testOrderedTagWriterWriteInner_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MarkupWriter().new OrderedTagWriter("Tag").writeInner(null, "Ctx"));
  }

  /**
   * Test PlainWriter {@link PlainWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <ul>
   *   <li>When {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PlainWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test PlainWriter apply(Content, Object) with 'Content', 'Object'; when CodeBlockImpl(String) with s is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlainWriter.apply(Content, Object)"})
  void testPlainWriterApplyWithContentObject_whenCodeBlockImplWithSIsFoo_thenReturnFoo() {
    // Arrange
    PlainWriter plainWriter = new MarkupWriter().new PlainWriter();

    // Act and Assert
    assertEquals(" foo ", plainWriter.apply(new CodeBlockImpl("foo"), "42"));
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#apply(Content, Object)} with {@code Content},
   * {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code <Tag>foo</Tag>}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTagWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test SimpleTagWriter apply(Content, Object) with 'Content', 'Object'; then return '<Tag>foo</Tag>'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleTagWriter.apply(Content, Object)"})
  void testSimpleTagWriterApplyWithContentObject_thenReturnTagFooTag() {
    // Arrange
    SimpleTagWriter simpleTagWriter = new MarkupWriter().new SimpleTagWriter("Tag");

    // Act and Assert
    assertEquals("<Tag>foo</Tag>", simpleTagWriter.apply(new CodeBlockImpl("foo"), "42"));
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#formatAttributes(Content)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTagWriter#formatAttributes(Content)}
   */
  @Test
  @DisplayName("Test SimpleTagWriter formatAttributes(Content); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleTagWriter.formatAttributes(Content)"})
  void testSimpleTagWriterFormatAttributes_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", new MarkupWriter().new SimpleTagWriter("Tag").formatAttributes(mock(Content.class)));
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#formatAttributes(Content)}.
   *
   * <ul>
   *   <li>Then return {@code src="https://example.org/example"}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTagWriter#formatAttributes(Content)}
   */
  @Test
  @DisplayName(
      "Test SimpleTagWriter formatAttributes(Content); then return 'src=\"https://example.org/example\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleTagWriter.formatAttributes(Content)"})
  void testSimpleTagWriterFormatAttributes_thenReturnSrcHttpsExampleOrgExample() {
    // Arrange
    ImageWriter imageWriter = new MarkupWriter().new ImageWriter();

    // Act and Assert
    assertEquals(
        " src=\"https://example.org/example\"",
        imageWriter.formatAttributes(new ImageImpl("https://example.org/example", "src")));
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#getAttributes(Content)}.
   *
   * <p>Method under test: {@link SimpleTagWriter#getAttributes(Content)}
   */
  @Test
  @DisplayName("Test SimpleTagWriter getAttributes(Content)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SimpleTagWriter.getAttributes(Content)"})
  void testSimpleTagWriterGetAttributes() {
    // Arrange, Act and Assert
    assertTrue(
        new MarkupWriter().new SimpleTagWriter("Tag").getAttributes(mock(Content.class)).isEmpty());
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#getContainedMarkup(Content)}.
   *
   * <ul>
   *   <li>When {@link CodeBlockImpl#CodeBlockImpl(String)} with s is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTagWriter#getContainedMarkup(Content)}
   */
  @Test
  @DisplayName(
      "Test SimpleTagWriter getContainedMarkup(Content); when CodeBlockImpl(String) with s is 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String SimpleTagWriter.getContainedMarkup(Content)"})
  void testSimpleTagWriterGetContainedMarkup_whenCodeBlockImplWithSIsFoo_thenReturnFoo() {
    // Arrange
    SimpleTagWriter simpleTagWriter = new MarkupWriter().new SimpleTagWriter("Tag");

    // Act and Assert
    assertEquals("foo", simpleTagWriter.getContainedMarkup(new CodeBlockImpl("foo")));
  }

  /**
   * Test SimpleTagWriter {@link SimpleTagWriter#SimpleTagWriter(MarkupWriter, String)}.
   *
   * <p>Method under test: {@link SimpleTagWriter#SimpleTagWriter(MarkupWriter, String)}
   */
  @Test
  @DisplayName("Test SimpleTagWriter new SimpleTagWriter(MarkupWriter, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTagWriter.<init>(MarkupWriter, String)"})
  void testSimpleTagWriterNewSimpleTagWriter() {
    // Arrange, Act and Assert
    assertEquals("Tag", new MarkupWriter().new SimpleTagWriter("Tag").tag);
  }

  /**
   * Test TableWriter {@link TableWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <p>Method under test: {@link TableWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test TableWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableWriter.apply(Content, Object)"})
  void testTableWriterApplyWithContentObject() {
    // Arrange
    TableWriter tableWriter = new MarkupWriter(new HashMap<>()).new TableWriter();

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(null);

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(null);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act and Assert
    assertEquals(
        "<table><thead><tr><th></th></tr></thead><tbody><tr><td></td></tr></tbody></table>",
        tableWriter.apply(new TableImpl(columns, data), "42"));
  }

  /**
   * Test TableWriter {@link TableWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <p>Method under test: {@link TableWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test TableWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableWriter.apply(Content, Object)"})
  void testTableWriterApplyWithContentObject2() {
    // Arrange
    TableWriter tableWriter = new MarkupWriter(new HashMap<>()).new TableWriter();

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(mock(Content.class));
    columns.add(null);

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(null);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act and Assert
    assertEquals(
        "<table><thead><tr><th></th><th></th></tr></thead><tbody><tr><td></td></tr></tbody></table>",
        tableWriter.apply(new TableImpl(columns, data), "42"));
  }

  /**
   * Test TableWriter {@link TableWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <p>Method under test: {@link TableWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test TableWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableWriter.apply(Content, Object)"})
  void testTableWriterApplyWithContentObject3() {
    // Arrange
    TableWriter tableWriter = new MarkupWriter(new HashMap<>()).new TableWriter();

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(null);

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(null);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(new ArrayList<>());
    data.add(contentList);

    // Act and Assert
    assertEquals(
        "<table><thead><tr><th></th></tr></thead><tbody><tr></tr><tr><td></td></tr></tbody></table>",
        tableWriter.apply(new TableImpl(columns, data), "42"));
  }

  /**
   * Test TableWriter {@link TableWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <p>Method under test: {@link TableWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName("Test TableWriter apply(Content, Object) with 'Content', 'Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableWriter.apply(Content, Object)"})
  void testTableWriterApplyWithContentObject4() {
    // Arrange
    BiFunction biFunction = mock(BiFunction.class);
    when(biFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");

    HashMap<Class<? extends Content>, BiFunction> tagMap = new HashMap<>();
    Class<Content> forNameResult = Content.class;
    tagMap.put(forNameResult, biFunction);
    TableWriter tableWriter = new MarkupWriter(tagMap).new TableWriter();

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(mock(Content.class));
    columns.add(null);

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(null);

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act
    String actualApplyResult = tableWriter.apply(new TableImpl(columns, data), "42");

    // Assert
    verify(biFunction).apply(isA(Object.class), isA(Object.class));
    assertEquals(
        "<table><thead><tr><th>Apply</th><th></th></tr></thead><tbody><tr><td></td></tr></tbody></table>",
        actualApplyResult);
  }

  /**
   * Test TableWriter {@link TableWriter#apply(Content, Object)} with {@code Content}, {@code
   * Object}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Content}.
   * </ul>
   *
   * <p>Method under test: {@link TableWriter#apply(Content, Object)}
   */
  @Test
  @DisplayName(
      "Test TableWriter apply(Content, Object) with 'Content', 'Object'; given ArrayList() add Content")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TableWriter.apply(Content, Object)"})
  void testTableWriterApplyWithContentObject_givenArrayListAddContent() {
    // Arrange
    TableWriter tableWriter = new MarkupWriter(new HashMap<>()).new TableWriter();

    ArrayList<Content> columns = new ArrayList<>();
    columns.add(null);

    ArrayList<Content> contentList = new ArrayList<>();
    contentList.add(mock(Content.class));

    ArrayList<List<Content>> data = new ArrayList<>();
    data.add(contentList);

    // Act and Assert
    assertEquals(
        "<table><thead><tr><th></th></tr></thead><tbody><tr><td></td></tr></tbody></table>",
        tableWriter.apply(new TableImpl(columns, data), "42"));
  }
}
