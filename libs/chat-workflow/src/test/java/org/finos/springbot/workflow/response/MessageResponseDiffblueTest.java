package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.Test;

class MessageResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MessageResponse#MessageResponse(Addressable, Map, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(null, data, m, "Template Name");
    String actualToStringResult = actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertTrue(actualMessage instanceof CodeBlock.CodeBlockImpl);
    assertEquals("MessageResponse [m=CodeBlock [foo], getData()={}, getTemplate()=Template Name, getAddress()=null]",
        actualToStringResult);
    assertEquals("Template Name", actualMessageResponse.getTemplateName());
    assertNull(actualMessageResponse.getAddress());
    Map<String, Object> data2 = actualMessageResponse.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(m, actualMessage);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(null, m);
    String actualToStringResult = actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertTrue(actualMessage instanceof CodeBlock.CodeBlockImpl);
    assertEquals("MessageResponse [m=CodeBlock [foo], getData()={}, getTemplate()=null, getAddress()=null]",
        actualToStringResult);
    assertNull(actualMessageResponse.getTemplateName());
    assertNull(actualMessageResponse.getAddress());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(m, actualMessage);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(null, m, "Template");
    String actualToStringResult = actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertTrue(actualMessage instanceof CodeBlock.CodeBlockImpl);
    assertEquals("MessageResponse [m=CodeBlock [foo], getData()={}, getTemplate()=Template, getAddress()=null]",
        actualToStringResult);
    assertEquals("Template", actualMessageResponse.getTemplateName());
    assertNull(actualMessageResponse.getAddress());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(m, actualMessage);
  }
}
