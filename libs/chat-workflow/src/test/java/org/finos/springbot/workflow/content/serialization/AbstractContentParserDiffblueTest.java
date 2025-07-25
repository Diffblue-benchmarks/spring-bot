package org.finos.springbot.workflow.content.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.BlockQuote;
import org.finos.springbot.workflow.content.BlockQuote.BlockQuoteImpl;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.CodeBlock.CodeBlockImpl;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.OrderedContent;
import org.finos.springbot.workflow.content.OrderedList;
import org.finos.springbot.workflow.content.OrderedList.OrderedListImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.UnorderedList;
import org.finos.springbot.workflow.content.UnorderedList.UnorderedListImpl;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.BlockQuoteFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.CodeBlockFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.ContainerFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.IgnoredFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.ListFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.MessageFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.ParagraphFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.TableFrame;
import org.finos.springbot.workflow.content.serialization.AbstractContentParser.TextRunFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractContentParserDiffblueTest {
  /**
   * Test BlockQuoteFrame {@link BlockQuoteFrame#getContents()}.
   *
   * <p>Method under test: {@link BlockQuoteFrame#getContents()}
   */
  @Test
  @DisplayName("Test BlockQuoteFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BlockQuote BlockQuoteFrame.getContents()"})
  void testBlockQuoteFrameGetContents() {
    // Arrange and Act
    BlockQuote actualContents = new BlockQuoteFrame("Tag").getContents();

    // Assert
    assertTrue(actualContents instanceof BlockQuoteImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Test BlockQuoteFrame {@link BlockQuoteFrame#BlockQuoteFrame(String)}.
   *
   * <p>Method under test: {@link BlockQuoteFrame#BlockQuoteFrame(String)}
   */
  @Test
  @DisplayName("Test BlockQuoteFrame new BlockQuoteFrame(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockQuoteFrame.<init>(String)"})
  void testBlockQuoteFrameNewBlockQuoteFrame() {
    // Arrange and Act
    BlockQuoteFrame actualBlockQuoteFrame = new BlockQuoteFrame("Tag");

    // Assert
    assertEquals("", actualBlockQuoteFrame.buf.toString());
    assertTrue(actualBlockQuoteFrame.stuffSoFar.isEmpty());
  }

  /**
   * Test CodeBlockFrame {@link CodeBlockFrame#getContents()}.
   *
   * <p>Method under test: {@link CodeBlockFrame#getContents()}
   */
  @Test
  @DisplayName("Test CodeBlockFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeBlock CodeBlockFrame.getContents()"})
  void testCodeBlockFrameGetContents() {
    // Arrange and Act
    CodeBlock actualContents = new CodeBlockFrame("Tag").getContents();
    String actualText = actualContents.getText();

    // Assert
    assertTrue(actualContents instanceof CodeBlockImpl);
    assertEquals("", actualContents.getText());
    assertEquals("", actualText);
  }

  /**
   * Test CodeBlockFrame getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeBlockFrame#CodeBlockFrame(String)}
   *   <li>{@link CodeBlockFrame#push(Content)}
   * </ul>
   */
  @Test
  @DisplayName("Test CodeBlockFrame getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeBlockFrame.<init>(String)", "void CodeBlockFrame.push(Content)"})
  void testCodeBlockFrameGettersAndSetters() {
    // Arrange and Act
    CodeBlockFrame actualCodeBlockFrame = new CodeBlockFrame("Tag");
    actualCodeBlockFrame.push(mock(Content.class));

    // Assert
    assertEquals("", actualCodeBlockFrame.buf.toString());
  }

  /**
   * Test CodeBlockFrame {@link CodeBlockFrame#hasContent()}.
   *
   * <p>Method under test: {@link CodeBlockFrame#hasContent()}
   */
  @Test
  @DisplayName("Test CodeBlockFrame hasContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeBlockFrame.hasContent()"})
  void testCodeBlockFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse(new CodeBlockFrame("Tag").hasContent());
  }

  /**
   * Test ContainerFrame {@link ContainerFrame#isEnding(String)}.
   *
   * <ul>
   *   <li>Given {@link BlockQuoteFrame#BlockQuoteFrame(String)} with tag is {@code Q Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ContainerFrame#isEnding(String)}
   */
  @Test
  @DisplayName(
      "Test ContainerFrame isEnding(String); given BlockQuoteFrame(String) with tag is 'Q Name'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContainerFrame.isEnding(String)"})
  void testContainerFrameIsEnding_givenBlockQuoteFrameWithTagIsQName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new BlockQuoteFrame("Q Name").isEnding("Q Name"));
  }

  /**
   * Test ContainerFrame {@link ContainerFrame#isEnding(String)}.
   *
   * <ul>
   *   <li>Given {@link BlockQuoteFrame#BlockQuoteFrame(String)} with {@code Tag}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ContainerFrame#isEnding(String)}
   */
  @Test
  @DisplayName(
      "Test ContainerFrame isEnding(String); given BlockQuoteFrame(String) with 'Tag'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ContainerFrame.isEnding(String)"})
  void testContainerFrameIsEnding_givenBlockQuoteFrameWithTag_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BlockQuoteFrame("Tag").isEnding("Q Name"));
  }

  /**
   * Test IgnoredFrame getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IgnoredFrame#IgnoredFrame(String)}
   *   <li>{@link IgnoredFrame#push(Content)}
   *   <li>{@link IgnoredFrame#getContents()}
   *   <li>{@link IgnoredFrame#hasContent()}
   * </ul>
   */
  @Test
  @DisplayName("Test IgnoredFrame getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IgnoredFrame.<init>(String)",
    "Content IgnoredFrame.getContents()",
    "boolean IgnoredFrame.hasContent()",
    "void IgnoredFrame.push(Content)"
  })
  void testIgnoredFrameGettersAndSetters() {
    // Arrange and Act
    IgnoredFrame actualIgnoredFrame = new IgnoredFrame("Tag");
    actualIgnoredFrame.push(mock(Content.class));
    Content actualContents = actualIgnoredFrame.getContents();
    boolean actualHasContentResult = actualIgnoredFrame.hasContent();

    // Assert
    assertEquals("", actualIgnoredFrame.buf.toString());
    assertNull(actualContents);
    assertFalse(actualHasContentResult);
  }

  /**
   * Test ListFrame {@link ListFrame#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ListFrame#ListFrame(String)} with qName is {@code ol}.
   *   <li>Then return {@link OrderedList.OrderedListImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ListFrame#getContents()}
   */
  @Test
  @DisplayName(
      "Test ListFrame getContents(); given ListFrame(String) with qName is 'ol'; then return OrderedListImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderedContent ListFrame.getContents()"})
  void testListFrameGetContents_givenListFrameWithQNameIsOl_thenReturnOrderedListImpl() {
    // Arrange and Act
    OrderedContent<?> actualContents = new ListFrame("ol").getContents();

    // Assert
    assertTrue(actualContents instanceof OrderedListImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Test ListFrame {@link ListFrame#getContents()}.
   *
   * <ul>
   *   <li>Given {@link ListFrame#ListFrame(String)} with {@code Q Name}.
   *   <li>Then return {@link UnorderedListImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ListFrame#getContents()}
   */
  @Test
  @DisplayName(
      "Test ListFrame getContents(); given ListFrame(String) with 'Q Name'; then return UnorderedListImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderedContent ListFrame.getContents()"})
  void testListFrameGetContents_givenListFrameWithQName_thenReturnUnorderedListImpl() {
    // Arrange and Act
    OrderedContent<?> actualContents = new ListFrame("Q Name").getContents();

    // Assert
    assertTrue(actualContents instanceof UnorderedListImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Test ListFrame {@link ListFrame#hasContent()}.
   *
   * <p>Method under test: {@link ListFrame#hasContent()}
   */
  @Test
  @DisplayName("Test ListFrame hasContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ListFrame.hasContent()"})
  void testListFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse(new ListFrame("Q Name").hasContent());
  }

  /**
   * Test ListFrame {@link ListFrame#ListFrame(String)}.
   *
   * <p>Method under test: {@link ListFrame#ListFrame(String)}
   */
  @Test
  @DisplayName("Test ListFrame new ListFrame(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListFrame.<init>(String)"})
  void testListFrameNewListFrame() {
    // Arrange and Act
    ListFrame actualListFrame = new ListFrame("Q Name");

    // Assert
    OrderedContent<?> contents = actualListFrame.getContents();
    assertTrue(contents instanceof UnorderedListImpl);
    assertEquals("", contents.getText());
    assertEquals("Q Name", actualListFrame.qName);
    assertNull(actualListFrame.parent);
    assertEquals(0, contents.size());
    assertFalse(contents.iterator().hasNext());
    assertFalse(actualListFrame.hasContent());
    assertTrue(contents.getContents().isEmpty());
  }

  /**
   * Test ListFrame {@link ListFrame#push(Content)}.
   *
   * <ul>
   *   <li>Then {@link ListFrame#ListFrame(String)} with {@code Q Name} Contents {@link
   *       UnorderedListImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ListFrame#push(Content)}
   */
  @Test
  @DisplayName(
      "Test ListFrame push(Content); then ListFrame(String) with 'Q Name' Contents UnorderedListImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListFrame.push(Content)"})
  void testListFramePush_thenListFrameWithQNameContentsUnorderedListImpl() {
    // Arrange
    ListFrame listFrame = new ListFrame("Q Name");
    MessageImpl c = new MessageImpl(new ArrayList<>());

    // Act
    listFrame.push(c);

    // Assert
    OrderedContent<?> contents = listFrame.getContents();
    assertTrue(contents instanceof UnorderedListImpl);
    List<?> contents2 = contents.getContents();
    assertEquals(1, contents2.size());
    assertSame(c, contents2.get(0));
    Iterator<?> iteratorResult = contents.iterator();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(c, actualNextResult);
    assertEquals(1, contents.size());
    assertTrue(listFrame.hasContent());
  }

  /**
   * Test ListFrame {@link ListFrame#push(Content)}.
   *
   * <ul>
   *   <li>When {@link Content}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ListFrame#push(Content)}
   */
  @Test
  @DisplayName(
      "Test ListFrame push(Content); when Content; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListFrame.push(Content)"})
  void testListFramePush_whenContent_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new ListFrame("Q Name").push(mock(Content.class)));
  }

  /**
   * Test MessageFrame {@link MessageFrame#getContents()}.
   *
   * <p>Method under test: {@link MessageFrame#getContents()}
   */
  @Test
  @DisplayName("Test MessageFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message MessageFrame.getContents()"})
  void testMessageFrameGetContents() {
    // Arrange and Act
    Message actualContents = new MessageFrame("Tag").getContents();

    // Assert
    assertTrue(actualContents instanceof MessageImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Test MessageFrame {@link MessageFrame#MessageFrame(String)}.
   *
   * <p>Method under test: {@link MessageFrame#MessageFrame(String)}
   */
  @Test
  @DisplayName("Test MessageFrame new MessageFrame(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageFrame.<init>(String)"})
  void testMessageFrameNewMessageFrame() {
    // Arrange and Act
    MessageFrame actualMessageFrame = new MessageFrame("Tag");

    // Assert
    assertEquals("", actualMessageFrame.buf.toString());
    assertTrue(actualMessageFrame.stuffSoFar.isEmpty());
  }

  /**
   * Test ParagraphFrame {@link ParagraphFrame#getContents()}.
   *
   * <p>Method under test: {@link ParagraphFrame#getContents()}
   */
  @Test
  @DisplayName("Test ParagraphFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Paragraph ParagraphFrame.getContents()"})
  void testParagraphFrameGetContents() {
    // Arrange and Act
    Paragraph actualContents = new ParagraphFrame("Q Name").getContents();

    // Assert
    assertTrue(actualContents instanceof ParagraphImpl);
    assertEquals("", actualContents.getText());
    assertEquals(0, actualContents.size());
    assertFalse(actualContents.iterator().hasNext());
    assertTrue(actualContents.getContents().isEmpty());
  }

  /**
   * Test ParagraphFrame {@link ParagraphFrame#ParagraphFrame(String)}.
   *
   * <p>Method under test: {@link ParagraphFrame#ParagraphFrame(String)}
   */
  @Test
  @DisplayName("Test ParagraphFrame new ParagraphFrame(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ParagraphFrame.<init>(String)"})
  void testParagraphFrameNewParagraphFrame() {
    // Arrange and Act
    ParagraphFrame actualParagraphFrame = new ParagraphFrame("Q Name");

    // Assert
    assertEquals("", actualParagraphFrame.buf.toString());
    assertTrue(actualParagraphFrame.stuffSoFar.isEmpty());
  }

  /**
   * Test TableFrame {@link TableFrame#getContents()}.
   *
   * <p>Method under test: {@link TableFrame#getContents()}
   */
  @Test
  @DisplayName("Test TableFrame getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Table TableFrame.getContents()"})
  void testTableFrameGetContents() {
    // Arrange and Act
    Table actualContents = new TableFrame("Q Name").getContents();

    // Assert
    assertFalse(actualContents.matches(null));
    assertFalse(actualContents.startsWith(null));
  }

  /**
   * Test TableFrame {@link TableFrame#hasContent()}.
   *
   * <p>Method under test: {@link TableFrame#hasContent()}
   */
  @Test
  @DisplayName("Test TableFrame hasContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TableFrame.hasContent()"})
  void testTableFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse(new TableFrame("Q Name").hasContent());
  }

  /**
   * Test TableFrame {@link TableFrame#newRow()}.
   *
   * <p>Method under test: {@link TableFrame#newRow()}
   */
  @Test
  @DisplayName("Test TableFrame newRow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableFrame.newRow()"})
  void testTableFrameNewRow() {
    // Arrange
    TableFrame tableFrame = new TableFrame("Q Name");

    // Act
    tableFrame.newRow();

    // Assert
    assertTrue(tableFrame.hasContent());
  }

  /**
   * Test TableFrame {@link TableFrame#TableFrame(String)}.
   *
   * <p>Method under test: {@link TableFrame#TableFrame(String)}
   */
  @Test
  @DisplayName("Test TableFrame new TableFrame(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TableFrame.<init>(String)"})
  void testTableFrameNewTableFrame() {
    // Arrange and Act
    TableFrame actualTableFrame = new TableFrame("Q Name");

    // Assert
    assertEquals("Q Name", actualTableFrame.qName);
    assertNull(actualTableFrame.parent);
    assertFalse(actualTableFrame.hasContent());
  }

  /**
   * Test TextRunFrame {@link TextRunFrame#hasContent()}.
   *
   * <p>Method under test: {@link TextRunFrame#hasContent()}
   */
  @Test
  @DisplayName("Test TextRunFrame hasContent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TextRunFrame.hasContent()"})
  void testTextRunFrameHasContent() {
    // Arrange, Act and Assert
    assertFalse(new BlockQuoteFrame("Tag").hasContent());
  }

  /**
   * Test TextRunFrame {@link TextRunFrame#push(Content)} with {@code c}.
   *
   * <p>Method under test: {@link TextRunFrame#push(Content)}
   */
  @Test
  @DisplayName("Test TextRunFrame push(Content) with 'c'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TextRunFrame.push(Content)"})
  void testTextRunFramePushWithC() {
    // Arrange
    BlockQuoteFrame blockQuoteFrame = new BlockQuoteFrame("Tag");
    Content c = mock(Content.class);

    // Act
    blockQuoteFrame.push(c);

    // Assert
    List<Content> contentList = blockQuoteFrame.stuffSoFar;
    assertEquals(1, contentList.size());
    assertSame(c, contentList.get(0));
    BlockQuote contents = blockQuoteFrame.getContents();
    assertTrue(contents instanceof BlockQuoteImpl);
    assertEquals("null", contents.getText());
    Iterator<Content> iteratorResult = contents.iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(c, actualNextResult);
    assertEquals(1, contents.size());
    assertTrue(blockQuoteFrame.hasContent());
  }
}
