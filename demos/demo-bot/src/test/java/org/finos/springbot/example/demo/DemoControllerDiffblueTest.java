package org.finos.springbot.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
import org.finos.springbot.workflow.content.Word;
import org.finos.springbot.workflow.response.MessageResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DemoController.class})
@ExtendWith(SpringExtension.class)
class DemoControllerDiffblueTest {
  @Autowired
  private DemoController demoController;

  /**
   * Test {@link DemoController#missingChatButton(List, Addressable)}.
   * <ul>
   *   <li>Then return Message Contents first Text is {@code Bot echoing - Hello}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoController#missingChatButton(List, Addressable)}
   */
  @Test
  @DisplayName("Test missingChatButton(List, Addressable); then return Message Contents first Text is 'Bot echoing - Hello'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.MessageResponse org.finos.springbot.example.demo.DemoController.missingChatButton(java.util.List, org.finos.springbot.workflow.content.Addressable)"})
  void testMissingChatButton_thenReturnMessageContentsFirstTextIsBotEchoingHello() {
    // Arrange, Act and Assert
    Content message = demoController.missingChatButton(new ArrayList<>(), mock(Addressable.class)).getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Bot echoing - Hello", getResult.getText());
    assertEquals("Bot echoing - Hello", message.getText());
    assertEquals(4, ((ParagraphImpl) getResult).getContents().size());
    assertEquals(4, ((ParagraphImpl) getResult).size());
  }

  /**
   * Test {@link DemoController#missingChatButton(List, Addressable)}.
   * <ul>
   *   <li>Then return Message Contents first Text is {@code Bot echoing - Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoController#missingChatButton(List, Addressable)}
   */
  @Test
  @DisplayName("Test missingChatButton(List, Addressable); then return Message Contents first Text is 'Bot echoing - Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.MessageResponse org.finos.springbot.example.demo.DemoController.missingChatButton(java.util.List, org.finos.springbot.workflow.content.Addressable)"})
  void testMissingChatButton_thenReturnMessageContentsFirstTextIsBotEchoingText() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");

    ArrayList<Word> msg = new ArrayList<>();
    msg.add(word);

    // Act
    MessageResponse actualMissingChatButtonResult = demoController.missingChatButton(msg, mock(Addressable.class));

    // Assert
    verify(word).getText();
    Content message = actualMissingChatButtonResult.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Bot echoing - Text", getResult.getText());
    assertEquals("Bot echoing - Text", message.getText());
    assertEquals(4, ((ParagraphImpl) getResult).getContents().size());
    assertEquals(4, ((ParagraphImpl) getResult).size());
  }

  /**
   * Test {@link DemoController#missingChatButton(List, Addressable)}.
   * <ul>
   *   <li>Then return Message Contents first Text is {@code Bot echoing - Text Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoController#missingChatButton(List, Addressable)}
   */
  @Test
  @DisplayName("Test missingChatButton(List, Addressable); then return Message Contents first Text is 'Bot echoing - Text Text'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.finos.springbot.workflow.response.MessageResponse org.finos.springbot.example.demo.DemoController.missingChatButton(java.util.List, org.finos.springbot.workflow.content.Addressable)"})
  void testMissingChatButton_thenReturnMessageContentsFirstTextIsBotEchoingTextText() {
    // Arrange
    Word word = mock(Word.class);
    when(word.getText()).thenReturn("Text");
    Word word2 = mock(Word.class);
    when(word2.getText()).thenReturn("Text");

    ArrayList<Word> msg = new ArrayList<>();
    msg.add(word2);
    msg.add(word);

    // Act
    MessageResponse actualMissingChatButtonResult = demoController.missingChatButton(msg, mock(Addressable.class));

    // Assert
    verify(word2).getText();
    verify(word).getText();
    Content message = actualMissingChatButtonResult.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Bot echoing - Text Text", getResult.getText());
    assertEquals("Bot echoing - Text Text", message.getText());
    assertEquals(5, ((ParagraphImpl) getResult).getContents().size());
    assertEquals(5, ((ParagraphImpl) getResult).size());
  }
}
