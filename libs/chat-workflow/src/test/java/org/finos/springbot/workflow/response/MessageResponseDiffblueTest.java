package org.finos.springbot.workflow.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.finos.springbot.workflow.content.Addressable;
import org.finos.springbot.workflow.content.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MessageResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Addressable}.</li>
   *   <li>Then return TemplateName is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Addressable; then return TemplateName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "org.finos.springbot.workflow.content.Content org.finos.springbot.workflow.response.MessageResponse.getMessage()",
      "java.lang.String org.finos.springbot.workflow.response.MessageResponse.toString()"})
  void testGettersAndSetters_whenAddressable_thenReturnTemplateNameIsNull() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, m);
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertNull(actualMessageResponse.getTemplateName());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code Template Name}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Map, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap(); then return 'Template Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "org.finos.springbot.workflow.content.Content org.finos.springbot.workflow.response.MessageResponse.getMessage()",
      "java.lang.String org.finos.springbot.workflow.response.MessageResponse.toString()"})
  void testGettersAndSetters_whenHashMap_thenReturnTemplateName() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    HashMap<String, Object> data = new HashMap<>();
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, data, m, "Template Name");
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertEquals("Template Name", actualMessageResponse.getTemplateName());
    Map<String, Object> data2 = actualMessageResponse.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
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
   *   <li>{@link MessageResponse#MessageResponse(Addressable, Content, String)}
   *   <li>{@link MessageResponse#toString()}
   *   <li>{@link MessageResponse#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Template'; then return TemplateName is 'Template'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, java.util.Map, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content)",
      "void org.finos.springbot.workflow.response.MessageResponse.<init>(org.finos.springbot.workflow.content.Addressable, org.finos.springbot.workflow.content.Content, java.lang.String)",
      "org.finos.springbot.workflow.content.Content org.finos.springbot.workflow.response.MessageResponse.getMessage()",
      "java.lang.String org.finos.springbot.workflow.response.MessageResponse.toString()"})
  void testGettersAndSetters_whenTemplate_thenReturnTemplateNameIsTemplate() {
    // Arrange
    Addressable stream = mock(Addressable.class);
    Content m = mock(Content.class);

    // Act
    MessageResponse actualMessageResponse = new MessageResponse(stream, m, "Template");
    actualMessageResponse.toString();
    Content actualMessage = actualMessageResponse.getMessage();

    // Assert
    assertEquals("Template", actualMessageResponse.getTemplateName());
    assertTrue(actualMessageResponse.getData().isEmpty());
    assertSame(stream, actualMessageResponse.getAddress());
    assertSame(m, actualMessage);
  }
}
