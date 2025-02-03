package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttachmentResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   *   <li>Then return TemplateName is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttachmentResponse#AttachmentResponse(Addressable, Content, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Addressable; then return TemplateName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, byte[], java.lang.String, java.lang.String)",
      "byte[] org.finos.springbot.workflow.response.AttachmentResponse.getAttachment()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getExtension()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getName()"})
  void testGettersAndSetters_whenAddressable_thenReturnTemplateNameIsNull() throws UnsupportedEncodingException {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(stream, m, attachment, "Name", "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();

    // Assert
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualAttachmentResponse.getName());
    assertNull(actualAttachmentResponse.getTemplateName());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(attachment, actualAttachment);
    assertSame(stream, actualAttachmentResponse.getAddress());
    assertSame(m, actualAttachmentResponse.getMessage());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAttachment);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Data is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttachmentResponse#AttachmentResponse(Addressable, Map, Content, String, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap(); then return Data is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, byte[], java.lang.String, java.lang.String)",
      "byte[] org.finos.springbot.workflow.response.AttachmentResponse.getAttachment()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getExtension()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getName()"})
  void testGettersAndSetters_whenHashMap_thenReturnDataIsHashMap() throws UnsupportedEncodingException {
    // Arrange
    Addressable stream = mock(Addressable.class);
    HashMap<String, Object> data = new HashMap<>();
    Content m = mock(Content.class);
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(stream, data, m, "Template", attachment,
        "Name", "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();

    // Assert
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualAttachmentResponse.getName());
    assertEquals("Template", actualAttachmentResponse.getTemplateName());
    Map<String, Object> data2 = actualAttachmentResponse.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(attachment, actualAttachment);
    assertSame(stream, actualAttachmentResponse.getAddress());
    assertSame(m, actualAttachmentResponse.getMessage());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAttachment);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Template}.</li>
   *   <li>Then return TemplateName is {@code Template}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttachmentResponse#AttachmentResponse(Addressable, Content, String, byte[], String, String)}
   *   <li>{@link AttachmentResponse#getAttachment()}
   *   <li>{@link AttachmentResponse#getExtension()}
   *   <li>{@link AttachmentResponse#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Template'; then return TemplateName is 'Template'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String, byte[], java.lang.String, java.lang.String)",
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, byte[], java.lang.String, java.lang.String)",
      "byte[] org.finos.springbot.workflow.response.AttachmentResponse.getAttachment()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getExtension()",
      "java.lang.String org.finos.springbot.workflow.response.AttachmentResponse.getName()"})
  void testGettersAndSetters_whenTemplate_thenReturnTemplateNameIsTemplate() throws UnsupportedEncodingException {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);
    byte[] attachment = "AXAXAXAX".getBytes("UTF-8");

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(stream, m, "Template", attachment, "Name",
        "Extension");
    byte[] actualAttachment = actualAttachmentResponse.getAttachment();
    String actualExtension = actualAttachmentResponse.getExtension();

    // Assert
    assertEquals("Extension", actualExtension);
    assertEquals("Name", actualAttachmentResponse.getName());
    assertEquals("Template", actualAttachmentResponse.getTemplateName());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(attachment, actualAttachment);
    assertSame(stream, actualAttachmentResponse.getAddress());
    assertSame(m, actualAttachmentResponse.getMessage());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualAttachment);
  }

  /**
   * Test {@link AttachmentResponse#AttachmentResponse(Addressable, byte[], String, String)}.
   * <p>
   * Method under test: {@link AttachmentResponse#AttachmentResponse(Addressable, byte[], String, String)}
   */
  @Test
  @DisplayName("Test new AttachmentResponse(Addressable, byte[], String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.AttachmentResponse.<init>(org.finos.springbot.workflow.content.Addressable, byte[], java.lang.String, java.lang.String)"})
  void testNewAttachmentResponse() throws UnsupportedEncodingException {
    // Arrange
    Addressable stream = mock(Addressable.class);

    // Act
    AttachmentResponse actualAttachmentResponse = new AttachmentResponse(stream, "AXAXAXAX".getBytes("UTF-8"), "Name",
        "Extension");

    // Assert
    assertEquals("Extension", actualAttachmentResponse.getExtension());
    assertEquals("Name", actualAttachmentResponse.getName());
    assertNull(actualAttachmentResponse.getTemplateName());
    assertTrue(actualAttachmentResponse.getData().isEmpty());
    assertSame(stream, actualAttachmentResponse.getAddress());
    byte[] expectedAttachment = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedAttachment, actualAttachmentResponse.getAttachment());
  }
}
