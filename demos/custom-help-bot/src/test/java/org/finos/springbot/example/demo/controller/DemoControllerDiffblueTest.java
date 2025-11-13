package org.finos.springbot.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.finos.springbot.workflow.content.Message;
import org.finos.springbot.workflow.content.Message.MessageImpl;
import org.finos.springbot.workflow.content.Paragraph;
import org.finos.springbot.workflow.content.Paragraph.ParagraphImpl;
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
  @Autowired private DemoController demoController;

  /**
   * Test {@link DemoController#pingTest1(Addressable)}.
   *
   * <p>Method under test: {@link DemoController#pingTest1(Addressable)}
   */
  @Test
  @DisplayName("Test pingTest1(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageResponse DemoController.pingTest1(Addressable)"})
  void testPingTest1() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    MessageResponse actualPingTest1Result = demoController.pingTest1(a);

    // Assert
    assertSame(a, actualPingTest1Result.getAddress());
    assertTrue(actualPingTest1Result.getData().isEmpty());
    Content message = actualPingTest1Result.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Ping!", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualPingTest1Result.getTemplateName());
  }

  /**
   * Test {@link DemoController#pingTest2(Addressable)}.
   *
   * <p>Method under test: {@link DemoController#pingTest2(Addressable)}
   */
  @Test
  @DisplayName("Test pingTest2(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageResponse DemoController.pingTest2(Addressable)"})
  void testPingTest2() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    MessageResponse actualPingTest2Result = demoController.pingTest2(a);

    // Assert
    assertSame(a, actualPingTest2Result.getAddress());
    assertTrue(actualPingTest2Result.getData().isEmpty());
    Content message = actualPingTest2Result.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("Pong!", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualPingTest2Result.getTemplateName());
  }

  /**
   * Test {@link DemoController#pingTest3(Addressable)}.
   *
   * <p>Method under test: {@link DemoController#pingTest3(Addressable)}
   */
  @Test
  @DisplayName("Test pingTest3(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageResponse DemoController.pingTest3(Addressable)"})
  void testPingTest3() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    MessageResponse actualPingTest3Result = demoController.pingTest3(a);

    // Assert
    assertSame(a, actualPingTest3Result.getAddress());
    assertTrue(actualPingTest3Result.getData().isEmpty());
    Content message = actualPingTest3Result.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("You asked for a thing", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualPingTest3Result.getTemplateName());
  }

  /**
   * Test {@link DemoController#pingTest4(Addressable)}.
   *
   * <p>Method under test: {@link DemoController#pingTest4(Addressable)}
   */
  @Test
  @DisplayName("Test pingTest4(Addressable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageResponse DemoController.pingTest4(Addressable)"})
  void testPingTest4() {
    // Arrange
    Addressable a = mock(Addressable.class);

    // Act
    MessageResponse actualPingTest4Result = demoController.pingTest4(a);

    // Assert
    assertSame(a, actualPingTest4Result.getAddress());
    assertTrue(actualPingTest4Result.getData().isEmpty());
    Content message = actualPingTest4Result.getMessage();
    assertTrue(message instanceof MessageImpl);
    List<Content> contents = ((MessageImpl) message).getContents();
    assertEquals(1, contents.size());
    Content getResult = contents.get(0);
    assertTrue(getResult instanceof ParagraphImpl);
    assertEquals("You asked for a bling", message.getText());
    Iterator<Content> iteratorResult = ((MessageImpl) message).iterator();
    Content actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(getResult, actualNextResult);
    assertEquals(1, ((MessageImpl) message).size());
    assertNull(actualPingTest4Result.getTemplateName());
  }
}
