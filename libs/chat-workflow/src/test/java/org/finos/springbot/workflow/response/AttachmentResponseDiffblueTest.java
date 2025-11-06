package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.CodeBlock;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.Test;

class AttachmentResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AttachmentResponse#AttachmentResponse(Addressable, Map, Content, String, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, Object> data = new HashMap<>();
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(null, data, m, "Template", attachment, "Name",
        "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();
    String actualName = actualAttachmentResponse.getName();

    // Assert
    Content message = actualAttachmentResponse.getMessage();
    assertTrue(message instanceof CodeBlock.CodeBlockImpl);
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualName);
    assertEquals("Template", actualAttachmentResponse.getTemplateName());
    assertNull(actualAttachmentResponse.getAddress());
    Map<String, Object> data2 = actualAttachmentResponse.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(m, message);
    assertSame(attachment, actualAttachment);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AttachmentResponse#AttachmentResponse(Addressable, Content, String, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(null, m, "Template", attachment, "Name",
        "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();
    String actualName = actualAttachmentResponse.getName();

    // Assert
    Content message = actualAttachmentResponse.getMessage();
    assertTrue(message instanceof CodeBlock.CodeBlockImpl);
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualName);
    assertEquals("Template", actualAttachmentResponse.getTemplateName());
    assertNull(actualAttachmentResponse.getAddress());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(m, message);
    assertSame(attachment, actualAttachment);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AttachmentResponse#AttachmentResponse(Addressable, Content, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() throws UnsupportedEncodingException {
    // Arrange
    CodeBlock.CodeBlockImpl m = new CodeBlock.CodeBlockImpl("foo");
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(null, m, attachment, "Name", "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();
    String actualName = actualAttachmentResponse.getName();

    // Assert
    Content message = actualAttachmentResponse.getMessage();
    assertTrue(message instanceof CodeBlock.CodeBlockImpl);
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualName);
    assertNull(actualAttachmentResponse.getTemplateName());
    assertNull(actualAttachmentResponse.getAddress());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(m, message);
    assertSame(attachment, actualAttachment);
  }

  /**
   * Method under test:
   * {@link AttachmentResponse#AttachmentResponse(Addressable, byte[], String, String)}
   */
  @Test
  void testNewAttachmentResponse() throws UnsupportedEncodingException {
    // Arrange
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(null, attachment, "Name", "Extension");

    // Assert
    assertEquals("Extension", actualAttachmentResponse.getExtension());
    assertEquals("Name", actualAttachmentResponse.getName());
    assertNull(actualAttachmentResponse.getTemplateName());
    assertNull(actualAttachmentResponse.getAddress());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(attachment, actualAttachmentResponse.getAttachment());
  }
}
