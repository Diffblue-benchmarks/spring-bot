package org.finos.springbot.tests.content;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Heading;
import org.finos.springbot.workflow.content.Heading.HeadingImpl;
import org.finos.springbot.workflow.content.Link;
import org.finos.springbot.workflow.content.Link.LinkImpl;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.OrderedList;
import org.finos.springbot.workflow.content.OrderedList.OrderedListImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.finos.springbot.workflow.content.Table;
import org.finos.springbot.workflow.content.Table.TableImpl;
import org.finos.springbot.workflow.content.UnorderedList;
import org.finos.springbot.workflow.content.UnorderedList.UnorderedListImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractContentTestDiffblueTest {
  /**
   * Test {@link AbstractContentTest#createMessage()}.
   *
   * <p>Method under test: {@link AbstractContentTest#createMessage()}
   */
  @Test
  @DisplayName("Test createMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Message AbstractContentTest.createMessage()"})
  void testCreateMessage() {
    // Arrange and Act
    Message actualCreateMessageResult = AbstractContentTest.createMessage();

    // Assert
    assertTrue(actualCreateMessageResult instanceof MessageImpl);
    List<Content> contents = actualCreateMessageResult.getContents();
    assertEquals(11, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof HeadingImpl);
    Content getResult2 = contents.get(1);
    assertTrue(getResult2 instanceof ParagraphImpl);
    Content getResult3 = contents.get(2);
    assertTrue(getResult3 instanceof ParagraphImpl);
    assertTrue(contents.get(8) instanceof LinkImpl);
    assertTrue(contents.get(9) instanceof HeadingImpl);
    assertTrue(contents.get(10) instanceof TableImpl);
    assertEquals(
        "Heading 1 some words Some other words item a item b item 1 item 2 Something wicked this way comes"
            + " <some>code</some> This is a link Heading 2  Heading 1 Heading 2 value 1 value 2 value 3 value 4 value"
            + " 5 value 6",
        actualCreateMessageResult.getText());
    Iterator<Content> iteratorResult = actualCreateMessageResult.iterator();
    assertTrue(iteratorResult.hasNext());
    assertSame(getResult, iteratorResult.next());
    assertSame(getResult2, iteratorResult.next());
    assertSame(getResult3, iteratorResult.next());
    assertTrue(iteratorResult.next() instanceof UnorderedListImpl);
    assertTrue(iteratorResult.next() instanceof OrderedListImpl);
    assertEquals(11, actualCreateMessageResult.size());
  }
}
